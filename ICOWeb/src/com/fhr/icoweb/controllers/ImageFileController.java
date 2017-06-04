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
/**
 * 图片文件上传下载控制器
 * @author fhr
 * @date 2017/06/04 
 */
@Controller
@RequestMapping("/file")
public class ImageFileController {
	
	@Autowired
	private IcoService imageConvertIco=null;
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public ResponseEntity<byte[]> uploadImageAndDownIco(
												@RequestParam(value="uuid",required=true) String uuid,
												@RequestParam(value="size",required=true) int size, 
												@RequestParam(value="icosize",required=false)Integer icoSize,
												@RequestParam(value="name",required=false)String name,
												MultipartFile file,
												HttpServletRequest request, 
												HttpServletResponse response) {
		// 无文件或者文件不是img
		if (file.isEmpty()||!SimpleFileUtil.isPictureByFileName(name)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		File icoFile=null;
		try {
			Image image = ImageIO.read(file.getInputStream());
			if (icoSize == null) {
				icoFile=imageConvertIco.convertToIco(image, uuid);
			} else {
				icoFile=imageConvertIco.convertToIco(image, icoSize, uuid);
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
	@RequestMapping("/download")
	public ResponseEntity<byte[]> downLoadIco(
							@RequestParam(value="name",required=true) String name,
							@RequestParam(value="uuid",required=true) String uuid,
							@RequestParam(value="icosize",required=false) Integer icoSize){
		byte[] data=null;
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		//单尺寸
		if(icoSize!=null){
			data=imageConvertIco.getBytesFromSingleIco(uuid);
			headers.set("Content-Disposition", "attachment;fileName=" + name+ ".ico");		}
		else{
			data=imageConvertIco.getBytesFromIcoZip(uuid);
			headers.set("Content-Disposition", "attachment;fileName=" + name + ".zip");
		}
		if(data==null){
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
		}
	}
}
