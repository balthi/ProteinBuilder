package proteinbuilder.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class UndoButton extends JButton implements ActionListener
{
   private static String UNDO = "Undo";
   private Mediator mediator;
   
   public UndoButton(Mediator mediator)
   {
      setText(UNDO);
      addActionListener(this);
      this.mediator = mediator;
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      mediator.undo();
   }
   
}