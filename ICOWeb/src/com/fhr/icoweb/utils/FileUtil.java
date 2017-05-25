package com.fhr.icoweb.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;
/**
 * 文件操作辅助类
 *
 */
public class FileUtil {
	
	//创建目录
	public static void mkDir(String path)
	{
		File file = new File(path);
		if (!file.isDirectory())
			file.mkdirs();
	}
	/**
	 * 获取文件的字节码
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static byte[] getFileByte(File file) throws IOException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());  
        BufferedInputStream in = null;  
        try {  
            in = new BufferedInputStream(new FileInputStream(file));  
            int buf_size = 1024;  
            byte[] buffer = new byte[buf_size];  
            int len = 0;  
            while (-1 != (len = in.read(buffer, 0, buf_size))) {  
                bos.write(buffer, 0, len);  
            }  
            return bos.toByteArray();  
        } catch (IOException e) {  
            e.printStackTrace();  
            throw e;  
        } finally {  
            try {  
                in.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
            bos.close();  
        }  
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
	 * @date 2017/05/21
	 */
	public static boolean savefile(MultipartFile file, String dir,String fileName) {
		try {
			File dirInfo=new File(dir);
			if(!dirInfo.exists()){
				dirInfo.mkdirs();
			}
			return saveFileFromInputStream(file.getInputStream(),String.format("%s\\%s", dir,fileName));
		} catch (IOException e) {
			return false;
		}
	}
	/**
	 * 保存文件
	 * @param file
	 * @param fileName
	 * @return
	 */
	public static boolean savefile(MultipartFile file, String fileName) {
		try {
			return saveFileFromInputStream(file.getInputStream(),fileName);
		} catch (IOException e) {
			return false;
		}
	}
	/**
	 *从输入流中保存文件
	 * @param stream
	 * @param fullFileName
	 * @throws IOException
	 * @author fhr 2017/05/21
	 */
	public static boolean saveFileFromInputStream(InputStream stream, String fullFileName){
		boolean flag=true;
		FileOutputStream outputStream=null;
		try {
			outputStream = new FileOutputStream(fullFileName);
			byte[] bytes = new byte[2048];
			int byteCount = 0;
			while ((byteCount = stream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, byteCount);
			}
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		} finally{
			try {
				outputStream.close();
				stream.close();
			} catch (IOException e) {
				flag=false;
				e.printStackTrace();
			}
		}
		return flag;
	}
}
