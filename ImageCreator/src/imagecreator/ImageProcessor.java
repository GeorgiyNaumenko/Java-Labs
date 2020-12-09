package imagecreator;

import java.awt.image.BufferedImage;


/**
 * 
 * @author �������� ������. �������� 09/12/2020
 * �����, ��'���� ����� ��������� �������� �� ������� �� �������
 * � ������� �� �������� ������������ �� ��������� ������ ImageCreator
 * 
 */
public class ImageProcessor extends Thread {
	
	/**
	 * ���� ������. ��������� ���� ��������, ������, �� ���� ��������� �� ��������, �� �� ��� ���� ������.
	 * �����, ��������� �� ������� ������� �������: 4 ����� �������, �������� � 3� �������� (���������� ���������),
	 * ���� ���� ��������, �������� � ������ ��������, �����-��� ��������.
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
	 * ������� �����������
	 */
	ImageProcessor(){
		newWidth = 0;
		newHeight = 0;
	}
	
	/**
	 * �����������
	 * @param image_ ������ �������� ���� BufferedImage
	 * @param width ������ ���� ��������
	 * @param height ������ ���� ��������
	 */
	ImageProcessor(BufferedImage image_, int width, int height){
		image = new ImageCreator(image_);
		newWidth = width;
		newHeight = height;
	}
	
	/**
	 * �����������
	 * @param image_ ������ �������� ���� ImageCreator
	 * @param width ������ ���� ��������
	 * @param height ������ ���� ��������
	 */
	ImageProcessor(ImageCreator image_, int width, int height){
		image = image_;
		newWidth = width;
		newHeight = height;
	}
	
	/**
	 * �����, �� ���������� �������� ��� ���������
	 * @param image_ ��������
	 */
	public void setSumImage(BufferedImage image_) {
		to_sum = image_;
	}

	/**
	 * �������������� ������ run() ��� �������������� �������
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
	 * �����, �� ������ ������ ��������
	 * @return ������ ��������
	 */
	BufferedImage getImage() {
		return image.getImage();
	}
	
	/**
	 * ������� �����-��� ��������
	 * @return �����-��� ��������
	 */
	BufferedImage getBlackWhite() {
		return blackwhite;
	}
	
	/**
	 * ������� �������� � �������� ��������
	 * @return �������� � �������� ��������
	 */
	BufferedImage getNegative() {
		return negativeImage;
	}
	
	/**
	 * ������� �������� � �������� ���������� ���������
	 * @return �������� � �������� 3�
	 */
	BufferedImage get3D() {
		return image3D;
	}
	
	/**
	 * ������� �������� � ������ ��������
	 * @return �����-��� �������� � ������ ��������
	 */
	BufferedImage getF1() {
		return filter1;
	}
	
	/**
	 * ������� �������� � ������ ��������
	 * @return �����-��� �������� � ������ ��������
	 */
	BufferedImage getF2() {
		return filter2;
	}
	
	/**
	 * ������� �������� � ����� ��������
	 * @return �����-��� �������� � ����� ��������
	 */
	BufferedImage getF3() {
		return filter3;
	}
	
	/**
	 * ������� �������� � ��������� ��������
	 * @return �����-��� �������� � ��������� ��������
	 */
	BufferedImage getF4() {
		return filter4;
	}
	
	/**
	 * ������� ���� ��������
	 * @return ���� ��������
	 */
	BufferedImage getSum() {
		return sum;
	}
	
	/**
	 * ������� �������� �������� ������
	 * @return �������� � ������� �������
	 */
	BufferedImage getResized() {
		return resizedImage;
	}
}
