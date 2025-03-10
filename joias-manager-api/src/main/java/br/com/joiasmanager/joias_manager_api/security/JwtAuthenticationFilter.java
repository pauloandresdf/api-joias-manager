package br.com.joiasmanager.joias_manager_api.security;

import br.com.joiasmanager.joias_manager_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, javax.servlet.http.HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = obterTokenDaRequisicao(request);

        if (token != null && !jwtUtils.isTokenExpirado(token)) {
            String email = jwtUtils.obterEmailDoToken(token);
            // Aqui você pode carregar o usuário e adicionar ao contexto
            SecurityContextHolder.getContext().setAuthentication(new UsuarioAuthenticationToken(email));
        }

        filterChain.doFilter(request, response);
    }

    private String obterTokenDaRequisicao(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        return null;
    }
}
