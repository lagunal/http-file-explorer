package com.fileexplorer.rest.controller;

import java.io.File;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fileexplorer.rest.io.FilterCurrentDirDirectories;
import org.apache.commons.io.FileUtils;

@RestController
public class DirectoryController {
	
	private String currentDirectory = "/files";
	private FilterCurrentDirDirectories filterDir;
	
	@GetMapping("/dir/list")
	public Collection<File> listDir(){
		File directory = new File(currentDirectory);
		filterDir = new FilterCurrentDirDirectories(currentDirectory);
		return FileUtils.listFilesAndDirs(directory, filterDir, filterDir);		
	}
	
}
