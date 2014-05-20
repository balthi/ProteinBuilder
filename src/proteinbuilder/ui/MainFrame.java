package proteinbuilder.ui;

import java.awt.Dimension;
import javax.swing.JFrame;

public class MainFrame
{  
   private static MainFrame frame;
   private static String FRAME_TITLE = "Protein Builder";
   
   
   private MainFrame()
   {
      //Do nothing
   }
   
   public static MainFrame getMainFrame()
   {
      if(frame == null)
      {
         frame = new MainFrame();
      }
      return frame;
   }
   
   public void createAndShowGUI()
   {
      JFrame frame = new JFrame(FRAME_TITLE);
      frame.setPreferredSize(new Dimension(900, 445));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      ProteinPane contentPane = new ProteinPane();
      contentPane.setOpaque(true); //necessary to view contentPane
      frame.setContentPane(contentPane);
      
      //Display frame
      frame.pack();
      frame.setVisible(true);
   }
}