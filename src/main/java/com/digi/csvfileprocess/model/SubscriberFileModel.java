package com.digi.csvfileprocess.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "subscriber_files")
public class SubscriberFileModel {
	@Id
	private String id;
	@Field("domain")
	private String domain;
	@Field("list_name")
	private String listName;
	@Field("file_name")
	private String fileName;
	@Field("processed")
	private boolean processed;
	@Field("total_count")
	private Integer totalCount;
	@Field("skip_count")
	private Integer skipCount;
	@Field("create_at")
	private Date createAt;
	@Field("ignore_count")
	private Integer ignoreCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getSkipCount() {
		return skipCount;
	}

	public void setSkipCount(Integer skipCount) {
		this.skipCount = skipCount;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Integer getIgnoreCount() {
		return ignoreCount;
	}

	public void setIgnoreCount(Integer ignoreCount) {
		this.ignoreCount = ignoreCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubscriberFileModel [id=");
		builder.append(id);
		builder.append(", domain=");
		builder.append(domain);
		builder.append(", listName=");
		builder.append(listName);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", processed=");
		builder.append(processed);
		builder.append(", totalCount=");
		builder.append(totalCount);
		builder.append(", skipCount=");
		builder.append(skipCount);
		builder.append(", createAt=");
		builder.append(createAt);
		builder.append(", ignoreCount=");
		builder.append(ignoreCount);
		builder.append("]");
		return builder.toString();
	}

}
