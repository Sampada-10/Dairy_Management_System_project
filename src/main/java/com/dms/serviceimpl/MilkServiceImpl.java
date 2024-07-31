package com.dms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.entities.Milk;
import com.dms.model.MilkDTO;
import com.dms.repository.MilkRepository;
import com.dms.service.MilkService;
import com.dms.utilities.MilkConverter;

@Service
public class MilkServiceImpl implements MilkService{

	//It is use to inject dependency
	@Autowired
	MilkRepository milkRepository;
	
	@Autowired
	MilkConverter milkConverter;
	@Override
	public MilkDTO addMilk(MilkDTO milkDTO) {
		//Convert milk dto to milk
		Milk milk=milkConverter.convertToMilk(milkDTO);
		
		//Save data in database
		Milk saveInfo = milkRepository.save(milk);
		
		//Convert and return milk to dto
		return milkConverter.convertToMilkDTO(saveInfo);
	}
	@Override
	public List<MilkDTO> getAllMilkDetails() {
		//Store all info in list
		List<Milk> milkInfo=milkRepository.findAll();
		
		//Create array list of milkDTO class
		List<MilkDTO> list= new ArrayList<>();
		
		//convert and add milk into list
		milkInfo.forEach(milk->list.add(milkConverter.convertToMilkDTO(milk)));
		return list;
	}
	

}
