package com.example.studenterd.dao;

import com.example.studenterd.entity.Province;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceDao extends JpaRepository<Province, CriteriaBuilder.In> {
}
