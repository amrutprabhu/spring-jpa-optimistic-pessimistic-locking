package com.amrut.prabhu.repository;

import com.amrut.prabhu.Data;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface DataRepository extends JpaRepository<Data, Long> {

    @Lock(LockModeType.OPTIMISTIC)
    Optional<Data> findFirstByOrderByDateDesc();
}
