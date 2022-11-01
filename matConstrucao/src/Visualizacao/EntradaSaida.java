package Visualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

    public static int solicitaOpcao() {
		String[] opcoes = { "Cadastrar", "Mostrar lista produtos", "Adicionar produtos", "Vender",
				"Estoque de produtos", "Cupons impressos", "Valor total de cupons", "Sair da loja" };

		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a ação desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}
    
}
