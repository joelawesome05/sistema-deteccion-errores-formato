package com.joel.ucbcba.sistemaayudadeteccionerroresformato.controllers;

import com.joel.ucbcba.sistemaayudadeteccionerroresformato.filestorage.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFileController {
    @Autowired
    FileStorage fileStorage;

    @GetMapping("/upload")
    public String index() {
        return "uploadform.html";
    }

    @PostMapping("/registration")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model) {
        try {
            fileStorage.store(file);
            model.addAttribute("message", "¡Trabajo académico subido exitosamente! -> archivo = " + file.getOriginalFilename());
        } catch (Exception e) {
            model.addAttribute("message", "!Error! -> al subir el archivo: " + file.getOriginalFilename());
        }
        return "uploadform.html";
    }
}
