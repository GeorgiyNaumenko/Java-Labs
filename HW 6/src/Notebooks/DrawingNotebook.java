package Notebooks;

import java.util.ArrayList;

public class DrawingNotebook extends Notebook {

	DrawingNotebook(){
		
	}
	
	DrawingNotebook(Page[] pages_){
		int k = pages_.length;
		for(int i = 0; i < k; i ++) {
			addNewPage(pages_[i]);
		}
	}
	
	@Override
	void show() {
		String s = "";
		ArrayList <Page> pgs = getPages();
		int k = pgs.size();
		for(int i = 0; i < k; i ++) {
			s += pgs.get(i).getText() + System.lineSeparator();
		}
		System.out.println(s);
	}

	@Override
	void showPage(int Ind) {
		ArrayList <Page> pgs = getPages();
		System.out.println(pgs.get(Ind-1).getText());
	}

}
