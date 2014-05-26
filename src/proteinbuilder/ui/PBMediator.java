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
import static proteinbuilder.Protein.DEFAULT_PROTEIN_NAME;

public final class PBMediator extends Mediator implements ProteinMediator
{
   private static final String DELIMITER = ":";
   private static final String AMINO_ACID = "AminoAcid";
   private static final String PROTEIN = "Protein";
   private static final String EMPTY_STRING = "";
   private static final String PROTEIN_SAVED = "Protein already saved.";
   private static final String ILLEGAL_CHARACTER = "DNA sequence may only contain the characters A, C, G, and T";
   
   private DefaultListModel<Protein> proteinList;
   private Protein displayProtein = new Protein();
   private SessionConfig sc = SessionConfig.getSessionConfig();
   private ErrorFrame errorFrame;
   
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
      String text = EMPTY_STRING;
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
      name.setText(displayProtein.getName());
   }
   
   private void setNameField(String s)
   {
      name.setText(s);
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
      if(displayProtein.getName().equals(DEFAULT_PROTEIN_NAME))
      {
         try
         {
            displayProtein.setName(name.getText());
            displayProtein.writeToFile();
            proteinList.addElement(displayProtein.clone());
            displayProtein.resetProteinName();
            displayProtein.clear();
            setNameField(EMPTY_STRING);
            setDisplayOnlyText();
         }
         catch(IllegalArgumentException ile)
         {
            errorFrame = new ErrorFrame(ile.getMessage());
            errorFrame.createAndShowFrame();
         }
      }
      else
      {
         errorFrame = new ErrorFrame(PROTEIN_SAVED);
         errorFrame.createAndShowFrame();
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
      String dnaText = editable.getText();
      if(!dnaText.matches(DNA_SEQ))
      {
         errorFrame = new ErrorFrame(ILLEGAL_CHARACTER);
         errorFrame.createAndShowFrame();
         return;
      }
      else
      {
         DNASequence dna = new DNASequence(dnaText);
         displayProtein = dna.getProtein();
         setNameField(EMPTY_STRING);
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
      if(!displayProtein.getName().equals(DEFAULT_PROTEIN_NAME))
      {
         displayProtein.resetProteinName();
         displayProtein.clear();
         setNameField(EMPTY_STRING);
      }
      displayProtein.add(selected);
      setDisplayOnlyText();
      multipleSelection.clearSelection();
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