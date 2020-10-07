package com.smi.allone.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smi.allone.domain.Cart;
import com.smi.allone.domain.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	Cart findByUserId(Integer id);

	@Query("select productId from Cart c where c.userId=?1")
	List<Integer> getProductId(Integer id);

	@Modifying
	@Transactional
	void deleteByProductId(Integer id);

	@Query("select id from Cart c where c.userId=?1")
	List<Integer> getCartId(Integer id);
	
	@Query("select s from Cart s where s.userId=?1 and s.productId=?2")
	List<Cart> findByProductUserId(int UserId , int productId);

	@Modifying
	@Transactional
	@Query("update Cart s set s.quantity=?3 where s.userId=?1 and s.productId=?2")
	int upadteQty(int id, int pid, int qty);

//	to get product quantity
	@Query("select quantity from Cart c where c.userId=?1")
	List<Integer> getQuantity(Integer id);

}
