package InteractiveApplet;

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
public class InteractiveApplet extends HttpServlet{

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
		if ((shapeWValue == "") || (Integer.parseInt(shapeWValue)>500) || (Integer.parseInt(shapeWValue)<10) ) {
			JOptionPane.showMessageDialog(null, "Please enter shape width between 10-500", "Error", JOptionPane.ERROR_MESSAGE);
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
		
		


	    
		//HTML form entry
		PrintWriter writer =  response.getWriter();
		response.setContentType("text/html");
		StringBuffer buf = new StringBuffer();
		
		buf.append("<html lang=\"en\"><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"><title>Assignment 3 Interactive Applet - by Taqwa Khogeer and Maya Bayer</title>\n");
		buf.append("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css\" integrity=\"sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy\" crossorigin=\"anonymous\">\n");
		buf.append("<link rel=stylesheet href=\"applet-style.css\"></head>\n");
		buf.append("<body><div class=container-fluid style=\"height:100%;\"><div class=row>\n");
		
		//applet input section starts---------------------------------------------
		buf.append("<div class=\"col-md-3 grey no-padding\">\n");
		//----------------------------------------------------------------------
		buf.append("<table class=\"table no-border\">\n");
		buf.append("<thead><tr><th><h2>Create your Applet</h2></th></tr></thead>\n");
		buf.append("<tbody><tr><td>\n");
		buf.append("<form action=appletServlet method=Post>\n");//form starts
		
		//shape style
		buf.append("<h4>Shape Style</h4>\n");
        buf.append("<h6>Choose a Shape</h6>\n");
		buf.append("<div class=\"form-check form-check-inline\"> \n");
		buf.append("<input class=form-check-input type=radio name=shape id=shape value=rect>\n");
		buf.append("<label class=form-check-label for=shape><img src=\"images/rect.gif\" alt=rectangle></label>\n");
		buf.append("<input class=form-check-input type=radio name=shape id=shape value=roundRect>\n");
		buf.append("<label class=form-check-label for=shape><img src=\"images/rnd-rect.gif\" alt=\"rounded rectangle\"></label>\n");
		buf.append("<input class=form-check-input type=radio name=shape id=shape value=oval>\n");
		buf.append("<label class=form-check-label for=shape><img src=\"images/oval.gif\" alt=oval></label></div>\n");
		
		//shape size
		buf.append("<br><br><div class=form-row>\n");
		buf.append("<div class=\"form-group col-md-3\">\n");
		buf.append("<label for=width >Width</label>\n");
		buf.append("<input type=text class=\"form-control form-control-sm\" id=shapeW name=shapeW value=shapeW maxlength=3 ></div>\n");
		buf.append("<div class=\"form-group col-md-9 float-left\">\n");
		buf.append("<label for=heighth>Height</label>\n");
		buf.append("<input type=text class=\"form-control form-control-sm\" id=shapeH name=shapeH value=shapeH maxlength=3 ></div></div><hr>\n");
		
		//message
		buf.append("<h4>Message</h4>\n");
		buf.append("<div class=form-group>\n");
		buf.append("<input type=text class=\"form-control form-control-sm\" id=message name=message aria-describedby=message value=message maxlength=20>\n");
		buf.append("<small id=message class=\"form-text text-muted\">Your message should not exceed 20 characters long</small></div><hr>\n");
		
		//font style
		buf.append("<h4>Font Style</h4>\n");
		buf.append("<div class=form-row>\n");
		buf.append("<div class=\"form-group col-md-6 \">\n");
		buf.append("<label>Font Style</label><br>\n");
		buf.append("<div class=\"form-check form-check-inline\">\n");
		buf.append("<input class=form-check-input type=checkbox name=fStyle id=bold value=bold>\n");//bold font
		buf.append("<label class=form-check-label for=bold><strong>Bold</strong></label></div>\n");
		buf.append("<div class=\"form-check form-check-inline\">\n");
		buf.append("<input class=form-check-input type=checkbox name=fStyle id=italic value=italic>\n");
		buf.append("<label class=form-check-label for=italic><i>Italic</i></label>\n");//italic font
		buf.append("/div></div></div>\n");
		buf.append("<div class=form-row>\n");
		buf.append("<div class=\"form-group col-md-4 col-lg-3\">\n");
		buf.append("<label for=font-size>Font Size</label>\n");
		buf.append("<select name=fontSize id=fontSize value=fontSize class=\"custom-select custom-select-sm\" >\n"); //font sizes dropdown
		buf.append("<option value=8>8</option>\n");
		buf.append("<option value=10>10</option>\n");
		buf.append("<option value=12>12</option>\n");
		buf.append("<option value=14 selected=selected>14</option>\n");// font size default value
		buf.append("<option value=18>18</option>\n");
		buf.append("<option value=24>24</option>\n");
		buf.append("<option value=30>36</option>\n");
		buf.append("<option value=36>36</option>\n");
		buf.append("<option value=48>48</option>\n");
		buf.append("<option value=60>60</option>\n");
		buf.append("<option value=72>72</option>\n");
		buf.append("</select></div>\n");
		buf.append("<div class=\"form-group col-md-4\">\n");
		buf.append("<label for=font-color>Font Color</label>\n");
		buf.append("<select  name=fontColor id=fontColor value=fontColor class=\"custom-select custom-select-sm \" >\n");//font color drop down
		buf.append("<option value=black selected=selected >Black</option>\n");//font color default value: black
		buf.append("<option value=white> White</option>\n");
		buf.append("<option value=blue>  Blue</option>\n");
		buf.append("<option value=cyan> Cyan</option>\n");
		buf.append("<option value=darkGray> Dark Gray</option>\n");
		buf.append("<option value=gray> Gray</option>\n");
		buf.append("<option value=green> Green</option>\n");
		buf.append("<option value=yellow> Yellow</option>\n");
		buf.append("<option value=lightGray> Light Gray</option>\n");
		buf.append("<option value=magenta> Magenta</option>\n");
		buf.append("<option value=orange> Orange</option>\n");
		buf.append("<option value=pink> Pink</option>\n");
		buf.append("<option value=red> Red</option>\n");
		buf.append("</select></div></div><hr>\n");
		
		//Applet Style
		buf.append("<h4>Applet Style</h4>\n");
		buf.append("<div class=form-row>\n");
		buf.append("<div class=\"form-group col-md-3\">\n");
		buf.append("<label for=width >Width</label>\n");
		buf.append("<input type=text class=\"form-control form-control-sm\" name=appW id=appW maxlength=3 value=appW ></div>\n");//applet width
		buf.append("<div class=\"form-group col-md-3\">\n");
		buf.append("<label for=heighth>Height</label>\n");
		buf.append("<input type=text class=\"form-control form-control-sm\" name=appH id=appH maxlength=3 value=appH ></div>\n");//applet height
		buf.append("<div class=\"form-group col-md-6\">\n");
		buf.append("<label for=background-color>Background Color</label><br>\n");
		buf.append("<select name=bgColor id=bgColor value=bgColor class=\"custom-select custom-select-sm\" >\n");//applet background color dropdown
		buf.append("<option value=black >Black</option>\n");
		buf.append("<option value=white selected=selected >White</option>\n");//background color default value: white
		buf.append("<option value=blue>  Blue</option>\n");
		buf.append("<option value=cyan> Cyan</option>\n");
		buf.append("<option value=darkGray> Dark Gray</option>\n");
		buf.append("<option value=gray> Gray</option>\n");
		buf.append("<option value=green> Green</option>\n");
		buf.append("<option value=yellow> Yellow</option>\n");
		buf.append("<option value=lightGray> Light Gray</option>\n");
		buf.append("<option value=magenta> Magenta</option>\n");
		buf.append("<option value=orange> Orange</option>\n");
		buf.append("<option value=pink> Pink</option>\n");
		buf.append("<option value=red> Red</option>\n");
		buf.append("</select></div></div><hr>\n");
		
		//alert message
		buf.append("<div class=\"alert text-center\" role=alert> verify that all your values are entered <br>before proceeding </div>\n");
		
		//create applet button
		buf.append("<div class=\"form-group text-center\">\n");
		buf.append("<input type=submit class=\"btn btn-primary\" value=\"Create Your Applet\"><br>\n");
		
		//reset button
		buf.append("<input type=reset value=\"Clear Form\" />\n");
		
		buf.append(" </div></form>\n");//form ends
		
		//applet input section ends---------------------------------------------
		buf.append("</td></tr></tbody></table></div>\n");
		//----------------------------------------------------------------------
		
		//*****************************************************************************************
		
		//applet output section starts------------------------------------------
		buf.append("<div class=\"col-md-9 text-center fixed-top\">\n");
		//----------------------------------------------------------------------
		buf.append("<applet code=\"/WEB-INF/classes/InteractiveApplet/Applet.class\" width=appW height=appH >\n");//applet starts
		
		//Shape parameters
		buf.append("<param name=shape value=\"");
		buf.append(shape);
		buf.append("\">\n<param name=shapeW value=\"");
		buf.append(shapeW);
		buf.append("\">\n<param name=shapeH value=\"");
		buf.append(shapeH);
		buf.append("\">\n");
		
		//message parameter
		buf.append("<param name=message value=\"");
		buf.append(message);
		buf.append("\">\n");
		
		//font style parameters
		buf.append("<param name=fSize   value=\"");
		buf.append(fSize);
		buf.append("\">\n<param name=fontC value=\"");
		buf.append(fontColorValue);
		buf.append("\">\n<param name=fontStyle value=\"");
		buf.append(fStyle);
		buf.append("\">\n");
		
		//applet parameters
		buf.append("<param name=appW value=\"");
		buf.append(appW);
		buf.append("\">\n<param name=appH value=\"");
		buf.append(appH);
		buf.append("\">\n<param name=bgC value=\"");
		buf.append(bgColorValue);
		buf.append("\">\n");
		
		buf.append("</applet>\n");//applet ends
		
		//applet output section ends--------------------------------------------
		buf.append("</div>\n");
		//----------------------------------------------------------------------
		
		buf.append(" </div></div>\n");
		buf.append("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=anonymous></script> \n");
		buf.append("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=anonymous></script> \n");
		buf.append("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js\" integrity=\"sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4\" crossorigin=anonymous></script>\n");
		buf.append("</body></html>\n");
		writer.println(buf.toString());
		writer.close();
		

		
	}
	


}