package com.eoldemo.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthService {
    private final UserDetailsService userDetailsService;

    public AuthService(UserDetailsService uds) {
        this.userDetailsService = uds;
    }

    public boolean login(String username, String password) {
        try {
            UserDetails ud = userDetailsService.loadUserByUsername(username);
            if (ud != null && ud.getPassword() != null) {
                // For demo we accept plain or {noop} passwords from the in-memory store
                if (ud.getPassword().equals(password) || ud.getPassword().equals("{noop}" + password)) {
                    UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(ud, null, ud.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    return true;
                }
            }
        } catch (Exception e) {
            // ignore for demo; log in production
        }
        return false;
    }

    public void logout() {
        SecurityContextHolder.clearContext();
    }
}
