package dao;

import java.util.ArrayList;

import models.Message;
import models.Post;

public interface MessageDAO {
	
	public int addMessage(Message message);

	public ArrayList<Message> getAllMessagesBySenderAndReceiver(int sender, int receiver);
	
	public Message getMessageBySender(int senderId, int msgId);
	
	public Message getMessageByReceiver(int receiverId, int msgId);


}
