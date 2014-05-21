package proteinbuilder.ui;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ProteinPane extends JPanel
{  
   private JLabel pName;
   private JTextField name;
   private JList proteins, acidList;
   private JTextArea acidDisplay, DNA;
   private JButton save, undo, rTrans, lTrans;
   private PBMediator mediator;
   
   private static final int WIDTH = 300;
   private static final int HEIGHT = 150;
   private static final int SHORT = 25;
   private static final String NAME = "Protein name:";
   
   public ProteinPane()
   {
      mediator = PBMediator.getPBMediator();
      
      //Create elements for the pane
      pName = new JLabel(NAME);
      
      name = mediator.getNameField();
      name.setMaximumSize(new Dimension(WIDTH, SHORT));
      
      acidDisplay = mediator.getAcids();
      acidDisplay.setMinimumSize(new Dimension(WIDTH, HEIGHT));
      acidDisplay.setLineWrap(true);
      
      proteins = mediator.getProteins();
      proteins.setMinimumSize(new Dimension(WIDTH, HEIGHT-50));
      
      acidList = mediator.getAcidList();
      acidList.setMinimumSize(new Dimension(HEIGHT, WIDTH));
      
      DNA = mediator.getDNA();
      DNA.setRows(150);
      DNA.setColumns(300);
      DNA.setLineWrap(true);
      
      save = mediator.getSaveButton();
      save.setMinimumSize(new Dimension(WIDTH/2, 25));
      undo = mediator.getUndoButton();
      undo.setMinimumSize(new Dimension(WIDTH/2, 25));
      rTrans = mediator.getRightTransferButton();
      lTrans = mediator.getLeftTransferButton();
      
      //Create layout
      GroupLayout layout = new GroupLayout(this);
      setLayout(layout);
      layout.setAutoCreateGaps(true);
      layout.setAutoCreateContainerGaps(true);
      
      /*Create vertical layout. Each field should get
      * its own row and the buttons go at the bottom.
      */
      layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
         .addComponent(acidList)
         .addGroup(layout.createSequentialGroup()
            .addComponent(pName)
            .addComponent(name)
            .addComponent(acidDisplay)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
               .addComponent(save)
               .addComponent(undo))
            .addComponent(proteins))
         .addGroup(layout.createSequentialGroup()
            .addComponent(rTrans)
            .addComponent(lTrans))
         .addComponent(DNA)
         );
         
      /*Create horizontal layout. There are two columns, one for 
      * titles to explain the fields, and another for text input
      * fields. One button goes at the bottom of each column
      */
      layout.setHorizontalGroup(layout.createSequentialGroup()
         .addComponent(acidList)
         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pName)
            .addComponent(name)
            .addComponent(acidDisplay)
            .addGroup(layout.createSequentialGroup()
               .addComponent(save)
               .addComponent(undo))
            .addComponent(proteins))
         .addGroup(layout.createParallelGroup()
            .addComponent(rTrans)
            .addComponent(lTrans))
         .addComponent(DNA)
         );
   }
}