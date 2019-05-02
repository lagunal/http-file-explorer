package com.fileexplorer.rest.io;

import java.io.File;
import java.util.logging.Logger;

import org.apache.commons.io.filefilter.IOFileFilter;

public class FilterCurrentDirDirectories implements IOFileFilter{
	Logger log = Logger.getLogger(this.getClass().getName());
	String currentDir = "/";
	
	public FilterCurrentDirDirectories(String dir) {
		currentDir = dir;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return false;
	}
	
	@Override
	public boolean accept(File file) {
		log.info("File "+ file.getAbsolutePath());
		String absPath = file.getAbsolutePath();
		int absFolders = absPath.split("/").length;
		int folders = currentDir.split("/").length;
		return (folders == absFolders ||  folders == (absFolders-1)) && !file.isFile();
	}
}
