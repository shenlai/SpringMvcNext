package com.sl.pojo;

import java.sql.Date;

//import javax.validation.constraints.Size;
//import org.hibernate.validator.constraints.NotEmpty;
//import org.hibernate.validator.constraints.Range;

public class Product {

	
	//@Range(min=0,max=1000000,message="�۸�ֻ������{2}-{1}֮��")
	private int price;
	
	//@Size(min=1,max=50,message="���Ƴ��ȱ������{2}-{1}֮��")
	//@NotEmpty
	private String productName;
	
	private Date bookingTime;
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}
}
