package com.digi.csvfileprocess.service;

import java.util.Date;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.csvfileprocess.model.SegmentMaster;
import com.digi.csvfileprocess.repo.SegmentMasterDaoImpl;

@Service
public class SegmentMasterService {
	private static Logger log = LoggerFactory.getLogger(SegmentMasterService.class);

	@Autowired
	private SegmentMasterDaoImpl segmentMasterDaoImpl;

	public String createAndUpdateSegment(Set<String> collectionSet) {

		for (String coll : collectionSet) {
			getSegmentCollection(coll);
		}

		return "SUCCESS";

	}

	public void getSegmentCollection(String coll) {
		SegmentMaster segmentMaster = segmentMasterDaoImpl.getSegmentMaster("seg_" + coll);
		if (segmentMaster == null) {
			segmentMaster = new SegmentMaster();
			segmentMaster.setActive(true);
			segmentMaster.setLast_used(new Date());
			segmentMaster.setLast_generated(new Date());
			segmentMaster.setCreatedDate(new Date());
			segmentMaster.setType("default");
			segmentMaster.setAction(coll);
			segmentMaster.setDescription(coll);
			segmentMaster.setSegCategory("openers");
			segmentMaster.setSegmentCollectionName("seg_" + coll);
			segmentMaster.setSegmentName(coll);
			segmentMaster.setCount(0l);
			segmentMasterDaoImpl.saveSegment(segmentMaster);
			log.info("segment opener name " + segmentMaster);

		}
		segmentMaster = segmentMasterDaoImpl.getSegmentMaster("seg_" + coll);
		log.info("segmentMaster" + segmentMaster);
	}

	public void getSegmentCollectionOpenClick(String coll, String segCatgory) {
		SegmentMaster segmentMaster = segmentMasterDaoImpl.getSegmentMaster("seg_" + coll);
		if (segmentMaster == null) {
			segmentMaster = new SegmentMaster();
			segmentMaster.setActive(true);
			segmentMaster.setLast_used(new Date());
			segmentMaster.setLast_generated(new Date());
			segmentMaster.setCreatedDate(new Date());
			segmentMaster.setType("default");
			segmentMaster.setAction(coll);
			segmentMaster.setDescription(coll);
			segmentMaster.setSegCategory(segCatgory);
			segmentMaster.setSegmentCollectionName("seg_" + coll);
			segmentMaster.setSegmentName(coll);
			segmentMaster.setCount(0l);
			segmentMasterDaoImpl.saveSegment(segmentMaster);
			log.info("segment opener name " + segmentMaster);

		}
		segmentMaster = segmentMasterDaoImpl.getSegmentMaster("seg_" + coll);
		log.info("segmentMaster" + segmentMaster);
	}

	public void getSegmentCollectionListWise(String coll, String segCatgory) {
		SegmentMaster segmentMaster = segmentMasterDaoImpl.getSegmentMaster("seg_" + coll);
		if (segmentMaster == null) {
			segmentMaster = new SegmentMaster();
			segmentMaster.setActive(true);
			segmentMaster.setLast_used(new Date());
			segmentMaster.setLast_generated(new Date());
			segmentMaster.setCreatedDate(new Date());
			segmentMaster.setType("default");
			segmentMaster.setAction(coll);
			segmentMaster.setDescription(coll);
			segmentMaster.setSegCategory(segCatgory);
			segmentMaster.setSegmentCollectionName("seg_" + coll);
			segmentMaster.setSegmentName(coll);
			segmentMaster.setCategoryFor(coll);
			segmentMaster.setCount(0l);
			segmentMasterDaoImpl.saveSegment(segmentMaster);
			log.info("segment opener name " + segmentMaster);

		}
		segmentMaster = segmentMasterDaoImpl.getSegmentMaster("seg_" + coll);

	}

}
