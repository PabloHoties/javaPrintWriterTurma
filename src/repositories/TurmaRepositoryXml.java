package repositories;

import java.io.PrintWriter;

import entities.Aluno;
import entities.Turma;
import interfaces.TurmaRepository;

public class TurmaRepositoryXml implements TurmaRepository {

	@Override
	public void exportar(Turma turma) throws Exception {
		PrintWriter printWriter = new PrintWriter("turma_" + turma.getId() + ".xml");
		
		printWriter.write("<?xml version='1.0' encoding='utf-8'?>");
		printWriter.write("<turma>");
		printWriter.write("<id>" + turma.getId() + "</id>");
		printWriter.write("<nome>" + turma.getNome() + "</nome>");
		printWriter.write("<horas_aula>" + turma.getHoras_aula() + "</horas_aula>");
			printWriter.write("<professor>");
			printWriter.write("<id>" + turma.getProfessor().getId() + "</id>");
			printWriter.write("<nome>" + turma.getProfessor().getNome() + "</nome>");
			printWriter.write("<disciplina>" + turma.getProfessor().getDisciplina() + "</disciplina>");
			printWriter.write("</professor>");
			printWriter.write("<alunos>");
			for(Aluno aluno : turma.getAlunos()) {
				printWriter.write("<aluno>");
				printWriter.write("<id>" + aluno.getId() + "</id>");
				printWriter.write("<nome>" + aluno.getNome() + "</nome>");
				printWriter.write("<idade>" + aluno.getIdade() + "</idade>");
				printWriter.write("</aluno>");
			}
			printWriter.write("</alunos>");
		printWriter.write("</turma>");
		
		printWriter.flush();
		printWriter.close();
	}

}
