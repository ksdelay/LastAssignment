import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class GUIDriver
{
	public static void main(String [] args)
	{
	 warGameGUI frame = new warGameGUI();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     frame.setSize(500,500);
     frame.validate();
     frame.setVisible(true);
	}

}
