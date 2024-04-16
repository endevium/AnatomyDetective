package com.BIT5.AnatomyDetective;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.awt.event.*;
import java.io.File;


public class game {
	
	private static Set<String> usedParts = new HashSet<>();
	private static JProgressBar PBar;
    private static JFrame main_frame;
    private static JCheckBox musicCheckbox, effectCheckbox;
    private static JLabel gameLogoLabel, scoreLabel, roundLabel, imageLabel, totalLabel, chooseModeLabel, chooseTopicLabel, chooseDifficultyLabel, rememberThisLabel, reviewImageLabel, partNameLabel, htpImageLabel, htpLabel, settingsLabel, cardioImageLabel, cardioLabel, digestiveImageLabel, digestiveLabel, endocrineImageLabel, endocrineLabel, excretoryImageLabel, excretoryLabel, immuneImageLabel, immuneLabel, integumentaryImageLabel, integumentaryLabel, nervousImageLabel, nervousLabel, reproductiveImageLabel, reproductiveImageLabel2, reproductiveLabel, respiratoryImageLabel, respiratoryLabel, skeletalImageLabel, skeletalLabel;
    private static JTextField answerInputField;
    private static JButton playBtn, submitBtn, skipBtn, tryAgainBtn, menuBtn, backBtn, casualBtn, reviewBtn, htpBtn, modelBtn, easyBtn, averageBtn, difficultBtn, continueBtn, settingsBtn, closeBtn, nervousBtn, skeletalBtn, excretoryBtn, reproductiveBtn, endocrineBtn, respiratoryBtn, integumentaryBtn, cardioBtn, digestiveBtn, immuneBtn;
    private static String correctAnswer; 
    private static JPanel main_panel, mode_panel, topic_panel, difficulty_panel, htp_panel, game_panel, game_over_panel, back_panel, timer_panel, review_panel, settingsBtn_panel, settings_panel, model_panel, nervous_panel, skeletal_panel, excretory_panel, reproductive_panel, endocrine_panel, respiratory_panel, integumentary_panel, cardiovascular_panel, digestive_panel, immune_panel;
    private static int score, roundNum, maxRound;
    private static String difficulty, topic;
    private static boolean isReview;
    
    public static void main(String[] args) {
        main_frame = new JFrame("Anatomy Detective");
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setSize(1024, 950);
        main_frame.setResizable(false);
        main_frame.setLocationRelativeTo(null);
        main_frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        Container container = main_frame.getContentPane();
        container.setLayout(null);
        
        difficulty = "";
        topic = "";
        score = 0;
        roundNum = 1;
        maxRound = 10;
        isReview = false;
        
        // Main menu panel
        main_panel = new JPanel(new GridBagLayout());
        main_panel.setBackground(null);
        main_panel.setBounds(250, 130, 500, 500);
        container.add(main_panel);
        
        gameLogoLabel = new JLabel();
        gameLogoLabel.setIcon(new ImageIcon("assets/anatomy_detective_logo.png"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(30, 0, 20, 0);
        main_panel.add(gameLogoLabel, gbc);
        
        playBtn = new JButton();
        playBtn.setIcon(new ImageIcon("assets/play_button.png"));
        playBtn.setBackground(null);
        playBtn.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 1;
        playBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	main_panel.setVisible(false);
            	mode_panel.setVisible(true);
            	back_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        main_panel.add(playBtn, gbc);
        
        modelBtn = new JButton();
        modelBtn.setIcon(new ImageIcon("assets/model_button.png"));
        modelBtn.setBackground(null);
        modelBtn.setBorder(null);
        modelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	main_panel.setVisible(false);
            	back_panel.setVisible(true);
            	cardiovascular_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        main_panel.add(modelBtn, gbc);
        
        htpBtn = new JButton();
        htpBtn.setIcon(new ImageIcon("assets/htp_button.png"));
        htpBtn.setBackground(null);
        htpBtn.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 3;
        htpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	main_panel.setVisible(false);
            	htp_panel.setVisible(true);
            	back_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        main_panel.add(htpBtn, gbc);
        
        // Panel for the Settings Button
        settingsBtn_panel = new JPanel();
        settingsBtn_panel.setBackground(Color.LIGHT_GRAY);
        settingsBtn_panel.setBounds(930, 0, 75, 75);
        container.add(settingsBtn_panel);
        
        settingsBtn = new JButton();
        settingsBtn.setIcon(new ImageIcon("assets/settings_button.png"));
        settingsBtn.setBackground(null);
        settingsBtn.setBorder(null);
        settingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (settings_panel.isVisible() == false) {
            		main_panel.setVisible(false);
            		settings_panel.setVisible(true);
            	}
            	else {
            		main_panel.setVisible(true);
            		settings_panel.setVisible(false);
            	}
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        settingsBtn_panel.add(settingsBtn);
        
        // Settings panel
        settings_panel = new JPanel();
        settings_panel.setLayout(null);
        settings_panel.setBackground(Color.LIGHT_GRAY);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        settings_panel.setBorder(border);
        settings_panel.setBounds(300, 130, 400, 500);
        settings_panel.setVisible(false);
        container.add(settings_panel);
        
        settingsLabel = new JLabel("Settings");
        settingsLabel.setForeground(Color.BLACK);
        settingsLabel.setFont(new Font("Zilla Slab", Font.PLAIN, 27));
        settingsLabel.setBounds(150, 17, 100, 30);
        settings_panel.add(settingsLabel);
        
        closeBtn = new JButton("X");
        closeBtn.setForeground(Color.BLACK);
        closeBtn.setBackground(null);
        closeBtn.setBorder(null);
        closeBtn.setFont(new Font("Zilla Slab", Font.PLAIN, 27));
        closeBtn.setBounds(5, 5, 51, 51);
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	main_panel.setVisible(true);
        		settings_panel.setVisible(false);
        		
        		if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        settings_panel.add(closeBtn);
        
        musicCheckbox = new JCheckBox(" Music", true);
        musicCheckbox.setFont(new Font("Zilla Slab", Font.PLAIN, 23));
        musicCheckbox.setIcon(new ImageIcon("assets/checkbox.png"));
        musicCheckbox.setSelectedIcon(new ImageIcon("assets/selected_checkbox.png"));
        musicCheckbox.setBackground(null);
        musicCheckbox.setForeground(Color.BLACK);
        musicCheckbox.setBounds(100, 100, 200, 50);
        settings_panel.add(musicCheckbox);
        
        effectCheckbox = new JCheckBox(" Sound Effects", true);
        effectCheckbox.setFont(new Font("Zilla Slab", Font.PLAIN, 23));
        effectCheckbox.setIcon(new ImageIcon("assets/checkbox.png"));
        effectCheckbox.setSelectedIcon(new ImageIcon("assets/selected_checkbox.png"));
        effectCheckbox.setBackground(null);
        effectCheckbox.setForeground(Color.BLACK);
        effectCheckbox.setBounds(100, 170, 200, 50);
        settings_panel.add(effectCheckbox);
        
        
        
        // How to Play panel
        htp_panel = new JPanel(new GridBagLayout());
        htp_panel.setBackground(null);
        htp_panel.setBounds(250, 85, 500, 700);
        htp_panel.setVisible(false);
        container.add(htp_panel);
        
        htpImageLabel = new JLabel();
        htpImageLabel.setIcon(new ImageIcon("assets/htpImage.png"));
        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridx = 0;
        gbc8.gridy = 0;
        gbc8.insets = new Insets(10, 0, 25, 0);
        htp_panel.add(htpImageLabel, gbc8);
        
        htpLabel = new JLabel("<html>Welcome to Anatomy Detective. In this game, you will be guessing different parts of the body. Click ‘Play’ to choose a gamemode. Click ‘Casual’ to play the guessing game, which will let you pick a difficulty. You can also review different systems of the body by clicking ‘Review’. </html>");
        htpLabel.setForeground(Color.BLACK);
        htpLabel.setPreferredSize(new Dimension(500, 220));
        htpLabel.setFont(new Font("Zilla Slab", Font.PLAIN, 23));
        gbc8.gridx = 0;
        gbc8.gridy = 1;
        htp_panel.add(htpLabel, gbc8);
        
        mode_panel = new JPanel(new GridBagLayout());
        mode_panel.setBackground(Color.LIGHT_GRAY);
        mode_panel.setBounds(250, 35, 500, 700);
        mode_panel.setVisible(false);
        container.add(mode_panel);
        
        chooseModeLabel = new JLabel("Choose Gamemode");
        chooseModeLabel.setForeground(Color.BLACK);
        chooseModeLabel.setFont(new Font("Zilla Slab", Font.PLAIN, 42));
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 0;
        gbc4.insets = new Insets(10, 0, 25, 0);
        mode_panel.add(chooseModeLabel, gbc4);
        
        casualBtn = new JButton();
        casualBtn.setIcon(new ImageIcon("assets/casual_button.png"));
        casualBtn.setBackground(null);
        casualBtn.setBorder(null);
        casualBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	maxRound = 10;
            	mode_panel.setVisible(false);
                difficulty_panel.setVisible(true);  
                
                if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc4.gridx = 0;
        gbc4.gridy = 1;
        mode_panel.add(casualBtn, gbc4);
        
        reviewBtn = new JButton();
        reviewBtn.setIcon(new ImageIcon("assets/review_button.png"));
        reviewBtn.setBackground(null);
        reviewBtn.setBorder(null);
        reviewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                topic_panel.setVisible(true);
                mode_panel.setVisible(false);
                
                if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc4.gridx = 0;
        gbc4.gridy = 2;
        mode_panel.add(reviewBtn, gbc4);
        
        difficulty_panel = new JPanel(new GridBagLayout());
        difficulty_panel.setBackground(Color.LIGHT_GRAY);
        difficulty_panel.setBounds(250, 75, 500, 700);
        difficulty_panel.setVisible(false);
        container.add(difficulty_panel);
        
        chooseDifficultyLabel = new JLabel("Choose Difficulty");
        chooseDifficultyLabel.setForeground(Color.BLACK);
        chooseDifficultyLabel.setFont(new Font("Zilla Slab", Font.PLAIN, 42));
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 0;
        gbc5.insets = new Insets(10, 0, 25, 0);
        difficulty_panel.add(chooseDifficultyLabel, gbc5);
        
        
        easyBtn = new JButton();
        easyBtn.setIcon(new ImageIcon("assets/easy_button.png"));
        easyBtn.setBackground(null);
        easyBtn.setBorder(null);
        easyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> easyDictionary = dictionary.getEasyDictionary();  
                generatePart(easyDictionary);  
                
            	fill();
            	score = 0;
            	roundNum = 1;
            	difficulty = "easy";
            	review_panel.remove(reviewImageLabel);
                review_panel.remove(partNameLabel);
                review_panel.revalidate();
                review_panel.repaint();
            	scoreLabel.setText(Integer.toString(score));
            	totalLabel.setText("Score: " + Integer.toString(score));
        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear(); 

            	difficulty_panel.setVisible(false);
            	game_panel.setVisible(true);
            	timer_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc5.gridx = 0;
        gbc5.gridy = 1;
        difficulty_panel.add(easyBtn, gbc5);
        
        averageBtn = new JButton();
        averageBtn.setIcon(new ImageIcon("assets/average_button.png"));
        averageBtn.setBackground(null);
        averageBtn.setBorder(null);
        averageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> averageDictionary = dictionary.getAverageDictionary();
                generatePart(averageDictionary);
                
            	fill();
            	score = 0;
            	roundNum = 1;
            	difficulty = "average";
            	review_panel.remove(reviewImageLabel);
                review_panel.remove(partNameLabel);
                review_panel.revalidate();
                review_panel.repaint();
            	scoreLabel.setText(Integer.toString(score));
            	totalLabel.setText("Score: " + Integer.toString(score));
        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear();
            	
            	difficulty_panel.setVisible(false);
            	game_panel.setVisible(true);
            	timer_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc5.gridx = 0;
        gbc5.gridy = 2;
        difficulty_panel.add(averageBtn, gbc5);
        
        difficultBtn = new JButton();
        difficultBtn.setIcon(new ImageIcon("assets/difficult_button.png"));
        difficultBtn.setBackground(null);
        difficultBtn.setBorder(null);
        difficultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> difficultDictionary = dictionary.getDifficultDictionary();
                generatePart(difficultDictionary);
                
            	fill();
            	score = 0;
            	roundNum = 1;
            	difficulty = "difficult";
            	review_panel.remove(reviewImageLabel);
                review_panel.remove(partNameLabel);
                review_panel.revalidate();
                review_panel.repaint();
            	scoreLabel.setText(Integer.toString(score));
            	totalLabel.setText("Score: " + Integer.toString(score));
        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear();
        			
            	difficulty_panel.setVisible(false);
            	game_panel.setVisible(true);
            	timer_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc5.gridx = 0;
        gbc5.gridy = 3;
        difficulty_panel.add(difficultBtn, gbc5);
        
        topic_panel = new JPanel(new GridBagLayout());
        topic_panel.setBackground(Color.LIGHT_GRAY);
        topic_panel.setBounds(60, 0, 900, 900);
        topic_panel.setVisible(false);
        container.add(topic_panel);
        
        chooseTopicLabel = new JLabel("Choose Topic");
        chooseTopicLabel.setForeground(Color.BLACK);
        chooseTopicLabel.setFont(new Font("Zilla Slab", Font.PLAIN, 42));
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 1;
        gbc6.gridy = 0;
        gbc6.insets = new Insets(10, 0, 25, 0);
        topic_panel.add(chooseTopicLabel, gbc6);
        
        cardioBtn = new JButton();
        cardioBtn.setIcon(new ImageIcon("assets/cardiovascular_system.png"));
        cardioBtn.setBackground(null);
        cardioBtn.setBorder(null);
        cardioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> firstTopic = dictionary.getFirstTopic();
                generatePart(firstTopic);
                
            	score = 0;
            	roundNum = 1;
            	topic = "first";
            	isReview = true;
            	
            	maxRound = (isReview) ? firstTopic.size() : 10;

        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear();
        		
            	
            	topic_panel.setVisible(false);
            	review_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc6.gridx = 0;
        gbc6.gridy = 1;
        topic_panel.add(cardioBtn, gbc6);
        
        digestiveBtn = new JButton();
        digestiveBtn.setIcon(new ImageIcon("assets/digestive_system.png"));
        digestiveBtn.setBackground(null);
        digestiveBtn.setBorder(null);
        digestiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> secondTopic = dictionary.getSecondTopic();
                generatePart(secondTopic);
                
            	score = 0;
            	roundNum = 1;
            	isReview = true;
            	
            	maxRound = (isReview) ? secondTopic.size() : 10;

        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear();
        		
        		
        	            	
            	topic_panel.setVisible(false);
            	review_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc6.gridx = 1;
        gbc6.gridy = 1;
        topic_panel.add(digestiveBtn, gbc6);
        
        endocrineBtn = new JButton();
        endocrineBtn.setIcon(new ImageIcon("assets/endocrine_system.png"));
        endocrineBtn.setBackground(null);
        endocrineBtn.setBorder(null);
        endocrineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> thirdTopic = dictionary.getThirdTopic();
                generatePart(thirdTopic);
                
            	score = 0;
            	roundNum = 1;
            	topic = "third";
            	isReview = true;
            	
            	maxRound = (isReview) ? thirdTopic.size() : 10;

        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear();
        	            	
            	topic_panel.setVisible(false);
            	review_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc6.gridx = 2;
        gbc6.gridy = 1;
        topic_panel.add(endocrineBtn, gbc6);
        
        excretoryBtn = new JButton();
        excretoryBtn.setIcon(new ImageIcon("assets/excretory_system.png"));
        excretoryBtn.setBackground(null);
        excretoryBtn.setBorder(null);
        excretoryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> fourthTopic = dictionary.getFourthTopic();
                generatePart(fourthTopic);
                
            	score = 0;
            	roundNum = 1;
            	topic = "fourth";
                review_panel.revalidate();
                review_panel.repaint();
        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear();
        	            	
            	topic_panel.setVisible(false);
            	review_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc6.gridx = 0;
        gbc6.gridy = 2;
        topic_panel.add(excretoryBtn, gbc6);
        
        immuneBtn = new JButton();
        immuneBtn.setIcon(new ImageIcon("assets/immune_system.png"));
        immuneBtn.setBackground(null);
        immuneBtn.setBorder(null);
        immuneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> fifthTopic = dictionary.getFifthTopic();
                generatePart(fifthTopic);
                
            	score = 0;
            	roundNum = 1;
            	topic = "fifth";
            	isReview = true;
            	
            	maxRound = (isReview) ? fifthTopic.size() : 10;

        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear();
        	            	
            	topic_panel.setVisible(false);
            	review_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc6.gridx = 1;
        gbc6.gridy = 2;
        topic_panel.add(immuneBtn, gbc6);
        
        integumentaryBtn = new JButton();
        integumentaryBtn.setIcon(new ImageIcon("assets/integumentary_system.png"));
        integumentaryBtn.setBackground(null);
        integumentaryBtn.setBorder(null);
        integumentaryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> sixthTopic = dictionary.getSixthTopic();
                generatePart(sixthTopic);
                
            	score = 0;
            	roundNum = 1;
            	topic = "sixth";
            	isReview = true;
            	
            	maxRound = (isReview) ? sixthTopic.size() : 10;

        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear();
        	            	
            	topic_panel.setVisible(false);
            	review_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc6.gridx = 2;
        gbc6.gridy = 2;
        topic_panel.add(integumentaryBtn, gbc6);
        
        nervousBtn = new JButton();
        nervousBtn.setIcon(new ImageIcon("assets/nervous_system.png"));
        nervousBtn.setBackground(null);
        nervousBtn.setBorder(null);
        nervousBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> seventhTopic = dictionary.getSeventhTopic();
                generatePart(seventhTopic);
                
            	score = 0;
            	roundNum = 1;
            	topic = "seventh";
            	isReview = true;
            	
            	maxRound = (isReview) ? seventhTopic.size() : 10;

        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear();
        	            	
            	topic_panel.setVisible(false);
            	review_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc6.gridx = 0;
        gbc6.gridy = 3;
        topic_panel.add(nervousBtn, gbc6);
        
        reproductiveBtn = new JButton();
        reproductiveBtn.setIcon(new ImageIcon("assets/reproductive_system.png"));
        reproductiveBtn.setBackground(null);
        reproductiveBtn.setBorder(null);
        reproductiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> eighthTopic = dictionary.getEighthTopic();
                generatePart(eighthTopic);
                
            	score = 0;
            	roundNum = 1;
            	topic = "eighth";
            	isReview = true;
            	
            	maxRound = (isReview) ? eighthTopic.size() : 10;

        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear();
        	            	
            	topic_panel.setVisible(false);
            	review_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc6.gridx = 1;
        gbc6.gridy = 3;
        topic_panel.add(reproductiveBtn, gbc6);
        
        respiratoryBtn = new JButton();
        respiratoryBtn.setIcon(new ImageIcon("assets/respiratory_system.png"));
        respiratoryBtn.setBackground(null);
        respiratoryBtn.setBorder(null);
        respiratoryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> ninthTopic = dictionary.getNinthTopic();
                generatePart(ninthTopic);
                
            	score = 0;
            	roundNum = 1;
            	topic = "ninth";
            	isReview = true;
            	
            	maxRound = (isReview) ? ninthTopic.size() : 10;

        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear();
        	            	
            	topic_panel.setVisible(false);
            	review_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc6.gridx = 2;
        gbc6.gridy = 3;
        topic_panel.add(respiratoryBtn, gbc6);
        
        skeletalBtn = new JButton();
        skeletalBtn.setIcon(new ImageIcon("assets/skeletal_system.png"));
        skeletalBtn.setBackground(null);
        skeletalBtn.setBorder(null);
        skeletalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> ninthTopic = dictionary.getTenthTopic();
                generatePart(ninthTopic);
                
            	score = 0;
            	roundNum = 1;
            	topic = "tenth";
            	isReview = true;
            	
            	maxRound = (isReview) ? ninthTopic.size() : 10;

        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear();
        	            	
            	topic_panel.setVisible(false);
            	review_panel.setVisible(true);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        gbc6.gridx = 1;
        gbc6.gridy = 4;
        topic_panel.add(skeletalBtn, gbc6);
        
        back_panel = new JPanel();
        back_panel.setBackground(Color.LIGHT_GRAY);
        back_panel.setBounds(14, 35, 30, 30);
        back_panel.setVisible(false);
        container.add(back_panel);
        
        backBtn = new JButton();
        backBtn.setIcon(new ImageIcon("assets/back_button.png"));
        backBtn.setBackground(null);
        backBtn.setBorder(null);
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            	
            	score = 0;
            	roundNum = 1;
            	scoreLabel.setText(Integer.toString(score));
            	totalLabel.setText("Score: " + Integer.toString(score));
        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
                
            	if (mode_panel.isVisible()) {
            		mode_panel.setVisible(false);
            		back_panel.setVisible(false);
            		main_panel.setVisible(true);
            	}
            	else if (htp_panel.isVisible()) {
            		htp_panel.setVisible(false);
            		back_panel.setVisible(false);
            		main_panel.setVisible(true);
            	}
            	else if (difficulty_panel.isVisible()) {
            		difficulty_panel.setVisible(false);
            		mode_panel.setVisible(true);
            	}
            	else if (topic_panel.isVisible()) {
            		topic_panel.setVisible(false);
            		mode_panel.setVisible(true);
            		isReview = false;
            		maxRound = 10;
            	}
            	else if (review_panel.isVisible()) {
            		review_panel.setVisible(false);
            		mode_panel.setVisible(true);
            		usedParts.clear();
            	}
            	else if (game_panel.isVisible() && isReview == true) {
            		game_panel.setVisible(false);
            		timer_panel.setVisible(false);
            		topic_panel.setVisible(true);
            		scoreLabel.setVisible(true);
            		isReview = false;
            		maxRound = 10;
            		usedParts.clear();
            	}
            	else if (game_panel.isVisible()) {
            		game_panel.setVisible(false);
            		timer_panel.setVisible(false);
            		difficulty_panel.setVisible(true);
            		usedParts.clear();
            	}
            }
        });
        back_panel.add(backBtn);
        
        // Model Panel
        cardiovascular_panel = new JPanel();
        cardiovascular_panel.setBackground(null);
        cardiovascular_panel.setVisible(false);
        cardiovascular_panel.setLayout(null);
        cardiovascular_panel.setBounds(320, 100, 383, 700);
        container.add(cardiovascular_panel);
        
        cardioImageLabel = new JLabel();
        cardioImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        cardioImageLabel.setBackground(null);
        cardioImageLabel.setBounds(0, 0, 383, 612);
        cardiovascular_panel.add(cardioImageLabel);
        
        cardioLabel = new JLabel("Cardiovascular System");
        cardioLabel.setFont(new Font("Zilla Slab", Font.BOLD, 30));
        cardioLabel.setForeground(Color.BLACK);
        cardioLabel.setBackground(null);
        cardioLabel.setBounds(0, 615, 500, 100);
        cardiovascular_panel.add(cardioLabel);
        
        digestive_panel = new JPanel();
        digestive_panel.setBackground(null);
        digestive_panel.setVisible(false);
        digestive_panel.setLayout(null);
        digestive_panel.setBounds(320, 100, 383, 700);
        container.add(digestive_panel);
        
        digestiveImageLabel = new JLabel();
        digestiveImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        digestiveImageLabel.setBackground(null);
        digestiveImageLabel.setBounds(0, 0, 383, 612);
        digestive_panel.add(digestiveImageLabel);
        
        digestiveLabel = new JLabel("Digestive System");
        digestiveLabel.setFont(new Font("Zilla Slab", Font.BOLD, 30));
        digestiveLabel.setForeground(Color.BLACK);
        digestiveLabel.setBackground(null);
        digestiveLabel.setBounds(0, 615, 500, 100);
        digestive_panel.add(digestiveLabel);
        
        endocrine_panel = new JPanel();
        endocrine_panel.setBackground(null);
        endocrine_panel.setVisible(false);
        endocrine_panel.setLayout(null);
        endocrine_panel.setBounds(320, 100, 383, 700);
        container.add(endocrine_panel);
        
        endocrineImageLabel = new JLabel();
        endocrineImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        endocrineImageLabel.setBackground(null);
        endocrineImageLabel.setBounds(0, 0, 383, 612);
        endocrine_panel.add(endocrineImageLabel);
        
        endocrineLabel = new JLabel("Endocrine System");
        endocrineLabel.setFont(new Font("Zilla Slab", Font.BOLD, 30));
        endocrineLabel.setForeground(Color.BLACK);
        endocrineLabel.setBackground(null);
        endocrineLabel.setBounds(0, 615, 500, 100);
        endocrine_panel.add(endocrineLabel);
        
        excretory_panel = new JPanel();
        excretory_panel.setBackground(null);
        excretory_panel.setVisible(false);
        excretory_panel.setLayout(null);
        excretory_panel.setBounds(320, 100, 383, 700);
        container.add(excretory_panel);
        
        excretoryImageLabel = new JLabel();
        excretoryImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        excretoryImageLabel.setBackground(null);
        excretoryImageLabel.setBounds(0, 0, 383, 612);
        excretory_panel.add(excretoryImageLabel);
        
        excretoryLabel = new JLabel("Excretory System");
        excretoryLabel.setFont(new Font("Zilla Slab", Font.BOLD, 30));
        excretoryLabel.setForeground(Color.BLACK);
        excretoryLabel.setBackground(null);
        excretoryLabel.setBounds(0, 615, 500, 100);
        excretory_panel.add(excretoryLabel);
        
        immune_panel = new JPanel();
        immune_panel.setBackground(null);
        immune_panel.setVisible(false);
        immune_panel.setLayout(null);
        immune_panel.setBounds(320, 100, 383, 700);
        container.add(immune_panel);
        
        immuneImageLabel = new JLabel();
        immuneImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        immuneImageLabel.setBackground(null);
        immuneImageLabel.setBounds(0, 0, 383, 612);
        immune_panel.add(immuneImageLabel);
        
        immuneLabel = new JLabel("Immune System");
        immuneLabel.setFont(new Font("Zilla Slab", Font.BOLD, 30));
        immuneLabel.setForeground(Color.BLACK);
        immuneLabel.setBackground(null);
        immuneLabel.setBounds(0, 615, 500, 100);
        immune_panel.add(immuneLabel);
        
        integumentary_panel = new JPanel();
        integumentary_panel.setBackground(null);
        integumentary_panel.setVisible(false);
        integumentary_panel.setLayout(null);
        integumentary_panel.setBounds(320, 100, 383, 700);
        container.add(integumentary_panel);
        
        integumentaryImageLabel = new JLabel();
        integumentaryImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        integumentaryImageLabel.setBackground(null);
        integumentaryImageLabel.setBounds(0, 0, 383, 612);
        integumentary_panel.add(integumentaryImageLabel);
        
        integumentaryLabel = new JLabel("Integumentary System");
        integumentaryLabel.setFont(new Font("Zilla Slab", Font.BOLD, 30));
        integumentaryLabel.setForeground(Color.BLACK);
        integumentaryLabel.setBackground(null);
        integumentaryLabel.setBounds(0, 615, 500, 100);
        integumentary_panel.add(integumentaryLabel);
        
        nervous_panel = new JPanel();
        nervous_panel.setBackground(null);
        nervous_panel.setVisible(false);
        nervous_panel.setLayout(null);
        nervous_panel.setBounds(320, 100, 383, 700);
        container.add(nervous_panel);
        
        nervousImageLabel = new JLabel();
        nervousImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        nervousImageLabel.setBackground(null);
        nervousImageLabel.setBounds(0, 0, 383, 612);
        nervous_panel.add(nervousImageLabel);
        
        nervousLabel = new JLabel("Nervous System");
        nervousLabel.setFont(new Font("Zilla Slab", Font.BOLD, 30));
        nervousLabel.setForeground(Color.BLACK);
        nervousLabel.setBackground(null);
        nervousLabel.setBounds(0, 615, 500, 100);
        nervous_panel.add(nervousLabel);
        
        reproductive_panel = new JPanel();
        reproductive_panel.setBackground(null);
        reproductive_panel.setVisible(false);
        reproductive_panel.setLayout(null);
        reproductive_panel.setBounds(320, 100, 383, 700);
        container.add(nervous_panel);
        
        reproductiveImageLabel = new JLabel();
        reproductiveImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        reproductiveImageLabel.setBackground(null);
        reproductiveImageLabel.setBounds(0, 0, 383, 612);
        reproductive_panel.add(reproductiveImageLabel);
        
        reproductiveImageLabel2 = new JLabel();
        reproductiveImageLabel2.setIcon(new ImageIcon("assets/human_body.png"));
        reproductiveImageLabel2.setBackground(null);
        reproductiveImageLabel2.setBounds(383, 0, 383, 612);
        reproductive_panel.add(reproductiveImageLabel2);
        
        reproductiveLabel = new JLabel("Reproductive System");
        reproductiveLabel.setFont(new Font("Zilla Slab", Font.BOLD, 30));
        reproductiveLabel.setForeground(Color.BLACK);
        reproductiveLabel.setBackground(null);
        reproductiveLabel.setBounds(0, 615, 500, 100);
        reproductive_panel.add(reproductiveLabel);
        
        respiratory_panel = new JPanel();
        respiratory_panel.setBackground(null);
        respiratory_panel.setVisible(false);
        respiratory_panel.setLayout(null);
        respiratory_panel.setBounds(320, 100, 383, 700);
        container.add(nervous_panel);
        
        respiratoryImageLabel = new JLabel();
        respiratoryImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        respiratoryImageLabel.setBackground(null);
        respiratoryImageLabel.setBounds(0, 0, 383, 612);
        respiratory_panel.add(respiratoryImageLabel);
        
        respiratoryLabel = new JLabel("Respiratory System");
        respiratoryLabel.setFont(new Font("Zilla Slab", Font.BOLD, 30));
        respiratoryLabel.setForeground(Color.BLACK);
        respiratoryLabel.setBackground(null);
        respiratoryLabel.setBounds(0, 615, 500, 100);
        respiratory_panel.add(respiratoryLabel);
        
        skeletal_panel = new JPanel();
        skeletal_panel.setBackground(null);
        skeletal_panel.setVisible(false);
        skeletal_panel.setLayout(null);
        skeletal_panel.setBounds(320, 100, 383, 700);
        container.add(nervous_panel);
        
        skeletalImageLabel = new JLabel();
        skeletalImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        skeletalImageLabel.setBackground(null);
        skeletalImageLabel.setBounds(0, 0, 383, 612);
        skeletal_panel.add(skeletalImageLabel);
        
        skeletalLabel = new JLabel("Skeletal System");
        skeletalLabel.setFont(new Font("Zilla Slab", Font.BOLD, 30));
        skeletalLabel.setForeground(Color.BLACK);
        skeletalLabel.setBackground(null);
        skeletalLabel.setBounds(0, 615, 500, 100);
        skeletal_panel.add(skeletalLabel);
        
        // Review Panel
        review_panel = new JPanel(new GridBagLayout());
        review_panel.setBackground(Color.LIGHT_GRAY);
        review_panel.setBounds(250, 60, 500, 700);
        review_panel.setVisible(false);
        container.add(review_panel);
        
        rememberThisLabel = new JLabel("Remember this!");
        rememberThisLabel.setFont(new Font("Zilla Slab", Font.BOLD, 40));
        rememberThisLabel.setForeground(Color.BLACK);
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 0;
        gbc7.gridy = 0;
        gbc7.insets = new Insets(10, 0, 10, 0);
        review_panel.add(rememberThisLabel, gbc7);
        
        continueBtn = new JButton();
        continueBtn.setIcon(new ImageIcon("assets/play_button.png"));
        continueBtn.setBackground(null);
        continueBtn.setBorder(null);
        gbc7.gridx = 0;
        gbc7.gridy = 3;
        continueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	isReview = true;
            	review_panel.setVisible(false);
            	game_panel.setVisible(true);
            	timer_panel.setVisible(false);
            	scoreLabel.setVisible(false);
            	
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            }
        });
        review_panel.add(continueBtn, gbc7);
        
        game_panel = new JPanel(new GridBagLayout());
        game_panel.setBackground(Color.LIGHT_GRAY);
        game_panel.setBounds(250, 60, 500, 700);
        game_panel.setVisible(false);
        container.add(game_panel);

        scoreLabel = new JLabel(Integer.toString(score));
        scoreLabel.setFont(new Font("Zilla Slab", Font.BOLD, 40));
        scoreLabel.setForeground(Color.BLACK);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.insets = new Insets(10, 0, 10, 0);
        game_panel.add(scoreLabel, gbc2);
        
        timer_panel = new JPanel();
        timer_panel.setBackground(Color.LIGHT_GRAY);
        timer_panel.setBounds(0, -6, 1040, 100);
        timer_panel.setVisible(false);
        container.add(timer_panel);
        
        PBar = new JProgressBar();
        PBar.setValue(0);
        PBar.setPreferredSize(new Dimension(1040, 25));
        PBar.setForeground(Color.GRAY);
        PBar.setBackground(Color.white);
        PBar.setBorder(null);
        timer_panel.add(PBar);
        
        roundLabel = new JLabel(Integer.toString(roundNum) + "/10");
        roundLabel.setFont(new Font("Zilla Slab", Font.PLAIN, 21));
        roundLabel.setForeground(Color.BLACK);
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        game_panel.add(roundLabel, gbc2);

        answerInputField = new JTextField("");
        answerInputField.setFont(new Font("Helvetica Neue", Font.BOLD, 19));
        answerInputField.setPreferredSize(new Dimension(400, 40));
        answerInputField.setBackground(null);
        answerInputField.setHorizontalAlignment(JTextField.CENTER);
        gbc2.gridx = 0;
        gbc2.gridy = 4;
        game_panel.add(answerInputField, gbc2);
        
        answerInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitAnswer();
            }
        });

        submitBtn = new JButton();
        submitBtn.setIcon(new ImageIcon("assets/submit_btn.png"));
        submitBtn.setBackground(null);
        submitBtn.setBorder(null);
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {	
                submitAnswer();
                review_panel.revalidate();
                review_panel.repaint();
            }
        });
        gbc2.gridx = 0;
        gbc2.gridy = 5;
        game_panel.add(submitBtn, gbc2);

        skipBtn = new JButton();
        skipBtn.setIcon(new ImageIcon("assets/skip_button.png"));
        skipBtn.setBackground(null);
        skipBtn.setBorder(null);
        skipBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (effectCheckbox.isSelected()) {
            		try {
            			File audioFile = new File("assets/button_click.wav");
                    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    	Clip clip = AudioSystem.getClip();
                    	clip.open(audioInputStream);
                    	clip.start();
                	} catch (Exception ex) {
                    	ex.printStackTrace();
                	}
            	}
            	
                if (roundNum < maxRound) {
                	if (isReview == true) {
                		review_panel.setVisible(true);
                		game_panel.setVisible(false);
                		timer_panel.setVisible(false);
                	}
                	else { 
                		fill();
                		totalLabel.setText("Score: " + Integer.toString(score));
                	}
                    
                    roundNum += 1;
                    scoreLabel.setText(Integer.toString(score)); 
                    roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
                    answerInputField.setText(""); 
                    AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                    
                    if (isReview == false) {
                    	switch (difficulty) {
                    		case "easy":
                    			Map<String, String> easyDictionary = dictionary.getEasyDictionary();
                    			generatePart(easyDictionary);
                    			break;
                    		case "average":
                    			Map<String, String> averageDictionary = dictionary.getAverageDictionary();
                    			generatePart(averageDictionary);
                    		case "difficult":
                    			Map<String, String> difficultDictionary = dictionary.getAverageDictionary();
                    			generatePart(difficultDictionary);
                    	}
                    }
                    else {
                    	switch (topic) {
                    		case "first":
                    			Map<String, String> firstTopic = dictionary.getFirstTopic();
                                generatePart(firstTopic);
                                break;
                    		case "second":
                    			Map<String, String> secondTopic = dictionary.getSecondTopic();
                                generatePart(secondTopic);
                                break;
                    		case "third":
                    			Map<String, String> thirdTopic = dictionary.getThirdTopic();
                                generatePart(thirdTopic);
                                break;
                    		case "fourth":
                    			Map<String, String> fourthTopic = dictionary.getFourthTopic();
                                generatePart(fourthTopic);
                                break;
                    		case "fifth":
                    			Map<String, String> fifthTopic = dictionary.getFifthTopic();
                                generatePart(fifthTopic);
                                break;
                    		case "sixth":
                    			Map<String, String> sixthTopic = dictionary.getSixthTopic();
                                generatePart(sixthTopic);
                                break;
                    		case "seven":
                    			Map<String, String> seventhTopic = dictionary.getSeventhTopic();
                                generatePart(seventhTopic);
                                break;
                    		case "eighth":
                    			Map<String, String> eighthTopic = dictionary.getEighthTopic();
                                generatePart(eighthTopic);
                                break;
                    		case "ninth":
                    			Map<String, String> ninthTopic = dictionary.getNinthTopic();
                                generatePart(ninthTopic);
                                break;
                    		case "tenth":
                    			Map<String, String> tenthTopic = dictionary.getTenthTopic();
                                generatePart(tenthTopic);
                                break;
                    	}
                    }
                } else if (roundNum == maxRound) {
                	if (isReview == true) {
                		isReview = true;
                	}
                	
                	if (isReview == false) {
                    	totalLabel.setText("Score: " + Integer.toString(score)); 
                    }
                    else {
                    	totalLabel.setText("You have completed the review!"); 
                    }
                	
                    Timer timer = (Timer) timer_panel.getClientProperty("timer");
                    if (timer != null && timer.isRunning()) {
                        timer.stop();
                    }
                    PBar.setValue(0);
                    scoreLabel.setText(Integer.toString(score));
                    roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
                    answerInputField.setText("");

                    back_panel.setVisible(false);
                    game_panel.setVisible(false);
                    timer_panel.setVisible(false);
                    game_over_panel.setVisible(true);
                }
            }
        });
        gbc2.gridx = 0;
        gbc2.gridy = 6;
        game_panel.add(skipBtn, gbc2);

        game_over_panel = new JPanel(new GridBagLayout());
        game_over_panel.setBackground(Color.LIGHT_GRAY);
        game_over_panel.setBounds(250, 0, 500, 700);
        game_over_panel.setVisible(false);
        container.add(game_over_panel);

        totalLabel = new JLabel("Score: " + score);
        totalLabel.setFont(new Font("Zilla Slab", Font.BOLD, 30));
        totalLabel.setForeground(Color.BLACK);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 0;
        gbc3.insets = new Insets(10, 0, 10, 0);
        game_over_panel.add(totalLabel, gbc3);

        tryAgainBtn = new JButton();
        tryAgainBtn.setIcon(new ImageIcon("assets/try_again_button.png"));
        tryAgainBtn.setBackground(null);
        tryAgainBtn.setBorder(null);
        tryAgainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
            	try {
            		File audioFile = new File("assets/button_click.wav");
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            	
            	if (isReview == true) {
            		review_panel.setVisible(true);
            		game_panel.setVisible(false);
            		timer_panel.setVisible(false);
            	}
            	else {
            		fill();
            		game_panel.setVisible(true);
            		timer_panel.setVisible(true);		
            	}
                game_over_panel.setVisible(false);
                score = 0;
                roundNum = 1;
                scoreLabel.setText(Integer.toString(score));
                roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
                usedParts.clear();
                review_panel.remove(reviewImageLabel);
                review_panel.remove(partNameLabel);
               
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                
                if (isReview == false) {
                	switch (difficulty) {
                		case "easy":
                			Map<String, String> easyDictionary = dictionary.getEasyDictionary();
                			generatePart(easyDictionary);
                			break;
                		case "average":
                			Map<String, String> averageDictionary = dictionary.getAverageDictionary();
                			generatePart(averageDictionary);
                		case "difficult":
                			Map<String, String> difficultDictionary = dictionary.getAverageDictionary();
                			generatePart(difficultDictionary);
                	}
                }
                else {
                	switch (topic) {
                		case "first":
                			Map<String, String> firstTopic = dictionary.getFirstTopic();
                            generatePart(firstTopic);
                            break;
                		case "second":
                			Map<String, String> secondTopic = dictionary.getSecondTopic();
                            generatePart(secondTopic);
                            break;
                		case "third":
                			Map<String, String> thirdTopic = dictionary.getThirdTopic();
                            generatePart(thirdTopic);
                            break;
                		case "fourth":
                			Map<String, String> fourthTopic = dictionary.getFourthTopic();
                            generatePart(fourthTopic);
                            break;
                		case "fifth":
                			Map<String, String> fifthTopic = dictionary.getFifthTopic();
                            generatePart(fifthTopic);
                            break;
                		case "sixth":
                			Map<String, String> sixthTopic = dictionary.getSixthTopic();
                            generatePart(sixthTopic);
                            break;
                		case "seven":
                			Map<String, String> seventhTopic = dictionary.getSeventhTopic();
                            generatePart(seventhTopic);
                            break;
                		case "eighth":
                			Map<String, String> eighthTopic = dictionary.getEighthTopic();
                            generatePart(eighthTopic);
                            break;
                		case "ninth":
                			Map<String, String> ninthTopic = dictionary.getNinthTopic();
                            generatePart(ninthTopic);
                            break;
                		case "tenth":
                			Map<String, String> tenthTopic = dictionary.getTenthTopic();
                            generatePart(tenthTopic);
                            break;
                	}
                }
                back_panel.setVisible(true);
            }
        });
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        game_over_panel.add(tryAgainBtn, gbc3);

        menuBtn = new JButton();
        menuBtn.setIcon(new ImageIcon("assets/menu_button.png"));
        menuBtn.setBackground(null);
        menuBtn.setBorder(null);
        menuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		File audioFile = new File("assets/button_click.wav");
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            	
                back_panel.setVisible(false);
                game_over_panel.setVisible(false);
                timer_panel.setVisible(false);
                score = 0;
                roundNum = 1;
                scoreLabel.setText(Integer.toString(score));
                roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
                usedParts.clear();
                main_panel.setVisible(true);
                
                if (isReview == true) {
                	isReview = false;
                }
            }
        });
        gbc3.gridx = 0;
        gbc3.gridy = 3;
        game_over_panel.add(menuBtn, gbc3);

        main_frame.setVisible(true);
        
    }    

    public static void generatePart(Map<String, String> dictionary) {
        Random random = new Random();
        String partName;
        
        if (usedParts.size() == dictionary.size()) {
            // Reset usedParts if all parts have been used (assuming you want to reuse)
            usedParts.clear();
        }

        // Keep generating a partName until finding one that hasn't been used
        do {
            int randomIndex = random.nextInt(dictionary.size());
            partName = (String) dictionary.keySet().toArray()[randomIndex];
        } while (usedParts.contains(partName));

        // Add the chosen partName to usedParts to mark it as used
        usedParts.add(partName);

        correctAnswer = partName;
        String imageDir = dictionary.get(partName);

        ImageIcon partImage = createResizedImageIcon(imageDir, 500, 400);

        if (imageLabel != null) {
            game_panel.remove(imageLabel);
        }
        
        if (reviewImageLabel != null) {
        	review_panel.remove(reviewImageLabel);
        }
        
        if (partNameLabel != null) {
        	review_panel.remove(partNameLabel);
        }

        imageLabel = new JLabel(partImage);
        GridBagConstraints gbcImage = new GridBagConstraints();
        gbcImage.gridx = 0;
        gbcImage.gridy = 3;
        game_panel.add(imageLabel, gbcImage);
        
        reviewImageLabel = new JLabel(partImage);
        GridBagConstraints gbcImage2 = new GridBagConstraints();
        gbcImage2.gridx = 0;
        gbcImage2.gridy = 1;
        review_panel.add(reviewImageLabel, gbcImage2);
        
        partNameLabel = new JLabel(correctAnswer);
        partNameLabel.setFont(new Font("Zilla Slab", Font.PLAIN, 27));
        partNameLabel.setForeground(Color.BLACK);
        gbcImage2.gridx = 0;
        gbcImage2.gridy = 2;
        review_panel.add(partNameLabel, gbcImage2);
        
        game_panel.revalidate();
        game_panel.repaint();
        review_panel.revalidate();
        review_panel.repaint();
    }

    static ImageIcon createResizedImageIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    
    static void fill() {
        Timer timer = (Timer) timer_panel.getClientProperty("timer");
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        timer = new Timer(1000, new ActionListener() { 
            int count = 0;
            final int max_count = 30;

            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if (count < max_count) {
                    PBar.setValue((int)((count / (double) max_count) * 100));
                } else {
                    ((Timer) e.getSource()).stop();
                    timerOver();
                    count = 0;
                }
            }
        });
        timer_panel.putClientProperty("timer", timer);
        timer.start();
    }
    
    static void timerOver() {
        Timer timer = (Timer) timer_panel.getClientProperty("timer");
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }   
    
        if (roundNum < 10) {
            fill();
            roundNum += 1;
            scoreLabel.setText(Integer.toString(score));
            roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
            answerInputField.setText("");
            AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
            
            if (isReview == false) {
            	switch (difficulty) {
            		case "easy":
            			Map<String, String> easyDictionary = dictionary.getEasyDictionary();
            			generatePart(easyDictionary);
            			break;
            		case "average":
            			Map<String, String> averageDictionary = dictionary.getAverageDictionary();
            			generatePart(averageDictionary);
            		case "difficult":
            			Map<String, String> difficultDictionary = dictionary.getAverageDictionary();
            			generatePart(difficultDictionary);
            	}
            }
            
            else {
            	switch (topic) {
            		case "first":
            			Map<String, String> firstTopic = dictionary.getFirstTopic();
                        generatePart(firstTopic);
                        break;
            		case "second":
            			Map<String, String> secondTopic = dictionary.getSecondTopic();
                        generatePart(secondTopic);
                        break;
            		case "third":
            			Map<String, String> thirdTopic = dictionary.getThirdTopic();
                        generatePart(thirdTopic);
                        break;
            		case "fourth":
            			Map<String, String> fourthTopic = dictionary.getFourthTopic();
                        generatePart(fourthTopic);
                        break;
            		case "fifth":
            			Map<String, String> fifthTopic = dictionary.getFifthTopic();
                        generatePart(fifthTopic);
                        break;
            		case "sixth":
            			Map<String, String> sixthTopic = dictionary.getSixthTopic();
                        generatePart(sixthTopic);
                        break;
            		case "seven":
            			Map<String, String> seventhTopic = dictionary.getSeventhTopic();
                        generatePart(seventhTopic);
                        break;
            		case "eighth":
            			Map<String, String> eighthTopic = dictionary.getEighthTopic();
                        generatePart(eighthTopic);
                        break;
            		case "ninth":
            			Map<String, String> ninthTopic = dictionary.getNinthTopic();
                        generatePart(ninthTopic);
                        break;
            		case "tenth":
            			Map<String, String> tenthTopic = dictionary.getTenthTopic();
                        generatePart(tenthTopic);
                        break;
            	}
            }
        } else if (roundNum == 10) {
            PBar.setValue(0);
            roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
            answerInputField.setText("");
            back_panel.setVisible(false);
            game_panel.setVisible(false);
            timer_panel.setVisible(false);
            game_over_panel.setVisible(true);
        }
    }

    static void submitAnswer() {
        String userAnswer = answerInputField.getText();
        
        if (userAnswer.equalsIgnoreCase(correctAnswer) && roundNum == maxRound) {
        	try {
        		File audioFile = new File("assets/correct_answer.wav");
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        	
            score += 0;
            int count = PBar.getValue();
            
            if (count >= 1 && count <= 20) {
                score += 100;
            } else if (count >= 21 && count <= 40) {
                score += 70;
            } else if (count >= 41 && count <= 60) {
                score += 50;
            } else if (count >= 61 && count <= 80) {
                score += 20;
            } else if (count > 81) {
                score += 10;
            } else if (count >= 100) {
                score += 0;
            }
            
            if (isReview == false) {
            	totalLabel.setText("Score: " + Integer.toString(score)); 
            }
            else {
            	totalLabel.setText("You have completed the review!"); 
            }
            back_panel.setVisible(false);
            game_panel.setVisible(false);
            timer_panel.setVisible(false);
            game_over_panel.setVisible(true);
            answerInputField.setText("");
        } else if (userAnswer.equalsIgnoreCase(correctAnswer) && roundNum < (maxRound + 1)) {
        	try {
        		File audioFile = new File("assets/correct_answer.wav");
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        	
            roundNum += 1;
            int count = PBar.getValue();
            
            if (isReview == true) {
            	review_panel.setVisible(true);
            	game_panel.setVisible(false);
            	timer_panel.setVisible(false);
            }
            else {
            	fill();
                score += 0;
                
                if (count >= 1 && count <= 20) {
                	score += 100;
                } else if (count >= 21 && count <= 40) {
                	score += 70;
                } else if (count >= 41 && count <= 60) {
                	score += 50;
                } else if (count >= 61 && count <= 80) {
                	score += 20;
                } else if (count > 81) {
                	score += 10;
                } else if (count >= 100) {
                	score += 0;
                }
            }
            
            
            scoreLabel.setText(Integer.toString(score));
            roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
            answerInputField.setText("");
            
            AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
            
            if (isReview == false) {
            	switch (difficulty) {
            		case "easy":
            			Map<String, String> easyDictionary = dictionary.getEasyDictionary();
            			generatePart(easyDictionary);
            			break;
            		case "average":
            			Map<String, String> averageDictionary = dictionary.getAverageDictionary();
            			generatePart(averageDictionary);
            		case "difficult":
            			Map<String, String> difficultDictionary = dictionary.getAverageDictionary();
            			generatePart(difficultDictionary);
            	}
            }
            else {
            	switch (topic) {
            		case "first":
            			Map<String, String> firstTopic = dictionary.getFirstTopic();
                        generatePart(firstTopic);
                        break;
            		case "second":
            			Map<String, String> secondTopic = dictionary.getSecondTopic();
                        generatePart(secondTopic);
                        break;
            		case "third":
            			Map<String, String> thirdTopic = dictionary.getThirdTopic();
                        generatePart(thirdTopic);
                        break;
            		case "fourth":
            			Map<String, String> fourthTopic = dictionary.getFourthTopic();
                        generatePart(fourthTopic);
                        break;
            		case "fifth":
            			Map<String, String> fifthTopic = dictionary.getFifthTopic();
                        generatePart(fifthTopic);
                        break;
            		case "sixth":
            			Map<String, String> sixthTopic = dictionary.getSixthTopic();
                        generatePart(sixthTopic);
                        break;
            		case "seven":
            			Map<String, String> seventhTopic = dictionary.getSeventhTopic();
                        generatePart(seventhTopic);
                        break;
            		case "eighth":
            			Map<String, String> eighthTopic = dictionary.getEighthTopic();
                        generatePart(eighthTopic);
                        break;
            		case "ninth":
            			Map<String, String> ninthTopic = dictionary.getNinthTopic();
                        generatePart(ninthTopic);
                        break;
            		case "tenth":
            			Map<String, String> tenthTopic = dictionary.getTenthTopic();
                        generatePart(tenthTopic);
                        break;
            	}
            }
        } else {
            answerInputField.setText("");
            try {
        		File audioFile = new File("assets/wrong_answer.wav");
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    

}
