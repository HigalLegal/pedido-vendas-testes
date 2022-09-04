package model.entities;

import java.math.BigDecimal;

public class DescontoSegundaFaixa extends CalcularFaixaDeDesconto {

	private final BigDecimal FAIXA_DESCONTO = new BigDecimal("0.06");

	public DescontoSegundaFaixa(CalcularFaixaDeDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {

		BigDecimal valor = new BigDecimal("0");

		if (valorTotal >= 800 && valorTotal < 1000) {
			valor = valor.add(BigDecimal.valueOf(valorTotal));
			
			//double debug = valor.doubleValue();
			
			valor = valor.multiply(FAIXA_DESCONTO);
			
			//debug = valor.doubleValue();

			return valor.doubleValue();
		}

		return -1;
	}

}
