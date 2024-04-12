package com.BIT5.AnatomyDetective;


import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.awt.event.*;

public class game {

	private static JProgressBar PBar;
    private static JFrame main_frame;
    private static JLabel gameLogoLabel, scoreLabel, roundLabel, imageLabel, totalLabel, chooseModeLabel, chooseTopicLabel, chooseDifficultyLabel;
    private static JTextField answerInputField;
    private static JButton playBtn, submitBtn, skipBtn, tryAgainBtn, menuBtn, backBtn, casualBtn, reviewBtn, htpBtn, easyBtn, averageBtn, difficultBtn, topicBtn;
    private static String correctAnswer; 
    private static JPanel main_panel, mode_panel, topic_panel, difficulty_panel, htp_panel, game_panel, game_over_panel, back_panel, timer_panel;
    private static int score;
    private static int roundNum;
    
    public static void main(String[] args) {
        main_frame = new JFrame("Anatomy Detective v0.0.1");
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setSize(1024, 950);
        main_frame.setResizable(false);
        main_frame.setLocationRelativeTo(null);
        main_frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        Container container = main_frame.getContentPane();
        container.setLayout(null);
        
        score = 0;
        roundNum = 1;
        
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
        gbc4.insets = new Insets(10, 0, 65, 0);
        mode_panel.add(chooseModeLabel, gbc4);
        
        casualBtn = new JButton();
        casualBtn.setIcon(new ImageIcon(".//assets/casual_button.png"));
        casualBtn.setBackground(null);
        casualBtn.setBorder(null);
        casualBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
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
        gbc5.insets = new Insets(10, 0, 65, 0);
        difficulty_panel.add(chooseDifficultyLabel, gbc5);
        
        easyBtn = new JButton();
        easyBtn.setIcon(new ImageIcon(".//assets/easy_button.png"));
        easyBtn.setBackground(null);
        easyBtn.setBorder(null);
        easyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	fill();
            	score = 0;
            	roundNum = 1;
            	scoreLabel.setText(Integer.toString(score));
            	totalLabel.setText("Score: " + Integer.toString(score));
        		roundLabel.setText(Integer.toString(roundNum) + "/10");
        		usedParts.clear();
            	generatePart();

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
            	fill();
            	score = 0;
            	roundNum = 1;
            	scoreLabel.setText(Integer.toString(score));
            	totalLabel.setText("Score: " + Integer.toString(score));
        		roundLabel.setText(Integer.toString(roundNum) + "/10");
        		usedParts.clear();
            	generatePart();
            	
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
            	fill();
            	score = 0;
            	roundNum = 1;
            	scoreLabel.setText(Integer.toString(score));
            	totalLabel.setText("Score: " + Integer.toString(score));
        		roundLabel.setText(Integer.toString(roundNum) + "/10");
        		usedParts.clear();
            	generatePart();
            	
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
        topic_panel.setBounds(250, 35, 500, 700);
        topic_panel.setVisible(false);
        container.add(topic_panel);
        
        chooseTopicLabel = new JLabel("Choose Topic");
        chooseTopicLabel.setForeground(Color.BLACK);
        chooseTopicLabel.setFont(new Font("Arial", Font.PLAIN, 42));
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 0;
        gbc6.gridy = 0;
        gbc6.insets = new Insets(10, 0, 65, 0);
        topic_panel.add(chooseTopicLabel, gbc6);
        
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
            	}
            	else if (game_panel.isVisible() && timer_panel.isVisible()) {
            		game_panel.setVisible(false);
            		timer_panel.setVisible(false);
            		difficulty_panel.setVisible(true);
            		usedParts.clear();
            	}
            }
        });
        back_panel.add(backBtn);
        
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

        generatePart();

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
                // Call submitAnswer method when submit button is clicked
                submitAnswer();
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
                if (roundNum < 10) {
                    fill();
                    roundNum += 1;
                    scoreLabel.setText(Integer.toString(score));
                    totalLabel.setText("Score: " + Integer.toString(score));
                    roundLabel.setText(Integer.toString(roundNum) + "/10");
                    answerInputField.setText("");
                    generatePart();
                } else if (roundNum == 10) {
                    Timer timer = (Timer) timer_panel.getClientProperty("timer");
                    if (timer != null && timer.isRunning()) {
                        timer.stop();
                    }
                    PBar.setValue(0);
                    scoreLabel.setText(Integer.toString(score));
                    totalLabel.setText("Score: " + Integer.toString(score));
                    roundLabel.setText(Integer.toString(roundNum) + "/10");
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
        totalLabel.setFont(new Font("Arial", Font.BOLD, 40));
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
                fill();
                game_over_panel.setVisible(false);
                score = 0;
                roundNum = 1;
                scoreLabel.setText(Integer.toString(score));
                totalLabel.setText("Score: " + Integer.toString(score));
                roundLabel.setText(Integer.toString(roundNum) + "/10");
                usedParts.clear();
                generatePart();
                back_panel.setVisible(true);
                game_panel.setVisible(true);
                timer_panel.setVisible(true);
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
                totalLabel.setText("Score: " + Integer.toString(score));
                roundLabel.setText(Integer.toString(roundNum) + "/10");
                usedParts.clear();
                generatePart();
                main_panel.setVisible(true);
            }
        });
        gbc3.gridx = 0;
        gbc3.gridy = 3;
        game_over_panel.add(menuBtn, gbc3);

        main_frame.setVisible(true);
        
    }

    static Set<String> usedParts = new HashSet<>();

    static void generatePart() {
        AnatomyDetectiveDictionary con = new AnatomyDetectiveDictionary();
        Map<String, String> dictionary = con.accessDictionary();
        
        if (usedParts.size() == dictionary.size()) {
            usedParts.clear();
        }

        Random random = new Random();
        String partName = null;
        
        do {
            partName = (String) dictionary.keySet().toArray()[random.nextInt(dictionary.size())];
        } while (usedParts.contains(partName));

        usedParts.add(partName);

        correctAnswer = partName;
        String imageDir = dictionary.get(partName);

        ImageIcon partImage = createResizedImageIcon(imageDir, 500, 400);

        if (imageLabel != null) {
            game_panel.remove(imageLabel);
        }

        imageLabel = new JLabel(partImage);
        GridBagConstraints gbcImage = new GridBagConstraints();
        gbcImage.gridx = 0;
        gbcImage.gridy = 3;
        game_panel.add(imageLabel, gbcImage);
        game_panel.revalidate();
        game_panel.repaint();
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
            roundLabel.setText(Integer.toString(roundNum) + "/10");
            answerInputField.setText("");
            generatePart();
        } else if (roundNum == 10) {
            PBar.setValue(0);
            roundLabel.setText(Integer.toString(roundNum) + "/10");
            answerInputField.setText("");
            back_panel.setVisible(false);
            game_panel.setVisible(false);
            timer_panel.setVisible(false);
            game_over_panel.setVisible(true);
        }
    }

    static void submitAnswer() {
        String userAnswer = answerInputField.getText();
        if (userAnswer.equalsIgnoreCase(correctAnswer) && roundNum == 10) {
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
            totalLabel.setText("Score: " + Integer.toString(score));
            back_panel.setVisible(false);
            game_panel.setVisible(false);
            timer_panel.setVisible(false);
            game_over_panel.setVisible(true);
            answerInputField.setText("");
            generatePart();
        } else if (userAnswer.equalsIgnoreCase(correctAnswer) && roundNum < 11) {
            fill();
            score += 0;
            roundNum += 1;
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
            scoreLabel.setText(Integer.toString(score));
            totalLabel.setText("Score: " + Integer.toString(score));
            roundLabel.setText(Integer.toString(roundNum) + "/10");
            answerInputField.setText("");
            generatePart();
        } else {
            answerInputField.setText("");
        }
    }
    

}
