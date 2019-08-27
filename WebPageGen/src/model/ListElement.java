package model;

import java.util.ArrayList;

public class ListElement extends TagElement {
	private ArrayList<Element>Item;
	
	public ListElement(boolean ordered, String attributes) {
		
		super("ul",true, null, attributes);
		if (ordered) {
			super.setName("ol");
		}
		this.Item=new ArrayList<Element>();
	}
    
	public void addItem(Element item) {
		this.Item.add(item);
	}
	
	public String genHTML(int indentation) {
		
		String re="";
		for (Element i: Item) {
			re+="\n"+super.helperInd(indentation+3)+"<li>"+"\n"
			+ super.helperInd(indentation+6)+i.genHTML(0)+"\n"+super.helperInd(indentation+3)
			+ "</li>";
		}
		
		
		return super.helperInd(indentation)+super.getStartTag()+re+"\n"+super.helperInd(indentation)+super.getEndTag();
	}
}	
