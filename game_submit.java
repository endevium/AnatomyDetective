
import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.awt.event.*;

public class game_submit {

    private static JProgressBar PBar;
    private static JFrame main_frame;
    private static JLabel gameLogoLabel, scoreLabel, roundLabel, imageLabel, totalLabel;
    private static JTextField answerInputField;
    private static JButton playBtn, submitBtn, skipBtn, tryAgainBtn, menuBtn, backBtn;
    private static String correctAnswer; 
    private static JPanel main_panel, game_panel, game_over_panel, back_panel, timer_panel;
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
        gameLogoLabel.setIcon(new ImageIcon("anatomy_detective_logo.png"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(80, 0, 20, 0);
        main_panel.add(gameLogoLabel, gbc);
        
        playBtn = new JButton();
        playBtn.setIcon(new ImageIcon("play_button.png"));
        playBtn.setBackground(null);
        playBtn.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 2;
        playBtn.addActionListener(new ActionListener() {
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
            	
            	main_panel.setVisible(false);
            	game_panel.setVisible(true);
            	back_panel.setVisible(true);
            	timer_panel.setVisible(true);

            }
        });
        main_panel.add(playBtn, gbc);
        
        back_panel = new JPanel();
        back_panel.setBackground(Color.LIGHT_GRAY);
        back_panel.setBounds(14, 25, 30, 30);
        back_panel.setVisible(false);
        container.add(back_panel);
        
        backBtn = new JButton();
        backBtn.setIcon(new ImageIcon("back_button.png"));
        backBtn.setBackground(null);
        backBtn.setBorder(null);
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	game_panel.setVisible(false);
            	back_panel.setVisible(false);
            	timer_panel.setVisible(false);
            	main_panel.setVisible(true);
            	usedParts.clear();
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
        timer_panel.setBounds(0, -6, 1200, 100);
        timer_panel.setVisible(false);
        container.add(timer_panel);
        
        PBar = new JProgressBar();
        PBar.setValue(0);
        PBar.setPreferredSize(new Dimension(1200, 25));
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

        // Add key listener to answerInputField
        answerInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call submitAnswer method when ENTER is pressed
                submitAnswer();
            }
        });

        submitBtn = new JButton();
        submitBtn.setIcon(new ImageIcon("submit_btn.png"));
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
        skipBtn.setIcon(new ImageIcon("skip_button.png"));
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
        tryAgainBtn.setIcon(new ImageIcon("try_again_button.png"));
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
        menuBtn.setIcon(new ImageIcon("menu_button.png"));
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

        timer = new Timer(590, new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                PBar.setValue(count);
                count++;
                if (count > 100) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer_panel.putClientProperty("timer", timer);
        timer.start();
    }

    // Method to submit the answer
    static void submitAnswer() {
        String userAnswer = answerInputField.getText();
        if (userAnswer.equalsIgnoreCase(correctAnswer) && roundNum == 10) {
            score += 100;
            totalLabel.setText("Score: " + Integer.toString(score));
            back_panel.setVisible(false);
            game_panel.setVisible(false);
            timer_panel.setVisible(false);
            game_over_panel.setVisible(true);
            answerInputField.setText("");
            generatePart();
        } else if (userAnswer.equalsIgnoreCase(correctAnswer) && roundNum < 11) {
            fill();
            score += 100;
            roundNum += 1;
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
