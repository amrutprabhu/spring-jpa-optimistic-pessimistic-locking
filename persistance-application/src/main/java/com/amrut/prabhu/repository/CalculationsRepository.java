package com.amrut.prabhu.repository;

import com.amrut.prabhu.Calculations;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface CalculationsRepository extends JpaRepository<Calculations, Long> {

    @Lock(LockModeType.OPTIMISTIC)
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Calculations> findById(Long id);
}
