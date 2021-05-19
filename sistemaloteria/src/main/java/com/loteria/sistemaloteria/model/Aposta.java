package com.loteria.sistemaloteria.model;
 
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
  

@Entity 
public class Aposta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="id_pessoa")
	@JsonIgnore
	private Pessoa pessoa;
	
	//Metodos Setter e Getter omitidos.

	@Column(name="numero_sorteado")
	private Integer numero_sorteado;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getNumero_sorteado() {
		return numero_sorteado;
	}

	public void setNumero_sorteado(Integer numero_sorteado) {
		this.numero_sorteado = numero_sorteado;
	}

	
}
