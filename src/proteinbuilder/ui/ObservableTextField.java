package proteinbuilder.ui;

import java.util.Iterator;
import java.util.LinkedList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class ObservableTextField extends JTextField implements KeyListener
{

   public ObservableTextField(TextFieldObserver tfo)
   {
      numChars = 0;
      valid = Valid.FALSE;
      observers = new LinkedList();
      observers.add(tfo);
      addKeyListener(this);
      notifyObservers();
   }
   
   private int numChars;
   private Valid valid;
   private LinkedList<TextFieldObserver> observers;
   
   /* 
   * The following methods are required to
   * implement the KeyListener interface
   */
   @Override
   public void keyPressed(KeyEvent e)
   {
      //Do nothing
   }
   
   @Override
   public void keyReleased(KeyEvent e)
   {
      //Do nothing
   }
   
   @Override
   public void keyTyped(KeyEvent e)
   {
      String text = this.getText();
      if(text.length() == 0)
      {
         setChanged(Valid.FALSE);
         notifyObservers();
      }
      else
      {
         setChanged(Valid.TRUE);
         notifyObservers();
      }
   }
   
   /**
   * Notify all observers of the state of this text field
   */
   public void notifyObservers()
   {
      Iterator<TextFieldObserver> iterator = observers.iterator();
      while(iterator.hasNext())
      {
         iterator.next().update(this, valid);
      }
   }
   
   public void setChanged(Valid changed)
   {
      valid = changed;
      notifyObservers();
   }
   
   /**
   * Returns true if the input in this text field is not null
   */
   public Valid isInputValid()
   {
      return valid;
   }
   
   /**
   * Add a new observer for this text field
   */
   public void addObserver(TextFieldObserver tfo)
   {
      observers.add(tfo);
   }
}