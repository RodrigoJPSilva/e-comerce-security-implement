package com.example.ecomerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Pagamento {
//    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;
    private LocalDate moment;

    @OneToOne
    @MapsId
    private Pedido pedido;
}


