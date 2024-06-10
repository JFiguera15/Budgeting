package com.juanfiguera.view;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServicePanel extends JPanel {
	private JTextField txtTiempoelectricidad;
	private JTextField txtTiempoagua;
	private JTextField txtTiempomantmaquina;
	private JTextField txtTiempotransporte;
	private JTextField txtTiempointernettelefono;
	private JTextField txtTiempoalquilerlocal;
	private JTextField txtTiempoalquilermaquinaria;
	private JTextField txtTiempogastosdeenvio;
	private JTextField txtTiempodelivery;
	private JTextField txtCostoelectricidad;
	private JTextField txtCostoagua;
	private JTextField txtCostomantmaquina;
	private JTextField txtCostotransporte;
	private JTextField txtCostointernettelefono;
	private JTextField txtCostoalquilerlocal;
	private JTextField txtCostoalquilermaquinaria;
	private JTextField txtCostogastosdeenvio;
	private JTextField txtCostodelivery;
	private float[] bsPrices;
	private float[] dollarPrices;
	public static float serviceTotalBs;
	public static float serviceTotalDollars;
	public JLabel lblTotalserviciosbs, lblTotalserviciodo;

	/**
	 * Create the panel.
	 */
	public ServicePanel() {
	
		
		bsPrices = new float[9];
		for (int i = 0; i < bsPrices.length; i++) {
			bsPrices[i] = 0;
		}
		
		dollarPrices = new float[9];
		for (int i = 0; i < dollarPrices.length; i++) {
			dollarPrices[i] = 0;
		}
		
		serviceTotalBs = 0;
		serviceTotalDollars = 0;
		
		setBorder(new TitledBorder(null, "Servicios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel lblServicios = new JLabel("Servicios");
		add(lblServicios);
		
		JLabel lblTiempoUsado = new JLabel("Tiempo usado");
		add(lblTiempoUsado);
		
		JLabel lblCosto = new JLabel("Costo");
		add(lblCosto);
		
		JLabel lblNewLabel_3 = new JLabel("");
		add(lblNewLabel_3);
		
		JLabel lblPrecioEnBolivares = new JLabel("Precio en Bolivares");
		add(lblPrecioEnBolivares);
		
		JLabel lblPrecioEnDolares = new JLabel("Precio en Dolares");
		add(lblPrecioEnDolares);
		
		JLabel lblElectricidad = new JLabel("Electricidad");
		add(lblElectricidad);
		
		txtTiempoelectricidad = new JTextField();
		txtTiempoelectricidad.setToolTipText("Tiempo que fue usada la electricidad");
		add(txtTiempoelectricidad);
		txtTiempoelectricidad.setColumns(10);
		
		txtCostoelectricidad = new JTextField();
		txtCostoelectricidad.setToolTipText("Costo por tiempo de electricidad");
		add(txtCostoelectricidad);
		txtCostoelectricidad.setColumns(10);
		
		JLabel lblPreciobselectricidad = new JLabel("0 BsS");
		JLabel lblPreciodoelectricidad = new JLabel("0 $");
		
		JButton btnCalcularelectricidad = new JButton("Calcular");
		btnCalcularelectricidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bsPrices[0] = Float.parseFloat(txtCostoelectricidad.getText());
					bsPrices[0] = bsPrices[0] / 22;
					bsPrices[0] = bsPrices[0] / 8;
					bsPrices[0] = bsPrices[0] * Float.parseFloat(txtTiempoelectricidad.getText());
					lblPreciobselectricidad.setText(bsPrices[0] + " BsS");
					dollarPrices[0] = (float )bsPrices[0] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblPreciodoelectricidad.setText( df.format(dollarPrices[0]) + " $");
					updateBsTotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		add(btnCalcularelectricidad);
		
		
		add(lblPreciobselectricidad);
		
		
		add(lblPreciodoelectricidad);
		
		JLabel lblAgua = new JLabel("Agua");
		add(lblAgua);
		
		txtTiempoagua = new JTextField();
		txtTiempoagua.setToolTipText("Tiempo que fue usada el agua");
		add(txtTiempoagua);
		txtTiempoagua.setColumns(10);
		
		txtCostoagua = new JTextField();
		txtCostoagua.setToolTipText("Costo por tiempo del agua");
		add(txtCostoagua);
		txtCostoagua.setColumns(10);
		
		JLabel lblPreciobsagua = new JLabel("0 BsS");
		JLabel lblPreciodoagua = new JLabel("0 $");
		
		JButton btnCalcularagua = new JButton("Calcular");
		btnCalcularagua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bsPrices[1] = Float.parseFloat(txtCostoagua.getText());
					bsPrices[1] = bsPrices[1] / 22;
					bsPrices[1] = bsPrices[1] / 8;
					bsPrices[1] = bsPrices[1] * Float.parseFloat(txtTiempoagua.getText());
					lblPreciobsagua.setText(bsPrices[1] + " BsS");
					dollarPrices[1] = (float )bsPrices[1] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblPreciodoagua.setText( df.format(dollarPrices[1]) + " $");
					updateBsTotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		add(btnCalcularagua);
		
		
		add(lblPreciobsagua);
		
		
		add(lblPreciodoagua);
		
		JLabel lblMantenimientoDeLa = new JLabel("Mantenimiento de la maquina");
		add(lblMantenimientoDeLa);
		
		txtTiempomantmaquina = new JTextField();
		txtTiempomantmaquina.setToolTipText("Tiempo usado para el mantenimiento de la maquina");
		add(txtTiempomantmaquina);
		txtTiempomantmaquina.setColumns(10);
		
		txtCostomantmaquina = new JTextField();
		txtCostomantmaquina.setToolTipText("Costo por tiempo de mantenimiento de la maquina");
		add(txtCostomantmaquina);
		txtCostomantmaquina.setColumns(10);
		
		JLabel lblPreciobsmantmaquina = new JLabel("0 BsS");
		JLabel lblPreciodomantmaquina = new JLabel("0 $");
		
		JButton btnCalcularmantmaquina = new JButton("Calcular");
		btnCalcularmantmaquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bsPrices[2] = Float.parseFloat(txtCostomantmaquina.getText());
					bsPrices[2] = bsPrices[2] / 22;
					bsPrices[2] = bsPrices[2] / 8;
					bsPrices[2] = bsPrices[2] * Float.parseFloat(txtTiempomantmaquina.getText());
					lblPreciobsmantmaquina.setText(bsPrices[2] + " BsS");
					dollarPrices[2] = (float )bsPrices[2] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblPreciodomantmaquina.setText( df.format(dollarPrices[2]) + " $");
					updateBsTotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		add(btnCalcularmantmaquina);
		
		
		add(lblPreciobsmantmaquina);
		
		
		add(lblPreciodomantmaquina);
		
		JLabel lblTransporte = new JLabel("Transporte");
		add(lblTransporte);
		
		txtTiempotransporte = new JTextField();
		txtTiempotransporte.setToolTipText("Tiempo usado en transporte");
		add(txtTiempotransporte);
		txtTiempotransporte.setColumns(10);
		
		txtCostotransporte = new JTextField();
		txtCostotransporte.setToolTipText("Costo por tiempo de transporte");
		add(txtCostotransporte);
		txtCostotransporte.setColumns(10);
		
		JLabel lblPreciobstransporte = new JLabel("0 BsS");
		JLabel lblPreciodotransporte = new JLabel("0 $");
		
		JButton btnCalculartransporte = new JButton("Calcular");
		btnCalculartransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bsPrices[3] = Float.parseFloat(txtCostotransporte.getText());
					bsPrices[3] = bsPrices[3] / 22;
					bsPrices[3] = bsPrices[3] / 8;
					bsPrices[3] = bsPrices[3] * Float.parseFloat(txtTiempotransporte.getText());
					lblPreciobstransporte.setText(bsPrices[3] + " BsS");
					dollarPrices[3] = (float )bsPrices[3] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblPreciodotransporte.setText( df.format(dollarPrices[3]) + " $");
					updateBsTotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		add(btnCalculartransporte);
		
		
		add(lblPreciobstransporte);
		
		
		add(lblPreciodotransporte);
		
		JLabel lblInternettelefono = new JLabel("Internet/Telefono");
		add(lblInternettelefono);
		
		txtTiempointernettelefono = new JTextField();
		txtTiempointernettelefono.setToolTipText("Tiempo que fue usado el internet y el telefono");
		add(txtTiempointernettelefono);
		txtTiempointernettelefono.setColumns(10);
		
		txtCostointernettelefono = new JTextField();
		txtCostointernettelefono.setToolTipText("Costo por tiempo de internet y telefono");
		add(txtCostointernettelefono);
		txtCostointernettelefono.setColumns(10);
		
		JLabel lblPreciobsinternettelefono = new JLabel("0 BsS");
		JLabel lblPreciodointernettelefono = new JLabel("0 $");
		
		JButton btnCalcularinternettelefono = new JButton("Calcular");
		btnCalcularinternettelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bsPrices[4] = Float.parseFloat(txtCostointernettelefono.getText());
					bsPrices[4] = bsPrices[4] / 22;
					bsPrices[4] = bsPrices[4] / 8;
					bsPrices[4] = bsPrices[4] * Float.parseFloat(txtTiempointernettelefono.getText());
					lblPreciobsinternettelefono.setText(bsPrices[4] + " BsS");
					dollarPrices[4] = (float )bsPrices[4] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblPreciodointernettelefono.setText( df.format(dollarPrices[4]) + " $");
					updateBsTotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		add(btnCalcularinternettelefono);
		
		
		add(lblPreciobsinternettelefono);
		
		
		add(lblPreciodointernettelefono);
		
		JLabel lblAlquilerLocal = new JLabel("Alquiler Local");
		add(lblAlquilerLocal);
		
		txtTiempoalquilerlocal = new JTextField();
		txtTiempoalquilerlocal.setToolTipText("Tiempo por el que fue alquilado el local");
		add(txtTiempoalquilerlocal);
		txtTiempoalquilerlocal.setColumns(10);
		
		txtCostoalquilerlocal = new JTextField();
		txtCostoalquilerlocal.setToolTipText("Costo por tiempo que fue alquilado el local");
		add(txtCostoalquilerlocal);
		txtCostoalquilerlocal.setColumns(10);
		
		JLabel lblPreciobsalquilerlocal = new JLabel("0 BsS");
		JLabel lblPreciodoalquilerlocal = new JLabel("0 $");
		
		JButton btnCalcularalquilerlocal = new JButton("Calcular");
		btnCalcularalquilerlocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bsPrices[5] = Float.parseFloat(txtCostoalquilerlocal.getText());
					bsPrices[5] = bsPrices[5] / 22;
					bsPrices[5] = bsPrices[5] / 8;
					bsPrices[5] = bsPrices[5] * Float.parseFloat(txtTiempoalquilerlocal.getText());
					lblPreciobsalquilerlocal.setText(bsPrices[5] + " BsS");
					dollarPrices[5] = (float )bsPrices[5] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblPreciodoalquilerlocal.setText( df.format(dollarPrices[5]) + " $");
					updateBsTotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		add(btnCalcularalquilerlocal);
		
		
		add(lblPreciobsalquilerlocal);
		
		
		add(lblPreciodoalquilerlocal);
		
		JLabel lblAlquilerDeLa = new JLabel("Alquiler de la maquinaria");
		add(lblAlquilerDeLa);
		
		txtTiempoalquilermaquinaria = new JTextField();
		txtTiempoalquilermaquinaria.setToolTipText("Tiempo por el que fue alquilada la maquina");
		add(txtTiempoalquilermaquinaria);
		txtTiempoalquilermaquinaria.setColumns(10);
		
		txtCostoalquilermaquinaria = new JTextField();
		txtCostoalquilermaquinaria.setToolTipText("Costo por tiempo que fue alquilada la maquina");
		add(txtCostoalquilermaquinaria);
		txtCostoalquilermaquinaria.setColumns(10);
		
		JLabel lblPreciobsalquilermaquina = new JLabel("0 BsS");
		JLabel lblPreciodoalquilermaquina = new JLabel("0 $");
		
		JButton btnCalcularalquilermaquina = new JButton("Calcular");
		btnCalcularalquilermaquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bsPrices[6] = Float.parseFloat(txtCostoalquilermaquinaria.getText());
					bsPrices[6] = bsPrices[6] / 22;
					bsPrices[6] = bsPrices[6] / 8;
					bsPrices[6] = bsPrices[6] * Float.parseFloat(txtTiempoalquilermaquinaria.getText());
					lblPreciobsalquilermaquina.setText(bsPrices[6] + " BsS");
					dollarPrices[6] = (float )bsPrices[6] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblPreciodoalquilermaquina.setText( df.format(dollarPrices[6]) + " $");
					updateBsTotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		add(btnCalcularalquilermaquina);
		
		
		add(lblPreciobsalquilermaquina);
		
		
		add(lblPreciodoalquilermaquina);
		
		JLabel lblGastosDeEnvio = new JLabel("Gastos de envio");
		add(lblGastosDeEnvio);
		
		txtTiempogastosdeenvio = new JTextField();
		txtTiempogastosdeenvio.setToolTipText("Tiempo de envio");
		add(txtTiempogastosdeenvio);
		txtTiempogastosdeenvio.setColumns(10);
		
		txtCostogastosdeenvio = new JTextField();
		txtCostogastosdeenvio.setToolTipText("Costo por tiempo de envio ");
		add(txtCostogastosdeenvio);
		txtCostogastosdeenvio.setColumns(10);
		
		JLabel lblPreciobsenvio = new JLabel("0 BsS");
		JLabel lblPreciodoenvio = new JLabel("0 $");
		
		JButton btnCalculargastosenvio = new JButton("Calcular");
		btnCalculargastosenvio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bsPrices[7] = Float.parseFloat(txtCostogastosdeenvio.getText());
					bsPrices[7] = bsPrices[7] / 22;
					bsPrices[7] = bsPrices[7] / 8;
					bsPrices[7] = bsPrices[7] * Float.parseFloat(txtTiempogastosdeenvio.getText());
					lblPreciobsenvio.setText(bsPrices[7] + " BsS");
					dollarPrices[7] = (float )bsPrices[7] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblPreciodoenvio.setText( df.format(dollarPrices[7]) + " $");
					updateBsTotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		add(btnCalculargastosenvio);
		
		
		add(lblPreciobsenvio);
		
		
		add(lblPreciodoenvio);
		
		
		JLabel lblDelivery = new JLabel("Delivery");
		add(lblDelivery);
		
		txtTiempodelivery = new JTextField();
		txtTiempodelivery.setToolTipText("Tiempo usado en delivery");
		add(txtTiempodelivery);
		txtTiempodelivery.setColumns(10);
		
		txtCostodelivery = new JTextField();
		txtCostodelivery.setToolTipText("Costo por tiempo usado en delivery");
		add(txtCostodelivery);
		txtCostodelivery.setColumns(10);
		
		JLabel lblPreciobsdelivery = new JLabel("0 BsS");
		JLabel lblPreciododelivery = new JLabel("0 $");
		
		JButton btnCalculardelivery = new JButton("Calcular");
		btnCalculardelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bsPrices[8] = Float.parseFloat(txtCostodelivery.getText());
					bsPrices[8] = bsPrices[8] / 22;
					bsPrices[8] = bsPrices[8] / 8;
					bsPrices[8] = bsPrices[8] * Float.parseFloat(txtTiempodelivery.getText());
					lblPreciobsdelivery.setText(bsPrices[8] + " BsS");
					dollarPrices[8] = (float )bsPrices[8] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblPreciododelivery.setText( df.format(dollarPrices[8]) + " $");
					updateBsTotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		add(btnCalculardelivery);
		
		
		add(lblPreciobsdelivery);
		
		
		add(lblPreciododelivery);
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		add(lblNewLabel_5);
		
		lblTotalserviciosbs = new JLabel("Total en Bolivares");
		add(lblTotalserviciosbs);
		
		lblTotalserviciodo = new JLabel("Total En Dolares:");
		add(lblTotalserviciodo);

	}

	private void updateBsTotal() {
		serviceTotalBs = 0;
		for (int i = 0; i < bsPrices.length; i++) {
			serviceTotalBs = serviceTotalBs + bsPrices[i];
		}
		DecimalFormat df = new DecimalFormat("#.##");	
		lblTotalserviciosbs.setText("Total en Bolivares: " + df.format(serviceTotalBs));		
	}
	
	private void updateDollarTotal() {
		serviceTotalDollars = 0;
		for (int i = 0; i < dollarPrices.length; i++) {
			serviceTotalDollars = serviceTotalDollars + dollarPrices[i];
		}
		DecimalFormat df = new DecimalFormat("#.##");		
		lblTotalserviciodo.setText("Total en Dolares: " + df.format(serviceTotalDollars) + " $");
	}
}
