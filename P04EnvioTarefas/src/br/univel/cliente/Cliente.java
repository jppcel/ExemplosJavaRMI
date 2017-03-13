package br.univel.cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.univel.comum.ServicoExecucao;

public class Cliente {


	public static void main(String[] args) {
		Registry registry;
		try {
			registry = LocateRegistry
					.getRegistry("127.0.0.1", 1818);
			
			ServicoExecucao servico = (ServicoExecucao) registry
					.lookup(ServicoExecucao.NOME_SERVICO);
			
			TarefaSimples ts = new TarefaSimples();
			
			System.out.println("Vou mandar para o servidor.");
			String retorno = servico.executar(ts);
			System.out.println("Retorno do servidor: " + retorno);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
}
