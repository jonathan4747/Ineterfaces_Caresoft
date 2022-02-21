package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;
public class UsuarioAdmin extends Usuario implements UsuarioCompatibleConHIPAA,AdminCompatibleConHIPAA {
	
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    public UsuarioAdmin(Integer id,String role) {
    	super(id);
    	this.role=role;
    	this.securityIncidents = new ArrayList<String>();
    }
   
    public boolean assignPin(int pin) {
    	int digito=0;
    	while (pin!=0)
    	{
    	pin=pin/10;
    	digito++;
    	}
    	if (digito >=6) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }
    
    public void authIncident() {
        String report = String.format(
            "Fecha y hora de envío: %s \n, ID: %s\n Notas: %s \n", 
            new Date(), this.id, "FALLÓ EL INTENTO DE AUTORIZACIÓN PARA ESTE USUARIO"
        );
        securityIncidents.add(report);
    }
    
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if(confirmedAuthID == this.id) {
    		return true;
    	}
    	
    	else {
    		authIncident();
    		return false;
    	}
    }
    
    public ArrayList<String> reportSecurityIncidents(){
    	return securityIncidents;
    }

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
    
    
	

}
