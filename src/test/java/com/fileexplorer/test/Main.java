package com.fileexplorer.test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.junit.Test;

import com.fileexplorer.rest.io.FilterCurrentDirDirectories;
import com.fileexplorer.rest.io.FilterCurrentDirFileFilter;

import ch.qos.logback.core.util.FileUtil;

public class Main {
	Logger log = Logger.getLogger(Main.class.getName());
	
	@Test
	public void test() throws IOException {
		//having a folder
		//read directories and show files
		String currentDir = "/Users/alx";
		File dir = new File(currentDir);
		log.log(Level.INFO, "reading "+dir);
		MyWalker walker = new MyWalker();
//		Collection<File> files = walker.walkIn((dir));
//		Collection<File> files = FileUtils.listFiles((dir), TrueFileFilter.INSTANCE, null);
		
		Collection<File> files = FileUtils.listFilesAndDirs(dir, 
				new FilterCurrentDirFileFilter(currentDir), 
				new FilterCurrentDirDirectories(currentDir));
		
		files.forEach((file)->{
			System.out.println(file.getAbsolutePath());			
		});
		
		String fileToRead = "/Users/alx/soapui-settings.xml";
		String fileContent = FileUtils.readFileToString(new File(fileToRead), Charset.forName("UTF-8"));
		System.out.println("File: "+ fileToRead + " \n contents: "+ fileContent);
		
	}
	
}

class MyWalker extends DirectoryWalker<File>{
	
	@Override
	protected void handleFile(File file, int depth, Collection<File> results) throws IOException {
		if(depth < 5 && file.getName().endsWith("*.pdf"))
		results.add(file);
	}
	
	public Collection<File> walkIn(File f) throws IOException {
		// TODO Auto-generated method stub
		List<File> results = new ArrayList<>();
		walk(f, results);
		return results;
	}

	@Override
	protected boolean handleDirectory(File directory, int depth, Collection<File> results) throws IOException {
		// TODO Auto-generated method stub
		return true;
	}
	
}

