package proteinbuilder;

import java.lang.IllegalArgumentException;
import java.util.EnumSet;
import java.util.ArrayList;
import java.util.List;

public enum AminoAcid
{
   ISOLEUCINE("ISOLEUCINE", Codon.ATT, Codon.ATC, Codon.ATA),
   LEUCINE("LEUCINE", Codon.CTT, Codon.CTC, Codon.CTA, Codon.CTG, Codon.TTA, Codon.TTG),
   VALINE("VALINE", Codon.GTT, Codon.GTC, Codon.GTA, Codon.GTG),
   PHENYLALANINE("PHENYLALANINE", Codon.TTT, Codon.TTC),
   METHIONINE("METHIONINE", Codon.ATG),
   CYSTEINE("CYSTEINE", Codon.TGT, Codon.TGC),
   ALANINE("ALANINE", Codon.GCT, Codon.GTC, Codon.GCA, Codon.GCG),
   GLYCINE("GLYCINE", Codon.GGT, Codon.GGC, Codon.GGA, Codon.GGG),
   PROLINE("PROLINE", Codon.CCT, Codon.CCC, Codon.CCA, Codon.CCG),
   THREONINE("THREONINE", Codon.ACT, Codon.ACC, Codon.ACA, Codon.ACG),
   SERINE("SERINE", Codon.TCT, Codon.TCC, Codon.TCA, Codon.TCG, Codon.AGT, Codon.AGC),
   TYROSINE("TYROSINE", Codon.TAT, Codon.TAC),
   TRYPTOPHAN("TRYPTOPHAN", Codon.TGG),
   GLUTAMINE("GLUTAMINE", Codon.CAA, Codon.CAG),
   ASPARAGINE("ASPARAGINE", Codon.AAT, Codon.AAC),
   HISTIDINE("HISTIDINE", Codon.CAT, Codon.CAC),
   GLUTAMIC_ACID("GLUTAMIC ACID", Codon.GAA, Codon.GAG),
   ASPARTIC_ACID("ASPARTIC ACID", Codon.GAT, Codon.GAC),
   LYSINE("LYSINE", Codon.AAA, Codon.AAG),
   ARGININE("ARGININE", Codon.CGT, Codon.CGC, Codon.CGA, Codon.CGG, Codon.AGA, Codon.AGG),
   STOP("STOP", Codon.TAA, Codon.TAG, Codon.TGA);
   
   private AminoAcid(String name, Codon c1)
   {
      this.name = name;
      codons = new ArrayList(1);
      codons.add(c1);
   }
   
   private AminoAcid(String name, Codon c1, Codon c2)
   {  
      this.name = name;
      codons = new ArrayList(2);
      codons.add(c1);
      codons.add(c2);
   }
   
   private AminoAcid(String name, Codon c1, Codon c2, Codon c3)
   {
      this.name = name;
      codons = new ArrayList(3);
      codons.add(c1);
      codons.add(c2);
      codons.add(c3);
   }
   
   private AminoAcid(String name, Codon c1, Codon c2, Codon c3, Codon c4)
   {
      this.name = name;
      codons = new ArrayList(4);
      codons.add(c1);
      codons.add(c2);
      codons.add(c3);
      codons.add(c4);
   }
   
   private AminoAcid(String name, Codon c1, Codon c2, Codon c3, Codon c4, Codon c5, Codon c6)
   {
      this.name = name;
      codons = new ArrayList(6);
      codons.add(c1);
      codons.add(c2);
      codons.add(c3);
      codons.add(c4);
      codons.add(c5);
      codons.add(c6);
   }
   
   private ArrayList<Codon> codons;
   private String name;
   private static final EnumSet<AminoAcid> AMINO_ACIDS = EnumSet.allOf(AminoAcid.class);
   
   /**
   * Returns the name of this amino acid
   */
   public String getName()
   {
      return name;
   }
   
   /**
   * Returns the amino acid represented by name.
   * Throws IllegalArgumentException if the amino
   * acid is not found.
   */
   public static AminoAcid getAminoAcidByName(String name)
   {
      for(AminoAcid aa : AMINO_ACIDS)
      {
         if(aa.getName().equals(name))
         {
            return aa;
         }
      }
      throw new IllegalArgumentException("Amino acid " + name + " not found.");
   }
   
   /**
   * Returns a list of this amino acid's codons
   */
   public List<Codon> getCodons()
   {
      ArrayList<Codon> list = new ArrayList(6);
      for(Codon codon : codons)
      {
         list.add(codon);
      }
      return list;
   }
   
   /**
   * Returns a String representation of this aminoAcid
   */
   @Override
   public String toString()
   {
      return name;
   }
};