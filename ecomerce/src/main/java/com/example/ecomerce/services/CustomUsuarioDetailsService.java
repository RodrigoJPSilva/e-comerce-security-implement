package com.example.ecomerce.services;

import com.example.ecomerce.entity.Usuario;
import com.example.ecomerce.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUsuarioDetailsService implements UserDetailsService {
    private final UsuarioRepository userRepository;

    public CustomUsuarioDetailsService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = userRepository.findByEmail(email);
        return User.builder()
                .username(user.getEmail())
                .password(user.getSenha())
                .roles(user.getRoles().name().replace("ROLE_",""))
                .build();
    }
}
