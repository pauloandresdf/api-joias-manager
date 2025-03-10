package br.com.joiasmanager.joias_manager_api.controller;

import br.com.joias_manager_api.model.Pedido;
import br.com.joias_manager_api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    // Criar um novo pedido
    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoService.criarPedido(pedido);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }

    // Obter todos os pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    // Obter pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obterPedido(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.obterPedidoPorId(id);
        return pedido.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Atualizar um pedido
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Pedido pedidoAtualizado = pedidoService.atualizarPedido(id, pedido);
        return new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK);
    }

    // Deletar um pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
