package com.fhr.icoweb.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import net.sf.image4j.codec.ico.ICOEncoder;
/**
 * 图片工具辅助类
 * @author fhr
 * @date 2017/05/21 
 */
public class ImageUtil {
	/**
	 * 指定宽高来压缩图片    图片会扁
	 * @param originImg
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	 public static Image compressPhoto (Image originImg,int newWidth,int newHeight){
       Image newImg = new BufferedImage(newWidth, newHeight,BufferedImage.TYPE_INT_RGB);
       newImg.getGraphics().drawImage(originImg.getScaledInstance(newWidth, newHeight,Image.SCALE_SMOOTH), 0, 0, null);
       return newImg;
     }
	 /**
	  * 指定宽度压缩图片
	  * @param originImg
	  * @param newWidth
	  * @return
	  */
	 public static Image compressPhotoByWidth(Image originImg,int newWidth){
       int oldWidth = originImg.getWidth(null);//得到文件原始宽度
       int oldHeight = originImg.getHeight(null);//得到文件原始高度
       double scale_w = (double) newWidth / oldWidth;
       int newHeight = (int) (oldHeight * scale_w);
       return compressPhoto(originImg, newWidth, newHeight);
	 }
	 /**
	  * 指定高度压缩图片
	  * @param originImg
	  * @param newWidth
	  * @return
	  */
	 public static Image compressPhotoByHeight(Image originImg,int newHeight){
       int oldWidth = originImg.getWidth(null);//得到文件原始宽度
       int oldHeight = originImg.getHeight(null);//得到文件原始高度
       double scale_h = (double) newHeight / oldHeight;
       int newWidth = (int) (oldWidth * scale_h);
       return compressPhoto(originImg, newWidth, newHeight);
	 }
	 /**
	  * 指定比例压缩图片
	  * @param originImg
	  * @param scale
	  * @return
	  */
	 public static Image compressPhotoByScale(Image originImg,float scale){
	   int oldWidth = originImg.getWidth(null);//得到文件原始宽度
	   int oldHeight = originImg.getHeight(null);//得到文件原始高度
	   int newWidth=(int) (oldWidth*scale);
	   int newHeight = (int) (oldHeight * scale);
	   return compressPhoto(originImg, newWidth, newHeight);
	 }
	/**
	 * 指定宽度和高度生成ico
	 * @param orginImg
	 * @param width
	 * @param height
	 * @param outPutFileName
	 * @return
	 */
	public static boolean convertImgToIco(Image orginImg, int width, int height, String outPutFileName) {
		Image newImg = compressPhoto(orginImg, width, height);
		try {
			ICOEncoder.write((BufferedImage) newImg, new File(outPutFileName));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 指定宽度生成ico
	 * @param orginImg
	 * @param width
	 * @param outPutFileName
	 * @return
	 */
	public static boolean convertImgToIcoByWidth(Image orginImg, int width, String outPutFileName) {
		Image newImg = compressPhotoByWidth(orginImg, width);
		try {
			ICOEncoder.write((BufferedImage) newImg, new File(outPutFileName));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 指定高度生成ico
	 * @param orginImg
	 * @param height
	 * @param outPutFileName
	 * @return
	 */
	public static boolean convertImgToIcoByHeight(Image orginImg, int height, String outPutFileName) {
		Image newImg = compressPhotoByHeight(orginImg, height);
		try {
			ICOEncoder.write((BufferedImage) newImg, new File(outPutFileName));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 指定比例生成ico
	 * @param orginImg
	 * @param scale
	 * @param outPutFileName
	 * @return
	 */
	public static boolean convertImgToIcoByScale(Image orginImg, float scale, String outPutFileName) {
		Image newImg = compressPhotoByScale(orginImg, scale);
		try {
			ICOEncoder.write((BufferedImage) newImg, new File(outPutFileName));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
