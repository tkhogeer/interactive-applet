package interactiveApplet;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class interactiveApplet extends HttpServlet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//default values
	String shape="RECT";
	int shapeW = 100;
	int shapeH = 60;
	String message = "Type Message";
	String fstyle = "PLAIN";
	int fsize = 14;
	Color fontC= Color.black;
	int appletW = 300;
	int appletH = 150;
	Color bgC=Color.pink;
	
	String[] shapes = {"OVAL", "RECT", "ROUNDRECT"};
	String[] colors = {"black", "blue", "cyan", "darkGray", "gray", "green", "lightGray", "magenta", "orange", "pink", "red", "white", "yellow"};
	String[] styles = {"BOLD", "ITALIC"};


	

}
