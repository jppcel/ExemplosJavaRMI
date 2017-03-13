package br.univel.comum;

import java.io.Serializable;

public abstract class Tarefa<R> implements Serializable {

	private static final long serialVersionUID = -5363319611219246060L;
	
	private R resultado;

	public R getResultado() {
		return resultado;
	}

	protected final void setResultado(R resultado) {
		this.resultado = resultado;
	}

	public abstract void work();
	
}
