package br.dagostini.cliente;

import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.dagostini.comum.ServicoRMI;

public class Cliente {

	/**
	 * Formatador de data para informações no console. Ver:
	 * https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
	 */
	private SimpleDateFormat sdf = new SimpleDateFormat("'[Cliente] 'dd/MM/yyyy H:mm:ss:SSS' -> '");

	public Cliente() {

		mostraConsole("Iniciando o cliente");

		try {

			// Busca pelo naming o objeto remoto. Essa linha já faz a conexão com o 
			// servidor e retorna a referência ao objeto remoto se o encontrar.
			ServicoRMI servico = (ServicoRMI) Naming.lookup("rmi://localhost:1818/SERVICO_RMI");

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