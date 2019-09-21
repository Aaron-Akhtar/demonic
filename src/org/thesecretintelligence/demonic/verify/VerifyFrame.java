package org.thesecretintelligence.demonic.verify;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.thesecretintelligence.demonic.stresser.Stresser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerifyFrame {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblYourApiKey;
	private JLabel lblViaOurDiscord;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerifyFrame window = new VerifyFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VerifyFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ImageIcon icon1 = new ImageIcon(this.getClass().getResource("/icon.png"));
		frame.setResizable(false);
		frame.setIconImage(icon1.getImage());
		frame.setTitle("DemonicStresser - Version 1.0-Beta");
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("/BG-DS.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Font font = new Font("Arial", Font.BOLD, 13);
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id;
				id = textField.getText();
					Verify verify = new Verify();
					if(verify.verify(id)) {
						lblYourApiKey = new JLabel("Success, Redirecting to Stresser!");
						lblYourApiKey.setBounds(129, 159, 398, 14);
						lblYourApiKey.setFont(font);
						frame.getContentPane().add(lblYourApiKey);
						frame.repaint();
						try {
						Thread.sleep(2500);
						}catch (Exception e) {
							frame.dispose();
							Stresser.main();
						}
						frame.dispose();
						Stresser.main();
					}else {
						lblYourApiKey = new JLabel("Your API Key is not valid, please purchase one");
						lblYourApiKey.setBounds(129, 159, 398, 14);
						lblYourApiKey.setFont(font);
						frame.getContentPane().add(lblYourApiKey);
						
						lblViaOurDiscord = new JLabel("via our discord server -> discord.thesecretintelligence.org");
						lblViaOurDiscord.setBounds(100, 172, 450, 14);
						lblViaOurDiscord.setFont(font);
						frame.getContentPane().add(lblViaOurDiscord);
						frame.repaint();
					
				}
				
				
			}
		});
		
		textField.setBounds(243, 129, 169, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter Your API Key ->");
		lblPleaseEnterYour.setFont(font);
		lblPleaseEnterYour.setBounds(30, 131, 222, 14);
		frame.getContentPane().add(lblPleaseEnterYour);
		
	}
}
