package com.cognizant.productcrud;

import com.cognizant.productcrud.model.Department;
import com.cognizant.productcrud.model.Product;
import com.cognizant.productcrud.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class ProductCrudApplication implements CommandLineRunner {

	@Autowired
	private ProductRepo productRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		productRepo.deleteAllInBatch();
		Department dept1 = new Department(1L, "Produce");
		Department dept2 = new Department(2L, "Seafood");
		Department dept3 = new Department(3L, "Snacks/Chips");
		Department dept4 = new Department(4L, "Juice");
		Department dept5 = new Department(5L, "Alcohol");
		Department dept6 = new Department(6L, "Meat");
		Department dept7 = new Department(7L, "Rice/Pasta");
		Department dept8 = new Department(9L, "Dairy");
		Department dept9 = new Department(10L, "Bread");
		List<Product> products = Arrays.asList(
				new Product(1L, "Shrimp", dept2),
				new Product(2L, "Beer - Heinekin", dept5),
				new Product(3L, "Pork Casing", dept6),
				new Product(4L, "Fuji Apples", dept1),
				new Product(5L, "Brocolinni - Gaylan, Chinese", dept7),
				new Product(6L, "Madeira", dept5),
				new Product(7L, "Juice - Orange, Concentrate", dept4),
				new Product(8L, "Creme De Cacao White", dept5),
				new Product(9L, "Gatorade - Orange", dept4),
				new Product(10L, "Lettuce - Belgian Endive", dept1),
				new Product(11L, "Capon - Breast, Wing On", dept6),
				new Product(12L, "Island Oasis - Strawberry", dept4),
				new Product(13L, "Corn Shoots", dept1),
				new Product(14L, "Juice - Happy Planet", dept5),
				new Product(15L, "Chips - Doritos", dept3),
				new Product(16L, "Bread Base - Toscano", dept9),
				new Product(17L, "Bread - Flat Bread", dept9),
				new Product(18L, "Jam - Marmalade, Orange", dept8),
				new Product(19L, "Cheese - Gouda Smoked", dept8),
				new Product(20L, "Milk 2% 500 Ml", dept8),
				new Product(21L, "Mudslide", dept5),
				new Product(22L, "Wine - Shiraz Wolf Blass Premium", dept5),
				new Product(23L, "Beef - Ground Lean Fresh", dept6),
				new Product(24L, "Bread Cranberry Foccacia", dept9),
				new Product(25L, "Chivas Regal - 12 Year Old" , dept5),
				new Product(26L, "Muffin Batt - Blueberry Passion", dept3),
				new Product(27L, "Beans - Kidney White", dept1),
				new Product(28L, "Pepper - Green, Chili", dept1),
				new Product(29L, "Cheese - Le Cheve Noir", dept8)
		);

		for (Product product: products) {
			productRepo.save(product);
		}
	}
}
