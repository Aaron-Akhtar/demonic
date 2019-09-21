package org.thesecretintelligence.demonic.utils;

import javax.swing.JOptionPane;

public class Utils {
	
	public static void alert(String title, String msg, String type) {
		if(type.equalsIgnoreCase("error")) {
			JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
		}else if(type.equalsIgnoreCase("info")){
			JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
		}else if(type.equalsIgnoreCase("yes")) {
			JOptionPane.showMessageDialog(null, msg, title, JOptionPane.YES_OPTION);
		}
	}

}
