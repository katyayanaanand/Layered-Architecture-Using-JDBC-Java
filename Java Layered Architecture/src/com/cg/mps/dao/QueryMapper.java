package com.cg.mps.dao;

public interface QueryMapper {

	 String CREATE_MOBILE_QUERY = "CREATE TABLE mobile (mobileId NUMBER PRIMARY KEY, name VARCHAR2(20), price NUMBER(10,2), quantity VARCHAR2(20))";
	
	String GET_MOBILE_ID = "SELECT quantity FROM MOBILE WHERE mobileid = ?";
	
	String INSERT_PURCHASE_QUERY = "INSERT INTO purchasedetails values (purchaseid_seq.nextval,?,?,?,sysdate,?)";

	String UPDATE_MOBILE_QUERY = "UPDATE mobile SET quantity = quantity-1 WHERE mobileid = ?";

	

	String SELECT_ALL_MOBILES = "SELECT *FROM mobile";

	String DELETE_MOBILE_QUERY = "DELETE FROM mobile WHERE mobileid = ?";

	String SELECT_MOBILES_ON_PRICE = "SELECT *FROM mobile WHERE price BETWEEN ? AND ? ";
	
	
	
}
