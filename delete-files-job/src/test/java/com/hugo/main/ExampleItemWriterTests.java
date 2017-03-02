package com.hugo.main;

import com.hugo.main.WriterDelete;

import junit.framework.TestCase;

public class ExampleItemWriterTests extends TestCase {

	private WriterDelete writer = new WriterDelete();
	
	public void testWrite() throws Exception {
		writer.write(null); // nothing bad happens
	}

}
