import java.io.*;
import java.net.*;
class UDPKRClient22 {
 public static void main(String args[]) throws Exception
 { 
   BufferedReader inFromUser=
    new BufferedReader(new InputStreamReader(System.in));
   DatagramSocket clientSocket = new DatagramSocket();                      // For UDP. Note: No port number. There's no connection
   InetAddress IPAddress = InetAddress.getByName("localhost");        // Java represents ip addresses using InetAddress class. Resolving the IP takes place here
   byte[] sendData = new byte[1024];
   byte[] receiveData = new byte[1024];
   String sentence=inFromUser.readLine();
   sendData=sentence.getBytes();
   DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress, 9876);  
   clientSocket.send(sendPacket);
   DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
   clientSocket.receive(receivePacket);
   String modifiedSentence = new String(receivePacket.getData());
   System.out.println("FROM SERVER:"+modifiedSentence);
   clientSocket.close();   
 }
}