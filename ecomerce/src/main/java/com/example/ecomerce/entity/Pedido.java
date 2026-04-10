package com.example.ecomerce.entity;

import com.example.ecomerce.enums.StatusDoPedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDate momento;
    private StatusDoPedido status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private  Pagamento pagamento;
}
