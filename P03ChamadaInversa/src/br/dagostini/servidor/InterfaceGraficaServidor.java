package br.dagostini.servidor;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.dagostini.comum.Cliente;
import br.dagostini.comum.Servidor;
import java.awt.Color;
import java.awt.Font;

public class InterfaceGraficaServidor extends JFrame implements Servidor {

	// =======================================================================================
	//
	// Código gerado pelo Window Builder
	//
	// =======================================================================================

	private JPanel contentPane;
	private JTextField txfPorta;
	private JButton buttonIniciarServico;
	private JButton buttonPararServico;
	private JComboBox comboIp;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGraficaServidor frame = new InterfaceGraficaServidor();
					frame.setVisible(true);

					// =======================================================================================
					frame.configurar(); // Só essa chamada não foi feita pelo
										// Window Builder.
					// =======================================================================================

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceGraficaServidor() {
		setTitle("RMI Chat Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("IP");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		comboIp = new JComboBox();
		comboIp.setMinimumSize(new Dimension(200, 24));
		comboIp.setPreferredSize(new Dimension(200, 24));
		GridBagConstraints gbc_comboIp = new GridBagConstraints();
		gbc_comboIp.insets = new Insets(0, 0, 5, 5);
		gbc_comboIp.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboIp.gridx = 1;
		gbc_comboIp.gridy = 0;
		contentPane.add(comboIp, gbc_comboIp);

		JLabel lblNewLabel_1 = new JLabel("Porta");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txfPorta = new JTextField();
		txfPorta.setText("1818");
		txfPorta.setPreferredSize(new Dimension(200, 24));
		txfPorta.setMinimumSize(new Dimension(200, 24));
		GridBagConstraints gbc_txfPorta = new GridBagConstraints();
		gbc_txfPorta.anchor = GridBagConstraints.WEST;
		gbc_txfPorta.insets = new Insets(0, 0, 5, 5);
		gbc_txfPorta.gridx = 1;
		gbc_txfPorta.gridy = 1;
		contentPane.add(txfPorta, gbc_txfPorta);

		buttonIniciarServico = new JButton("Iniciar Serviço");
		GridBagConstraints gbc_buttonIniciarServico = new GridBagConstraints();
		gbc_buttonIniciarServico.anchor = GridBagConstraints.WEST;
		gbc_buttonIniciarServico.insets = new Insets(0, 0, 5, 5);
		gbc_buttonIniciarServico.gridx = 2;
		gbc_buttonIniciarServico.gridy = 1;
		contentPane.add(buttonIniciarServico, gbc_buttonIniciarServico);

		buttonPararServico = new JButton("Parar Serviço");
		GridBagConstraints gbc_buttonPararServico = new GridBagConstraints();
		gbc_buttonPararServico.anchor = GridBagConstraints.WEST;
		gbc_buttonPararServico.insets = new Insets(0, 0, 5, 0);
		gbc_buttonPararServico.gridx = 3;
		gbc_buttonPararServico.gridy = 1;
		contentPane.add(buttonPararServico, gbc_buttonPararServico);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);

		textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 16));
		textArea.setForeground(new Color(50, 205, 50));
		textArea.setBackground(Color.BLACK);
		scrollPane.setViewportView(textArea);
	}

	// =======================================================================================
	//
	// Código complementar
	//
	// =======================================================================================

	/**
	 * Formatador de data para informações no console. Ver:
	 * https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
	 */
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:mm:ss:SSS");

	/**
	 * Contém todos os clientes conectados no servidor.
	 */
	private Map<String, Cliente> mapaClientes = new HashMap<>();

	/**
	 * Referência a esse próprio objeto depois de exportado.
	 */
	private Servidor servidor;

	/**
	 * Registo onde o objeto exportado será buscado pelo nome. É o registro que
	 * escuta na porta TCP/IP.
	 */
	private Registry registry;

	/**
	 * Chamado para fazer as configurações de tela adicionais que não são feitas
	 * no Window Builder.
	 */
	public void configurar() {

		// Botao para parar inicia desabilitado.
		buttonPararServico.setEnabled(false);

		// Configura os ips no combobox.
		List<String> lista = getIpsDisponiveis();
		comboIp.setModel(new DefaultComboBoxModel<String>(new Vector<String>(lista)));
		comboIp.setSelectedIndex(0);

		// Configura o frame para encerrar a aplicação ao clicar no botão fechar
		// (X).
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Configura o frame para avisar os clientes que está sendo fechado.
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				fecharTodosClientes();
			}
		});

		// Configura o botao iniciar servico.
		buttonIniciarServico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciarServico();
			}
		});

		// Configura o botao parar servico.
		buttonPararServico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pararServico();
			}
		});

	}

	protected void iniciarServico() {

		String strPorta = txfPorta.getText().trim();

		if (!strPorta.matches("[0-9]+") || strPorta.length() > 5) {
			JOptionPane.showMessageDialog(this, "A porta deve ser um valor numérico de no máximo 5 dígitos!");
			return;
		}
		int intPorta = Integer.parseInt(strPorta);
		if (intPorta < 1024 || intPorta > 65535) {
			JOptionPane.showMessageDialog(this, "A porta deve estar entre 1024 e 65535");
			return;
		}

		try {

			servidor = (Servidor) UnicastRemoteObject.exportObject(this, 0);
			registry = LocateRegistry.createRegistry(intPorta);
			registry.rebind(Servidor.NOME, servidor);

			mostrar("Serviço iniciado.");

			comboIp.setEnabled(false);
			txfPorta.setEnabled(false);
			buttonIniciarServico.setEnabled(false);

			buttonPararServico.setEnabled(true);

		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(this, "Erro criando registro, verifique se a porta já não está sendo usada.");
			e.printStackTrace();
		}
	}

	/**
	 * Avisa os clientes e encerra as atividades do servidor, mas não fecha a
	 * aplicação.
	 */
	protected void pararServico() {
		mostrar("SERVIDOR PARANDO O SERVIÇO.");

		fecharTodosClientes();

		try {
			UnicastRemoteObject.unexportObject(this, true);
			UnicastRemoteObject.unexportObject(registry, true);

			comboIp.setEnabled(true);
			txfPorta.setEnabled(true);
			buttonIniciarServico.setEnabled(true);

			buttonPararServico.setEnabled(false);

			mostrar("Serviço encerrado.");

		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Desconecta todos os clientes.
	 */
	private void fecharTodosClientes() {
		mostrar("DESCONECTANDO TODOS OS CLIENTES.");
	}

	/**
	 * Busca no sistema todos os ips IPV4, filtrados por expressão regular.
	 * 
	 * @return
	 */
	private List<String> getIpsDisponiveis() {

		List<String> addrList = new ArrayList<String>();
		try {
			Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();

			while (ifaces.hasMoreElements()) {
				NetworkInterface ifc = ifaces.nextElement();
				if (ifc.isUp()) {
					Enumeration<InetAddress> addresses = ifc.getInetAddresses();
					while (addresses.hasMoreElements()) {

						InetAddress addr = addresses.nextElement();

						String ip = addr.getHostAddress();

						if (ip.matches("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}")) {
							addrList.add(ip);
						}

					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}

		return addrList;
	}

	/**
	 * Mostra no TextArea o texto recebido devidamente formatado e com data e
	 * hora.
	 * 
	 * @param string
	 */
	private void mostrar(String string) {
		textArea.append(sdf.format(new Date()));
		textArea.append(" -> ");
		textArea.append(string);
		textArea.append("\n");
	}

	private void atualizarListasDeParticipantes() {
		mostrar("Enviando lista atualizada de participantes para todos.");
		try {
			for (Cliente c : mapaClientes.values()) {
				c.receberListaParticipantes(new ArrayList<String>(mapaClientes.keySet()));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	// =======================================================================================
	//
	// Métodos da implementação da interface.
	//
	// =======================================================================================

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void entrarNoChat(String nome, Cliente cliente) throws RemoteException {

		mostrar(nome + " se conectou.");

		if (mapaClientes.get(nome) != null) {

			mostrar("Retornando erro para tentativa de nome duplicado: " + nome);

			throw new RemoteException("Alguém já está usando o nome: " + nome);
		}

		mapaClientes.put(nome, cliente);

		mostrar(nome + " se conectou.");

		atualizarListasDeParticipantes();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void enviarMensagem(String remetente, String destinatario, String mensagem) throws RemoteException {
		Cliente c = mapaClientes.get(destinatario);
		if (c == null) {
			throw new RemoteException(destinatario + " não se encontra na sala!");
		}

		c.receberMensagemPrivada(remetente, mensagem);

		mostrar(remetente + " envia mensagem privada para " + destinatario);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void enviarMensagemPublica(String remetente, String mensagem) throws RemoteException {

		for (Entry<String, Cliente> e : mapaClientes.entrySet()) {
			if (e.getKey().equals(remetente)) {
				continue;
			} else {
				try {
					e.getValue().receberMensagemPublica(remetente, mensagem);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}

		mostrar(remetente + " fala para todos: " + mensagem);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void sair(String nome) throws RemoteException {
		mapaClientes.remove(nome);
		mostrar(nome + " deixou a sala.");
		atualizarListasDeParticipantes();
	}
}