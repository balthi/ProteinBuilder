package proteinbuilder;

import java.lang.IllegalArgumentException;
import java.util.EnumSet;

public enum Codon
{
   TTT("TTT", AminoAcid.PHENYLALANINE),TTC("TTC", AminoAcid.PHENYLALANINE),TTA("TTA", AminoAcid.LEUCINE),TTG("TTG", AminoAcid.LEUCINE),
   CTT("CTT", AminoAcid.LEUCINE),CTC("CTC", AminoAcid.LEUCINE),CTA("CTA", AminoAcid.LEUCINE),CTG("CTG", AminoAcid.LEUCINE),
   ATT("ATT", AminoAcid.ISOLEUCINE),ATC("ATC", AminoAcid.ISOLEUCINE),ATA("ATA", AminoAcid.ISOLEUCINE),ATG("ATG", AminoAcid.METHIONINE),
   GTT("GTT", AminoAcid.VALINE),GTC("GTC", AminoAcid.VALINE),GTA("GTA", AminoAcid.VALINE),GTG("GTG", AminoAcid.VALINE),
   TCT("TCT", AminoAcid.SERINE),TCC("TCC", AminoAcid.SERINE),TCA("TCA", AminoAcid.SERINE),TCG("TCG", AminoAcid.SERINE),
   CCT("CCT", AminoAcid.PROLINE),CCC("CCC", AminoAcid.PROLINE),CCA("CCA", AminoAcid.PROLINE),CCG("CCG", AminoAcid.PROLINE),
   ACT("ACT", AminoAcid.THREONINE),ACC("ACC", AminoAcid.THREONINE),ACA("ACA", AminoAcid.THREONINE),ACG("ACG", AminoAcid.THREONINE),
   GCT("GCT", AminoAcid.ALANINE),GCC("GCC", AminoAcid.ALANINE),GCA("GCA", AminoAcid.ALANINE),GCG("GCG", AminoAcid.ALANINE),
   TAT("TAT", AminoAcid.TYROSINE),TAC("TAC", AminoAcid.TYROSINE),TAA("TAA", AminoAcid.STOP),TAG("TAG", AminoAcid.STOP),
   CAT("CAT", AminoAcid.HISTIDINE),CAC("CAC", AminoAcid.HISTIDINE),CAA("CAA", AminoAcid.GLUTAMINE),CAG("CAG", AminoAcid.GLUTAMINE),
   AAT("AAT", AminoAcid.ASPARAGINE),AAC("AAC", AminoAcid.ASPARAGINE),AAA("AAA", AminoAcid.LYSINE),AAG("AAG", AminoAcid.LYSINE),
   GAT("GAT", AminoAcid.ASPARTIC_ACID),GAC("GAC", AminoAcid.ASPARTIC_ACID),GAA("GAA", AminoAcid.GLUTAMIC_ACID),GAG("GAG", AminoAcid.GLUTAMIC_ACID),
   TGT("TGT", AminoAcid.CYSTEINE),TGC("TGC", AminoAcid.CYSTEINE),TGA("TGA", AminoAcid.STOP),TGG("TGG", AminoAcid.TRYPTOPHAN),
   CGT("CGT", AminoAcid.ARGININE),CGC("CGC", AminoAcid.ARGININE),CGA("CGA", AminoAcid.ARGININE),CGG("CGG", AminoAcid.ARGININE),
   AGT("AGT", AminoAcid.SERINE),AGC("AGC", AminoAcid.SERINE),AGA("AGA", AminoAcid.ARGININE),AGG("AGG", AminoAcid.ARGININE),
   GGT("GGT", AminoAcid.GLYCINE),GGC("GGC", AminoAcid.GLYCINE),GGA("GGA", AminoAcid.GLYCINE),GGG("GGG", AminoAcid.GLYCINE);
   
   private Codon(String name, AminoAcid aminoAcid)
   {
      this.name = name;
      this.aminoAcid = aminoAcid;
   }
   
   private AminoAcid aminoAcid;
   private String name;
   private static final EnumSet<Codon> ALL_CODONS = EnumSet.allOf(Codon.class);
   
   /**
   * Returns this codon's corresponding amino acid
   */
   public AminoAcid getAminoAcid()
   {
      return aminoAcid; 
   }
   
   public String getName()
   {
      return name;
   }
   
   /**
   * Returns the codon represented by this string of letters
   */
   public static Codon parseCodon(String codon)
   {
      String upper = codon.toUpperCase();
      for(Codon c : ALL_CODONS)
      {
         if(upper.equals(c.getName()))
         {
            return c;
         }
      }
      throw new IllegalArgumentException("Codons are three characters and contain only the letters A, C, G and T.");
   }
   
   /**
   * Returns a String representation of this codon
   */
   @Override
   public String toString()
   {
      return name;
   }
   
};