package com.giuliag.PrjEmpresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.giuliag.PrjEmpresa.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	@Query("SELECT f FROM Funcionario f WHERE LOWER(f.funNome) LIKE LOWER(CONCAT('%', :funNome, '%'))")
	List<Funcionario> findByNomeContaining(@Param("funNome") String funNome);
	
}
