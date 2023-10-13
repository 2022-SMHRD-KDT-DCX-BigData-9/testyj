package com.smhrd.bigdata.converter;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

public class ImageToBase64 implements ImageConverter<File, String>{

	@Override
	public String convert(File f) throws IOException {
		
		//File 객체를 String 으로 변환 (Base64 사용)
		//1. File 객체 -> byte[] 변환
		byte[] fileContent = FileUtils.readFileToByteArray(f);
		
		//2. byte[] -> String(base64)
		String result = Base64.getEncoder().encodeToString(fileContent);
		
		
		return result;
	}
	
}
