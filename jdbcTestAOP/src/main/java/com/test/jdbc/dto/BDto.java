package com.test.jdbc.dto;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class BDto {


	@NotEmpty(message="no empty")
	String bName;
	
	@NotEmpty(message="no empty")
	String bTitle;
	
	@NotEmpty(message="no empty")
	String bContent;
	
	
	
	public BDto() {
		super();
	}
	public BDto(String bName, String bTitle, String bContent) {
		super();
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	
	
	
	
	
}
