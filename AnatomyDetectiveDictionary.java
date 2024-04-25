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
		easyDictionary.put("Aorta", "assets/aorta.png");
		easyDictionary.put("Kidney", "assets/kidney.png");
		easyDictionary.put("Anus", "assets/anus.png");
		easyDictionary.put("Esophagus", "assets/esophagus.png");
		easyDictionary.put("Gallbladder", "assets/gallbladder.png");
		easyDictionary.put("Stomach", "assets/stomach.png");
		easyDictionary.put("Liver", "assets/liver.png");
		easyDictionary.put("Mouth", "assets/mouth.png");
		easyDictionary.put("Pancreas", "assets/pancreas.png");;
		easyDictionary.put("Small intestine", "assets/small_intestines.png");
		easyDictionary.put("Large intestine", "assets/large_intestines.png");
		easyDictionary.put("Testes", "assets/testes.png");
		easyDictionary.put("Ovaries", "assets/ovaries.png");
		easyDictionary.put("Skin", "assets/skin.png");
		easyDictionary.put("Hair Follicle", "assets/hair_follicle.png");
		easyDictionary.put("Diaphragm", "assets/diaphragm.png");
		easyDictionary.put("Left lung", "assets/left_lung.png");
		easyDictionary.put("Right lung", "assets/right_lung.png");
		easyDictionary.put("Nose", "assets/nose.png");
		easyDictionary.put("Bladder", "assets/bladder.png");
		easyDictionary.put("Urethra", "assets/urethra_men.png");
		easyDictionary.put("Foreskin", "assets/foreskin.png");
		easyDictionary.put("Vagina", "assets/vagina.png");
		easyDictionary.put("Testicles", "assets/testicles.png");
		easyDictionary.put("Uterus", "assets/uterus.png");
		easyDictionary.put("Prostate", "assets/prostate.png");
		easyDictionary.put("Bone marrow", "assets/bone_marrow.png");
		easyDictionary.put("Spleen", "assets/spleen.png");
		easyDictionary.put("Brain", "assets/brain.png");
		easyDictionary.put("Parietal lobe", "assets/parietal_lobe.png");
		easyDictionary.put("Frontal lobe", "assets/frontal_lobe.png");
		easyDictionary.put("Occipital lobe", "assets/occipital_lobe.png");
		easyDictionary.put("Ribs", "assets/ribs.png");	
		easyDictionary.put("Skull", "assets/skull.png");
		
		averageDictionary = new HashMap<>();
		averageDictionary.put("Left ventricle", "assets/left_ventricle.png");
		averageDictionary.put("Right ventricle", "assets/right_ventricle.png");
		averageDictionary.put("Left atrium", "assets/left_atrium.png");
		averageDictionary.put("Right atrium", "assets/right_atrium.png");
		averageDictionary.put("Pulmonary vein", "assets/pulmonary_vein.png");
		averageDictionary.put("Pulmonary artery", "assets/pulmonary_artery.png");
		averageDictionary.put("Superior vena cava", "assets/superior_vena_cava.png");
		averageDictionary.put("Appendix", "assets/appendix.png");
		averageDictionary.put("Rectum", "assets/rectum.png");
		averageDictionary.put("Hypothalamus", "assets/hypothalamus.png");
		averageDictionary.put("Thymus", "assets/thymus.png");
		averageDictionary.put("Pituitary gland", "assets/pituitary_gland.png");
		averageDictionary.put("Dermis", "assets/dermis.png");
		averageDictionary.put("Epidermis", "assets/epidermis.png");
		averageDictionary.put("Hypodermis", "assets/hypodermis.png");
		averageDictionary.put("Bronchus", "assets/bronchus.png");
		averageDictionary.put("Bronchioles", "assets/bronchioles.png");
		averageDictionary.put("Larynx", "assets/larynx.png");
		averageDictionary.put("Pharynx", "assets/pharynx.png");
		averageDictionary.put("Nasal cavity", "assets/nasal_cavity.png");
		averageDictionary.put("Trachea", "assets/trachea.png");
		averageDictionary.put("Ureter", "assets/ureter.png");
		averageDictionary.put("Cervix", "assets/cervix.png");
		averageDictionary.put("Ovarian ligament", "assets/ovarian_ligament.png");
		averageDictionary.put("Endometrium", "assets/endometrium.png");
		averageDictionary.put("Urethral opening", "assets/urethral_opening.png");
		averageDictionary.put("Cervical canal", "assets/cervical_canal.png");
		averageDictionary.put("Tonsil", "assets/tonsils.png");
		averageDictionary.put("Thymus", "assets/thymus2.png");
		averageDictionary.put("Femur", "assets/femur.png");
		averageDictionary.put("Shoulder blades", "assets/shoulder_blades.png");

		
		
		difficultDictionary = new HashMap<>();
		difficultDictionary.put("Tricuspid valve", "assets/tricuspid_valve.png");
		difficultDictionary.put("Septum", "assets/septum.png");
		difficultDictionary.put("Mitral valve", "assets/mitral_valve.png");
		difficultDictionary.put("Pulmonary valve", "assets/pulmonary_valve.png");
		difficultDictionary.put("Aortic valve", "assets/aortic_valve.png");
		difficultDictionary.put("Salivary glands", "assets/salivary_glands.png");
		difficultDictionary.put("Adrenal gland", "assets/adrenal_gland.png");
		difficultDictionary.put("Pineal gland", "assets/pineal_gland.png");
		difficultDictionary.put("Parathyroid gland", "assets/parathyroid_glands.png");
		difficultDictionary.put("Thyroid gland", "assets/thyroid_gland.png");
		difficultDictionary.put("Sebaceous Gland", "assets/sebaceous_glands.png");
		difficultDictionary.put("Sweat Gland", "assets/sweat_glands.png");
		difficultDictionary.put("Alveoli", "assets/alveoli.png");
		difficultDictionary.put("Frontal sinus", "assets/frontal_sinus.png");
		difficultDictionary.put("Nasal conchae", "assets/nasal_conchae.png");
		difficultDictionary.put("Sphenoidal sinus", "assets/sphenoidal_sinus.png");
		difficultDictionary.put("Epididymis", "assets/epididymis.png");
		difficultDictionary.put("Infundibulum", "assets/infundibulum.png");
		difficultDictionary.put("Vena cava", "assets/vena_cava.png");
		difficultDictionary.put("Seminal vesicle", "assets/seminal_vesicle.png");
		difficultDictionary.put("Uterine fundus", "assets/uterine_fundus.png");
		difficultDictionary.put("Cervical nerve", "assets/cervical_nerves.png");
		difficultDictionary.put("Lumbar nerve", "assets/lumbar_nerves.png");
		difficultDictionary.put("Peripheral leg nerve", "assets/peripheral_leg_nerves.png");
		difficultDictionary.put("Sacral nerve", "assets/sacral_nerves.png");
		difficultDictionary.put("Spinal cord", "assets/spinal_cord.png");
		difficultDictionary.put("Tibial nerve", "assets/tibial_nerve.png");
		difficultDictionary.put("Sciatic nerve", "assets/sciatic_nerve.png");
		difficultDictionary.put("Temporal nerve", "assets/temporal_nerve.png");
		difficultDictionary.put("Thoracic nerve", "assets/thoracic nerve.png");
		difficultDictionary.put("Coccyx", "assets/coccyx.png");
		difficultDictionary.put("Fibula", "assets/fibula.png");
		difficultDictionary.put("Tibia", "assets/tibia.png");

		
		// Topics
		
		cardiovascular = new HashMap<>();
		cardiovascular.put("Aorta", "assets/aorta.png");
		cardiovascular.put("Aortic valve", "assets/aortic_valve.png");
		cardiovascular.put("Left ventricle", "assets/left_ventricle.png");
		cardiovascular.put("Septum", "assets/septum.png");
		cardiovascular.put("Left atrium", "assets/left_atrium.png");
		cardiovascular.put("Mitral valve", "assets/mitral_valve.png");
		cardiovascular.put("Pulmonary artery", "assets/pulmonary_artery.png");
		cardiovascular.put("Pulmonary valve", "assets/pulmonary_valve.png");
		cardiovascular.put("Pulmonary vein", "assets/pulmonary_vein.png");
		cardiovascular.put("Right atrium", "assets/right_atrium.png");
		cardiovascular.put("Right ventricle", "assets/right_ventricle.png");
		cardiovascular.put("Superior vena cava", "assets/superior_vena_cava.png");
		cardiovascular.put("Tricuspid valve", "assets/tricuspid_valve.png");
		
		digestive = new HashMap<>();
		digestive.put("Anus", "assets/anus.png");
		digestive.put("Appendix", "assets/appendix.png");
		digestive.put("Esophagus", "assets/esophagus.png");
		digestive.put("Gallbladder", "assets/gallbladder.png");
		digestive.put("Large intestine", "assets/large_intestines.png");
		digestive.put("Liver", "assets/liver.png");
		digestive.put("Mouth", "assets/mouth.png");
		digestive.put("Pancreas", "assets/pancreas.png");
		digestive.put("Rectum", "assets/rectum.png");
		digestive.put("Salivary gland", "assets/salivary_glands.png");
		digestive.put("Small intestine", "assets/small_intestines.png");
		digestive.put("Stomach", "assets/stomach.png");
		
		endocrine = new HashMap<>();
		endocrine.put("Adrenal gland", "assets/adrenal_gland.png");
		endocrine.put("Ovaries", "assets/ovaries.png");
		endocrine.put("Pancreas", "assets/pancreas.png");
		endocrine.put("Pituitary gland", "assets/pituitary_gland.png");
		endocrine.put("Thyroid gland", "assets/thyroid_gland.png");
		endocrine.put("Thymus", "assets/thymus.png");
		endocrine.put("Pineal gland", "assets/pineal_gland.png");
		endocrine.put("Testes", "assets/testes.png");
		endocrine.put("Hypothalamus", "assets/hypothalamus.png");
		endocrine.put("Kidneys", "assets/kidney.png");
		endocrine.put("Parathyroid gland", "assets/parathyroid_glands.png");
		
		excretory = new HashMap<>();
		excretory.put("Aorta", "assets/aorta2.png");
		excretory.put("Bladder", "assets/bladder.png");
		excretory.put("Kidney", "assets/kidney2.png");
		excretory.put("Renal artery", "assets/renal_artery.png");
		excretory.put("Renal vein", "assets/renal_vein.png");
		excretory.put("Ureter", "assets/ureter.png");
		excretory.put("Urethra", "assets/urethra.png");
		excretory.put("Vena cava", "assets/vena_cava.png");
		
		immune = new HashMap<>();
		immune.put("Bone marrow", "assets/bone_marrow.png"); 
		immune.put("Lympathic vessels", "assets/lympathic_vessels.png");
		immune.put("Lymph nodes", "assets/lymph_nodes.png");
		immune.put("Spleen", "assets/spleen.png"); 
		immune.put("Thymus", "assets/thymus2.png"); 
		immune.put("Tonsils", "assets/tonsils.png"); 
		
		integumentary = new HashMap<>();
		integumentary.put("Dermis", "assets/dermis.png");
		integumentary.put("Epidermis", "assets/epidermis.png");
		integumentary.put("Hair Follicle", "assets/hair_follicle.png");
		integumentary.put("Hypodermis", "assets/hypodermis.png");
		integumentary.put("Sebaceous Glands", "assets/sebaceous_glands.png");
		integumentary.put("Skin", "assets/skin.png");
		integumentary.put("Sweat Glands", "assets/sweat_glands.png");
		
		nervous = new HashMap<>();
		nervous.put("Brain", "assets/brain.png"); //
		nervous.put("Cervical nerve", "assets/cervical_nerves.png");
		nervous.put("Lumbar nerve", "assets/lumbar_nerves.png");
		nervous.put("Parietal lobe", "assets/parietal_lobe.png"); 
		nervous.put("Peripheral leg nerve", "assets/peripheral_leg_nerves.png");
		nervous.put("Sacral nerve", "assets/sacral_nerves.png");
		nervous.put("Spinal cord", "assets/spinal_cord.png");
		nervous.put("Tibial nerve", "assets/tibial_nerve.png");
		nervous.put("Frontal lobe", "assets/frontal_lobe.png"); 
		nervous.put("Occipital lobe", "assets/occipital_lobe.png"); 
		nervous.put("Sciatic nerve", "assets/sciatic_nerve.png");
		nervous.put("Temporal nerve", "assets/temporal_nerve.png");
		nervous.put("Thoracic nerve", "assets/thoracic nerve.png");
		
		reproductive = new HashMap<>();
		reproductive.put("Cervix", "assets/cervix.png");
		reproductive.put("Ovarian ligament", "assets/ovarian_ligament.png");
		reproductive.put("Ovaries", "assets/ovary.png");
		reproductive.put("Vagina", "assets/vagina.png");
		reproductive.put("Bladder", "assets/bladder_men.png");
		reproductive.put("Cervical canal", "assets/cervical_canal.png");
		reproductive.put("Endometrium", "assets/endometrium.png");
		reproductive.put("Epididymis", "assets/epididymis.png");
		reproductive.put("Fallopian tube", "assets/fallopian_tube.png");
		reproductive.put("Foreskin", "assets/foreskin.png");
		reproductive.put("Infundibulum", "assets/infundibulum.png");
		reproductive.put("Myometrium", "assets/myometrium.png");
		reproductive.put("Penis", "assets/penis.png");
		reproductive.put("Prostate", "assets/prostate.png");
		reproductive.put("Seminal vesicle", "assets/seminal_vesicle.png");
		reproductive.put("Testicles", "assets/testicles.png");
		reproductive.put("Urethra", "assets/urethra_men.png");
		reproductive.put("Urethral opening", "assets/urethral_opening.png");
		reproductive.put("Uterine fundus", "assets/uterine_fundus.png");
		reproductive.put("Uterus", "assets/uterus.png");

		respiratory = new HashMap<>(); //
		respiratory.put("Alveoli", "assets/alveoli.png");
		respiratory.put("Bronchus", "assets/bronchus.png");
		respiratory.put("Diaphragm", "assets/diaphragm.png");
		respiratory.put("Larynx", "assets/larynx.png");
		respiratory.put("Trachea", "assets/trachea.png");
		respiratory.put("Bronchioles", "assets/bronchioles.png");
		respiratory.put("Frontal sinus", "assets/frontal_sinus.png");
		respiratory.put("Left lung", "assets/left_lung.png");
		respiratory.put("Nasal cavity", "assets/nasal_cavity.png");
		respiratory.put("Nasal conchae", "assets/nasal_conchae.png");
		respiratory.put("Nose", "assets/nose.png");
		respiratory.put("Pharynx", "assets/pharynx.png");
		respiratory.put("Right lung", "assets/right_lung.png");
		respiratory.put("Sphenoidal sinus", "assets/sphenoidal_sinus.png");
		
		skeletal = new HashMap<>();
		skeletal.put("Coccyx", "assets/coccyx.png");
		skeletal.put("Femur", "assets/femur.png"); 
		skeletal.put("Fibula", "assets/fibula.png");
		skeletal.put("Ribs", "assets/ribs.png"); 
		skeletal.put("Shoulder blades", "assets/shoulder_blades.png"); 
		skeletal.put("Skull", "assets/skull.png"); 
		skeletal.put("Tibia", "assets/tibia.png");
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
