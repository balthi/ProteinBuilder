package proteinbuilder.ui;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public final class ProteinPane extends JPanel
{  
   private JLabel pName;
   private JTextField name;
   private JList singleSelection, multipleSelection;
   private JTextArea displayOnly, editable;
   private JButton save, undo, tRight, tLeft;
   private JScrollPane editableScrollPane, displayOnlyScrollPane, singleSelectionScrollPane;
   private Mediator mediator;
   
   private static final int WIDTH = 300;
   private static final int HEIGHT = 150;
   private static final int SHORT = 25;
   private static final String NAME = "Protein name:";
   
   public ProteinPane()
   {
      mediator = MediatorFactory.getMediator();
      
      //Create elements for the pane
      pName = new JLabel(NAME);
      
      name = mediator.getNameField();
      name.setMaximumSize(new Dimension(WIDTH, SHORT));
      
      displayOnly = mediator.getDisplayOnly();
      displayOnlyScrollPane = new JScrollPane(displayOnly);
      displayOnlyScrollPane.setMinimumSize(new Dimension(WIDTH, HEIGHT));
      displayOnly.setLineWrap(true);
      
      singleSelection = mediator.getSingleSelection();
      singleSelectionScrollPane = new JScrollPane(singleSelection);
      singleSelectionScrollPane.setMinimumSize(new Dimension(WIDTH, HEIGHT-50));
      
      multipleSelection = mediator.getMultipleSelection();
      multipleSelection.setMinimumSize(new Dimension(HEIGHT, WIDTH));
      
      editable = mediator.getEditable();
      editableScrollPane = new JScrollPane(editable);
      editable.setRows(150);
      editable.setColumns(300);
      editable.setLineWrap(true);
      
      save = mediator.getSaveButton();
      save.setMinimumSize(new Dimension(WIDTH/2, 25));
      undo = mediator.getUndoButton();
      undo.setMinimumSize(new Dimension(WIDTH/2, 25));
      tRight = mediator.getRightTransferButton();
      tLeft = mediator.getLeftTransferButton();
      
      //Create layout
      GroupLayout layout = new GroupLayout(this);
      setLayout(layout);
      layout.setAutoCreateGaps(true);
      layout.setAutoCreateContainerGaps(true);
      
      /*Create vertical layout. Each field should get
      * its own row and the buttons go at the bottom.
      */
      layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
         .addComponent(multipleSelection)
         .addGroup(layout.createSequentialGroup()
            .addComponent(pName)
            .addComponent(name)
            .addComponent(displayOnlyScrollPane)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
               .addComponent(save)
               .addComponent(undo))
            .addComponent(singleSelectionScrollPane))
         .addGroup(layout.createSequentialGroup()
            .addComponent(tRight)
            .addComponent(tLeft))
         .addComponent(editableScrollPane)
         );
         
      /*Create horizontal layout. There are two columns, one for 
      * titles to explain the fields, and another for text input
      * fields. One button goes at the bottom of each column
      */
      layout.setHorizontalGroup(layout.createSequentialGroup()
         .addComponent(multipleSelection)
         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pName)
            .addComponent(name)
            .addComponent(displayOnlyScrollPane)
            .addGroup(layout.createSequentialGroup()
               .addComponent(save)
               .addComponent(undo))
            .addComponent(singleSelectionScrollPane))
         .addGroup(layout.createParallelGroup()
            .addComponent(tRight)
            .addComponent(tLeft))
         .addComponent(editableScrollPane)
         );
   }
}