package ATM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameL extends JFrame
{
	public static boolean saved;
    /** Creates a new instance of JFrameL */
    public JFrameL(String title) {
        super(title);
        FrameListener listener = new FrameListener();
        addWindowListener(listener);
    }
   private class FrameListener extends WindowAdapter
   {

    public void windowClosing(WindowEvent e) {
           if (Main.saved ==false)
           {
        	   
           
           
		int ret=JOptionPane.showConfirmDialog( null ,"Save file before exitting?");
		if (ret==JOptionPane.CANCEL_OPTION) {
			return; 
		}
		else if (ret==JOptionPane.YES_OPTION) {
			Main.writeFile();
			System.exit(0);
		}
		else if (ret==JOptionPane.NO_OPTION)
		{

			
		
    }
		}
           System.exit(0);
          return; }
    }
   }

