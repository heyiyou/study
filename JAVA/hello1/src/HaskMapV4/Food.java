package HaskMapV4;

import java.util.HashMap;

public class Food {
	String name;
	boolean isHot;
	int price;
	
	HashMap<String,String> global = new HashMap<>();
	
	public Food(String name, boolean isHot, int price, String engName, String chnName) {
		this.name = name;
		this.isHot = isHot;
		this.price = price;
		
		global.put("eng", engName);
		global.put("chn", chnName);
	}
}