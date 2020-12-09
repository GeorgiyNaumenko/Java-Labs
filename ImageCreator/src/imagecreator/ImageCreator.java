package imagecreator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;

/**
 * 
 * @author Науменко Георгій. Створено 09/12/2020
 * Класс, об'єкти якого зберігають картинку та оброобляють її певним чином
 * 
 */
public class ImageCreator extends Thread{

	/**
	 * Поля, що зберігають картинку для обробки та її тип
	 */
	private BufferedImage image = null;
	private int type;
	
	/**
	 * Статична функція сигмоїда
	 * @param x аргумент
	 * @return значення функції-сигмоїди в точці x
	 */
	private static float sigmoid(double x) {
		return (float) (1 /( 1 + (Math.exp(-x))));
	}
	
	/**
	 * Конструктор
	 * @param _image картинка
	 */
	ImageCreator(BufferedImage _image){
		image = _image;
		type = _image.getType();
	}
	
	/**
	 * Метод, що повертає власну картинку об'єкту
	 * @return картинка
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * Метод, що змінює розмір картинки
	 * @param width ширина нової картинки
	 * @param height висота нової картинки
	 * @return картинка зі зміненим розміром
	 */
	public BufferedImage changeSize(int width, int height) {
		BufferedImage resizedImage = new BufferedImage(width, height, this.type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(this.image, 0, 0, width, height, null);
		g.dispose();
		return resizedImage;
	}

	/**
	 * Метод, що створює чорно-білу картинку
	 * @return чорно-біла картинка
	 */
	public BufferedImage black_white() {
		int x = image.getWidth();
		int y = image.getHeight();
		Color current;
		BufferedImage blackwhiteImage = new BufferedImage(x, y, image.getType());
		for(int x_i = 0; x_i < x; x_i++) {
			for (int y_j = 0; y_j < y; y_j++) {
				current = new Color(image.getRGB(x_i, y_j));
				int currentBlue = current.getBlue();
                int currentRed = current.getRed();
                int currentGreen = current.getGreen();
                int blue = (int) ((int) currentBlue*0.114 + currentRed*0.299 + currentGreen*0.587);
                int red = blue;
                int green = red;
                Color newColor = new Color(red, green, blue);
                blackwhiteImage.setRGB(x_i, y_j, newColor.getRGB());
			} 
		}
		return blackwhiteImage;
	}
	
	/**
	 * Метод, що накладає на картинку еффект негативу
	 * @return картинка з ефектом негативу
	 */
	public BufferedImage negative() {
		int x = image.getWidth();
		int y = image.getHeight();
		Color current;
		BufferedImage negativeImage = new BufferedImage(x, y, image.getType());
		for(int x_i = 0; x_i < x; x_i++) {
			for (int y_j = 0; y_j < y; y_j++) {
				current = new Color(image.getRGB(x_i, y_j));
				int currentBlue = current.getBlue();
                int currentRed = current.getRed();
                int currentGreen = current.getGreen();
                int blue = 255 - currentBlue;
                int red = 255 - currentRed;
                int green = 255 - currentGreen;
                Color newColor = new Color(red, green, blue);
                negativeImage.setRGB(x_i, y_j, newColor.getRGB());
			} 
		}
		return negativeImage;
	}
	
	/**
	 * Метод, що додає дві картинки наступним чином: Спочатку, друга картинка нормується до розміру першої.
	 * Для кожноі пари відповідних пікселів, створюється новий, як лінійна комбінація векторів RGB.
	 * Тобто, нехай для якогось пікселя в двох картинках є два вектори col1 = (r1, g1, b1) та col2 = (r2, g2, b2).
	 * Обераэться 2 коеффіцієнти c1 та c2 з відрізка [0, 1], c1 + c2 = 1 (тут нам і потрібна сигмоїда).
	 * Тоді, відповідний піксель їх суми буде заданий вектором col = c1*col1 + c2*col2.
	 * @param other картинка, яку додаємо
	 * @param coef коеффіцієнт
	 * @return сума картинок
	 */
	public BufferedImage add(BufferedImage other, double coef){
		int x = image.getWidth();
		int y = image.getHeight();
		ImageCreator im = new ImageCreator(other);
		BufferedImage image1 = im.changeSize(x, y);
		Color current;
		Color current1;
		float coef1 = sigmoid(coef);
		float coef2 = 1 - coef1;
		BufferedImage newImage = new BufferedImage(x, y, image.getType());
		for(int x_i = 0; x_i < x; x_i++) {
			for (int y_j = 0; y_j < y; y_j++) {
				current = new Color(image.getRGB(x_i, y_j));
				current1 = new Color(image1.getRGB(x_i, y_j));
				int currentBlue = current.getBlue();
                int currentRed = current.getRed();
                int currentGreen = current.getGreen();
                int currentBlue1 = current1.getBlue();
                int currentRed1 = current1.getRed();
                int currentGreen1 = current1.getGreen();
                int blue = (int) (currentBlue * coef1 + currentBlue1 * coef2);
                int red = (int) (currentRed * coef1 + currentRed1 * coef2);
                int green = (int) (currentGreen * coef1 + currentGreen1 * coef2);
                Color newColor = new Color(red, green, blue);
                newImage.setRGB(x_i, y_j, newColor.getRGB());
			} 
		}
		return newImage;
	}
	
	/**
	 * Застосування фільтру до картинки - множення компонент вектору-кольору на деякі коеффіцієнти.
	 * @param r коеффіцієнт каналу R
	 * @param g коеффіцієнт каналу G
	 * @param b коеффіцієнт каналу B
	 * @return картинку з фільтром
	 */
	public BufferedImage filter(double r, double g, double b) {
		int x = image.getWidth();
		int y = image.getHeight();
		Color current;
		BufferedImage filtered = new BufferedImage(x, y, image.getType());
		for(int x_i = 0; x_i < x; x_i++) {
			for (int y_j = 0; y_j < y; y_j++) {
				current = new Color(image.getRGB(x_i, y_j));
				int currentBlue = current.getBlue();
                int currentRed = current.getRed();
                int currentGreen = current.getGreen();
                int blue = (int) ((int) currentBlue*b);
                int red = (int) ((int) currentRed*r);
                int green = (int) ((int) currentGreen*g);
                Color newColor = new Color(red, green, blue);
                filtered.setRGB(x_i, y_j, newColor.getRGB());
			} 
		}
		return filtered;
	}
	
	/**
	 * Приватне метод, що додає до картинки іншу, зсунуту на деяку кількість пікселів вверх та вправо.
	 * Потрібний тут лише як допоміжний для хроматичної абберації.
	 * @param other картинка, яку додаємо
	 * @param coef1 коеффіцієнт присутності першої картинки
	 * @param coef2 коеффіцієнт присутності другої картинки
	 * @param x_bias зсув вправо
	 * @param y_bias зсув вверх
	 * @return сума картинок
	 */
	private BufferedImage addWithBias(BufferedImage other, double coef1, double coef2, int x_bias, int y_bias) {
		int x = image.getWidth();
		int y = image.getHeight();
		ImageCreator im = new ImageCreator(other);
		BufferedImage image1 = im.changeSize(x, y);
		Color current;
		Color current1;
		BufferedImage newImage = new BufferedImage(x - x_bias, y - y_bias, image.getType());
		for(int x_i = 0; x_i < x - x_bias; x_i++) {
			for (int y_j = 0; y_j < y - y_bias; y_j++) {
				current = new Color(image.getRGB(x_i + x_bias, y_j));
				current1 = new Color(image1.getRGB(x_i, y_j + y_bias));
				int currentBlue = current.getBlue();
                int currentRed = current.getRed();
                int currentGreen = current.getGreen();
                int currentBlue1 = current1.getBlue();
                int currentRed1 = current1.getRed();
                int currentGreen1 = current1.getGreen();
                int blue = Math.min(255, (int) (currentBlue * coef1 + currentBlue1 * coef2));
                int red = Math.min(255, (int) (currentRed * coef1 + currentRed1 * coef2));
                int green = Math.min(255, (int) (currentGreen * coef1 + currentGreen1 * coef2));
                Color newColor = new Color(red, green, blue);
                newImage.setRGB(x_i, y_j, newColor.getRGB());
			} 
		}
		return newImage;
	}
	
	/**
	 * Метод, що реалізовує еффект хроматичної абберації (еффект 3D).
	 * Ідея полягає в тому, шо береться чорно-біла картинка та створюються дві її копії.
	 * В першій - відключаємо канали G та B та зсуваємо її на декілька пікселів вліво.
	 * В другій - відключаємо канал R та зсуваємо її на декілька пікселів вправо.
	 * При накладанні цих копій та самої чорно-білої картинки - отримаємо еффект для 3D.
	 * @return картинка з 3D еффектом
	 */
	public BufferedImage effect3D() {
		BufferedImage chb = this.black_white();
		ImageCreator im = new ImageCreator(chb);
		BufferedImage filtered2 = im.filter(0, 1, 1);
		BufferedImage filtered1 = im.filter(1, 0, 0);
		ImageCreator im1 = new ImageCreator(filtered1);
		BufferedImage res1 = im1.addWithBias(chb, 1, 1, 16, 0);
		ImageCreator im2 = new ImageCreator(res1);
		BufferedImage result = im2.addWithBias(filtered2, 1, 1, 16, 0);
		return result;
	}
}
