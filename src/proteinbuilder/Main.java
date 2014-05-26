package proteinbuilder;

import proteinbuilder.config.SessionConfig;
import proteinbuilder.ui.MainFrame;

public final class Main
{
   public static void main(String[] args)
   {
      SessionConfig sc = SessionConfig.getSessionConfig();
      sc.loadConfiguration();
      
      MainFrame mf = MainFrame.getMainFrame();
      mf.createAndShowGUI();
   }
}