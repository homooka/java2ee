package echoサーバー;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class EchoSever {

    private static final int BUFSIZE = 32; // 受信バッファサイズ

    public static void main(String[] args) throws IOException {

	    int servPort = 5000;
		// サーバソケットの作成
	    ServerSocket servSock = new ServerSocket(servPort);

		int recvMsgSize; // 受信メッセージサイズ
		byte[] receiveBuf = new byte[BUFSIZE]; // 受信バッファ

		// クライアントからの接続を待ち受けるループ
		while (true) {
			Socket clntSock = servSock.accept(); // クライアントの接続を取得
			SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
			System.out.println("接続中：" + clientAddress);

			InputStream in = clntSock.getInputStream();
			OutputStream out = clntSock.getOutputStream();

			while ((recvMsgSize = in.read(receiveBuf)) != -1) {
				out.write(receiveBuf, 0, recvMsgSize);
			}
			clntSock.close();
		}
		// 到達不能コード
	}
}
