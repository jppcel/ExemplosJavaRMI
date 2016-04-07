package br.dagostini.cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.dagostini.comum.ServicoRMI;

public class Cliente {

	private static final int PORTA_TCPIP = 1818;

	/**
	 * Formatador de data para informações no console. Ver:
	 * https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
	 */
	private SimpleDateFormat sdf = new SimpleDateFormat("'[Cliente] 'dd/MM/yyyy H:mm:ss:SSS' -> '");

	public Cliente() {

		mostraConsole("Iniciando o cliente");
		
		Registry registry;
		try {

			// Intância do registro. Nesse momento a conexão com o servidor já
			// é estabelecida pela rede, ou pela internet se for o caso.
			registry = LocateRegistry.getRegistry("127.0.0.1", PORTA_TCPIP);

			// Busca pelo nome no registro uma instância do objeto remoto.
			// A variável servico abaixo está referenciando um objeto existente
			// na JVM do servidor.
			ServicoRMI servico = (ServicoRMI) registry.lookup(ServicoRMI.NOME);

			// Ao chamar o método saudar o parâmetro é transferido pela rede,
			// chega no servidor, o método então é executado no servidor e o
			// retorno volta aqui para o cliente.
			String retorno = servico.saudar("Pluto");

			mostraConsole(retorno);

		} catch (Exception e) {
			System.err.println("\n\n-------------------------------------------------------\n"
					+ "ERRO: VERIFIQUE SE O SERVIDOR ESTÁ RODANDO, SE O IP E PORTA ESTÃO"
					+ " CORRETOS, SE NÃO HÁ BLOQUEIO DE FIREWALL OU ANTIVIRUS.\n"
					+ "-------------------------------------------------------------------\n\n");
			e.printStackTrace();
		}

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

	public static void main(String[] args) {
		new Cliente();
	}
}