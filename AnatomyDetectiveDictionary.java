package com.BIT5.AnatomyDetective;

import java.util.HashMap;
import java.util.Map;

public class AnatomyDetectiveDictionary {
	private Map<String, String> dictionary;
	
	public AnatomyDetectiveDictionary() {
		dictionary = new HashMap<>();
		dictionary.put("skull", ".//assets/skull.png");
		dictionary.put("leg", ".//assets/leg.png");
		dictionary.put("hand", ".//assets/hand.png");
		dictionary.put("eye", ".//assets/eye.png");
		dictionary.put("liver", ".//assets/liver.png");
		dictionary.put("kidney", ".//assets/kidney.png");
		dictionary.put("lung", ".//assets/lung.png");
		dictionary.put("teeth", ".//assets/teeth.png");
		dictionary.put("neck", ".//assets/neck.png");
		dictionary.put("stomach", ".//assets/stomach.png");
		dictionary.put("brain", ".//assets/brain.png");
	}
	
	public Map<String, String> accessDictionary() {
		return dictionary;
	}
}
