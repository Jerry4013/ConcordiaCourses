// -----------------------------------------------------
// Assignment 3
// Question:
// Written by: Jingchao Zhang, 40049474
// -----------------------------------------------------

/**
 * Name(s) and ID(s): Jingchao Zhang 40049474 <br>
 * COMP249 <br>
 * Assignment # 3 <br>
 * Due Date: Mar 16, 2018 <br>
 * Purpose: Read from 10 files with some article information, check their validity, and output proper files containing reference
 * information in 3 different format, IEEE, ACM, NJ.  
 */
package assignment.a3;

public class Article {
	
	private int serialNumber;
	private String authors;
	private String journal;
	private String title;
	private int year;
	private String volume;
	private int number;
	private String pages;
	private String keywords;
	private String doi;
	private String ISSN;
	private String month;
	
	public Article(){}
	public Article(int serialNumber, String authors, String journal, String title, int year, String volume, int number,
			String pages, String keywords, String doi, String iSSN, String month) {
		super();
		this.serialNumber = serialNumber;
		this.authors = authors;
		this.journal = journal;
		this.title = title;
		this.year = year;
		this.volume = volume;
		this.number = number;
		this.pages = pages;
		this.keywords = keywords;
		this.doi = doi;
		ISSN = iSSN;
		this.month = month;
	}
	
	public boolean hasEnoughInformation(){
		if( authors==null || title==null || journal==null || volume==null || pages==null || month==null || year==0 || doi==null)
			return false;
		return true;
	}
	
	public String generateIEEE() {
		if(!hasEnoughInformation()){
			System.out.println("Do not have enough information to generate an IEEE format.");
			System.exit(0);
		}
		return authors.replace(" and ", ", ") + ". \"" + title + "\", " + journal + ", vol. " + volume +
				", no. " + number + ", p. " + pages + ", " + month + " " + year + ".";
	}
	
	public String generateACM(){
		if(!hasEnoughInformation()){
			System.out.println("Do not have enough information to generate an ACM format.");
			System.exit(0);
		}
		return authors.substring(0, authors.indexOf(" and ")==-1?authors.length():authors.indexOf(" and ")) + " et al. " + year + ". " + title + ". " + 
				journal + ". " + volume + ", " + number + " (" + year + "), " + pages + ". DOI:https://doi.org/" + doi + ".";
	}
	
	public String generateNJ(){
		if(!hasEnoughInformation()){
			System.out.println("Do not have enough information to generate an ACM format.");
			System.exit(0);
		}
		return authors.replace("and", "&") + ". " + title + ". " + journal + ". " + volume + ", " + pages + "(" + year + ").";
	}
	
	
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public String getISSN() {
		return ISSN;
	}
	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	@Override
	public String toString() {
		return "Article [serialNumber=" + serialNumber + ", authors=" + authors + ", journal=" + journal + ", title="
				+ title + ", year=" + year + ", volume=" + volume + ", number=" + number + ", pages=" + pages
				+ ", keywords=" + keywords + ", doi=" + doi + ", ISSN=" + ISSN + ", month=" + month + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (ISSN == null) {
			if (other.ISSN != null)
				return false;
		} else if (!ISSN.equals(other.ISSN))
			return false;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (doi == null) {
			if (other.doi != null)
				return false;
		} else if (!doi.equals(other.doi))
			return false;
		if (journal == null) {
			if (other.journal != null)
				return false;
		} else if (!journal.equals(other.journal))
			return false;
		if (keywords == null) {
			if (other.keywords != null)
				return false;
		} else if (!keywords.equals(other.keywords))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (number != other.number)
			return false;
		if (pages == null) {
			if (other.pages != null)
				return false;
		} else if (!pages.equals(other.pages))
			return false;
		if (serialNumber != other.serialNumber)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
}
