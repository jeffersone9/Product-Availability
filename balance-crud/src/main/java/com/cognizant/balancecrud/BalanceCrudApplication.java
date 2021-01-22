package com.cognizant.balancecrud;

import com.cognizant.balancecrud.model.BalanceDB;
import com.cognizant.balancecrud.repository.BalanceRepo;
import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.io.IOException;
import java.util.Random;

@SpringBootApplication
//@EnableCaching
public class BalanceCrudApplication implements CommandLineRunner {

	@Autowired
	private BalanceRepo balanceRepo;

	private MemcachedClient cache;

	public static void main(String[] args) {
		SpringApplication.run(BalanceCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try{
			cache = new MemcachedClient(AddrUtil.getAddresses("productavailability.qwn7sl.0001.use1.cache.amazonaws.com:11211"));

		} catch(IOException e){
			e.printStackTrace();
		}

		cache.flush();
		balanceRepo.deleteAllInBatch();

		int productSize = 26;
		int locationSize = 6;
		Random rand = new Random();
		Long index = 1L;
		for(Long x = 1L; x <= productSize; x++){
			for(Long y = 1L; y <= locationSize; y++){
				BalanceDB newBalance = new BalanceDB(index, rand.nextInt(50), x, y);
				balanceRepo.save(newBalance);
				cache.add(index.toString(), 5, newBalance);
				index++;
			}
		}


	}
}
