package model;


public class AnchorElement extends TagElement {

	private String URL;
	private String linktext;
	
	
	public AnchorElement (String url, String linkText, String attributes) {
		
		super("a",true,new TextElement(linkText)," "+"href=" +'"'+url+ '"'+ attributes);
		this.URL=url;
		this.linktext=linkText;
		if (attributes==null) {
			super.setAttributes(" "+"href="+ '"'+url+'"');
		}
		
		
	}
	public String getLinkText() {
		return linktext; 
	}
	public String getUrlText() {
		return URL;
	}
	
	public String genHTML(int indentation) {
		return  super.genHTML(indentation);
	}
}
