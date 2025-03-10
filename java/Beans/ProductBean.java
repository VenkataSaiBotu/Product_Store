package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductBean implements Serializable
{
	private String name;
	private int code,qty;
	private float price;
	
	public ProductBean() {
		super();
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
