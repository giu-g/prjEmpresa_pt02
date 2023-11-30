package com.giuliag.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giuliag.PrjEmpresa.entities.Departamento;
import com.giuliag.PrjEmpresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	private final DepartamentoRepository departamentoRepository;

	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;

	}

	public Departamento saveDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	public List<Departamento> getAllDepartamento() {
		return departamentoRepository.findAll();
	}

	public Departamento getDepartamentoById(Long depCodigo) {
		return departamentoRepository.findById(depCodigo).orElse(null);
	}

	public void deleteDepartamento(Long depCodigo) {
		departamentoRepository.deleteById(depCodigo);
	}

	public Departamento updateDepartamento(Long depCodigo, Departamento novoDepartamento) {
		Optional<Departamento> departamentoOptional = departamentoRepository.findById(depCodigo);
		if (departamentoOptional.isPresent()) {
			Departamento departamentoExistente = departamentoOptional.get();
			departamentoExistente.setDepNome(novoDepartamento.getDepNome());
			departamentoExistente.setDepCodigo(novoDepartamento.getDepCodigo());
			return departamentoRepository.save(departamentoExistente);
		} else {
			return null;
		}
	}

}
