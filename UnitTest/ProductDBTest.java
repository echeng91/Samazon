import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import model.Product;

public class ProductDBTest {

	@Test
	public void test1() {
		Product p = new Product();
		Product detailedProduct = ProductDB.getProductByID(13);
		assertTrue(detailedProduct.getPid() == 13);
	}
	
	@Test
	public void test2() {
		Product detailedProduct = ProductDB.getProductByID(13);
		assertTrue(detailedProduct.getPname().equals("Squirtle"));
	}

	@Test
	public void test3() {
		Product detailedProduct = ProductDB.getProductByID(13);
		assertTrue(detailedProduct.getPdescription().equals("Turtle Pokemon"));
	}
	
	@Test
	public void test4() {
		Product detailedProduct = ProductDB.getProductByID(13);
		assertTrue(detailedProduct.getPprice().doubleValue() == 50);
	}
	
	@Test
	public void test5() {
		Product detailedProduct = ProductDB.getProductByID(13);
		assertTrue(detailedProduct.getPimgurl().equals("http://cdn.bulbagarden.net/upload/thumb/3/39/007Squirtle.png/250px-007Squirtle.png"));
	}
}
