package com.java.ivtmg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.ivtmg.model.Ivtmg;

@Repository
public interface IvtmgRepo extends JpaRepository<Ivtmg,Integer>{

}
