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
		elements.put("button", Button.class);
	}

	public MenuLoader(File dir, Map<String, Menu> menuMap) {
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
					GUIElement guiElement = parseElement(element);
					if(guiElement instanceof Menu){
						Menu menu = (Menu)guiElement;
						menuMap.put(menu.getAttribute("id"), menu);
						System.out.println(menu.getAttribute("id") + " loaded");
					}
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public GUIElement parseElement(Element element){
		Class elementType = elements.get(element.getNodeName());
		Map<String,String> attributes = new HashMap<String,String>();
		for(int i = 0; i < element.getAttributes().getLength(); i++){
			String name = element.getAttributes().item(i).getNodeName();
			String value = element.getAttribute(name);
			attributes.put(name, value);
		}
		GUIElement guiElement;
		try {
			guiElement = (GUIElement) elementType.getConstructor(Map.class).newInstance(attributes);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e1) {
			e1.printStackTrace();
			return null;
		}
		if(element.hasChildNodes()){
			NodeList childNodes = element.getElementsByTagName("*");
			for(int i = 0; i < childNodes.getLength(); i++){
				guiElement.add(parseElement((Element)childNodes.item(i)));
			}
		}
		return guiElement;
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