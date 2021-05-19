package com.loteria.sistemaloteria.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loteria.sistemaloteria.model.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
	
	@Query("SELECT p FROM Pessoa p WHERE p.email LIKE LOWER(CONCAT ('%', :email,'%')) ")
	Optional<Pessoa> findByEmail(String email);
}