package br.com.cotiinformatica.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "fornecedor")

public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "razaosocial", length = 100, nullable = false)
	private String razaoSocial;

	@Column(name = "cnpj", length = 20, nullable = false)
	private String cnpj;

	@JsonIgnore // este campo não sera mostrado na consulta da API
	@OneToMany(mappedBy = "fornecedor") // um fornecedor para muitos produtos
	private List<Produto> produtos;

}