/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package com.practica.programacion;

import java.io.Serializable;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Usuario.
 * 
 * @author Santiago Hernández
 */
public class Usuario implements Serializable {
	 private static final long serialVersionUID = 30L;
	/**
	 * Description of the property correo.
	 */
	public String correo = "";
	
	/**
	 * Description of the property clave.
	 */
	public String clave = "";
	
	// Start of user code (user defined attributes for Usuario)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public Usuario() {
		// Start of user code constructor for Usuario)
		super();
		// End of user code
	}
	public Usuario(
                String correo, 
                String clave){
            this();
            this.correo=correo;
            this.clave=clave;
                    
                    
        }
	// Start of user code (user defined methods for Usuario)
	
	// End of user code
	/**
	 * Returns correo.
	 * @return correo 
	 */
	public String getCorreo() {
		return this.correo;
	}
	
	/**
	 * Sets a value to attribute correo. 
	 * @param newCorreo 
	 */
	public void setCorreo(String newCorreo) {
	    this.correo = newCorreo;
	}

	/**
	 * Returns clave.
	 * @return clave 
	 */
	public String getClave() {
		return this.clave;
	}
	
	/**
	 * Sets a value to attribute clave. 
	 * @param newClave 
	 */
	public void setClave(String newClave) {
	    this.clave = newClave;
	}



}
