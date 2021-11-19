package com.teste.aula.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.aula.model.Usuario;




@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
