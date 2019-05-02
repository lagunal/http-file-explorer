package com.fileexplorer.rest.io;

import java.io.File;
import java.util.logging.Logger;

import org.apache.commons.io.filefilter.IOFileFilter;

import com.fileexplorer.test.Main;

public class FilterCurrentDirFileFilter implements IOFileFilter {
	Logger log = Logger.getLogger(FilterCurrentDirFileFilter.class.getName());
	String currentDir = "/";
	
	public FilterCurrentDirFileFilter(String dir) {
		currentDir = dir;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean accept(File file) {
		// TODO Auto-generated method stub
		String absPath = file.getAbsolutePath();
		int folders = currentDir.split("/").length;
		int absFolders = absPath.split("/").length;
		log.info("File "+ file.getAbsolutePath());
		return (folders == absFolders ||  folders == (absFolders-1)) && file.isFile();
	}
}
