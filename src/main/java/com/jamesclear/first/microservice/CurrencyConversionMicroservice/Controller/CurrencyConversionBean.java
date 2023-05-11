package com.jamesclear.first.microservice.CurrencyConversionMicroservice.Controller;


public class CurrencyConversionBean {
	
      private int id;
	  
	  private String from;
	  
	  private String to;
	  
	  private double conversionMultiple;
	  
	  private int quantity;
	  
	  private double totalCalculatedAmount; 
	  
	  private String environment;
		  
	  public CurrencyConversionBean() {
		super();
		// TODO Auto-generated constructor stub
	  }
	  	
	public CurrencyConversionBean(int id, String from, String to, double conversionMultiple, int quantity,
			double totalCalculatedAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public int getId() {
		return id;
	  }
	
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public double getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(double conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}



	public void setTotalCalculatedAmount(double totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	@Override
	public String toString() {
		return "CurrencyConversionBean [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", quantity=" + quantity + ", totalCalculatedAmount=" + totalCalculatedAmount
				+ ", environment=" + environment + "]";
	}
	  	  
	
}
