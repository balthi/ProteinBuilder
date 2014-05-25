package proteinbuilder;

import java.lang.Comparable;
import java.lang.IllegalArgumentException;
import java.util.EnumSet;
import java.util.ArrayList;
import java.util.List;

public enum AminoAcid
{
   ISOLEUCINE("ISOLEUCINE (I)", Codon.ATT, Codon.ATC, Codon.ATA),
   LEUCINE("LEUCINE (L)", Codon.CTT, Codon.CTC, Codon.CTA, Codon.CTG, Codon.TTA, Codon.TTG),
   VALINE("VALINE (V)", Codon.GTT, Codon.GTC, Codon.GTA, Codon.GTG),
   PHENYLALANINE("PHENYLALANINE (F)", Codon.TTT, Codon.TTC),
   METHIONINE("METHIONINE (M)", Codon.ATG),
   CYSTEINE("CYSTEINE (C)", Codon.TGT, Codon.TGC),
   ALANINE("ALANINE (A)", Codon.GCT, Codon.GTC, Codon.GCA, Codon.GCG),
   GLYCINE("GLYCINE (G)", Codon.GGT, Codon.GGC, Codon.GGA, Codon.GGG),
   PROLINE("PROLINE (P)", Codon.CCT, Codon.CCC, Codon.CCA, Codon.CCG),
   THREONINE("THREONINE (T)", Codon.ACT, Codon.ACC, Codon.ACA, Codon.ACG),
   SERINE("SERINE (S)", Codon.TCT, Codon.TCC, Codon.TCA, Codon.TCG, Codon.AGT, Codon.AGC),
   TYROSINE("TYROSINE (Y)", Codon.TAT, Codon.TAC),
   TRYPTOPHAN("TRYPTOPHAN (W)", Codon.TGG),
   GLUTAMINE("GLUTAMINE (Q)", Codon.CAA, Codon.CAG),
   ASPARAGINE("ASPARAGINE (N)", Codon.AAT, Codon.AAC),
   HISTIDINE("HISTIDINE (H)", Codon.CAT, Codon.CAC),
   GLUTAMIC_ACID("GLUTAMIC ACID (E)", Codon.GAA, Codon.GAG),
   ASPARTIC_ACID("ASPARTIC ACID (D)", Codon.GAT, Codon.GAC),
   LYSINE("LYSINE (K)", Codon.AAA, Codon.AAG),
   ARGININE("ARGININE (R)", Codon.CGT, Codon.CGC, Codon.CGA, Codon.CGG, Codon.AGA, Codon.AGG),
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
   * Returns a list of all the amino acids in
   * this enum
   */
   public static List<AminoAcid> getAllAminoAcids()
   {
      int num = AMINO_ACIDS.size();
      ArrayList list = new ArrayList(num);
      for(AminoAcid aa : AMINO_ACIDS)
      {
         list.add(aa);
      }
      return list;
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