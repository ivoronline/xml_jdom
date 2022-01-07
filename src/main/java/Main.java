import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

    //CREATE DOCUMENT BUILDER
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder        builder = factory.newDocumentBuilder();

    //SPECIFY XML SOURCE (FILE)
    File                   input = new File("Test.xml");

    //CREATE DOCUMENT
    Document               document  = builder.parse(input);
                           document.getDocumentElement().normalize();

    //ITERATE THROUGH ELEMENTS
    NodeList nodeList = document.getElementsByTagName("student");
    for (int i = 0; i < nodeList.getLength(); i++) {

      //GET NEXT ELEMENT
      Node node = nodeList.item(i);

      //GET DATA
      Element eElement  = (Element) node;
      String  rollno    = eElement.getAttribute("rollno");
      String  firstname = eElement.getElementsByTagName("firstname").item(0).getTextContent();
      String  lastname  = eElement.getElementsByTagName("lastname" ).item(0).getTextContent();
      String  marks     = eElement.getElementsByTagName("marks"    ).item(0).getTextContent();

      //DISPLAY DATA
      System.out.println("rollno   : " + rollno   );
      System.out.println("firstname: " + firstname);
      System.out.println("lastname : " + lastname );
      System.out.println("marks    : " + marks    );
      System.out.println();

   }

    //PARSE

    System.out.println("Root element :" + document.getDocumentElement().getNodeName());

    Element root = document.getDocumentElement();
    
    //returns specific attribute
    root.getAttribute("attributeName");
    
    //returns a Map (table) of names/values
    root.getAttributes();

  }

}
