package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterestCalculate {

	public static void main(String args[]) {
	
		String borrowerId = "B1";
		String finDate = "16-Jan-2020";
		double totalAmt = 0;
		
		totalAmt  = calculateInterest(borrowerId,finDate);
		
		System.out.println(totalAmt);
		
	}

	public static double calculateInterest(String borrowerId,String finDate) {

		double totalAmt = 0;
		
		List<String> noOfFinances = getAllFinance(borrowerId);
		
		for(String finance : noOfFinances) {
			
			Map<String,Object> financeMap = getFinanceDetails(finance);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			
			double financeAmt = 0;
			try {
				Date financeCalculationDate = formatter.parse(finDate);   //date on which finance need to be calculated
				financeAmt = getTotalFiannceAmount(financeMap,financeCalculationDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			totalAmt = totalAmt + financeAmt;
			
		}
		
		return totalAmt;
		
	}


	private static List<String> getAllFinance(String borrowerId) {
		
		List<String> noOfFinaces = new ArrayList<>();
		
		//Data to be fetched from DB
		noOfFinaces.add("F1");
		
		return noOfFinaces;
	}
	
	private static Map<String, Object> getFinanceDetails(String finance) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Map<String, Object> financeDetailsMap = new HashMap<>();
		try {
			//Data to be fetched from DB
			financeDetailsMap.put("REFERENCE_NO", "F1");
			financeDetailsMap.put("LOAN_START_DT", formatter.parse("27-Dec-2019"));
			financeDetailsMap.put("NET_FINANCE_AMT", 766166.52);
			financeDetailsMap.put("LOAN_END_DT", formatter.parse("10-Jan-2020"));
			financeDetailsMap.put("PAST_DUE_DT", formatter.parse("20-Jan-2020"));  //if past due date is not there in table then add the grace days in loan end date to calculate past due date
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return financeDetailsMap;
				
	}

	private static float getInterestRates(Map<String, Object> financeMap, LocalDate dynamicLcoalDate) {
		float interestRate = 0;
		
		Date pastDueDate = (Date) financeMap.get("PAST_DUE_DT");
		LocalDate pastDueLocalDate = pastDueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		//Data to be fetched from DB
		if(dynamicLcoalDate.isBefore(pastDueLocalDate)) {
			interestRate = 14.05f;
		}else {
			interestRate = 16.05f;
		}
		
		return interestRate;
				
	}


	private static double getTotalFiannceAmount(Map<String, Object> financeMap, Date financeCalculationDate) {
		
		double totalFinanceAmt = 0;
		double totalInterestAmt = 0;
		Date loanStartDate = (Date) financeMap.get("LOAN_START_DT");
		//LocalDate loanStartLocalDate = loanStartDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate dynamicLcoalDate = loanStartDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate finCalLoaclDate = financeCalculationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		List<Map<String,Object>> finSettlementDetails = getFinanceSettlementDetails(financeMap);
		Month currentMonth = dynamicLcoalDate.getMonth();
		double netFinanceAmt = (double) financeMap.get("NET_FINANCE_AMT");
		while(!dynamicLcoalDate.isAfter(finCalLoaclDate)) {
			float interestRate = getInterestRates(financeMap,dynamicLcoalDate);
			
			if(null != finSettlementDetails && !finSettlementDetails.isEmpty()) {
				for(Map<String,Object> settlementMap : finSettlementDetails) {
					Date settlementDate = (Date) settlementMap.get("OPN_EFFECTIVE_DT");
					LocalDate settlementLocalDate = settlementDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					if(dynamicLcoalDate.equals(settlementLocalDate)) {
						double settlementAmt = (double) settlementMap.get("SETTL_AMT");
						netFinanceAmt = Math.round((netFinanceAmt + totalInterestAmt)*100d)/100d; 
						netFinanceAmt = Math.round((netFinanceAmt - settlementAmt)*100d)/100d;
						totalInterestAmt = 0;
					}
				}
			}
			
			Month newMonth = dynamicLcoalDate.getMonth();
			if(!currentMonth.equals(newMonth)) {
				//System.out.println(netFinanceAmt + ":Interest" +totalInterestAmt);
				netFinanceAmt = Math.round((netFinanceAmt + totalInterestAmt)*100d)/100d;
				totalInterestAmt = 0;
			}
			
			//System.out.println(netFinanceAmt + ":Interest" +totalInterestAmt);
			double interest = 0;
			if(dynamicLcoalDate.isLeapYear()) {
				interest = Math.round(((netFinanceAmt * interestRate * 1)/(100 * 365)) *100d)/100d;				
			}else {
				interest = Math.round(((netFinanceAmt * interestRate * 1)/(100 * 365)) *100d)/100d;
			}
			
			System.out.println("Date :" + dynamicLcoalDate + " and Amount : " + netFinanceAmt + "  and Interest : "  + interest);
			totalInterestAmt = totalInterestAmt + interest;
			
			currentMonth = dynamicLcoalDate.getMonth();
			dynamicLcoalDate = dynamicLcoalDate.plusDays(1);
		}
		
		totalFinanceAmt = netFinanceAmt + totalInterestAmt;
		return Math.round(totalFinanceAmt*100.00)/100.0;
	}

	private static List<Map<String, Object>> getFinanceSettlementDetails(Map<String, Object> financeMap) {
		
		//Data to be fetched from DB
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Map<String, Object> settlementMap = null;
		List<Map<String,Object>> settlementList = new ArrayList<>();
		try {
			
			settlementMap = new HashMap<>();
			settlementMap.put("REFERENCE_NO", "F1");
			settlementMap.put("OPN_EFFECTIVE_DT", formatter.parse("08-Jan-2020"));
			settlementMap.put("SETTL_AMT", 364173.51);
			
			settlementList.add(settlementMap);
			settlementMap = new HashMap<>();
			settlementMap.put("REFERENCE_NO", "F1");
			settlementMap.put("OPN_EFFECTIVE_DT", formatter.parse("10-Jan-2020"));
			settlementMap.put("SETTL_AMT", 200000.00);
			
			settlementList.add(settlementMap);
			
			settlementMap = new HashMap<>();
			settlementMap.put("REFERENCE_NO", "F1");
			settlementMap.put("OPN_EFFECTIVE_DT", formatter.parse("20-Jan-2020"));
			settlementMap.put("SETTL_AMT", 200000.00);
		
			settlementList.add(settlementMap);
			
			settlementMap = new HashMap<>();
			settlementMap.put("REFERENCE_NO", "F1");
			settlementMap.put("OPN_EFFECTIVE_DT", formatter.parse("25-Jan-2020"));
			settlementMap.put("SETTL_AMT", 6561.39);
		
			settlementList.add(settlementMap);
			
			settlementMap = new HashMap<>();
			settlementMap.put("REFERENCE_NO", "F1");
			settlementMap.put("OPN_EFFECTIVE_DT", formatter.parse("26-Jan-2020"));
			settlementMap.put("SETTL_AMT", 84.11);
		
			settlementList.add(settlementMap);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return settlementList;
	}
}
