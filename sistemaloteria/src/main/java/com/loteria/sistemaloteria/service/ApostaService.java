package com.loteria.sistemaloteria.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class ApostaService {

	private static final int NUMERO_MINIMO_POSSIVEL_APOSTA = 1;
	private static final int NUMERO_MAXIMO_POSSIVEL_APOSTA = 60;
	private static final int QUANTIDADE_NUMEROS_APOSTA = 10;
	
	private List<Integer> numerosAposta = new ArrayList<>();
	
	public List<Integer>gerarApostaAleatoria(){
	
		
		
		Collections.shuffle(numerosAposta);
		return Collections.unmodifiableList(numerosAposta.stream().limit(QUANTIDADE_NUMEROS_APOSTA).collect(Collectors.toList()));
		
	}
	
	@PostConstruct //serve para chamar o metodo na construcao do objeto
	private void inicializarApostaComNumerosPadroes() {
		for(int i= NUMERO_MINIMO_POSSIVEL_APOSTA; i <= NUMERO_MAXIMO_POSSIVEL_APOSTA; i++) {
			numerosAposta.add(i);
			
		}
	}
	
	
	
}

