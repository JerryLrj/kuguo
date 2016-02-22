package com.kuguo.front.entity;

public class ProductLabel extends IdEntity {
	private Label label;
	private Product product;
	
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
