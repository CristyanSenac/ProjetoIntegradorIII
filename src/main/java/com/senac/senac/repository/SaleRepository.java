package com.senac.senac.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.senac.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByRemovedAndUserId(boolean b, Long userId);

    List<Sale> findByRemoved(boolean b);
}
