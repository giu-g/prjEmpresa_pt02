package com.giuliag.PrjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giuliag.PrjEmpresa.entities.Departamento;
import com.giuliag.PrjEmpresa.services.DepartamentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Departamento", description = "Controle de departamentos")
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	private final DepartamentoService departamentoService;

	@Autowired
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	@PostMapping
	@Operation(summary = "Cadastra um funcionário")
	public Departamento createDepartamento(@RequestBody Departamento departamento) {
		return departamentoService.saveDepartamento(departamento);
	}

	@GetMapping("/{depCodigo}")
	@Operation(summary = "Apresenta todos os funcionários")
	public Departamento getDepartamento(@PathVariable Long depCodigo) {
		return departamentoService.getDepartamentoById(depCodigo);
	}

	@GetMapping
	public List<Departamento> getAllDepartamento() {
		return departamentoService.getAllDepartamento();
	}

	@DeleteMapping("/{depCodigo}")
	@Operation(summary = "Exclui um usuário")
	public void deleteDepartamento(@PathVariable Long depCodigo) {
		departamentoService.deleteDepartamento(depCodigo);
	}
}
