package aufgabe4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import aufgabe4.Ctcomments.Entry;
import aufgabe4.Recipe;

public class Main {
	
	private static String xmlPath;
	private static String xmlFile;
	private static Recipe recipe;
	private static JAXBContext jc;
	

	/**
	 * Main
	 * @param args
	 * @throws JAXBException
	 * @throws IOException
	 */
	public static void main(String[] args) throws JAXBException, IOException{
		
		selectXml();
		selectOptions();
	}
	
	/**
	 * Verzeichnis zu den XML Dateien von Aufgabe 3 abfragen und auflisten.
	 * Durch Eingabe in der Console wird eine XML Datei ausgewählt.
	 * @throws JAXBException
	 * @throws IOException
	 */
	public static void selectXml() throws JAXBException, IOException{
		// Verzeichnis auslesen
		File path = new File("src/aufgabe3");
		int j=0;
		List<String> fileList = new ArrayList<String>();
		for (int i = 0; i < path.list().length; i++) {
			String currentFile = path.list()[i];
			if(currentFile.endsWith(".xml")) {
				fileList.add(currentFile);
				System.out.println(++j+": "+path.list()[i]);
			}
		}
		// Auswahlmenü		
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("XML-Datei wählen (Mit '0' Programm beenden):");
			int auswahl = in.nextInt();
			in.nextLine();
			if (auswahl == 0) {
				System.out.println("Programm beendet");
				System.exit(0);
			}
			if (auswahl <= fileList.size() && auswahl > 0) {
				xmlFile = fileList.get(auswahl-1);
				xmlPath = path+"/"+xmlFile;
				jc = JAXBContext.newInstance(Recipe.class);
				unmarshal();
				break;
			} else {
				System.out.println("Ungültige Eingabe!");
			}	
		}
	}
	
	/**
	 * Menü
	 * @throws JAXBException
	 * @throws IOException
	 */
	public static void selectOptions() throws JAXBException, IOException {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("1: Rezept lesen");
			System.out.println("2: Kommentar verfassen");
			System.out.println("3: XML-Dokument auswählen");
			System.out.println("4: Programm beenden");
			int auswahl = in.nextInt();
			if (auswahl == 4) {
				System.out.println("Programm beendet");
				System.exit(0);
			}
			switch (auswahl) {
			case 1:
				outputXml();
				break;
			case 2:
				writeComment();
				break;
			case 3:
				selectXml();
				break;
			default:
				System.out.println("Ungültige Eingabe");
			}
		}		
	}
	
	/**
	 * Methode zum Schreiben eines Kommentars
	 * @throws JAXBException
	 * @throws IOException
	 */
	private static void writeComment() throws JAXBException, IOException{
		
		Scanner in = new Scanner(System.in);
		
		Entry entry = new Entry();
		
		// Letzte Kommentar ID abfragen falls vorhanden und diese um 1 hochzählen.
		int id = 1;
		if(recipe.getComments().getEntry().size() != 0) {
			 id = recipe.getComments().getEntry().get(
				recipe.getComments().getEntry().size()-1).getId().intValue()+1;
		}
		entry.setId(BigInteger.valueOf(id));
		
		System.out.println("Name eingeben: ");
		String inputName = in.nextLine();
		entry.setAuthor(inputName);
		
		// Datum und Uhrzeit
		GregorianCalendar gCalendar = new GregorianCalendar();
		Date currentDate = new Date();
		gCalendar.setTime(currentDate);
		XMLGregorianCalendar xmlCalendar = null;
		try {
			xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
			} catch (DatatypeConfigurationException ex) {
		}
		entry.setDate(xmlCalendar);
		
		System.out.println("Kommentar eingeben: ");	
		String inputComment = in.nextLine();
		entry.setText(inputComment);
	 
		recipe.getComments().getEntry().add(entry);
		System.out.println(inputComment);
		
		//XML Dokument erzeugen und mit dem alten XML Dokument überschreiben
		marshall();
		System.out.println();
		System.out.println("Kommentar gespeichert!");
	}

	/**
	 * Ausgabe der Daten
	 */
	private static void outputXml() {
		
		// Für die Datumsausgabe in den Kommentaren
		SimpleDateFormat df = new SimpleDateFormat ("dd.MM.yyyy HH:mm");	
		
		System.out.println("Rezept: "+recipe.getTitle());
		System.out.println("");
		
		if(recipe.getPicture().size() != 0) {
			System.out.println("Bilder: ");
			for (int i = 0; i < recipe.getPicture().size(); i++) {
				System.out.println(recipe.getPicture().get(i));
			}
			System.out.println("");
		}
		
		System.out.println("Zutaten:");
	    for (int i = 0; i < recipe.getIngredient().size(); i++) {
	    	
	    	System.out.println(recipe.getIngredient().get(i).getAmount()+" "
	    			+((recipe.getIngredient().get(i).getUnit() != null) ? 
	    					recipe.getIngredient().get(i).getUnit()+" " :"")
	    			+recipe.getIngredient().get(i).getName());
	    }
	    System.out.println("");
	    System.out.println("Zubereitung:");
	    System.out.println("Arbeitsaufwand: "+recipe.getPreparation().getPreptime().getValue()+" "
	    		+recipe.getPreparation().getPreptime().getUnit()+" | "
	    		+"Schwierigkeitsgrad: "+recipe.getPreparation().getDifficulty()+" | "
	    		+"Brennwert: "+recipe.getPreparation().getCalvalue()+" kcal");
	    System.out.println(recipe.getPreparation().getText());
	    System.out.println();
	    System.out.println("Kommentare: ");
	    
	    if(recipe.getComments().getEntry().size() != 0) {
	    	for (int i = 0; i < recipe.getComments().getEntry().size(); i++) {
	    		Date d = recipe.getComments().getEntry().get(i).getDate().toGregorianCalendar().getTime();
	    		System.out.println(recipe.getComments().getEntry().get(i).getAuthor()
	    	    		+" am "+df.format(d)+" Uhr");
	    	    System.out.println(""+recipe.getComments().getEntry().get(i).getText()+"");
	    	    System.out.println();
	    	}
	    }
	}
	
	/**
	 * Methode um ein XML Dokument einzulesen und diese in Java Objekten umwandeln
	 * @throws JAXBException
	 * @throws IOException
	 */
	private static void unmarshal() throws JAXBException, IOException{
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		InputStream inputStream = new FileInputStream(xmlPath);
		Reader reader = new InputStreamReader(inputStream,"UTF-8");
	    
	    try {
	    	recipe = (Recipe) unmarshaller.unmarshal(reader);
	    } finally {
	    	reader.close();
	    }
	}
	
	/**
	 * Methode um aus Java Objekten ein XML Dokument zu erstellen
	 */	
	private static void marshall() throws JAXBException{
		
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty("jaxb.schemaLocation", "http://example.org/Rezept Rezept.xsd");
		marshaller.marshal(recipe, new File(xmlPath));
	}

}
