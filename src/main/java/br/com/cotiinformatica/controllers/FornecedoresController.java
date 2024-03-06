package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.entities.Fornecedor;
import br.com.cotiinformatica.repositories.FornecedorRepository;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedoresController {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@GetMapping
	public List<Fornecedor> get() {
		return fornecedorRepository.findAll();
	}

}
