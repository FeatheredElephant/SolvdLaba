package app.model.parsers;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import app.IOManager;
import app.model.domains.CarDealership;

public class XmlJAXBParser {

	private static IOManager io = IOManager.getInstance();
	private static JAXBContext context;
	
	public static JAXBContext getContext() {
		if (context == null)
			try {
				context = JAXBContext.newInstance(CarDealership.class);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return context;
	}

	public static boolean write(CarDealership carDealership, String fileName) {
		try {
			File file = io.getFileFromResources(fileName);
			Marshaller marshaller = getContext().createMarshaller();
			marshaller.marshal(carDealership, file);
			return true;
		} catch (Exception e) {
			io.reportError(e);
		}
		return false;
	}

	public static CarDealership read(String fileName) {
		try {
			context = JAXBContext.newInstance(CarDealership.class);
			File file = io.getFileFromResources(fileName);
			Unmarshaller unmarshaller = getContext().createUnmarshaller();
			CarDealership cd = (CarDealership) unmarshaller.unmarshal(file);
			return cd;
		} catch (Exception e) {
			io.reportError(e);
		}
		return null;
	}

	public static void main(String[] args) {
		String fileName = "carDealership.xml";
		try {
			CarDealership cd = XmlJAXBParser.read(fileName);
			io.println(cd);
			XmlJAXBParser.write(cd, "test.xml");
		} catch (Exception e) {
			io.reportError(e);
		}
	}
}