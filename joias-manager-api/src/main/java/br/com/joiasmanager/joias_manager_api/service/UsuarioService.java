package br.com.joias_manager_api.service;

import br.com.joias_manager_api.model.Usuario;
import br.com.joias_manager_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario cadastrarUsuario(Usuario usuario) {
        // Criptografando a senha do usuário
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        // Definindo o perfil padrão de "Vendedor" (pode ser alterado conforme necessidade)
        usuario.setRoles(Collections.singleton("ROLE_VENDEDOR"));
        return usuarioRepository.save(usuario);
    }

    public Usuario autenticarUsuario(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (passwordEncoder.matches(senha, usuario.getSenha())) {
            return usuario;
        } else {
            throw new RuntimeException("Senha incorreta");
        }
    }
}
