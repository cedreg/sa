package orderprocessing;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class POHandler extends DefaultHandler {
	private boolean isPrice = false;
	private StringBuffer buf = null;

  public void startElement(String uri, String name, String qName, Attributes attrs) {
    if (qName.equals("po:price")) {
    	buf = new StringBuffer();
    	isPrice = true;
    }
  }

  public void endElement (String uri, String name, String qName){
    if (qName.equals ("po:price")) {
    	System.out.println(buf.toString());
    	isPrice = false;
    }
  }

  public void characters (char ch[], int start, int length){
    if(isPrice) {
	    for (int i = start; i < start + length; i++) {
		      buf.append(ch[i]);
		    }
    }
  }

public static void main (String args[])
        throws Exception {
   SAXParserFactory factory = SAXParserFactory.newInstance();
   SAXParser saxParser = factory.newSAXParser();
   DefaultHandler handler = new POHandler();
   
   // Parse each file provided on the command line.
   for (int i = 0; i < args.length; i++) {
      saxParser.parse( new File(args[i]), handler ); 
   }
 }

}
