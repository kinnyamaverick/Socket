package br.edu.ifspcaraguatatuba.socket;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StartChat extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  StartChat(){
		
		Font fonte = new Font("Serif", Font.PLAIN, 26);
		JTextField textoParaEnviar = new JTextField();
		textoParaEnviar.setFont(fonte);
		JButton botao = new JButton("Enviar");
		botao.setFont(fonte);
		
		
		Container envio = new JPanel();
		envio.setLayout(new BorderLayout());
		envio.add(BorderLayout.CENTER, textoParaEnviar);
		envio.add(BorderLayout.EAST, botao);
		getContentPane().add(BorderLayout.SOUTH, envio);
		
		
		JTextArea textoRecebido = new JTextArea();
		textoRecebido.setFont(fonte);
		JScrollPane scroll = new JScrollPane(textoRecebido);
		
		getContentPane().add(BorderLayout.CENTER, scroll);
		getContentPane().add(BorderLayout.SOUTH, envio);
		
		
		setTitle("Chat");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		new StartChat();
		
	}

}
