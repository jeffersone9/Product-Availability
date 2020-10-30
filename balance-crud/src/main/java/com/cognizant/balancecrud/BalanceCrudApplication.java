package com.cognizant.balancecrud;

import com.cognizant.balancecrud.model.BalanceDB;
import com.cognizant.balancecrud.repository.BalanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BalanceCrudApplication implements CommandLineRunner {

	@Autowired
	private BalanceRepo balanceRepo;

	public static void main(String[] args) {
		SpringApplication.run(BalanceCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		balanceRepo.deleteAllInBatch();

		balanceRepo.save(new BalanceDB(1L, 1, 1L, 1L));
		balanceRepo.save(new BalanceDB(2L, 1, 1L, 2L));
		balanceRepo.save(new BalanceDB(3L, 1, 1L, 3L));
		balanceRepo.save(new BalanceDB(4L, 1, 2L, 1L));
		balanceRepo.save(new BalanceDB(5L, 1, 2L, 2L));
		balanceRepo.save(new BalanceDB(6L, 1, 2L, 3L));
		balanceRepo.save(new BalanceDB(7L, 1, 3L, 1L));
		balanceRepo.save(new BalanceDB(8L, 1, 3L, 2L));
		balanceRepo.save(new BalanceDB(9L, 1, 3L, 3L));

	}
}
