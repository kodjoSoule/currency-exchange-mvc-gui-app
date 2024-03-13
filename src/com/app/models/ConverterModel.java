package com.app.models;

public class ConverterModel {
    
	private String[] devises ;
    
	public String[] getDevices() {
		return devises;
	}

	
    public ConverterModel() {
    	
    	devises = new String[]{"Euro", "FCFA", "Dollar Americain","Yen", "Livre Sterling", "Dinar Tunisien", "Cedi"};
    }
    
    public double convertToOld(double montant, String deviseFrom, String deviseTo) {
    	return montant*getTauxEchange(deviseFrom)/getTauxEchange(deviseTo);
    	
    }
    public double convertTo(double montant, String deviseFrom, String deviseTo) {
        double tauxEchangeFrom = getTauxEchange(deviseFrom);
        double tauxEchangeTo = getTauxEchange(deviseTo);
        return montant * tauxEchangeFrom / tauxEchangeTo;
    }
    public double convertFCA(double montant, String devise) {
    	double tauxEchange = getTauxEchange(devise);
        
    	return montant * tauxEchange;
    }
    public double getTauxEchange(String devise) throws IllegalArgumentException {
        
        switch (devise) {
            case "Euro":
                return 655.91;
            case "FCFA":
                return 1;
            case "Dollar Americain":
                return 599.48;
            case "Livre Sterling":
                return 765.84;
            case "Cedi":
                return 53.30 ;
            case "Yen":
                return 4.27 ;
                
            case "Dinar Tunisien":
                return 194.92;
            default:
                throw new IllegalArgumentException("devise Invalide : " + devise);
        }
    }
    
}
