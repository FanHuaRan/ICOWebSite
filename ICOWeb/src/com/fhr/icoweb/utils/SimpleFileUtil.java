package com.fhr.icoweb.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;
/**
 * 文件操作辅助类
 *
 */
public class SimpleFileUtil {
	
	//创建目录
	public static void mkDir(String path)
	{
		File file = new File(path);
		if (!file.isDirectory())
			file.mkdirs();
	}
	/**
	 * 获取文件扩展名
	 * @param filename
	 * @return
	 * @author fhr 2017/05/21
	 */
	public static String getExtension(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return null;
	}
	/**
	 * 通过扩展名判断文件是否是图片类型
	 * @param extension
	 * @return
	 */
	public static boolean isPicture(String extension) {
		return extension != null && (extension.equals("jpg") || extension.equals("png") || extension.equals("bmp"));
	}	
	/**
	 * 获取文件名，不带扩展
	 * @param filename
	 * @return
	 * @author fhr 2017/05/21
	 */
	public static String getFileNameNoExtension(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length()))) {
				return filename.substring(0, dot);
			}
		}
		return filename;
	}
	/**
	 * 获取文件夹中的文件个数
	 * @param dir
	 * @return
	 * @author fhr 2017/05/21
	 */
	public static int getFilesCount(String dir){
		 File file=new File(dir);
         return file.list().length;
	}
	/**
	 * 判断文件夹是否存在
	 * @param dir
	 * @return
	 */
    public static boolean dirIsExist(String dir){
		 File file=new File(dir);
		 return file.isDirectory()&&file.exists();
	}
    /**
     * 判断文件是否存在
     * @param fileName
     * @return
     * @author fhr 2017/05/21
     */
	public static boolean fileIsExist(String fileName){
		 File file=new File(fileName);
		 return file.isFile()&&file.exists();
	}
	
	/**
	 * 保存文件
	 * @param file
	 * @param dir
	 * @param fileName
	 * @return
	 * @author fhr 
	 * @throws IOException 
	 * @date 2017/05/21
	 */
	public static void savefile(MultipartFile file, String dir,String fileName) throws IOException {
		 saveFileFromInputStream(file.getInputStream(),String.format("%s\\%s", dir,fileName));
	}
	/**
	 * 保存文件
	 * @param file
	 * @param fileName
	 * @return
	 * @throws IOException 
	 */
	public static void savefile(MultipartFile file, String fileName) throws IOException {
		saveFileFromInputStream(file.getInputStream(),fileName);
	}
	/**
	 *从输入流中保存文件
	 * @param stream
	 * @param fullFileName
	 * @throws IOException
	 * @author fhr 2017/05/21
	 */
	public static void saveFileFromInputStream(InputStream stream, String fullFileName) throws IOException{
		FileOutputStream outputStream=null;
		try {
			File file=new File(fullFileName);
			if(!file.getParentFile().exists()){
				file.getParentFile().mkdirs();
			}
			outputStream = new FileOutputStream(fullFileName);
			//20K的缓冲区
			byte[] bytes = new byte[20480];
			int byteCount = 0;
			while ((byteCount = stream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, byteCount);
			}
		} finally{
			try {
				outputStream.close();
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
