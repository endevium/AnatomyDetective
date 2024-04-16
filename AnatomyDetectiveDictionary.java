package com.BIT5.AnatomyDetective;

import java.util.HashMap;
import java.util.Map;

public class AnatomyDetectiveDictionary {
	private Map<String, String> easyDictionary;
	private Map<String, String> averageDictionary;
	private Map<String, String> difficultDictionary;
	
	private Map<String, String> cardiovascular;
	private Map<String, String> digestive;
	private Map<String, String> endocrine;
	private Map<String, String> excretory;
	private Map<String, String> immune;
	private Map<String, String> integumentary;
	private Map<String, String> nervous;
	private Map<String, String> reproductive;
	private Map<String, String> respiratory;
	private Map<String, String> skeletal;
	
	public AnatomyDetectiveDictionary() {
		easyDictionary = new HashMap<>();
		easyDictionary.put("Skull", "assets/skull.png");
		easyDictionary.put("Leg", "assets/leg.png");
		easyDictionary.put("Hand", "assets/hand.png");
		easyDictionary.put("Eye", "assets/eye.png");
		easyDictionary.put("Liver", "assets/liver.png");
		easyDictionary.put("Kidney", "assets/kidney.png");
		easyDictionary.put("Lung", "assets/lung.png");
		easyDictionary.put("Teeth", "assets/teeth.png");
		easyDictionary.put("Neck", "assets/neck.png");
		easyDictionary.put("Stomach", "assets/stomach.png");
		easyDictionary.put("Brain", "assets/brain.png");
		
		averageDictionary = new HashMap<>();
		averageDictionary.put("testone", "assets/skull.png");
		averageDictionary.put("testtwo", "assets/leg.png");
		averageDictionary.put("testtree", "assets/hand.png");
		averageDictionary.put("testfour", "assets/eye.png");
		averageDictionary.put("testfive", "assets/liver.png");
		averageDictionary.put("testsix", "assets/kidney.png");
		averageDictionary.put("testseven", "assets/lung.png");
		averageDictionary.put("testeight", "assets/teeth.png");
		averageDictionary.put("testnine", "assets/neck.png");
		averageDictionary.put("testten", "assets/stomach.png");
		averageDictionary.put("testele", "assets/brain.png");
		
		difficultDictionary = new HashMap<>();
		difficultDictionary.put("Skull", "assets/skull.png");
		difficultDictionary.put("Leg", "assets/leg.png");
		difficultDictionary.put("Hand", "assets/hand.png");
		difficultDictionary.put("Eye", "assets/eye.png");
		difficultDictionary.put("Liver", "assets/liver.png");
		difficultDictionary.put("Kidney", "assets/kidney.png");
		difficultDictionary.put("Lung", "assets/lung.png");
		difficultDictionary.put("Teeth", "assets/teeth.png");
		difficultDictionary.put("Neck", "assets/neck.png");
		difficultDictionary.put("Stomach", "assets/stomach.png");
		difficultDictionary.put("Brain", "assets/brain.png");
		
		cardiovascular = new HashMap<>();
		cardiovascular.put("sk", "assets/skull.png");
		cardiovascular.put("le", "assets/leg.png");
		cardiovascular.put("ha", "assets/hand.png");
		cardiovascular.put("e", "assets/eye.png");
		cardiovascular.put("li", "assets/liver.png");
		cardiovascular.put("ki", "assets/kidney.png");
		cardiovascular.put("lu", "assets/lung.png");
		cardiovascular.put("te", "assets/teeth.png");
		cardiovascular.put("ne", "assets/neck.png");
		cardiovascular.put("st", "assets/stomach.png");
		cardiovascular.put("br", "assets/brain.png");
		
		digestive = new HashMap<>();
		digestive.put("le", "assets/leg.png");
		digestive.put("a", "assets/leg.png");
		digestive.put("b", "assets/leg.png");
		digestive.put("c", "assets/leg.png");
		digestive.put("d", "assets/leg.png");
		digestive.put("e", "assets/leg.png");
		digestive.put("f", "assets/leg.png");
		digestive.put("g", "assets/leg.png");
		digestive.put("h", "assets/leg.png");
		
		endocrine = new HashMap<>();
		endocrine.put("ha", "assets/hand.png");
		endocrine.put("a", "assets/hand.png");
		endocrine.put("b", "assets/hand.png");
		endocrine.put("c", "assets/hand.png");
		endocrine.put("d", "assets/hand.png");
		endocrine.put("e", "assets/hand.png");
		endocrine.put("f", "assets/hand.png");
		endocrine.put("g", "assets/hand.png");
		endocrine.put("h", "assets/hand.png");
		
		excretory = new HashMap<>();
		excretory.put("ey", "assets/eye.png");
		excretory.put("a", "assets/eye.png");
		excretory.put("b", "assets/eye.png");
		excretory.put("c", "assets/eye.png");
		excretory.put("d", "assets/eye.png");
		excretory.put("e", "assets/eye.png");
		excretory.put("f", "assets/eye.png");
		excretory.put("g", "assets/eye.png");
		excretory.put("h", "assets/eye.png");
		
		immune = new HashMap<>();
		immune.put("li", "assets/liver.png");
		immune.put("a", "assets/liver.png");
		immune.put("b", "assets/liver.png");
		immune.put("c", "assets/liver.png");
		immune.put("d", "assets/liver.png");
		immune.put("e", "assets/liver.png");
		immune.put("f", "assets/liver.png");
		immune.put("g", "assets/liver.png");
		immune.put("h", "assets/liver.png");
		
		integumentary = new HashMap<>();
		integumentary.put("Dermis", "assets/dermis.png");
		integumentary.put("Epidermis", "assets/epidermis.png");
		integumentary.put("Hair Follicle", "assets/hair_follicle.png");
		integumentary.put("Hypodermis", "assets/hypodermis.png");
		integumentary.put("Sebaceous Glands", "assets/sebaceous_glands.png");
		integumentary.put("Skin", "assets/skin.png");
		integumentary.put("Sweat Glands", "assets/sweat_glands.png");
		
		nervous = new HashMap<>();
		nervous.put("le", "assets/lung.png");
		nervous.put("a", "assets/lung.png");
		nervous.put("b", "assets/lung.png");
		nervous.put("c", "assets/lung.png");
		nervous.put("d", "assets/lung.png");
		nervous.put("e", "assets/lung.png");
		nervous.put("f", "assets/lung.png");
		nervous.put("g", "assets/lung.png");
		nervous.put("h", "assets/lung.png");
		
		reproductive = new HashMap<>();
		reproductive.put("le", "assets/teeth.png");
		reproductive.put("a", "assets/teeth.png");
		reproductive.put("b", "assets/teeth.png");
		reproductive.put("c", "assets/teeth.png");
		reproductive.put("d", "assets/teeth.png");
		reproductive.put("e", "assets/teeth.png");
		reproductive.put("f", "assets/teeth.png");
		reproductive.put("g", "assets/teeth.png");
		reproductive.put("h", "assets/teeth.png");
		
		respiratory = new HashMap<>();
		respiratory.put("le", "assets/neck.png");
		respiratory.put("a", "assets/neck.png");
		respiratory.put("b", "assets/neck.png");
		respiratory.put("c", "assets/neck.png");
		respiratory.put("d", "assets/neck.png");
		respiratory.put("e", "assets/neck.png");
		respiratory.put("f", "assets/neck.png");
		respiratory.put("g", "assets/neck.png");
		respiratory.put("h", "assets/neck.png");
		
		skeletal = new HashMap<>();
		skeletal.put("le", "assets/neck.png");
		skeletal.put("a", "assets/neck.png");
		skeletal.put("b", "assets/neck.png");
		skeletal.put("c", "assets/neck.png");
		skeletal.put("d", "assets/neck.png");
		skeletal.put("e", "assets/neck.png");
		skeletal.put("f", "assets/neck.png");
		skeletal.put("g", "assets/neck.png");
		skeletal.put("h", "assets/neck.png");
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
    
    public Map<String, String> getFirstTopic() {
        return cardiovascular;
    }
    
    public Map<String, String> getSecondTopic() {
        return digestive;
    }
    
    public Map<String, String> getThirdTopic() {
        return endocrine;
    }
    
    public Map<String, String> getFourthTopic() {
        return excretory;
    }
    
    public Map<String, String> getFifthTopic() {
        return immune;
    }
    
    public Map<String, String> getSixthTopic() {
        return integumentary;
    }
    
    public Map<String, String> getSeventhTopic() {
        return nervous;
    }
    
    public Map<String, String> getEighthTopic() {
        return reproductive;
    }
    
    public Map<String, String> getNinthTopic() {
        return respiratory;
    }
    
    public Map<String, String> getTenthTopic() {
        return skeletal;
    }
    
    
}
