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
		if ((shapeWValue.equals("")) || (Integer.parseInt(shapeWValue)>600) || (Integer.parseInt(shapeWValue)<50) ) {
			JOptionPane.showMessageDialog(null, "Please enter shape width between 50-600", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			shapeW = (Integer.parseInt(shapeWValue));
		}
		
		
		//check and set shapeH
		if ((shapeHValue.equals("")) || (Integer.parseInt(shapeHValue)>600) || (Integer.parseInt(shapeHValue)<50) ) {
			JOptionPane.showMessageDialog(null, "Please enter shape height between 50-600", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			shapeH = (Integer.parseInt(shapeHValue));
		}
		
		//check and set appW
		if (( appWValue.equals("")) || (Integer.parseInt(appWValue)>700) || (Integer.parseInt(appWValue)<150) ) {
			JOptionPane.showMessageDialog(null, "Please enter applet width between 150-700", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			appW = (Integer.parseInt(appWValue));
		}
		
		//check and set appH
		if ((appHValue.equals("")) || (Integer.parseInt(appHValue)>700) || (Integer.parseInt(appHValue)<100) ) {
			JOptionPane.showMessageDialog(null, "Please enter applet height between 100-700", "Error", JOptionPane.ERROR_MESSAGE);
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
		if (shape.equals("rect")) {
			buf.append("<input checked class=form-check-input type=radio name=shape id=shape value="+shape+">\n");
		} else {
			buf.append("<input class=form-check-input type=radio name=shape id=shape value=\"rect\">\n");
		}
		buf.append("<label class=form-check-label for=shape><img src=\"images/rect.gif\" alt=rectangle></label>\n");
		
		if (shape.equals("roundRect")) {
			buf.append("<input checked class=form-check-input type=radio name=shape id=shape value=\"roundRect\">\n");
		} else {
			buf.append("<input class=form-check-input type=radio name=shape id=shape value=\"roundRect\">\n");
		}
		buf.append("<label class=form-check-label for=shape><img src=\"images/rnd-rect.gif\" alt=\"rounded rectangle\"></label>\n");
		
		if (shape.equals("oval")) {
			buf.append("<input checked class=form-check-input type=radio name=shape id=shape value=\"oval\">\n");
		} else {
			buf.append("<input class=form-check-input type=radio name=shape id=shape value=\"oval\">\n");
		}
		buf.append("<label class=form-check-label for=shape><img src=\"images/oval.gif\" alt=oval></label></div>\n");
		
		
		
		//shape size
		buf.append("<br><br><div class=form-row>\n");
		buf.append("<div class=\"form-group col-md-3\">\n");
		buf.append("<label for=width >Width</label>\n");
		buf.append("<input type=text class=\"form-control form-control-sm\" id=shapeW name=shapeW value="+shapeW+" maxlength=3 ></div>\n");
		buf.append("<div class=\"form-group col-md-9 float-left\">\n");
		buf.append("<label for=heighth>Height</label>\n");
		buf.append("<input type=text class=\"form-control form-control-sm\" id=shapeH name=shapeH value="+shapeH+" maxlength=3 ></div></div><hr>\n");
		
		//message
		buf.append("<h4>Message</h4>\n");
		buf.append("<div class=form-group>\n");
		buf.append("<input type=text class=\"form-control form-control-sm\" id=message name=message aria-describedby=message value=\""+ message +"\" maxlength=20>\n");
		buf.append("<small id=message class=\"form-text text-muted\">Your message should not exceed 20 characters long</small></div><hr>\n");
		
		//font style
		buf.append("<h4>Font Style</h4>\n");
		buf.append("<div class=form-row>\n");
		buf.append("<div class=\"form-group col-md-6 \">\n");
		buf.append("<label>Font Style</label><br>\n");
		buf.append("<div class=\"form-check form-check-inline\">\n");

		if (fontStyleValues!=null) {
			if  (Arrays.asList(fontStyleValues).contains("bold")){
				buf.append("<input checked class=form-check-input type=checkbox name=fStyle id=bold value=\"bold\">\n");//bold font
			} else {
				buf.append("<input class=form-check-input type=checkbox name=fStyle id=bold value=\"bold\">\n");//bold font
			}
			buf.append("<label class=form-check-label for=bold><strong>Bold</strong></label></div>\n");
			buf.append("<div class=\"form-check form-check-inline\">\n");
			
			if  (Arrays.asList(fontStyleValues).contains("italic")) {
				buf.append("<input checked class=form-check-input type=checkbox name=fStyle id=italic value=\"italic\">\n");
			} else {
				buf.append("<input class=form-check-input type=checkbox name=fStyle id=italic value=\"italic\">\n");
			}
			buf.append("<label class=form-check-label for=italic><i>Italic</i></label>\n");//italic font
		} else {
			buf.append("<input class=form-check-input type=checkbox name=fStyle id=bold value=\"bold\">\n");//bold font
			buf.append("<label class=form-check-label for=bold><strong>Bold</strong></label></div>\n");
			buf.append("<div class=\"form-check form-check-inline\">\n");
			buf.append("<input class=form-check-input type=checkbox name=fStyle id=italic value=\"italic\">\n");
			buf.append("<label class=form-check-label for=italic><i>Italic</i></label>\n");//italic font
		}

		buf.append("</div></div></div>\n");
		buf.append("<div class=form-row>\n");
		buf.append("<div class=\"form-group col-md-4 col-lg-3\">\n");
		buf.append("<label for=font-size>Font Size</label>\n");
		buf.append("<select name=fontSize id=fontSize  class=\"custom-select custom-select-sm\" >\n"); 
		
		//font sizes dropdown
		if (fSize==8) {
               buf.append("<option selected value="+fSize+">8</option>\n");
        } else {
               buf.append("<option value="+fSize+">8</option>\n");
        }
		
		if (fSize==10) {
               buf.append("<option selected value="+fSize+">10</option>\n");
        } else {
               buf.append("<option value="+fSize+">10</option>\n");
        }
		
		if (fSize==12) {
               buf.append("<option selected value="+fSize+">12</option>\n");
        } else {
               buf.append("<option value="+fSize+">12</option>\n");
        }
	
	    if (fSize==14) {
               buf.append("<option selected value="+fSize+">14</option>\n");
        } else {
               buf.append("<option value="+fSize+">14</option>\n");
        }
		
		if (fSize==18) {
               buf.append("<option selected value="+fSize+">18</option>\n");
        } else {
               buf.append("<option value="+fSize+">18</option>\n");
        }
		
		if (fSize==24) {
               buf.append("<option selected value="+fSize+">24</option>\n");
        } else {
               buf.append("<option value="+fSize+">24</option>\n");
        }
		
		if (fSize==30) {
               buf.append("<option selected value="+fSize+">30</option>\n");
        } else {
               buf.append("<option value="+fSize+">30</option>\n");
        }
		
		if (fSize==36) {
               buf.append("<option selected value="+fSize+">36</option>\n");
        } else {
               buf.append("<option value="+fSize+">36</option>\n");
        }
		
		if (fSize==48) {
               buf.append("<option selected value="+fSize+">48</option>\n");
        } else {
               buf.append("<option value="+fSize+">48</option>\n");
        }
		
		if (fSize==60) {
               buf.append("<option selected value="+fSize+">60</option>\n");
        } else {
               buf.append("<option value="+fSize+">60</option>\n");
        }
		
		if (fSize==72) {
               buf.append("<option selected value="+fSize+">72</option>\n");
        } else {
               buf.append("<option value="+fSize+">72</option>\n");
        }
		buf.append("</select></div>\n");
		buf.append("<div class=\"form-group col-md-4\">\n");
		buf.append("<label for=font-color>Font Color</label>\n");
		buf.append("<select  name=fontColor id=fontColor  class=\"custom-select custom-select-sm \" >\n");//font color drop down
		
		//font color choices
		if (fontColorValue.equals("black")) {
               buf.append("<option selected value="+fontColorValue+">Black</option>\n");
        } else {
               buf.append("<option value="+fontColorValue+">Blaxk</option>\n");
        }
		
		if (fontColorValue.equals("white")) {
               buf.append("<option selected value="+fontColorValue+">White</option>\n");
        } else {
               buf.append("<option value="+fontColorValue+">White</option>\n");
        }
		
		if (fontColorValue.equals("blue")) {
               buf.append("<option selected value="+fontColorValue+">Blue</option>\n");
        } else {
               buf.append("<option value="+fontColorValue+">Blue</option>\n");
        }
		
		if (fontColorValue.equals("cyan")) {
               buf.append("<option selected value="+fontColorValue+">Cyan</option>\n");
        } else {
               buf.append("<option value="+fontColorValue+">Cyan</option>\n");
        }
		
		if (fontColorValue.equals("darkGray")) {
               buf.append("<option selected value="+fontColorValue+">Dark Gray</option>\n");
        } else {
               buf.append("<option value="+fontColorValue+">Dark Gray</option>\n");
        }
		
		if (fontColorValue.equals("gray")) {
               buf.append("<option selected value="+fontColorValue+">Gray</option>\n");
        } else {
               buf.append("<option value="+fontColorValue+">Gray</option>\n");
        }
		
		if (fontColorValue.equals("green")) {
               buf.append("<option selected value="+fontColorValue+">Green</option>\n");
        } else {
               buf.append("<option value="+fontColorValue+">Green</option>\n");
        }
		
		if (fontColorValue.equals("yellow")) {
               buf.append("<option selected value="+fontColorValue+">Yellow</option>\n");
        } else {
               buf.append("<option value="+fontColorValue+">Yellow</option>\n");
        }
		
	    if (fontColorValue.equals("lightGray")) {
               buf.append("<option selected value="+fontColorValue+">Light Gray</option>\n");
        } else {
               buf.append("<option value="+fontColorValue+">Light Gray</option>\n");
        }
		
		if (fontColorValue.equals("magenta")) {
               buf.append("<option selected value="+fontColorValue+">Magenta</option>\n");
        } else {
               buf.append("<option value="+fontColorValue+">Magenta</option>\n");
        }
		
		if (fontColorValue.equals("orange")) {
               buf.append("<option selected value="+fontColorValue+">Orange</option>\n");
        } else {
               buf.append("<option value="+fontColorValue+">Orange</option>\n");
        }
		
		if (fontColorValue.equals("pink")) {
               buf.append("<option selected value="+fontColorValue+">Pink</option>\n");
        } else {
               buf.append("<option value="+fontColorValue+">Pink</option>\n");
        }
		
		if (fontColorValue.equals("red")) {
               buf.append("<option selected value="+fontColorValue+"> Red</option>\n");
        } else {
               buf.append("<option value="+fontColorValue+"> Red</option>\n");
        }
	
		buf.append("</select></div></div><hr>\n");
		
		//Applet Style
		buf.append("<h4>Applet Style</h4>\n");
		buf.append("<div class=form-row>\n");
		buf.append("<div class=\"form-group col-md-3\">\n");
		buf.append("<label for=width >Width</label>\n");
		buf.append("<input type=text class=\"form-control form-control-sm\" name=appW id=appW maxlength=3 value="+appW +"></div>\n");//applet width
		buf.append("<div class=\"form-group col-md-3\">\n");
		buf.append("<label for=heighth>Height</label>\n");
		buf.append("<input type=text class=\"form-control form-control-sm\" name=appH id=appH maxlength=3 value="+appH+" ></div>\n");//applet height
		buf.append("<div class=\"form-group col-md-6\">\n");
		buf.append("<label for=background-color>Background Color</label><br>\n");
		buf.append("<select name=bgColor id=bgColor  class=\"custom-select custom-select-sm\" >\n");//applet background color dropdown
		
		//background color choices
			if (bgColorValue.equals("black")) {
               buf.append("<option selected value="+bgColorValue+">Black</option>\n");
        } else {
               buf.append("<option value="+bgColorValue+">Blaxk</option>\n");
        }
		
		if (bgColorValue.equals("white")) {
               buf.append("<option selected value="+bgColorValue+">White</option>\n");
        } else {
               buf.append("<option value="+bgColorValue+">White</option>\n");
        }
		
		if (bgColorValue.equals("blue")) {
               buf.append("<option selected value="+bgColorValue+">Blue</option>\n");
        } else {
               buf.append("<option value="+bgColorValue+">Blue</option>\n");
        }
		
		if (bgColorValue.equals("cyan")) {
               buf.append("<option selected value="+bgColorValue+">Cyan</option>\n");
        } else {
               buf.append("<option value="+bgColorValue+">Cyan</option>\n");
        }
		
		if (bgColorValue.equals("darkGray")) {
               buf.append("<option selected value="+bgColorValue+">Dark Gray</option>\n");
        } else {
               buf.append("<option value="+bgColorValue+">Dark Gray</option>\n");
        }
		
		if (bgColorValue.equals("gray")) {
               buf.append("<option selected value="+bgColorValue+">Gray</option>\n");
        } else {
               buf.append("<option value="+bgColorValue+">Gray</option>\n");
        }
		
		if (bgColorValue.equals("green")) {
               buf.append("<option selected value="+bgColorValue+">Green</option>\n");
        } else {
               buf.append("<option value="+bgColorValue+">Green</option>\n");
        }
		
		if (bgColorValue.equals("yellow")) {
               buf.append("<option selected value="+bgColorValue+">Yellow</option>\n");
        } else {
               buf.append("<option value="+bgColorValue+">Yellow</option>\n");
        }
		
	    if (bgColorValue.equals("lightGray")) {
               buf.append("<option selected value="+bgColorValue+">Light Gray</option>\n");
        } else {
               buf.append("<option value="+bgColorValue+">Light Gray</option>\n");
        }
		
		if (bgColorValue.equals("magenta")) {
               buf.append("<option selected value="+bgColorValue+">Magenta</option>\n");
        } else {
               buf.append("<option value="+bgColorValue+">Magenta</option>\n");
        }
		
		if (bgColorValue.equals("orange")) {
               buf.append("<option selected value="+bgColorValue+">Orange</option>\n");
        } else {
               buf.append("<option value="+bgColorValue+">Orange</option>\n");
        }
		
		if (bgColorValue.equals("pink")) {
               buf.append("<option selected value="+bgColorValue+">Pink</option>\n");
        } else {
               buf.append("<option value="+bgColorValue+">Pink</option>\n");
        }
		
		if (bgColorValue.equals("red")) {
               buf.append("<option selected value="+bgColorValue+"> Red</option>\n");
        } else {
               buf.append("<option value="+bgColorValue+"> Red</option>\n");
        }
	
		buf.append("</select></div></div><hr>\n");
		
		//alert message
		buf.append("<div class=\"alert text-center\" role=alert> verify that all your values are entered <br>before proceeding </div>\n");
		
		//create applet button
		buf.append("<div class=\"form-group text-center\">\n");
		buf.append("<input type=submit class=\"btn btn-primary\" value=\"Create Your Applet\"><br>\n");
		
		
		buf.append(" </div></form>\n");//form ends
		
		//applet input section ends---------------------------------------------
		buf.append("</td></tr></tbody></table></div>\n");
		//----------------------------------------------------------------------
		
		//*****************************************************************************************
		
		//applet output section starts------------------------------------------
		buf.append("<div class=\"col-md-9 text-center fixed-top\">\n");
		//----------------------------------------------------------------------
		buf.append("<applet code=\"InteractiveApplet/Applet\" width="+appW+" height="+appH+" >\n");//applet starts
		
		//Shape parameters
		buf.append("<param name=shape value="+shape+">\n");
		buf.append("<param name=shapeW value="+shapeW+">\n");
		buf.append("<param name=shapeH value="+shapeH+">\n");
		
		//message parameter
		buf.append("<param name=message value="+message+">\n");
		
		//font style parameters
		buf.append("<param name=fStyle   value="+fStyle+">\n");
		buf.append("<param name=fontSize value="+fSize+">\n");
		buf.append("<param name=fontCr value="+fontC+">\n");
		
		//applet parameters
		buf.append("<param name=appW value="+appW+">\n");
		buf.append("<param name=appH value="+appH+">\n");
		buf.append("<param name=bgC value="+bgC+">\n");
		
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