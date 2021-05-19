package com.loteria.sistemaloteria.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
 

@Entity 
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL) 
	private List<Aposta> aposta= new ArrayList<Aposta>();
	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Aposta> getAposta() {
		return aposta;
	}

	public void setAposta(List<Aposta> aposta) {
		this.aposta = aposta;
		aposta.forEach(entity -> entity.setPessoa(this));
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", email=" + email + ", aposta=" + aposta + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aposta == null) ? 0 : aposta.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (aposta == null) {
			if (other.aposta != null)
				return false;
		} else if (!aposta.equals(other.aposta))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
