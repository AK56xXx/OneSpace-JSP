package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Message;
import models.Message;

public class MessageDAOImpl implements MessageDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public MessageDAOImpl() {
		con = extra.db.DataBaseConnection.getConnected();
	}

	@Override
	public int addMessage(Message message) {
		try {
			ps = con.prepareStatement("INSERT INTO message (sender_id,receiver_id,message) Values (?,?,?)");
			
			ps.setInt(1, message.getSender());
			ps.setInt(2, message.getReceiver());
			ps.setString(3, message.getMessage());
			
			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : addMessage " + e);
		}
		return -1;
	}
	
	
	

	@Override
	public ArrayList<Message> getAllMessagesBySenderAndReceiver(int sender, int receiver) {
		 try {
		        ArrayList<Message> list = new ArrayList<Message>();
		        ps = con.prepareStatement("SELECT distinct * FROM message WHERE (sender_id=? AND receiver_id=?) OR (sender_id=? AND receiver_id=?) ORDER BY posted_at ASC");

		        ps.setInt(1, sender);
		        ps.setInt(2, receiver);
		        ps.setInt(3, receiver);
		        ps.setInt(4, sender);
		        rs = ps.executeQuery();

		        while (rs.next()) {
		            Message message = new Message();

		            message.setId(rs.getInt(1));
		            message.setSender(rs.getInt(2));
		            message.setReceiver(rs.getInt(3));
		            message.setMessage(rs.getString(4));
		            message.setPosted_at(rs.getString(5));

		            list.add(message);
		        }
		        return list;
		    } catch (Exception e) {
		        System.out.println("Connection error: getAllMessagesBySenderAndReceiver");
		        e.printStackTrace();
		    }

		    return null;
	}

	@Override
	public Message getMessageBySender(int senderId, int msgId) {
		try {
			Message message = new Message();
			ps = con.prepareStatement("select * from message where sender_id=? and id=?");

			ps.setInt(1, senderId);
			ps.setInt(2, msgId);

			rs = ps.executeQuery();

			if (rs.next()) {

				message.setId(rs.getInt(1));
				message.setSender(rs.getInt(2));
				message.setReceiver(rs.getInt(3));
				message.setMessage(rs.getString(4));
				message.setPosted_at(rs.getString(5));
			

			}
			return message;

		} catch (Exception e) {
			System.out.println("Connection error : getMessageBySender");
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Message getMessageByReceiver(int receiverId, int msgId) {
		try {
			Message message = new Message();
			ps = con.prepareStatement("select * from message where receiver_id=? and id=?");

			ps.setInt(1, receiverId);
			ps.setInt(2, msgId);

			rs = ps.executeQuery();

			if (rs.next()) {

				message.setId(rs.getInt(1));
				message.setSender(rs.getInt(2));
				message.setReceiver(rs.getInt(3));
				message.setMessage(rs.getString(4));
				message.setPosted_at(rs.getString(5));
			

			}
			return message;

		} catch (Exception e) {
			System.out.println("Connection error : getMessageByReceiver");
		}

		return null;
	}

}
