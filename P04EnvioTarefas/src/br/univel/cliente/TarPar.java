package br.univel.cliente;

import br.univel.comum.Tarefa;

public class TarPar extends Tarefa<Integer> {

	private int i;
	private int j;

	public TarPar(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public void work() {
		this.setResultado(this.i + this.j);
	}

}
