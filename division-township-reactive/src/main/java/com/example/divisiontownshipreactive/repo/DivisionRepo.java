package com.example.divisiontownshipreactive.repo;

import com.example.divisiontownshipreactive.entity.Division;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;

public interface DivisionRepo extends JpaRepositoryImplementation<Division,Integer> {

    @Query("""
select d.name from Division d where  d.name = :name
""")
    Optional<Division> searchByName(String name);
}
