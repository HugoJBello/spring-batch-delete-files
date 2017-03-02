package com.hugo.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.io.File;


/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
@Component("writerDelete")
public class WriterDelete implements ItemWriter<ArrayList<File>> {

	private static final Log log = LogFactory.getLog(WriterDelete.class);
	
	/**
	 * @see ItemWriter#write(java.util.List)
	 */
	public void write(List<? extends ArrayList<File>> data) throws Exception {
		log.info(data);
		Iterator ite = data.iterator();
		while (ite.hasNext()) {
			ArrayList<File> files = (ArrayList<File>) ite.next();
			for (File file: files){
				try {
					log.info("Deleting file " + file.getName());
					file.delete();
				} catch (Exception e) {
					log.error("Error found deleting file "  + file.getName());// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
