package ForoHub.Blog.Config.Security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import ForoHub.Blog.Repository.RegisterRepository;
import ForoHub.Blog.Services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RegisterRepository registerRepository;

    @Override
    protected void doFilterInternal(@SuppressWarnings("null") HttpServletRequest request, @SuppressWarnings("null") HttpServletResponse response, @SuppressWarnings("null") FilterChain filterChain)
            throws ServletException, IOException {

        var token = request.getHeader("Authorization");

        if (token != null) {
            System.out.println("Not Null");

            token = token.replace("Bearer ", "");
            System.out.println(token);

            System.out.println(tokenService.getSubject(token));
            var subject = tokenService.getSubject(token);

            if (subject != null) {

                var user = registerRepository.findByEmail(subject);

                var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(auth);

            }
        }

        filterChain.doFilter(request, response);

    }
}

