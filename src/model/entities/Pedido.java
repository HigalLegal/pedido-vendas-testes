package model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pedido {
	
	private CalcularFaixaDeDesconto calcularFaixaDeDesconto;
	
	private List<ItemPedido> itensPedido = new ArrayList<>();
	
	public Pedido(CalcularFaixaDeDesconto calcularFaixaDeDesconto) {
		this.calcularFaixaDeDesconto = calcularFaixaDeDesconto;
	}

	public void adicionarItem(ItemPedido itemPedido) {		
		itensPedido.add(itemPedido);
	}

	public Double valorTotal() {
		List<BigDecimal> valores = itensPedido.stream().map(item -> item.total()).collect(Collectors.toList());
		BigDecimal somatoria = valores.stream().reduce(new BigDecimal("0"), Pedido::somar);
		
		return somatoria.doubleValue();
	}

	public Double desconto() {
		
		double valorDesconto = calcularFaixaDeDesconto.desconto(valorTotal());
		
//		if(valorTotal() >= 300 && valorTotal() < 800) {
//			valorDesconto = BigDecimal.valueOf(valorTotal());
//			valorDesconto = valorDesconto.multiply(DESCONTO_FAIXA_1);
//			
//		} else if(valorTotal() >= 800 && valorTotal() < 1000) {
//			valorDesconto = BigDecimal.valueOf(valorTotal());
//			valorDesconto = valorDesconto.multiply(DESCONTO_FAIXA_2);
//			
//		} else if(valorTotal() >= 1000) {
//			valorDesconto = BigDecimal.valueOf(valorTotal());
//			valorDesconto = valorDesconto.multiply(DESCONTO_FAIXA_3);
//			
//		} 
		
		return valorDesconto;
	}
	
	private static BigDecimal somar(BigDecimal numero1, BigDecimal numero2) {
		return numero1.add(numero2);
	}

}
