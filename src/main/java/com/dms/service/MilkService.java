package com.dms.service;

import java.util.List;

import com.dms.model.MilkDTO;

public interface MilkService{
	
	public MilkDTO addMilk(MilkDTO milkDTO);
	public List<MilkDTO> getAllMilkDetails();
}
