package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entity.Jobs;

@Repository
public interface JobRepository extends JpaRepository<Jobs, Long>{
		//Jobs findBycompanyName(String companyname);
}
