package com.dms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.entities.DairyOwner;
import com.dms.entities.Farmer;
import com.dms.exception.ResourceNotFoundException;
import com.dms.repository.DairyOwnerRepository;
import com.dms.repository.FarmerRepository;
import com.dms.service.DairyOwnerService;
import com.dms.utilities.DairyOwnerConverter;

@Service
public class DairyOwnerImpl implements DairyOwnerService {

	@Autowired
	DairyOwnerRepository dairyRepository;
	
	@Autowired
	FarmerRepository farmerRepository;

	@Autowired
	DairyOwnerConverter dairyOwnerConverter;

	@Override
	public String addFarmerById(int fid) {
		
		//Find the farmer in db
		Farmer farmer=farmerRepository.  findById(fid).orElseThrow(()->
		new ResourceNotFoundException("Farmer", "fid", fid));
		
		DairyOwner dairyOwner=new  DairyOwner();
		//Create list
		List<Farmer> newFarmer= new ArrayList<>();
		//add customer in list
		newFarmer.add(farmer);
		
		//add farmer in dairy owner
		dairyOwner.setFarmers(newFarmer);
		
		farmer.setDairyOwner(dairyOwner);
		
		//save info in data base
		dairyRepository.save(dairyOwner);
		farmerRepository.save(farmer);
		
		return "farmer information added succesfully";
	}

}
