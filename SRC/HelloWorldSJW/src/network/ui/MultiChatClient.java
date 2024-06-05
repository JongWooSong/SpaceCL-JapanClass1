package network.ui;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;

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
			BufferedOutputStream bos = new BufferedOutputStream(os);
			byte[] bytes = msg.getBytes();
			bos.write(bytes);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}//end method
	
	
	
	
}
