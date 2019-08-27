package model;

public class ImageElement extends TagElement {
	private String url;
	
	public ImageElement(String imageURL, int width, int height,String alt, String attributes) {
		super("img",false,null,"src="+ '"'+imageURL+'"'+ " "+ "width="+ '"'+ width+ '"'
				+ " "+"height="+ '"'+ height+'"'+" "+ "alt="+ '"'+alt+ '"'+ " "+ attributes);
		if (attributes ==null) {
			super.setAttributes("src="+ '"'+imageURL+'"'+ " "+ "width="+ '"'+ width+ '"'
				+ " "+"height="+ '"'+ height+'"'+" "+ "alt="+ '"'+alt+ '"');
		}
		this.url=imageURL;
		
	}
	
	public String getImageURL() {
		return this.url;
	}
	

}
