package network.ui;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class MultiChatClient {

	private ChatView mChatView;
	private Socket mSocket;
	
	public MultiChatClient(ChatView chatView) {
		mChatView = chatView;
		
		try {
			mSocket = new Socket( mChatView.mIp, 9999 );
			String msg = "서버에 접속 되었다." + mSocket.isConnected();
			mChatView.mJta.append(msg + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//서버로 메시지 전송
	public void sendMsg(String msg) {
		try {
			OutputStream os = mSocket.getOutputStream();
			System.out.println( new Date() + " ==> " + "클라이언트가 서버로 메시지를 송신 합니다.");
			BufferedOutputStream bw = new BufferedOutputStream( os );
			bw.write( msg.getBytes() );
			bw.flush();//즉시전송 
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}//end method
	
	
	
	
}
