package serviodorudp;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.DatagramPacket;
import java.io.IOException;
import java.net.InetAddress;

public class svMain {

	public static void main(String[] args) {
	

		 int porta = 8181;

			
				 try{
					 DatagramSocket soquete = new DatagramSocket(porta);
					
					 byte buffer[] = new byte[85536];
					 DatagramPacket datagrama = new DatagramPacket(buffer, buffer.length);
					 System.out.println("Aguardando solicitacoes");
					
					 long start = System.currentTimeMillis();
					 soquete.receive(datagrama);
					 
					 System.out.println("A mensagem recebida é : " + (new String(datagrama.getData()).trim()) + 
							 " , o tamanho é : " + datagrama.getLength());
					 
					 soquete.close();
					 long fim = System.currentTimeMillis() ;
					 long tempoDif =   fim -  start;
					 
					 System.out.println("E o tempo gasto foi : " + tempoDif /  1000 + " Segundos");
					 
				 }catch(SocketException se){
					 se.printStackTrace();
				 }catch(IOException ioe){
					 ioe.printStackTrace();
				 }
	}

}
