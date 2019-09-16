package com.cg.mps.service;

import java.util.List;

import com.cg.mps.exception.MPSException;
import com.cg.mps.model.MobileData;
import com.cg.mps.model.Purchase;

public interface MPSService {

	public boolean validateName(String name) throws MPSException;

	public boolean validateEmail(String mailId) throws MPSException;

	public boolean validatePhone(long phoneNo) throws MPSException;

	public boolean validateMobileId(int mobileId) throws MPSException;
	
	public int insertPurchases(Purchase purchase) throws MPSException;

	public List<MobileData> getAllMobiles() throws MPSException;
		
	public int deleteMobileData(int id) throws MPSException;
	
	public List<MobileData> getMobilesOnPrice(double cost1,double cost2) throws MPSException;

	
	
}
