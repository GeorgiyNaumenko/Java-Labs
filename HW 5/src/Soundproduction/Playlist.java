package Soundproduction;
import java.util.ArrayList;

public class Playlist {

	private ArrayList <Audiotrack> playlist = new ArrayList<>();
	private int playlistLength = 0;
	private double playlistTime = 0;
	
	Playlist(){
		
	}
	
	Playlist(ArrayList <Audiotrack> _playlist){
		playlist = _playlist;
		playlistTime = 0;
		playlistLength = playlist.size();
		for(int i = 0; i < playlistLength; i ++) {
			playlistTime += playlist.get(i).length();
		}
	}
	
	Playlist(Audiotrack[] _playlist){
		ArrayList <Audiotrack> pl = new ArrayList<>();
		int k = _playlist.length;
		for(int i = 0; i < k; i ++) {
			pl.add(_playlist[i]);
		}
		playlist = pl;
		playlistTime = 0;
		playlistLength = playlist.size();
		for(int i = 0; i < playlistLength; i ++) {
			playlistTime += playlist.get(i).length();
		}
	}
	
	protected void updateByGanres(){
		ArrayList <String> genres = new ArrayList<>();
		for(int i = 0; i < playlistLength; i ++) {
			if (!genres.contains(playlist.get(i).getGenre())) {
				genres.add(playlist.get(i).getGenre());
			}
		}
		int k = genres.size();
		ArrayList <Audiotrack> updated = new ArrayList<>();
		for(int i = 0; i < k; i ++) {
			for(int j = 0; j < playlistLength; j ++) {
				if(genres.get(i) == playlist.get(j).getGenre()) {
					updated.add(playlist.get(j));
				}
			}
		}
		playlist = updated;
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < playlistLength; i ++) {
			if (i != playlistLength - 1) {
				s += playlist.get(i).toString() + ", ";
			}
			else {
				s += playlist.get(i).toString();
			}
		}
		return s;
	}
	
	protected void add(Audiotrack _new) {
		if (!playlist.contains(_new)) {
			playlist.add(_new);
			playlistLength ++;
			playlistTime += _new.length();
		}
	}
		
	protected void addWithUpdate(Audiotrack _new) {
			if (!playlist.contains(_new)) {
			playlist.add(_new);
			playlistLength ++;
			playlistTime += _new.length();
			updateByGanres();
		}
		
	}
	
	protected ArrayList <Audiotrack> getPlaylist(){
		return playlist;
	}
	
	protected double getTime() {
		return playlistTime;
	}
	
	
}
