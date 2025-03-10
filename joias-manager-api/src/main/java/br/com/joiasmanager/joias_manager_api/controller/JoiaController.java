package br.com.joias_manager_api.controller;

import br.com.joias_manager_api.model.Joia;
import br.com.joias_manager_api.service.JoiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joias")
public class JoiaController {

    @Autowired
    private JoiaService joiaService;

    // Criar uma nova joia
    @PostMapping
    public ResponseEntity<Joia> criarJoia(@RequestBody Joia joia) {
        Joia novaJoia = joiaService.criarJoia(joia);
        return new ResponseEntity<>(novaJoia, HttpStatus.CREATED);
    }

    // Obter todas as joias
    @GetMapping
    public ResponseEntity<List<Joia>> listarJoias() {
        List<Joia> joias = joiaService.listarJoias();
        return new ResponseEntity<>(joias, HttpStatus.OK);
    }

    // Obter joia por ID
    @GetMapping("/{id}")
    public ResponseEntity<Joia> obterJoia(@PathVariable Long id) {
        Joia joia = joiaService.obterJoiaPorId(id);
        return new ResponseEntity<>(joia, HttpStatus.OK);
    }

    // Atualizar uma joia
    @PutMapping("/{id}")
    public ResponseEntity<Joia> atualizarJoia(@PathVariable Long id, @RequestBody Joia joia) {
        Joia joiaAtualizada = joiaService.atualizarJoia(id, joia);
        return new ResponseEntity<>(joiaAtualizada, HttpStatus.OK);
    }

    // Deletar uma joia
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJoia(@PathVariable Long id) {
        joiaService.deletarJoia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
