package InteractiveApplet;

import java.awt.Color;
import java.util.Arrays;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class InteractiveApplet extends HttpServlet{

	//default values
	String shape="RECT";
	int shapeW = 100;
	int shapeH = 60;
	String message = "Type Message";
	String fStyle = "PLAIN";
	int fSize = 14;
	Color fontC= Color.black;
	int appW = 300;
	int appH = 150;
	Color bgC=Color.pink;
	String errors="";
	
	String[] colors = {"black", "blue", "cyan", "darkGray", "gray", "green", "lightGray", "magenta", "orange", "pink", "red", "white", "yellow"};
	String[] styles = {"BOLD", "ITALIC"};
	
	public void doPost( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//get all values
		String shapeValue = request.getParameter("shape");
		int shapeWValue = Integer.parseInt(request.getParameter("shapeW"));
		int shapeHValue = Integer.parseInt(request.getParameter("shapeH"));
		int appWValue = Integer.parseInt(request.getParameter("appW"));
		int appHValue = Integer.parseInt(request.getParameter("appH"));
		String messageValue = request.getParameter("message");
		String fontColorValue = request.getParameter("fontColor");
		String bgColorValue = request.getParameter("bgColor");
		int fontSizeValue = Integer.parseInt(request.getParameter("fontSize"));
		//String fontStyleValues[] = request.getParameterValues(“fStyle“) ;
		
		//check and set shapeW
		if (( Integer.toString(shapeWValue) == null) || (shapeWValue>500) || (shapeWValue<10) ) {
			errors += "Please enter shape width between 10-500";
			PrintWriter writer =  response.getWriter();
			response.setContentType("text/html");
		    writer.println("<h2><font color=green>Pleaaaase enter shape width between 10-500</font></h2>");
		    writer.close();
		} else {
			shapeW = shapeWValue;
		}
		
		//check and set shapeH
		if (( Integer.toString(shapeHValue) == null) || (shapeHValue>500) || (shapeHValue<10) ) {
			errors += "Please enter shape height between 10-500";
		} else {
			shapeH = shapeHValue;
		}
		
		//check and set appW
		if (( Integer.toString(appWValue) == null) || (appWValue>500) || (appWValue<10) ) {
			errors += "Please enter applet width between 10-500";
		} else {
			appW = appWValue;
		}
		
		//check and set appH
		if (( Integer.toString(appHValue) == null) || (appHValue>700) || (appHValue<50) ) {
			errors += "Please enter applet height between 50-700";
		} else {
			appH = appHValue;
		}
		
		//check and set message
		if (messageValue!=null) {
			message=messageValue;
		}
		
		//set shape, fSize
		shape = shapeValue;
		fSize = fontSizeValue;
		
		//set fontC
		if (fontColorValue.equals("black")) {
			fontC=Color.black;
		}
		else if (fontColorValue.equals("blue")) {
			fontC=Color.blue;
		}
		else if (fontColorValue.equals("cyan")) {
			fontC=Color.cyan;
		}
		else if (fontColorValue.equals("darkGray")) {
			fontC=Color.darkGray;
		}
		else if (fontColorValue.equals("gray")) {
			fontC=Color.gray;
		}
		else if (fontColorValue.equals("lightGray")) {
			fontC=Color.lightGray;
		}
		else if (fontColorValue.equals("green")) {
			fontC=Color.green;
		}
		else if (fontColorValue.equals("magenta")) {
			fontC=Color.magenta;
		}
		else if (fontColorValue.equals("orange")) {
			fontC=Color.orange;
		}
		else if (fontColorValue.equals("pink")) {
			fontC=Color.pink;
		}
		else if (fontColorValue.equals("red")) {
			fontC=Color.red;
		}
		else if (fontColorValue.equals("white")) {
			fontC=Color.white;
		}
		else if (fontColorValue.equals("yellow")) {
			fontC=Color.yellow;
		}
		
		//set bgC
		if (bgColorValue.equals("black")) {
			bgC=Color.black;
		}
		else if (bgColorValue.equals("blue")) {
			bgC=Color.blue;
		}
		else if (bgColorValue.equals("cyan")) {
			bgC=Color.cyan;
		}
		else if (bgColorValue.equals("darkGray")) {
			bgC=Color.darkGray;
		}
		else if (bgColorValue.equals("gray")) {
			bgC=Color.gray;
		}
		else if (bgColorValue.equals("lightGray")) {
			bgC=Color.lightGray;
		}
		else if (bgColorValue.equals("green")) {
			bgC=Color.green;
		}
		else if (bgColorValue.equals("magenta")) {
			bgC=Color.magenta;
		}
		else if (bgColorValue.equals("orange")) {
			bgC=Color.orange;
		}
		else if (bgColorValue.equals("pink")) {
			bgC=Color.pink;
		}
		else if (bgColorValue.equals("red")) {
			bgC=Color.red;
		}
		else if (bgColorValue.equals("white")) {
			bgC=Color.white;
		}
		else if (bgColorValue.equals("yellow")) {
			bgC=Color.yellow;
		}
		
		//check and set fStyle


		
		
		
	}

}
