package com.fhr.icoweb.services.impl;

import java.awt.Image;
import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fhr.icoweb.services.IImageConvertIco;
import com.fhr.icoweb.utils.ImageUtil;

@Service
public class ImageConvertIco implements IImageConvertIco {
	private static final String ROOT_PATH="D://icoimages";

	@Override
	public File convertToIco(Image image) {
		String uuid = getUUID();
		for (int i = 0; i < 4; i++) {
			int size = (int) Math.pow(2, i + 4);
			if (!ImageUtil.convertImgToIcoByHeight(image, size,
					String.format("%s\\%s\\%d.ico", ROOT_PATH, uuid, size))) {
				return null;
			}
		}
		return new File(String.format("%s\\%s", ROOT_PATH, uuid));
	}

	@Override
	public File convertToIco(Image image, int size) {
		String uuid=getUUID();
		if(ImageUtil.convertImgToIcoByHeight(image,size,String.format("%s\\%s.ico", ROOT_PATH,uuid))){
			return new File(String.format("%s\\%s.ico",ROOT_PATH,uuid));
		}else{
			return null;
		}
	}

    public static String getUUID(){ 
        String s = UUID.randomUUID().toString(); 
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
    } 
}
