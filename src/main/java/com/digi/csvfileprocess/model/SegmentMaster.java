package com.digi.csvfileprocess.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "segment_master")
public class SegmentMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Field("segment_id")
	private String segment_id;
	@Field("autoincrement_id")
	private long autoincrementId;
	@Field("segment_name")
	private String segmentName;
	@Field("count")
	private Long count;
	@Field("description")
	private String description;
	@Field("last_used")
	private Date last_used;
	@Field("last_generated")
	private Date last_generated;
	@Field("created_date")
	private Date createdDate;
	@Field("seg_category")
	private String segCategory;
	@Field("category_for")
	private String categoryFor;
	@Field("segment_collection_name")
	private String segmentCollectionName;
	private String action;
	@Field("is_active")
	private boolean isActive;
	@Field("type")
	private String type;
	@Field("min_days")
	private int minDays;
	@Field("max_days")
	private int maxDays;

	public String getSegment_id() {
		return segment_id;
	}

	public void setSegment_id(String segment_id) {
		this.segment_id = segment_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLast_used() {
		return last_used;
	}

	public void setLast_used(Date last_used) {
		this.last_used = last_used;
	}

	public Date getLast_generated() {
		return last_generated;
	}

	public void setLast_generated(Date last_generated) {
		this.last_generated = last_generated;
	}

	public String getSegmentName() {
		return segmentName;
	}

	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public long getAutoincrementId() {
		return autoincrementId;
	}

	public void setAutoincrementId(long autoincrementId) {
		this.autoincrementId = autoincrementId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSegCategory() {
		return segCategory;
	}

	public void setSegCategory(String segCategory) {
		this.segCategory = segCategory;
	}

	public String getSegmentCollectionName() {
		return segmentCollectionName;
	}

	public void setSegmentCollectionName(String segmentCollectionName) {
		this.segmentCollectionName = segmentCollectionName;
	}

	public String getCategoryFor() {
		return categoryFor;
	}

	public void setCategoryFor(String categoryFor) {
		this.categoryFor = categoryFor;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMinDays() {
		return minDays;
	}

	public void setMinDays(int minDays) {
		this.minDays = minDays;
	}

	public int getMaxDays() {
		return maxDays;
	}

	public void setMaxDays(int maxDays) {
		this.maxDays = maxDays;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SegmentMaster [segment_id=");
		builder.append(segment_id);
		builder.append(", autoincrementId=");
		builder.append(autoincrementId);
		builder.append(", segmentName=");
		builder.append(segmentName);
		builder.append(", count=");
		builder.append(count);
		builder.append(", description=");
		builder.append(description);
		builder.append(", last_used=");
		builder.append(last_used);
		builder.append(", last_generated=");
		builder.append(last_generated);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", segCategory=");
		builder.append(segCategory);
		builder.append(", categoryFor=");
		builder.append(categoryFor);
		builder.append(", segmentCollectionName=");
		builder.append(segmentCollectionName);
		builder.append(", action=");
		builder.append(action);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append("]");
		return builder.toString();
	}

}