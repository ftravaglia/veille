package fr.ftravaglia.demo;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Demo pour concordion.
 * @author ftravaglia
 *
 */
public class PrerequisInstallationActivites {

	private static final String URL_COMPAGNON = "http://activites-preproduction.jouy.inra.fr:11080/services-compagnon/RCGestionAgentP2I?wsdl";
	private static final String URL_STRUCTURES_SO = "http://ws-structures-preproduction.jouy.inra.fr:8080/axis/services/RSdescriptionsSODate?wsdl";
	private static final String URL_MC = "http://activites-preproduction.jouy.inra.fr:8080/services-descripteurs/MCGestionDescripteur?wsdl";

	public PrerequisInstallationActivites(){
		super();
	}
	
	public String getWSDLCompagnon() throws MalformedURLException{
		URL urlCompagnon = new URL(URL_COMPAGNON);		
		return urlCompagnon.getFile();
	}
	
	public String getWSDLStuctures() throws MalformedURLException{
		URL urlCompagnon = new URL(URL_STRUCTURES_SO);		
		return urlCompagnon.getFile();
	}
	
	public String getWSDLMotsCles() throws MalformedURLException{
		URL urlCompagnon = new URL(URL_MC);		
		return urlCompagnon.getFile();
	}
}
