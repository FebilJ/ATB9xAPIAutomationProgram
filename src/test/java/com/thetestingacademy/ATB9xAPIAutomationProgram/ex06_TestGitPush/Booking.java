package com.thetestingacademy.ATB9xAPIAutomationProgram.ex06_TestGitPush;

public class Booking {
	private String firstname;
    private String lastname;
    private Integer totalPrice;
    private boolean depositpaid;
    private String additionalneeds;
    private BookingDates bookingDates;
    
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public boolean isDepositpaid() {
		return depositpaid;
	}
	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}
	public String getAdditionalneeds() {
		return additionalneeds;
	}
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
	public BookingDates getBookingDates() {
		return bookingDates;
	}
	public void setBookingDates(BookingDates bookingDates) {
		this.bookingDates = bookingDates;
	}
}