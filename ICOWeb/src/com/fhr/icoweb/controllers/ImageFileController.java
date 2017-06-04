package com.fhr.icoweb.controllers;

import java.awt.Image;
import java.io.File;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fhr.icoweb.services.IcoService;
import com.fhr.icoweb.utils.SimpleFileUtil;

@Controller
@RequestMapping("/file")
public class ImageFileController {
	
	@Autowired
	private IcoService imageConvertIco=null;
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public ResponseEntity<byte[]> uploadImageAndDownIco(
												@RequestParam(value="uuid",required=true) String uuid,
												@RequestParam(value="size",required=false) Integer size, 
												MultipartFile file,
												HttpServletRequest request, 
												HttpServletResponse response) {
		String fileName=file.getOriginalFilename();
		// 无文件或者文件不是img
		if (file.isEmpty()||SimpleFileUtil.isPicture(SimpleFileUtil.getExtension(fileName))) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		File icoFile=null;
		try {
			Image image = ImageIO.read(file.getInputStream());
			if (size == null) {
				icoFile=imageConvertIco.convertToIco(image, uuid);
			} else {
				icoFile=imageConvertIco.convertToIco(image, size, uuid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(icoFile==null){
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}else{
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@RequestMapping("/dowload")
	public ResponseEntity<byte[]> downLoadIco(
							@RequestParam(value="name",required=true) String name,
							@RequestParam(value="uuid",required=true) String uuid,
							@RequestParam(value="size",required=false) Integer size){
		byte[] data=null;
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		//单尺寸
		if(size==null){
			data=imageConvertIco.getBytesFromSingleIco(uuid);
			headers.set("Content-Disposition", "attachment;fileName=" + name+ ".ico");		}
		else{
			data=imageConvertIco.getBytesFromSingleIco(uuid);
			headers.set("Content-Disposition", "attachment;fileName=" + name + ".zip");
		}
		if(data==null){
			return new ResponseEntity<byte[]>(HttpStatus.EXPECTATION_FAILED);
		}else{
			return new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
		}
	}
}
