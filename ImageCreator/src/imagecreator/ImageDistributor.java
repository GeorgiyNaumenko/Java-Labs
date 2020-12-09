package imagecreator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * 
 * @author �������� ������. �������� 09/12/2020
 * �����, �� ������ ������������ �� ������������ ��������
 * 
 */
public class ImageDistributor {

	/**
	 * ����- ������ �������� �� ��������
	 */
	private ArrayList<BufferedImage> stock = null;
	private ArrayList<BufferedImage> processed = stock;
	
	/**
	 * ������� �����������
	 */
	ImageDistributor(){
		
	}
	
	/**
	 * �����������
	 * @param stock_ ���� �������� ���� BufferedImage
	 */
	ImageDistributor(ArrayList<BufferedImage> stock_){
		stock = stock_;
		processed = stock;
	}
	
	/**
	 * �����������
	 * @param directpath ���� �� ��������
	 * @throws IOException
	 */
	ImageDistributor(String directpath) throws IOException{
		stock = this.input(directpath);
		processed = stock;
	}
	
	/**
	 * �����, �� ������� �������� � ��������
	 * @param directpath ���� �� ��������
	 * @return ��������� ��������
	 * @throws IOException
	 */
	public ArrayList<BufferedImage> input(String directpath) throws IOException {
		ArrayList<BufferedImage> pics = new ArrayList<>();
		File f = new File(directpath);
		String[] names = f.list();
		File file;
		String filepath = "";
		for (int i = 0; i < names.length; i++) {
			filepath = directpath + "\\" + names[i];
			file = new File(filepath);
			BufferedImage image = ImageIO.read(file);
			pics.add(image);
		}
		return pics;
	}
	
	/**
	 * �����, �� ������� ��������
	 * @param directpath ����, ���� ���������
	 * @throws IOException
	 */
	public void output(String directpath) throws IOException {
		if(!Files.exists(Paths.get(directpath))) {
			Files.createDirectory(Paths.get(directpath));
		}
		File out;
		for (int i = 0; i < processed.size(); i++) {
			out = new File(directpath + "\\processed" + Integer.toString(i) + ".jpg");
			ImageIO.write(processed.get(i), "jpg", out);
		}
	}
	
	/**
	 * �����, �� ���� ������ �� �������� ��������
	 * @return ������ ��������
	 */
	public ArrayList<BufferedImage> getStock(){
		return stock;
	}
	
	/**
	 * �����, �� ���� ������ �� ���������� ��������
	 * @return �������� ��������
	 */
	public ArrayList<BufferedImage> getProcessed(){
		return processed;
	}
	
	/**
	 * �����, ���������� �������� ��������
	 * @param processed_ ��������� ���������� ��������
	 */
	public void setProcessed(ArrayList<BufferedImage> processed_) {
		processed = processed_;
	}
}
