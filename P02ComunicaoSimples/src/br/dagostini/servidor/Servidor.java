package br.dagostini.servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.dagostini.comum.ServicoRMI;

/**
 * Implementação do servidor.
 * 
 * @author Fernando D'Agostini
 */
public class Servidor extends UnicastRemoteObject implements Runnable, ServicoRMI {

	private static final long serialVersionUID = 8739495026619829583L;

	/**
	 * Estendendo de {@link UnicastRemoteObject} não é necessário chamar essa
	 * linha como no exemplo P01:
	 * 
	 * servico = (ServicoRMI) UnicastRemoteObject.exportObject(Servidor.this, 0);
	 * 
	 * @throws RemoteException
	 */
	public Servidor() throws RemoteException {
		super();

		new Thread(this).start();
	}

	/**
	 * Porta para conexão do cliente.
	 */
	private static final int PORTA_TCPIP = 1818;

	/**
	 * Formatador de data para informações no console. Ver:
	 * https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
	 */
	private SimpleDateFormat sdf = new SimpleDateFormat("'[Servidor] 'dd/MM/yyyy H:mm:ss:SSS' -> '");

	@Override
	public void run() {

		mostraConsole("Iniciando o servidor.");

		try {
			// Cria e exporta uma instância de Registry no localhost que
			// aceita conexões tcp/ip na porta especificada.
			//
			// É nessa porta que o cliente deve conectar.
			//
			// Assegure-se de que a porta esteja disponível na máquina e
			// que o cliente use a mesma porta para conectar no servidor.
			Registry registry = LocateRegistry.createRegistry(PORTA_TCPIP);

			// Registra o objeto remoto exportado atribuindo-lhe um
			// nome.
			//
			// Para o nome é utilizada a constante da interface mas pode
			// ser uma String qualquer desde que o cliente saiba qual é o
			// nome correto.

			registry.rebind(ServicoRMI.NOME, this);

			mostraConsole("Aguardando conexões.");

		} catch (Exception e) {
			System.err.println("\n\n-------------------------------------------------------\n"
					+ "ERRO: VERIFIQUE SE A APLICAÇÃO JÁ NÃO ESTÁ RODANDO"
					+ " OU SE A PORTA NÃO ESTÁ OCUPADA POR OUTRO PROGRAMA.\n"
					+ "-------------------------------------------------------------------\n\n");
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc} A implementação apenas retorna um "Olá" concatenado ao nome
	 * recebido.
	 */
	@Override
	public String saudar(String nome) throws RemoteException {
		mostraConsole("Cliente conectou e passou o parâmetro \"" + nome + "\" para saudação.");
		return "Olá " + nome + "!";
	}

	/**
	 * Repassa as informações para o console adicionando informações de data e
	 * hora.
	 * 
	 * @param string
	 */
	private void mostraConsole(String string) {
		System.out.println(sdf.format(new Date()) + string);
	}

	/**
	 * Esse método main deve iniciar primeiro e antes de fechar deve aguardar o
	 * cliente conectar.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new Servidor();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
