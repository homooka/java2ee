package Httpsever;
import java.net.Socket;
import java.util.Scanner;
public class Kadai1Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 3838);          // localhost server を使用
            Scanner input = new Scanner(socket.getInputStream());
            System.out.println("サーバーからのメッセージは「" + input.nextLine() + "」");
            input.close();          // Scannerはclose()で閉じるのが基本
            socket.close();         // Socketはclose()で閉じるのが基本
        } catch (Exception e){
            System.out.println(e);
        }
    }
}