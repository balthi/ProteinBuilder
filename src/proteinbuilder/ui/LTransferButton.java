package proteinbuilder.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class LTransferButton extends JButton implements ActionListener
{
   private static String TEXT = "<-";
   private Mediator mediator;
   
   public LTransferButton(Mediator mediator)
   {
      setText(TEXT);
      addActionListener(this);
      this.mediator = mediator;
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      mediator.transferLeft();
   }
   
}