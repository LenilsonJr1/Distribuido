package serviodorudp;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;
public class Cliente {
 static byte[] mensagem = "Num ninho de mafagafos há sete mafagafinhos. Quando a mafagafa gafa, gafam os sete mafagafinhos.".getBytes();
 static int porta = 8888;
	 public static void main(String a[]){
		 try{
			 
			 DatagramSocket soquete = new DatagramSocket();
			 DatagramPacket dp = new DatagramPacket(mensagem, mensagem.length,InetAddress.getByName("177.89.66.126"), porta);
			 System.out.println(mensagem.length);
			 soquete.send(dp);
			 soquete.close();
			 
		 }catch(SocketException se){
			 se.printStackTrace();
		 }catch(UnknownHostException uhe){
			 uhe.printStackTrace();
		 }catch(IOException ioe){
			 ioe.printStackTrace();
		 }
	 }
}