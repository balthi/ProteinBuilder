package proteinbuilder.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CancelButton extends JButton implements ActionListener
{
   private static String CANCEL = "Cancel";
   private Mediator mediator;
   
   public CancelButton(Mediator mediator)
   {
      setText(CANCEL);
      addActionListener(this);
      this.mediator = mediator;
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      mediator.cancel();
   }
   
}