package model.exceptions;

public class QuantidadeInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public QuantidadeInvalidaException(String mensagem) {
		super(mensagem);
	}

}
