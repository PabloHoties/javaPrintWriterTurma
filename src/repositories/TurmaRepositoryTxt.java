package repositories;

import java.io.PrintWriter;

import entities.Aluno;
import entities.Turma;
import interfaces.TurmaRepository;

public class TurmaRepositoryTxt implements TurmaRepository {

	@Override
	public void exportar(Turma turma) throws Exception {
		PrintWriter printWriter = new PrintWriter("turma_" + turma.getId() + ".txt");

		printWriter.write("ID da Turma: " + turma.getId());
		printWriter.write("\nNome da Turma: " + turma.getNome());
		printWriter.write("\nHoras de Aula: " + turma.getHoras_aula());

		printWriter.write("\n\nProfessor:\n- ID: " + turma.getProfessor().getId());
		printWriter.write("\n- Nome: " + turma.getProfessor().getNome());
		printWriter.write("\n- Disciplina: " + turma.getProfessor().getDisciplina());

		printWriter.write("\nAlunos:");
		int quantidadeAlunos = 1;
		for (Aluno aluno : turma.getAlunos()) {
			printWriter.write("\n" + quantidadeAlunos + ". ID: " + aluno.getId());
			printWriter.write("\n   Nome: " + aluno.getNome());
			printWriter.write("\n   Idade: " + aluno.getIdade() + "\n");
			quantidadeAlunos++;
		}
		
		printWriter.flush();
		printWriter.close();
	}
}
