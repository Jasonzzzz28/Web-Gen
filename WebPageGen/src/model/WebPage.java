package model;

import java.util.ArrayList;

public class WebPage implements Comparable<WebPage> {
	private String webtitle; 
	private ArrayList<Element>webcont;
	public WebPage(String title) {
		this.webtitle=title;
		this.webcont=new ArrayList<Element>();
	}
	
	public int addElement(Element element) {
		this.webcont.add(element);
       
		if (element.getClass().toString().equals("class model.TextElement")) {
			return -1;
		}
		else {
			TagElement t= (TagElement)element;
			return t.getId();
		}
		
	}
	public String getWebPageHTML(int indentation) {
		String re="";
		for (Element n: webcont) {
			re+="\n"+n.genHTML(indentation);
		}
	
		return "<!doctype html>\n<html>\n"+TagElement.helperInd(indentation)+"<head lang=\"en\">\n"+
		TagElement.helperInd(indentation+3)+"<meta charset=\"utf-8\"/>\n"+TagElement.helperInd(indentation+3)
		+"<title>"+webtitle+"</title>\n"+TagElement.helperInd(indentation)+"</head>"+"\n"+
		TagElement.helperInd(indentation)+"<body>"+re+"\n"+ TagElement.helperInd(indentation)+"</body>\n"+"</html>";
	}

	public void writeToFile(String filename,int indentation) {
		Utilities.writeToFile(filename, this.getWebPageHTML(indentation));
	}
	
	public Element findElem(int id) {
		int count=0;
		int pos=0;
		for (Element i: webcont) {
			if (!i.getClass().toString().equals("class model.TextElement")) {
				TagElement te=(TagElement)i;
				if(te.getId()==id) {
					pos=count;
				}
				else {
					count++;
				}
			}
			else {
				count++;
			}
		}
		return webcont.get(pos);
	}	
	
	public String stats() {
		int Noflist=0;
		int Nofpara=0;
		int Noftab=0;
		double tableper=0;
		for (Element i: webcont) {
			if(i.getClass().toString().equals("class model.ListElement")) {
				Noflist++;
			}
			if(i.getClass().toString().equals("class model.ParagraphElement")) {
				Nofpara++;
			}
			if(i.getClass().toString().equals("class model.TableElement")) {
				Noftab++;
				TableElement tb=(TableElement)i;
				tableper += tb.getTableUtilization();
			}
		
		}
		
		return "List Count: "+Noflist+ "\nParagraph Count: "+Nofpara+"\nTable Count: "+Noftab+
				(Noftab==0?"":"\nTableElement Utilization: "+tableper/Noftab);
	}
	
	public int compareTo(WebPage webPage) {
		return this.getWebPageHTML(0).compareTo(webPage.getWebPageHTML(0));
	}
	public static void enableId(boolean choice) {
		TagElement.enableId(choice);
	}
}
