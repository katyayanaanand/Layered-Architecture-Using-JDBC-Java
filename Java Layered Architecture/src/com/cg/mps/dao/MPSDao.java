package com.cg.mps.dao;

import java.util.List;

import com.cg.mps.exception.MPSException;
import com.cg.mps.model.MobileData;
import com.cg.mps.model.Purchase;

public interface MPSDao {

	public void createMobileMaster() throws MPSException;

	public int getmobileId(int mobileId) throws MPSException;

	public int insertPurchases(Purchase purchase) throws MPSException;

	public List<MobileData> getAllMobiles() throws MPSException;

	public int deleteMobileData(int id) throws MPSException;
	
	public List<MobileData> getMobilesOnPrice(double cost1,double cost2) throws MPSException;
}
