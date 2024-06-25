package entities;

import java.util.List;
import java.util.UUID;

public class Turma {

	private UUID id;
	private String nome;
	private Integer horas_aula;
	private Professor professor; // Uma turma tem um professor.
	private List<Aluno> alunos; // Uma turma tem uma lista de alunos.

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getHoras_aula() {
		return horas_aula;
	}

	public void setHoras_aula(Integer horas_aula) {
		this.horas_aula = horas_aula;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
