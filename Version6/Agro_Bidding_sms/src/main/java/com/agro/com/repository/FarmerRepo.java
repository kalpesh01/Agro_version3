package com.agro.com.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agro.com.model.Farmer;
import com.agro.com.model.User;


public interface FarmerRepo extends JpaRepository<Farmer, Long>{
	
	@Query(value="select * from farmer f where f.id=?1",nativeQuery = true)
	public List<Farmer> getUser(long id);
	
	
	@Query(value="select * from farmer f where f.uid=?1",nativeQuery = true)
	public List<Farmer> getProducts(String usrid);

	
	@Query(value="select * from farmer f where f.pid=?1",nativeQuery = true)
	public List<Farmer> getProductByProductId(long prdid);
	
	
	@Modifying
	@Transactional
	@Query(value="update farmer f set f.highest_bid=:hgp, f.winner_id=:winid where f.pid=:prdctId",nativeQuery = true)
	public void updateHighestBidPrice(@Param(value = "prdctId") long prdctId,@Param(value = "hgp") double hgp,@Param(value = "winid") String winid);

	
//	@Modifying
//	@Transactional
//	@Query(value="update farmer f set f.highest_bid=:hgp, winner_id=:winnerid where f.pid=:prdctId",nativeQuery = true)
//	public void updateHighestBidPrice(@Param(value = "prdctId") long prdctId,@Param(value = "hgp") double hgp,@Param(value = "winnerid") String winnerid);
//
//	
	@Modifying
	@Transactional
	@Query(value="update farmer f set f.status=:bstatus where f.endbdate<=:CURRENT_DATE",nativeQuery = true)
	public int updateBidEndDates(@Param(value = "bstatus") Boolean bstatus,@Param(value = "CURRENT_DATE")LocalDate CURRENT_DATE);
	
	@Query(value="select * from farmer f where f.status=?1",nativeQuery = true)
	public List<Farmer> getStatusChange(Boolean sts);
	
	
//	@Modifying
//	@Transactional
//	@Query(value="delete from farmer f where f.pid=:pid",nativeQuery = true)
//	public int deleteExpiredRecord(@Param("pid") long pid);
}
