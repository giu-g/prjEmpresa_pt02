package com.giuliag.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giuliag.PrjEmpresa.entities.Funcionario;
import com.giuliag.PrjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;

	}

	public List<Funcionario> getAllFuncionario() {
		return funcionarioRepository.findAll();
	}

	public Funcionario getFuncionarioById(Long funCodigo) {
		return funcionarioRepository.findById(funCodigo).orElse(null);
	}

	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public List<Funcionario> getFuncionariosByFunNomeAproximado(String funNome) {
		return funcionarioRepository.findByNomeContaining(funNome);
	}

	public boolean deleteFuncionario(Long funCodigo) {
		Optional<Funcionario> funcionarioExistente = funcionarioRepository.findById(funCodigo);
		if (funcionarioExistente.isPresent()) {
			funcionarioRepository.deleteById(funCodigo);
			return true;
		} else {
			return false;
		}
	}

	public Funcionario updateFuncionario(Long funCodigo, Funcionario novoFuncionario) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(funCodigo);
		if (funcionarioOptional.isPresent()) {
			Funcionario funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setFunNome(novoFuncionario.getFunNome());
			funcionarioExistente.setFunNascimento(novoFuncionario.getFunNascimento());
			funcionarioExistente.setFunSalario(novoFuncionario.getFunSalario());

			if (novoFuncionario.getDepartamento() != null) {
				funcionarioExistente.setDepartamento(novoFuncionario.getDepartamento());
			}
			return funcionarioRepository.save(funcionarioExistente);
		} else {
			return null;
		}
	}

}
