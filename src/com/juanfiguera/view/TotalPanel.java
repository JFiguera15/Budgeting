package com.juanfiguera.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class TotalPanel extends JPanel {
	
	public static float finalTotalBs;
	public static float finalTotalDollars;
	public static JLabel lblTotalEnBolivares, lblTotalEnDolares;

	/**
	 * Create the panel.
	 */
	public TotalPanel() {
		
		setMaximumSize(new Dimension(500, 2));
		setBorder(new TitledBorder(null, "Total", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		finalTotalBs = 0;
		
		finalTotalDollars = 0;
		
		setLayout(new GridLayout(1, 2, 0, 0));
		this.setPreferredSize(new Dimension(450,100));
		this.setMaximumSize(new Dimension(450,100));
		
		lblTotalEnBolivares = new JLabel("Total en Bolivares:");
		add(lblTotalEnBolivares);
		
		lblTotalEnDolares = new JLabel("Total en Dolares:");
		add(lblTotalEnDolares);

	}
	
	public static void updateFinalTotal() {
		finalTotalBs = MaterialsPanelWb.bsTotal + ServicePanel.serviceTotalBs + HandiWorkPanel.sueldoBs;
		finalTotalDollars = MaterialsPanelWb.dollarTotal + ServicePanel.serviceTotalDollars + HandiWorkPanel.sueldoDolares;
		lblTotalEnBolivares.setText("Total en Bolivares: " + finalTotalBs + " BsS");
		DecimalFormat df = new DecimalFormat("#.##");	
		lblTotalEnDolares.setText("Total en Dolares: " + df.format(finalTotalDollars) + " $");
	}

}
