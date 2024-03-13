package com.app.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.app.models.ConverterModel;
import com.app.views.View;
public class Controller{
	private ConverterModel model;
    private View view;
    
    public Controller(ConverterModel model, View view) {
        this.model = model;
        this.view = view;
        
        //Add devise list to the combo
        view.setDeviseItemsFromModelFrom(model.getDevices());
        view.setDeviseItemsFromModelTo(model.getDevices());
        view.setSelectedDevise(1);
        
        addListener();
    }
    
    private void addListener() {
    	ActionListener listenerConvertButton = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String montant = view.getMontantAConvertitTextField();
				String deviseFrom = view.getCurentDeviseFrom() ;
				String deviseTo = view.getCurentDeviseTo();
				view.setMontantFromLabel("Montant From (" + deviseFrom + ") ");
				view.setMontantToLabel("Montant To (" + deviseTo + ") ");
				
				if (!montant.isEmpty()) {
	                double montantSaisie = Double.parseDouble(montant);
	                //double montantConvertit = model.convertFCA(montantSaisie, deviseFrom);
	                double montantConvertit = model.convertTo(montantSaisie, deviseFrom, deviseTo);
	                		
	                //view.setMontantConvertit(montantConvertit);
	                //view.setMontantConvertit(Math.round(montantConvertit, 4));
	                view.setMontantConvertit(Math.round(montantConvertit * 10000.0) / 10000.0);

	            	}
	            }
			
			
			};
		view.addConvertButtonActionListener(listenerConvertButton);
		//cleanButton
		ActionListener listenerCleanButton = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			view.clean();	
			
			}
		};
		view.addCleanButtonActionListener(listenerCleanButton);
		
		//combobox devise
		ActionListener listenerCombox = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				String montant = view.getMontantAConvertitTextField();
				
				
			//	String devise = view.getCurentDeviseFrom() ;
				String deviseFrom = view.getCurentDeviseFrom() ;
				String deviseTo = view.getCurentDeviseTo();
				view.setMontantFromLabel("Montant devise étrangère (" + deviseFrom + "): ");
				
				view.setMontantToLabel("Montant To (" + deviseTo + ") ");
				if (!montant.isEmpty()) {
	                double montantSaisie = Double.parseDouble(montant);
	                //double montantConvertit = model.convertFCA(montantSaisie, deviseFrom);
	                double montantConvertit = model.convertTo(montantSaisie, deviseFrom, deviseTo);
	                //view.setMontantConvertit(Math.round(montantConvertit));
	                view.setMontantConvertit(Math.round(montantConvertit * 10000.0) / 10000.0);

	            	}
	            }
		};
		view.addComboxFromActionListener(listenerCombox);
		view.addComboxToActionListener(listenerCombox);
		
    }
    
    public void start() {
        view.display();
    }
	
}
