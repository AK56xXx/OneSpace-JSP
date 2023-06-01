package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.File;

public class FileDAOImpl implements FileDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public FileDAOImpl() {
		con = extra.db.DataBaseConnection.getConnected();
	}

	@Override
	public int addFile(File file) {
		try {
			ps = con.prepareStatement("INSERT INTO file (name,path) Values (?,?)");
			
			ps.setString(1, file.getName());
			ps.setBlob(2, file.getPath());

			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : addFile " + e);
		}
		return -1;
	}

	@Override
	public int updateFile(File file) {
		try {
			ps = con.prepareStatement("update file set name=?,path=?" + "where id=?");

			ps.setString(1, file.getName());

			ps.setBlob(2, file.getPath());
			
			ps.setInt(3, file.getId());

			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : updateFile " + e);
		}
		return -1;
	}

	@Override
	public File getFileById(int id) {
		try {
			File file = new File();
			ps = con.prepareStatement("select * from file where id=?");

			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				file.setId(rs.getInt(1));
				file.setName(rs.getString(2));
				file.setPath(rs.getBlob(3));
				file.setAddedAt(rs.getString(4));

			}
			return file;

		} catch (Exception e) {
			System.out.println("Connection error : getFileById");
		}

		return null;
	}

	@Override
	public ArrayList<File> getAllFiles() {
		try {
			ArrayList<File> list = new ArrayList<File>();
			ps = con.prepareStatement("select * from file");

			rs = ps.executeQuery();

			while (rs.next()) {
				
				File file = new File();
				file.setId(rs.getInt(1));
				file.setName(rs.getString(2));
				file.setPath(rs.getBlob(3));
				file.setAddedAt(rs.getString(4));
				
				list.add(file);

			}
			return list;

		} catch (Exception e) {
			System.out.println("Connection error : getAllFiles");
		}

		return null;
	}

	@Override
	public int deleteFile(int id) {
		try {
			ps = con.prepareStatement("DELETE from file where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : deleteFile " + e);
		}
		return -1;
	}

}
