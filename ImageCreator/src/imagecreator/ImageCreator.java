package imagecreator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;

/**
 * 
 * @author �������� ������. �������� 09/12/2020
 * �����, ��'���� ����� ��������� �������� �� ����������� �� ������ �����
 * 
 */
public class ImageCreator extends Thread{

	/**
	 * ����, �� ��������� �������� ��� ������� �� �� ���
	 */
	private BufferedImage image = null;
	private int type;
	
	/**
	 * �������� ������� �������
	 * @param x ��������
	 * @return �������� �������-������� � ����� x
	 */
	private static float sigmoid(double x) {
		return (float) (1 /( 1 + (Math.exp(-x))));
	}
	
	/**
	 * �����������
	 * @param _image ��������
	 */
	ImageCreator(BufferedImage _image){
		image = _image;
		type = _image.getType();
	}
	
	/**
	 * �����, �� ������� ������ �������� ��'����
	 * @return ��������
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * �����, �� ����� ����� ��������
	 * @param width ������ ���� ��������
	 * @param height ������ ���� ��������
	 * @return �������� � ������� �������
	 */
	public BufferedImage changeSize(int width, int height) {
		BufferedImage resizedImage = new BufferedImage(width, height, this.type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(this.image, 0, 0, width, height, null);
		g.dispose();
		return resizedImage;
	}

	/**
	 * �����, �� ������� �����-��� ��������
	 * @return �����-��� ��������
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
	 * �����, �� ������� �� �������� ������ ��������
	 * @return �������� � ������� ��������
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
	 * �����, �� ���� �� �������� ��������� �����: ��������, ����� �������� ��������� �� ������ �����.
	 * ��� ����� ���� ��������� ������, ����������� �����, �� ����� ��������� ������� RGB.
	 * �����, ����� ��� ������� ������ � ���� ��������� � ��� ������� col1 = (r1, g1, b1) �� col2 = (r2, g2, b2).
	 * ���������� 2 ������������ c1 �� c2 � ������ [0, 1], c1 + c2 = 1 (��� ��� � ������� �������).
	 * ���, ��������� ������ �� ���� ���� ������� �������� col = c1*col1 + c2*col2.
	 * @param other ��������, ��� ������
	 * @param coef �����������
	 * @return ���� ��������
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
	 * ������������ ������� �� �������� - �������� ��������� �������-������� �� ���� ������������.
	 * @param r ����������� ������ R
	 * @param g ����������� ������ G
	 * @param b ����������� ������ B
	 * @return �������� � ��������
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
	 * �������� �����, �� ���� �� �������� ����, ������� �� ����� ������� ������ ����� �� ������.
	 * �������� ��� ���� �� ��������� ��� ���������� ���������.
	 * @param other ��������, ��� ������
	 * @param coef1 ����������� ���������� ����� ��������
	 * @param coef2 ����������� ���������� ����� ��������
	 * @param x_bias ���� ������
	 * @param y_bias ���� �����
	 * @return ���� ��������
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
	 * �����, �� �������� ������ ���������� ��������� (������ 3D).
	 * ���� ������ � ����, �� �������� �����-��� �������� �� ����������� �� �� ��ﳿ.
	 * � ������ - ��������� ������ G �� B �� ������� �� �� ������� ������ ����.
	 * � ����� - ��������� ����� R �� ������� �� �� ������� ������ ������.
	 * ��� ��������� ��� ���� �� ���� �����-��� �������� - �������� ������ ��� 3D.
	 * @return �������� � 3D ��������
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
