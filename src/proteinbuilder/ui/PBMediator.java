package proteinbuilder.ui;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import proteinbuilder.AminoAcid;
import proteinbuilder.ProteinSet;

public class PBMediator implements Mediator, TextFieldObserver
{
   private JList acidList, proteins;
   private JTextArea acids, DNA;
   private ObservableTextField name;
   private SaveButton save;
   private UndoButton undo;
   private RTransferButton rTrans;
   private LTransferButton lTrans;
   private ProteinSet proteinSet;
   private static PBMediator pb;
   
   private PBMediator()
   {
      List<AminoAcid> list = AminoAcid.getAllAminoAcids();
      acidList = new JList(list.toArray());
      acids = new JTextArea();
      proteins = new JList();
      DNA = new JTextArea();
      
      name = new ObservableTextField(this);
      save = new SaveButton(this);
      undo = new UndoButton(this);
      rTrans = new RTransferButton(this);
      lTrans = new LTransferButton(this);
   }
   
   public static PBMediator getPBMediator()
   {
      if(pb == null)
      {
         pb = new PBMediator();
      }
      return pb;
   }
   
   /**
   * Returns the JComboBox in which the protein acid
   * list is displayed
   */
   public JList getAcidList()
   {
      return acidList;
   }
   
   /**
   * Returns the JComboBox in which the complete list of 
   * amino acids is displayed.
   */
   public JTextArea getAcids()
   {
      return acids;
   }
   
   /**
   * Returns the JTextArea that displays the DNA string
   */
   public JTextArea getDNA()
   {
      return DNA;
   }
   
   /**
   * Returns the JComboBox in which the list of 
   * saved proteins is displayed.
   */
   public JList getProteins()
   {
      return proteins;
   }
   
   /**
   * Returns the JTextField in which the protein's
   * name is entered.
   */
   public JTextField getNameField()
   {
      return name;
   }
   
   /**
   * Returns the JButton with an arrow pointed
   * to the left.
   */
   public JButton getLeftTransferButton()
   {
      return lTrans;
   }
   
   /**
   * Returns the JButton with an arrow pointed to
   * the right
   */
   public JButton getRightTransferButton()
   {
      return rTrans;
   }
   
   /**
   * Returns the JButton with save printed on it
   */
   public JButton getSaveButton()
   {
      return save;
   }
   
   /**
   * Returns the JButton with undo printed on it
   */
   public JButton getUndoButton()
   {
      return undo;
   }
   
   @Override
   public void ok()
   {
   }
   
   @Override
   public void cancel()
   {
   }
   
   @Override
   public void save()
   {
   }
   
   @Override
   public void transferLeft()
   {
   }
   
   @Override
   public void transferRight()
   {
   }
   
   @Override
   public void undo()
   {
   }
   
   @Override
   public void update(ObservableTextField otf, Valid validInput)
   {
   }   
}