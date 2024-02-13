package com.fooddelivaryapp.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingPassword {
	static String hashing(String password) {
		try {
			MessageDigest hash=MessageDigest.getInstance("MD5");
			hash.update(password.getBytes());
			byte[] digest = hash.digest();
			
			StringBuilder string = new StringBuilder();
			
			for(byte b:digest) {
				string.append(String.format("%02x", b));
			}
			
			return string.toString();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	

}
