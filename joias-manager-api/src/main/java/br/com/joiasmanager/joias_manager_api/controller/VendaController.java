package br.com.joiasmanager.joias_manager_api.controller;

import br.com.joias_manager_api.model.Venda;
import br.com.joias_manager_api.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    @Autowired
    private VendaService vendaService;

    // Criar uma nova venda
    @PostMapping
    public ResponseEntity<Venda> criarVenda(@RequestBody Venda venda) {
        Venda novaVenda = vendaService.criarVenda(venda);
        return new ResponseEntity<>(novaVenda, HttpStatus.CREATED);
    }

    // Obter todas as vendas
    @GetMapping
    public ResponseEntity<List<Venda>> listarVendas() {
        List<Venda> vendas = vendaService.listarVendas();
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    // Obter venda por ID
    @GetMapping("/{id}")
    public ResponseEntity<Venda> obterVenda(@PathVariable Long id) {
        Optional<Venda> venda = vendaService.obterVendaPorId(id);
        return venda.map(v -> new ResponseEntity<>(v, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Atualizar uma venda
    public ResponseEntity<Venda> atualizarVenda(@PathVariable Long id, @RequestBody Venda venda) {
        Venda vendaAtualizada = vendaService.atualizarVenda(id, venda);
        return vendaAtualizada != null ?
                new ResponseEntity<>(vendaAtualizada, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Deletar uma venda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVenda(@PathVariable Long id) {
        vendaService.deletarVenda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

