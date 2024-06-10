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

public class MaterialsPanelWb extends JPanel {
	private JTextField txtCantidadprincipal;
	private JTextField txtCantidadforro;
	private JTextField txtCantidadmalla;
	private JTextField txtCantidadcierre;
	private JTextField txtCantidadcintapoly;
	private JTextField txtCantidadelastica;
	private JTextField txtCantidadaguja;
	private JTextField txtCantidadhilo;
	private JTextField txtCantidadslider;
	private JTextField txtCantidadherraje;
	private JTextField txtCantidadadornos;
	private JTextField txtCantidadplacaid;
	private JTextField txtCantidadsublimacion;
	private JTextField txtCantidadvivo;
	private JTextField txtCantidadsesgo;
	private JTextField txtCantidadrelleno;
	private JTextField txtPrecioprincipal;
	private JTextField txtPrecioforro;
	private JTextField txtPreciorelleno;
	private JTextField txtPreciomalla;
	private JTextField txtPreciocierre;
	private JTextField txtPreciocintapoly;
	private JTextField txtPrecioaguja;
	private JTextField txtPreciohilo;
	private JTextField txtPrecioslier;
	private JTextField txtPrecioherrajes;
	private JTextField txtPrecioadornos;
	private JTextField txtPrecioplacaid;
	private JTextField txtPreciosublimacion;
	private JTextField txtPreciovivo;
	private JTextField txtPreciosesgo;
	private JTextField txtPrecioelastica;
	private float[] bsPrices;
	private float[] dollarPrices;
	public static float bsTotal;
	public static float dollarTotal;
	public JLabel lblTotalbs,lblTotaldolares;
	private JTextField txtUsadoprincipal;
	private JTextField txtUsadoforro;
	private JTextField txtUsadorelleno;
	private JTextField txtUsadomalla;
	private JTextField txtUsadocierre;
	private JTextField txtUsadocintapoly;
	private JTextField txtUsadoelastica;
	private JTextField txtUsadoaguja;
	private JTextField txtUsadohilo;
	private JTextField txtUsadoslider;
	private JTextField txtUsadoherrajes;
	private JTextField txtUsadoadornos;
	private JTextField txtUsadoPlacaId;
	private JTextField txtUsadosublimacion;
	private JTextField txtUsadovivo;
	private JTextField txtUsadosesgo;



	/**
	 * Create the panel.
	 */
	public MaterialsPanelWb() {
		
		bsPrices =  new float[16];
		for (int i = 0; i < bsPrices.length; i++) {
			bsPrices[i] = 0;
		}
		dollarPrices =  new float[16];
		for (int i = 0; i < dollarPrices.length; i++) {
			dollarPrices[i] = 0;
		}

		bsTotal = 0;
		dollarTotal = 0;
		setBorder(new TitledBorder(null, "Materiales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 7, 0, 0));

		JLabel lblMateriales = new JLabel("Materiales");
		add(lblMateriales);

		JLabel lblCantidadDelMaterial = new JLabel("Cantidad del Material");
		add(lblCantidadDelMaterial);

		JLabel lblPreciomaterial = new JLabel("Precio del Material");
		add(lblPreciomaterial);
		
		JLabel lblCantidadUsada = new JLabel("Cantidad Usada");
		add(lblCantidadUsada);

		JLabel lblBlank = new JLabel("");
		add(lblBlank);

		JLabel lblPrecioPorCantidad = new JLabel("Precio por cm/unidad");
		add(lblPrecioPorCantidad);

		JLabel lblPrecioEnDolare = new JLabel("Precio en Dolares");
		add(lblPrecioEnDolare);

		JLabel lblTelaprincipal = new JLabel("Tela Principal (cm2)");
		add(lblTelaprincipal);

		txtCantidadprincipal = new JTextField();
		txtCantidadprincipal.setToolTipText("Cantidad de cm2 de tela principal");
		add(txtCantidadprincipal);
		txtCantidadprincipal.setColumns(10);

		txtPrecioprincipal = new JTextField();
		txtPrecioprincipal.setToolTipText("Precio por cm2 de la tela principal");
		add(txtPrecioprincipal);
		txtPrecioprincipal.setColumns(10);
		JLabel lblTotalbsprincipal = new JLabel("0 BsS");
		JLabel lblTotalDoPrincipal = new JLabel("0 $");

		JButton btnCalcularprincipal = new JButton("Calcular");
		btnCalcularprincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[0] = (int) ((Float.parseFloat(txtPrecioprincipal.getText()) / Float.parseFloat(txtCantidadprincipal.getText())) * Float.parseFloat(txtUsadoprincipal.getText()));
					lblTotalbsprincipal.setText(bsPrices[0] + " BsS");
					dollarPrices[0] = (float) bsPrices[0] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotalDoPrincipal.setText( df.format(dollarPrices[0]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadoprincipal = new JTextField();
		add(txtUsadoprincipal);
		txtUsadoprincipal.setColumns(10);
		add(btnCalcularprincipal);

		add(lblTotalbsprincipal);


		add(lblTotalDoPrincipal);

		JLabel lblTelaforro = new JLabel("Tela de Forro (cm2)");
		add(lblTelaforro);

		txtCantidadforro = new JTextField();
		txtCantidadforro.setToolTipText("Cantidad de cm2 de tela de forro");
		add(txtCantidadforro);
		txtCantidadforro.setColumns(10);

		txtPrecioforro = new JTextField();
		txtPrecioforro.setToolTipText("Precio por cm2 de la tela de forro");
		add(txtPrecioforro);
		txtPrecioforro.setColumns(10);
		JLabel lblTotalbsforro = new JLabel("0 BsS");
		JLabel lblTotaldoforro = new JLabel("0 $");

		JButton btnCalcularforro = new JButton("Calcular");
		btnCalcularforro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[1] = (int) ((Float.parseFloat(txtPrecioforro.getText()) / Float.parseFloat(txtCantidadforro.getText())) * Float.parseFloat(txtUsadoforro.getText()));
					lblTotalbsforro.setText(bsPrices[1] + " BsS");
					dollarPrices[1] = (float )bsPrices[1] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldoforro.setText( df.format(dollarPrices[1]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadoforro = new JTextField();
		add(txtUsadoforro);
		txtUsadoforro.setColumns(10);
		add(btnCalcularforro);

		
		add(lblTotalbsforro);

		
		add(lblTotaldoforro);

		JLabel lblTelaDeRelleno = new JLabel("Tela de Relleno (cm2)");
		add(lblTelaDeRelleno);

		txtCantidadrelleno = new JTextField();
		txtCantidadrelleno.setToolTipText("Cantidad de cm2 de tela de relleno");
		add(txtCantidadrelleno);
		txtCantidadrelleno.setColumns(10);

		txtPreciorelleno = new JTextField();
		txtPreciorelleno.setToolTipText("Precio por cm2 de la tela de relleno");
		add(txtPreciorelleno);
		txtPreciorelleno.setColumns(10);
		JLabel lblTotalbsrelleno = new JLabel("0 BsS");
		JLabel lblTotaldorelleno = new JLabel("0 $");

		JButton btnCalcularrelleno = new JButton("Calcular");
		btnCalcularrelleno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[2] = (int) ((Float.parseFloat(txtPreciorelleno.getText()) / Float.parseFloat(txtCantidadrelleno.getText())) * Float.parseFloat(txtUsadorelleno.getText()));;
					lblTotalbsrelleno.setText(bsPrices[2] + " BsS");
					dollarPrices[2] = (float )bsPrices[2] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldorelleno.setText( df.format(dollarPrices[2]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadorelleno = new JTextField();
		add(txtUsadorelleno);
		txtUsadorelleno.setColumns(10);
		add(btnCalcularrelleno);

		
		add(lblTotalbsrelleno);

		
		add(lblTotaldorelleno);

		JLabel lblTelamalla = new JLabel("Tela de Malla (cm2)");
		add(lblTelamalla);

		txtCantidadmalla = new JTextField();
		txtCantidadmalla.setToolTipText("Cantidad de cm2 de tela de malla");
		add(txtCantidadmalla);
		txtCantidadmalla.setColumns(10);

		txtPreciomalla = new JTextField();
		txtPreciomalla.setToolTipText("Precio por cm2 de la tela de malla");
		add(txtPreciomalla);
		txtPreciomalla.setColumns(10);
		JLabel lblTotalbsmalla = new JLabel("0 BsS");
		
		JButton btnCalcularmalla = new JButton("Calcular");
		JLabel lblTotaldomalla = new JLabel("0 $");
		
		btnCalcularmalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[3] = (int) ((Float.parseFloat(txtPreciomalla.getText()) / Float.parseFloat(txtCantidadmalla.getText())) * Float.parseFloat(txtUsadomalla.getText()));
					lblTotalbsmalla.setText(bsPrices[3] + " BsS");
					dollarPrices[3] = (float )bsPrices[3] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldomalla.setText( df.format(dollarPrices[3]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadomalla = new JTextField();
		add(txtUsadomalla);
		txtUsadomalla.setColumns(10);
		add(btnCalcularmalla);

		
		add(lblTotalbsmalla);

		
		add(lblTotaldomalla);

		JLabel lblCierre = new JLabel("Cierre (cm)");
		add(lblCierre);

		txtCantidadcierre = new JTextField();
		txtCantidadcierre.setToolTipText("Cantidad de cm2 de cierres");
		add(txtCantidadcierre);
		txtCantidadcierre.setColumns(10);

		txtPreciocierre = new JTextField();
		txtPreciocierre.setToolTipText("Precio por cm2 de cierre");
		add(txtPreciocierre);
		txtPreciocierre.setColumns(10);

		JLabel lblTotalbscierre = new JLabel("0 BsS");
		JLabel lblTotaldocierre = new JLabel("0 $");
		
		JButton btnCalcularcierre = new JButton("Calcular");
		btnCalcularcierre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[4] = (int) ((Float.parseFloat(txtPreciocierre.getText()) / Float.parseFloat(txtCantidadcierre.getText())) * Float.parseFloat(txtUsadocierre.getText()));
					lblTotalbscierre.setText(bsPrices[4] + " BsS");
					dollarPrices[4] = (float)bsPrices[4] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldocierre.setText( df.format(dollarPrices[4]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadocierre = new JTextField();
		add(txtUsadocierre);
		txtUsadocierre.setColumns(10);
		add(btnCalcularcierre);

		
		add(lblTotalbscierre);

		
		add(lblTotaldocierre);

		JLabel lblCintapoly = new JLabel("Cinta poly (cm)");
		add(lblCintapoly);

		txtCantidadcintapoly = new JTextField();
		txtCantidadcintapoly.setToolTipText("Cantidad de cm cinta poly");
		add(txtCantidadcintapoly);
		txtCantidadcintapoly.setColumns(10);

		txtPreciocintapoly = new JTextField();
		txtPreciocintapoly.setToolTipText("Precio por cm de cinta poly");
		add(txtPreciocintapoly);
		txtPreciocintapoly.setColumns(10);
		
		JLabel lblTotalbscintapoly = new JLabel("0 BsS");
		JLabel lblTotaldocintapoly = new JLabel("0 $");

		JButton btnCalcularcintapoly = new JButton("Calcular");
		btnCalcularcintapoly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[5] = (int) ((Float.parseFloat(txtPreciocintapoly.getText()) / Float.parseFloat(txtCantidadcintapoly.getText())) * Float.parseFloat(txtUsadocintapoly.getText()));
					lblTotalbscintapoly.setText(bsPrices[5] + " BsS");
					dollarPrices[5] = (float)bsPrices[5] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldocintapoly.setText( df.format(dollarPrices[5]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadocintapoly = new JTextField();
		add(txtUsadocintapoly);
		txtUsadocintapoly.setColumns(10);
		add(btnCalcularcintapoly);

		
		add(lblTotalbscintapoly);

		
		add(lblTotaldocintapoly);

		JLabel lblElastica = new JLabel("Elastica (cm)");
		add(lblElastica);

		txtCantidadelastica = new JTextField();
		txtCantidadelastica.setToolTipText("Cantidad de cm2 de elastica");
		add(txtCantidadelastica);
		txtCantidadelastica.setColumns(10);

		txtPrecioelastica = new JTextField();
		txtPrecioelastica.setToolTipText("Precio por cm2 de elastica");
		add(txtPrecioelastica);
		txtPrecioelastica.setColumns(10);
		
		JLabel lblTotalbselastica = new JLabel("0 BsS");
		JLabel lblTotaldoelastica = new JLabel("0 $");

		JButton btnCalcularelastica = new JButton("Calcular");
		btnCalcularelastica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[6] = (int) ((Float.parseFloat(txtPrecioelastica.getText()) / Float.parseFloat(txtCantidadelastica.getText())) * Float.parseFloat(txtUsadoelastica.getText()));
					lblTotalbselastica.setText(bsPrices[6] + " BsS");
					dollarPrices[6] = (float) bsPrices[6] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldoelastica.setText( df.format(dollarPrices[6]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadoelastica = new JTextField();
		add(txtUsadoelastica);
		txtUsadoelastica.setColumns(10);
		add(btnCalcularelastica);


		add(lblTotalbselastica);


		add(lblTotaldoelastica);

		JLabel lblAguja = new JLabel("Aguja (Unid.)");
		add(lblAguja);

		txtCantidadaguja = new JTextField();
		txtCantidadaguja.setToolTipText("Cantidad de agujas");
		add(txtCantidadaguja);
		txtCantidadaguja.setColumns(10);

		txtPrecioaguja = new JTextField();
		txtPrecioaguja.setToolTipText("Precio por aguja");
		add(txtPrecioaguja);
		txtPrecioaguja.setColumns(10);
		
		JLabel lblTotalbsaguja = new JLabel("0 BsS");
		JLabel lblTotaldoaguja = new JLabel("0 $");

		JButton btnCalcularaguja = new JButton("Calcular");
		btnCalcularaguja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[7] = (int) ((Float.parseFloat(txtPrecioaguja.getText()) / Float.parseFloat(txtCantidadaguja.getText())) * Float.parseFloat(txtUsadoaguja.getText()));
					lblTotalbsaguja.setText(bsPrices[7] + " BsS");
					dollarPrices[7] = (float) bsPrices[7] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldoaguja.setText( df.format(dollarPrices[7]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadoaguja = new JTextField();
		add(txtUsadoaguja);
		txtUsadoaguja.setColumns(10);
		add(btnCalcularaguja);

		
		add(lblTotalbsaguja);


		add(lblTotaldoaguja);

		JLabel lblHilo = new JLabel("Hilo (Unid.)");
		add(lblHilo);

		txtCantidadhilo = new JTextField();
		txtCantidadhilo.setToolTipText("Cantidad de hilos");
		add(txtCantidadhilo);
		txtCantidadhilo.setColumns(10);

		txtPreciohilo = new JTextField();
		txtPreciohilo.setToolTipText("Precio por hilo");
		add(txtPreciohilo);
		txtPreciohilo.setColumns(10);
		
		JLabel lblTotalbshilo = new JLabel("0 BsS");
		JLabel lblTotaldohilo = new JLabel("0 $");

		JButton btnCalcularhilo = new JButton("Calcular");
		btnCalcularhilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[8] = (int) ((Float.parseFloat(txtPreciohilo.getText()) / Float.parseFloat(txtCantidadhilo.getText())) * Float.parseFloat(txtUsadohilo.getText()));
					lblTotalbshilo.setText(bsPrices[8] + " BsS");
					dollarPrices[8] = (float) bsPrices[8] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldohilo.setText( df.format(dollarPrices[8]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadohilo = new JTextField();
		add(txtUsadohilo);
		txtUsadohilo.setColumns(10);
		add(btnCalcularhilo);

		
		add(lblTotalbshilo);

		
		add(lblTotaldohilo);

		JLabel lblSlider = new JLabel("Slider (Unid.)");
		add(lblSlider);

		txtCantidadslider = new JTextField();
		txtCantidadslider.setToolTipText("Cantidad de sliders");
		add(txtCantidadslider);
		txtCantidadslider.setColumns(10);

		txtPrecioslier = new JTextField();
		txtPrecioslier.setToolTipText("Precio por slider");
		add(txtPrecioslier);
		txtPrecioslier.setColumns(10);
		
		JLabel lblTotalbsslider = new JLabel("0 BsS");
		JLabel lblTotaldoslider = new JLabel("0 $");

		JButton btnCalcularslider = new JButton("Calcular");
		btnCalcularslider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[9] = (int) ((Float.parseFloat(txtPrecioslier.getText()) / Float.parseFloat(txtCantidadslider.getText())) * Float.parseFloat(txtUsadoslider.getText()));
					lblTotalbsslider.setText(bsPrices[9] + " BsS");
					dollarPrices[9] = (float) bsPrices[9] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldoslider.setText( df.format(dollarPrices[9]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadoslider = new JTextField();
		add(txtUsadoslider);
		txtUsadoslider.setColumns(10);
		add(btnCalcularslider);

		
		add(lblTotalbsslider);

		
		add(lblTotaldoslider);

		JLabel lblHerrajes = new JLabel("Herrajes (Unid.)");
		add(lblHerrajes);

		txtCantidadherraje = new JTextField();
		txtCantidadherraje.setToolTipText("Cantidad de herrajes");
		add(txtCantidadherraje);
		txtCantidadherraje.setColumns(10);

		txtPrecioherrajes = new JTextField();
		txtPrecioherrajes.setToolTipText("Precio por herrajes");
		add(txtPrecioherrajes);
		txtPrecioherrajes.setColumns(10);
		
		JLabel lblTotalbsherrajes = new JLabel("0 BsS");
		JLabel lblTotaldoherrajes = new JLabel("0 $");

		JButton btnCalcularherrajes = new JButton("Calcular");
		btnCalcularherrajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[10] = (int) ((Float.parseFloat(txtPrecioherrajes.getText()) / Float.parseFloat(txtCantidadherraje.getText())) * Float.parseFloat(txtUsadoherrajes.getText()));
					lblTotalbsherrajes.setText(bsPrices[10] + " BsS");
					dollarPrices[10] = (float) bsPrices[10] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldoherrajes.setText( df.format(dollarPrices[10]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadoherrajes = new JTextField();
		add(txtUsadoherrajes);
		txtUsadoherrajes.setColumns(10);
		add(btnCalcularherrajes);

		
		add(lblTotalbsherrajes);

		
		add(lblTotaldoherrajes);

		JLabel lblAdornos = new JLabel("Adornos (Unid.)");
		add(lblAdornos);

		txtCantidadadornos = new JTextField();
		txtCantidadadornos.setToolTipText("Cantidad de adornos");
		add(txtCantidadadornos);
		txtCantidadadornos.setColumns(10);

		txtPrecioadornos = new JTextField();
		txtPrecioadornos.setToolTipText("Precio por adornos");
		add(txtPrecioadornos);
		txtPrecioadornos.setColumns(10);
		
		JLabel lblTotalbsadornos = new JLabel("0 BsS");
		JLabel lblTotaldoadornos = new JLabel("0 $");

		JButton btnCalcularadornos = new JButton("Calcular");
		btnCalcularadornos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[11] = (int) ((Float.parseFloat(txtPrecioadornos.getText()) / Float.parseFloat(txtCantidadadornos.getText())) * Float.parseFloat(txtUsadoadornos.getText()));
					lblTotalbsadornos.setText(bsPrices[11] + " BsS");
					dollarPrices[11] = (float) bsPrices[11] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldoadornos.setText( df.format(dollarPrices[11]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadoadornos = new JTextField();
		add(txtUsadoadornos);
		txtUsadoadornos.setColumns(10);
		add(btnCalcularadornos);

		
		add(lblTotalbsadornos);

		
		add(lblTotaldoadornos);

		JLabel lblPlacaid = new JLabel("Placa Identificadora (Unid.)");
		add(lblPlacaid);

		txtCantidadplacaid = new JTextField();
		txtCantidadplacaid.setToolTipText("Cantidad de placa identificadora");
		add(txtCantidadplacaid);
		txtCantidadplacaid.setColumns(10);

		txtPrecioplacaid = new JTextField();
		txtPrecioplacaid.setToolTipText("Precio por placa identificadora");
		add(txtPrecioplacaid);
		txtPrecioplacaid.setColumns(10);
		
		JLabel lblTotalbsplacaid = new JLabel("0 BsS");
		JLabel lblTotaldoplacaid = new JLabel("0 $");

		JButton btnCalcularplacaid = new JButton("Calcular");
		btnCalcularplacaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[12] = (int) ((Float.parseFloat(txtPrecioplacaid.getText()) / Float.parseFloat(txtCantidadplacaid.getText())) * Float.parseFloat(txtUsadoPlacaId.getText()));
					lblTotalbsplacaid.setText(bsPrices[12] + " BsS");
					dollarPrices[12] = (float) bsPrices[12] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldoplacaid.setText( df.format(dollarPrices[12]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadoPlacaId = new JTextField();
		add(txtUsadoPlacaId);
		txtUsadoPlacaId.setColumns(10);
		add(btnCalcularplacaid);

		
		add(lblTotalbsplacaid);


		add(lblTotaldoplacaid);

		JLabel lblSublimacion = new JLabel("Sublimacion (Unid)");
		add(lblSublimacion);

		txtCantidadsublimacion = new JTextField();
		txtCantidadsublimacion.setToolTipText("Cantidad de sublimacion");
		add(txtCantidadsublimacion);
		txtCantidadsublimacion.setColumns(10);

		txtPreciosublimacion = new JTextField();
		txtPreciosublimacion.setToolTipText("Precio por sublimacion");
		add(txtPreciosublimacion);
		txtPreciosublimacion.setColumns(10);
		
		JLabel lblTotalbssublimacion = new JLabel("0 BsS");
		JLabel lblTotaldosublimacion = new JLabel("0 $");

		JButton btnCalcularsublimacion = new JButton("Calcular");
		btnCalcularsublimacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[13] = (int) ((Float.parseFloat(txtPreciosublimacion.getText()) / Float.parseFloat(txtCantidadsublimacion.getText())) * Float.parseFloat(txtUsadosublimacion.getText()));
					lblTotalbssublimacion.setText(bsPrices[13] + " BsS");
					dollarPrices[13] = (float) bsPrices[13] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldosublimacion.setText( df.format(dollarPrices[13]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadosublimacion = new JTextField();
		add(txtUsadosublimacion);
		txtUsadosublimacion.setColumns(10);
		add(btnCalcularsublimacion);

		
		add(lblTotalbssublimacion);

		
		add(lblTotaldosublimacion);

		JLabel lblVivo = new JLabel("Vivo");
		add(lblVivo);

		txtCantidadvivo = new JTextField();
		txtCantidadvivo.setToolTipText("Cantidad de vivo");
		add(txtCantidadvivo);
		txtCantidadvivo.setColumns(10);

		txtPreciovivo = new JTextField();
		txtPreciovivo.setToolTipText("Precio de vivo");
		add(txtPreciovivo);
		txtPreciovivo.setColumns(10);

		JLabel lblTotalbsvivo = new JLabel("0 BsS");
		JLabel lblTotaldovivo = new JLabel("0 $");
		
		JButton btnCalcularvivo = new JButton("Calcular");
		btnCalcularvivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[14] = (int) ((Float.parseFloat(txtPreciovivo.getText()) / Float.parseFloat(txtCantidadvivo.getText())) * Float.parseFloat(txtUsadovivo.getText()));
					lblTotalbsvivo.setText(bsPrices[14] + " BsS");
					dollarPrices[14] = (float) bsPrices[14] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldovivo.setText( df.format(dollarPrices[14]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadovivo = new JTextField();
		add(txtUsadovivo);
		txtUsadovivo.setColumns(10);
		add(btnCalcularvivo);

		
		add(lblTotalbsvivo);

		
		add(lblTotaldovivo);

		JLabel lblSesgo = new JLabel("Sesgo");
		add(lblSesgo);

		txtCantidadsesgo = new JTextField();
		txtCantidadsesgo.setToolTipText("Cantidad de sesgo");
		add(txtCantidadsesgo);
		txtCantidadsesgo.setColumns(10);

		txtPreciosesgo = new JTextField();
		txtPreciosesgo.setToolTipText("Precio de sesgo");
		add(txtPreciosesgo);
		txtPreciosesgo.setColumns(10);
		
		JLabel lblTotalbssesgo = new JLabel("0 BsS");
		JLabel lblTotaldosesgo = new JLabel("0 $");

		JButton btnCalcularsesgo = new JButton("Calcular");
		btnCalcularsesgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bsPrices[15] = (int) ((Float.parseFloat(txtPrecioaguja.getText()) / Float.parseFloat(txtCantidadaguja.getText())) * Float.parseFloat(txtUsadoaguja.getText()));
					lblTotalbssesgo.setText(bsPrices[15] + " BsS");
					dollarPrices[15] = (float) bsPrices[15] / (float) DollarPanel.dollarRate;
					DecimalFormat df = new DecimalFormat("#.##");					
					lblTotaldosesgo.setText( df.format(dollarPrices[15]) + " $");
					updateBstotal();
					updateDollarTotal();
					TotalPanel.updateFinalTotal();
				} catch (ArithmeticException a) {
					JOptionPane.showMessageDialog(null, "Por favor establezca la tasa de dolares.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor inserte un valor valido.");
				}
			}
		});
		
		txtUsadosesgo = new JTextField();
		add(txtUsadosesgo);
		txtUsadosesgo.setColumns(10);
		add(btnCalcularsesgo);

		
		add(lblTotalbssesgo);

		
		add(lblTotaldosesgo);

		JLabel lblNewLabel_1 = new JLabel("");
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		add(lblNewLabel_3);

		JLabel lblBlank_1 = new JLabel("");
		add(lblBlank_1);

		lblTotalbs = new JLabel("Total en Bolivares:");
		add(lblTotalbs);

		lblTotaldolares = new JLabel("Total en Dolares");
		add(lblTotaldolares);

	}

	public void updateBstotal() {
		bsTotal = 0;
		for (int i = 0; i < bsPrices.length; i++) {
			bsTotal = bsTotal + bsPrices[i];
		}
		lblTotalbs.setText("Total en Bolivares: " + bsTotal + " BsS");
	}

	public void updateDollarTotal() {
		dollarTotal = 0;
		for (int i = 0; i < dollarPrices.length; i++) {
			dollarTotal = dollarTotal + dollarPrices[i];
		}
		DecimalFormat df = new DecimalFormat("#.##");		
		lblTotaldolares.setText("Total en Dolares: " + df.format(dollarTotal) + " $");
	}
}
