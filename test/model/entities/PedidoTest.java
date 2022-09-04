package model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.exceptions.QuantidadeInvalidaException;
import model.utils.PedidoBuilder;

public class PedidoTest {

	private PedidoBuilder pedido;

	@BeforeEach
	public void setup() {
		pedido = new PedidoBuilder();
	}

	private void assertResumoPedido(double valorTotal, double desconto) {
		assertEquals(valorTotal, pedido.getInstancia().valorTotal());
		assertEquals(desconto, pedido.getInstancia().desconto());
	}

	@Test
	public void adicionarUmItemNoPedido() throws Exception {
		pedido.comItem(3.0, 10);
	}

	@Test
	public void calcularValorTotalDescontoParaPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0);
	}

	@Test
	public void calcularItemSemDesconto() {
		pedido.comItem(5.0, 5);
		assertResumoPedido(25, 0.0);
	}

	@Test
	public void calcularResumoParaDoisItensSemDesconto() {
		pedido.comItem(3.0, 3).comItem(7.0, 3);

		assertResumoPedido(30, 0.0);

	}

	@Test
	public void aplicarDescontoPrimeiraFaixa() {
		pedido.comItem(20.0, 20);

		assertResumoPedido(400, 16);
	}

	@Test
	public void aplicarDescontoPrimeiraFaixa2() {
		pedido.comItem(17.25, 20);

		assertResumoPedido(345, 13.80);
	}

	@Test
	public void aplicarDescontoSegundaFaixa() {
		pedido.comItem(33.5, 26);

		assertResumoPedido(871, 52.26);
	}

	@Test
	public void aplicarDescontoTerceiraFaixa() {
		pedido.comItem(63.25, 20);

		assertResumoPedido(1265, 101.2);
	}

	@Test
	public void recusarValorUnitarioInferiorZero() {
		QuantidadeInvalidaException excecao = Assertions.assertThrows(QuantidadeInvalidaException.class, () -> {
			pedido.comItem(-10, 3);
		});
		
		Assertions.assertEquals("Parâmetro inválido.", excecao.getMessage());

	}
	
	@Test
	public void recusarPedidoInferiorZero() {
		QuantidadeInvalidaException excecao = Assertions.assertThrows(QuantidadeInvalidaException.class, () -> {
			pedido.comItem(-10, 3);
		});
		
		Assertions.assertEquals("Parâmetro inválido.", excecao.getMessage());

	}

}
