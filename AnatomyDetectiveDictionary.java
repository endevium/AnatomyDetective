package com.BIT5.AnatomyDetective;

import java.util.HashMap;
import java.util.Map;

public class AnatomyDetectiveDictionary {
	private Map<String, String> easyDictionary;
	private Map<String, String> averageDictionary;
	private Map<String, String> difficultDictionary;
	
	private Map<String, String> firstTopic;
	private Map<String, String> secondTopic;
	private Map<String, String> thirdTopic;
	private Map<String, String> fourthTopic;
	private Map<String, String> fifthTopic;
	private Map<String, String> sixthTopic;
	private Map<String, String> seventhTopic;
	private Map<String, String> eighthTopic;
	private Map<String, String> ninthTopic;
	
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
		
		firstTopic = new HashMap<>();
		firstTopic.put("sk", ".//assets/skull.png");
		firstTopic.put("le", ".//assets/leg.png");
		firstTopic.put("ha", ".//assets/hand.png");
		firstTopic.put("e", ".//assets/eye.png");
		firstTopic.put("li", ".//assets/liver.png");
		firstTopic.put("ki", ".//assets/kidney.png");
		firstTopic.put("lu", ".//assets/lung.png");
		firstTopic.put("te", ".//assets/teeth.png");
		firstTopic.put("ne", ".//assets/neck.png");
		firstTopic.put("st", ".//assets/stomach.png");
		firstTopic.put("br", ".//assets/brain.png");
		
		secondTopic = new HashMap<>();
		secondTopic.put("le", ".//assets/leg.png");
		secondTopic.put("a", ".//assets/leg.png");
		secondTopic.put("b", ".//assets/leg.png");
		secondTopic.put("c", ".//assets/leg.png");
		secondTopic.put("d", ".//assets/leg.png");
		secondTopic.put("e", ".//assets/leg.png");
		secondTopic.put("f", ".//assets/leg.png");
		secondTopic.put("g", ".//assets/leg.png");
		secondTopic.put("h", ".//assets/leg.png");
		
		thirdTopic = new HashMap<>();
		thirdTopic.put("ha", ".//assets/hand.png");
		thirdTopic.put("a", ".//assets/hand.png");
		thirdTopic.put("b", ".//assets/hand.png");
		thirdTopic.put("c", ".//assets/hand.png");
		thirdTopic.put("d", ".//assets/hand.png");
		thirdTopic.put("e", ".//assets/hand.png");
		thirdTopic.put("f", ".//assets/hand.png");
		thirdTopic.put("g", ".//assets/hand.png");
		thirdTopic.put("h", ".//assets/hand.png");
		
		fourthTopic = new HashMap<>();
		fourthTopic.put("ey", ".//assets/eye.png");
		fourthTopic.put("a", ".//assets/eye.png");
		fourthTopic.put("b", ".//assets/eye.png");
		fourthTopic.put("c", ".//assets/eye.png");
		fourthTopic.put("d", ".//assets/eye.png");
		fourthTopic.put("e", ".//assets/eye.png");
		fourthTopic.put("f", ".//assets/eye.png");
		fourthTopic.put("g", ".//assets/eye.png");
		fourthTopic.put("h", ".//assets/eye.png");
		
		fifthTopic = new HashMap<>();
		fifthTopic.put("li", ".//assets/liver.png");
		fifthTopic.put("a", ".//assets/liver.png");
		fifthTopic.put("b", ".//assets/liver.png");
		fifthTopic.put("c", ".//assets/liver.png");
		fifthTopic.put("d", ".//assets/liver.png");
		fifthTopic.put("e", ".//assets/liver.png");
		fifthTopic.put("f", ".//assets/liver.png");
		fifthTopic.put("g", ".//assets/liver.png");
		fifthTopic.put("h", ".//assets/liver.png");
		
		sixthTopic = new HashMap<>();
		sixthTopic.put("le", ".//assets/kidney.png");
		sixthTopic.put("a", ".//assets/kidney.png");
		sixthTopic.put("b", ".//assets/kidney.png");
		sixthTopic.put("c", ".//assets/kidney.png");
		sixthTopic.put("d", ".//assets/kidney.png");
		sixthTopic.put("e", ".//assets/kidney.png");
		sixthTopic.put("f", ".//assets/kidney.png");
		sixthTopic.put("g", ".//assets/kidney.png");
		sixthTopic.put("h", ".//assets/kidney.png");
		
		seventhTopic = new HashMap<>();
		seventhTopic.put("le", ".//assets/lung.png");
		seventhTopic.put("a", ".//assets/lung.png");
		seventhTopic.put("b", ".//assets/lung.png");
		seventhTopic.put("c", ".//assets/lung.png");
		seventhTopic.put("d", ".//assets/lung.png");
		seventhTopic.put("e", ".//assets/lung.png");
		seventhTopic.put("f", ".//assets/lung.png");
		seventhTopic.put("g", ".//assets/lung.png");
		seventhTopic.put("h", ".//assets/lung.png");
		
		eighthTopic = new HashMap<>();
		eighthTopic.put("le", ".//assets/teeth.png");
		eighthTopic.put("a", ".//assets/teeth.png");
		eighthTopic.put("b", ".//assets/teeth.png");
		eighthTopic.put("c", ".//assets/teeth.png");
		eighthTopic.put("d", ".//assets/teeth.png");
		eighthTopic.put("e", ".//assets/teeth.png");
		eighthTopic.put("f", ".//assets/teeth.png");
		eighthTopic.put("g", ".//assets/teeth.png");
		eighthTopic.put("h", ".//assets/teeth.png");
		
		ninthTopic = new HashMap<>();
		ninthTopic.put("le", ".//assets/neck.png");
		ninthTopic.put("a", ".//assets/neck.png");
		ninthTopic.put("b", ".//assets/neck.png");
		ninthTopic.put("c", ".//assets/neck.png");
		ninthTopic.put("d", ".//assets/neck.png");
		ninthTopic.put("e", ".//assets/neck.png");
		ninthTopic.put("f", ".//assets/neck.png");
		ninthTopic.put("g", ".//assets/neck.png");
		ninthTopic.put("h", ".//assets/neck.png");
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
        return firstTopic;
    }
    
    public Map<String, String> getSecondTopic() {
        return secondTopic;
    }
    
    public Map<String, String> getThirdTopic() {
        return thirdTopic;
    }
    
    public Map<String, String> getFourthTopic() {
        return fourthTopic;
    }
    
    public Map<String, String> getFifthTopic() {
        return fifthTopic;
    }
    
    public Map<String, String> getSixthTopic() {
        return sixthTopic;
    }
    
    public Map<String, String> getSeventhTopic() {
        return seventhTopic;
    }
    
    public Map<String, String> getEighthTopic() {
        return eighthTopic;
    }
    
    public Map<String, String> getNinthTopic() {
        return ninthTopic;
    }
    
    
}
