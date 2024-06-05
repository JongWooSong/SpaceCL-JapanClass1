package network.ui;

import java.net.Socket;

public class MultiChatClient {

	private ChatView mChatView;
	private Socket mSocket;
	
	public MultiChatClient(ChatView chatView) {
		mChatView = chatView;
		
		try {
			mSocket = new Socket( mChatView.mIp, 9999 );
			String msg = "서버에 접속 되었다." + mSocket.isConnected();
			mChatView.mJta.append(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
