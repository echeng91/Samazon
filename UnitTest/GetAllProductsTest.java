import static org.junit.Assert.*;

import org.junit.Test;

import model.Product;
import java.util.List;

public class GetAllProductsTest {

	@Test
	public void testNotEmpty() {
		List<Product> prods = ProductDB.getAllProducts();
		assertFalse(prods.isEmpty());
	}

	@Test
	public void testContains13() {
		List<Product> prods = ProductDB.getAllProducts();
		assertTrue(prods.size() == 13);//will need to change if add more products
	}
	
	@Test
	public void testTestudoFirstID() {
		List<Product> prods = ProductDB.getAllProducts();
		assertTrue(prods.get(0).getPid() == 1);
	}
	
	@Test
	public void testTestudoFirstName() {
		List<Product> prods = ProductDB.getAllProducts();
		assertTrue(prods.get(0).getPname().equals("Testudo"));
	}
	
	@Test
	public void testTestudoFirstDescription() {
		List<Product> prods = ProductDB.getAllProducts();
		assertTrue(prods.get(0).getPdescription().equals("UMD Mascot"));
	}
	
	@Test
	public void testTestudoFirstPrice() {
		List<Product> prods = ProductDB.getAllProducts();
		assertTrue(prods.get(0).getPprice().doubleValue() == 900.00);
	}
	@Test
	public void testTestudoFirstImgurl() {
		List<Product> prods = ProductDB.getAllProducts();
		assertTrue(prods.get(0).getPimgurl().equals("https://upload.wikimedia.org/wikipedia/commons/f/f8/UMD_Testudo_Statue.JPG"));
	}
}
