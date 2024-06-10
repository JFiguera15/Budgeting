package com.juanfiguera.view;

import com.juanfiguera.main.Main;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Window extends JFrame implements ActionListener {
	
	protected DollarPanel dollarPanel;
	protected SquareCmPanel squareCmPanel;
	protected MaterialsPanelWb materialsPanelWb;
	protected ServicePanel servicePanel;
	protected HandiWorkPanel handiWorkPanel;
	protected TotalPanel totalPanel;
	
	public Window(Main main) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JScrollPane scrPane = new JScrollPane(panel);
		this.add(scrPane);
		this.setTitle("El mejor programa para calcular presupuestos de bolsos");
		this.setSize(1100, 720);
		this.setLayout(new GridLayout(1, 1));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		dollarPanel = new DollarPanel();
		panel.add(dollarPanel);
		squareCmPanel = new SquareCmPanel();
		panel.add(squareCmPanel);
		materialsPanelWb = new MaterialsPanelWb();
		panel.add(materialsPanelWb);
		servicePanel = new ServicePanel();
		panel.add(servicePanel);
		handiWorkPanel = new HandiWorkPanel();
		panel.add(handiWorkPanel);
		totalPanel = new TotalPanel();
		panel.add(totalPanel);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
