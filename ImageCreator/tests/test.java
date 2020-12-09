package imagecreator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class test {

	public static void main(String[] args) throws IOException{
		
		ImageDistributor imageDistributor = new ImageDistributor("D:\\Eclipse Workspace\\ImageCreator\\recources");
		File file = new File("D:\\Eclipse Workspace\\ImageCreator\\recources\\Naruto & Saske.jpg");
		BufferedImage img = ImageIO.read(file);
		
		ArrayList<BufferedImage> images = imageDistributor.getStock();
		ArrayList<BufferedImage> filters1 = new ArrayList<>();
		ArrayList<BufferedImage> filters2 = new ArrayList<>();
		ArrayList<BufferedImage> filters3 = new ArrayList<>();
		ArrayList<BufferedImage> filters4 = new ArrayList<>();
		ArrayList<BufferedImage> images3D = new ArrayList<>();
		ArrayList<BufferedImage> blackwhites = new ArrayList<>();
		ArrayList<BufferedImage> resizedImages = new ArrayList<>();
		ArrayList<BufferedImage> negativeImages = new ArrayList<>();
		ArrayList<BufferedImage> sums = new ArrayList<>();
		
		ArrayList<ImageProcessor> processors = new ArrayList<>();
		
		for (int i = 0; i < images.size(); i++) {
			ImageProcessor current = new ImageProcessor(images.get(i), 300, 300);
			current.setSumImage(img);
			current.start();
			processors.add(current);
		}
		
		for (int i = 0; i < processors.size(); i++) {
			try {
				processors.get(i).join();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < processors.size(); i++) {
			filters1.add(processors.get(i).getF1());
			imageDistributor.setProcessed(filters1);
			imageDistributor.output("D:\\Eclipse Workspace\\ImageCreator\\tests\\filters1");
			
			filters2.add(processors.get(i).getF2());
			imageDistributor.setProcessed(filters2);
			imageDistributor.output("D:\\Eclipse Workspace\\ImageCreator\\tests\\filters2");
			
			filters3.add(processors.get(i).getF3());
			imageDistributor.setProcessed(filters3);
			imageDistributor.output("D:\\Eclipse Workspace\\ImageCreator\\tests\\filters3");
			
			filters4.add(processors.get(i).getF4());
			imageDistributor.setProcessed(filters4);
			imageDistributor.output("D:\\Eclipse Workspace\\ImageCreator\\tests\\filters4");
			
			images3D.add(processors.get(i).get3D());
			imageDistributor.setProcessed(images3D);
			imageDistributor.output("D:\\Eclipse Workspace\\ImageCreator\\tests\\images3D");
			
			blackwhites.add(processors.get(i).getBlackWhite());
			imageDistributor.setProcessed(blackwhites);
			imageDistributor.output("D:\\Eclipse Workspace\\ImageCreator\\tests\\blackwhites");
			
			resizedImages.add(processors.get(i).getResized());
			imageDistributor.setProcessed(resizedImages);
			imageDistributor.output("D:\\Eclipse Workspace\\ImageCreator\\tests\\resizedImages");
			
			negativeImages.add(processors.get(i).getNegative());
			imageDistributor.setProcessed(negativeImages);
			imageDistributor.output("D:\\Eclipse Workspace\\ImageCreator\\tests\\negativeImages");
			
			sums.add(processors.get(i).getSum());
			imageDistributor.setProcessed(sums);
			imageDistributor.output("D:\\Eclipse Workspace\\ImageCreator\\tests\\sums");
		}
	}
}
