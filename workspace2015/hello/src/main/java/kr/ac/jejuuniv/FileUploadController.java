package kr.ac.jejuuniv;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
	@RequestMapping
	public String upload(MultipartFile file) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(new File("/daum/github/java-framework-class/java-framework-class/workspace2015/hello/src/main/webapp/resources/" + file.getOriginalFilename()));
		BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
		outputStream.write(file.getBytes());
		outputStream.close();
		return "redirect:/success.jeju";
	}
}
