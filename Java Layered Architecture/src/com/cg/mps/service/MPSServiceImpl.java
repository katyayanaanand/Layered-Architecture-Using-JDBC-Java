package com.cg.mps.service;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cg.mps.dao.MPSDao;
import com.cg.mps.dao.MPSDaoImpl;
import com.cg.mps.exception.MPSException;
import com.cg.mps.model.MobileData;
import com.cg.mps.model.Purchase;

public class MPSServiceImpl implements MPSService {

	
	MPSDao mpsDao = new MPSDaoImpl();
	
	@Override
	public boolean validateName(String name) throws MPSException {
		boolean nameFlag = false;
		String nameRegEx = "[A-Z]{1}[A-Za-z\\s]{4,19}";

		if (Pattern.matches(nameRegEx, name)) {
			nameFlag = true;
		} else {
			throw new MPSException("First letter should be capital and lenght in the range of 5 to 20");
		}
		return nameFlag;
	}

	@Override
	public boolean validateEmail(String mailId) throws MPSException {
		
		boolean mailFlag =false;
			
		
		String mailRegEx = "[a-zA-Z0-9._-]+@[a-zA-Z]+[.][a-zA-Z]+";
		
		if (Pattern.matches(mailRegEx, mailId)) {
			mailFlag = true;
		} else {
			throw new MPSException("Please  enter email id in proper format");
		}
		return mailFlag;

}

	@Override
	public boolean validatePhone(long phoneNo) throws MPSException {
		boolean phoneFlag = false;
		String phoneRegEx = "[6|7|8|9]{1}[0-9]{9}";

		String phoneNumber = String.valueOf(phoneNo);

		if (Pattern.matches(phoneRegEx, phoneNumber)) {
			phoneFlag = true;
		} else {
			throw new MPSException("phone number should contain exactly 10 digits");
		}
		return phoneFlag;
	}

	@Override
	public boolean validateMobileId(int mobileId) throws MPSException {
		
				boolean mobileFlag =false;
				int id =	mpsDao.getmobileId(mobileId);
				
				if (id !=0) {
					mobileFlag = true;
				} else {
					throw new MPSException("Following id does not exist");
				}
				return mobileFlag;
	}

	@Override
	public int insertPurchases(Purchase purchase) throws MPSException {
		
		return mpsDao.insertPurchases(purchase);
		
	}

	@Override
	public List<MobileData> getAllMobiles() throws MPSException {
		return mpsDao.getAllMobiles();
	}

	@Override
	public int deleteMobileData(int id) throws MPSException {
		
		return mpsDao.deleteMobileData(id);
	}

	@Override
	public List<MobileData> getMobilesOnPrice(double cost1,double cost2) throws MPSException {
		
		return mpsDao.getMobilesOnPrice(cost1, cost2);
	}
	
	
}