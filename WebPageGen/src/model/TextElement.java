package model;

public class TextElement implements Element {
	private String Text;
	
	public TextElement(String text) {
		this.Text=text;
		
	}
	
	public String genHTML(int indentation) {
		return TagElement.helperInd(indentation)+this.Text;
	}
	

}
