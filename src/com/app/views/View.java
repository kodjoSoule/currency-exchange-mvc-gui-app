package com.app.views;

import javax.swing.*;
import com.app.models.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JTextField montantAConvertitTextField;
    private JTextField montantConvertitTextField;
    
    //
    private JLabel deviceSelectionFrom;
    private JLabel deviceSelectionTo;
    
    JLabel m_title ;
    String curentDevise ;
    private JButton convertButton;
    private JButton cleanButton;
    
    //
    JPanel contentPanel ;
    
    JLabel montantTo ;
    JLabel montantFrom ;
    JPanel panelTitle ;
    JPanel panelConverterDevices;
    JPanel panelMontantEtrangere ;
    JPanel panelConvertit;
    JPanel panelConvertButton;
    JComboBox<String> comboBoxFrom;
    JComboBox<String> comboBoxTo;
	
   //
   public void setMontantFromLabel(String montantEtrangere) {
	   this.montantFrom.setText(montantEtrangere);
   }
   public void setMontantToLabel(String montantTo) {
	   this.montantTo.setText(montantTo);
   }
  //Aconvertit
    public String getMontantAConvertitTextField() {
    	String montant = montantAConvertitTextField.getText();
    	return montant;
    	//Double.parseDouble(montant);
	}
    //
    public void setSelectedDevise(int index) {
    	comboBoxTo.setSelectedIndex(index);
    }
    public void setMontantAConvertitTextField(double montantAConvertit) {
    	montantConvertitTextField.setText(String.valueOf(montantAConvertit));
    }
    //convertit
    public String getMontantConvertitTextField() {
		String montant = montantConvertitTextField.getText();
    	return montant ;
    	//Double.parseDouble(montant);
	}
    public void setMontantConvertit( double montantConvertit) {
		this.montantConvertitTextField.setText(String.valueOf(montantConvertit));
	}
    
    public void display() {
        setVisible(true);
    }
    //ComboxFrom
    public String getCurentDeviseFrom() {
    	return this.comboBoxFrom.getSelectedItem().toString();
    }
    

    public void setDeviseItemsFromModelFrom(String[] devise) {
    	comboBoxFrom.removeAllItems();
        for (String item : devise) {
            comboBoxFrom.addItem(item);
        }
    }
    //ComboxTo
    
    public String getCurentDeviseTo() {
    	return this.comboBoxTo.getSelectedItem().toString();
    }
    public void setDeviseItemsFromModelTo(String[] devise) {
    	comboBoxTo.removeAllItems();
        for (String item : devise) {
            comboBoxTo.addItem(item);
        }
    }
    //AddListerner
	public void addConvertButtonActionListener(ActionListener listenerConvertButton) {
		convertButton.addActionListener(listenerConvertButton);
	}
	public void addComboxFromActionListener(ActionListener listenerConvertButton) {
		this.comboBoxFrom.addActionListener(listenerConvertButton);
		
	}
	public void addComboxToActionListener(ActionListener listenerConvertButton) {
		this.comboBoxTo.addActionListener(listenerConvertButton);
		
	}
    public View() {
    	
        setTitle("Convertisseur de devises");
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelTitle = new JPanel();
        panelTitle.setBackground(Color.green);
        
        //
        panelConverterDevices = new JPanel();
        panelConverterDevices.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //ComboxFrom
        comboBoxFrom = new JComboBox<>();
        
        
        
        comboBoxFrom.setPreferredSize(new Dimension(150, 30));
        deviceSelectionFrom = new JLabel("Conversion ");
        
        panelConverterDevices.add(deviceSelectionFrom);
        panelConverterDevices.add(comboBoxFrom);
        //
      //ComboxTO
       
        comboBoxTo = new JComboBox<>();
        
        comboBoxTo.setPreferredSize(new Dimension(150, 30));
        deviceSelectionTo = new JLabel("To");
        
        panelConverterDevices.add(deviceSelectionTo);
        panelConverterDevices.add(comboBoxTo);
        //
        m_title = new JLabel("App 12 Conversiteur (MVC)");
        m_title.setFont(new Font("Arial", Font.BOLD, 20));
        m_title.setForeground(Color.red);
        
        panelTitle.add(m_title, BorderLayout.CENTER);
        //
        panelMontantEtrangere = new JPanel();
        panelMontantEtrangere.setLayout(new GridLayout(1, 2));
        montantAConvertitTextField = new JTextField(10);
        montantFrom = new JLabel("Montant devise étrangère (Euro) : " );
        panelMontantEtrangere.add(montantFrom);
        panelMontantEtrangere.add(montantAConvertitTextField);
        
        //
        panelConvertit = new JPanel();
        panelConvertit.setLayout(new GridLayout(1, 2));
        montantTo = new JLabel("Montant convertit  (CFA)  :");
        montantConvertitTextField = new JTextField(10);
        //montantConvertitTextField.setEnabled(false);
        montantConvertitTextField.setEditable(false);
        panelConvertit.add(montantTo);
        panelConvertit.add(montantConvertitTextField);
        //
        panelConvertButton = new JPanel();
        panelConvertButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        convertButton = new JButton("Convertir");
        cleanButton = new JButton("Clean");
        convertButton.setBackground(Color.blue);
        convertButton.setForeground(Color.white);
        convertButton.setFont(new Font("Arial", Font.BOLD, 20));
        
        cleanButton.setBackground(Color.red);
        cleanButton.setForeground(Color.white);
        cleanButton.setFont(new Font("Arial", Font.BOLD, 20));
        
		panelConvertButton.add(convertButton);
		panelConvertButton.add(cleanButton);
		
//		     });

        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(5, 1));
        //
        contentPanel.add(panelTitle);
        //
        contentPanel.add(panelConverterDevices);
        
        contentPanel.add(panelMontantEtrangere);
        
        contentPanel.add(panelConvertit);

        
        contentPanel.add(panelConvertButton);
        
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        getContentPane().add(contentPanel);
    }
	public void addCleanButtonActionListener(ActionListener listenerCleanButton) {
		this.cleanButton.addActionListener(listenerCleanButton);
		
	}
	public void clean() {
		this.montantAConvertitTextField.setText("");
		this.montantConvertitTextField.setText("");
		
	}
	

    

	
}
