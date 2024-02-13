package com.fooddelivaryapp.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AutoGenerateId {
	
	
	public static int generateId() {
		
		int randomNumber = (int) (Math.random() * 100_000);
		
		
		return randomNumber;
		
	}
	
	public static void main(String[] args) {
//		System.out.println(generateId());
//		long timestamp = System.currentTimeMillis();
//        int randomNumber = (int) (Math.random() * 100_000); // Adjust the range as needed
//
//        String uniqueNumber = String.format("%d%05d", timestamp, randomNumber);
//        System.out.println(timestamp);
//
//        System.out.println("Generated Unique Number: " + uniqueNumber);
		
	}

}
