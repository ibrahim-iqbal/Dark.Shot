package io.darkshot.app.model;

public class FeedModel {
	
	String original, landscape, photographer;
	
	
	public FeedModel ( String original , String landscape , String photographer ) {
		this.original = original;
		this.landscape = landscape;
		this.photographer = photographer;
	}
	
	public String getOriginal ( ) {
		return original;
	}
	
	public String getLandscape ( ) {
		return landscape;
	}
	
	public String getPhotographer ( ) {
		return photographer;
	}
}
