package Visualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

    public static int solicitaOpcao() {
		String[] opcoes = { "Cadastrar", "Mostrar produtos cad", "Adicionar produtos", "Ver estoque de produtos", "Vender",
				 "Cupons impressos", "Valor total de cupons", "Sair da loja" };

		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a ação desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static int solicitaCodigo(){
		return Integer.parseInt(JOptionPane.showInputDialog("Informe o código do novo produto"));
	}

	public static void msgSairDaLoja() {
		JOptionPane.showMessageDialog(null, "Obrigado. Volte sempre!");
	}

	public static String solicitaDescicao(){
		return JOptionPane.showInputDialog("Informe a descrição do produto");
	}

	public static double solicitaValor(){
		return Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do produto"));
	}

	public static int pedeQuantidadeProdutos() {

		return Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de produtos"));
	}

	public static void mostrarProdCadastrados(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Produtos Cadastrados", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void mostrarEstoque(String informacoes) {

		JOptionPane.showMessageDialog(null, informacoes, "Produtos em Estoque", JOptionPane.INFORMATION_MESSAGE);
	}



    
}
