package com.example.ecomerce.repository;

import com.example.ecomerce.entity.Pedido;
import com.example.ecomerce.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Pedido, UUID> {
    Usuario findByEmail(String email);
}
