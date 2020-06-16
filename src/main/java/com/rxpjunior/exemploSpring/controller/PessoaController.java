package com.rxpjunior.exemploSpring.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rxpjunior.exemploSpring.model.Pessoa;
import com.rxpjunior.exemploSpring.repository.PessoaRepository;

@Controller // Anotação indicando que se trata de um controlador
@RequestMapping(path="/pessoa")
public class PessoaController {
	
	@Autowired //Anotaçao de injeção de dependencia
	private PessoaRepository pessoaRepository;
	
	//Pesquisa pessoa por id
	@RequestMapping(value="/id/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscaPessoaId(@PathVariable Integer id) {
		Optional<Pessoa> p = pessoaRepository.findById(id);
		return ResponseEntity.ok().body(p);
	}
	
	//Pesquisa todas as pessoas cadastradas
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public ResponseEntity<?> buscarTodos() {
		Iterable<Pessoa> lp = pessoaRepository.findAll();
		return ResponseEntity.ok().body(lp);
	}
	
	//Salva um registro
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Pessoa obj){
		obj=pessoaRepository.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Deleta registro por id
	@RequestMapping(value="/id/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		pessoaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
