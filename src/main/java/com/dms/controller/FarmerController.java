package com.dms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dms.model.FarmerDTO;
import com.dms.service.FarmerService;
import com.dms.utilities.FarmerConverter;

import jakarta.validation.Valid;

@RestController
@Validated
public class FarmerController {

	@Autowired
	FarmerService farmerService;

	@Autowired
	FarmerConverter farmerConverter;

	// It is use to send data to server or save data in database
	@PostMapping("/api/addFarmer")
	FarmerDTO addFarmer(@Valid @RequestBody FarmerDTO farmerDTO) {
		return farmerService.addFarmer(farmerDTO);
	}

	// It is use to view data from server or database
	@GetMapping("api/getAllFarmer")
	List<FarmerDTO> getAllSupplier() {
		return farmerService.getAllFarmer();
	}

	// Find Farmer by id
	@GetMapping("/api/getFarmer/{id}")
	FarmerDTO getFarmer(@Valid @PathVariable("id") int id) {
		return farmerService.getFarmer(id);
	}

	// Update the supplier information
	@PutMapping("/api/updateFarmer/{phoneNo}")
	FarmerDTO updateFarmer(@Valid @RequestBody FarmerDTO farmerDTO,@Valid @PathVariable("id") int id) {
		return farmerService.updateFarmer(farmerDTO, id);
	}

	// Delete Supplier by id
	@DeleteMapping("/api/deleteFarmer/{id}")
	String deleteSupplierById(@Valid @PathVariable("id") int id) {
		return farmerService.deleteFarmer(id);
	}
}
