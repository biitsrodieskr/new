package com.digi.csvfileprocess.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.digi.csvfileprocess.model.SubscriberFileModel;

public interface SubscriberFileRepo extends MongoRepository<SubscriberFileModel, String> {
	public List<SubscriberFileModel> findByProcessed(boolean processed);
}
