package com.example.divisiontownshipreactive.repo;

import com.example.divisiontownshipreactive.entity.Township;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface TownshipRepo extends JpaRepositoryImplementation<Township,Integer> {
}
