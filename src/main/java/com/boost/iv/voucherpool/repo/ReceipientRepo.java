package com.boost.iv.voucherpool.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boost.iv.voucherpool.entity.Receipient;

@Repository
public interface ReceipientRepo extends JpaRepository<Receipient, Long>{

	boolean existsByEmail(String email);

	List<Receipient> findByEmail(String email);

}
