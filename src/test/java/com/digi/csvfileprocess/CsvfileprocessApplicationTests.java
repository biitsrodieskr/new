package com.digi.csvfileprocess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.digi.csvfileprocess.model.SubscriberFileModel;
import com.digi.csvfileprocess.util.CSVFilesReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CsvfileprocessApplicationTests {
	@Autowired
	private CSVFilesReader cSVFilesReader;

	@Test
	public void contextLoads() {
		cSVFilesReader.getSubscribers("file1.csv", new SubscriberFileModel());
	}

}
