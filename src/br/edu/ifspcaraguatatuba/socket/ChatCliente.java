package br.edu.ifspcaraguatatuba.socket;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField textoParaEnviar;
	Socket socket;
	PrintWriter escritor;
	String nome;
	static JTextArea textoRecebido;
	Scanner leitor;
	List<PrintWriter> escritores = new ArrayList<>();
	
	
	private class lerServidor implements Runnable{

		Scanner leitor;
		public lerServidor(Socket socket){
			try{
			leitor = new Scanner(socket.getInputStream());
			}catch(Exception e){
				
			}
		}
		@Override
		public void run() {
			try{
			String texto;
			while((texto = leitor.nextLine()) != null){
				textoRecebido.append(texto + "\n");
				
			}
			
		}catch(Exception x){
			
		}
			
		}
		
	}
	
	
	public ChatCliente(String nome){
		super("Chat " + nome);
		this.nome = nome;
		
		Font fonte = new Font("Serif", Font.PLAIN, 26);
		textoParaEnviar = new JTextField();
		textoParaEnviar.setFont(fonte);
		JButton botao = new JButton("Enviar");
		botao.setFont(fonte);
		botao.addActionListener(new EnviarListener());
		
		Container envio = new JPanel();
		envio.setLayout(new BorderLayout());
		envio.add(BorderLayout.CENTER, textoParaEnviar);
		envio.add(BorderLayout.EAST, botao);
		getContentPane().add(BorderLayout.SOUTH, envio);
		
		
		textoRecebido = new JTextArea();
		textoRecebido.setFont(fonte);
		JScrollPane scroll = new JScrollPane(textoRecebido);
		
		getContentPane().add(BorderLayout.CENTER, scroll);
		getContentPane().add(BorderLayout.SOUTH, envio);
		
		configurarRede();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	private class EnviarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			escritor.println(nome + " digitou: " + textoParaEnviar.getText());
			escritor.flush();
			textoParaEnviar.setText("");
			textoParaEnviar.requestFocus();
		}
		
	}
	
	private void configurarRede(){
		try{
		socket = new Socket("10.10.112.5", 2001);
		escritor = new PrintWriter(socket.getOutputStream());
		leitor = new Scanner(socket.getInputStream());
		new Thread(new lerServidor(socket)).start();
		}catch(Exception e){
			
			}
		}
	
	private void encaminharParaTodos(String texto){
		for(PrintWriter w : escritores){
			try{
			w.println(texto);
			w.flush();
			}catch(Exception x){
				
			}
		}
	}
	

}
