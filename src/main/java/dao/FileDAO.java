package dao;

import java.util.ArrayList;

import models.File;

public interface FileDAO {
	
	public int addFile(File file);

	public int updateFile(File file);

	public File getFileById(int id);

	public ArrayList<File> getAllFiles();

	public int deleteFile(int id);

}
