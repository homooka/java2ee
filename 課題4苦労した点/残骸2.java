package Httpsever;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Kadai1Server {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(3838, 5);
            while(true){
                System.out.println("サーバーは稼働しています。");
                Socket socket = server.accept();
                PrintWriter output = new PrintWriter(socket.getOutputStream());
                output.println("こんにちは！こちらはサーバーです！");
                output.close();     // PrintWriterはclose()で閉じるのが基本
                socket.close();     // Socketはclose()で閉じるのが基本
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}