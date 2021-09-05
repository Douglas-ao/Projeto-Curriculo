package br.unipar.ambientes;

import org.eclipse.swt.widgets.Display;

import br.unipar.ambientes.telas.dialog.CurriculoDialog;


public class AmbientesMain {

	public static void main(String[] args) {
//		LoginDialog loginDialog = new LoginDialog(Display.getDefault().getActiveShell());
//		loginDialog.open();
		
//		CalculadoraIMCDialog calculadoraDialog = new CalculadoraIMCDialog(Display.getDefault().getActiveShell());
//		calculadoraDialog.open();
		
//		CadastroDialog cadastroDialog = new CadastroDialog(Display.getDefault().getActiveShell());
//		cadastroDialog.open();

		CurriculoDialog curriculoDialog = new CurriculoDialog(Display.getDefault().getActiveShell());
		curriculoDialog.open();
	
//		ExemploTrabalhoDialog exemploDialog = new ExemploTrabalhoDialog(Display.getDefault().getActiveShell());
//		exemploDialog.open();		
	}

}
