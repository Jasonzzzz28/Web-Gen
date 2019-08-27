package model;

import java.util.ArrayList;

public class ParagraphElement extends TagElement{
	private ArrayList <Element> Content;
	public ParagraphElement(String attributes) {
		
		super ("p",true,null,attributes);
		this.Content=new ArrayList<Element>();
	}
	
	public void addItem(Element item) {
		this.Content.add(item);//question: add more than one Element ?
	}
	
	public String genHTML(int indentation) {
		String re="";
		for (Element i: Content) {
			re+="\n"+super.helperInd(indentation+3)+i.genHTML(0);
		}
		
		return super.helperInd(indentation)+super.getStartTag()+re+"\n"+super.helperInd(indentation)+super.getEndTag();
	}
	
	

}
