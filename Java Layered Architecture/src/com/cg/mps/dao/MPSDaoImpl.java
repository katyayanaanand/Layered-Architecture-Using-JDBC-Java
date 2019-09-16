package com.cg.mps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cg.mps.exception.MPSException;
import com.cg.mps.model.MobileData;
import com.cg.mps.model.Purchase;
import com.cg.mps.utility.JDBC_Utility;

public class MPSDaoImpl implements MPSDao {

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	Logger logger = Logger.getLogger(MPSDaoImpl.class);
	@Override
	public void createMobileMaster() throws MPSException {

		connection = JDBC_Utility.getconnection();
		logger.info("connection established");

		try {
			statement = connection.prepareStatement(QueryMapper.CREATE_MOBILE_QUERY);
			logger.debug("statement created");
			statement.execute();
			logger.info("table created");
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new MPSException("problem in creating table");
		} finally {
			try {
				logger.debug("before closing statement");
				statement.close();
				
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MPSException("unable to close statement");
			}
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MPSException("unable to close connection");
			}
		}
	}

	public int getmobileId(int mobileId) throws MPSException {
		int id = 0;
		connection = JDBC_Utility.getconnection();
		logger.info("statement created");
		try {
			statement = connection.prepareStatement(QueryMapper.GET_MOBILE_ID);
			statement.setLong(1, mobileId);
			id = statement.executeUpdate();

		} catch (SQLException e) {
			throw new MPSException("Problem in fetching data from table");
		}

		return id;

	}

	@Override
	public int insertPurchases(Purchase purchase) throws MPSException {
		int result = 0;
		connection = JDBC_Utility.getconnection();

		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(QueryMapper.INSERT_PURCHASE_QUERY);
			statement.setString(1, purchase.getCustomer_name());
			statement.setString(2, purchase.getMailId());
			statement.setLong(3, purchase.getPhoneNo());
			statement.setInt(4, purchase.getMobileId());

			statement.executeUpdate();
			connection.commit();

			statement = connection.prepareStatement(QueryMapper.UPDATE_MOBILE_QUERY);
			statement.setInt(1, purchase.getMobileId());
			result = statement.executeUpdate();

			connection.commit();
		} catch (SQLException e) {
			// connection.rollback();
			throw new MPSException("problem while creating prepared statement object");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new MPSException("closed");
			}
		}

		return result;

	}

	public List<MobileData> getAllMobiles() throws MPSException {

		List<MobileData> mobiles = new ArrayList<>();

		connection = JDBC_Utility.getconnection();
		try {
			statement = connection.prepareStatement(QueryMapper.SELECT_ALL_MOBILES);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("mobileid");
				String name = resultSet.getString("name");
				double price = resultSet.getDouble("price");
				int quantity = resultSet.getInt("quantity");

				MobileData mobile = new MobileData(id, name, price, quantity);

				mobiles.add(mobile);
			}

		} catch (SQLException e) {
			throw new MPSException("Problem in fetching data ");
		}

		return mobiles;
	}

	@Override
	public int deleteMobileData(int id1) throws MPSException {
		int result=0;
		connection = JDBC_Utility.getconnection();

		try {
			statement = connection.prepareStatement(QueryMapper.DELETE_MOBILE_QUERY);
			statement.setInt(1, id1);
			
			result =statement.executeUpdate();
			connection.commit();
			

		} catch (SQLException e) {

			throw new MPSException("Please Enter the valid ID");
		}
		
		return result;
	}

	@Override
	public List<MobileData> getMobilesOnPrice(double cost1, double cost2) throws MPSException {
		List<MobileData> mobiles = new ArrayList<>();

		connection = JDBC_Utility.getconnection();
		try {
			statement = connection.prepareStatement(QueryMapper.SELECT_MOBILES_ON_PRICE);
			statement.setDouble(1, cost1);
			statement.setDouble(2, cost2);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("mobileid");
				String name = resultSet.getString("name");
				double price = resultSet.getDouble("price");
				int quantity = resultSet.getInt("quantity");

				MobileData mobile = new MobileData(id, name, price, quantity);

				mobiles.add(mobile);
			}

		} catch (SQLException e) {
			throw new MPSException("Problem in fetching data ");
		}

		return mobiles;

	}

}
