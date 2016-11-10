package br.edu.ifspcaraguatatuba.socket;

import java.awt.TextArea;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTextArea;

public class ChatServer {
	Scanner leitor;
	JTextArea textoRecebido;
	List<PrintWriter> escritores = new ArrayList<>();
	
	public ChatServer(JTextArea text){
		
		this.textoRecebido = text;
		
		ServerSocket server;
		
		try {
			server = new ServerSocket(2000);
			
			while(true){
				
				Socket socket = server.accept();
				System.out.println("Nova conexão com o cliente " + socket.getInetAddress().getHostAddress());
				new Thread(new EscutaCliente(socket)).start();
				PrintWriter p = new PrintWriter(socket.getOutputStream());
				escritores.add(p);
			}
		} catch (IOException e) {
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
	
	public class EscutaCliente implements Runnable{
		
		Scanner leitor;
		public EscutaCliente(Socket socket){
			try{
			leitor = new Scanner(socket.getInputStream());
			}catch(Exception e){
				
			}
		}
		
		@Override
		public void run() {
			try{
			String texto;
		while((texto = leitor.nextLine()) != null ){
			System.out.println(texto);
			textoRecebido.append(texto);
			//encaminharParaTodos(texto);
			}
			}catch(Exception e){
				
			}
		}
		
	}
	
	
	
	/*public static void main(String[] args) {
		new ChatServer();

	}*/

}
