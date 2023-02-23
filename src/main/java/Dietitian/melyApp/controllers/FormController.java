package Dietitian.melyApp.controllers;

import Dietitian.melyApp.business.FormService;
import Dietitian.melyApp.entity.FormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping("/api/form")
@CrossOrigin
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping(value = "/register")
    public String den(@RequestBody FormDto formDto) throws IOException {
        this.formService.preRegister(formDto);
        return "register1 kısmına gönderildi";
    }

    @PostMapping("/register2")
    public String den(@RequestBody MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        formService.preRegister2(convFile);
        return "gönderildi";
    }

    @GetMapping("/register3")
    public String den() {
        return "gönderildi";
    }


}
