package br.com.cotiinformatica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cotiinformatica.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

}
