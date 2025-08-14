package com.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CurrencyGrouping {

	public static void main(String[] args) {
		
		/*
		 * List<HashMap<String,String>> exchangeRateList = new ArrayList<>();
		 * 
		 * HashMap<String,String> exchangeMap = new HashMap<>();
		 * 
		 * exchangeMap.put("CURR_PAIR", "AED/EUR"); exchangeMap.put("EXCHANGE_RATE",
		 * "4.63663"); exchangeMap.put("ASONDATE", "01-FEB-2020");
		 * exchangeRateList.add(exchangeMap);
		 * 
		 * exchangeMap = new HashMap<>(); exchangeMap.put("CURR_PAIR", "AED/EUR");
		 * exchangeMap.put("EXCHANGE_RATE", "4.63663"); exchangeMap.put("ASONDATE",
		 * "02-FEB-2020"); exchangeRateList.add(exchangeMap);
		 * 
		 * exchangeMap = new HashMap<>(); exchangeMap.put("CURR_PAIR", "AED/EUR");
		 * exchangeMap.put("EXCHANGE_RATE", "4.63663"); exchangeMap.put("ASONDATE",
		 * "03-FEB-2020"); exchangeRateList.add(exchangeMap);
		 * 
		 * exchangeMap = new HashMap<>(); exchangeMap.put("CURR_PAIR", "AED/GBP");
		 * exchangeMap.put("EXCHANGE_RATE", "4.63663"); exchangeMap.put("ASONDATE",
		 * "01-FEB-2020"); exchangeRateList.add(exchangeMap);
		 * 
		 * exchangeMap = new HashMap<>(); exchangeMap.put("CURR_PAIR", "AED/GBP");
		 * exchangeMap.put("EXCHANGE_RATE", "4.63663"); exchangeMap.put("ASONDATE",
		 * "02-FEB-2020"); exchangeRateList.add(exchangeMap);
		 * 
		 * exchangeMap = new HashMap<>(); exchangeMap.put("CURR_PAIR", "AED/GBP");
		 * exchangeMap.put("EXCHANGE_RATE", "4.63663"); exchangeMap.put("ASONDATE",
		 * "03-FEB-2020"); exchangeRateList.add(exchangeMap);
		 */
		
		List<HashMap<String,String>> limitList = new ArrayList<>();
		
		HashMap<String,String> exchangeMap = new HashMap<>();
		
		exchangeMap.put("DESCRIPTION", "NFCAP");
		exchangeMap.put("APPROVED", "4000000.4");
		exchangeMap.put("UTILIZED", "200000.6");
		exchangeMap.put("AVAILABLE", "3799999.8");
		exchangeMap.put("CURRENCY", "AED");
		exchangeMap.put("ASONDATE", "16-FEB-2020");
		limitList.add(exchangeMap);
		
		exchangeMap = new HashMap<>();		
		exchangeMap.put("DESCRIPTION", "FDCAP");
		exchangeMap.put("APPROVED", "4000000.2");
		exchangeMap.put("UTILIZED", "100000.3");
		exchangeMap.put("AVAILABLE", "3899999.9");
		exchangeMap.put("CURRENCY", "USD");
		exchangeMap.put("ASONDATE", "16-FEB-2020");
		limitList.add(exchangeMap);
		
		exchangeMap = new HashMap<>();		
		exchangeMap.put("DESCRIPTION", "FDCAP");
		exchangeMap.put("APPROVED", "6000000.4");
		exchangeMap.put("UTILIZED", "200000.6");
		exchangeMap.put("AVAILABLE", "5799999.8");
		exchangeMap.put("CURRENCY", "AED");
		exchangeMap.put("ASONDATE", "16-FEB-2020");
		limitList.add(exchangeMap);
		
		exchangeMap = new HashMap<>();		
		exchangeMap.put("DESCRIPTION", "NFCAP");
		exchangeMap.put("APPROVED", "3000000.2");
		exchangeMap.put("UTILIZED", "100000.3");
		exchangeMap.put("AVAILABLE", "2899999.9");
		exchangeMap.put("CURRENCY", "USD");
		exchangeMap.put("ASONDATE", "16-FEB-2020");
		limitList.add(exchangeMap);
		
		exchangeMap = new HashMap<>();		
		exchangeMap.put("DESCRIPTION", "TOTAL");
		exchangeMap.put("APPROVED", "6000000.2");
		exchangeMap.put("UTILIZED", "300000.3");
		exchangeMap.put("AVAILABLE", "5699999.9");
		exchangeMap.put("CURRENCY", "USD");
		exchangeMap.put("ASONDATE", "16-FEB-2020");
		limitList.add(exchangeMap);
		
		exchangeMap = new HashMap<>();		
		exchangeMap.put("DESCRIPTION", "TOTAL");
		exchangeMap.put("APPROVED", "9000000.4");
		exchangeMap.put("UTILIZED", "600000.6");
		exchangeMap.put("AVAILABLE", "8399999.8");
		exchangeMap.put("CURRENCY", "AED");
		exchangeMap.put("ASONDATE", "16-FEB-2020");
		limitList.add(exchangeMap);

		Map<String, List<HashMap<String, String>>> convertedMap = limitList.stream().collect(Collectors.groupingBy(x -> x.get("DESCRIPTION").toString()));
		
		System.out.println(convertedMap);
		
		String localCcy = "AED";
		List<HashMap> exhangeRateList = new ArrayList<>();
		exchangeMap = new HashMap<>();
		exchangeMap.put("CURRENCY", "AED");
		exchangeMap.put("COUNTER_CURRENCY", "USD");
		exchangeMap.put("EXCHANGE_RATE", "3.67");
		exhangeRateList.add(exchangeMap);
		
		exchangeMap = new HashMap<>();
		exchangeMap.put("CURRENCY", "AED");
		exchangeMap.put("COUNTER_CURRENCY", "AED");
		exchangeMap.put("EXCHANGE_RATE", "1");
		exhangeRateList.add(exchangeMap);
		
		
		
		List<Map<String,Object>> finalList = new ArrayList<>();
		
		convertedMap.forEach((k,v) -> {
			Map<String,Object> finalMap =  getLimitDetails(localCcy,v,exhangeRateList);
			finalMap.put("DESCRIPTION", k);
			finalMap.put("CURRENCY", localCcy);
			finalList.add(finalMap);
		});
		
		System.out.println(finalList);
			
	}

	private static HashMap<String, Object> getLimitDetails(String localCcy,List<HashMap<String, String>> limitList, List<HashMap> exhangeRateList) {
		HashMap<String,Object> innerMap = new HashMap<>();
		BigDecimal approvedAmt = new BigDecimal(0);
		BigDecimal utilizedAmt = new BigDecimal(0);
		BigDecimal availableAmt = new BigDecimal(0);
		String asondate = "";
		for(HashMap<String,String> limitMap : limitList) {
			String counterCurrency = limitMap.get("CURRENCY");
			asondate = limitMap.get("ASONDATE");
			approvedAmt = approvedAmt.add(getConvertedValue(localCcy,counterCurrency,limitMap.get("APPROVED"),exhangeRateList));
			utilizedAmt = utilizedAmt.add(getConvertedValue(localCcy,counterCurrency,limitMap.get("UTILIZED"),exhangeRateList));
			availableAmt = availableAmt.add(getConvertedValue(localCcy,counterCurrency,limitMap.get("AVAILABLE"),exhangeRateList));
		}
		
		innerMap.put("APPROVED", approvedAmt);
		innerMap.put("UTILIZED", utilizedAmt);
		innerMap.put("AVAILABLE", availableAmt);
		innerMap.put("ASONDATE", asondate);
		
		return innerMap;
	}

	private static BigDecimal getConvertedValue(String localCcy, String counterCurrency, String amount, List<HashMap> exhangeRateList) {
		BigDecimal conAmount = new BigDecimal(amount);
		List<HashMap> newExchangeRateList = exhangeRateList.stream().filter(x  -> x.get("COUNTER_CURRENCY").equals(counterCurrency)).collect(Collectors.toList());
		HashMap exchangeMap = newExchangeRateList.get(0);
		BigDecimal exRate = new BigDecimal(exchangeMap.get("EXCHANGE_RATE").toString());
		BigDecimal newValue = conAmount.multiply(exRate);
		return newValue;
	}

}
