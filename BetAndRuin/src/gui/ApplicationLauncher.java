package gui;

import java.awt.Color; // This import is necessary to add Color
import java.net.URL;
import java.util.Locale;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;

public class ApplicationLauncher {
	
	
	
	public static void main(String[] args) {
		
		//DataAccess db = new DataAccess();
		try {
			//db.createAccount("admin", "admin"); //Test createAccount method
			//db.verifyAccount("admin", "admin"); /* Test verifyUser method */
			//db.createAccount("String0", "String1", "String2", "String3", "username", "pass", "String4");
			//db.createAccount("admin", "admin");
			
			// You can try the verifyUser method with the credentials "username" and "pass".
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ConfigXML c=ConfigXML.getInstance();
	
		System.out.println(c.getLocale());
		
		Locale.setDefault(new Locale(c.getLocale()));
		
		System.out.println("Locale: "+Locale.getDefault());
		
		HomepageGUI home = new HomepageGUI();                   // <---  NEEDS TO BE THE STARTING WINDOW
		//home.setVisible(true);
		//MainGUI a =new MainGUI();
		//a.setVisible(true);



		try {
			
			BLFacade appFacadeInterface;
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			
			if (c.isBusinessLogicLocal()) {
				
			 appFacadeInterface=new BLFacadeImplementation();
				
				
			}
			
			else { //Si es remoto
				
				//String serviceName="http://localhost:9999/ws/ruralHouses?wsdl";
				 String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
				 
				//URL url = new URL("http://localhost:9999/ws/ruralHouses?wsdl");
				URL url = new URL(serviceName);

		 
		        //1st argument refers to wsdl document above
				//2nd argument is service name, refer to wsdl document above
		        QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
		 
		        Service service = Service.create(url, qname);
		 
		         appFacadeInterface = service.getPort(BLFacade.class);
			} 
			/*if (c.getDataBaseOpenMode().equals("initialize")) 
				appFacadeInterface.initializeBD();
				*/
			MainGUI.setBussinessLogic(appFacadeInterface);
			//########################################################################################
			// just for testing purpose
			if(appFacadeInterface.UsernameAvailable("admin55"))System.out.println("Available");
			//appFacadeInterface.Register("admin55", "admin");
		

			
		}catch (Exception e) {
			//a.jLabelSelectOption.setText("Error: "+e.toString());
			//a.jLabelSelectOption.setForeground(Color.RED);		
			System.out.println("Error in ApplicationLauncher: "+e.toString());
		}
		//a.pack();


	}

}
