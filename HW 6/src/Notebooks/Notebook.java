package Notebooks;
import java.util.ArrayList;

public abstract class Notebook {

	private ArrayList <Page> pages = new ArrayList<>();
	
	void addNewPage(Page page) {
		pages.add(page);
	}
	
	Page getPage(int ind) {
		return pages.get(ind-1);
	}
	
	abstract void show();
	
	abstract void showPage(int Ind);
	
	ArrayList <Page> getPages(){
		return pages;
	}
	
	void deletePage(int num) {
		pages.remove(num);
	}
	
	void deletePage(Page page) {
		pages.remove(page);
	}
	
	void clear() {
		pages.clear();
	}
	
	void isEmpty() {
		pages.isEmpty();
	}
}
