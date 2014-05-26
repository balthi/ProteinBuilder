package proteinbuilder.ui;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import junit.framework.TestCase;
import proteinbuilder.AminoAcid;
import proteinbuilder.Protein;
import proteinbuilder.config.SessionConfig;

import static proteinbuilder.config.SessionConfig.NL;

public final class PBMediator_Test extends TestCase
{
   private JTextField name;
   private JTextArea displayOnly, editable;
   private PBMediator mediator;
   
   private static final AminoAcid GLY = AminoAcid.GLYCINE;
   private static final AminoAcid LEU = AminoAcid.LEUCINE;
   private static final String NAME = "test";
   private static final String EXPECTED_DNA_SEQUENCE = "GGTCTT";
   private static final String EMPTY_STRING = "";
   
   public void setUp()
   {
      SessionConfig sc = SessionConfig.getSessionConfig();
      sc.loadConfiguration();
      mediator = new PBMediator();
      name = mediator.getNameField();
      displayOnly = mediator.getDisplayOnly();
      editable = mediator.getEditable();
   }
   
   public void testSave()
   {
      mediator.listItemSelected(GLY);
      mediator.listItemSelected(LEU);
      name.setText(NAME);
      mediator.save();
      assertTrue("Text found in name field after save"
                  + "FOUND" + NL
                  + name.getText(), name.getText().equals(EMPTY_STRING));
      assertTrue("Text found in display only field after save", displayOnly.getText().equals(EMPTY_STRING));
   }
   
   public void testUndo()
   {
      mediator.listItemSelected(GLY);
      mediator.listItemSelected(LEU);
      name.setText(NAME);
      mediator.undo();
      assertTrue("LEUCINE found in displayOnly after undo", displayOnly.getText().equals(AminoAcid.GLYCINE.toString() + ":"));
   }
   
   public void testTransferRight()
   {
      mediator.listItemSelected(GLY);
      mediator.listItemSelected(LEU);
      name.setText(NAME);
      mediator.transferRight();
      assertTrue("Wrong DNA sequence found in editable in testTransferRight"
                  + "EXPECTED " + NL + EXPECTED_DNA_SEQUENCE + NL
                  + "FOUND " + NL + editable.getText(), editable.getText().equals(EXPECTED_DNA_SEQUENCE));
   }
   
   public void testTransferLeft()
   {
      editable.setText(EXPECTED_DNA_SEQUENCE);
      mediator.transferLeft();
      assertTrue("Wrong text found in displayOnly on testTransferLeft", displayOnly.getText().equals(
                                                                                                GLY.toString() + ":" +
                                                                                                LEU.toString() + ":"));
   }
   
   public void testListItemSelectedAminoAcid()
   {
   }
   
   public void testListItemSelectedProtein()
   {
   }
}