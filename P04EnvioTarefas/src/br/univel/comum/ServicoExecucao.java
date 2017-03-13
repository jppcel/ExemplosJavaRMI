package br.univel.comum;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServicoExecucao extends Remote {

	public static final String NOME_SERVICO 
				= "The_remote_executor";
	
	public <R> R executar(Tarefa<R> tarefa) 
			throws RemoteException;

}
