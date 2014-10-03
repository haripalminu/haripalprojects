/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MovingText;

/**
 *
 * @author Haripal
 */

    import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
 
public class MovingText extends JFrame implements ActionListener{
  JLabel label;
  JLabel label2;
 
  public MovingText()  {
    label = new JLabel( "Hello World,Where there is will there is& nbsp;a way");
    getContentPane().add(label, BorderLayout.NORTH);
     javax.swing.Timer timer = new javax.swing.Timer(100, this);
    timer.start();
  }
   public void actionPerformed(ActionEvent e)  {
    String oldText = label.getText();
    String newText = oldText.substring(1) + oldText.substring(0, 1);
     label.setText( newText );
  }
   public static void main(String[] args)  {
    MovingText frame = new MovingText();
    frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
    frame.setSize(300,100);
    frame.setVisible(true);
  }
}
    

