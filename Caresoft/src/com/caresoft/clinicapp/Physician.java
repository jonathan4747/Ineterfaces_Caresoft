package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;
public class Physician extends Usuario implements UsuarioCompatibleConHIPAA{
	     
    private ArrayList<String> patientNotes;

    
    public Physician(Integer id) {
    	super(id);
    }
    
    public boolean assignPin(int pin) {
    	int digito=0;
    	while (pin!=0)
    	{
    	pin=pin/10;
    	digito++;
    	}
    	if (digito == 4) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }
    
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if(confirmedAuthID == this.id) {
    		return true;
    	}
    	
    	else {
    		return false;
    	}
    }
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Fecha y hora de envío: %s \n", date);
        report += String.format("Reportado por ID: %s\n", this.id);
        report += String.format("Nombre del paciente: %s\n", patientName);
        report += String.format("Notas: %s \n", notes);
        this.patientNotes.add(report);
    }

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
    

}
