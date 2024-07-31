package com.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dms.service.DairyOwnerService;

@RestController
public class DairyOwnerController {

	@Autowired
	DairyOwnerService dairyOwnerService;
	
	@PostMapping("/api/addNewFarmer/{id}")
	String addFarmerInDairy(@PathVariable("id") int id) {
		
		return dairyOwnerService.addFarmerById(id);
	}
}
