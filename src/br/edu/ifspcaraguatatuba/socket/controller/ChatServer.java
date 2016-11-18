package br.edu.ifspcaraguatatuba.socket.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JTextArea;

public class ChatServer {
	
	private Scanner leitor;
	private JTextArea txtArea;
	private int port;
	private String IP;
	
	private ServerSocket server;
	private Socket client;
	
	//====================================================================================================================================
	//=====================================================Construtor=====================================================================
	//====================================================================================================================================
	public ChatServer(JTextArea txtArea, String IP, int port) {
		this.txtArea = txtArea;
		this.IP = IP;
		this.port = port;
	}

	public ChatServer() {}
	//====================================================================================================================================
	//=======================================================Métodos======================================================================
	//====================================================================================================================================
	
	public void connect () throws IOException {
		server = new ServerSocket(port);
	}
	
	public void escutaCliente () {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO implementar thread
				
				try {
					txtArea.append("Aguardando conexão do cliente");
					setClient(server.accept()); // aguarda conexão de um cliente
					
					txtArea.setText(null);
					txtArea.append("Cliente conectado");
					
					
					leitor = new Scanner(client.getInputStream());
					
					while (leitor.hasNextLine())
						txtArea.append("\n" + leitor.nextLine());
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread thread = new Thread(r);
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
		
	}

	public Scanner getLeitor() {
		return leitor;
	}

	public void setLeitor(Scanner leitor) {
		this.leitor = leitor;
	}

	public JTextArea getTxtArea() {
		return txtArea;
	}

	public void setTxtArea(JTextArea txtArea) {
		this.txtArea = txtArea;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public ServerSocket getServer() {
		return server;
	}

	public void setServer(ServerSocket server) {
		this.server = server;
	}

	public Socket getClient() {
		return client;
	}

	public void setClient(Socket client) {
		this.client = client;
	}

}