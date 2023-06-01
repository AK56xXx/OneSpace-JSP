package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Announcement;

public class AnnouncementDAOImpl implements AnnouncementDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public AnnouncementDAOImpl() {
		con = extra.db.DataBaseConnection.getConnected();
	}

	@Override
	public int addAnnoucement(Announcement announcement) {
		try {
			ps = con.prepareStatement("INSERT INTO announcement (title,description,image) Values (?,?,?)");
			ps.setString(1, announcement.getTitle());
			ps.setString(2, announcement.getDescription());
			ps.setBlob(3, announcement.getImage());
			
			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : addAnnouncement " + e);
		}
		return -1;
	}

	@Override
	public int updateAnnouncement(Announcement announcement) {
		try {
			ps = con.prepareStatement("update announcement set title=?,description=?,image=?" + "where id=?");

			ps.setString(1, announcement.getTitle());
			ps.setString(2, announcement.getDescription());
			ps.setBlob(3, announcement.getImage());
			ps.setInt(4, announcement.getId());

			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : updateAnnouncement " + e);
		}
		return -1;
	}

	@Override
	public Announcement getAnnouncementById(int id) {
		try {
			Announcement announcement = new Announcement();
			ps = con.prepareStatement("select * from announcement where id=?");

			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				announcement.setId(rs.getInt(1));
				announcement.setTitle(rs.getString(2));
				announcement.setDescription(rs.getString(3));
				announcement.setImage(rs.getBlob(4));

			}
			return announcement;

		} catch (Exception e) {
			System.out.println("Connection error : getAnnouncementById");
		}

		return null;
	}

	@Override
	public ArrayList<Announcement> getAllAnnouncements() {
		try {

			ArrayList<Announcement> list = new ArrayList<Announcement>();
			ps = con.prepareStatement("SELECT * from announcement order by posted_at desc");
			rs = ps.executeQuery();
			while (rs.next()) {
				Announcement announcement = new Announcement();
				
				announcement.setId(rs.getInt(1));
				announcement.setTitle(rs.getString(2));
				announcement.setDescription(rs.getString(3));
				announcement.setImage(rs.getBlob(4));
				announcement.setPostedAt(rs.getString(5));
				
				list.add(announcement);
			}

			return list;

		} catch (Exception e) {
			System.out.println("Connection error : getAllAnnouncements");
		}

		return null;
	}

	@Override
	public int deleteAnnouncement(int id) {
		try {
			ps = con.prepareStatement("DELETE from announcement where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : deleteAnnouncement " + e);
		}
		return -1;
	}

}
