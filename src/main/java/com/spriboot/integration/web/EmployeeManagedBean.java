package com.spriboot.integration.web;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@Scope("view")
@ManagedBean
public class EmployeeManagedBean implements Serializable {

	private static final long serialVersionUID = -2977688161569868585L;
	
	// Bean iniettato da CDI
	@Autowired
	EmployeeService employeeService;

	@PostConstruct
	public void init(){
		System.out.print("entro!!\n");
	}
	
	// Nome del dipendente da ricercare
	private String employeeName;
	
	// Risultato della ricerca
	private List<Employee> result = null;
	
	private ResourceBundle bundle;
	 
    public ResourceBundle getBundle() {
        if (bundle == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            bundle = context.getApplication().getResourceBundle(context, "msg");
        }
        return bundle;
    }

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public List<Employee> getResult() {
		return result;
	}

	public void setResult(List<Employee> result) {
		this.result = result;
	}

	public String search() {
		if ( employeeName == null || employeeName.isEmpty() ) {
			result = employeeService.getAllEmployees();
		} else {
			result = employeeService.searchEmployeesByName(employeeName);
		}
		System.out.println( getBundle().getString( "message.search" ) );
        
		return null;
	}

}
