import java.math.BigDecimal;
import java.util.List;
import customTools.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Product;

public class ProductDB {

	public static List<Product> getAllProducts() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT p from Product p ORDER BY p.pid";
		TypedQuery<Product> q = em.createQuery(qString, Product.class);
		List<Product> products = null;
		try {
			products = q.getResultList();
			if(products == null || products.isEmpty()) {
				products = null;
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			em.close();
		}
		return products;
	}
	
	public static Product getProductByID(long prodid) {
		Product found = new Product();
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT p from Product p WHERE p.pid = " + prodid;
		TypedQuery<Product> q = em.createQuery(qString, Product.class);
		try {
			found = q.getSingleResult();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			em.close();
		}
		return found;
	}
	
}

/*
create table products (
pid int not null primary key,
pname varchar(50),
pdescription varchar(255),
pprice decimal(5,2),
pimgurl varchar(255)
);

insert into products (pid, pname, pdescription, pprice, pimgurl) values (1, 'Testudo', 'UMD Mascot', 900.00, 'https://upload.wikimedia.org/wikipedia/commons/f/f8/UMD_Testudo_Statue.JPG');
insert into products (pid, pname, pdescription, pprice, pimgurl) values (2, 'Blastudo', 'Blastoise Testudo', 50.00, 'http://forum.tip.it/uploads/profile/photo-189934.jpg?_r=0');
insert into products (pid, pname, pdescription, pprice, pimgurl) values (3, 'Paratroopa', 'Flying Koopa', 50.00, 'http://images2.fanpop.com/image/photos/14200000/Paratroopa-koopa-troopa-14263616-520-520.jpg');
insert into products (pid, pname, pdescription, pprice, pimgurl) values (4, 'Raphael', 'Red', 50, 'http://vignette1.wikia.nocookie.net/vsbattles/images/3/39/Raph.jpg/revision/latest?cb=20150805114924');
insert into products (pid, pname, pdescription, pprice, pimgurl) values (5, 'Michelangelo', 'Orange', 50, 'https://img1.etsystatic.com/010/0/6529674/il_340x270.421361123_55k7.jpg');
insert into products (pid, pname, pdescription, pprice, pimgurl) values (6, 'Donatello', 'Purple', 50, 'http://www.ninjaturtles.ru/forum/resources/image/16281');
insert into products (pid, pname, pdescription, pprice, pimgurl) values (7, 'Leonardo', 'Blue', 50, 'http://img3.wikia.nocookie.net/__cb20130622165845/tmnt/images/5/5c/Leonardo-tmnt-leonardo-32837781-251-289.jpg');
insert into products (pid, pname, pdescription, pprice, pimgurl) values (8, 'kale', 'Healthy leafy veggie', 5, 'http://cdn-img.health.com/sites/default/files/migration/img/web/2013/02/slides/easy-kale-recipes-400x400.jpg');
insert into products (pid, pname, pdescription, pprice, pimgurl) values (9, 'carrots', 'Orange vegetable', 5, 'https://plus.maths.org/content/sites/plus.maths.org/files/articles/2011/paraconsistency/carrot.jpg');
insert into products (pid, pname, pdescription, pprice, pimgurl) values (10, 'pizza', 'Turtles not included', 10, 'http://teenagemutantninjaturtles.com/wp-content/uploads/2013/03/Ninja-Turtles-TMNT-Pizza.jpg');


create table users(
userid int not null primary key,
username varchar(50),
userpass varchar(50)
);

insert into users(userid, username, userpass) values(1, 'Eric', 'abc123');


create table orders(
userid int,
productid int, 
quantity int,
orderdate date
);

alter table orders add foreign key (userid) references users (userid);
alter table orders add foreign key (productid) references products (pid);

insert into products (pid, pname, pdescription, pprice, pimgurl) values (11, 'Bowser', 'King of Koopas', 100, 'http://vignette2.wikia.nocookie.net/villains/images/7/71/Bowser.png/revision/latest?cb=20131030220015');
insert into products (pid, pname, pdescription, pprice, pimgurl) values (12, 'Kamek', 'Koopa Wizard', 50, 'http://vignette4.wikia.nocookie.net/mario/images/1/18/KamekNSMBW.png/revision/latest?cb=20120324234123');
insert into products (pid, pname, pdescription, pprice, pimgurl) values (13, 'Squirtle', 'Turtle Pokemon', 50, 'http://cdn.bulbagarden.net/upload/thumb/3/39/007Squirtle.png/250px-007Squirtle.png');

*/