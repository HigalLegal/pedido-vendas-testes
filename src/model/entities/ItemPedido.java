package model.entities;

import java.math.BigDecimal;

import model.exceptions.QuantidadeInvalidaException;

public class ItemPedido {
	
	private String descricao;
	private BigDecimal valorUnitario;
	private int quantidade;

	// --------------------------------------------

	public ItemPedido() {
	}

	public ItemPedido(String descricao, Double valorUnitario, int quantidade) {
		
		if(valorUnitario < 0 || quantidade < 0) {
			throw new QuantidadeInvalidaException("Parâmetro inválido.");
		}
		
		this.descricao = descricao;
		this.valorUnitario = BigDecimal.valueOf(valorUnitario);
		this.quantidade = quantidade;
	}
	
	// --------------------------------------------

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = BigDecimal.valueOf(valorUnitario);
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	// -------------------------------------------
	
	public BigDecimal total() {
		return valorUnitario.multiply(BigDecimal.valueOf(quantidade));
	}
	
}