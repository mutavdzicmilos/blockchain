package blockchain;

import java.security.MessageDigest;

public class HesiranjeKradeno {
	
	//nacin na koji se izvrsava hashcode jer nije moguce da dva razlicita unosa daju isti hashcode. Ovo je razvila 
	//Americka bezbednosna agencija
	public static String applySha256(String input){		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");	        
			byte[] hash = digest.digest(input.getBytes("UTF-8"));	        
			StringBuffer hexString = new StringBuffer(); 
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static String getDificultyString(int difficulty) {
		return new String(new char[difficulty]).replace('\0', '0');
	}
}