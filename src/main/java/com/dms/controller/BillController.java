package com.dms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dms.model.BillDTO;
import com.dms.service.BillService;

@RestController
public class BillController {
	
	//It is use to automatic inject dependency
	@Autowired
	BillService billService;
	
	@PostMapping("/api/generateBill")
	public BillDTO generateBill(@RequestBody BillDTO billDTO) {
		return billService.generateBill(billDTO);
	}
	
	@GetMapping("/api/getBills")
	public List<BillDTO> generateBill() {
		return billService.getAllBills();
	}

}
