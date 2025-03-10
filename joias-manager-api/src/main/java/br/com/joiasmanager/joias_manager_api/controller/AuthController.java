package br.com.joiasmanager.joias_manager_api.controller;

import br.com.joiasmanager.joias_manager_api.model.Usuario;
import br.com.joiasmanager.joias_manager_api.security.JwtUtils;
import br.com.joiasmanager.joias_manager_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtils jwtUtils;

    // Cadastro de novo usuário
    @PostMapping("/register")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
        Usuario usuarioRegistrado = usuarioService.registrarUsuario(usuario);
        return new ResponseEntity<>(usuarioRegistrado, HttpStatus.CREATED);
    }

    // Login e gerar token JWT
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioAutenticado = usuarioService.autenticar(usuario.getEmail(), usuario.getSenha());
            String token = jwtUtils.gerarToken(usuarioAutenticado);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
