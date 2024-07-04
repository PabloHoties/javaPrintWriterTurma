package controllers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import entities.Aluno;
import entities.Professor;
import entities.Turma;
import enums.Disciplina;
import interfaces.TurmaRepository;
import repositories.TurmaRepositoryTxt;
import repositories.TurmaRepositoryXml;

public class TurmaController {

	public void cadastrarTurma() throws Exception {
		Scanner scanner = new Scanner(System.in);
		Turma turma = new Turma();

		System.out.println("Cadastro de Turma:\n");

		// Turma
		turma.setId(UUID.randomUUID());
		System.out.print("Nome da Turma: ");
		turma.setNome(scanner.nextLine());
		System.out.print("Horas de Aula: ");
		turma.setHoras_aula(Integer.parseInt(scanner.nextLine()));
		System.out.print("Quantidade de alunos: ");
		Integer quantidadeAlunos = Integer.parseInt(scanner.nextLine());

		// Professor
		Professor professor = new Professor();
		professor.setId(UUID.randomUUID());
		System.out.print("\nNome do Professor(a): ");
		professor.setNome(scanner.nextLine());
		System.out.print(
				"\n\n(1) Artes\n(2) Biologia\n(3) Educação Física\n(4) Espanhol\n(5) Física\n(6) Filosofia\n(7) Geografia\n(8) História\n(9) Inglês\n(10) Matemática\n(11) Português\n(12) Química\n(13) Sociologia\n\nEscolha uma disciplina: ");
		Integer numeroDisciplina = Integer.parseInt(scanner.nextLine());

		switch (numeroDisciplina) {
		case 1:
			professor.setDisciplina(Disciplina.ARTES);
			break;
		case 2:
			professor.setDisciplina(Disciplina.BIOLOGIA);
			break;
		case 3:
			professor.setDisciplina(Disciplina.EDUCAÇÃO_FÍSICA);
			break;
		case 4:
			professor.setDisciplina(Disciplina.ESPANHOL);
			break;
		case 5:
			professor.setDisciplina(Disciplina.FÍSICA);
			break;
		case 6:
			professor.setDisciplina(Disciplina.FILOSOFIA);
			break;
		case 7:
			professor.setDisciplina(Disciplina.GEOGRAFIA);
			break;
		case 8:
			professor.setDisciplina(Disciplina.HISTÓRIA);
			break;
		case 9:
			professor.setDisciplina(Disciplina.INGLÊS);
			break;
		case 10:
			professor.setDisciplina(Disciplina.MATEMÁTICA);
			break;
		case 11:
			professor.setDisciplina(Disciplina.PORTUGUÊS);
			break;
		case 12:
			professor.setDisciplina(Disciplina.QUÍMICA);
			break;
		case 13:
			professor.setDisciplina(Disciplina.SOCIOLOGIA);
			break;
		default:
			scanner.close();
			throw new IllegalArgumentException("Disciplina inválida.");
		}
		turma.setProfessor(professor);

		// Aluno
		turma.setAlunos(new ArrayList<Aluno>());
		for (int i = 1; i <= quantidadeAlunos; i++) {
			Aluno aluno = new Aluno();
			aluno.setId(UUID.randomUUID());
			System.out.print("\nNome do Aluno(a): ");
			aluno.setNome(scanner.nextLine());
			System.out.print("Idade do Aluno(a): ");
			aluno.setIdade(Integer.parseInt(scanner.nextLine()));

			turma.getAlunos().add(aluno);
		}

		System.out.print("\nEscolha (1) para XML ou (2) para TXT: ");
		Integer escolha = Integer.parseInt(scanner.nextLine());
		TurmaRepository turmaRepository = null;

		switch (escolha) {
		case 1:
			turmaRepository = new TurmaRepositoryXml();
			break;
		case 2:
			turmaRepository = new TurmaRepositoryTxt();
			break;
		default:
			scanner.close();
			throw new IllegalArgumentException("Formato inválido.");
		}

		turmaRepository.exportar(turma);
		scanner.close();
	}
}
