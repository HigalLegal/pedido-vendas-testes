package model.entities;

public abstract class CalcularFaixaDeDesconto {
	
	private CalcularFaixaDeDesconto proximo;
	
	public CalcularFaixaDeDesconto() {}

	public CalcularFaixaDeDesconto(CalcularFaixaDeDesconto proximo) {
		this.proximo = proximo;
	}
	
	public double desconto(double valorTotal) {
		
		double valorDesconto = calcular(valorTotal);
		
		if(valorDesconto == -1) {
			valorDesconto = proximo.desconto(valorTotal);
		}
		
		return valorDesconto;
		
	}
	
	protected abstract double calcular(double valorTotal);

}
