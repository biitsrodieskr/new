package com.digi.csvfileprocess.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.digi.csvfileprocess.model.UploadedList;

public interface UploadedFileRepo extends MongoRepository<UploadedList, String> {

}
