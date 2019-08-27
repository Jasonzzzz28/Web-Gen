package model;

public class TagElement implements Element{
	private String name;
	private boolean endtag;
	private Element cont;
	public String attrib; 
	public static int id=0;
	private int myid;
	public static boolean enableid; 
	
	public TagElement(String tagName, boolean endTag,Element content,String attributes) {
		this.name=tagName; 
		this.endtag =endTag;
		this.cont=content;
		if (attributes==null) { 
		  this.attrib="";
		}
		else {
			this.attrib=" "+attributes;
		}
		id++;
		this.myid=id;
	}
	public void setName(String input) {
		this.name=input;
	}
	public int getId() {
		return myid;
	}
	public String getStringId() {
		return name+myid;
	}
	public String getStartTag() {
		if (enableid) {
			return "<"+name+" id="+ '"'+ name+ myid+'"'+ attrib+">";
		}
		else {
			
			return "<"+name+attrib+">";
		}
	}
	public String getEndTag() {
		if (endtag) {
			return "<"+"/"+name+">";
		}
		else {
			return "";
		}
	}
	public void setAttributes(String attributes) {
		this.attrib= " "+attributes;
	}
	public static void resetIds() {
		id=0;
	}
	public static void enableId(boolean choice) {
		enableid=choice;
	}
	public String genHTML(int indentation) {
		
		if(cont!=null) { 
		   return helperInd(indentation)+this.getStartTag()+cont.genHTML(0)+this.getEndTag(); 
		}
		else {
			return helperInd(indentation)+this.getStartTag()+this.getEndTag();
		}
		//question content indentation? 
	}
	public static String helperInd(int ind){
		String re="";
		for (int i=0;i<ind;i++) {
			re+=" ";
		}
		return re;
	}

}
