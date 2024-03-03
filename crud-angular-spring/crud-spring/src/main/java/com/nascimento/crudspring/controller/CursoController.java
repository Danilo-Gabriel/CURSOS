package com.nascimento.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nascimento.crudspring.Model.Curso;
import com.nascimento.crudspring.repository.CursoRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/cursos")
 public class CursoController {



  private final CursoRepository cursoRepository;

  /*public CursoController(CursoRepository cursoRepository){
    this.cursoRepository = cursoRepository;
  }
  */



  //@RequestMapping(method = RequestMethod.GET)
  @GetMapping
  public @ResponseBody List<Curso>List(){

    return cursoRepository.findAll();
  }


  //@RequestMapping(method = RequestMethod.POST)
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED) // Não precisaria mais no ResponseEntity no metodo
  public  /*ResponseEntity<Curso>*/ Curso create(@RequestBody Curso dados){

    //return ResponseEntity.status(HttpStatus.CREATED)
    //.body(dados);
     return cursoRepository.save(dados);
  //    System.out.println(dados.getNome());
  }

 }
