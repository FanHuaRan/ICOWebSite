package com.fhr.icoweb.controllers;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fhr.icoweb.services.IImageConvertIco;
import com.fhr.icoweb.services.impl.ImageConvertIco;
import com.fhr.icoweb.utils.FileUtil;
import com.fhr.icoweb.utils.ZipUtils;

@Controller
public class HomeController {
	
	@Autowired
	private IImageConvertIco imageConvertIco=null;
	
	@RequestMapping("")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/upload")
	public ResponseEntity<byte[]> uploadImageAndDownIco(MultipartFile file, @RequestParam Integer size,
			HttpServletRequest request, HttpServletResponse response) {
		// 无文件
		if (file.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		ResponseEntity<byte[]> responseEntity = null;
		try {
			Image image = ImageIO.read(file.getInputStream());
			if (size == null) {
				responseEntity=createZipResonse(file, image);
			} else {
				responseEntity=createSingleResonse(file, image,size);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<byte[]>(HttpStatus.BAD_GATEWAY);
		}
		return responseEntity;
	}

	private ResponseEntity<byte[]> createZipResonse(MultipartFile file, Image image) throws Exception, IOException {
		File convertFile = imageConvertIco.convertToIco(image);
		if (convertFile == null) {
			return new ResponseEntity<byte[]>(HttpStatus.BAD_GATEWAY);
		}
		File zipFile = new File(convertFile.getAbsoluteFile() + ".zip");
		ZipUtils.doCompress(convertFile, zipFile);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.set("Content-Disposition", "attachment;fileName=" + file.getName() + ".zip");
		byte[] bytes = FileUtil.getFileByte(zipFile);
		zipFile.delete();
		return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
	}
	
	private ResponseEntity<byte[]> createSingleResonse(MultipartFile file, Image image,int size) throws Exception, IOException {
		File convertFile = imageConvertIco.convertToIco(image, size);
		if (convertFile == null) {
			return new ResponseEntity<byte[]>(HttpStatus.BAD_GATEWAY);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.set("Content-Disposition", "attachment;fileName=" + file.getName() + ".ico");
		byte[] bytes = FileUtil.getFileByte(convertFile);
		return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
	}
}
