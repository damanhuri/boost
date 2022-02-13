package com.boost.iv.voucherpool.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boost.iv.voucherpool.entity.SpecialOffer;

@Repository
public interface SpecialOfferRepo extends JpaRepository<SpecialOffer, Long>{

}
