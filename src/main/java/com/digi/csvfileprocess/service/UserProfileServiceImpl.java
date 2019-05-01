package com.digi.csvfileprocess.service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.csvfileprocess.model.SubscriberFileModel;
import com.digi.csvfileprocess.model.UploadedList;
import com.digi.csvfileprocess.model.UserProfile;
import com.digi.csvfileprocess.repo.SubscriberFileRepo;
import com.digi.csvfileprocess.repo.UploadedFileRepo;
import com.digi.csvfileprocess.repo.UserProfileRepo;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	private static Logger log = LoggerFactory.getLogger(UserProfileServiceImpl.class);
	@Autowired
	private SubscriberFileRepo subscriberFileRepo;
	@Autowired
	private UserProfileRepo userProfileRepo;

	@Autowired
	private SegmentMasterService segmentMasterService;

	@Autowired
	private UploadedFileRepo uploadedFileRepo;

	@Override
	public String saveSubscriber(List<UserProfile> subsDToList, SubscriberFileModel subscriberFileModel) {
		Integer skipCount = 0;
		Integer ignoreCount = 0;
		for (UserProfile userProfile : subsDToList) {
			if (isValidEmailAddress(userProfile.getEmaiId())) {
				List<UserProfile> userProfileTemp = userProfileRepo.findByEmaiId(userProfile.getEmaiId());
				UserProfile tUserProfile = null;
				if (userProfileTemp != null && userProfileTemp.size() > 1) {
					log.info("Duplicate Recod found::: {}", tUserProfile);
					for (UserProfile userProfile2 : userProfileTemp) {
						if (tUserProfile == null) {
							tUserProfile = userProfile2;
						} else {
							log.info("Duplicate Recod going to delete ::: {}", tUserProfile);
							userProfileRepo.delete(userProfile2);
						}
					}
				}
				if (tUserProfile == null && userProfileTemp.size() == 0) {
					log.info("Email id  not exist going to create {}", userProfile.getEmaiId());
					try {
						userProfileRepo.save(userProfile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					log.info("Email id  Exist {}", userProfile.getEmaiId());
					skipCount++;
				}
			} else {
				log.info("invalid Email id  ignored {}", userProfile.getEmaiId());
				ignoreCount++;
			}
		}

		int finalCount = subsDToList.size() - (skipCount + ignoreCount);
		subscriberFileModel.setTotalCount(subsDToList.size());
		subscriberFileModel.setSkipCount(skipCount);
		subscriberFileModel.setProcessed(true);
		subscriberFileModel.setIgnoreCount(ignoreCount);
		subscriberFileRepo.save(subscriberFileModel);
		try {
			UploadedList uploadedList = new UploadedList();
			uploadedList.setProcessed(false);
			uploadedList.setSegmentName(subscriberFileModel.getListName().trim());
			uploadedList.setCreatedAt(new Date());
			uploadedFileRepo.save(uploadedList);
			log.info("uploadedList saved into db :::  {}", uploadedList);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error in saving the list procesed uploadedList");
		}
		String domainName = subscriberFileModel.getDomain();
		if (finalCount > 0) {
			segmentMasterService.getSegmentCollectionOpenClick(
					subscriberFileModel.getListName().trim() + "_" + domainName.trim() + "_open", "openers");
			segmentMasterService.getSegmentCollectionOpenClick(
					subscriberFileModel.getListName().trim() + "_" + domainName.trim() + "_click", "clickers");
			segmentMasterService.getSegmentCollectionListWise(subscriberFileModel.getListName().trim(),
					"list_wise_data");
		}
		String fileDetails = "Domain Name " + domainName + "\t List Name " + subscriberFileModel.getListName().trim()
				+ "\t  File Name :- " + subscriberFileModel.getFileName() + "\t Total Count: " + subsDToList.size()
				+ " \t Total Added: " + (subsDToList.size() - (skipCount + ignoreCount)) + "\t Total skip: " + skipCount
				+ "\t Total Ignore : " + ignoreCount;
		return fileDetails;
	}

	public boolean isValidEmailAddress(String emailId) {
		boolean result = false;
		if (emailId != null) {
			Pattern pattern = Pattern
					.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher matcher = pattern.matcher(emailId.trim());
			result = matcher.matches();
		}
		return result;
	}

	/*
	 * public static void main(String[] args) { List<String> emails = new
	 * ArrayList<>(); emails.addAll(Arrays.asList("infra20016@gmail.com",
	 * "mansingh20018@gmail.com", "aksaxwna@gmail.com", "smudit288@gmail.com",
	 * "rajauhan7@gmail.com", "abhilashraichand@gmail.com",
	 * "testidinfradb@gmail.com", "subhrajit212@gmail.com", "dadagopi993@gmail.com",
	 * "yadavmaan30@gmail.com", "romsuresh29@gmail.com",
	 * "Somaraj131singh@gmail.com", "rocketsinghclick1@gmail.com",
	 * "hpro1794@gmail.com", "klr3027@gmail.com", "bhushankoshik@gmail.com",
	 * "gauravkashi6677@gmail.com", "zaidirihan0@gmail.com", "da640417@gmail.com",
	 * "rocketsinghclick3@gmail.com", "mailid201892@gmail.com",
	 * "mailid201893@gmail.com"));
	 * 
	 * for (String email : emails) { System.out.println(email
	 * +"::: "+isValidEmailAddress(email)); }
	 * 
	 * }
	 */

}
