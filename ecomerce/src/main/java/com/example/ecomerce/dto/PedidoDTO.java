package com.example.ecomerce.dto;

import com.example.ecomerce.entity.Pedido;
import com.example.ecomerce.entity.Usuario;
import com.example.ecomerce.enums.StatusDoPedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
public class PedidoDTO {
    @NotNull(message = "O id está vazio ou com algum erro")
    private UUID id;
    @NotNull(message = "A data não pode estar vazia")
    private LocalDate momento;
    @NotBlank(message = "O status não foi definido")
    private StatusDoPedido status;
    private UUID cliente;

    public PedidoDTO() {}

    public PedidoDTO(Pedido dto) {
        this.id = dto.getId();
        this.momento = dto.getMomento();
        this.status = dto.getStatus();
        this.cliente = dto.getCliente().getId();
    }

}
