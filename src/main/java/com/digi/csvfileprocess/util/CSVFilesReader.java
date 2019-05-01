package com.digi.csvfileprocess.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.digi.csvfileprocess.model.SubscriberFileModel;
import com.digi.csvfileprocess.model.UserProfile;

@Component
public class CSVFilesReader {
	@Value("${upload.subscriber.dir.path}")
	private String directoryPath;

	private static Logger log = LoggerFactory.getLogger(CSVFilesReader.class);

	public List<UserProfile> getSubscribers(String fileName, SubscriberFileModel subscriberFileModel) {
		List<UserProfile> userProfileList = new ArrayList<>();
		try {

			File file = new File(directoryPath + "/" + fileName);
			if (file.exists()) {
				log.info("File Exist");
			}

			CSVFormat format = CSVFormat.RFC4180.withFirstRecordAsHeader();
			// BufferedReader in = new BufferedReader(new FileReader(directoryPath + "/" +
			// fileName), 1048576 * 10);
			Reader in = new FileReader(directoryPath + "/" + fileName);
			@SuppressWarnings("resource")
			CSVParser parser = new CSVParser(in, format);

			Map<String, Integer> headerMap = parser.getHeaderMap();
			List<String> labels = new ArrayList<>(headerMap.size());
			for (final String label : headerMap.keySet()) {
				if (label != null && !label.equalsIgnoreCase("")) {
					final int pos = headerMap.get(label.trim());
					labels.add(pos, label.trim());
				}
			}
			log.info("" + labels);
			List<CSVRecord> records = parser.getRecords();
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String doj = formatter.format(calendar.getTime());
			long count = 0l;
			for (CSVRecord record : records) {
				UserProfile subscriberDTO = new UserProfile();
				try {
					subscriberDTO.setEmaiId(record.get(labels.indexOf("email")));
					log.info("Email Id Found in recod no {} EmailID {}", count++, record.get(labels.indexOf("email")));
					subscriberDTO.setDefaultDomain(subscriberFileModel.getDomain().trim());
					subscriberDTO.setListName(subscriberFileModel.getListName().trim());
					subscriberDTO.setDoj(doj);
					if (labels.indexOf("phone_no") != -1) {
						subscriberDTO.setMobileNo(record.get(labels.indexOf("phone_no")));
					}

					if (labels.indexOf("city") != -1) {
						subscriberDTO.setCity(record.get(labels.indexOf("city")));
					}

					if (labels.indexOf("gender") != -1) {
						subscriberDTO.setGender(record.get(labels.indexOf("gender")));
					}

					if (labels.indexOf("income_group") != -1) {
						subscriberDTO.setIncomeGroup(record.get(labels.indexOf("income_group")));
					}
				} catch (Exception e) {
					log.error("error in reading record" + e.getMessage());
				}
				userProfileList.add(subscriberDTO);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// log.info("list size" + userProfileList);
		return userProfileList;
	}

}
