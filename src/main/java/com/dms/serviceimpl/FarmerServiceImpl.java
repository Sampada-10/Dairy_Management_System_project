package com.dms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.entities.Farmer;
import com.dms.exception.ResourceNotFoundException;
import com.dms.model.FarmerDTO;
import com.dms.repository.FarmerRepository;
import com.dms.service.FarmerService;
import com.dms.utilities.FarmerConverter;

@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	private FarmerConverter farmerConverter;

	@Autowired
	private FarmerRepository farmerRepository;

	@Override
	public FarmerDTO addFarmer(FarmerDTO farmerDTO) {

		// Convert DTO to entity
		final Farmer farmer = farmerConverter.convertToFarmer(farmerDTO);

		// Save in database and convert to DTO return
		return farmerConverter.convertToFarmerDTO(farmerRepository.save(farmer));
	}

	@Override
	public List<FarmerDTO> getAllFarmer() {

		// Get data from data base
		List<Farmer> farmers = farmerRepository.findAll();

		// Create List of FarmerDTO
		List<FarmerDTO> allFarmers = new ArrayList<>();

		for (Farmer farmer : farmers) {
			allFarmers.add(farmerConverter.convertToFarmerDTO(farmer));

		}
		return allFarmers;
	}

	@Override
	public FarmerDTO getFarmer(int id) {

		Farmer farmer = farmerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Farmer", "id", id));
		return farmerConverter.convertToFarmerDTO(farmer);
	}

	@Override
	public String deleteFarmer(int id) {
		farmerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Farmer", "id", id));

		// Information is deleted
		farmerRepository.deleteById(id);

		return "farmer information deleted";
	}

	@Override
	public FarmerDTO updateFarmer(FarmerDTO farmerDTO, int id) {

		// Converting DTO to entity

		Farmer newFarmer = farmerConverter.convertToFarmer(farmerDTO);

		// Information is get from database if it is present
		Farmer farmer = farmerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Farmer", "id", id));

		// setting new values
		farmer.setAddress(newFarmer.getAddress());
		farmer.setName(newFarmer.getName());

		// Save info in database
		return farmerConverter.convertToFarmerDTO(farmerRepository.save(farmer));
	}

}
