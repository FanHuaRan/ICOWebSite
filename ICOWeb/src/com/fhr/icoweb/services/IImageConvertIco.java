package com.fhr.icoweb.services;

import java.awt.Image;
import java.io.File;
/**
 * 图片转换ICO业务接口
 * @author fhr
 * @date 2017/05/25 
 */
public interface IImageConvertIco {
	/**
	 * 将image转换为16,32,64,128位的ico,返回ico的文件夹file
	 * @param image
	 * @return
	 */
	File convertToIco(Image image);
	/**
	 * 将image转换为指定size的ico,返回该图片的文件file
	 * @param image
	 * @param size
	 * @return
	 */
	File convertToIco(Image image,int size);
}
