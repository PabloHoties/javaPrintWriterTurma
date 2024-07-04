package principal;

import controllers.TurmaController;

public class Main {

	public static void main(String[] args) {
		try {
			
			TurmaController turmaController = new TurmaController();
			turmaController.cadastrarTurma();

			System.out.println("\nTurma cadastrada com sucesso.");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.\n" + e.getMessage());
		}
	}
}
