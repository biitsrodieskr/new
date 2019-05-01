package com.digi.csvfileprocess.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.digi.csvfileprocess.model.SegmentMaster;

@Repository
public class SegmentMasterDaoImpl {
	@Autowired
	private MongoTemplate mongoTemplate;

	
	public SegmentMaster getSegmentMaster(String segmentCollName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("segment_collection_name").is(segmentCollName));
		return mongoTemplate.findOne(query, SegmentMaster.class);
	}


	public void saveSegment(SegmentMaster segmentMaster) {
		mongoTemplate.save(segmentMaster);
	}

}
