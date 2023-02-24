package Dietitian.melyApp.business;

import Dietitian.melyApp.entity.FormDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FormService {
  String  preRegister(FormDto formDto);
  String preRegister2(MultipartFile file);

  String getJson();
}
