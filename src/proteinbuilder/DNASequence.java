package proteinbuilder;

import java.util.regex.Pattern;
import java.util.List;
import java.util.LinkedList;

public class DNASequence
{
   public DNASequence(String sequence)
   {
      if(!isValidSequence(sequence))
      {
         throw new IllegalArgumentException("DNASequence must contain only the letters A, C, G and T.");
      }
      else
      {
         this.sequence = sequence.toUpperCase();
      }
   }
   
   private String sequence;

   private boolean isValidSequence(String sequence)
   {
      return sequence.matches("[acgtACGT]+");
   }
   
   /*
   * Trim this DNASequence so that it contains
   * a number of bases evenly divisible by three
   */
   private String trim()
   {
      int over = sequence.length() % 3;
      return sequence.substring(0, sequence.length()-over);
   }
   
   /**
   * Returns the Codon sequence represented by this 
   * DNASequence
   */
   public List<Codon> getCodonSequence()
   {
      String fits = this.trim();
      LinkedList<Codon> list = new LinkedList();
      for(int i=0; i<fits.length(); i += 3)
      {
         list.add(Codon.parseCodon(fits.substring(i, i+3)));
      }
      return list; 
   }
}