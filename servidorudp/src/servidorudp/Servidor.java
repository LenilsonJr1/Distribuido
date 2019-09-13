

import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.DatagramPacket;
import java.io.IOException;
import java.net.InetAddress;
public class Servidor {
	
 static int porta = 8888;
 
	 public static void main(String a[]){
		 try{
			 DatagramSocket soquete = new DatagramSocket(porta,InetAddress.getByName("0.0.0.0"));
			 
		
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
