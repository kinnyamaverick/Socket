package br.edu.ifspcaraguatatuba.socket.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

public class ChatCliente {

	private JTextArea txtArea;
	private ServerSocket server;
	private Socket client;
	private String IP;
	private int port;
	
	//=======================================================================================================
	//=============================================Construtor================================================
	//=======================================================================================================
	
	public ChatCliente(String IP, int port) {
		this.IP = IP;
		this.port = port;
	}
	//=======================================================================================================
	//================================================Métodos================================================
	//=======================================================================================================
	public boolean connect () {
		boolean result = true;
		
		try {
			client = new Socket(IP, port);
		} catch (IOException e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
	
	public void sendMessage (String message) throws IOException {
		PrintStream exit = new PrintStream(client.getOutputStream());
		exit.println(message);
	}
	
	public String getIP() {
		return IP;
	}
	
	public void setIP(String iP) {
		IP = iP;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}

	public JTextArea getTxtArea() {
		return txtArea;
	}

	public void setTxtArea(JTextArea txtArea) {
		this.txtArea = txtArea;
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