package com.cognizant.balancecrud;

import com.cognizant.balancecrud.model.BalanceDB;
import com.cognizant.balancecrud.repository.BalanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class BalanceCrudApplication implements CommandLineRunner {

	@Autowired
	private BalanceRepo balanceRepo;

	public static void main(String[] args) {
		SpringApplication.run(BalanceCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		balanceRepo.deleteAllInBatch();

		int productSize = 26;
		int locationSize = 6;
		Random rand = new Random();
		Long index = 1L;
		for(Long x = 1L; x <= productSize; x++){
			for(Long y = 1L; y <= locationSize; y++){
				balanceRepo.save(new BalanceDB(index, rand.nextInt(50), x, y));
				index++;
			}
		}


	}
}
