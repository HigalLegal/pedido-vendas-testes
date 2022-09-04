package model.entities;

import java.math.BigDecimal;

public class DescontoPrimeiraFaixa extends CalcularFaixaDeDesconto {

	private final BigDecimal FAIXA_DESCONTO = new BigDecimal("0.04");

	public DescontoPrimeiraFaixa(CalcularFaixaDeDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {

		BigDecimal valor = new BigDecimal("0");

		if (valorTotal >= 300 && valorTotal < 800) {
			valor = valor.add(BigDecimal.valueOf(valorTotal));
			valor = valor.multiply(FAIXA_DESCONTO);

			return valor.doubleValue();
		}

		return -1;
	}
}
