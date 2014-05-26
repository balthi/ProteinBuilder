package proteinbuilder.ui;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import proteinbuilder.config.SessionConfig;
import proteinbuilder.ui.buttonlistener.ButtonListenerFactory;

public abstract class Mediator
{
   public static final String SAVE = "Save";
   public static final String UNDO = "Undo";
   public static final String TRANSFER_RIGHT = ">>";
   public static final String TRANSFER_LEFT = "<<";
   
   protected JList multipleSelection;
   protected JList singleSelection;
   protected JTextArea displayOnly, editable;
   protected JButton save, undo, tRight, tLeft;
   protected JTextField name;
   
   public Mediator()
   {
      
      //Set up text displays
      displayOnly = new JTextArea();
      displayOnly.setEditable(false);
      editable = new JTextArea();
      editable.setEditable(true);
      name = new JTextField();
      
      //Set up buttons
      save = new JButton(SAVE);
      save.addActionListener(ButtonListenerFactory.getButtonListener(this, save));
      undo = new JButton(UNDO);
      undo.addActionListener(ButtonListenerFactory.getButtonListener(this, undo));
      tRight = new JButton(TRANSFER_RIGHT);
      tRight.addActionListener(ButtonListenerFactory.getButtonListener(this, tRight));
      tLeft = new JButton(TRANSFER_LEFT);
      tLeft.addActionListener(ButtonListenerFactory.getButtonListener(this, tLeft));
      
      //Set up JLists
      setUpSingleSelection();
      setUpMultipleSelection();
   }
   
   /*
   * Abstract method for setting up the single selection JList
   */
   protected abstract void setUpSingleSelection();
   
   /*
   * Abstract method for setting up the multiple selection JList
   */
   protected abstract void setUpMultipleSelection();
   
   /**
   * Returns the JList from which multiple selected items
   * can be displayed simulaneously.
   */
   public final JList getMultipleSelection()
   {
      return multipleSelection;
   }
   
   /**
   * Returns the display only text area
   */
   public final JTextArea getDisplayOnly()
   {
      return displayOnly;
   }
   
   /**
   * Returns the JTextArea that displays editable text
   */
   public final JTextArea getEditable()
   {
      return editable;
   }
   
   /**
   * Returns the JList from which only one element at a time
   * can be displayed
   */
   public final JList getSingleSelection()
   {
      return singleSelection;
   }
   
   /**
   * Returns the JTextField.
   */
   public final JTextField getNameField()
   {
      return name;
   }
   
   /**
   * Returns the JButton with an arrow pointed
   * to the left.
   */
   public final JButton getLeftTransferButton()
   {
      return tLeft;
   }
   
   /**
   * Returns the JButton with an arrow pointed to
   * the right
   */
   public final JButton getRightTransferButton()
   {
      return tRight;
   }
   
   /**
   * Returns the JButton with save printed on it
   */
   public final JButton getSaveButton()
   {
      return save;
   }
   
   /**
   * Returns the JButton with undo printed on it
   */
   public final JButton getUndoButton()
   {
      return undo;
   }
   
   /*
   * Set the text for the display only field
   */
   protected abstract void setDisplayOnlyText();
   
   /*
   * Sets the value of the name field
   */
   protected abstract void setNameField();
   
   /**
   * Determines the behavior of pressing the ok button
   */
   public abstract void ok();
   
   /**
   * Determines the behavior of pressing the cancel button
   */
   public abstract void cancel();
   
   /**
   * Determines the behavior of pressing the save button
   */
   public abstract void save();
   
   /**
   * Determines the behavior of pressing the undo button
   */
   public abstract void undo();
   
   /**
   * Determines the behavior of pressing the transfer right button
   */
   public abstract void transferRight();
   
   /**
   * Determines the behavior of pressing the transfer left button
   */
   public abstract void transferLeft();
}