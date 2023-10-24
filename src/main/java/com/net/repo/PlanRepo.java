package com.net.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.net.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
