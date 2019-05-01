package com.digi.csvfileprocess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.digi.csvfileprocess.controller.ProcessCSVFileController;

@SpringBootApplication
/* @EnableScheduling */
public class CsvfileprocessApplication {
	private static Logger log = LoggerFactory.getLogger(CsvfileprocessApplication.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CsvfileprocessApplication.class, args);
		ProcessCSVFileController processCSVFileController = ctx.getBean(ProcessCSVFileController.class);
		log.info("info");
		log.debug("debug");
		log.error("error");
		processCSVFileController.processFiles();

		/*MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);
		System.out.println(mongoTemplate.getMongoDbFactory());
		mongoTemplate.find(new Query(), SegmentMaster.class);*/

	}

}
