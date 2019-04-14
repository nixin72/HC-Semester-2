package pDumaresq_B20_A03_MusicSystem;


public class Song {
	private int year;
	private int rank;
	private int downloads;
	private String artist;
	private String songTitle;
	
	public Song() {
		year = 0;
		rank = 0;
		downloads = 0;
		artist = "unknown";
		songTitle = "unknown";
	}
	
	public Song(int y, int r, int d, String a, String t) {
		year = y;
		rank = r;
		downloads = d;
		artist = a;
		songTitle = t;
	}
	
	//Mutator methods
	public void setYear(int y) {
		year = y;
	}
	public void setRank(int r) {
		rank = r;
	}
	public void setDownloads(int d) {
		downloads = d;
	}
	public void setArtist(String a) {
		artist = a;
	}
	public void setTitle(String t) {
		songTitle = t;
	}
	
	//Accessor methods
	public int getYear() {
		return year;
	}
	public int getRank() {
		return rank;
	}
	public int getDownloads() {
		return downloads;
	}
	public String getArtist() {
		return artist;
	}
	public String getTitle() {
		return songTitle;
	}
}
