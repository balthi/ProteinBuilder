package proteinbuilder.io;

import junit.framework.TestCase;
import proteinbuilder.Protein;
import proteinbuilder.AminoAcid;
import proteinbuilder.config.SessionConfig;

import static proteinbuilder.config.SessionConfig.PROTEIN_FILE_DIRECTORY;
import static proteinbuilder.config.SessionConfig.FORMAT;

public abstract class IO_Test extends TestCase
{
   protected Protein protein;
   protected AminoAcid GLY = AminoAcid.GLYCINE;
   protected AminoAcid LEU = AminoAcid.LEUCINE;
   protected SessionConfig sc;
   protected ProteinWriter pw;
   protected static final String NAME = "test";
   protected static final String FILE = PROTEIN_FILE_DIRECTORY + NAME + ".json";
   
}