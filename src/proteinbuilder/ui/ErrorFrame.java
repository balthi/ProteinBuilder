package proteinbuilder.ui;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JFrame;

public final class ErrorFrame
{
   public ErrorFrame(String message)
   {
      this.message = message;
   }
   
   private String message;
   private static final String ERROR = "Error";
   
   public void createAndShowFrame()
   {
      JFrame frame = new JFrame(ERROR);
      frame.setPreferredSize(new Dimension(650, 100));
      frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      
      JLabel lMessage = new JLabel(message);
      frame.getContentPane().add(lMessage);
      //frame.getContentPane().setOpaque();
      frame.pack();
      frame.setVisible(true);
   }
}