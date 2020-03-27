package test;

import javax.swing.JOptionPane;

import model.Pais;
import service.PaisService;

public class PaisTeste {

	public static void main(String[] args) {
		int menu;

		String menuTxt = "MENU\n" +
						 "1- Adicionar pa�s;\n" +
						 "2- Remover pa�s;\n" +
						 "3- Carregar pa�s\n" +
						 "4- Alterar Pa�s\n" +
						 "5- Carregar pa�s com a maior popula��o\n" +
						 "6- Carregar pa�s com a menor �rea\n" +
						 "7- Carregar 3 pa�ses\n" +
						 "8- Sair";

		PaisService ps = new PaisService();

		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog(menuTxt));

			if (menu == 0) {}
			else if (menu == 1) {
				Pais pais = new Pais(
							0,
							JOptionPane.showInputDialog("Digite o nome do pa�s"),
							Long.parseLong(JOptionPane.showInputDialog("Digite a popula��o do pa�s")),
							Double.parseDouble(JOptionPane.showInputDialog("Digite a �rea do pa�s"))
						);
				ps.incluir(pais);
			}
			else if (menu == 2) {
				ps.excluir(Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do pa�s para excluir")));
			}
			else if (menu == 3) {
				JOptionPane.showMessageDialog(null, ps.carregar(Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do pa�s para carregar"))));
			}
			else if (menu == 4) {
				Pais pais = new Pais(
						Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do pa�s que deseja atualizar os dados")),
						JOptionPane.showInputDialog("Digite o nome do pa�s"),
						Long.parseLong(JOptionPane.showInputDialog("Digite a popula��o do pa�s")),
						Double.parseDouble(JOptionPane.showInputDialog("Digite a �rea do pa�s"))
					);
			ps.atualizar(pais);
			}
			else if (menu == 5) {
				JOptionPane.showMessageDialog(null, ps.carregarMaiorPopulacao());
			}
			else if (menu == 6) {
				JOptionPane.showMessageDialog(null, ps.carregarMenorArea());
			}
			else if (menu == 7) {
				String concatenador = "";
				Pais[] paises = ps.carrega3paises();
				for (int i = 0; i < paises.length; i++) {
					concatenador += paises[i] + "\n";
				}
				JOptionPane.showMessageDialog(null, concatenador);
			}

		} while (menu != 8);
	}
}