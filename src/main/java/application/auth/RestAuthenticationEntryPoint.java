package application.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final AuthenticationException authException) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "401");
        map.put("message", "Email ou mot de passe incorrect");
        response.setStatus(401);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), map);
    }

    public void erreur(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final AuthenticationException authException, String message) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "401");
        map.put("message", message);
        response.setStatus(401);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), map);

    }
}