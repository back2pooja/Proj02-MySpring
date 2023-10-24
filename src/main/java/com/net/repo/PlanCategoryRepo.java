package com.net.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.net.entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer> {

}
