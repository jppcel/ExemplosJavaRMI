package br.dagostini.testes;

import java.awt.EventQueue;

import br.dagostini.cliente.InterfaceGraficaCliente;
import br.dagostini.servidor.InterfaceGraficaServidor;

public class Testar {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					InterfaceGraficaCliente cliente1 = new InterfaceGraficaCliente();
					cliente1.setVisible(true);
					cliente1.configurarAuto("Hugo", 0);

					InterfaceGraficaCliente cliente2 = new InterfaceGraficaCliente();
					cliente2.setVisible(true);
					cliente2.configurarAuto("José", 1);

					InterfaceGraficaCliente cliente3 = new InterfaceGraficaCliente();
					cliente3.setVisible(true);
					cliente3.configurarAuto("Luiz", 2);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
