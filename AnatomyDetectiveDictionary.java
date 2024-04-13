package com.BIT5.AnatomyDetective;

import java.util.HashMap;
import java.util.Map;

public class AnatomyDetectiveDictionary {
	private Map<String, String> easyDictionary;
	private Map<String, String> averageDictionary;
	private Map<String, String> difficultDictionary;
	
	public AnatomyDetectiveDictionary() {
		easyDictionary = new HashMap<>();
		easyDictionary.put("Skull", ".//assets/skull.png");
		easyDictionary.put("Leg", ".//assets/leg.png");
		easyDictionary.put("Hand", ".//assets/hand.png");
		easyDictionary.put("Eye", ".//assets/eye.png");
		easyDictionary.put("Liver", ".//assets/liver.png");
		easyDictionary.put("Kidney", ".//assets/kidney.png");
		easyDictionary.put("Lung", ".//assets/lung.png");
		easyDictionary.put("Teeth", ".//assets/teeth.png");
		easyDictionary.put("Neck", ".//assets/neck.png");
		easyDictionary.put("Stomach", ".//assets/stomach.png");
		easyDictionary.put("Brain", ".//assets/brain.png");
		
		averageDictionary = new HashMap<>();
		averageDictionary.put("testone", ".//assets/skull.png");
		averageDictionary.put("testtwo", ".//assets/leg.png");
		averageDictionary.put("testtree", ".//assets/hand.png");
		averageDictionary.put("testfour", ".//assets/eye.png");
		averageDictionary.put("testfive", ".//assets/liver.png");
		averageDictionary.put("testsix", ".//assets/kidney.png");
		averageDictionary.put("testseven", ".//assets/lung.png");
		averageDictionary.put("testeight", ".//assets/teeth.png");
		averageDictionary.put("testnine", ".//assets/neck.png");
		averageDictionary.put("testten", ".//assets/stomach.png");
		averageDictionary.put("testele", ".//assets/brain.png");
		
		difficultDictionary = new HashMap<>();
		difficultDictionary.put("Skull", ".//assets/skull.png");
		difficultDictionary.put("Leg", ".//assets/leg.png");
		difficultDictionary.put("Hand", ".//assets/hand.png");
		difficultDictionary.put("Eye", ".//assets/eye.png");
		difficultDictionary.put("Liver", ".//assets/liver.png");
		difficultDictionary.put("Kidney", ".//assets/kidney.png");
		difficultDictionary.put("Lung", ".//assets/lung.png");
		difficultDictionary.put("Teeth", ".//assets/teeth.png");
		difficultDictionary.put("Neck", ".//assets/neck.png");
		difficultDictionary.put("Stomach", ".//assets/stomach.png");
		difficultDictionary.put("Brain", ".//assets/brain.png");
	}
	
	public Map<String, String> getEasyDictionary() {
        return easyDictionary;
    }

    public Map<String, String> getAverageDictionary() {
        return averageDictionary;
    }

    public Map<String, String> getDifficultDictionary() {
        return difficultDictionary;
    }
}
