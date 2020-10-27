package Soundproduction;

public class Audiotrack extends Audio {

	@SuppressWarnings("unused")
	private String name = "", year = "", album = "", artist = "";
	private String genre = "";
	@SuppressWarnings("unused")
	private String playlist = "";
	
	Audiotrack(){
		super();
	}
	
	Audiotrack(int _bitrate, int _sampleRate, int _bitDepth, int canals, int _type, String _artist, 
			String _name, String _album, String _year, String _genre, String _playlist){
		super(_bitrate, _sampleRate, _bitDepth, canals, _type);
		
		name = _name;
		year = _year;
		artist = _artist;
		album = _album;
		genre = _genre;
		playlist = _playlist;
	}
	
	Audiotrack(int _bitrate, int _sampleRate, int _bitDepth, int canals, int _type, double _len, 
			String _artist, String _name, String _album, String _year, String _genre, String _playlist){
		super(_bitrate, _sampleRate, _bitDepth, canals, _type, _len);
		
		name = _name;
		year = _year;
		artist = _artist;
		album = _album;
		genre = _genre;
		playlist = _playlist;
	}
	
	public String toString() {
		String s = artist + " - " + name + "." + getType();
		return s;
	}
	
	protected String getGenre() {
		return genre;
	}
	
}
