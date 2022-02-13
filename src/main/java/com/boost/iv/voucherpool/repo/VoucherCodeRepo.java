package com.boost.iv.voucherpool.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boost.iv.voucherpool.entity.VoucherCode;

@Repository
public interface VoucherCodeRepo extends JpaRepository<VoucherCode, Long>{

	List<VoucherCode> findByCode(String code);

	@Query("SELECT vc FROM VoucherCode vc WHERE vc.receipient.id = ?1")
	List<VoucherCode> findByReceipient_Id(Long id);
}
