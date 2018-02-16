package Httpsever;



import java.net.InetAddress;
import java.net.UnknownHostException;

public class IP {
  public static void main(String[] args) {
    // ローカルホスト名とIPアドレスを取得
    try {
      InetAddress addr = InetAddress.getLocalHost();
      InetAddress addr2 = InetAddress.getLocalHost();
      if (addr.equals(addr2)) System.out.println("addrとaddr2は同じインスタンス");
      System.out.println("Local Host Name: " + addr.getHostName());
      System.out.println("IP Address     : " + addr.getHostAddress());
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }
}
