package Dietitian.melyApp.business;

import Dietitian.melyApp.entity.FormDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FormService {
  void  preRegister(FormDto formDto);
  void preRegister2(File file);

  FormDto getJson(String formDto, MultipartFile file);
}
