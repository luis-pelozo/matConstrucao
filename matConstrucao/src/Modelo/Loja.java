package Modelo;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Visualizacao.EntradaSaida;

public class Loja {

    private ArrayList<Produtos> listaDeProdutos = new ArrayList<Produtos>();

    public ArrayList<Produtos> getListaDeProdutos() {
		return listaDeProdutos;
	}

    public void setListaDeProdutos(ArrayList<Produtos> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

    public void cadastrarProduto(Produtos produto, int addCodigo) {
		listaDeProdutos.add(produto);
		JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");

	}

    public boolean verificaCodigo(int addCodigo) {
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = listaDeProdutos.get(i);
			if (produto.getCodigo() == addCodigo) {
				return true;
			}
		}
		return false;
	}

    DecimalFormat df = new DecimalFormat("#0.00");

    public String verProdCadastrados() {
		String informacoes = "";
		for (Produtos produto : this.listaDeProdutos) {
			informacoes += "#" + produto.getCodigo()  + " -  " + produto.getDescricao() +  " - R$" + df.format(produto.getPreco()) + "\n" + "\n";
		}

		return informacoes;
	}


    public void mostraEstoque(int qntdeEstoque, int codigoEstoque) {

		for (int i = 0; i < listaDeProdutos.size(); i++) {

			Produtos produto = listaDeProdutos.get(i);

			if (produto.getCodigo() == codigoEstoque) {
				produto.setQuantidadeProdutos(produto.getQuantidadeProdutos() + qntdeEstoque);
				JOptionPane.showMessageDialog(null, "Estoque cadastrado!");
			}
		}

	}

    public String verEstoque() {

		String infoEstoque = "";

		for (Produtos produto : this.listaDeProdutos) {
			infoEstoque += "#" + produto.getCodigo() + " - " + produto.getDescricao() + "\n"
					+ "Quantidade em estoque: " + produto.getQuantidadeProdutos() + "\n" + "\n";
		}

		if (infoEstoque == "") {
			String vazio = "Não tem produtos no estoque ainda";
			return vazio;
		} else {
			return infoEstoque;
		}
	}

    public Produtos pegaProduto(int codigo) {
		Produtos recebeProduto = null;

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = listaDeProdutos.get(i);
			if (produto.getCodigo() == codigo) {
				recebeProduto = produto;
			}
		}
		return recebeProduto;
	}

    public void venderProduto(int codigo, int qntdeVendida) {

		boolean verificaRemocao = false;

		for (int i = 0; i < listaDeProdutos.size(); i++) {

			Produtos produto = listaDeProdutos.get(i);

			if (produto.getCodigo() == codigo) {
				verificaRemocao = true;
				JOptionPane.showMessageDialog(null, "Vendido: " + qntdeVendida + " " + produto.getDescricao());
				int qtd = produto.getQuantidadeProdutos() - qntdeVendida;
				produto.setQuantidadeProdutos(qtd);
			}
		}
		if (verificaRemocao == false) {
			JOptionPane.showMessageDialog(null, "Produto inválido ou não existe");
		}
	}


    /*private ArrayList<Cupom> listaDeCupons = new ArrayList<Cupom>();

    public ArrayList<Cupom> getListaDeCupons() {
		return listaDeCupons;
	}

	public void setListaDeCupons(ArrayList<Cupom> listaDeCupons) {
		this.listaDeCupons = listaDeCupons;
	}*/

    
}
