package Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.text.DateFormatter;

public class Cupom {
    LocalDateTime dataDaVenda = LocalDateTime.now();
    DateTimeFormatter formata = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private String descricao;
    private int quantidade;
    double preco, valorTotal;
    public String getDataDaVenda(){
        return dataDaVenda.format(formata);
    }

    public void setDataVenda(LocalDateTime dataDaVenda) {
		this.dataDaVenda = dataDaVenda;
	}

    public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


    public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

    public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}

    public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
