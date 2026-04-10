package com.example.ecomerce.controller;

import com.example.ecomerce.dto.PedidoDTO;
import com.example.ecomerce.entity.Pedido;
import com.example.ecomerce.services.PedidoService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/Pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<Pedido> insert(@RequestBody Pedido dto) {
        dto = service.insert(dto);

        // Cria a URL com o ID do novo pedido (Boa prática REST)
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // Retorna Status 204 No Content (sucesso sem corpo na resposta)
//    public ResponseEntity<?> create(PedidoDTO dto){
//        service.create(dto);
//        return ResponseEntity.ok("Criado com sucesso !");
//    }
    }
}
