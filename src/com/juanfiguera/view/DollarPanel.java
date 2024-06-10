package com.juanfiguera.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class DollarPanel extends JPanel {
	
	protected JLabel text;
	protected JButton button;
	protected JTextField textfield;
	public static int dollarRate;
	
	public DollarPanel() {
		dollarRate = 0;
		text = new JLabel("Tasa actual de dolares: ");
		textfield = new JTextField();
		button = new JButton("Insertar");
		this.setMaximumSize(new Dimension(450,40));
		this.setLayout(new GridLayout(1, 7));
		this.setBorder(new TitledBorder("Configuracion Dolares"));
		this.add(text);
		this.add(textfield);
		this.add(button);
		this.setVisible(true);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					dollarRate = Integer.parseInt(textfield.getText());
					JOptionPane.showMessageDialog(null, "La tasa de dolares usada sera: " + dollarRate + " BsS por dolar");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido");
				}
				
				
			}
		});
	}
	
	

}
