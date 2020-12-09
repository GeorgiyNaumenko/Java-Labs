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
 * @author Науменко Георгій. Створено 09/12/2020
 * Класс, що виконує завантаження та вивантаження картинок
 * 
 */
public class ImageDistributor {

	/**
	 * Поля- стокові картинки та оброблені
	 */
	private ArrayList<BufferedImage> stock = null;
	private ArrayList<BufferedImage> processed = stock;
	
	/**
	 * Базовий конструктор
	 */
	ImageDistributor(){
		
	}
	
	/**
	 * Конструктор
	 * @param stock_ набір картинок типу BufferedImage
	 */
	ImageDistributor(ArrayList<BufferedImage> stock_){
		stock = stock_;
		processed = stock;
	}
	
	/**
	 * Конструктор
	 * @param directpath шлях до директорії
	 * @throws IOException
	 */
	ImageDistributor(String directpath) throws IOException{
		stock = this.input(directpath);
		processed = stock;
	}
	
	/**
	 * Метод, шо вигружає картинки з директорії
	 * @param directpath шлях до директорії
	 * @return коллекція картинок
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
	 * Метод, що вигружає картинки
	 * @param directpath шлях, куди вигрузити
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
	 * Метод, що надає доступ до стокових картинок
	 * @return стокові картинки
	 */
	public ArrayList<BufferedImage> getStock(){
		return stock;
	}
	
	/**
	 * Метод, що надає доступ до оброблених картинок
	 * @return оброблені картинки
	 */
	public ArrayList<BufferedImage> getProcessed(){
		return processed;
	}
	
	/**
	 * Метод, встановлює оброблені картинки
	 * @param processed_ коллекція оброблених картинок
	 */
	public void setProcessed(ArrayList<BufferedImage> processed_) {
		processed = processed_;
	}
}
