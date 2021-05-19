package com.loteria.sistemaloteria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loteria.sistemaloteria.model.Aposta;
import com.loteria.sistemaloteria.model.Pessoa;
import com.loteria.sistemaloteria.repository.ApostaRepository;
import com.loteria.sistemaloteria.repository.PessoaRepository;
import com.loteria.sistemaloteria.service.ApostaService;
 

@Controller 
@RequestMapping(path="/sistema")
public class MainController {
	
	@Autowired
	PessoaRepository pessoarepository;
	
	@Autowired 
	ApostaRepository apostarepository;
	
	@Autowired
	ApostaService apostaservice;
	
	@PostMapping(path="/pessoa/add")
	public @ResponseBody ResponseEntity<Pessoa> addNewPessoa(@RequestParam String email) {
		

		List<Aposta> lstAaposta =  new ArrayList<Aposta>();//intanciando 
		List<Integer> numerosAposta= new ArrayList<Integer>();
		numerosAposta = apostaservice.gerarApostaAleatoria();
		
		for(Integer item: numerosAposta) { 
			Aposta apt = new Aposta(); 
			apt.setNumero_sorteado(item);
			
			lstAaposta.add(apt);
		}
		
		Pessoa p = new Pessoa(); 
		p.setEmail(email);
		p.setAposta(lstAaposta);
		 
		pessoarepository.save(p);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
	@GetMapping("{email}")
	public ResponseEntity<Optional<Pessoa>> buscaPorEmail(@PathVariable String email){
		Optional<Pessoa> pessoa = pessoarepository.findByEmail(email);
		return ResponseEntity.ok(pessoa);
	}
	
	
	//retorna uma lista com todos os elementos da classe;
	@GetMapping(path="/pessoa/all")
	public @ResponseBody Iterable<Pessoa> getAllPessoa() {
		return pessoarepository.findAll();
	}
	
	
	@GetMapping(path="/aposta/all")
	public @ResponseBody Iterable<Aposta> getAllAposta() {
		return apostarepository.findAll();
	}
	
	
	
	@DeleteMapping(path="/pessoa/remove")
	public @ResponseBody String removeOnePessoa(@RequestParam long id) {
		pessoarepository.deleteById(id);
		return "Excluido com sucesso";
	}
	
	
	
	
	
	

}
