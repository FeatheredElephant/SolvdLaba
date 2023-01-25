package app.model.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import app.IOManager;
import app.model.domains.CarDealership;

public class xmlJAXBParser {

	private static IOManager io = IOManager.getInstance();
	private JAXBContext context;
	
	public xmlJAXBParser() throws JAXBException {
		context = JAXBContext.newInstance(CarDealership.class);
	}
	
	public CarDealership parse(String fileName) {
		try {
			File file = io.getFileFromResources(fileName);
			Unmarshaller unmarshaller = this.context.createUnmarshaller();
			CarDealership cd = (CarDealership)unmarshaller.unmarshal(file);
			return cd;
		}
		catch (Exception e) {
			io.reportError(e);
		}
		return null;
	}
	
	public static void main(String[] args) {
		try {
			xmlJAXBParser x = new xmlJAXBParser();
			io.println(x.parse("carDealership.xml"));
		}
		catch (Exception e) {
			io.reportError(e);
		}
	}
}