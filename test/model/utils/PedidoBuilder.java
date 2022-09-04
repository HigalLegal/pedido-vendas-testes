package model.utils;

import model.entities.CalcularFaixaDeDesconto;
import model.entities.DescontoPrimeiraFaixa;
import model.entities.DescontoSegundaFaixa;
import model.entities.DescontoTerceiraFaixa;
import model.entities.ItemPedido;
import model.entities.Pedido;
import model.entities.SemDesconto;

public class PedidoBuilder {
	
	private Pedido instancia;
	
	public PedidoBuilder() {
		CalcularFaixaDeDesconto semDesconto = new SemDesconto();
		CalcularFaixaDeDesconto primeiraFaixa = new DescontoPrimeiraFaixa(semDesconto);
		CalcularFaixaDeDesconto segundaFaixa = new DescontoSegundaFaixa(primeiraFaixa);
		CalcularFaixaDeDesconto terceiraFaixa = new DescontoTerceiraFaixa(segundaFaixa);
		
		instancia = new Pedido(terceiraFaixa);
	}
	
	public PedidoBuilder comItem(double valorUnitario, int quantidade) {
		instancia.adicionarItem(new ItemPedido("Gerada", valorUnitario, quantidade));
		
		return this;
	}
	
	public Pedido getInstancia() {
		return instancia;
	}

}
