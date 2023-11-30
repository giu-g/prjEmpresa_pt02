package com.giuliag.PrjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giuliag.PrjEmpresa.entities.Funcionario;
import com.giuliag.PrjEmpresa.services.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Funcionario", description = "Controle de funcionários")
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	private final FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController (FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	@GetMapping("/{funCodigo}")
	@Operation(summary = "Apresenta todos os funcionários")
	public ResponseEntity<Funcionario> findFuncionariobyId(@PathVariable Long funCodigo) {
		Funcionario funcionario = funcionarioService.getFuncionarioById(funCodigo);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/nome/{funNome}")
	public ResponseEntity<List<Funcionario>> findFuncionariosByNomeAproximado(@PathVariable String funNome) {
	    List<Funcionario> funcionarios = funcionarioService.getFuncionariosByFunNomeAproximado(funNome);
	    if (!funcionarios.isEmpty()) {
	        return ResponseEntity.ok(funcionarios);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> findAllUsuarioscontrol() {
		List<Funcionario> funcionario = funcionarioService.getAllFuncionario();
		return ResponseEntity.ok(funcionario);
	}
	
	@PostMapping("/")
	@Operation(summary = "Cadastra um funcionário")
	public ResponseEntity<Funcionario> insertUsuariosControl(@RequestBody Funcionario funcionario) {
		Funcionario novofuncionario = funcionarioService.saveFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(novofuncionario);
	}
	
	@PutMapping("/{funCodigo}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long funCodigo, @RequestBody Funcionario funcionario) {
        Funcionario funcionarioAtualizado = funcionarioService.updateFuncionario(funCodigo, funcionario);
        if (funcionarioAtualizado != null) {
            return ResponseEntity.ok(funcionarioAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@DeleteMapping("/{funCodigo}")
	@Operation(summary = "Exclui um usuário")
	public ResponseEntity<String> deleteUsuarioControl(@PathVariable Long funCodigo) {
		boolean remover = funcionarioService.deleteFuncionario(funCodigo);
		if (remover) {
			return ResponseEntity.ok().body("usuario Excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
