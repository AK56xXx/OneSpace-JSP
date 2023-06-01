package dao;

import java.util.ArrayList;

import models.Announcement;

public interface AnnouncementDAO {
	
	
	public int addAnnoucement(Announcement announcement);

	public int updateAnnouncement(Announcement announcement);

	public Announcement getAnnouncementById(int id);

	public ArrayList<Announcement> getAllAnnouncements();

	public int deleteAnnouncement(int id);
	

}
