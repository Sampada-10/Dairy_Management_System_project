package com.dms.service;

import java.util.List;

import com.dms.model.BillDTO;

public interface BillService {
	
	BillDTO generateBill(BillDTO billDTO);
	List<BillDTO> getAllBills();
}
