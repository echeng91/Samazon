package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PRODUCTS database table.
 * 
 */
@Entity
@Table(name="PRODUCTS")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long pid;

	private String pdescription;

	private String pimgurl;

	private String pname;

	private BigDecimal pprice;

	public Product() {
	}

	public long getPid() {
		return this.pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getPdescription() {
		return this.pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	public String getPimgurl() {
		return this.pimgurl;
	}

	public void setPimgurl(String pimgurl) {
		this.pimgurl = pimgurl;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public BigDecimal getPprice() {
		return this.pprice;
	}

	public void setPprice(BigDecimal pprice) {
		this.pprice = pprice;
	}

}