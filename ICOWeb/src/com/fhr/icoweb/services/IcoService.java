package com.fhr.icoweb.services;

import java.awt.Image;
import java.io.File;
/**
 * 图片转换ICO业务接口
 * @author fhr
 * @date 2017/05/25 
 */
public interface IcoService {
	/**
	 * 将image转换为16,32,64,128位的ico,
	 * 返回ico的文件夹file null则代表保存出错
	 * @param image
	 * @return
	 */
	File convertToIco(Image image,String uuid);
	/**
	 * 将image转换为指定size的ico,
	 * 返回该图片的文件file null则代表保存出错
	 * @param image
	 * @param size
	 * @return 
	 */
	File convertToIco(Image image,int size,String uuid);
	/**
	 * 获取ico的字节 单个
	 * @param uuid
	 * @return
	 */
	byte[] getBytesFromSingleIco(String uuid);
	/**
	 * 获取ico压缩包字节
	 * @param uuid
	 * @return
	 */
	byte[] getBytesFromIcoZip(String uuid);
}
