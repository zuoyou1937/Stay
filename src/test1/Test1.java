package test1;

import org.opencv.core.*;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.highgui.HighGui;

public class Test1 {
	static {
		 System.loadLibrary("opencv_java341");   
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub   
	        Mat image=Imgcodecs.imread("D:\\Pic\\1.jpg");
	        Mat image_gray=image.clone();
	        Mat image_sobel=image.clone();
	        Mat image_threshold=image.clone();
	        /**
	         * f �Ҷȴ���
	         */
	        Imgproc.cvtColor(image,image_gray,Imgproc.COLOR_RGB2GRAY);
	        
	        /**
	         * f ��˹�˲�
	         */
	        Imgproc.GaussianBlur(image_gray, image_gray, new Size(5,5), 0);
	        
	        /**
	         * ddepth:Ŀ��ͼ�����ɫ���
	         * dx:��x�����Ľ���
	         * dy:��y�����Ľ���
	         * ksize���˴�С1��3��5��7
	         * delta�����ӵ�����Ŀ�ѡ��ֵ
	         * borderType:�����ڲ巽��
	         **/
	        Imgproc.Sobel(image_gray, image_sobel, CvType.CV_8U, 1, 0, 3, 1, 1,Core.BORDER_DEFAULT);
	        
	        /**
	         * f otsu�㷨����ֵ��
	         */
	        Imgproc.threshold(image_sobel,image_threshold,0,255,Imgproc.THRESH_BINARY+Imgproc.THRESH_OTSU);
	        
	        //Imgproc.findContours();
	        Mat element=Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(17,3));
	        
	        Imgcodecs.imwrite("D:\\Pic\\new\\image_threshold.jpg", image_threshold);
	        Imgcodecs.imwrite("D:\\Pic\\new\\image_sobel.jpg", image_sobel);
	        Imgcodecs.imwrite("D:\\Pic\\new\\image_gray.jpg",image_gray);
	}

}
