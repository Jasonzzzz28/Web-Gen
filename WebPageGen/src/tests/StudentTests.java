package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AnchorElement;
import model.HeadingElement;
import model.ImageElement;
import model.ListElement;
import model.ParagraphElement;
import model.TableElement;
import model.TagElement;
import model.TextElement;
import model.WebPage;

public class StudentTests {

	@Test
	public void TextElementTest() {
		int indentation = 6;
		String answer = "";
		
		TagElement.resetIds();
		TagElement.enableId(false);
		TextElement element = new TextElement("Hello");
		answer = element.genHTML(indentation);
	
		answer += "\nSecond Element\n";
		element = new TextElement("I'm from Mars");
		answer += element.genHTML(indentation);

		answer += "\nThird Element\n";
		indentation = 6;
		element = new TextElement("I'm here to colonize Earth");
		answer += element.genHTML(indentation);
		
		

		assertTrue(TestsSupport.isCorrect("StuTextTest", answer));
	}
	
	@Test
	public void ImageElementTest() {
		int indentation = 5;
		String answer = "", attributes = null, alt = "Movie Image";
		int width = 250, height = 138;
		
		TagElement.resetIds();
		TagElement.enableId(true);
		ImageElement element = new ImageElement("deadpool.jpg", width, height, alt, attributes);
		answer += element.genHTML(indentation);
		answer += "\nSecondElement\n";
		
		indentation = 8;
		element = new ImageElement("wolverine.jpg", 238, 145, alt, attributes);
		answer += element.genHTML(indentation);
		
		
		
		assertTrue(TestsSupport.isCorrect("StuImgTest", answer));
	}
	
	@Test
	public void pubAnchorElementTest1() {
		int indentation = 3;
		String answer = "", attributes = null;
		
		TagElement.resetIds();
		TagElement.enableId(false);
		AnchorElement element = new AnchorElement("https://www.youtube.com/watch?v=4tdnehO0G6A", "MyVideo", attributes);
		answer += element.genHTML(indentation);
		answer += "\nSecondElement\n";
		
		
		indentation = 9;
		element = new AnchorElement("http://www.google.com", "GOOGLE", attributes);;
		answer += element.genHTML(indentation);
		
		
		assertTrue(TestsSupport.isCorrect("StuAnchTest", answer));
	}
	
	@Test
	public void HeadingElementTest() {
		int indentation = 6, level = 3;
		String answer = "";
		String attributes = null;
		
		TagElement.resetIds();
		TagElement.enableId(true);
		HeadingElement element = new HeadingElement(new TextElement("HelloWorld!"), level, attributes);
		answer = element.genHTML(indentation);
		
		
		assertTrue(TestsSupport.isCorrect("StuHeadTest", answer));
	}
	
	@Test
	public void ParagraphElementTest() {
		int indentation = 4;
		String answer = "", attributes = null;
		
		TagElement.resetIds();
		TagElement.enableId(true);
		ParagraphElement element = new ParagraphElement(attributes);
		
		element.addItem(new ImageElement("A dog.jpg", 35, 48, "Dog Image", attributes));
		element.addItem(new TextElement("Hi, I'm a dog"));
		
		answer += element.genHTML(indentation);
		answer += "\nSecondElement\n";
		
		TagElement.enableId(false);
		indentation = 7;
		attributes = "style=no color";
		ParagraphElement element2 = new ParagraphElement(attributes);
		element2.addItem(new TextElement("Fear the turtle"));
		element2.addItem(new ImageElement("A cat.jpg", 55, 66, "Cat Image", null));
		answer += element2.genHTML(indentation);
		
		
		
		assertTrue(TestsSupport.isCorrect("StuParaTest", answer));
	}
	
	@Test
	public void TableElementTest() {
		int indentation = 3;
		String attributes = "Table=pronoun", answer = "";
		
		TagElement.resetIds();
		TagElement.enableId(true);
		TableElement tableElement = new TableElement(3, 3, attributes);
		tableElement.addItem(2, 0, new TextElement("You"));
		tableElement.addItem(0, 2, new TextElement("Him"));
		tableElement.addItem(1, 0, new TextElement("Her"));
		tableElement.addItem(0, 0, new TextElement("Me"));
		answer += tableElement.genHTML(indentation);
		
		
		assertTrue(TestsSupport.isCorrect("StuTabTest", answer));
	}
	
	@Test
	public void ListElementTest() {
		int indentation = 8;
		String answer = "", attributes = null;
		
		boolean orderedList = false;
		TagElement.resetIds();
		TagElement.enableId(true);
		ListElement element = new ListElement(orderedList, attributes);
		element.addItem(new HeadingElement(new TextElement("HelloWorld!"), 2, attributes));
		element.addItem(new AnchorElement("https://submit.cs.umd.edu", "Submit", attributes));
		element.addItem(new TextElement("Hello!"));
		answer += element.genHTML(indentation);
		answer += "\nSecondElement\n";
	
		
		indentation = 6;
		orderedList = true;
		attributes = "ordered";
		ListElement element2 = new ListElement(orderedList, attributes);
		element2.addItem(new TextElement("Deadpool"));
		element2.addItem(new TextElement("IronMan"));
		answer += element2.genHTML(indentation);
		
		
	
		assertTrue(TestsSupport.isCorrect("StuListTest", answer));
	}
	
	
	@Test
	public void WebPageTest() {
		WebPage webPage = new WebPage("Example1");
		int indentation = 3;
		String answer = "";
		
		TagElement.resetIds();
		TagElement.enableId(false);
		webPage.addElement(new HeadingElement(new TextElement("Test"), 1, null));
		ParagraphElement paragraph = new ParagraphElement(null);
		paragraph.addItem(new TextElement("This is a picture!"));
		paragraph.addItem(new ImageElement("pciture.jpg", 500, 500, "Picture Image", ""));
		paragraph.addItem(new TextElement("End of this picture!"));
		webPage.addElement(paragraph);

		answer += webPage.getWebPageHTML(indentation);
		
		assertTrue(TestsSupport.isCorrect("StuWebTest", answer));
	}

}
