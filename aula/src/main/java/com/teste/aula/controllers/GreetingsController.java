package com.teste.aula.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.teste.aula.model.Usuario;
import com.teste.aula.repository.UsuarioRepository;


/**
*
* A sample greetings controller to return greeting text
*/
@RestController
public class GreetingsController {
   /**
    *
    * @param name the name to greet
    * @return greeting text
    */
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Autowired
	private UsuarioRepository userR;
   
   @RequestMapping(value = "/usuario/{nome}/idade/{idade}", method = RequestMethod.GET)
   @ResponseStatus(HttpStatus.OK)
   public String salvarUsuario(@PathVariable String nome, @PathVariable int idade) {
   	
   	Usuario usuario = new Usuario();
   	    	   	
   	usuario.setNome(nome);
   	
   	usuario.setIdade(idade);
   	
   	usuarioRepository.save(usuario);
   	
   	   	    	
   	return  "Salvo o usuario " + nome + " | Idade " + idade;
   	
   }
    
   @RequestMapping(value = "listar", method = RequestMethod.GET)
   @ResponseStatus(HttpStatus.OK)
   public List<Usuario> buscarTodos() { 
	   
   	return userR.findAll();
   	
   }
   
   @DeleteMapping(value = "deletar")
   @ResponseBody
   public ResponseEntity<Usuario> delete(@RequestParam Long id){
   	
   	usuarioRepository.deleteById(id);
   	
   	return new ResponseEntity<Usuario>(HttpStatus.OK);

   }
   
     
}