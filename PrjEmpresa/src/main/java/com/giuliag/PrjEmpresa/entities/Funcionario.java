package com.giuliag.PrjEmpresa.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name= "tb_funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funCodigo;
	
	@NotNull
	@NotBlank
	private String funNome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate funNascimento;
	
	@NotNull
	@NotBlank
	@Size(min = 4,message= "Um salário mínimo tem ao menos 4 digitos!")
	private String funSalario;
	
	@ManyToOne
	private Departamento departamento;

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Long getFunCodigo() {
		return funCodigo;
	}

	public void setFunCodigo(Long funCodigo) {
		this.funCodigo = funCodigo;
	}

	public String getFunNome() {
		return funNome;
	}

	public void setFunNome(String funNome) {
		this.funNome = funNome;
	}

	public LocalDate getFunNascimento() {
		return funNascimento;
	}

	public void setFunNascimento(LocalDate funNascimento) {
		this.funNascimento = funNascimento;
	}

	public String getFunSalario() {
		return funSalario;
	}

	public void setFunSalario(String funSalario) {
		this.funSalario = funSalario;
	}
}
