package Controle;

import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import Modelo.Cupom;
import Modelo.Loja;
import Modelo.Produtos;
import Visualizacao.EntradaSaida;


public class Controladora {
    Loja loja = new Loja();

    public void exibeMenu(){        
        int opcao = 0;        
        do{
            opcao = EntradaSaida.solicitaOpcao();

            switch(opcao){
                
                case 0:
                    Produtos produtos= new Produtos();
                    int adicionarCodigo = EntradaSaida.solicitaCodigo();

                    while (this.loja.verificaCodigo(adicionarCodigo)) {
                        JOptionPane.showMessageDialog(null, "Este código ja existe no estoque");
                        adicionarCodigo = EntradaSaida.solicitaCodigo();
                    }
                    produtos.setCodigo(adicionarCodigo);
                    produtos.setDescricao(EntradaSaida.solicitaDescicao());
                    produtos.setPreco(EntradaSaida.solicitaValor());
                    produtos.setQuantidadeProdutos(0);
                    this.loja.cadastrarProduto(produtos, adicionarCodigo);
                break;

                case 1:
                    if (loja.getListaDeProdutos().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não tem produtos cadastrados");
                    } else {

                        String informacoes = this.loja.verProdCadastrados();
                        EntradaSaida.mostrarProdCadastrados(informacoes);
                    }
                break;

                case 2:
                if (loja.getListaDeProdutos().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ainda não tem produto cadastrado!");
				} else {
                    String informacoes = this.loja.verProdCadastrados();
                    EntradaSaida.mostrarProdCadastrados(informacoes);


					int codigoEstoque = EntradaSaida.solicitaCodigo();

					while (!this.loja.verificaCodigo(codigoEstoque)) {
						JOptionPane.showMessageDialog(null, "Este código não existe ou não foi cadastrado");
						codigoEstoque = EntradaSaida.solicitaCodigo();
					}

					int qntdeEstoque = EntradaSaida.pedeQuantidadeProdutos();
					this.loja.mostraEstoque(qntdeEstoque, codigoEstoque);
				}
                break;

                case 3:
                    String infoEstoque = this.loja.verEstoque();
                    EntradaSaida.mostrarEstoque(infoEstoque);
                break;

                case 4:

                if (this.loja.getListaDeProdutos().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Você não tem produtos para vender");

				} else {

					int codigo = EntradaSaida.solicitaCodigo();
					int qntdeVendida = EntradaSaida.pedeQuantidadeProdutos();
					Produtos produtao = this.loja.pegaProduto(codigo);

					if (produtao.getQuantidadeProdutos() - qntdeVendida < 0) {
						JOptionPane.showMessageDialog(null, "A quantidade é maior do que a disponivel para venda");
					
                    }else {
						this.loja.venderProduto(codigo, qntdeVendida);
						Cupom cupom = new Cupom();
						cupom.setDataVenda(LocalDateTime.now());
						cupom.setDescricao(produtao.getDescricao());
						cupom.setQuantidade(qntdeVendida);
						cupom.setPreco(produtao.getPreco());
						cupom.setValorTotal(produtao.getPreco() * qntdeVendida);
						this.loja.gerarCupom(cupom);

					}
				}
                break;
                
                case 5:
                if (loja.getListaDeCupons().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Não há cupons gerados!");
				} else {
					String informacoes = this.loja.mostrarCuponsGerados();
					JOptionPane.showMessageDialog(null, informacoes, "Cupons Gerados", JOptionPane.INFORMATION_MESSAGE);
				}
				break;

                case 6:
				if (loja.getListaDeCupons().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Ainda não há nenhum cupom gerado");

				} else {

					String informacoes = this.loja.calculaTotalCupons();
					JOptionPane.showMessageDialog(null, informacoes, "Valor Total de Cupons", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
            }

        }while(opcao !=7);
        EntradaSaida.msgSairDaLoja();
    }
}
