import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.sql.*;
import java.sql.PreparedStatement;


public class DatabaseQuery {
    public static void main(String[] args) {

        PreparedStatement preparedStatement = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/advanced_java","temp","temp");

            // PreparedStatements can use variables and are more efficient
            preparedStatement = con
                    .prepareStatement("insert into Student values ( ?, ?, ?, ? , ?)");

            File inputFile = new File("input.txt");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String id = eElement.getAttribute("rollno");
                    String Name = eElement
                            .getElementsByTagName("firstname")
                            .item(0)
                            .getTextContent() + " " + eElement
                            .getElementsByTagName("middlename")
                            .item(0)
                            .getTextContent();
                    String Surname = eElement
                            .getElementsByTagName("lastname")
                            .item(0)
                            .getTextContent();
                    String Gender = eElement
                            .getElementsByTagName("gender")
                            .item(0)
                            .getTextContent();
                    Float Marks = Float.parseFloat( eElement
                            .getElementsByTagName("marks")
                            .item(0)
                            .getTextContent());

                    preparedStatement.setString(1, id);
                    preparedStatement.setString(2, Name);
                    preparedStatement.setString(3, Surname);
                    preparedStatement.setString(4, Gender);
                    preparedStatement.setFloat(5, Marks);
                    preparedStatement.executeUpdate();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
