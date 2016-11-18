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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.ifspcaraguatatuba.socket.controller.ChatCliente;
import br.edu.ifspcaraguatatuba.socket.controller.ChatServer;

public class StartChat extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//=====================================================================================================================================================	
	//==============================================================Atributos==============================================================================
	//=====================================================================================================================================================
	
	private JTextField textoParaEnviar;
	private JTextField txtIp;
	private JTextField txtPort;
	private JTextField txtPortIp;
	private JTextArea textoRecebido;
	
	private JButton btnEnviarMsg;
	private JButton btnConectIp;
	private JButton btnConect;
	
	private ChatCliente client;
	private ChatServer server;
	
	
	//=====================================================================================================================================================	
	//=============================================================Construtor==============================================================================
	//=====================================================================================================================================================
	
	public StartChat() {
		initComponent();
	}
	
	//=====================================================================================================================================================	
	//===============================================================Métodos===============================================================================
	//=====================================================================================================================================================

	public void initComponent (){
		
		Font fonte = new Font("Serif", Font.PLAIN, 26);
		getContentPane().setLayout(null);
		textoParaEnviar = new JTextField();
		textoParaEnviar.setFont(fonte);
		textoParaEnviar.addKeyListener (new KeyAdapter() {
			// Aqui quando digitar algum texto e aperta a tecla 'enter' irá acionar o botão enviar!!!
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnEnviarMsg.doClick();
				}
				
			}
			
		});
		
		Container envio = new JPanel();
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
		btnEnviarMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
		btnConect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// TODO criar lógica para quando o cliente inicia a conexão
				
				String IP = txtIp.getText();
				int port = Integer.parseInt(txtPort.getText());
				
				server = new ChatServer(textoRecebido, IP, port);
				try {
					server.connect();
					server.escutaCliente();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				setComponents();
				
			}
		});
		btnConect.setBounds(497, 435, 91, 22);
		getContentPane().add(btnConect);
		
		JLabel lblNewLabel = new JLabel("Porta");
		lblNewLabel.setBounds(437, 422, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblIp = new JLabel("IP");
		lblIp.setBounds(51, 422, 46, 14);
		getContentPane().add(lblIp);
		
		JLabel lblPorta = new JLabel("Porta");
		lblPorta.setBounds(143, 422, 46, 14);
		getContentPane().add(lblPorta);
		
		btnConectIp = new JButton("Conectar");
		btnConectIp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {
				// TODO criar lógica para quando se conectar em um servidor
				String IP = txtIp.getText();
				int port = Integer.parseInt(txtPortIp.getText());
				
				client = new ChatCliente(IP, port);
				client.connect();
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
		getContentPane().add(txtIp);
		txtIp.setColumns(10);
		
		txtPort = new JTextField();
		txtPort.setBounds(408, 435, 86, 20);
		getContentPane().add(txtPort);
		txtPort.setColumns(10);
		
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
	
	public void setComponents () {
		txtIp.setEnabled(false);
		txtPortIp.setEnabled(false);
		txtPort.setEnabled(false);
		btnConect.setEnabled(false);
		btnConectIp.setEnabled(false);
		textoParaEnviar.setEnabled(true);
		btnEnviarMsg.setEnabled(true);
	}
}