package br.com.joiasmanager.joias_manager_api.security;

import br.com.joiasmanager.joias_manager_api.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final String secretKey = "segredo"; // Use uma chave mais forte para produção

    // Gera o JWT
    public String gerarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .claim("perfil", usuario.getPerfil().toString()) // Inclui o perfil no token
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Expira em 1 hora
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    // Valida o JWT e obtém o email
    public String obterEmailDoToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Verifica se o token está expirado
    public boolean isTokenExpirado(String token) {
        Date expiracao = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiracao.before(new Date());
    }
}
