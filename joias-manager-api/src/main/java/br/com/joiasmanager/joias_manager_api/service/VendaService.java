package br.com.joias_manager_api.service;

import br.com.joias_manager_api.model.Venda;
import br.com.joias_manager_api.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda criarVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

    public Venda obterVendaPorId(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public Venda atualizarVenda(Long id, Venda venda) {
        if (vendaRepository.existsById(id)) {
            venda.setId(id);
            return vendaRepository.save(venda);
        }
        return null;
    }

    public void deletarVenda(Long id) {
        vendaRepository.deleteById(id);
    }
}
