package br.univel.servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.univel.comum.ServicoExecucao;
import br.univel.comum.Tarefa;

public class Servidor implements ServicoExecucao {
	
	
	public static void main(String[] args) {
		
		System.out.println("Iniciando servidor");
		Servidor servidor = new Servidor();
		
		ServicoExecucao servico;
		try {
			servico = (ServicoExecucao) UnicastRemoteObject
					.exportObject(servidor, 0);
			Registry registry = LocateRegistry
					.createRegistry(1818);
			registry
				.rebind(ServicoExecucao.NOME_SERVICO, servico);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public <R> R executar(Tarefa<R> tarefa) throws RemoteException {

		System.out.println("Recebendo tarefa para "
				+ "executar.");

		tarefa.work();
		
		System.out.println("Tarefa executada.");
		
		return tarefa.getResultado();

	}

}
