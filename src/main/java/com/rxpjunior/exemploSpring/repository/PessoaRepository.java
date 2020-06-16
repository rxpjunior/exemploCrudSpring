package com.rxpjunior.exemploSpring.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rxpjunior.exemploSpring.model.Pessoa;

@Repository // Anotação que indica se tratar de um repositório
public interface PessoaRepository extends CrudRepository<Pessoa,Integer>{

}
