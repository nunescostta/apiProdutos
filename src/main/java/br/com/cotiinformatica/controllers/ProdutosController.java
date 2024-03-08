package br.com.cotiinformatica.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.cotiinformatica.dtos.ProdutosPostDto;
import br.com.cotiinformatica.dtos.ProdutosPutDto;
import br.com.cotiinformatica.entities.Fornecedor;
import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.repositories.FornecedorRepository;
import br.com.cotiinformatica.repositories.ProdutoRepository;

@RestController
@RequestMapping("api/produtos")

public class ProdutosController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@PostMapping
	public ResponseEntity<String> post(@RequestBody ProdutosPostDto dto) {
		try {

			// capturar dados do produto
			Produto produto = new Produto();

			produto.setNome(dto.getNome());
			produto.setPreco(dto.getPreco());
			produto.setQuantidade(dto.getQuantidade());

			// consultar fornecedor no banco de dados pelo ID
			Fornecedor fornecedor = fornecedorRepository.findById(dto.getFornecedor()).get();

			// assocando o fornecedor ao produto
			produto.setFornecedor(fornecedor);

			// salvar no banco de dados
			produtoRepository.save(produto);

			// retornando um http 201 (CREATED)
			return ResponseEntity.status(201).body("PRODUTO CADASTRADO COM SUCESSO");

		} catch (Exception e) {

			// retornando um http 500 (INTERNAL SERVER ERROR)
			return ResponseEntity.status(500).body(e.getMessage());
		}

	}

	@PutMapping
	public ResponseEntity<String> put(@RequestBody ProdutosPutDto dto) {
		try {
			// buscar produto no banco de dados atraves do id
			Produto produto = produtoRepository.findById(dto.getId()).get();

			produto.setNome(dto.getNome());
			produto.setPreco(dto.getPreco());
			produto.setQuantidade(dto.getQuantidade());

			// consultando p fornecedor no banco de dados
			Fornecedor fornecedor = fornecedorRepository.findById(dto.getFornecedor()).get();

			// associando o produto no banco de dados
			produto.setFornecedor(fornecedor);

			// atualizar o produto no banco de dados
			produtoRepository.save(produto);

			// http 200 (ok)
			return ResponseEntity.status(200).body("PRODUTO ATUALIZADO COM SUCESSO");

		} catch (Exception e) {

			// HTTP 500 (INTERNAL SERVER ERROR)
			return ResponseEntity.status(500).body(e.getMessage());
		}

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			// pesquisar produto no banco de dados atravez do id
			Produto produto = produtoRepository.findById(id).get();

			// excluir produto
			produtoRepository.delete(produto);

			// http200 (ok)
			return ResponseEntity.status(200).body("PRODUTO EXCLUIDO COM SUCESSO");

		} catch (Exception e) {

			// HTTP 500 (INTERNAL SERVER ERROR)
			return ResponseEntity.status(500).body(e.getMessage());
		}

	}

	@GetMapping
	public List<Produto> get() {
		// Consultar todos os produtos no banco de dados
		return produtoRepository.findAll();

	}

}
