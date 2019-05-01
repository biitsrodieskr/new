package com.digi.csvfileprocess.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digi.csvfileprocess.model.SubscriberFileModel;
import com.digi.csvfileprocess.model.UserProfile;
import com.digi.csvfileprocess.repo.SubscriberFileRepo;
import com.digi.csvfileprocess.service.UserProfileService;
import com.digi.csvfileprocess.util.CSVFilesReader;
import com.digi.csvfileprocess.util.MailUtil;

@Component
public class ProcessCSVFileController {
	private static Logger log = LoggerFactory.getLogger(ProcessCSVFileController.class);
	@Autowired
	private CSVFilesReader cSVFilesReader;

	@Autowired
	private SubscriberFileRepo subscriberFileRepo;
	@Autowired
	private UserProfileService userProfileService;
	@Autowired
	private MailUtil mailUtil;

	/* @Scheduled(cron = "${scheduling.job.cron}") */
	public void processFiles() {
		try {
			String subject = "Subscriber Uploaded SuccessFully";
			StringBuilder fDetails = new StringBuilder("");
			List<SubscriberFileModel> filesList = subscriberFileRepo.findByProcessed(false);
			log.info("going to process files");
			for (SubscriberFileModel subscriberFileModel : filesList) {
				log.info("subscriberFileModel file details {}", subscriberFileModel);
				if (subscriberFileModel.getFileName().endsWith(".csv")) {
					log.info("going to get  subscriber details from csv file");
					List<UserProfile> subsDToList = cSVFilesReader.getSubscribers(subscriberFileModel.getFileName(),
							subscriberFileModel);
					log.info("going to save  subscriber details into subscribe collection");
					String fileDetails = userProfileService.saveSubscriber(subsDToList, subscriberFileModel);
					fDetails.append(fileDetails).append("\n");
				} else {
					subject = "File Process Failed";
					fDetails.append("Invalid file error. Please contact to admin.");
					log.info("Error in Process of file");
				}
			}
			if (fDetails.length() > 1) {
				mailUtil.sendMail(subject, fDetails.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
