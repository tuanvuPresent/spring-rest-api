package com.example.demo.api.sample;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
    List<Sample> findAll();
}
