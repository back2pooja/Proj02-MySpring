package com.net.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.net.constants.AppConstants;
import com.net.entity.Plan;
import com.net.props.AppProperties;
import com.net.service.PlanService;

@RestController
public class PlanRestController {
	
	@Autowired
	private PlanService planService;
	private Map<String, String> messages;
	
	public PlanRestController(PlanService planService,AppProperties appProps) {
		this.planService = planService;
		this.messages = appProps.getMessages();
	}
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer,String>> planCategoies(){
		Map<Integer,String>categories = planService.getPlanCategories();
		return new ResponseEntity<>(categories,HttpStatus.OK);
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		String responseMsg = AppConstants.EMPTY_STR;
		
		boolean isSaved  = planService.savePlan(plan);
		if(isSaved) {
			String value = messages.get(AppConstants.PLAN_SAVED);
		}else {
			responseMsg = messages.get(AppConstants.PLAN_SAVE_FAIL) ;
		}
		return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
	}
	
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		boolean isUpdated = planService.updatePlan(plan);
		String updateMsg = AppConstants.EMPTY_STR;;
		if(isUpdated) {
			updateMsg = messages.get(AppConstants.PLAN_UPDATED_SUCC);
		}else {
			updateMsg =  messages.get(AppConstants.PLAN_UPDATED_SUCC);;
		}
		return new  ResponseEntity<>(updateMsg,HttpStatus.OK);
		
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans(){
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans,HttpStatus.OK);
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId,@PathVariable String status){
		boolean isStatusChanged = planService.planStatusChange(planId, status);
		String changedStatusMsg = AppConstants.EMPTY_STR;;
		if (isStatusChanged) { 
			changedStatusMsg = messages.get(AppConstants.PLAN_STATUS_CHANGE);;
		}else {
			changedStatusMsg =  messages.get(AppConstants.PLAN_STATUS_CHANGE_FAIL);
		}
		return new  ResponseEntity<>(changedStatusMsg,HttpStatus.OK);
		
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		Plan plan = planService.getPlanById(planId);
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		boolean isDeleted = planService.deletePlanById(planId);
		String deleteMsg = AppConstants.EMPTY_STR;;
		if(isDeleted) {
				deleteMsg =  messages.get(AppConstants.PLAN_DELETE_SUCC);;
		}else {
			deleteMsg =  messages.get(AppConstants.PLAN_STATUS_CHANGE_FAIL);
		}
		return new ResponseEntity<>(deleteMsg, HttpStatus.OK);
	}

}
