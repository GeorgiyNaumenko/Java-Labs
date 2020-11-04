package Notebooks;

public class Page implements IPaper {

	private String material = "";
	private String format = "";
	private String sepOrient = null;
	private String separator = null;
	private double horizontalRange = 0, verticalRange = 0;
	private String text = "";
	private int range = 0;
	
	Page(){
		
	}
	
	Page(int _range, String _format){
		range = _range;
		format = _format;
	}

	@Override
	public void setFormat(String newFormat) {
		format = newFormat;
	}

	@Override
	public boolean isEmpty() {
		return text == "";
	}

	@Override
	public boolean hasSeparators() {
		if (separator.equals(null)) {
			return false;
		}
		return true;
	}

	@Override
	public void createSeparators(String separatorType, double hor, double ver, String ori) {
		separator = separatorType;
		horizontalRange = hor;
		verticalRange = ver;
		sepOrient = ori;
	}

	@Override
	public void clearSeparators() {
		sepOrient = null;
		separator = null;
		horizontalRange = 0;
		verticalRange = 0;
	}

	@Override
	public void clean() {
		text = "";
	}

	@Override
	public int pageRange() {
		return range;
	}

	@Override
	public void addText(String _text) {
		text += _text;
	}

	@Override
	public String getText() {
		return text;
	}
}
