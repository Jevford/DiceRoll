// Represents a display panel for a Craps table

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class DisplayPanel extends JPanel
{
    private JTextField wonText, lostText, pointText, betText, creditText;
    private int wonCount, lostCount, bet, credit;

    // Constructor
    public DisplayPanel()
    {
        super(new GridLayout(3, 2, 10, 0));
        setBorder(new EmptyBorder(0, 0, 5, 0));
        Font displayFont = new Font("Monospaced", Font.BOLD, 16);

        add(new JLabel("    Bet:"));
        betText = new JTextField("0", 5);
        betText.setFont(displayFont);
        betText.setEditable(true);
        betText.setBackground(Color.WHITE);
        add(betText);
        add(new JLabel("    Credit:"));

        creditText = new JTextField("1000", 5);
        creditText.setFont(displayFont);
        creditText.setEditable(false);
        creditText.setBackground(Color.WHITE);
        add(creditText);

        add(new JLabel("    Won:"));
        add(new JLabel("    Lost:"));
        add(new JLabel("    Point:"));
        add(new JLabel(""));



        wonText = new JTextField("  0", 5);
        wonText.setFont(displayFont);
        wonText.setEditable(false);
        wonText.setBackground(Color.WHITE);
        add(wonText);

        lostText = new JTextField("  0", 5);
        lostText.setFont(displayFont);
        lostText.setEditable(false);
        lostText.setBackground(Color.WHITE);
        add(lostText);

        pointText = new JTextField(5);
        pointText.setFont(displayFont);
        pointText.setEditable(false);
        pointText.setBackground(Color.DARK_GRAY);
        add(pointText);
    }
  
    public JTextField getBet()
    {
        return betText;
    }
  
    public JTextField getCredit()
    {
        return creditText;
    }

    // Updates this display, based on the result and
    // "point" in the previous roll
    public void update(int result, int point)
    {
        // Your code goes here
        this.bet = Integer.parseInt(getBet().getText());
        this.credit = Integer.parseInt(getCredit().getText());

        if(result == -1){
            lostCount++;
            credit -= bet;
            betText.setEditable(true);
            creditText.setText(Integer.toString(credit));
            lostText.setText(Integer.toString(lostCount));
            pointText.setText("");
            pointText.setBackground(Color.DARK_GRAY);
        }
        else if(result == 1){
            wonCount++;
            credit += bet;
            betText.setEditable(true);
            creditText.setText(Integer.toString(credit));
            wonText.setText(Integer.toString(wonCount));
            pointText.setText("");
            pointText.setBackground(Color.DARK_GRAY);

        }
        else if(result == 0){
            betText.setEditable(false);
            pointText.setBackground(Color.ORANGE);
            pointText.setText(Integer.toString(point));

        }
        else{
            //Something aint right
        }
  }
}
