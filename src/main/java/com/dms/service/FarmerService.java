package com.dms.service;

import java.util.List;

import com.dms.model.FarmerDTO;

public interface FarmerService {
	
	FarmerDTO addFarmer(FarmerDTO farmerDTO);
	List<FarmerDTO> getAllFarmer();
	FarmerDTO getFarmer(int id);
	String deleteFarmer(int id);
	FarmerDTO updateFarmer(FarmerDTO farmerDTO,int id);
}
