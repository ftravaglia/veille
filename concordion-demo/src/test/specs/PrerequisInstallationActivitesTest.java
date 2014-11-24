

import java.net.MalformedURLException;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import fr.ftravaglia.demo.PrerequisInstallationActivites;


@RunWith(ConcordionRunner.class)
public class PrerequisInstallationActivitesTest {

	private static final String KO = "KO";
	private static final String DISPONIBLE = "disponible";
	private PrerequisInstallationActivites appelsWSDL;

	@Before
	public void setUp(){
		appelsWSDL = new PrerequisInstallationActivites();
	}

	public PrerequisInstallationActivitesTest(){
		super();
	}


	public String testAppelCompagnon() throws MalformedURLException{
		String result = KO;

		if (appelsWSDL.getWSDLCompagnon().equals("/services-compagnon/RCGestionAgentP2I?wsdl")) {
			result = DISPONIBLE;
		}
		return result;
	}


	public String testAppelStructures() throws MalformedURLException{
		String result = KO;

		if (appelsWSDL.getWSDLStuctures().equals("/axis/services/RSdescriptionsSODate?wsdl")) {
			result = DISPONIBLE;
		}
		return result;

	}

	public String testAppelMotsCles() throws MalformedURLException{

		String result = KO;
		if (appelsWSDL.getWSDLMotsCles().equals("/services-descripteurs/MCGestionDescripteur?wsdl")) {
			result = DISPONIBLE;
		}
		return result;
	}
}