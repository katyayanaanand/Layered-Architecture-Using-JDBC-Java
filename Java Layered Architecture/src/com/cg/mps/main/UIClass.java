package com.cg.mps.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.mps.dao.MPSDao;
import com.cg.mps.dao.MPSDaoImpl;
import com.cg.mps.exception.MPSException;
import com.cg.mps.model.MobileData;
import com.cg.mps.model.Purchase;
import com.cg.mps.service.MPSService;
import com.cg.mps.service.MPSServiceImpl;

public class UIClass {

	public static void main(String[] args) {

		MPSDao mpsDao = new MPSDaoImpl();
		MPSService mpsService = new MPSServiceImpl();
		Scanner scanner = new Scanner(System.in);
		String inputResult = "";
		do {

			System.out.println("**** Welcome to MPS **** ");
			System.out.println("1.insert Purchase Details");
			System.out.println("2.Get Mobile Details");
			System.out.println("3.Delete Mobile Detail on ID");
			System.out.println("4.Search mobile based on price range");
			System.out.println("5.exit");

			int input = 0;
			boolean inputFlag = false;

			do {
				scanner = new Scanner(System.in);
				System.out.println("Enter ur choice(1-5)");
				try {
					input = scanner.nextInt();
					inputFlag = true;
					String name = "";
					boolean nameFlag = false;

					switch (input) {
					case 1:
						scanner.nextLine();

						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter Name:");
							name = scanner.nextLine();
							try {
								mpsService.validateName(name);
								nameFlag = true;
							} catch (MPSException e) {
								nameFlag = false;
								System.err.println(e.getMessage());
							}
						} while (!nameFlag);

						String mailId = "";
						boolean mailFlag = false;

						do {

							scanner = new Scanner(System.in);
							System.out.println("Enter Email ID:");
							mailId = scanner.nextLine();
							try {
								mpsService.validateEmail(mailId);
								mailFlag = true;
							} catch (MPSException e) {
								mailFlag = false;
								System.err.println(e.getMessage());
							}
						} while (!mailFlag);

						long phoneNo = 0;
						boolean phoneFlag = false;

						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter phone number:");
							phoneNo = scanner.nextLong();
							try {

								mpsService.validatePhone(phoneNo);
								phoneFlag = true;
							} catch (InputMismatchException e) {
								phoneFlag = false;
								System.err.println("phone number should contain only digits");
							} catch (MPSException e) {
								System.err.println(e.getMessage());
							}
						} while (!phoneFlag);

						int mobileId = 0;
						boolean mobileFlag = false;

						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter mobileid:");
							mobileId = scanner.nextInt();
							try {
								mpsService.validateMobileId(mobileId);
								mobileFlag = true;
							} catch (MPSException e) {
								mobileFlag = false;
								System.err.println(e.getMessage());
							}
						} while (!mobileFlag);

						Purchase purchase = new Purchase(name, mailId, phoneNo, mobileId);

						try {
							int record = mpsService.insertPurchases(purchase);
							System.out.println(record + " record inserted");
						} catch (MPSException e) {
							System.err.println(e.getMessage());
						}

						break;

					case 2:
						try {
							List<MobileData> mobiles = mpsService.getAllMobiles();
							for(MobileData mobile : mobiles) {
								System.out.println(mobile);
							
						} }catch (MPSException e) {
							System.err.println(e.getMessage());
						}
						
						break;

					case 3:

						System.out.println("Enter mobile id for delete the record ");
						int id = scanner.nextInt();
						
						try {
							int result = mpsService.deleteMobileData(id);
							System.out.println(result+ " record deleted");
						} catch (MPSException e) {
							System.err.println(e.getMessage());
						}
						

						break;
						
					case 4:
						System.out.println("Enter the Minimum Value of Price");
						double cost1 = scanner.nextDouble();
						System.out.println("Enter the Maximum Value of Price");
						double cost2 = scanner.nextDouble();
						
						try {
							List<MobileData> mobiles = mpsService.getMobilesOnPrice(cost1, cost2);
							for(MobileData mobile : mobiles) {
								System.out.println(mobile);
							
						}
						} catch (MPSException e) {
							System.err.println(e.getMessage());
						}
						
						
						break;

						
					case 5:
						System.exit(0);
						break;

					default:
						System.out.println("enter in the range of 1 - 4");
						inputFlag = false;
						break;
					}
				} catch (InputMismatchException e) {
					inputFlag = false;
					System.err.println("input should contain only digits");
				}
			} while (!inputFlag);

			System.out.println("do you want to continue again: (yes/no)");
			inputResult = scanner.next();

		} while (inputResult.equalsIgnoreCase("yes"));

		scanner.close();

	}

}
