package proteinbuilder.ui;

import java.util.List;
import java.lang.NullPointerException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import proteinbuilder.AminoAcid;
import proteinbuilder.Protein;
import proteinbuilder.ProteinList;
import proteinbuilder.config.SessionConfig;
import proteinbuilder.ui.buttonlistener.ButtonListenerFactory;
import proteinbuilder.ui.listlistener.ListListenerFactory;

public class PBMediator extends Mediator implements ProteinMediator
{
   private static final String DELIMITER = ":";
   
   private JList<AminoAcid> acidList;
   private JList<Protein> proteins;
   private JTextArea acids, DNA;
   private JButton save, undo, tRight, tLeft;
   private JTextField name;
   private ProteinList proteinList;
   private Protein displayProtein;
   private DefaultListModel<AminoAcid> aaList = new DefaultListModel();
   private SessionConfig sc = SessionConfig.getSessionConfig();
   private static PBMediator pb;
   
   private PBMediator()
   {
      displayProtein = new Protein();
      
      //Set up AminoAcid and Protein ListModels
      List<AminoAcid> list = AminoAcid.getAllAminoAcids();
      for(AminoAcid aa : list)
      {
         aaList.addElement(aa);
      }
      proteinList = sc.getProteinsFromFiles();
            
      //Set up display areas
      acidList = new JList(aaList);
      acidList.addListSelectionListener(ListListenerFactory.getListListener(this, acidList));
      
      proteins = new JList(proteinList);
      proteins.addListSelectionListener(ListListenerFactory.getListListener(this, proteins));
      
      acids = new JTextArea();
      acids.setEditable(false);
      
      DNA = new JTextArea();
      DNA.setEditable(true);
      
      
      //Set up observables and objects that communicate
      //to the mediator
      name = new JTextField();
      save = new JButton(SAVE);
      save.addActionListener(ButtonListenerFactory.getButtonListener(this, save));
      undo = new JButton(UNDO);
      undo.addActionListener(ButtonListenerFactory.getButtonListener(this, undo));
      tRight = new JButton(TRANSFER_RIGHT);
      tRight.addActionListener(ButtonListenerFactory.getButtonListener(this, tRight));
      tLeft = new JButton(TRANSFER_LEFT);
      tLeft.addActionListener(ButtonListenerFactory.getButtonListener(this, tLeft));
   }
   
   /**
   * Returns a reference to this PBMediator
   */
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
      return tLeft;
   }
   
   /**
   * Returns the JButton with an arrow pointed to
   * the right
   */
   public JButton getRightTransferButton()
   {
      return tRight;
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
   
   /**
   * Clears all amino acids from the display pane
   */
   public void clearAminoAcids()
   {
      displayProtein.clear();
      setAcidsText();
   }
   
   /*
   * Set the text for the acids display field
   */
   private void setAcidsText()
   {
      String text = "";
      for(AminoAcid aa : displayProtein)
      {
         text = text + aa.toString() + DELIMITER;
      }
      acids.setText(text);
   }
   
   /*
   * Sets the value of the name field to displayProtein's name
   */
   private void setNameField()
   {  
      try
      {
         name.setText(displayProtein.getName());
      }
      catch(NullPointerException npe)
      {
         name.setText(null);
      }
   }

   
   /*
   * The following two methods are from the 
   * ProteinMediator interface
   */
   @Override
   public void listItemSelected(AminoAcid selected)
   {
      //TODO: rework so that the same amino acid can be selected twice
      try
      {
         displayProtein.getName();
         displayProtein.setName(null);
         displayProtein.clear();
         setNameField();
      }
      catch(NullPointerException npe)
      {
         System.err.println("No protein selected.");
      }
      finally
      {
         displayProtein.add(selected);
         setAcidsText();
      }
   }

   @Override   
   public void listItemSelected(Protein selected)
   {
      displayProtein.clear();
      displayProtein.setName(selected.getName());
      for(AminoAcid aa : selected)
      {
         displayProtein.add(aa);
      }
      setNameField();
      setAcidsText();
   }
   
   /*
   * The following four methods are implementations
   * of those found in the Mediator interface
   */
   
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
      try
      {
         displayProtein.getName();
         System.err.println("displayProtein has a name");
      }
      catch(NullPointerException npe)
      {
         //TODO: make this work. It currently saves nameless proteins
         try
         {
            displayProtein.setName(name.getText());
            System.err.println("Name set to " + name.getText());
            System.err.println("displayProtein name set to " + name.getText());
            displayProtein.writeToFile();
            System.err.println("displayProtein written to file.");
            proteinList.add(displayProtein);
            System.err.println("displayProtein added to list.");
            displayProtein.setName(null);
            System.err.println("displayProtein name reset.");
            displayProtein.clear();
            System.err.println("displayProtein cleared.");
            setNameField();
            setAcidsText();
         }
         catch(NullPointerException ne)
         {
            System.err.println("Please enter a name for this protein.");
         }
      }
   }
   
   @Override
   public void undo()
   {
      if(displayProtein.size() > 0)
      {
         displayProtein.pop();
         setAcidsText();
      }
   }
   
   /*
   * The following two methods are from the TransferMediator
   * interface
   */
   
   @Override
   public void transferLeft()
   {
   }
   
   @Override
   public void transferRight()
   {
      String text = "";
      for(AminoAcid aa : displayProtein)
      {
         text = text + aa.getCodons().get(0).toString();
      }
      DNA.setText(text);
   }   
}