package com.agro.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agro.com.model.Farmer;
import com.agro.com.model.User;


public interface FarmerRepo extends JpaRepository<Farmer, Long>{
	
	@Query(value="select * from farmer f where f.id=?1",nativeQuery = true)
	public List<Farmer> getUser(long id);
	
	
	@Query(value="select * from farmer f where f.uid=?1",nativeQuery = true)
	public List<Farmer> getProducts(String usrid);

}
