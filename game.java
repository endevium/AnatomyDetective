package com.BIT5.AnatomyDetective;


import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class game {
	
	private static Set<String> usedParts = new HashSet<>();
	private static JProgressBar PBar;
    private static JFrame main_frame;
    private static JCheckBox musicCheckbox, effectCheckbox;
    private static JLabel gameLogoLabel, scoreLabel, roundLabel, imageLabel, totalLabel, chooseModeLabel, chooseTopicLabel, chooseDifficultyLabel, rememberThisLabel, reviewImageLabel, partNameLabel, htpImageLabel, htpLabel, cardioImageLabel, cardioLabel, digestiveImageLabel, digestiveLabel, endocrineImageLabel, endocrineLabel, excretoryImageLabel, excretoryLabel, immuneImageLabel, immuneLabel, integumentaryImageLabel, integumentaryLabel, nervousImageLabel, nervousLabel, reproductiveImageLabel, reproductiveImageLabel2, reproductiveLabel, respiratoryImageLabel, respiratoryLabel, skeletalImageLabel, skeletalLabel, coinLabel, coinImageLabel, addedCoinLabel, hintLabel;
    private static JTextField answerInputField;
    private static JButton playBtn, submitBtn, skipBtn, tryAgainBtn, menuBtn, backBtn, casualBtn, reviewBtn, htpBtn, modelBtn, easyBtn, averageBtn, difficultBtn, continueBtn, settingsBtn, nervousBtn, skeletalBtn, excretoryBtn, reproductiveBtn, endocrineBtn, respiratoryBtn, integumentaryBtn, cardioBtn, digestiveBtn, immuneBtn, nextBtn, backBtn2, unused_hintBtn;
    private static String correctAnswer; 
    private static JPanel main_panel, mode_panel, topic_panel, difficulty_panel, htpBtn_panel, htp_panel, game_panel, game_over_panel, back_panel, timer_panel, review_panel, settingsBtn_panel, settings_panel, nervous_panel, skeletal_panel, excretory_panel, reproductive_panel, endocrine_panel, respiratory_panel, integumentary_panel, cardiovascular_panel, digestive_panel, immune_panel, nextBtn_panel, backBtn_panel2, coin_panel, hintBtn_panel, hint_panel;
    private static int score, roundNum, maxRound, addedCoins;
    private static int coins;
    private static String difficulty, topic;
    private static boolean isReview;
    
    public static void main(String[] args) {
        main_frame = new JFrame("Anatomy Detective");
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setSize(1024, 950);
        main_frame.setResizable(false);
        main_frame.setLocationRelativeTo(null);
        try {
            ImageIcon backgroundImage = new ImageIcon(ImageIO.read(new File("assets/game_background.png")));
            JLabel bgLabel = new JLabel(backgroundImage);
            main_frame.setContentPane(bgLabel);
        } catch (Exception ex) {
            ex.printStackTrace();
            // Handle image loading error
        }

        Container container = main_frame.getContentPane();
        
        difficulty = "";
        topic = "";
        score = 0;
        addedCoins = 0;
        roundNum = 1;
        maxRound = 10;
        isReview = false;
        
        // Coin panel
        coin_panel = new JPanel() {
        	private static final long serialVersionUID = 1L;

		@Override
        	protected void paintComponent(Graphics g) {
            	super.paintComponent(g);
            	ImageIcon imageIcon = new ImageIcon("assets/coin_panel.png");
            	Image image = imageIcon.getImage();
            	g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        	}
        };
        coin_panel.setBackground(null);
        coin_panel.setLayout(null);
        coin_panel.setOpaque(false);
        coin_panel.setBounds(837, 25, 147, 60);
        container.add(coin_panel);
        
        coinLabel = new JLabel();
        coinLabel.setForeground(Color.WHITE);
        coinLabel.setFont(new Font("Bungee", Font.PLAIN, 23));
        coinLabel.setBounds(70, 18, 80, 30);
        coin_panel.add(coinLabel);
        
        
        // Importing coins.txt
        try {
            File file = new File("assets/coins.txt");
            if (!file.exists()) {
                coins = 0;
            } else {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                reader.close();
                coins = Integer.parseInt(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            coins = 0;
        }

        coinLabel.setText(Integer.toString(coins));
        
        
        // Hint Button Panels
        hintBtn_panel = new JPanel();
        hintBtn_panel.setBackground(null);
        hintBtn_panel.setOpaque(false);
        hintBtn_panel.setVisible(false);
        hintBtn_panel.setBounds(885, 100, 75, 75);
        container.add(hintBtn_panel);
        
        unused_hintBtn = new JButton();
        unused_hintBtn.setIcon(new ImageIcon("assets/unused_hint_button.png"));
        unused_hintBtn.setBackground(null);
        unused_hintBtn.setBorder(null);
        unused_hintBtn.setBorderPainted(false);
        unused_hintBtn.setContentAreaFilled(false);
        unused_hintBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        unused_hintBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {	
            	if (coins >= 5) {
            		coins -= 5;
            		coinLabel.setText(Integer.toString(coins));
            		unused_hintBtn.setIcon(new ImageIcon("assets/used_hint_button.png"));
                	hintBtn_panel.setVisible(false);
                	game_panel.setVisible(false);
                	hint_panel.setVisible(true);
                	timer_panel.setVisible(false);
            		
                	try {
                		File file = new File("assets/coins.txt");
                		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                		writer.write(Integer.toString(coins));
                		writer.close();
                	}
                	catch (Exception ex) {
                		ex.printStackTrace();
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
            	else {
            		if (effectCheckbox.isSelected()) {
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
        });
        hintBtn_panel.add(unused_hintBtn);
        
        hint_panel = new JPanel() {
        	private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("assets/hint_panel.png");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        hint_panel.setLayout(null);
        hint_panel.setBackground(null);
        hint_panel.setBounds(360, 250, 286, 299);
        hint_panel.setVisible(false);
        hint_panel.setOpaque(false);
        container.add(hint_panel);
        
        hintLabel = new JLabel("<html>This part starts with the letter 'S'. It has 5 letters. </html>");
        hintLabel.setFont(new Font("Bungee", Font.BOLD, 25));
        hintLabel.setForeground(Color.WHITE);
        hintLabel.setBounds(50, 30, 200, 250);
        hint_panel.add(hintLabel);
        
        // Main menu panel
        main_panel = new JPanel(new GridBagLayout());
        main_panel.setBackground(null);
        main_panel.setOpaque(false);
        main_panel.setBounds(250, 150, 500, 400);
        container.add(main_panel);
        
        gameLogoLabel = new JLabel();
        gameLogoLabel.setIcon(new ImageIcon("assets/game_logo.png"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);
        main_panel.add(gameLogoLabel, gbc);
        
        coin_panel = new JPanel();
        
        playBtn = new JButton();
        playBtn.setIcon(new ImageIcon("assets/play_button.png"));
        playBtn.setBackground(null);
        playBtn.setBorder(null);
        playBtn.setBorderPainted(false);
        playBtn.setContentAreaFilled(false);
        playBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 0;
        gbc.gridy = 1;
        playBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	main_panel.setVisible(false);
            	mode_panel.setVisible(true);
            	settingsBtn_panel.setVisible(false);
            	htpBtn_panel.setVisible(false);
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
        modelBtn.setIcon(new ImageIcon("assets/atlas_button.png"));
        modelBtn.setBackground(null);
        modelBtn.setBorder(null);
        modelBtn.setBorderPainted(false);
        modelBtn.setContentAreaFilled(false);
        modelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        modelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	main_panel.setVisible(false);
            	back_panel.setVisible(true);
            	cardiovascular_panel.setVisible(true);
                nextBtn_panel.setVisible(true);
                settingsBtn_panel.setVisible(false);
                htpBtn_panel.setVisible(false);
            	
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
        
        
        htpBtn_panel = new JPanel();
        htpBtn_panel.setBackground(null);
        htpBtn_panel.setOpaque(false);
        htpBtn_panel.setBounds(500, 590, 75, 75);
        container.add(htpBtn_panel);
        
        htpBtn = new JButton();
        htpBtn.setIcon(new ImageIcon("assets/htp_button.png"));
        htpBtn.setBackground(null);
        htpBtn.setBorder(null);
        htpBtn.setBorderPainted(false);
        htpBtn.setContentAreaFilled(false);
        htpBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        htpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	main_panel.setVisible(false);
            	htp_panel.setVisible(true);
            	back_panel.setVisible(true);
            	settingsBtn_panel.setVisible(false);
            	htpBtn_panel.setVisible(false);
            	
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
        htpBtn_panel.add(htpBtn);
        
        // Panel for the Settings Button
        settingsBtn_panel = new JPanel();
        settingsBtn_panel.setBackground(null);
        settingsBtn_panel.setBounds(420, 590, 75, 75);
        settingsBtn_panel.setOpaque(false);
        container.add(settingsBtn_panel);
        
        settingsBtn = new JButton();
        settingsBtn.setIcon(new ImageIcon("assets/settings_button.png"));
        settingsBtn.setBackground(null);
        settingsBtn.setBorder(null);
        settingsBtn.setBorderPainted(false);
        settingsBtn.setContentAreaFilled(false);
        settingsBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        settingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		main_panel.setVisible(false);
            		settings_panel.setVisible(true);
            		back_panel.setVisible(true);
            		settingsBtn_panel.setVisible(false);
            		htpBtn_panel.setVisible(false);
            	
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
        settings_panel = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("assets/settings_frame.png");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        settings_panel.setLayout(null);
        settings_panel.setBackground(null);
        settings_panel.setBounds(400, 250, 230, 300);
        settings_panel.setVisible(false);
        settings_panel.setOpaque(false);
        container.add(settings_panel);
        
        musicCheckbox = new JCheckBox(" Music", true);
        musicCheckbox.setFont(new Font("Bungee", Font.PLAIN, 16));
        musicCheckbox.setIcon(new ImageIcon("assets/checkbox.png"));
        musicCheckbox.setSelectedIcon(new ImageIcon("assets/selected_checkbox.png"));
        musicCheckbox.setBackground(null);
        musicCheckbox.setBorderPainted(false);
        musicCheckbox.setContentAreaFilled(false);
        musicCheckbox.setForeground(new Color(4,37,100));
        musicCheckbox.setBounds(25, 70, 200, 50);
        settings_panel.add(musicCheckbox);
        
        effectCheckbox = new JCheckBox(" Sound Effects", true);
        effectCheckbox.setFont(new Font("Bungee", Font.PLAIN, 16));
        effectCheckbox.setIcon(new ImageIcon("assets/checkbox.png"));
        effectCheckbox.setSelectedIcon(new ImageIcon("assets/selected_checkbox.png"));
        effectCheckbox.setBackground(null);
        effectCheckbox.setBorderPainted(false);
        effectCheckbox.setContentAreaFilled(false);
        effectCheckbox.setForeground(new Color(4,37,100));
        effectCheckbox.setBounds(25, 120, 250, 50);
        settings_panel.add(effectCheckbox);
        
        // How to Play panel
        htp_panel = new JPanel(new GridBagLayout());
        htp_panel.setBackground(null);
        htp_panel.setOpaque(false);
        htp_panel.setBounds(100, 85, 800, 700);
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
        htpLabel.setForeground(new Color(4,37,100));
        htpLabel.setPreferredSize(new Dimension(800, 220));
        htpLabel.setFont(new Font("Bungee", Font.PLAIN, 23));
        gbc8.gridx = 0;
        gbc8.gridy = 1;
        htp_panel.add(htpLabel, gbc8);
        
        mode_panel = new JPanel(new GridBagLayout());
        mode_panel.setBackground(null);
        mode_panel.setOpaque(false);
        mode_panel.setBounds(250, 50, 500, 700);
        mode_panel.setVisible(false);
        container.add(mode_panel);
        
        chooseModeLabel = new JLabel();
        chooseModeLabel.setIcon(new ImageIcon("assets/gamemode_label.png"));
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 0;
        gbc4.insets = new Insets(10, 0, 25, 0);
        mode_panel.add(chooseModeLabel, gbc4);
        
        casualBtn = new JButton();
        casualBtn.setIcon(new ImageIcon("assets/casual_button.png"));
        casualBtn.setBackground(null);
        casualBtn.setBorder(null);
        casualBtn.setBorderPainted(false);
        casualBtn.setContentAreaFilled(false);
        casualBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        reviewBtn.setBorderPainted(false);
        reviewBtn.setContentAreaFilled(false);
        reviewBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        difficulty_panel.setBackground(null);
        difficulty_panel.setBounds(250, 75, 500, 700);
        difficulty_panel.setVisible(false);
        difficulty_panel.setOpaque(false);
        container.add(difficulty_panel);
        
        chooseDifficultyLabel = new JLabel();
        chooseDifficultyLabel.setIcon(new ImageIcon("assets/difficulty_label.png"));
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 0;
        gbc5.insets = new Insets(10, 0, 25, 0);
        difficulty_panel.add(chooseDifficultyLabel, gbc5);
        
        
        easyBtn = new JButton();
        easyBtn.setIcon(new ImageIcon("assets/easy_button.png"));
        easyBtn.setBackground(null);
        easyBtn.setBorder(null);
        easyBtn.setBorderPainted(false);
        easyBtn.setContentAreaFilled(false);
        easyBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
                back_panel.setBounds(14, 35, 75, 75);
            	scoreLabel.setText(Integer.toString(score));
            	totalLabel.setText("Score: " + Integer.toString(score));
        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear(); 

            	difficulty_panel.setVisible(false);
            	game_panel.setVisible(true);
            	timer_panel.setVisible(true);
            	hintBtn_panel.setVisible(true);
            	
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
        averageBtn.setBorderPainted(false);
        averageBtn.setContentAreaFilled(false);
        averageBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
            	back_panel.setBounds(14, 35, 75, 75);
            	scoreLabel.setText(Integer.toString(score));
            	totalLabel.setText("Score: " + Integer.toString(score));
        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear();
            	
            	difficulty_panel.setVisible(false);
            	game_panel.setVisible(true);
            	timer_panel.setVisible(true);
            	hintBtn_panel.setVisible(true);
            	
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
        difficultBtn.setBorderPainted(false);
        difficultBtn.setContentAreaFilled(false);
        difficultBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
            	back_panel.setBounds(14, 35, 75, 75);
            	scoreLabel.setText(Integer.toString(score));
            	totalLabel.setText("Score: " + Integer.toString(score));
        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
        		usedParts.clear();
        			
            	difficulty_panel.setVisible(false);
            	game_panel.setVisible(true);
            	timer_panel.setVisible(true);
            	hintBtn_panel.setVisible(true);
            	
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
        topic_panel.setBackground(null);
        topic_panel.setBounds(60, 0, 900, 900);
        topic_panel.setOpaque(false);
        topic_panel.setVisible(false);
        container.add(topic_panel);
        
        chooseTopicLabel = new JLabel();
        chooseTopicLabel.setIcon(new ImageIcon("assets/topic_label.png"));
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 1;
        gbc6.gridy = 0;
        gbc6.insets = new Insets(10, 0, 25, 0);
        topic_panel.add(chooseTopicLabel, gbc6);
        
        cardioBtn = new JButton();
        cardioBtn.setIcon(new ImageIcon("assets/cardiovascular_system.png"));
        cardioBtn.setBackground(null);
        cardioBtn.setBorder(null);
        cardioBtn.setBorderPainted(false);
        cardioBtn.setContentAreaFilled(false);
        cardioBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cardioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> firstTopic = dictionary.getFirstTopic();
                generatePart(firstTopic);
                
            	score = 0;
            	roundNum = 1;
            	topic = "cardiovascular";
            	isReview = true;
            	back_panel.setBounds(14, 35, 75, 75);
            	
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
        digestiveBtn.setBorderPainted(false);
        digestiveBtn.setContentAreaFilled(false);
        digestiveBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        digestiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> secondTopic = dictionary.getSecondTopic();
                generatePart(secondTopic);
                
            	score = 0;
            	roundNum = 1;
            	topic = "digestive";
            	isReview = true;
            	back_panel.setBounds(14, 35, 75, 75);
            	
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
        endocrineBtn.setBorderPainted(false);
        endocrineBtn.setContentAreaFilled(false);
        endocrineBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        endocrineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> thirdTopic = dictionary.getThirdTopic();
                generatePart(thirdTopic);
                
            	score = 0;
            	roundNum = 1;
            	topic = "endocrine";
            	isReview = true;
            	back_panel.setBounds(14, 35, 75, 75);
            	
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
        excretoryBtn.setBorderPainted(false);
        excretoryBtn.setContentAreaFilled(false);
        excretoryBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        excretoryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> fourthTopic = dictionary.getFourthTopic();
                generatePart(fourthTopic);
                
                score = 0;
            	roundNum = 1;
            	topic = "excretory";
            	isReview = true;
            	back_panel.setBounds(14, 35, 75, 75);
        	            	
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
        immuneBtn.setBorderPainted(false);
        immuneBtn.setContentAreaFilled(false);
        immuneBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        immuneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> fifthTopic = dictionary.getFifthTopic();
                generatePart(fifthTopic);
                
                score = 0;
            	roundNum = 1;
            	topic = "immune";
            	isReview = true;
            	back_panel.setBounds(14, 35, 75, 75);
            	
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
        integumentaryBtn.setBorderPainted(false);
        integumentaryBtn.setContentAreaFilled(false);
        integumentaryBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        integumentaryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> sixthTopic = dictionary.getSixthTopic();
                generatePart(sixthTopic);
                
            	score = 0;
            	roundNum = 1;
            	topic = "integumentary";
            	isReview = true;
            	back_panel.setBounds(14, 35, 75, 75);
            	
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
        nervousBtn.setBorderPainted(false);
        nervousBtn.setContentAreaFilled(false);
        nervousBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nervousBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> seventhTopic = dictionary.getSeventhTopic();
                generatePart(seventhTopic);
                
                score = 0;
            	roundNum = 1;
            	topic = "nervous";
            	isReview = true;
            	back_panel.setBounds(14, 35, 75, 75);
            	
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
        reproductiveBtn.setBorderPainted(false);
        reproductiveBtn.setContentAreaFilled(false);
        reproductiveBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reproductiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> eighthTopic = dictionary.getEighthTopic();
                generatePart(eighthTopic);
                
                score = 0;
            	roundNum = 1;
            	topic = "reproductive";
            	isReview = true;
            	back_panel.setBounds(14, 35, 75, 75);
            	
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
        respiratoryBtn.setBorderPainted(false);
        respiratoryBtn.setContentAreaFilled(false);
        respiratoryBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        respiratoryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> ninthTopic = dictionary.getNinthTopic();
                generatePart(ninthTopic);
                
                score = 0;
            	roundNum = 1;
            	topic = "respiratory";
            	isReview = true;
            	back_panel.setBounds(14, 35, 75, 75);
            	
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
        skeletalBtn.setBorderPainted(false);
        skeletalBtn.setContentAreaFilled(false);
        skeletalBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        skeletalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnatomyDetectiveDictionary dictionary = new AnatomyDetectiveDictionary();
                Map<String, String> ninthTopic = dictionary.getTenthTopic();
                generatePart(ninthTopic);
                
                score = 0;
            	roundNum = 1;
            	topic = "skeletal";
            	isReview = true;
            	back_panel.setBounds(14, 35, 75, 75);
            	
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
        back_panel.setBackground(null);
        back_panel.setBounds(14, 15, 75, 75);
        back_panel.setOpaque(false);
        back_panel.setVisible(false);
        container.add(back_panel);
        
        backBtn = new JButton();
        backBtn.setIcon(new ImageIcon("assets/back_button.png"));
        backBtn.setBackground(null);
        backBtn.setBorder(null);
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (hint_panel.isVisible() == false) {
	            	Timer timer = (Timer) timer_panel.getClientProperty("timer");
	                if (timer != null && timer.isRunning()) {
	                    timer.stop();
	                }
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
            	
            	
            	
            	score = 0;
            	roundNum = 1;
            	skipBtn.setVisible(true);
            	scoreLabel.setText(Integer.toString(score));
            	totalLabel.setText("Score: " + Integer.toString(score));
        		roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
                
            	if (mode_panel.isVisible()) {
            		mode_panel.setVisible(false);
            		back_panel.setVisible(false);
            		main_panel.setVisible(true);
            		settingsBtn_panel.setVisible(true);
            		htpBtn_panel.setVisible(true);
            	}
            	else if (hint_panel.isVisible()) {
            		hint_panel.setVisible(false);
            		timer_panel.setVisible(true);
            		hintBtn_panel.setVisible(true);
            		unused_hintBtn.setIcon(new ImageIcon("assets/unused_hint_button.png"));
            		game_panel.setVisible(true);
            	}
            	else if (htp_panel.isVisible()) {
            		htp_panel.setVisible(false);
            		back_panel.setVisible(false);
            		main_panel.setVisible(true);
            		settingsBtn_panel.setVisible(true);
            		htpBtn_panel.setVisible(true);
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
            		topic_panel.setVisible(true);
            		isReview = false;
            		usedParts.clear();
            	}
            	else if (game_panel.isVisible() && isReview == true) {
            		game_panel.setVisible(false);
            		timer_panel.setVisible(false);
            		topic_panel.setVisible(true);
            		
            		isReview = false;
            		maxRound = 10;
            		usedParts.clear();
            		back_panel.setBounds(14, 15, 75, 75);
            	}
            	else if (game_panel.isVisible()) {
            		game_panel.setVisible(false);
            		timer_panel.setVisible(false);
            		difficulty_panel.setVisible(true);
            		hintBtn_panel.setVisible(false);
            		usedParts.clear();
            		back_panel.setBounds(14, 15, 75, 75);
            	}
            	else if (settings_panel.isVisible()) {
            		main_panel.setVisible(true);
            		settings_panel.setVisible(false);
            		settingsBtn_panel.setVisible(true);
            		htpBtn_panel.setVisible(true);
            		back_panel.setVisible(false);
            	}
            	else if (cardiovascular_panel.isVisible()) {
            		cardiovascular_panel.setVisible(false);
            		nextBtn_panel.setVisible(false);
            		backBtn_panel2.setVisible(false);
            		back_panel.setVisible(false);
            		main_panel.setVisible(true);
            		settingsBtn_panel.setVisible(true);
            		htpBtn_panel.setVisible(true);
            	}
            	else if (digestive_panel.isVisible()) {
            		digestive_panel.setVisible(false);
            		nextBtn_panel.setVisible(false);
            		backBtn_panel2.setVisible(false);
            		back_panel.setVisible(false);
            		main_panel.setVisible(true);
            		settingsBtn_panel.setVisible(true);
            		htpBtn_panel.setVisible(true);
            	}
            	else if (endocrine_panel.isVisible()) {
            		endocrine_panel.setVisible(false);
            		nextBtn_panel.setVisible(false);
            		backBtn_panel2.setVisible(false);
            		back_panel.setVisible(false);
            		main_panel.setVisible(true);
            		settingsBtn_panel.setVisible(true);
            		htpBtn_panel.setVisible(true);
            	}
            	else if (excretory_panel.isVisible()) {
            		excretory_panel.setVisible(false);
            		nextBtn_panel.setVisible(false);
            		backBtn_panel2.setVisible(false);
            		back_panel.setVisible(false);
            		main_panel.setVisible(true);
            		settingsBtn_panel.setVisible(true);
            		htpBtn_panel.setVisible(true);
            	}
            	else if (immune_panel.isVisible()) {
            		immune_panel.setVisible(false);
            		nextBtn_panel.setVisible(false);
            		backBtn_panel2.setVisible(false);
            		back_panel.setVisible(false);
            		main_panel.setVisible(true);
            		settingsBtn_panel.setVisible(true);
            		htpBtn_panel.setVisible(true);
            	}
            	else if (integumentary_panel.isVisible()) {
            		integumentary_panel.setVisible(false);
            		nextBtn_panel.setVisible(false);
            		backBtn_panel2.setVisible(false);
            		back_panel.setVisible(false);
            		main_panel.setVisible(true);
            		settingsBtn_panel.setVisible(true);
            		htpBtn_panel.setVisible(true);
            	}
            	else if (nervous_panel.isVisible()) {
            		nervous_panel.setVisible(false);
            		nextBtn_panel.setVisible(false);
            		backBtn_panel2.setVisible(false);
            		back_panel.setVisible(false);
            		main_panel.setVisible(true);
            		settingsBtn_panel.setVisible(true);
            		htpBtn_panel.setVisible(true);
            	}
            	else if (reproductive_panel.isVisible()) {
            		reproductive_panel.setVisible(false);
            		nextBtn_panel.setVisible(false);
            		backBtn_panel2.setVisible(false);
            		back_panel.setVisible(false);
            		main_panel.setVisible(true);
            		settingsBtn_panel.setVisible(true);
            		htpBtn_panel.setVisible(true);
            	}
            	else if (respiratory_panel.isVisible()) {
            		respiratory_panel.setVisible(false);
            		nextBtn_panel.setVisible(false);
            		backBtn_panel2.setVisible(false);
            		back_panel.setVisible(false);
            		main_panel.setVisible(true);
            		settingsBtn_panel.setVisible(true);
            		htpBtn_panel.setVisible(true);
            	}
            	else if (skeletal_panel.isVisible()) {
            		skeletal_panel.setVisible(false);
            		nextBtn_panel.setVisible(false);
            		backBtn_panel2.setVisible(false);
            		back_panel.setVisible(false);
            		main_panel.setVisible(true);
            		settingsBtn_panel.setVisible(true);
            		htpBtn_panel.setVisible(true);
            	}
            }
        });
        back_panel.add(backBtn);
        
        // Model Panel
        backBtn_panel2 = new JPanel();
        backBtn_panel2.setBackground(null);
        backBtn_panel2.setVisible(false);
        backBtn_panel2.setOpaque(false);
        backBtn_panel2.setLayout(null);
        backBtn_panel2.setBounds(10, 355, 100, 100);
        container.add(backBtn_panel2);

        backBtn2 = new JButton();
        backBtn2.setIcon(new ImageIcon("assets/back_button.png"));
        backBtn2.setBounds(0, 0, 75, 75);
        backBtn2.setBackground(null);
        backBtn2.setBorder(null);
        backBtn2.setBorderPainted(false);
        backBtn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backBtn2.setContentAreaFilled(false);
        backBtn2.addActionListener(new ActionListener() {
            @Override
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
            	
            	if (digestive_panel.isVisible()) {
            		cardiovascular_panel.setVisible(true);
            		digestive_panel.setVisible(false);
            		backBtn_panel2.setVisible(false);
            		nextBtn_panel.setVisible(true);
            	}
            	else if (endocrine_panel.isVisible()) {
                    endocrine_panel.setVisible(false);
                    digestive_panel.setVisible(true);
                    nextBtn_panel.setVisible(true);
                } 
                else if (excretory_panel.isVisible()) {
                    excretory_panel.setVisible(false);
                    endocrine_panel.setVisible(true);
                    nextBtn_panel.setVisible(true);
                } 
                else if (immune_panel.isVisible()) {
                    immune_panel.setVisible(false);
                    excretory_panel.setVisible(true);
                    nextBtn_panel.setVisible(true);
                } 
                else if (integumentary_panel.isVisible()) {
                    integumentary_panel.setVisible(false);
                    immune_panel.setVisible(true);
                    nextBtn_panel.setVisible(true);
                } 
                else if (nervous_panel.isVisible()) {
                    nervous_panel.setVisible(false);
                    integumentary_panel.setVisible(true);
                    nextBtn_panel.setVisible(true);
                } 
                else if (reproductive_panel.isVisible()) {
                    reproductive_panel.setVisible(false);
                    nervous_panel.setVisible(true);
                    nextBtn_panel.setVisible(true);
                } 
                else if (respiratory_panel.isVisible()) {
                    respiratory_panel.setVisible(false);
                    reproductive_panel.setVisible(true);
                    nextBtn_panel.setVisible(true);
                } 
                else if (skeletal_panel.isVisible()) {
                    skeletal_panel.setVisible(false);
                    respiratory_panel.setVisible(true);
                    nextBtn_panel.setVisible(true);
                }
            }
        }});
        backBtn_panel2.add(backBtn2);	

        nextBtn_panel = new JPanel();
        nextBtn_panel.setBackground(null);
        nextBtn_panel.setVisible(false);
        nextBtn_panel.setLayout(null);
        nextBtn_panel.setOpaque(false);
        nextBtn_panel.setBounds(900, 350, 100, 100);
        container.add(nextBtn_panel);
        
        nextBtn = new JButton();
        nextBtn.setIcon(new ImageIcon("assets/next_button.png"));
        nextBtn.setBounds(0, 0, 75, 75);
        nextBtn.setBackground(null);
        nextBtn.setBorder(null);
        nextBtn.setBorderPainted(false);
        nextBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nextBtn.setContentAreaFilled(false);
        nextBtn.addActionListener(new ActionListener() {
            @Override
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
                if ( cardiovascular_panel.isVisible()) {
                    cardiovascular_panel.setVisible(false);
                    digestive_panel.setVisible(true); 
                    backBtn_panel2.setVisible(true);
                }

                else if ( digestive_panel.isVisible()) {
                    digestive_panel.setVisible(false);
                    endocrine_panel.setVisible(true);
                }

                else if (endocrine_panel.isVisible()) {
                    endocrine_panel.setVisible(false);
                    excretory_panel.setVisible(true);
                }
                
                else if (excretory_panel.isVisible()) {
                    excretory_panel.setVisible(false);
                    immune_panel.setVisible(true);
                }

                else if (immune_panel.isVisible()) {
                    immune_panel.setVisible(false);
                    integumentary_panel.setVisible(true);
                }

                else if (integumentary_panel.isVisible()) {
                    integumentary_panel.setVisible(false);
                    nervous_panel.setVisible(true);
                }

                else if (nervous_panel.isVisible()) {
                    nervous_panel.setVisible(false);
                    reproductive_panel.setVisible(true);
                }

                else if (reproductive_panel.isVisible()) {
                    reproductive_panel.setVisible(false);
                    respiratory_panel.setVisible(true);
                }

                else if (respiratory_panel.isVisible()) {
                    respiratory_panel.setVisible(false);
                    skeletal_panel.setVisible(true);
                    nextBtn_panel.setVisible(false);
                }
            }
        });
        nextBtn_panel.add(nextBtn);
        
        cardiovascular_panel = new JPanel();
        cardiovascular_panel.setBackground(null);
        cardiovascular_panel.setVisible(false);
        cardiovascular_panel.setLayout(null);
        cardiovascular_panel.setOpaque(false);
        cardiovascular_panel.setBounds(320, 100, 383, 700);
        container.add(cardiovascular_panel);
        
        cardioImageLabel = new JLabel();
        cardioImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        cardioImageLabel.setBackground(null);
        cardioImageLabel.setBounds(0, 0, 383, 612);
        cardiovascular_panel.add(cardioImageLabel);
        
        cardioLabel = new JLabel("Cardiovascular System");
        cardioLabel.setFont(new Font("Bungee", Font.BOLD, 25));
        cardioLabel.setForeground(new Color(4,37,100));
        cardioLabel.setBackground(null);
        cardioLabel.setBounds(10, 615, 500, 100);
        cardiovascular_panel.add(cardioLabel);
        
        digestive_panel = new JPanel();
        digestive_panel.setBackground(null);
        digestive_panel.setVisible(false);
        digestive_panel.setLayout(null);
        digestive_panel.setOpaque(false);
        digestive_panel.setBounds(320, 100, 383, 700);
        container.add(digestive_panel);
        
        digestiveImageLabel = new JLabel();
        digestiveImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        digestiveImageLabel.setBackground(null);
        digestiveImageLabel.setBounds(0, 0, 383, 612);
        digestive_panel.add(digestiveImageLabel);
        
        digestiveLabel = new JLabel("Digestive System");
        digestiveLabel.setFont(new Font("Bungee", Font.BOLD, 30));
        digestiveLabel.setForeground(new Color(4,37,100));
        digestiveLabel.setBackground(null);
        digestiveLabel.setBounds(25, 615, 500, 100);
        digestive_panel.add(digestiveLabel);
        
        endocrine_panel = new JPanel();
        endocrine_panel.setBackground(null);
        endocrine_panel.setVisible(false);
        endocrine_panel.setLayout(null);
        endocrine_panel.setOpaque(false);
        endocrine_panel.setBounds(320, 100, 383, 700);
        container.add(endocrine_panel);
        
        endocrineImageLabel = new JLabel();
        endocrineImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        endocrineImageLabel.setBackground(null);
        endocrineImageLabel.setBounds(0, 0, 383, 612);
        endocrine_panel.add(endocrineImageLabel);
        
        endocrineLabel = new JLabel("Endocrine System");
        endocrineLabel.setFont(new Font("Bungee", Font.BOLD, 30));
        endocrineLabel.setForeground(new Color(4,37,100));
        endocrineLabel.setBackground(null);
        endocrineLabel.setBounds(25, 615, 500, 100);
        endocrine_panel.add(endocrineLabel);
        
        excretory_panel = new JPanel();
        excretory_panel.setBackground(null);
        excretory_panel.setVisible(false);
        excretory_panel.setLayout(null);
        excretory_panel.setOpaque(false);
        excretory_panel.setBounds(320, 100, 383, 700);
        container.add(excretory_panel);
        
        excretoryImageLabel = new JLabel();
        excretoryImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        excretoryImageLabel.setBackground(null);
        excretoryImageLabel.setBounds(0, 0, 383, 612);
        excretory_panel.add(excretoryImageLabel);
        
        excretoryLabel = new JLabel("Excretory System");
        excretoryLabel.setFont(new Font("Bungee", Font.BOLD, 30));
        excretoryLabel.setForeground(new Color(4,37,100));
        excretoryLabel.setBackground(null);
        excretoryLabel.setBounds(25, 615, 500, 100);
        excretory_panel.add(excretoryLabel);
        
        immune_panel = new JPanel();
        immune_panel.setBackground(null);
        immune_panel.setVisible(false);
        immune_panel.setLayout(null);
        immune_panel.setOpaque(false);
        immune_panel.setBounds(320, 100, 383, 700);
        container.add(immune_panel);
        
        immuneImageLabel = new JLabel();
        immuneImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        immuneImageLabel.setBackground(null);
        immuneImageLabel.setBounds(0, 0, 383, 612);
        immune_panel.add(immuneImageLabel);
        
        immuneLabel = new JLabel("Immune System");
        immuneLabel.setFont(new Font("Bungee", Font.BOLD, 30));
        immuneLabel.setForeground(new Color(4,37,100));
        immuneLabel.setBackground(null);
        immuneLabel.setBounds(45, 615, 500, 100);
        immune_panel.add(immuneLabel);
        
        integumentary_panel = new JPanel();
        integumentary_panel.setBackground(null);
        integumentary_panel.setVisible(false);
        integumentary_panel.setLayout(null);
        integumentary_panel.setOpaque(false);
        integumentary_panel.setBounds(320, 100, 383, 700);
        container.add(integumentary_panel);
        
        integumentaryImageLabel = new JLabel();
        integumentaryImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        integumentaryImageLabel.setBackground(null);
        integumentaryImageLabel.setBounds(0, 0, 383, 612);
        integumentary_panel.add(integumentaryImageLabel);
        
        integumentaryLabel = new JLabel("Integumentary System");
        integumentaryLabel.setFont(new Font("Bungee", Font.BOLD, 26));
        integumentaryLabel.setForeground(new Color(4,37,100));
        integumentaryLabel.setBackground(null);
        integumentaryLabel.setBounds(10, 615, 500, 100);
        integumentary_panel.add(integumentaryLabel);
        
        nervous_panel = new JPanel();
        nervous_panel.setBackground(null);
        nervous_panel.setVisible(false);
        nervous_panel.setLayout(null);
        nervous_panel.setOpaque(false);
        nervous_panel.setBounds(320, 100, 383, 700);
        container.add(nervous_panel);
        
        nervousImageLabel = new JLabel();
        nervousImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        nervousImageLabel.setBackground(null);
        nervousImageLabel.setBounds(0, 0, 383, 612);
        nervous_panel.add(nervousImageLabel);
        
        nervousLabel = new JLabel("Nervous System");
        nervousLabel.setFont(new Font("Bungee", Font.BOLD, 30));
        nervousLabel.setForeground(new Color(4,37,100));
        nervousLabel.setBackground(null);
        nervousLabel.setBounds(45, 615, 500, 100);
        nervous_panel.add(nervousLabel);
        
        reproductive_panel = new JPanel();
        reproductive_panel.setBackground(null);
        reproductive_panel.setVisible(false);
        reproductive_panel.setLayout(null);
        reproductive_panel.setOpaque(false);
        reproductive_panel.setBounds(100, 100, 750, 700);
        container.add(reproductive_panel);
        
        reproductiveImageLabel = new JLabel();
        reproductiveImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        reproductiveImageLabel.setBackground(null);
        reproductiveImageLabel.setBounds(20, 0, 383, 612);
        reproductive_panel.add(reproductiveImageLabel);
        
        reproductiveImageLabel2 = new JLabel();
        reproductiveImageLabel2.setIcon(new ImageIcon("assets/human_body.png"));
        reproductiveImageLabel2.setBackground(null);
        reproductiveImageLabel2.setBounds(420, 0, 383, 612);
        reproductive_panel.add(reproductiveImageLabel2);
        
        reproductiveLabel = new JLabel("Reproductive System");
        reproductiveLabel.setFont(new Font("Bungee", Font.BOLD, 30));
        reproductiveLabel.setForeground(new Color(4,37,100));
        reproductiveLabel.setBackground(null);
        reproductiveLabel.setBounds(220, 615, 500, 100);
        reproductive_panel.add(reproductiveLabel);
        
        respiratory_panel = new JPanel();
        respiratory_panel.setBackground(null);
        respiratory_panel.setVisible(false);
        respiratory_panel.setLayout(null);
        respiratory_panel.setOpaque(false);
        respiratory_panel.setBounds(320, 100, 383, 700);
        container.add(respiratory_panel);
        
        respiratoryImageLabel = new JLabel();
        respiratoryImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        respiratoryImageLabel.setBackground(null);
        respiratoryImageLabel.setBounds(0, 0, 383, 612);
        respiratory_panel.add(respiratoryImageLabel);
        
        respiratoryLabel = new JLabel("Respiratory System");
        respiratoryLabel.setFont(new Font("Bungee", Font.BOLD, 30));
        respiratoryLabel.setForeground(new Color(4,37,100));
        respiratoryLabel.setBackground(null);
        respiratoryLabel.setBounds(0, 615, 500, 100);
        respiratory_panel.add(respiratoryLabel);
        
        skeletal_panel = new JPanel();
        skeletal_panel.setBackground(null);
        skeletal_panel.setVisible(false);
        skeletal_panel.setLayout(null);
        skeletal_panel.setOpaque(false);
        skeletal_panel.setBounds(320, 100, 383, 700);
        container.add(skeletal_panel);
        
        skeletalImageLabel = new JLabel();
        skeletalImageLabel.setIcon(new ImageIcon("assets/human_body.png"));
        skeletalImageLabel.setBackground(null);
        skeletalImageLabel.setBounds(0, 0, 383, 612);
        skeletal_panel.add(skeletalImageLabel);
        
        skeletalLabel = new JLabel("Skeletal System");
        skeletalLabel.setFont(new Font("Bungee", Font.BOLD, 30));
        skeletalLabel.setForeground(new Color(4,37,100));
        skeletalLabel.setBackground(null);
        skeletalLabel.setBounds(25, 615, 500, 100);
        skeletal_panel.add(skeletalLabel);
        
        // Review Panel
        review_panel = new JPanel(new GridBagLayout());
        review_panel.setBackground(null);
        review_panel.setOpaque(false);
        review_panel.setBounds(250, 60, 500, 700);
        review_panel.setVisible(false);
        container.add(review_panel);
        
        rememberThisLabel = new JLabel("Remember this!");
        rememberThisLabel.setFont(new Font("Bungee", Font.BOLD, 40));
        rememberThisLabel.setForeground(new Color(4,37,100));
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 0;
        gbc7.gridy = 0;
        gbc7.insets = new Insets(10, 0, 10, 0);
        review_panel.add(rememberThisLabel, gbc7);
        
        continueBtn = new JButton();
        continueBtn.setIcon(new ImageIcon("assets/play_button.png"));
        continueBtn.setBackground(null);
        continueBtn.setBorder(null);
        continueBtn.setBorderPainted(false);
        continueBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        continueBtn.setContentAreaFilled(false);
        gbc7.gridx = 0;
        gbc7.gridy = 3;
        continueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	isReview = true;
            	review_panel.setVisible(false);
            	game_panel.setVisible(true);
            	timer_panel.setVisible(false);
            	scoreLabel.setText(topic);
            	skipBtn.setVisible(false);
            	back_panel.setBounds(14, 35, 75, 75);
            	
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
        game_panel.setBackground(null);
        game_panel.setBounds(250, 30, 500, 800);
        game_panel.setVisible(false);
        game_panel.setOpaque(false);
        container.add(game_panel);

        scoreLabel = new JLabel(Integer.toString(score));
        scoreLabel.setFont(new Font("Bungee", Font.BOLD, 40));
        scoreLabel.setForeground(new Color(4,37,100));
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.insets = new Insets(10, 0, 10, 0);
        game_panel.add(scoreLabel, gbc2);
        
        timer_panel = new JPanel();
        timer_panel.setBackground(null);
        timer_panel.setBounds(0, -6, 1040, 100);
        timer_panel.setVisible(false);
        timer_panel.setOpaque(false);
        container.add(timer_panel);
        
        PBar = new JProgressBar();
        PBar.setValue(0);
        PBar.setPreferredSize(new Dimension(1040, 25));
        PBar.setForeground(Color.GRAY);
        PBar.setBackground(Color.white);
        PBar.setBorder(null);
        timer_panel.add(PBar);
        
        roundLabel = new JLabel(Integer.toString(roundNum) + "/10");
        roundLabel.setFont(new Font("Bungee", Font.PLAIN, 21));
        roundLabel.setForeground(new Color(4,37,100));
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        game_panel.add(roundLabel, gbc2);

        answerInputField = new JTextField("");
        answerInputField.setFont(new Font("Bungee", Font.PLAIN, 19));
        answerInputField.setPreferredSize(new Dimension(300, 40));
        answerInputField.setMinimumSize(new Dimension(300, 40));
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
        submitBtn.setIcon(new ImageIcon("assets/submit_button.png"));
        submitBtn.setBackground(null);
        submitBtn.setBorder(null);
        submitBtn.setBorderPainted(false);
        submitBtn.setContentAreaFilled(false);
        submitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        skipBtn.setBorderPainted(false);
        skipBtn.setContentAreaFilled(false);
        skipBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
                    			Map<String, String> difficultDictionary = dictionary.getDifficultDictionary();
                    			generatePart(difficultDictionary);
                    	}
                    }
                    else {
                    	switch (topic) {
                    		case "cardiovascular":
                    			Map<String, String> firstTopic = dictionary.getFirstTopic();
                                generatePart(firstTopic);
                                break;
                    		case "digestive":
                    			Map<String, String> secondTopic = dictionary.getSecondTopic();
                                generatePart(secondTopic);
                                break;
                    		case "endocrine":
                    			Map<String, String> thirdTopic = dictionary.getThirdTopic();
                                generatePart(thirdTopic);
                                break;
                    		case "excretory":
                    			Map<String, String> fourthTopic = dictionary.getFourthTopic();
                                generatePart(fourthTopic);
                                break;
                    		case "immune":
                    			Map<String, String> fifthTopic = dictionary.getFifthTopic();
                                generatePart(fifthTopic);
                                break;
                    		case "integumentary":
                    			Map<String, String> sixthTopic = dictionary.getSixthTopic();
                                generatePart(sixthTopic);
                                break;
                    		case "nervous":
                    			Map<String, String> seventhTopic = dictionary.getSeventhTopic();
                                generatePart(seventhTopic);
                                break;
                    		case "reproductive":
                    			Map<String, String> eighthTopic = dictionary.getEighthTopic();
                                generatePart(eighthTopic);
                                break;
                    		case "respiratory":
                    			Map<String, String> ninthTopic = dictionary.getNinthTopic();
                                generatePart(ninthTopic);
                                break;
                    		case "skeletal":
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
                    	totalLabel.setText("<html> You have completed the review! <html>"); 
                    	totalLabel.setBounds(30, -20, 200, 250);
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
                    hintBtn_panel.setVisible(false);
                    game_over_panel.setVisible(true);
                }
            }
        });
        gbc2.gridx = 0;
        gbc2.gridy = 6;
        game_panel.add(skipBtn, gbc2);

        game_over_panel = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("assets/game_over_panel.png");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        game_over_panel.setBackground(null);
        game_over_panel.setLayout(null);
        game_over_panel.setOpaque(false);
        game_over_panel.setBounds(400, 250, 225, 243);
        game_over_panel.setVisible(false);
        container.add(game_over_panel);

        totalLabel = new JLabel("Score: " + score);
        totalLabel.setFont(new Font("Bungee", Font.BOLD, 25));
        totalLabel.setForeground(Color.WHITE);
        totalLabel.setBounds(50, -50, 200, 250);
        game_over_panel.add(totalLabel);
        
        coinImageLabel = new JLabel();
        coinImageLabel.setIcon(new ImageIcon("assets/coin.png"));
        coinImageLabel.setBounds(60, 90, 60, 60);
        game_over_panel.add(coinImageLabel);
        
        addedCoinLabel = new JLabel("+0");
        addedCoinLabel.setFont(new Font("Bungee", Font.BOLD, 25));
        addedCoinLabel.setForeground(Color.WHITE);
        addedCoinLabel.setBounds(120, 90, 200, 60);
        game_over_panel.add(addedCoinLabel);

        tryAgainBtn = new JButton();
        tryAgainBtn.setIcon(new ImageIcon("assets/try_again_button.png"));
        tryAgainBtn.setBackground(null);
        tryAgainBtn.setBorder(null);
        tryAgainBtn.setBorderPainted(false);
        tryAgainBtn.setContentAreaFilled(false);
        tryAgainBtn.setBounds(40, 155, 75, 75);
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
                hintBtn_panel.setVisible(true);
                roundNum = 1;
                addedCoins = 0;
            	addedCoinLabel.setText("+" + addedCoins);
                game_over_panel.revalidate();
                game_over_panel.repaint();
                
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
                			Map<String, String> difficultDictionary = dictionary.getDifficultDictionary();
                			generatePart(difficultDictionary);
                	}
                }
                else {
                	switch (topic) {
	                	case "cardiovascular":
	            			Map<String, String> firstTopic = dictionary.getFirstTopic();
	                        generatePart(firstTopic);
	                        break;
	            		case "digestive":
	            			Map<String, String> secondTopic = dictionary.getSecondTopic();
	                        generatePart(secondTopic);
	                        break;
	            		case "endocrine":
	            			Map<String, String> thirdTopic = dictionary.getThirdTopic();
	                        generatePart(thirdTopic);
	                        break;
	            		case "excretory":
	            			Map<String, String> fourthTopic = dictionary.getFourthTopic();
	                        generatePart(fourthTopic);
	                        break;
	            		case "immune":
	            			Map<String, String> fifthTopic = dictionary.getFifthTopic();
	                        generatePart(fifthTopic);
	                        break;
	            		case "integumentary":
	            			Map<String, String> sixthTopic = dictionary.getSixthTopic();
	                        generatePart(sixthTopic);
	                        break;
	            		case "nervous":
	            			Map<String, String> seventhTopic = dictionary.getSeventhTopic();
	                        generatePart(seventhTopic);
	                        break;
	            		case "reproductive":
	            			Map<String, String> eighthTopic = dictionary.getEighthTopic();
	                        generatePart(eighthTopic);
	                        break;
	            		case "respiratory":
	            			Map<String, String> ninthTopic = dictionary.getNinthTopic();
	                        generatePart(ninthTopic);
	                        break;
	            		case "skeletal":
	            			Map<String, String> tenthTopic = dictionary.getTenthTopic();
	                        generatePart(tenthTopic);
	                        break;
                	}
                }
                back_panel.setVisible(true);
            }
        });
        game_over_panel.add(tryAgainBtn);

        menuBtn = new JButton();
        menuBtn.setIcon(new ImageIcon("assets/menu_button.png"));
        menuBtn.setBackground(null);
        menuBtn.setBorder(null);
        menuBtn.setBorderPainted(false);
        menuBtn.setContentAreaFilled(false);
        menuBtn.setBounds(110, 155, 75, 75);
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
                hintBtn_panel.setVisible(false);
                settingsBtn_panel.setVisible(true);
                htpBtn_panel.setVisible(true);
                skipBtn.setVisible(true); 
                back_panel.setBounds(14, 15, 75, 75);
                
                addedCoins = 0;
            	addedCoinLabel.setText("+" + addedCoins);
                game_over_panel.revalidate();
                game_over_panel.repaint();
                
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
        game_over_panel.add(menuBtn);

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

        ImageIcon partImage = createResizedImageIcon(imageDir, 400, 400);

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
        imageLabel.setBorder(BorderFactory.createLineBorder(new Color(4,37,100), 2));
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
        partNameLabel.setFont(new Font("Bungee", Font.PLAIN, 27));
        partNameLabel.setForeground(new Color(4,37,100));
        gbcImage2.gridx = 0;
        gbcImage2.gridy = 2;
        review_panel.add(partNameLabel, gbcImage2);
        
        char firstLetter = partName.charAt(0);
        int lettersNum = 0;
        for (int i = 0; i < partName.length(); i++) {
            if (partName.charAt(i) != ' ') {
                lettersNum++;
            }
        }
        hintLabel.setText("<html>This part starts with the letter '" + firstLetter + "'. It has " + lettersNum + " letters. </html>");
        
        game_panel.revalidate();
        game_panel.repaint();
        review_panel.revalidate();
        review_panel.repaint();
        hint_panel.revalidate();
        hint_panel.repaint();
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
            			Map<String, String> difficultDictionary = dictionary.getDifficultDictionary();
            			generatePart(difficultDictionary);
            	}
            }
            
            else {
            	switch (topic) {
	            	case "cardiovascular":
	        			Map<String, String> firstTopic = dictionary.getFirstTopic();
	                    generatePart(firstTopic);
	                    break;
	        		case "digestive":
	        			Map<String, String> secondTopic = dictionary.getSecondTopic();
	                    generatePart(secondTopic);
	                    break;
	        		case "endocrine":
	        			Map<String, String> thirdTopic = dictionary.getThirdTopic();
	                    generatePart(thirdTopic);
	                    break;
	        		case "excretory":
	        			Map<String, String> fourthTopic = dictionary.getFourthTopic();
	                    generatePart(fourthTopic);
	                    break;
	        		case "immune":
	        			Map<String, String> fifthTopic = dictionary.getFifthTopic();
	                    generatePart(fifthTopic);
	                    break;
	        		case "integumentary":
	        			Map<String, String> sixthTopic = dictionary.getSixthTopic();
	                    generatePart(sixthTopic);
	                    break;
	        		case "nervous":
	        			Map<String, String> seventhTopic = dictionary.getSeventhTopic();
	                    generatePart(seventhTopic);
	                    break;
	        		case "reproductive":
	        			Map<String, String> eighthTopic = dictionary.getEighthTopic();
	                    generatePart(eighthTopic);
	                    break;
	        		case "respiratory":
	        			Map<String, String> ninthTopic = dictionary.getNinthTopic();
	                    generatePart(ninthTopic);
	                    break;
	        		case "skeletal":
	        			Map<String, String> tenthTopic = dictionary.getTenthTopic();
	                    generatePart(tenthTopic);
	                    break;
            	}
            }
        } else if (roundNum == 10) {
        	addedCoinLabel.setText("+" + addedCoins);
            game_over_panel.revalidate();
            game_over_panel.repaint();
            PBar.setValue(0);
            roundLabel.setText(Integer.toString(roundNum) + "/" + Integer.toString(maxRound));
            answerInputField.setText("");
            back_panel.setVisible(false);
            game_panel.setVisible(false);
            timer_panel.setVisible(false);
            game_over_panel.setVisible(true);
            hintBtn_panel.setVisible(false);
        }
    }

    static void submitAnswer() {
        String userAnswer = answerInputField.getText();
        
        if (userAnswer.equalsIgnoreCase(correctAnswer) && roundNum == maxRound) {
        	if (difficulty.equals("easy")) {
            	coins += 1;
            	coinLabel.setText(Integer.toString(coins));
            	addedCoins += 1;
                addedCoinLabel.setText("+" + addedCoins);
                game_over_panel.revalidate();
                game_over_panel.repaint();
                hintBtn_panel.setVisible(false);
            	
            	try {
            		File file = new File("assets/coins.txt");
            		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            		writer.write(Integer.toString(coins));
            		writer.close();
            	}
            	catch (Exception ex) {
            		ex.printStackTrace();
            	}
            }
            else if (difficulty.equals("average")) {
            	coins += 2;
            	coinLabel.setText(Integer.toString(coins));
            	addedCoins += 2;
                addedCoinLabel.setText("+" + addedCoins);
                game_over_panel.revalidate();
                game_over_panel.repaint();
            	
            	try {
            		File file = new File("assets/coins.txt");
            		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            		writer.write(Integer.toString(coins));
            		writer.close();
            	}
            	catch (Exception ex) {
            		ex.printStackTrace();
            	}
            }
            else if (difficulty.equals("difficult")) {
            	coins += 3;
            	coinLabel.setText(Integer.toString(coins));
            	addedCoins += 3;
                addedCoinLabel.setText("+" + addedCoins);
                game_over_panel.revalidate();
                game_over_panel.repaint();
            	
            	try {
            		File file = new File("assets/coins.txt");
            		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            		writer.write(Integer.toString(coins));
            		writer.close();
            	}
            	catch (Exception ex) {
            		ex.printStackTrace();
            	}
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
            	totalLabel.setText("<html>Review Complete!</html>"); 
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
                
                if (difficulty.equals("easy")) {
                	coins += 1;
                	coinLabel.setText(Integer.toString(coins));
                	addedCoins += 1;
                    addedCoinLabel.setText("+" + addedCoins);
                    game_over_panel.revalidate();
                    game_over_panel.repaint();
                	
                	try {
                		File file = new File("assets/coins.txt");
                		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                		writer.write(Integer.toString(coins));
                		writer.close();
                	}
                	catch (Exception ex) {
                		ex.printStackTrace();
                	}
                }
                else if (difficulty.equals("average")) {
                	coins += 2;
                	coinLabel.setText(Integer.toString(coins));
                	addedCoins += 2;
                    addedCoinLabel.setText("+" + addedCoins);
                    game_over_panel.revalidate();
                    game_over_panel.repaint();
                	
                	try {
                		File file = new File("assets/coins.txt");
                		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                		writer.write(Integer.toString(coins));
                		writer.close();
                	}
                	catch (Exception ex) {
                		ex.printStackTrace();
                	}
                }
                else if (difficulty.equals("difficult")) {
                	coins += 3;
                	coinLabel.setText(Integer.toString(coins));
                	addedCoins += 3;
                    addedCoinLabel.setText("+" + addedCoins);
                    game_over_panel.revalidate();
                    game_over_panel.repaint();
                	
                	try {
                		File file = new File("assets/coins.txt");
                		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                		writer.write(Integer.toString(coins));
                		writer.close();
                	}
                	catch (Exception ex) {
                		ex.printStackTrace();
                	}
                }
                
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
            			Map<String, String> difficultDictionary = dictionary.getDifficultDictionary();
            			generatePart(difficultDictionary);
            	}
            }
            else {
            	switch (topic) {
	            	case "cardiovascular":
	        			Map<String, String> firstTopic = dictionary.getFirstTopic();
	                    generatePart(firstTopic);
	                    break;
	        		case "digestive":
	        			Map<String, String> secondTopic = dictionary.getSecondTopic();
	                    generatePart(secondTopic);
	                    break;
	        		case "endocrine":
	        			Map<String, String> thirdTopic = dictionary.getThirdTopic();
	                    generatePart(thirdTopic);
	                    break;
	        		case "excretory":
	        			Map<String, String> fourthTopic = dictionary.getFourthTopic();
	                    generatePart(fourthTopic);
	                    break;
	        		case "immune":
	        			Map<String, String> fifthTopic = dictionary.getFifthTopic();
	                    generatePart(fifthTopic);
	                    break;
	        		case "integumentary":
	        			Map<String, String> sixthTopic = dictionary.getSixthTopic();
	                    generatePart(sixthTopic);
	                    break;
	        		case "nervous":
	        			Map<String, String> seventhTopic = dictionary.getSeventhTopic();
	                    generatePart(seventhTopic);
	                    break;
	        		case "reproductive":
	        			Map<String, String> eighthTopic = dictionary.getEighthTopic();
	                    generatePart(eighthTopic);
	                    break;
	        		case "respiratory":
	        			Map<String, String> ninthTopic = dictionary.getNinthTopic();
	                    generatePart(ninthTopic);
	                    break;
	        		case "skeletal":
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
