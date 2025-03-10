package br.com.joias_manager_api.repository;

import br.com.joias_manager_api.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
