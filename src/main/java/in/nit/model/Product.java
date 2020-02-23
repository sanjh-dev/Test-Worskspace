package in.nit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Integer prodId;
	private String prodCode;
	private Double prodCost;
	private Double gst;
	private Double discount;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public Double getProdCost() {
		return prodCost;
	}

	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodCode=" + prodCode + ", prodCost=" + prodCost + ", gst=" + gst
				+ ", discount=" + discount + "]";
	}

}
