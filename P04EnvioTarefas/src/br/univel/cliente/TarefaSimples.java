package br.univel.cliente;

import br.univel.comum.Tarefa;

class TarefaSimples extends Tarefa<String>{

	private static final long serialVersionUID = -2170964870071376254L;

	@Override
	public void work() {
		System.out.println("Tarefa Trabalhando");
		
		for (int i = 0; i < 20; i++) {
			System.out.print(".");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		super.setResultado("Ma oeeeee!!");
		
		System.out.println("\nTarefa Terminada.");
	}
	
}
