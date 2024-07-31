package com.dms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dms.model.MilkDTO;
import com.dms.service.MilkService;

@RestController
public class MilkController {

	@Autowired
	MilkService milkService;
	
	@PostMapping("/api/addMilk")
	public MilkDTO addMilk(@RequestBody MilkDTO milkDTO) {
		return milkService.addMilk(milkDTO); 
	}
	@GetMapping("/api/getMilkInfo")
	public List<MilkDTO> getAllMilkDetails() {
		return milkService.getAllMilkDetails();
	}
}
