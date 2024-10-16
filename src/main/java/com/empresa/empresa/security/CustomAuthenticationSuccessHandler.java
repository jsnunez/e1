package com.empresa.empresa.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {



    @Override
    public void onAuthenticationSuccess(jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response, Authentication authentication)
            throws IOException, jakarta.servlet.ServletException {
                String redirectUrl = "/home"; // Default URL

                // Determine redirect URL based on user roles
                if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                    redirectUrl = "/admin/dashboard.html"; // Admin HTML page
                } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_DEVELOPER"))) {
                    redirectUrl = "/developer/home.html"; // Developer HTML page
                } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_CLIENTE"))) {
                    redirectUrl = "/registrarcliente"; // Cliente HTML page
                } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_JEFEBODEGA"))) {
                    redirectUrl = "/jefebodega/home.html"; // Jefe Bodega HTML page
                } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_JEFERECUROSHUMANOS"))) {
                    redirectUrl = "/registrarempleado"; // Jefe Recursos Humanos HTML page
                } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_JEFEMARKETING"))) {
                    redirectUrl = "/jefemarketing/home.html"; // Jefe Marketing HTML page
                } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_JEFECOMPRA"))) {
                    redirectUrl = "/jefec compra/home.html"; // Jefe Compra HTML page
                } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_JEFEINVENTARIO"))) {
                    redirectUrl = "/jefeinventario/home.html"; // Jefe Inventario HTML page
                } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_PROFESIONALSERVICIO"))) {
                    redirectUrl = "/profesionalservicio/home.html"; // Profesional Servicio HTML page
                } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_JEFESISTEMAS"))) {
                    redirectUrl = "/jefesistemas/home.html"; // Jefe Sistemas HTML page
                }
                response.sendRedirect(redirectUrl);}
}
