package squareworks.theforgotten.menu;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference.Elements;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuLoader {
	private static Map<String, Class> elements = new HashMap<String, Class>();
	static{
		elements.put("area", Area.class);
		elements.put("menu", Menu.class);
	}

	public MenuLoader(File dir) {
		for (File f : findFilesWithExtension(dir, "xml")) {
			try {
				DocumentBuilderFactory builderFactory = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder documentBuilder = builderFactory
						.newDocumentBuilder();
				Document document = documentBuilder.parse(f);
				document.getDocumentElement().normalize();
				NodeList nodes = document.getChildNodes();
				for(int i = 0; i < nodes.getLength(); i++){
					Element element = (Element)nodes.item(i);
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public GUIElement parseElement(Element element){
		Class elementType = elements.get(element.getNodeValue());
		Map<String,String> attributes = new HashMap<String,String>();
		for(int i = 0; i < element.getAttributes().getLength(); i++){
			String name = element.getAttributes().item(i).getNodeName();
			String value = element.getAttribute(name);
			attributes.put(name, value);
		}
		try {
			return (GUIElement) elementType.getConstructor().newInstance(attributes);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<File> findFilesWithExtension(File dir, String extension) {
		ArrayList<File> result = new ArrayList<File>();
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				result.addAll(findFilesWithExtension(f, extension));
			} else if (f.getName().endsWith("." + extension)) {
				result.add(f);
			}
		}
		return result;
	}
}