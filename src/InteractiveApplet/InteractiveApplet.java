package InteractiveApplet;

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/appletServlet")
public class InteractiveApplet extends HttpServlet{

	//default values
	String shape="RECT";
	int shapeW = 100;
	int shapeH = 60;
	String message = "Type Message";
	Font font = new Font( "Serif", Font.PLAIN, 14 );
	int fSize = 14;
	Color fontC= Color.black;
	int appW = 300;
	int appH = 150;
	Color bgC=Color.pink;
	String errors="";
	
	String fontStyleValues[] = {""};
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException  {
		System.out.println("InGet");

			}
	public void doPost( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("InPost");
		//get all values
		String shapeValue = request.getParameter("shape");	
	  	String shapeWValue = request.getParameter("shapeW");
		String shapeHValue = request.getParameter("shapeH");
		String appWValue = request.getParameter("appW");
		String appHValue = request.getParameter("appH");
		String messageValue = request.getParameter("message");
		String fontColorValue = request.getParameter("fontColor");
		String bgColorValue = request.getParameter("bgColor");
		int fontSizeValue = Integer.parseInt(request.getParameter("fontSize"));
		String fontStyleValues[] = request.getParameterValues("fStyle");
		
		
		//check and set shapeW	
		if ((shapeWValue == "") || (Integer.parseInt(shapeWValue)>500) || (Integer.parseInt(shapeWValue)<10) ) {
			errors += "Please enter shape width between 10-500";
			
			PrintWriter writer =  response.getWriter();
			response.setContentType("text/html");
		    writer.println("<h3><font color=green>Please enter shape width between 10-500</font></h3>");
		    writer.close();
		} else {
			shapeW = (Integer.parseInt(shapeWValue));
		}
		
		
		//check and set shapeH
		if ((shapeHValue == "") || (Integer.parseInt(shapeHValue)>500) || (Integer.parseInt(shapeHValue)<10) ) {
			errors += "Please enter shape height between 10-500";
		} else {
			shapeH = (Integer.parseInt(shapeHValue));
		}
		
		//check and set appW
		if (( appWValue == "") || (Integer.parseInt(appWValue)>500) || (Integer.parseInt(appWValue)<10) ) {
			errors += "Please enter applet width between 10-500";
		} else {
			appW = (Integer.parseInt(appWValue));
		}
		
		//check and set appH
		if ((appHValue == "") || (Integer.parseInt(appHValue)>700) || (Integer.parseInt(appHValue)<50) ) {
			errors += "Please enter applet height between 50-700";
		} else {
			appH = (Integer.parseInt(appHValue));
		}
		
		//check and set message
		if (messageValue!="") {
			message=messageValue;
		} else {
			message="";
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
		if (fontStyleValues==null) {
			font = new Font( "Serif", Font.PLAIN, fSize );
		} else {
			List<String> fontStyleList = Arrays.asList(fontStyleValues);
			if (fontStyleList.contains("bold")) {
				if (fontStyleList.contains("italic")) {
					font = new Font( "Serif", Font.BOLD + Font.ITALIC, fSize );
				}
				else {
					font = new Font( "Serif", Font.BOLD , fSize );
				}
			} else {
				font = new Font( "Serif", Font.ITALIC, fSize );
				}
		}

		
		
		
	}

}
