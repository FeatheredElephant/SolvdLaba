package app.model.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import app.IOManager;
import app.model.domains.CarDealership;

public class XmlJAXBParser {

	private static IOManager io = IOManager.getInstance();
	private JAXBContext context;

	public XmlJAXBParser() throws JAXBException {
		context = JAXBContext.newInstance(CarDealership.class);
	}

	public boolean write(CarDealership carDealership, String fileName) {
		try {
			File file = io.getFileFromResources(fileName);
			Marshaller marshaller = this.context.createMarshaller();
			marshaller.marshal(carDealership, file);
			return true;
		} catch (Exception e) {
			io.reportError(e);
		}
		return false;
	}

	public CarDealership read(String fileName) {
		try {
			File file = io.getFileFromResources(fileName);
			Unmarshaller unmarshaller = this.context.createUnmarshaller();
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
			XmlJAXBParser x = new XmlJAXBParser();
			CarDealership cd = x.read("outputCarDealership.xml");
			io.println(cd);
			x.write(cd, "test.xml");
		} catch (Exception e) {
			io.reportError(e);
		}
	}
}