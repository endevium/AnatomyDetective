package com.BIT5.AnatomyDetective;


import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.awt.event.*;


public class game {
	
	private static Set<String> usedParts = new HashSet<>();
	private static JProgressBar PBar;
    private static JFrame main_frame;
    private static JLabel gameLogoLabel, scoreLabel, roundLabel, imageLabel, totalLabel, chooseModeLabel, chooseTopicLabel, chooseDifficultyLabel, rememberThisLabel, reviewImageLabel, partNameLabel;
    private static JTextField answerInputField;
    private static JButton playBtn, submitBtn, skipBtn, tryAgainBtn, menuBtn, backBtn, casualBtn, reviewBtn, htpBtn, easyBtn, averageBtn, difficultBtn, continueBtn, topicBtn1, topicBtn2, topicBtn3, topicBtn4, topicBtn5, topicBtn6, topicBtn7, topicBtn8, topicBtn9;
    private static String correctAnswer; 
    private static JPanel main_panel, mode_panel, topic_panel, difficulty_panel, htp_panel, game_panel, game_over_panel, back_panel, timer_panel, review_panel;
    private static int score, roundNum, maxRound;
    private static String difficulty, topic;
    private static boolean isReview;
    
    public static void main(String[] args) {
        main_frame = new JFrame("Anatomy Detective v0.0.1");
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
        
        main_panel = new JPanel(new GridBagLayout());
        main_panel.setBackground(Color.LIGHT_GRAY);
        main_panel.setBounds(250, 0, 500, 700);
        container.add(main_panel);
        
        gameLogoLabel = new JLabel();
        gameLogoLabel.setIcon(new ImageIcon(".//assets/anatomy_detective_logo.png"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(30, 0, 20, 0);
        main_panel.add(gameLogoLabel, gbc);
        
        playBtn = new JButton();
        playBtn.setIcon(new ImageIcon(".//assets/play_button.png"));
        playBtn.setBackground(null);
        playBtn.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 2;
        playBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	main_panel.setVisible(false);
            	mode_panel.setVisible(true);
            	back_panel.setVisible(true);
            }
        });
        main_panel.add(playBtn, gbc);
        
        htpBtn = new JButton();
        htpBtn.setIcon(new ImageIcon(".//assets/htp_button.png"));
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
            }
        });
        main_panel.add(htpBtn, gbc);
        
        htp_panel = new JPanel(new GridBagLayout());
        htp_panel.setBackground(Color.LIGHT_GRAY);
        htp_panel.setBounds(250, 35, 500, 700);
        htp_panel.setVisible(false);
        container.add(htp_panel);
        
        mode_panel = new JPanel(new GridBagLayout());
        mode_panel.setBackground(Color.LIGHT_GRAY);
        mode_panel.setBounds(250, 35, 500, 700);
        mode_panel.setVisible(false);
        container.add(mode_panel);
        
        chooseModeLabel = new JLabel("Choose Gamemode");
        chooseModeLabel.setForeground(Color.BLACK);
        chooseModeLabel.setFont(new Font("Arial", Font.PLAIN, 42));
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 0;
        gbc4.insets = new Insets(10, 0, 25, 0);
        mode_panel.add(chooseModeLabel, gbc4);
        
        casualBtn = new JButton();
        casualBtn.setIcon(new ImageIcon(".//assets/casual_button.png"));
        casualBtn.setBackground(null);
        casualBtn.setBorder(null);
        casualBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	maxRound = 10;
            	mode_panel.setVisible(false);
                difficulty_panel.setVisible(true);          
            }
        });
        gbc4.gridx = 0;
        gbc4.gridy = 1;
        mode_panel.add(casualBtn, gbc4);
        
        reviewBtn = new JButton();
        reviewBtn.setIcon(new ImageIcon(".//assets/review_button.png"));
        reviewBtn.setBackground(null);
        reviewBtn.setBorder(null);
        reviewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                topic_panel.setVisible(true);
                mode_panel.setVisible(false);
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
        chooseDifficultyLabel.setFont(new Font("Arial", Font.PLAIN, 42));
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 0;
        gbc5.insets = new Insets(10, 0, 25, 0);
        difficulty_panel.add(chooseDifficultyLabel, gbc5);
        
        
        easyBtn = new JButton();
        easyBtn.setIcon(new ImageIcon(".//assets/easy_button.png"));
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
            }
        });
        gbc5.gridx = 0;
        gbc5.gridy = 1;
        difficulty_panel.add(easyBtn, gbc5);
        
        averageBtn = new JButton();
        averageBtn.setIcon(new ImageIcon(".//assets/average_button.png"));
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
            }
        });
        gbc5.gridx = 0;
        gbc5.gridy = 2;
        difficulty_panel.add(averageBtn, gbc5);
        
        difficultBtn = new JButton();
        difficultBtn.setIcon(new ImageIcon(".//assets/difficult_button.png"));
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
            }
        });
        gbc5.gridx = 0;
        gbc5.gridy = 3;
        difficulty_panel.add(difficultBtn, gbc5);
        
        topic_panel = new JPanel(new GridBagLayout());
        topic_panel.setBackground(Color.LIGHT_GRAY);
        topic_panel.setBounds(110, 75, 800, 700);
        topic_panel.setVisible(false);
        container.add(topic_panel);
        
        chooseTopicLabel = new JLabel("Choose Topic");
        chooseTopicLabel.setForeground(Color.BLACK);
        chooseTopicLabel.setFont(new Font("Arial", Font.PLAIN, 42));
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 1;
        gbc6.gridy = 0;
        gbc6.insets = new Insets(10, 0, 25, 0);
        topic_panel.add(chooseTopicLabel, gbc6);
        
        topicBtn1 = new JButton();
        topicBtn1.setIcon(new ImageIcon(".//assets/placeholder_button.png"));
        topicBtn1.setBackground(null);
        topicBtn1.setBorder(null);
        topicBtn1.addActionListener(new ActionListener() {
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
            }
        });
        gbc6.gridx = 0;
        gbc6.gridy = 1;
        topic_panel.add(topicBtn1, gbc6);
        
        topicBtn2 = new JButton();
        topicBtn2.setIcon(new ImageIcon(".//assets/placeholder_button.png"));
        topicBtn2.setBackground(null);
        topicBtn2.setBorder(null);
        topicBtn2.addActionListener(new ActionListener() {
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
            }
        });
        gbc6.gridx = 1;
        gbc6.gridy = 1;
        topic_panel.add(topicBtn2, gbc6);
        
        topicBtn3 = new JButton();
        topicBtn3.setIcon(new ImageIcon(".//assets/placeholder_button.png"));
        topicBtn3.setBackground(null);
        topicBtn3.setBorder(null);
        topicBtn3.addActionListener(new ActionListener() {
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
            }
        });
        gbc6.gridx = 2;
        gbc6.gridy = 1;
        topic_panel.add(topicBtn3, gbc6);
        
        topicBtn4 = new JButton();
        topicBtn4.setIcon(new ImageIcon(".//assets/placeholder_button.png"));
        topicBtn4.setBackground(null);
        topicBtn4.setBorder(null);
        topicBtn4.addActionListener(new ActionListener() {
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
            }
        });
        gbc6.gridx = 0;
        gbc6.gridy = 2;
        topic_panel.add(topicBtn4, gbc6);
        
        topicBtn5 = new JButton();
        topicBtn5.setIcon(new ImageIcon(".//assets/placeholder_button.png"));
        topicBtn5.setBackground(null);
        topicBtn5.setBorder(null);
        topicBtn5.addActionListener(new ActionListener() {
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
            }
        });
        gbc6.gridx = 1;
        gbc6.gridy = 2;
        topic_panel.add(topicBtn5, gbc6);
        
        topicBtn6 = new JButton();
        topicBtn6.setIcon(new ImageIcon(".//assets/placeholder_button.png"));
        topicBtn6.setBackground(null);
        topicBtn6.setBorder(null);
        topicBtn6.addActionListener(new ActionListener() {
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
            }
        });
        gbc6.gridx = 2;
        gbc6.gridy = 2;
        topic_panel.add(topicBtn6, gbc6);
        
        topicBtn7 = new JButton();
        topicBtn7.setIcon(new ImageIcon(".//assets/placeholder_button.png"));
        topicBtn7.setBackground(null);
        topicBtn7.setBorder(null);
        topicBtn7.addActionListener(new ActionListener() {
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
            }
        });
        gbc6.gridx = 0;
        gbc6.gridy = 3;
        topic_panel.add(topicBtn7, gbc6);
        
        topicBtn8 = new JButton();
        topicBtn8.setIcon(new ImageIcon(".//assets/placeholder_button.png"));
        topicBtn8.setBackground(null);
        topicBtn8.setBorder(null);
        topicBtn8.addActionListener(new ActionListener() {
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
            }
        });
        gbc6.gridx = 1;
        gbc6.gridy = 3;
        topic_panel.add(topicBtn8, gbc6);
        
        topicBtn9 = new JButton();
        topicBtn9.setIcon(new ImageIcon(".//assets/placeholder_button.png"));
        topicBtn9.setBackground(null);
        topicBtn9.setBorder(null);
        topicBtn9.addActionListener(new ActionListener() {
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
            }
        });
        gbc6.gridx = 2;
        gbc6.gridy = 3;
        topic_panel.add(topicBtn9, gbc6);
        
        back_panel = new JPanel();
        back_panel.setBackground(Color.LIGHT_GRAY);
        back_panel.setBounds(14, 35, 30, 30);
        back_panel.setVisible(false);
        container.add(back_panel);
        
        backBtn = new JButton();
        backBtn.setIcon(new ImageIcon(".//assets/back_button.png"));
        backBtn.setBackground(null);
        backBtn.setBorder(null);
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        
        review_panel = new JPanel(new GridBagLayout());
        review_panel.setBackground(Color.LIGHT_GRAY);
        review_panel.setBounds(250, 60, 500, 700);
        review_panel.setVisible(false);
        container.add(review_panel);
        
        rememberThisLabel = new JLabel("Remember this!");
        rememberThisLabel.setFont(new Font("Arial", Font.BOLD, 40));
        rememberThisLabel.setForeground(Color.BLACK);
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 0;
        gbc7.gridy = 0;
        gbc7.insets = new Insets(10, 0, 10, 0);
        review_panel.add(rememberThisLabel, gbc7);
        
        continueBtn = new JButton();
        continueBtn.setIcon(new ImageIcon(".//assets/play_button.png"));
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
            }
        });
        review_panel.add(continueBtn, gbc7);
        
        game_panel = new JPanel(new GridBagLayout());
        game_panel.setBackground(Color.LIGHT_GRAY);
        game_panel.setBounds(250, 60, 500, 700);
        game_panel.setVisible(false);
        container.add(game_panel);

        scoreLabel = new JLabel(Integer.toString(score));
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 40));
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
        roundLabel.setFont(new Font("Arial", Font.PLAIN, 21));
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
        submitBtn.setIcon(new ImageIcon(".//assets/submit_btn.png"));
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
        skipBtn.setIcon(new ImageIcon(".//assets/skip_button.png"));
        skipBtn.setBackground(null);
        skipBtn.setBorder(null);
        skipBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        totalLabel.setFont(new Font("Arial", Font.BOLD, 30));
        totalLabel.setForeground(Color.BLACK);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 0;
        gbc3.insets = new Insets(10, 0, 10, 0);
        game_over_panel.add(totalLabel, gbc3);

        tryAgainBtn = new JButton();
        tryAgainBtn.setIcon(new ImageIcon(".//assets/try_again_button.png"));
        tryAgainBtn.setBackground(null);
        tryAgainBtn.setBorder(null);
        tryAgainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
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
                	}
                }
                back_panel.setVisible(true);
            }
        });
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        game_over_panel.add(tryAgainBtn, gbc3);

        menuBtn = new JButton();
        menuBtn.setIcon(new ImageIcon(".//assets/menu_button.png"));
        menuBtn.setBackground(null);
        menuBtn.setBorder(null);
        menuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        partNameLabel.setFont(new Font("Arial", Font.PLAIN, 27));
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
            final int max_count = 60;

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
            	}
            }
        } else {
            answerInputField.setText("");
        }
    }
    

}
