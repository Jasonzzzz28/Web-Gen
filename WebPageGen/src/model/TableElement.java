package model;



public class TableElement extends TagElement {
	private int row;
	private int col;
	private Element[][]tablecont;
	public TableElement(int rows, int cols, String attributes){
     
		super("table", true, null, attributes);
		
		this.row=rows;this.col=cols;
		this.tablecont=new Element[rows][cols];
		
	}
	
	public void addItem(int rowIndex,int colIndex,Element item) {
		this.tablecont[rowIndex][colIndex]= item;
	}
	
	
	public String genHTML(int indentation) {
		String re="";
		for (int i=0; i<tablecont.length;i++) {
			re+="\n"+super.helperInd(indentation+3)+"<tr>";
			for (int k=0; k< tablecont[i].length;k++) {
			     re+="<td>"+((tablecont[i][k]==null)? "": tablecont[i][k].genHTML(0))+"</td>";
			} 
			re+="</tr>";
		}
		return super.helperInd(indentation)+super.getStartTag()+re+"\n"+super.helperInd(indentation)+super.getEndTag();
	}

	public double getTableUtilization() {
		int count=0;
		
		for (int i=0; i<tablecont.length;i++) {
			for (int k=0; k< tablecont[i].length;k++) {
				if (tablecont[i][k]!=null) {
					count++;
				}
			}
		}
		
		return 100*count/(row*col);
		
	}
}
