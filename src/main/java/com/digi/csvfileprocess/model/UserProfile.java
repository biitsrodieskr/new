package com.digi.csvfileprocess.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "user_profile")
public class UserProfile implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	@Field("email_id")
	String emaiId;
	@Field("first_name")
	String firstName;
	@Field("last_name")
	String lastName;
	@Field("default_domain")
	String defaultDomain;
	@Field("secondary_domain")
	String secondaryDomain;
	@Field("product")
	String product;
	@Field("mobile_no")
	String mobileNo;
	@Field("gender")
	String gender;
	@Field("dob")
	String dob;
	@Field("doj")
	String doj;
	@Field("city")
	String city;
	@Field("state")
	String state;
	@Field("primary_product")
	String primaryProduct;
	@Field("promo_enable")
	boolean promoEnable;
	@Field("promo_enable_date")
	Date promoEnableDate;
	@Field("is_unsubscribed")
	boolean isUnsubscribed;
	@Field("is_bounced")
	boolean isBounced;
	@Field("listid")
	private Integer listId;
	@Field("listname")
	private String listName;
	@Field("operator")
	private String operator;
	@Field("circle")
	private String circle;
	@Field("income_group;")
	private String incomeGroup;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmaiId() {
		return emaiId;
	}

	public void setEmaiId(String emaiId) {
		this.emaiId = emaiId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDefaultDomain() {
		return defaultDomain;
	}

	public void setDefaultDomain(String defaultDomain) {
		this.defaultDomain = defaultDomain;
	}

	public String getSecondaryDomain() {
		return secondaryDomain;
	}

	public void setSecondaryDomain(String secondaryDomain) {
		this.secondaryDomain = secondaryDomain;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPrimaryProduct() {
		return primaryProduct;
	}

	public void setPrimaryProduct(String primaryProduct) {
		this.primaryProduct = primaryProduct;
	}

	public boolean getPromoEnable() {
		return promoEnable;
	}

	public void setPromoEnable(boolean promoEnable) {
		this.promoEnable = promoEnable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getPromoEnableDate() {
		return promoEnableDate;
	}

	public void setPromoEnableDate(Date promoEnableDate) {
		this.promoEnableDate = promoEnableDate;
	}

	public boolean isUnsubscribed() {
		return isUnsubscribed;
	}

	public void setUnsubscribed(boolean isUnsubscribed) {
		this.isUnsubscribed = isUnsubscribed;
	}

	public boolean isBounced() {
		return isBounced;
	}

	public void setBounced(boolean isBounced) {
		this.isBounced = isBounced;
	}

	public Integer getListId() {
		return listId;
	}

	public void setListId(Integer listId) {
		this.listId = listId;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getIncomeGroup() {
		return incomeGroup;
	}

	public void setIncomeGroup(String incomeGroup) {
		this.incomeGroup = incomeGroup;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserProfile [id=");
		builder.append(id);
		builder.append(", emaiId=");
		builder.append(emaiId);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", defaultDomain=");
		builder.append(defaultDomain);
		builder.append(", secondaryDomain=");
		builder.append(secondaryDomain);
		builder.append(", product=");
		builder.append(product);
		builder.append(", mobileNo=");
		builder.append(mobileNo);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", primaryProduct=");
		builder.append(primaryProduct);
		builder.append(", promoEnable=");
		builder.append(promoEnable);
		builder.append(", promoEnableDate=");
		builder.append(promoEnableDate);
		builder.append(", isUnsubscribed=");
		builder.append(isUnsubscribed);
		builder.append(", isBounced=");
		builder.append(isBounced);
		builder.append(", listId=");
		builder.append(listId);
		builder.append(", listName=");
		builder.append(listName);
		builder.append(", operator=");
		builder.append(operator);
		builder.append(", circle=");
		builder.append(circle);
		builder.append(", incomeGroup=");
		builder.append(incomeGroup);
		builder.append("]");
		return builder.toString();
	}

}
