package model.entities;

import java.math.BigDecimal;

public class DescontoTerceiraFaixa extends CalcularFaixaDeDesconto {
	
	private final BigDecimal FAIXA_DESCONTO = new BigDecimal("0.08");

	public DescontoTerceiraFaixa(CalcularFaixaDeDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		
		BigDecimal valor = new BigDecimal("0");
		
		if(valorTotal >= 1000) {
			valor = valor.add(BigDecimal.valueOf(valorTotal));
			valor = valor.multiply(FAIXA_DESCONTO);
			
			return valor.doubleValue();
		}
		
		return -1;
	}
	

}
