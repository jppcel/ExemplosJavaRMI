package br.dagostini.comum;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Interface implementada pelo cliente. Esses métodos são chamados no servidor e
 * executados no cliente.
 * 
 * AVISO: NÃO PREOCUPAÇÃO ALGUMA COM A SEGURANÇA AQUI. ESSE É SÓ UM EXEMPLO DE
 * RMI.
 * 
 * @author Fernando D'Agostini
 *
 */
public interface Cliente extends Remote {

	/**
	 * Faz o cliente receber a lista de participantes do chat. A lista completa
	 * é enviada a cada vez que um novo cliente entra no chat ou um participante
	 * sai.
	 * 
	 * @param lista
	 *            Lista com os nomes.
	 * 
	 * @throws RemoteException
	 */
	public void receberListaParticipantes(List<String> lista) throws RemoteException;

	/**
	 * Faz o cliente receber uma mensagem privada, ou seja, a mensagem foi
	 * enviada somente para ele.
	 * 
	 * @param remetente
	 *            Nome do remetente.
	 * 
	 * 
	 * @param mensagem
	 *            Texto da mensagem.
	 * 
	 * @throws RemoteException
	 */
	public void receberMensagemPrivada(String remetente, String mensagem) throws RemoteException;

	/**
	 * Faz o cliente receber uma mensagem pública, ou seja, que foi enviada para
	 * todos.
	 * 
	 * @param remetente
	 *            Quem enviou a mensagem.
	 * 
	 * @param mensagem
	 *            Texto da mensagem.
	 * 
	 * @throws RemoteException
	 */
	public void receberMensagemPublica(String remetente, String mensagem) throws RemoteException;

}
