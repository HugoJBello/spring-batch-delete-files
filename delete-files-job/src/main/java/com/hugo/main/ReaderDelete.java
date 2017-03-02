package com.hugo.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("readerDelete")
public class ReaderDelete implements ItemReader<ArrayList<File>> {

	@Autowired
	private File baseDirectory;

	private int index = 0;

	private static final Log log = LogFactory.getLog(ReaderDelete.class);
	
	private static String fileNamePattern = "example_";

	private ArrayList<File> filesWithPattern = new ArrayList<File>();

	public ArrayList<File> read() throws Exception {
		if (index==0){
			log.info("-------------------");
			for (File file : baseDirectory.listFiles()){
				if (file.getName().startsWith(fileNamePattern)){
					filesWithPattern.add(file);
					log.info("found file:");
					log.info(file.getName());
				}
			}
			index++;
			return filesWithPattern;
		} else {
			return null;
		}
	}

}
