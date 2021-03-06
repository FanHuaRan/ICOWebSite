package com.fhr.icoweb.services.impl;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fhr.icoweb.services.IcoConfig;
import com.fhr.icoweb.services.IcoService;
import com.fhr.icoweb.utils.ImageUtil;
import com.fhr.icoweb.utils.ZipUtils;

/**
 * ICO业务实现
 * @author fhr
 * @date 2017/06/04 
 */
@Service
public class IcoServiceClass implements IcoService {

	private static final Logger logger = Logger.getLogger(IcoServiceClass.class);

	@Override
	public File convertToIco(Image image, String name,String uuid) {
		for (int i = 0; i < 4; i++) {
			int size = (int) Math.pow(2, i + 4);
			if (!ImageUtil.convertImgToIco(image, size,size,String.format("%s\\%s_%s\\%d.ico", IcoConfig.ICO_ROOT, uuid, name,size))) {
				logger.error("文件转换失败：" + uuid);
				return null;
			}
		}
		return new File(String.format("%s\\%s_%s", IcoConfig.ICO_ROOT, uuid,name));
	}

	@Override
	public File convertToIco(Image image, String name,int size, String uuid) {
		String icoFileName=String.format("%s\\%s_%s.ico", IcoConfig.ICO_ROOT, uuid,name);
		if (ImageUtil.convertImgToIco(image, size,size,icoFileName)) {
			return new File(icoFileName);
		} else {
			logger.error("文件转换失败：" + uuid);
			return null;
		}
	}

	@Override
	public byte[] getBytesFromSingleIco(String uuid,String name) {
		File file = new File(String.format("%s\\%s_%s.ico", IcoConfig.ICO_ROOT, uuid,name));
		byte[] data = null;
		try {
			data = FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("文件获取失败", e);
		} finally {
			if (IcoConfig.DELETEICO) {
				forceDeleteFile(file);
			}
		}
		return data;
	}

	@Override
	public byte[] getBytesFromIcoZip(String uuid,String name) {
		byte[] data = null;
		File file = new File(String.format("%s\\%s_%s", IcoConfig.ICO_ROOT, uuid,name));
		try {
			File zipTmpFile = File.createTempFile(uuid, ".zip", new File(IcoConfig.ICO_ROOT));
			zipTmpFile.deleteOnExit();
			ZipUtils.doCompress(file, zipTmpFile);
			data = FileUtils.readFileToByteArray(zipTmpFile);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			if (IcoConfig.DELETEICO) {
				forceDeleteFile(file);
			}
		}
		return data;
	}

	private void forceDeleteFile(File file) {
		try {
			FileUtils.forceDelete(file);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
}
