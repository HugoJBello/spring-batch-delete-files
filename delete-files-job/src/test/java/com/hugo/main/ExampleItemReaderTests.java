package com.hugo.main; 

import com.hugo.main.ReaderDelete;

import junit.framework.TestCase;

public class ExampleItemReaderTests extends TestCase {

	private ReaderDelete reader = new ReaderDelete();
	
	public void testReadOnce() throws Exception {
		assertEquals("Hello world!", reader.read());
	}

	public void testReadTwice() throws Exception {
		reader.read();
		assertEquals(null, reader.read());
	}

}
