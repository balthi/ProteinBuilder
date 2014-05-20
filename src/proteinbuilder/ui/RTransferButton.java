package proteinbuilder.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class RTransferButton extends JButton implements ActionListener
{
   private static String TEXT = "->";
   private Mediator mediator;
   
   public RTransferButton(Mediator mediator)
   {
      setText(TEXT);
      addActionListener(this);
      this.mediator = mediator;
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      mediator.transferRight();
   }
   
}