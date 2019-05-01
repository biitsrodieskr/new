package com.digi.csvfileprocess.service;

import java.util.List;

import com.digi.csvfileprocess.model.SubscriberFileModel;
import com.digi.csvfileprocess.model.UserProfile;

public interface UserProfileService {

	String saveSubscriber(List<UserProfile> subsDToList, SubscriberFileModel subscriberFileModel);

}
