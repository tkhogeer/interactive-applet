package InteractiveApplet;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;
import javax.swing.JApplet;

public class Applet extends JApplet{
			
	public void paint(Graphics g) {
		String message=getParameter("message");
		String shape=getParameter("shape");
		String fontColorValue=getParameter("fontC");
		String bgColorValue=getParameter("bgC");
		String shapeWidth=getParameter("shapeW");
		String shapeHeight=getParameter("shapeH");
		String fStyle=getParameter("fStyle");
		String fontSize=getParameter("fSize");
		String appWidth=getParameter("appW");
		String appHeight=getParameter("appH");

		//parse integers
		int fSize = Integer.parseInt(fontSize);
		int appW = Integer.parseInt(appWidth);
		int appH = Integer.parseInt(appHeight);
		int shapeW = Integer.parseInt(shapeWidth);
		int shapeH = Integer.parseInt(shapeHeight);
				
		
		Color fontC= Color.black;
		Color bgC = Color.white;
		Font font = new Font( "Serif", Font.PLAIN, 14 );
		String errors = "";
		
		

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
		if (fStyle==null) {
			font = new Font( "Serif", Font.PLAIN, fSize );
		} else if (fStyle.equals("bold")) {
			font = new Font( "Serif", Font.BOLD , fSize );
		} else if (fStyle.equals("italic")) {
			font = new Font( "Serif", Font.ITALIC, fSize );
		} else {
			font = new Font( "Serif", Font.BOLD + Font.ITALIC, fSize );
		}


		g.setColor(bgC);
		g.fillRect(0, 0, appW, appH);
		g.setColor(fontC);
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics();
		if ((fm.getHeight()>=shapeH) || (fm.stringWidth(message)>=shapeW)){
			fSize=14;
			errors+="Font too large";
			if (fStyle==null) {
				font = new Font( "Serif", Font.PLAIN, fSize );
			} else if (fStyle.equals("bold")) {
				font = new Font( "Serif", Font.BOLD , fSize );
			} else if (fStyle.equals("italic")) {
				font = new Font( "Serif", Font.ITALIC, fSize );
			} else {
				font = new Font( "Serif", Font.BOLD + Font.ITALIC, fSize );
			}
		}
		
		g.setFont(font);
		
		//font metrics
		FontMetrics f = g.getFontMetrics();
		
		//draw shape
		if (shape.equals("rect")) {
			g.drawRect((appW-shapeW)/2,(appH-shapeH)/2,appW,appH);
		}
		else if (shape.equals("roundRect")) {
			g.drawRoundRect((appW-shapeW)/2,(appH-shapeH)/2,appW,appH, 20, 20);
		}
		else if (shape.equals("oval")) {
			g.drawOval((appW-shapeW)/2,(appH-shapeH)/2,appW,appH);
		}
		
		//write message
		int fmx = (appW-appW)/2 + (appW - f.stringWidth(message)) / 2;
		int fmy = (appH-shapeH)/2 + ((appH - f.getHeight()) / 2) + f.getAscent();
		g.drawString(message, fmx, fmy);
		
		//write errors
		g.setFont( new Font( "Serif", Font.PLAIN, 14 ) );
		g.drawString(errors, 10, 15);
	}

}
