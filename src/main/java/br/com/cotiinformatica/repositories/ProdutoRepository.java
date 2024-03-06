package br.com.cotiinformatica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cotiinformatica.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
