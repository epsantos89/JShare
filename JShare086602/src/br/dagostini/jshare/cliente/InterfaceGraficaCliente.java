package br.dagostini.jshare.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.dagostini.jshare.comum.pojos.Arquivo;
import br.dagostini.jshare.comun.Cliente;
import br.dagostini.jshare.comun.IServer;

import java.awt.GridBagLayout;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class InterfaceGraficaCliente extends JFrame implements IServer {

	// =======================================================================================
	//
	// Código gerado pelo Window Builder
	//
	// =======================================================================================

	private JPanel contentPane;
	private JTextField txfIp;
	private JTextField txfPorta;
	private JTextField txfMensagem;
	private JButton buttonDesconectar;
	private JButton buttonConectar;
	private JList listParticipantes;
	private JTextArea textArea;
	private JLabel lblNome;
	private JTextField txfMeuNome;
	private JButton buttonEnviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGraficaCliente frame = new InterfaceGraficaCliente();
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
	public InterfaceGraficaCliente() {
		setTitle("RMI Chat Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		txfMensagem = new JTextField();
		GridBagConstraints gbc_txfMensagem = new GridBagConstraints();
		gbc_txfMensagem.insets = new Insets(0, 0, 0, 5);
		gbc_txfMensagem.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfMensagem.gridx = 0;
		gbc_txfMensagem.gridy = 0;
		panel.add(txfMensagem, gbc_txfMensagem);
		txfMensagem.setColumns(10);

		buttonEnviar = new JButton("Enviar");
		GridBagConstraints gbc_buttonEnviar = new GridBagConstraints();
		gbc_buttonEnviar.gridx = 1;
		gbc_buttonEnviar.gridy = 0;
		panel.add(buttonEnviar, gbc_buttonEnviar);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		panel_1.add(lblNome, gbc_lblNome);

		txfMeuNome = new JTextField();
		GridBagConstraints gbc_txfMeuNome = new GridBagConstraints();
		gbc_txfMeuNome.gridwidth = 3;
		gbc_txfMeuNome.insets = new Insets(0, 0, 5, 5);
		gbc_txfMeuNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfMeuNome.gridx = 1;
		gbc_txfMeuNome.gridy = 0;
		panel_1.add(txfMeuNome, gbc_txfMeuNome);
		txfMeuNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Endereço IP");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		txfIp = new JTextField();
		txfIp.setText("127.0.0.1");
		GridBagConstraints gbc_txfIp = new GridBagConstraints();
		gbc_txfIp.insets = new Insets(0, 0, 0, 5);
		gbc_txfIp.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfIp.gridx = 1;
		gbc_txfIp.gridy = 1;
		panel_1.add(txfIp, gbc_txfIp);
		txfIp.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Porta");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txfPorta = new JTextField();
		txfPorta.setText("1818");
		GridBagConstraints gbc_txfPorta = new GridBagConstraints();
		gbc_txfPorta.insets = new Insets(0, 0, 0, 5);
		gbc_txfPorta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfPorta.gridx = 3;
		gbc_txfPorta.gridy = 1;
		panel_1.add(txfPorta, gbc_txfPorta);
		txfPorta.setColumns(10);

		buttonConectar = new JButton("Conectar");
		GridBagConstraints gbc_buttonConectar = new GridBagConstraints();
		gbc_buttonConectar.insets = new Insets(0, 0, 0, 5);
		gbc_buttonConectar.gridx = 4;
		gbc_buttonConectar.gridy = 1;
		panel_1.add(buttonConectar, gbc_buttonConectar);

		buttonDesconectar = new JButton("Desconectar");
		GridBagConstraints gbc_buttonDesconectar = new GridBagConstraints();
		gbc_buttonDesconectar.gridx = 5;
		gbc_buttonDesconectar.gridy = 1;
		panel_1.add(buttonDesconectar, gbc_buttonDesconectar);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(10);
		contentPane.add(splitPane, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);

		listParticipantes = new JList();
		scrollPane.setViewportView(listParticipantes);

		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);

		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		splitPane.setDividerLocation(150);
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
	 * Referência ao servidor.
	 */
	private IServer servidor;

	/**
	 * Referência a esse próprio objeto depois de exportado, passado para o
	 * servidor.
	 */
	private Cliente cliente;

	/**
	 * Registo onde o objeto exportado será buscado pelo nome. É o registro que
	 * escuta na porta TCP/IP, aberto no servidor.
	 */
	private Registry registry;

	/**
	 * Meu nome, variável iniciada ao conectar no servidor.
	 */
	private String meunome;

	
	/**
	 * Usado só para os testes.
	 * 
	 * @param string
	 * @param i
	 */
	public void configurarAuto(String string, int i) {

		configurar();
		txfMeuNome.setText(string);
		int x = 0;
		int y = 0 + (i * 240);
		setBounds(x, y, 640, 240);
		
	}

	
	protected void configurar() {

		buttonConectar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conectar();
			}
		});

		buttonDesconectar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		buttonEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		txfMensagem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				}
			}
		});

		listParticipantes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					if (e.getClickCount() == 2) {
						int sel = listParticipantes.getSelectedIndex();
						if (sel == -1) {
							return;
						}
						String nome = "/" + (String) listParticipantes.getModel().getElementAt(sel) + ":";

						if (txfMensagem.getText().startsWith(nome)) {
							return;
						}

						if (txfMensagem.getText().startsWith("/") && txfMensagem.getText().contains(":")) {

							String msg = txfMensagem.getText().trim();

							String mensagem = msg.substring(msg.indexOf(':') + 1);

							txfMensagem.setText(nome + mensagem);

						} else {
							String msg = txfMensagem.getText().trim();
							txfMensagem.setText(nome + msg);
						}

					}
				}
			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			}
		});
	}

	/**
	 * Conecta no servidor.
	 */
	protected void conectar() {

		meunome = txfMeuNome.getText().trim();
		if (meunome.length() == 0) {
			JOptionPane.showMessageDialog(this, "Você precisa digitar um nome!");
			return;
		}

		// Endereço IP
		String host = txfIp.getText().trim();
		if (!host.matches("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}")) {
			JOptionPane.showMessageDialog(this, "O endereço ip parece inválido!");
			return;
		}

		// Porta
		String strPorta = txfPorta.getText().trim();
		if (!strPorta.matches("[0-9]+") || strPorta.length() > 5) {
			JOptionPane.showMessageDialog(this, "A porta deve ser um valor numérico de no máximo 5 dígitos!");
			return;
		}
		int intPorta = Integer.parseInt(strPorta);

		// Iniciando objetos para conexão.
		try {
			registry = LocateRegistry.getRegistry(host, intPorta);

			servidor = (IServer) registry.lookup(IServer.NOME_SERVICO);

			// Avisando o servidor que está entrando no Chat.
			
			Cliente c = new Cliente();
			c.setIp(txfIp.getText());
			c.setNome(txfMeuNome.getText());
			c.setPorta(intPorta);
			 
			servidor.registrarCliente(c);

			buttonDesconectar.setEnabled(true);

			buttonConectar.setEnabled(false);
			txfMeuNome.setEnabled(false);
			txfIp.setEnabled(false);
			txfPorta.setEnabled(false);

			buttonConectar.setEnabled(false);
			buttonEnviar.setEnabled(true);
			txfMensagem.setEnabled(true);

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Desconecta do servidor.
	 */


	
	private void mostrar(String string) {
		textArea.append(sdf.format(new Date()));
		textArea.append(" -> ");
		textArea.append(string);
		textArea.append("\n");
	}

	@Override
	public void registrarCliente(Cliente c) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void publicarListaArquivos(Cliente c, List<Arquivo> lista) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Cliente, List<Arquivo>> procurarArquivo(String nome) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] baixarArquivo(Arquivo arq) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desconectar(Cliente c) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	// =======================================================================================
	//
	// Métodos da implementação da interface.
	//
	// =======================================================================================


	

}
