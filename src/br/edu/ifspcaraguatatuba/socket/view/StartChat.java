package br.edu.ifspcaraguatatuba.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.ifspcaraguatatuba.socket.controller.ChatCliente;
import br.edu.ifspcaraguatatuba.socket.controller.ChatServer;


import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartChat extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//=====================================================================================================================================================	
	//==============================================================Atributos==============================================================================
	//=====================================================================================================================================================
	
	private JTextField textoParaEnviar;
	private JTextField textField;
	private JTextArea textoRecebido;
	private JTextArea textArea;
	
	private JButton botao;
	private JTextField txtIp;
	
	
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
			
			//Aqui quando digitar algum texto e aperta a tecla enter irá acionar o botão enviar!!!
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					botao.doClick();
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
		botao = new JButton("Enviar");
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String textoParaEnviar = textField.getText();
					String textoRecebido = textArea.getText();
					textoRecebido += InetAddress.getLocalHost().getHostName() + "->" + "Bem vindo \n";
					textArea.setText(textoRecebido);
					
					textField.setText(null);
					textField.setCaretPosition(0);
					
				} catch (Exception e) {
					e.getMessage();
				} 
				
			
			}
		});
		botao.setBounds(487, 468, 101, 34);
		getContentPane().add(botao);
		botao.setFont(fonte);
	
		
		JButton btnConect = new JButton("Conectar");
		btnConect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChatServer ChatServer = new ChatServer();
							
			}
		});
		btnConect.setBounds(497, 435, 91, 22);
		getContentPane().add(btnConect);
		
		JFormattedTextField txtPort = new JFormattedTextField();
		txtPort.setBounds(421, 435, 62, 20);
		getContentPane().add(txtPort);
		
		JLabel lblNewLabel = new JLabel("Porta");
		lblNewLabel.setBounds(437, 422, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JFormattedTextField formatxtPortIp = new JFormattedTextField();
		formatxtPortIp.setText("");
		formatxtPortIp.setBounds(118, 435, 71, 20);
		getContentPane().add(formatxtPortIp);
		
		JLabel lblIp = new JLabel("IP");
		lblIp.setBounds(51, 422, 46, 14);
		getContentPane().add(lblIp);
		
		JLabel lblPorta = new JLabel("Porta");
		lblPorta.setBounds(143, 422, 46, 14);
		getContentPane().add(lblPorta);
		
		JButton btnConectIp = new JButton("Conectar");
		btnConectIp.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent x) {
				ChatCliente ChatCliente = new ChatCliente();
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
		
		
		setTitle("Chat");
		setSize(594,529);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		
	}
}