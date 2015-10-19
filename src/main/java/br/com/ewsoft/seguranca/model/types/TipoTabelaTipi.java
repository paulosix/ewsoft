package br.com.ewsoft.seguranca.model.types;

public enum TipoTabelaTipi {
	PRODUTO(1), SERVICO(2);

	private final int valor;

	TipoTabelaTipi(int valorOpcao) {
		valor = valorOpcao;
	}

	public int getValor(){
		return valor;
	}
}
