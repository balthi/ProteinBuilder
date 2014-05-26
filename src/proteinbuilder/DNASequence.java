package proteinbuilder;

import java.util.regex.Pattern;
import java.util.List;
import java.util.LinkedList;

import static proteinbuilder.config.SessionConfig.DNA_SEQ;

public final class DNASequence
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
      return sequence.matches(DNA_SEQ);
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
   public LinkedList<Codon> getCodonSequence()
   {
      String fits = this.trim();
      LinkedList<Codon> list = new LinkedList();
      for(int i=0; i<fits.length(); i += 3)
      {
         list.add(Codon.parseCodon(fits.substring(i, i+3)));
      }
      return list; 
   }
   
   /**
   * Returns the amino acid sequence coded by this
   * DNASequence
   */
   public LinkedList<AminoAcid> getAminoAcids()
   {
      LinkedList<Codon> codons = getCodonSequence();
      LinkedList<AminoAcid> acids = new LinkedList();
      for(Codon c : codons)
      {
         acids.add(c.getAminoAcid());
      }
      return acids;
   }
   
   public Protein getProtein()
   {
      LinkedList<AminoAcid> acids = getAminoAcids();
      Protein protein = new Protein();
      for(AminoAcid aa : acids)
      {
         protein.add(aa);
      }
      return protein;
   }
}