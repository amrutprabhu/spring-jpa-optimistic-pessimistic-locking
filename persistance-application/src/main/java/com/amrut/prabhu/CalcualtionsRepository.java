package com.amrut.prabhu;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface CalcualtionsRepository extends JpaRepository<Calculations, Long> {

    @Lock(LockModeType.OPTIMISTIC)
    Optional<Calculations> findById(Long id);
}
