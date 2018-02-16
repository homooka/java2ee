package Httpsever;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class httpServer {
	public static void main(String[] args){
         String host = "www.jp.FreeBSD.org";
         int port = 80;
         String path = "/index.html";

         Socket socket;
                 BufferedReader reader;
                  BufferedWriter writer;

         try {
           socket = new Socket(host, port);
             reader =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
             writer =
                 new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            writer.write("GET " + path + " HTTP/1.0\r\n");

            	writer.write("Host: " + host + ":" + port + "\r\n");
           writer.write("\r\n");
            writer.flush();

             while (true){
                String line = reader.readLine();
                 if ( line == null ){
                    break;
                }
               System.out.println(line);
             }
             reader.close();
             writer.close();
             socket.close();

       } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
         }     }
 }

	
