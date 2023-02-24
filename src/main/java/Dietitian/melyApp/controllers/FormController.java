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
@CrossOrigin(origins="*")
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping(value = "/register")
    public String den(@RequestBody FormDto formDto) throws IOException {
        return this.formService.preRegister(formDto);
    }

    @PostMapping("/register2")
    public String den(@RequestBody MultipartFile file) throws IOException {
        return formService.preRegister2(file);
    }

    @GetMapping("/register3")
    public String den() {
        return formService.getJson();
    }


}
