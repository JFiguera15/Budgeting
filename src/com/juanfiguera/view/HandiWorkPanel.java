package com.juanfiguera.view;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class HandiWorkPanel extends JPanel {
	private JTextField txtSueldo;
	
	public static float sueldoBs;
	public static float sueldoDolares;
	private JTextField txtHoras;
	private JTextField txtCestaticket;

	/**
	 * Create the panel.
	 */
	public HandiWorkPanel() {
		sueldoBs = 0;
		sueldoDolares = 0;
		setMaximumSize(new Dimension(700, 80));
		setBorder(new TitledBorder(null, "Mano de Obra", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel lblSueldoMinimo = new JLabel("Sueldo Minimo");
		add(lblSueldoMinimo);
		
		JLabel lblHorasUtilizadas = new JLabel("Horas Utilizadas");
		add(lblHorasUtilizadas);
		
		JLabel lblCestaticket = new JLabel("CestaTicket");
		add(lblCestaticket);
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel);
		
		JLabel lblSueldoEnBolivares = new JLabel("Sueldo en Bolivares");
		add(lblSueldoEnBolivares);
		
		JLabel lblSueldoEnDolares = new JLabel("Sueldo en Dolares");
		add(lblSueldoEnDolares);
		
		txtSueldo = new JTextField();
		add(txtSueldo);
		txtSueldo.setColumns(10);
		
		JLabel lblSueldobs = new JLabel("0 BsS");
		JLabel lblSueldodo = new JLabel("0 $");
		txtHoras = new JTextField();
		add(txtHoras);
		txtHoras.setColumns(10);
		
		JButton btnCalcularsueldo = new JButton("Calcular");
		btnCalcularsueldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					sueldoBs = Integer.parseInt(txtSueldo.getText()) + Integer.parseInt(txtCestaticket.getText());
					sueldoBs = sueldoBs / 22;
					sueldoBs = sueldoBs / 8;
					System.out.println(sueldoBs);
					sueldoBs = sueldoBs * Integer.parseInt(txtHoras.getText());
					DecimalFormat df = new DecimalFormat("#.##");	
					lblSueldobs.setText(df.format(sueldoBs) + " BsS");
					sueldoDolares = sueldoBs / DollarPanel.dollarRate;
					lblSueldodo.setText(df.format(sueldoDolares) + " $");
					TotalPanel.updateFinalTotal();
					
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
					ex.printStackTrace();
				}
			}
		});
		
		txtCestaticket = new JTextField();
		add(txtCestaticket);
		txtCestaticket.setColumns(10);
		
		
	
		add(btnCalcularsueldo);
		
		
		add(lblSueldobs);
		
		
		add(lblSueldodo);

	}

}
