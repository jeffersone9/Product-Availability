package com.cognizant.balancecrud.repository;

import com.cognizant.balancecrud.model.BalanceDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepo extends JpaRepository<BalanceDB, Long> {
}
