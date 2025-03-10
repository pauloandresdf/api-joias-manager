package br.com.joias_manager_api.service;

import br.com.joias_manager_api.model.Joia;
import br.com.joias_manager_api.repository.JoiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoiaService {

    @Autowired
    private JoiaRepository joiaRepository;

    // Criar uma nova joia
    public Joia criarJoia(Joia joia) {
        return joiaRepository.save(joia);
    }

    // Listar todas as joias
    public List<Joia> listarJoias() {
        return joiaRepository.findAll();
    }

    // Obter joia por ID
    public Joia obterJoiaPorId(Long id) {
        Optional<Joia> joia = joiaRepository.findById(id);
        return joia.orElse(null); // Retorna null caso não encontre a joia
    }

    // Atualizar uma joia existente
    public Joia atualizarJoia(Long id, Joia joia) {
        if (joiaRepository.existsById(id)) {
            joia.setId(id);
            return joiaRepository.save(joia);
        }
        return null; // Retorna null se a joia não existir
    }

    // Deletar uma joia
    public void deletarJoia(Long id) {
        joiaRepository.deleteById(id);
    }
}
