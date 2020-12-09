package imagecreator;

import java.awt.image.BufferedImage;


/**
 * 
 * @author Науменко Георгій. Створено 09/12/2020
 * Класс, об'єкти якого зберігають картинки та варіанти їх обробки
 * В потоках ци картинки обробляються за допомогою классу ImageCreator
 * 
 */
public class ImageProcessor extends Thread {
	
	/**
	 * Поля классу. Зберігають саму картинку, розміри, до яких зводиться та картинку, що до всіх буде додана.
	 * Також, зберігають усі наступні варіанти обробки: 4 різних фільтри, картинку з 3д єффектом (хроматична абберація),
	 * сума двох картинок, картинка з ефетом негативу, чорно-біла картинка.
	 */
	private int newWidth, newHeight;
	private ImageCreator image;
	private BufferedImage resizedImage;
	private BufferedImage blackwhite;
	private BufferedImage image3D;
	private BufferedImage filter1;
	private BufferedImage filter2;
	private BufferedImage filter3;
	private BufferedImage filter4;
	private BufferedImage sum;
	private BufferedImage to_sum;
	private BufferedImage negativeImage;

	/**
	 * Базовий конструктор
	 */
	ImageProcessor(){
		newWidth = 0;
		newHeight = 0;
	}
	
	/**
	 * Конструктор
	 * @param image_ базова картинка типу BufferedImage
	 * @param width ширина нової картинки
	 * @param height висота нової картинки
	 */
	ImageProcessor(BufferedImage image_, int width, int height){
		image = new ImageCreator(image_);
		newWidth = width;
		newHeight = height;
	}
	
	/**
	 * Конструктор
	 * @param image_ базова картинка типу ImageCreator
	 * @param width ширина нової картинки
	 * @param height висота нової картинки
	 */
	ImageProcessor(ImageCreator image_, int width, int height){
		image = image_;
		newWidth = width;
		newHeight = height;
	}
	
	/**
	 * Метод, що встановлює картинку для додавання
	 * @param image_ картинка
	 */
	public void setSumImage(BufferedImage image_) {
		to_sum = image_;
	}

	/**
	 * Перевизначення методу run() для багатопотокової обробки
	 */
	@Override
	public void run() {
		resizedImage = image.changeSize(newWidth, newHeight);
		blackwhite = image.black_white();
		image3D = image.effect3D();
		negativeImage = image.negative();
		filter1 = image.filter(1, 0, 0);
		filter2 = image.filter(0, 1, 0);
		filter3 = image.filter(0, 0, 1);
		filter4 = image.filter(0.3, 0.5, 0.2);
		sum = image.add(to_sum, 0.7);
	}
	
	/**
	 * Метод, що повертє базову картинку
	 * @return базова картинка
	 */
	BufferedImage getImage() {
		return image.getImage();
	}
	
	/**
	 * Поветрає чорно-білу картинку
	 * @return чорно-біла картинка
	 */
	BufferedImage getBlackWhite() {
		return blackwhite;
	}
	
	/**
	 * Поветрає картинку з еффектом негативу
	 * @return картинка з еффектом негативу
	 */
	BufferedImage getNegative() {
		return negativeImage;
	}
	
	/**
	 * Поветрає картинку з еффектом хроматичної абберації
	 * @return картинка з еффектом 3д
	 */
	BufferedImage get3D() {
		return image3D;
	}
	
	/**
	 * Поветрає картинку з першим фільтром
	 * @return чорно-біла картинка з першим фільтром
	 */
	BufferedImage getF1() {
		return filter1;
	}
	
	/**
	 * Поветрає картинку з другим фільтром
	 * @return чорно-біла картинка з другим фільтром
	 */
	BufferedImage getF2() {
		return filter2;
	}
	
	/**
	 * Поветрає картинку з третім фільтром
	 * @return чорно-біла картинка з третім фільтром
	 */
	BufferedImage getF3() {
		return filter3;
	}
	
	/**
	 * Поветрає картинку з четвертим фільтром
	 * @return чорно-біла картинка з четвертим фільтром
	 */
	BufferedImage getF4() {
		return filter4;
	}
	
	/**
	 * Поветрає суму картинок
	 * @return сума картинок
	 */
	BufferedImage getSum() {
		return sum;
	}
	
	/**
	 * Поветрає картинку заданого розміру
	 * @return картинка зі зміненим розміром
	 */
	BufferedImage getResized() {
		return resizedImage;
	}
}
