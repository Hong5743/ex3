package com.example.ex3.repository;

import com.example.ex3.entity.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {
    public Optional<MyData> findById(Long name);
}
