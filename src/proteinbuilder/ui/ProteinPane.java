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
   private JTextField name;
   private JList proteins, acidList;
   private JTextArea acids, DNA;
   private JButton save, undo, rTrans, lTrans;
   private PBMediator mediator;
   
   private static final int WIDTH = 300;
   private static final int HEIGHT = 150;
   private static final int SHORT = 25;
   
   public ProteinPane()
   {
      mediator = PBMediator.getPBMediator();
      
      //Create elements for the pane
      name = mediator.getNameField();
      name.setMaximumSize(new Dimension(WIDTH, SHORT));
      acids = mediator.getAcids();
      acids.setMinimumSize(new Dimension(WIDTH, HEIGHT));
      proteins = mediator.getProteins();
      proteins.setMinimumSize(new Dimension(WIDTH, HEIGHT-50));
      acidList = mediator.getAcidList();
      acidList.setMinimumSize(new Dimension(HEIGHT, WIDTH));
      DNA = mediator.getDNA();
      DNA.setRows(150);
      DNA.setColumns(300);
      
      save = mediator.getSaveButton();
      undo = mediator.getSaveButton();
      System.out.println(undo.getMinimumSize().toString());
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
            .addComponent(name)
            .addComponent(acids)
            .addComponent(save)
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
            .addComponent(name)
            .addComponent(acids)
            .addComponent(save)
            .addComponent(proteins))
         .addGroup(layout.createParallelGroup()
            .addComponent(rTrans)
            .addComponent(lTrans))
         .addComponent(DNA)
         );
   }
}