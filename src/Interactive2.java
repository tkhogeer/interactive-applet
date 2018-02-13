//Assignment 3 Interactive Applet - by Taqwa Khogeer and Maya Bayer

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

import java.io.*;

@WebServlet("/appletServlet")
public class Interactive2 extends HttpServlet{

	//default values
	String shape="rect";
	int shapeW = 100;
	int shapeH = 60;
	String message = "Type Message";
	Font font = new Font( "Serif", Font.PLAIN, 14 );
	int fSize = 14;
	Color fontC= Color.black;
	int appW = 300;
	int appH = 150;
	Color bgC=Color.white;
	String errors="";
	
	String fontStyleValues[] = {""};
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException  {

			}
	public void doPost( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
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
		
		String fStyle = Arrays.toString(fontStyleValues);
		
		//check and set shapeW	
		if ((shapeWValue.equals("")) || (Integer.parseInt(shapeWValue)>600) || (Integer.parseInt(shapeWValue)<100) ) {
			JOptionPane.showMessageDialog(null, "Please enter shape width between 100-600", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			shapeW = (Integer.parseInt(shapeWValue));
		}
		
		
		//check and set shapeH
		if ((shapeHValue.equals("")) || (Integer.parseInt(shapeHValue)>600) || (Integer.parseInt(shapeHValue)<100) ) {
			JOptionPane.showMessageDialog(null, "Please enter shape height between 100-600", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			shapeH = (Integer.parseInt(shapeHValue));
		}
		
		//check and set appW
		if (( appWValue.equals("")) || (Integer.parseInt(appWValue)>700) || (Integer.parseInt(appWValue)<150)) {
			JOptionPane.showMessageDialog(null, "Please enter applet width between 150-700", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (shapeW>=(Integer.parseInt(appWValue))){
			JOptionPane.showMessageDialog(null, "Shape width exceeds applet width. Returning to default.", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			appW = (Integer.parseInt(appWValue));
		}
		
		//check and set appH
		if ((appHValue.equals("")) || (Integer.parseInt(appHValue)>700) || (Integer.parseInt(appHValue)<100) ) {
			JOptionPane.showMessageDialog(null, "Please enter applet height between 100-700", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (shapeH>=(Integer.parseInt(appHValue))){
			JOptionPane.showMessageDialog(null, "Shape height exceeds applet height. Returning to default.", "Error", JOptionPane.ERROR_MESSAGE);
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
		
		String applet = String.format("<applet code=\"TheApplet.class\" width=\"" + String.valueOf(appW) + "\"\" height=\""  + String.valueOf(appH) + "\">\n" +
				"<param name='message' value='%s'>\n" +
				"<param name='fontC' value='%s'>\n" +
				"<param name='bgC' value='%s'>\n" +
				"<param name='shapeH' value='%s'>\n" +
				"<param name='shapeW' value='%s'>\n" +
				"<param name='appH' value='%s'>\n" +
				"<param name='appW' value='%s'>\n" +
				"<param name='fStyle' value='%s'>\n" +
				"<param name='shape' value='%s'>\n" +
				"<param name='fSize' value='%s'>\n" +
				"</applet>", message, fontColorValue, bgColorValue, shapeH, shapeW, appH, appW, fStyle, shape, fSize );
		 
		request.getSession().setAttribute("applet", applet);
		//response.sendRedirect("index.jsp");
		request.getRequestDispatcher("applet.jsp").forward(request, response);
		
	}	


}