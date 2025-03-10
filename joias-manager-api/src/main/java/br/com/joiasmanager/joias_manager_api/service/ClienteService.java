package br.com.joias_manager_api.service;

import br.com.joias_manager_api.model.Cliente;
import br.com.joias_manager_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obterClientePorId(Long id) {
        return clienteRepository.findById(id);
    }


    public Cliente atualizarCliente(Long id, Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            throw new ClienteNotFoundException("Cliente não encontrado com id: " + id);
        }
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }


    public void deletarCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ClienteNotFoundException("Cliente não encontrado com id: " + id);
        }
        clienteRepository.deleteById(id);
    }

}
