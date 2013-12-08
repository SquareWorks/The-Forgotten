package squareworks.mandw.menu;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MenuLoader {

	public MenuLoader(File dir) {
		for (File f : findFilesWithExtension(dir, "xml")) {
			try {
				DocumentBuilderFactory builderFactory = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder documentBuilder = builderFactory
						.newDocumentBuilder();
				Document document = documentBuilder.parse(f);
				document.getDocumentElement().normalize();
				Element meta = document.getElementById("meta");
				Menu tempMenu = new Menu(Integer.parseInt(meta.getAttribute("id")), meta.getAttribute("name"), meta.getAttribute("type"));
				Element menu = document.getElementById("menu");
				NodeList nodes = menu.getElementsByTagName("area");
				for(int i = 0; i < nodes.getLength(); i++){
					Element area = (Element)nodes.item(i);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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