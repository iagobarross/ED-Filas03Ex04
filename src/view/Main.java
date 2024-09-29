package view;

import javax.swing.JOptionPane;

import br.edu.fateczl.Fila.*;
import controller.ImpressoraController;

public class Main {

	public static void main(String[] args) {
		Fila<String> f = new Fila<>();
		ImpressoraController impCont = new ImpressoraController();
		int opc = 0;

		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("MENU\n\n1- Inserir Documento\n2- Imprimir\n9- Fim"));

			switch (opc) {

			case 1:
				StringBuffer documento = new StringBuffer();

				String idPC = JOptionPane.showInputDialog("Digite o ID do seu PC: ");
				while (idPC.equals("")) {
					idPC = JOptionPane.showInputDialog("Digite o ID do seu PC: ");
				}
				documento.append(idPC);
				documento.append(";");

				String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo: ");
				while (nomeArquivo.equals("")) {
					nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo: ");
				}

				documento.append(nomeArquivo);

				impCont.insereDocumento(f, documento.toString());

				break;

			case 2:
				try {
					impCont.imprime(f);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;

			case 9:
				JOptionPane.showMessageDialog(null, "Programa finalizado");
				System.exit(0);

			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida");

			}
		}

	}

}
