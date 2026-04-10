package com.example.ecomerce.services;

import com.example.ecomerce.entity.Pedido;
import com.example.ecomerce.enums.StatusDoPedido;
import com.example.ecomerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;


    public Pedido insert(Pedido pedido) {

        pedido.setMomento(LocalDate.now());

        if (pedido.getStatus() == null) {
            pedido.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO);
        }
        
        return repository.save(pedido);
    }


    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado para o ID: " + id);
        }
        repository.deleteById(id);
    }
}