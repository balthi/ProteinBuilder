package proteinbuilder;

import java.lang.IllegalArgumentException;
import java.util.EnumSet;

public enum Codon
{
   TTT("TTT"),TTC("TTC"),TTA("TTA"),TTG("TTG"),
   CTT("CTT"),CTC("CTC"),CTA("CTA"),CTG("CTG"),
   ATT("ATT"),ATC("ATC"),ATA("ATA"),ATG("ATG"),
   GTT("GTT"),GTC("GTC"),GTA("GTA"),GTG("GTG"),
   TCT("TCT"),TCC("TCC"),TCA("TCA"),TCG("TCG"),
   CCT("CCT"),CCC("CCC"),CCA("CCA"),CCG("CCG"),
   ACT("ACT"),ACC("ACC"),ACA("ACA"),ACG("ACG"),
   GCT("GCT"),GCC("GCC"),GCA("GCA"),GCG("GCG"),
   TAT("TAT"),TAC("TAC"),TAA("TAA"),TAG("TAG"),
   CAT("CAT"),CAC("CAC"),CAA("CAA"),CAG("CAG"),
   AAT("AAT"),AAC("AAC"),AAA("AAA"),AAG("AAG"),
   GAT("GAT"),GAC("GAC"),GAA("GAA"),GAG("GAG"),
   TGT("TGT"),TGC("TGC"),TGA("TGA"),TGG("TGG"),
   CGT("CGT"),CGC("CGC"),CGA("CGA"),CGG("CGG"),
   AGT("AGT"),AGC("AGC"),AGA("AGA"),AGG("AGG"),
   GGT("GGT"),GGC("GGC"),GGA("GGA"),GGG("GGG");
   
   private Codon(String name)
   {
      this.name = name;
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
   * Returns true if it successfully sets this codon's AminoAcid
   * to aa.
   */
   public boolean setAminoAcid(AminoAcid aminoAcid)
   {
      if(this.aminoAcid == null)
      {
         this.aminoAcid = aminoAcid;
         return true;
      }
      return false;
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