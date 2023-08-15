package com.codeflow.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeflow.service.DashboardService;

@RestController
@RequestMapping("api/v1/dashboard")
public class DashboardController {

	@Autowired
	DashboardService dashboardService;
	
	@GetMapping()
	public ResponseEntity<?> getData() {
		return ResponseEntity.ok(dashboardService.getData());
	}
	
}
