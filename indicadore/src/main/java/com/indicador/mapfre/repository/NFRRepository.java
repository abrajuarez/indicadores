package com.indicador.mapfre.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.indicador.mapfre.entity.XxmpfBpmIndEmision;;

@Repository("nfrRepository")
public interface NFRRepository extends JpaRepository<XxmpfBpmIndEmision, String>{


}
