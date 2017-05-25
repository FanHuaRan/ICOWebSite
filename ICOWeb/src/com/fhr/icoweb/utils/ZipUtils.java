package com.fhr.icoweb.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * 文件压缩辅助工具
 * @autho  摘自博客园
 */
public class ZipUtils {
	/**
	 * 压缩文件或者目录
	 * @param srcFile
	 * @param zipFile
	 * @throws Exception
	 */
	public static void doCompress(String srcFile, String zipFile) throws Exception {
		doCompress(new File(srcFile), new File(zipFile));
	}
	/**
	 * 压缩文件
	 * @param srcFile
	 * @param destFile
	 * @throws Exception
	 */
	public static void doCompress(File srcFile, File destFile) throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(destFile));
		if (srcFile.isDirectory()) {
			File[] files = srcFile.listFiles();
			for (File file : files) {
				doCompress(file, out);
			}
		} else {
			doCompress(srcFile, out);
		}
	}
	/**
	 * 压缩文件或者目录
	 * @param pathname
	 * @param out
	 * @throws IOException
	 */
	public static void doCompress(String pathname, ZipOutputStream out) throws IOException {
		doCompress(new File(pathname), out);
	}
	/**
	 * 压缩文件或者目录
	 * @param file
	 * @param out
	 * @throws IOException
	 */
	public static void doCompress(File file, ZipOutputStream out) throws IOException {
		if (file.exists()) {
			byte[] buffer = new byte[1024];
			FileInputStream fis = new FileInputStream(file);
			out.putNextEntry(new ZipEntry(file.getName()));
			int len = 0;
			// 读取文件的内容,打包到zip文件
			while ((len = fis.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			out.flush();
			out.closeEntry();
			fis.close();
		}
	}
}
	
