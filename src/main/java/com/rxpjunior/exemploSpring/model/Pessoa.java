package com.rxpjunior.exemploSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //Anotação que indica que se trata de uma tabela no BD
public class Pessoa {
	
	@Id // Chave primária
	@GeneratedValue(strategy=GenerationType.AUTO) // Geração de Id automática
	private Integer id;
	private String nome;
	private String peso;
	private String altura;
		
	public Pessoa() {
		super();
	}

	public Pessoa(Integer id, String nome, String peso, String altura) {
		super();
		this.id = id;
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}
	
}
