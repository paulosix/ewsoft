package br.com.ewsoft.seguranca.model.types;

public enum TipoNivelDeGrupo {
	ADMINISTRADORES(1),USUARIOS(2),FORNECEDORES(3),CLIENTES(4);

	private final int valor;

	TipoNivelDeGrupo(int valorOpcao) {
		valor = valorOpcao;
	}

	public int getValor(){
		return valor;
	}
}
