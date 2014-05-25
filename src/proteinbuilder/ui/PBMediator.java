package proteinbuilder.ui;

import java.util.List;
import java.lang.NullPointerException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import proteinbuilder.AminoAcid;
import proteinbuilder.DNASequence;
import proteinbuilder.Protein;
import proteinbuilder.ProteinList;
import proteinbuilder.config.SessionConfig;
import proteinbuilder.ui.buttonlistener.ButtonListenerFactory;
import proteinbuilder.ui.listlistener.ListListenerFactory;

import static proteinbuilder.config.SessionConfig.DNA_SEQ;

public class PBMediator extends Mediator implements ProteinMediator
{
   private static final String DELIMITER = ":";
   private static final String AMINO_ACID = "AminoAcid";
   private static final String PROTEIN = "Protein";
   
   private DefaultListModel<Protein> proteinList;
   private Protein displayProtein = new Protein();
   private SessionConfig sc = SessionConfig.getSessionConfig();
   
   //From Mediator
   @Override
   protected void setUpSingleSelection()
   {
      SessionConfig sc = SessionConfig.getSessionConfig();
      ProteinList pList = sc.getProteinsFromFiles();
      proteinList = new DefaultListModel<Protein>();
      for(Protein p : pList)
      {
         proteinList.addElement(p);
      }
      singleSelection = new JList<Protein>(proteinList);
      singleSelection.addListSelectionListener(ListListenerFactory.getListListener(this, PROTEIN));
   }
   
   //From Mediator
   @Override
   protected void setUpMultipleSelection()
   {
      List<AminoAcid> aaList = AminoAcid.getAllAminoAcids();
      DefaultListModel<AminoAcid> dlm = new DefaultListModel<AminoAcid>();
      for(AminoAcid aa : aaList)
      {
         dlm.addElement(aa);
      }
      multipleSelection = new JList<AminoAcid>(dlm);
      multipleSelection.addListSelectionListener(ListListenerFactory.getListListener(this, AMINO_ACID));
   }
   
   //From Mediator
   @Override
   protected void setDisplayOnlyText()
   {
      String text = "";
      for(AminoAcid aa : displayProtein)
      {
         text = text + aa.toString() + DELIMITER;
      }
      displayOnly.setText(text);
   }
   
   //From Mediator
   @Override
   protected void setNameField()
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
   
   //From Mediator
   @Override
   public void ok()
   {
   }
   
   //From Mediator
   @Override
   public void cancel()
   {
   }
   
   //From Mediator
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
         if(name.getText().equals(null) || name.getText().equals(""))
         {
            System.err.println("Please enter a name for the protein.");
         }
         else
         {
            displayProtein.setName(name.getText());
            displayProtein.writeToFile();
            proteinList.addElement(displayProtein.clone());
            displayProtein.setName(null);
            displayProtein.clear();
            setNameField();
            setDisplayOnlyText();
         }
      }
   }
   
   //From Mediator
   @Override
   public void undo()
   {
      if(displayProtein.size() > 0)
      {
         displayProtein.pop();
         setDisplayOnlyText();
      }
   }
   
   //From Mediator   
   @Override
   public void transferLeft()
   {
      String text = editable.getText();
      if(!text.matches(DNA_SEQ))
      {
         System.err.println("Invalid character found.");
         return;
      }
      else
      {
         DNASequence dna = new DNASequence(text);
         Protein newProtein = dna.getProtein();
         displayProtein.setName(null);
         displayProtein.clear();
         for(AminoAcid aa : newProtein)
         {
            displayProtein.add(aa);
            System.err.println("Adding " + aa.toString() + " to displayProtein.");
         }
         setNameField();
         setDisplayOnlyText();
      }
   }
   
   //From Mediator
   @Override
   public void transferRight()
   {
      String text = "";
      for(AminoAcid aa : displayProtein)
      {
         text = text + aa.getCodons().get(0).toString();
      }
      editable.setText(text);
   }  
   
   //From ProteinMediator
   @Override
   public void listItemSelected(AminoAcid selected)
   {
      //TODO: rework so that the same amino acid can be selected twice
      //TODO: rework so that try/catch is not controlling program flow
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
         setDisplayOnlyText();
      }
   }

   //From ProteinMediator
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
      setDisplayOnlyText();
   } 
}