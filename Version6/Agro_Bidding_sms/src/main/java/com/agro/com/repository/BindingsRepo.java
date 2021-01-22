package com.agro.com.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agro.com.model.Biddings;


public interface BindingsRepo extends JpaRepository<Biddings, Long>{

	@Query(value="select * from Biddings b where b.buyer_id=?1",nativeQuery = true)
	public List<Biddings> getBidds(String byrId);
	
	//to check bidder already exist in bidding table or not
	@Query(value="select * from Biddings b where b.pid=?1 and b.buyer_id=?2 ",nativeQuery = true)
	public List<Biddings> checkBidder(long prdctId,String byrId);
	
	
	@Modifying
	@Transactional
	@Query(value="update biddings b set b.bid_price=:bidprice where b.buyer_id=:byrId and b.pid=:prdctid",nativeQuery = true)
	public void updateBid(@Param(value = "byrId") String byrId,@Param(value = "bidprice") float bidprice,@Param(value = "prdctid") long prdctid);
	
	@Query(value="select max(bid_price) as bid_price,buyer_id from Biddings b where b.pid=?1",nativeQuery = true)
	public List<Object> getHighestBid(long prdctid);
	
	@Query(value="select * from Biddings b where b.pid=?1 ORDER BY b.bid_price DESC",nativeQuery = true)
	public List<Biddings> getProductBids(long prdctid);
	
	@Query(value="select buyer_id from Biddings b where b.bid_price=?1 and b.pid=?2",nativeQuery = true)
	public String findWinner(float highestPrice,long pdtid);
	
	
}
