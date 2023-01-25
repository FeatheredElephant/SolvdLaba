package app.model.xml;

import org.w3c.dom.*;

import app.IOManager;
import app.model.domains.*;

import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

public class xmlDomParser {
	static IOManager io = IOManager.getInstance();
	public static CarDealership ParseDocument(String fileName){
		try {
			CarDealership dealership = new CarDealership();
			File inputFile = io.getFileFromResources(fileName);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(inputFile);
			NodeList nodes = document.getFirstChild().getChildNodes();
			
			if (nodes.getLength() == 0) return null;
			for (int index=0; index < nodes.getLength(); index++) {
				HandleNode(dealership, nodes.item(index));
			}
		}
		catch (Exception e) {
			IOManager.getInstance().reportError(e);
		}
		
		return null;
		
	}
	
	private static void HandleNode(CarDealership dealership, Node node) {
		if (node.getNodeType() != Node.ELEMENT_NODE) return;
		Element eNode = (Element)node;
		switch (eNode.getNodeName()) {
		case "users":
			NodeList userNodeList = eNode.getElementsByTagName("user");
			if (userNodeList.getLength() == 0) break;
			
			List<User> userList = new ArrayList<User>();
			for (int i = 0; i<userNodeList.getLength(); i++) {
				Element userNode = (Element)userNodeList.item(i);
				NodeList userElements = userNode.getElementsByTagName("*");
				int id = -1;
				String name = null;				
				for (int j=0; j<userElements.getLength(); j++) {
					Node n = userElements.item(j);
					if (n.getNodeName().equals("userId")) id = Integer.parseInt(n.getTextContent());
					if (n.getNodeName().equals("name")) name = n.getTextContent();
				}
				if (id == -1) throw new IllegalArgumentException("Element with name 'userId' not found.");
				if (name == null) throw new IllegalArgumentException("Element with name 'name' not found.");
				userList.add(new User(id, name));
			}
			for(User u: userList){
				io.println(u);
			}
			break;
		default:
			break;
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParseDocument("carDealership.xml");
	}
}