package Soundproduction;

public class Audio {

	private int bitrate = 0;
	private int sampleRate = 0;
	private int bitDepth = 0;
	private String[] formats = {"wav", "flac", "aiff", "mp3", "ogg", "ape"};
	private boolean stereo = false, mono = true;
	private String type = "";
	
	private double len = 0;
	private double size = 0;
	
	Audio(){
		
	}
	
	Audio(int _bitrate, int _sampleRate, int _bitDepth, int canals, int _type){
		bitrate = _bitrate;
		sampleRate = _sampleRate;
		bitDepth = _bitDepth;
		if (canals == 1) {
			stereo = false;
			mono = true;
		}
		else {
			stereo = false;
			mono = true;
		}
		type = formats[_type-1];
	}
	
	Audio(int _bitrate, int _sampleRate, int _bitDepth, int canals, int _type, double _len){
		bitrate = _bitrate;
		sampleRate = _sampleRate;
		bitDepth = _bitDepth;
		if (canals == 1) {
			stereo = false;
			mono = true;
		}
		else {
			stereo = false;
			mono = true;
		}
		type = formats[_type-1];
		len = _len;
		size = canals * (len * sampleRate * bitDepth + bitrate * len / 1000);
	}
	
	protected int getBitrate() {
		return bitrate;
	}
	
	protected int getSampleRate() {
		return sampleRate;
	}
	
	protected int getBitDepth() {
		return bitDepth;
	}
	
	protected String getType() {
		return type;
	}
	
	protected boolean isMono() {
		return mono;
	}
	
	protected boolean isStereo() {
		return stereo;
	}
	
	protected double getSize() {
		return size;
	}
	
	protected double length() {
		return len;
	}
}
