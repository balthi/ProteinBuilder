package proteinbuilder.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class SaveButton extends JButton implements ActionListener
{
   private static String SAVE = "Save";
   private Mediator mediator;
   
   public SaveButton(Mediator mediator)
   {
      setText(SAVE);
      addActionListener(this);
      this.mediator = mediator;
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      mediator.save();
   }
   
}