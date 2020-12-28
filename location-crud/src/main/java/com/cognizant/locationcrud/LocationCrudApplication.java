package com.cognizant.locationcrud;

import com.cognizant.locationcrud.model.Location;
import com.cognizant.locationcrud.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocationCrudApplication implements CommandLineRunner {

	@Autowired
	private LocationRepo locationRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(LocationCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		locationRepo.deleteAllInBatch();
		locationRepo.save(new Location(1L, "Ruston", "71270"));
		locationRepo.save(new Location(2L, "Zachary", "70791"));
		locationRepo.save(new Location(3L, "Irving", "75014"));
		locationRepo.save(new Location(4L, "Grambling", "71245"));
		locationRepo.save(new Location(5L, "Baton Rouge", "70807"));
		locationRepo.save(new Location(6L, "Dallas", "75394"));
	}
}
