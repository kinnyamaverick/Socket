package br.edu.ifspcaraguatatuba.socket.view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
<<<<<<< HEAD
=======
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
>>>>>>> upstream/master

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.ifspcaraguatatuba.socket.controller.ChatCliente;
import br.edu.ifspcaraguatatuba.socket.controller.ChatServer;
<<<<<<< HEAD
=======
import br.edu.ifspcaraguatatuba.socket.controller.ChatCliente.lerServidor;
import br.edu.ifspcaraguatatuba.socket.controller.ChatServer.EscutaCliente;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
>>>>>>> upstream/master

public class StartChat extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//=====================================================================================================================================================	
	//==============================================================Atributos==============================================================================
	//=====================================================================================================================================================
	
	private Container envio;
	
	private JTextField textoParaEnviar;
	private JTextField txtPort;
	private JTextField txtPortIp;
	private JTextField txtIp;
	
	private JTextArea textoRecebido;
	
<<<<<<< HEAD
	private JButton btnEnviarMsg;
	private JButton btnConect;
	private JButton btnConectIp;
	
	private ChatServer server;
	private ChatCliente client;
=======
	private JButton botao;
	private JTextField txtIp;
	private JTextField txtPorta;
>>>>>>> upstream/master
	
	
	//=====================================================================================================================================================	
	//=============================================================Construtor==============================================================================
	//=====================================================================================================================================================
	
	public StartChat() {
		initComponent();
	}
	
	//=====================================================================================================================================================	
	//===============================================================Métodos===============================================================================
	//=====================================================================================================================================================

	public void initComponent () {
		
		Font fonte = new Font("Serif", Font.PLAIN, 26);
		getContentPane().setLayout(null);
		textoParaEnviar = new JTextField();
		textoParaEnviar.setEnabled(false);
		textoParaEnviar.setFont(fonte);
		textoParaEnviar.addKeyListener (new KeyAdapter() {
			
<<<<<<< HEAD
			// Aqui quando digitar algum texto e aperta a tecla enter irá acionar o botão enviar!!!
=======
			//Aqui quando digitar algum texto e aperta a tecla 'enter' irá acionar o botão enviar!!!
>>>>>>> upstream/master
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnEnviarMsg.doClick();
				}
			}
			
		});
		
		
		envio = new JPanel();
		envio.setBounds(0, 468, 492, 34);
		envio.setLayout(new BorderLayout());
		envio.add(BorderLayout.CENTER, textoParaEnviar);
		getContentPane().add(BorderLayout.SOUTH, envio);
		
		
		
		textoRecebido = new JTextArea();
		textoRecebido.setEditable(false);
		textoRecebido.setFont(fonte);
		JScrollPane scroll = new JScrollPane(textoRecebido);
		scroll.setBounds(0, 0, 588, 398);
		
		getContentPane().add(scroll);
		getContentPane().add(BorderLayout.SOUTH, envio);
		btnEnviarMsg = new JButton("Enviar");
		btnEnviarMsg.setEnabled(false);
		btnEnviarMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // Botão de enviar mensagem
				// TODO criar lógica para enviar mensagem
				String message = textoParaEnviar.getText();
				
				try {
					client.sendMessage(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				textoParaEnviar.setText(null);
			}
		});
		btnEnviarMsg.setBounds(487, 468, 101, 34);
		getContentPane().add(btnEnviarMsg);
		btnEnviarMsg.setFont(fonte);
	
		
		btnConect = new JButton("Conectar");
		btnConect.addActionListener(new ActionListener() { // Botão para criar conexão de servidor.
			public void actionPerformed(ActionEvent arg0) {
<<<<<<< HEAD
				// TODO criar lógica para criar um servidor
				
				int port = Integer.parseInt(txtPort.getText());
				String IP = txtIp.getText();
				
				server = new ChatServer(textoRecebido, IP, port);
				
				try {
					server.connect();
					server.escutaCliente();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				setComponents();
=======
				
				ChatServer();
		
					
					
				
							
>>>>>>> upstream/master
			}
		});
		btnConect.setBounds(497, 435, 91, 22);
		getContentPane().add(btnConect);
		
<<<<<<< HEAD
		txtPort = new JTextField();
		txtPort.setBounds(421, 435, 62, 20);
		getContentPane().add(txtPort);
		
=======
>>>>>>> upstream/master
		JLabel lblNewLabel = new JLabel("Porta");
		lblNewLabel.setBounds(437, 422, 46, 14);
		getContentPane().add(lblNewLabel);
		
<<<<<<< HEAD
		txtPortIp = new JTextField();
		txtPortIp.setText("");
		txtPortIp.setBounds(118, 435, 71, 20);
		getContentPane().add(txtPortIp);
		
=======
>>>>>>> upstream/master
		JLabel lblIp = new JLabel("IP");
		lblIp.setBounds(51, 422, 46, 14);
		getContentPane().add(lblIp);
		
		JLabel lblPorta = new JLabel("Porta");
		lblPorta.setBounds(143, 422, 46, 14);
		getContentPane().add(lblPorta);
		
		btnConectIp = new JButton("Conectar");
		btnConectIp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {
<<<<<<< HEAD
				// TODO criar lógica para conectar em um servidor
				
				String IP = txtIp.getText();
				int port = Integer.parseInt(txtPortIp.getText());
				
				client = new ChatCliente(IP, port);
				client.connect();
				
				setComponents();
=======
				configurarRede();
				
>>>>>>> upstream/master
			}
		});
		btnConectIp.setBounds(199, 434, 91, 23);
		getContentPane().add(btnConectIp);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(255, 255, 255));
		canvas.setBounds(346, 398, 3, 66);
		getContentPane().add(canvas);
		
		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setBounds(468, 400, 71, 14);
		getContentPane().add(lblServidor);
		
		txtIp = new JTextField();
		txtIp.setBounds(0, 435, 107, 20);
		txtIp.setColumns(10);
		getContentPane().add(txtIp);
		
		txtPorta = new JTextField();
		txtPorta.setBounds(408, 435, 86, 20);
		getContentPane().add(txtPorta);
		txtPorta.setColumns(10);
		
		txtPortIp = new JTextField();
		txtPortIp.setBounds(132, 435, 57, 20);
		getContentPane().add(txtPortIp);
		txtPortIp.setColumns(10);
		
		
		setTitle("Chat");
		setSize(594,529);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	}
<<<<<<< HEAD
	
	public void setComponents () {
		txtIp.setEnabled(false);
		txtPortIp.setEnabled(false);
		txtPort.setEnabled(false);
		btnConect.setEnabled(false);
		btnConectIp.setEnabled(false);
		textoParaEnviar.setEnabled(true);
		btnEnviarMsg.setEnabled(true);
	}
	
=======
//-------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------
								//Cliente
	
	
	Socket socket;
	PrintWriter escritor;
	String nome;
	Scanner leitor;
	List<PrintWriter> escritores = new ArrayList<>();
	private JTextField txtPortIp;

	public class lerServidor implements Runnable {

		Scanner leitor;

		public lerServidor(Socket socket) {
			try {
				leitor = new Scanner(socket.getInputStream());
			} catch (Exception e) {

			}
		}

		@Override
		public void run() {
			try {
				String texto;
				while ((texto = leitor.nextLine()) != null) {
					textoRecebido.append(texto + "\n");

				}

			} catch (Exception x) {

			}

		}

	}


	private class EnviarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			escritor.println(nome + " digitou: " + textoParaEnviar.getText());
			escritor.flush();
			textoParaEnviar.setText("");
			textoParaEnviar.requestFocus();
		}

	}

	private void configurarRede() {
		
		String IP = txtIp.getText(); 
		int port = Integer.parseInt(txtPortIp.getText());
		
		try {
			socket = new Socket(IP, port);
			escritor = new PrintWriter(socket.getOutputStream());
			leitor = new Scanner(socket.getInputStream());
			new Thread(new lerServidor(socket)).start();
		} catch (Exception e) {

		}
	}
	//-------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------
	
								//Servidor
	
	
	
public void ChatServer() {

		
		int port = Integer.parseInt(txtPorta.getText());
		ServerSocket server;
		
		
		
		
		
		try {
			
			
			server = new ServerSocket(port);

			while (true) {
				System.out.println("Esperando conexção com o cliente");
				Socket socket = server.accept();
				System.out.println("Nova conexão com o cliente " + socket.getInetAddress().getHostAddress());
				new Thread(new EscutaCliente(socket)).start();
				PrintWriter p = new PrintWriter(socket.getOutputStream());
				escritores.add(p);
			}
		} catch (IOException e) {
		}
	}

	public class EscutaCliente implements Runnable {

		Scanner leitor;

		public EscutaCliente(Socket socket) {
			try {
				leitor = new Scanner(socket.getInputStream());
			} catch (Exception e) {

			}
		}

		@Override
		public void run() {
			try {
				String texto;
				while ((texto = leitor.nextLine()) != null) {
					System.out.println(texto);
					textoRecebido.append(texto);

				}
			} catch (Exception e) {

			}
		}

	}
>>>>>>> upstream/master
}