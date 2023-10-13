package com.smhrd.bigdata.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.bigdata.converter.ImageCon;
import com.smhrd.bigdata.converter.ImageConverter;
import com.smhrd.bigdata.converter.ImageToBase64;
import com.smhrd.bigdata.entity.BootBoard;
import com.smhrd.bigdata.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService service;
	
	@PostMapping("/board/write")
	public String write(BootBoard b, @RequestPart("photo") MultipartFile photo) {
		System.out.println(b.getTitle());
		System.out.println(b.getWriter());
		System.out.println(b.getContent());
		
		System.out.println(photo.getOriginalFilename());
		//파일 이름이 겹치지 않도록 -> UUID (시스템 적으로 절대 겹치지 않는 문자열을 생성)
		// UUID+OriginalFilename
		System.out.println(UUID.randomUUID().toString());
		
		String newFileName = UUID.randomUUID().toString() + photo.getOriginalFilename();
		
		//이미지 파일 저장 -> 지정한 경로에!
		//런타임 오류 : 코드가 실행되었을 때 발생하는 오류 -> 예외처리 (try~catch)
		try { //실행할 코드
			photo.transferTo(new File(newFileName));
		}catch(Exception e) { //예외가 발생했을 경우 어떻게 처리할건지
			e.printStackTrace(); //예외발생 절차 콘솔에 출력
		}
		
		b.setImg(newFileName); //새로만들어준 이름으로 img 필드 초기화
		
		service.write(b);
		
		return "redirect:/";
	}
	
	@GetMapping("/board/content/{idx}")
	public String content(@PathVariable("idx") int idx, Model model){
		
		BootBoard b = service.content(idx);
		
		//특정 경로에 저장되어 있는 파일 가져오기 (img-파일이름)
		File file = new File("c:\\uploadImage\\"+b.getImg());
		//->문자열 형태로 변환(base64 형식을 사용해서 인코딩)
		
		
		ImageConverter<File,String> converter = new ImageToBase64();
		
		String fileStringValue = null;
		try {
			fileStringValue = converter.convert(file);
			System.out.println(fileStringValue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		b.setImg(fileStringValue);
		
		model.addAttribute("board", b);
		
		return "boardcontent";
	}
}





