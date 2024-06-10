package com.juanfiguera.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class SquareCmPanel extends JPanel {
	
	protected JTextField height, width;
	protected JLabel explanation, result;
	protected JButton calculate;
	
	
	public SquareCmPanel() {
		
		this.setLayout(new GridLayout(1,6));
		this.setVisible(true);
		this.setBorder(new TitledBorder("Centimetros cuadrados"));
		this.setMinimumSize(new Dimension(750, 200));
		this.setMaximumSize(new Dimension(750, 800));
		height = new JTextField();
		height.setToolTipText("Valor de altura a calcular");
		width = new JTextField();
		width.setToolTipText("Valor de anchura a calcular");
		explanation = new JLabel("Largo (cm) x Ancho (cm): ");
		calculate = new JButton("Calcular");
		calculate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					float resultNumber = Float.parseFloat(height.getText()) * Float.parseFloat(width.getText());
					DecimalFormat df = new DecimalFormat("#.##");
					result.setText( "     " + resultNumber + " cm2");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
				
			}
		});
		result = new JLabel("0");
		result.setText("     " + "0");
		this.add(explanation);
		this.add(height);
		this.add(width);
		this.add(calculate);
		this.add(result);
		
	}
	
	

	

}
