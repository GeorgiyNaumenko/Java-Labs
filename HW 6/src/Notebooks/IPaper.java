package Notebooks;

public interface IPaper {

	void setFormat(String newFormat);
	
	boolean isEmpty();
	
	boolean hasSeparators();
	
	void createSeparators(String separatorType, double hor, double ver, String ori);
	
	void clearSeparators();
	
	void clean();
	
	int pageRange();
	
	void addText(String _text);
	
	String getText();
}
