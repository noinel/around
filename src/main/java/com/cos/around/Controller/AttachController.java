package com.cos.around.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cos.around.Model.AttachFile;

@RestController
@RequestMapping("/attach")
public class AttachController {

	private final String PATH = "E://around!//around-master//src//main//resources//static//attach//";

	@PostMapping("/upload")
	public AttachFile attachUpload(@RequestParam("file") MultipartFile file) throws IOException {
		Path filePath = Paths.get(PATH + file.getOriginalFilename());

		Files.write(filePath, file.getBytes());

		AttachFile aFile = new AttachFile();

		aFile.setMimeType(file.getContentType());
		aFile.setFileName(file.getOriginalFilename());
		aFile.setFilePath("/attach/" + file.getOriginalFilename());

		return aFile;
	}

}
