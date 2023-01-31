package app.model.parsers;

import javax.xml.bind.JAXBException;

import com.fasterxml.jackson.databind.*;

import app.IOManager;
import app.model.domains.CarDealership;

public class JsonParser {

	public static ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	public static IOManager io = IOManager.getInstance();

	public static <T> T read(String fileName, Class<T> classType) {
		try {
			return objectMapper.readValue(io.getFileFromResources(fileName), classType);
		} catch (Exception e) {
			io.reportError(e);
			e.printStackTrace();
		}
		return null;
	}

	public static <T> boolean write(String fileName, T source) {
		try {
			objectMapper.writeValue(io.getFileFromResources(fileName), source);
			return true;
		} catch (Exception e) {
			io.reportError(e);
		}
		return false;
	}

	public static void main(String[] args) {
		String sourceFileName = "carDealership.xml";
		String targetFileName = "carDealership.json";

		try {
			CarDealership cd = XmlJAXBParser.read(sourceFileName);
			io.println(cd);
			JsonParser.write(targetFileName, cd);
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}