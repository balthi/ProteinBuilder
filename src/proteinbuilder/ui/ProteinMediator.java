package proteinbuilder.ui;

import proteinbuilder.AminoAcid;
import proteinbuilder.Protein;

public interface ProteinMediator
{
   /**
   * Appends the selected acid to the acid display's list
   */
   public void listItemSelected(AminoAcid selected);
   
   /**
   * Sets the name field to display the protein's name
   * and the acid display field to display the protein's
   * amino acid chain
   */
   public void listItemSelected(Protein selected);
}