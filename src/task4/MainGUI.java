package task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private final int ICON_DIMENSION = 80;
    private final String scorePattern = "%s : %s";
    private final String lastScorerPattern = "Last scorer: %s";

    //Panels
    private final JPanel teamPanel = new JPanel(new GridLayout(1, 3, 0, 20));
    private final JPanel lastScorerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JPanel finishPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    //Views
    private final JButton finishButton = new JButton("Finish");
    private final JLabel lastScorer = new JLabel(String.format(lastScorerPattern, ""));
    private final JLabel score = new JLabel(String.format(scorePattern, 0,0));

    //ImageIcons
    private final String iconFirstTeamPath = "D:\\IntellijRepos\\JavaTasks\\src\\task4\\icons\\icon_liverpool.png";
    private final String iconSecondTeamPath = "D:\\IntellijRepos\\JavaTasks\\src\\task4\\icons\\icon_ural.png";

    //Teams
    private Team firstTeam = new Team("Liverpool", new ImageIcon(iconFirstTeamPath)
            .getImage()
            .getScaledInstance(ICON_DIMENSION, ICON_DIMENSION, Image.SCALE_DEFAULT));
    private Team secondTeam = new Team("Ural", new ImageIcon(iconSecondTeamPath)
            .getImage()
            .getScaledInstance(ICON_DIMENSION, ICON_DIMENSION, Image.SCALE_DEFAULT));

    public MainGUI(){
        super("Team Scorer");
        this.setBounds(400, 100, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Get main container
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new GridLayout(3,1));

        //Set up UI for first team
        JPanel firstTeamPanel = new JPanel(new GridLayout(2, 1, 20, 0));


        JLabel firstTeamIconLabel = new JLabel(
                new ImageIcon(firstTeam.getIcon()));
        firstTeamIconLabel.setHorizontalAlignment(JLabel.CENTER);

        JButton firstTeamButton = new JButton(firstTeam.getName());
        firstTeamButton.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        firstTeamButton.setHorizontalAlignment(JButton.CENTER);
        firstTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstTeam.addScore();
                updateUI(firstTeam.getName());
            }
        });

        firstTeamPanel.add(firstTeamIconLabel);
        firstTeamPanel.add(firstTeamButton);

        //Set up UI for second team
        JPanel secondTeamPanel = new JPanel(new GridLayout(2, 1, 20, 0));

        JLabel secondTeamIconLabel = new JLabel(
                new ImageIcon(secondTeam.getIcon()));
        secondTeamIconLabel.setHorizontalAlignment(JLabel.CENTER);

        JButton secondTeamButton = new JButton(secondTeam.getName());
        secondTeamButton.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        secondTeamButton.setHorizontalAlignment(JButton.CENTER);
        secondTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondTeam.addScore();
                updateUI(secondTeam.getName());
            }
        });

        secondTeamPanel.add(secondTeamIconLabel);
        secondTeamPanel.add(secondTeamButton);

        //Set up UI for score
        score.setHorizontalAlignment(JLabel.CENTER);
        score.setFont(new Font("Sans Serif", Font.PLAIN, 40));

        //Add UI to team panel
        teamPanel.add(firstTeamPanel);
        teamPanel.add(score);
        teamPanel.add(secondTeamPanel);

        //UI for last scorer panel
        lastScorer.setFont(new Font("Sans Serif", Font.PLAIN, 40));
        lastScorerPanel.add(lastScorer);

        //UI for Finish panel
        finishButton.setFont(new Font("Sans Serif", Font.PLAIN, 40));
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String winnerName = getWinnerName();
                JOptionPane.showMessageDialog(
                        null,
                        winnerName,
                        "Result",
                        JOptionPane.INFORMATION_MESSAGE
                );
                firstTeam.setScore(0);
                secondTeam.setScore(0);
                updateUI("");
            }
        });
        finishPanel.add(finishButton);

        mainContainer.add(teamPanel);
        mainContainer.add(lastScorerPanel);
        mainContainer.add(finishPanel);

    }

    private void updateUI(String scoringTeamName){
        score.setText(String.format(
                scorePattern,
                firstTeam.getScore(),
                secondTeam.getScore()
        ));

        lastScorer.setText(String.format(
                lastScorerPattern,
                scoringTeamName
        ));
    }

    private String getWinnerName(){
        if (firstTeam.getScore() == secondTeam.getScore()){
            return "Draw";
        }
        else if (firstTeam.getScore() > secondTeam.getScore()){
            return firstTeam.getName();
        }
        else{
            return secondTeam.getName();
        }
    }
}
