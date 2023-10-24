package com.net.service;

import java.util.List;
import java.util.Map;

import com.net.entity.Plan;

public interface PlanService  {
	
	public Map<Integer,String> getPlanCategories();
	
	public boolean savePlan(Plan plan);
	
	public List<Plan> getAllPlans();
	
	public Plan getPlanById(Integer planId);
	
	public boolean deletePlanById(Integer planId);
	
	public boolean planStatusChange(Integer planId, String status); 
	
	public boolean updatePlan(Plan plan);
	

}
