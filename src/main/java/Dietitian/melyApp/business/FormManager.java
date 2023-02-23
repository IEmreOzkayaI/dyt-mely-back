package Dietitian.melyApp.business;

import Dietitian.melyApp.entity.FormDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

@Service
public class FormManager implements FormService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void preRegister(FormDto formDto) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("diyetisyenlik_kayit@gmail.com");
            helper.setTo("0emre.ozkaya0@gmail.com");
            helper.setSubject("Diyetisyen Danışmanlığı Kayıt Formu");
            String body ="Kişisel Bilgiler------"+"\nAd Soyad : " + formDto.getNameSurname() +
                    "\nCinsiyet : " + formDto.getGender() +
                    "\nMeslek : " + formDto.getJob() +
                    "\nE-Posta : " + formDto.getEmail() +
                    "\nCep Telefonu : " + formDto.getPhoneNumber() +
                    "\nYaş : " + formDto.getAge() +
                    "\nKilo : " + formDto.getWeight() +
                    "\nBoy : " + formDto.getHeight()+
                    "\nTanısı Konuş Hastalığınız : " + formDto.getDisaster()+
                    "\nBirinci Derece Akrabanızda Kronik Hastalık : " + formDto.getFamilyDisaster()+
                    "\nDüzenli Kullandığınız İlaçlar : " + formDto.getMedic()+
                    "\nGeçirilen Ameliyat : " + formDto.getOperation()+
                    "\nBesin Alerjisi : " + formDto.getAllergie()+
                    "\nBelirli Bir Uyanış Saati : " + formDto.getMorningTime()+
                    "\nBelirli Bir Yatış Saati : " + formDto.getNightTime()+
                    "\nBelirli Bir Regl Düzeni : " + (formDto.isRegl() ? "Evet" :"Hayır")+

                    "\n\nSindirim Sistemi------"+
                    "\nDüzenli Tuvalet Alışkanlığınız : " + (formDto.isToilet() ? "Evet" :"Hayır")+
                    "\nSindirim Sistemi Problemi : " + formDto.getDigestiveProblem()+
                    "\nMideye Rahatsızlık Veren Yiyecek : " + formDto.getBadFood()+
                    "\nMideye Rahatsızlık Veren İçecek : " + formDto.getBadDrink()+

                    "\n\nAlışkanlıklarınız------"+
                    "\nGünde Kaç Öğün Yapıyorsunuz : " + formDto.getCurrentDailyMealAmount()+
                    "\nAtlanan Öğün ( Sabah , Öğle , Akşam ) : " + formDto.getPassedMeal()+
                    "\nGünde Kaç Ara Öğün Yapıyorsunuz : " + formDto.getCurrentDailySnackAmount()+
                    "\nGünde Kaç Öğün Yapabilirsiniz : " + formDto.getPossibleDailyMealAmount()+
                    "\nVazgeçilmez Besin : " + formDto.getEssentialFood()+
                    "\nSevilmeyen Besin : " + formDto.getUnlikedFood()+
                    "\nHızlı Yemek Yeme Alışkanlığı : " + (formDto.isFastEat() ? "Evet" :"Hayır")+
                    "\nHaftada Kaç Kez Dışarıda Yersiniz : " + formDto.getCheatAmount()+
                    "\nDışarıda Yeme Sebebiniz Nedir : " + formDto.getCheatReason()+

                    "\n\nGünlük Tüketim------"+
                    "\nSu ( Litre ) : " + formDto.getWater()+
                    "\nÇay ( Bardak ) : " + formDto.getTea()+
                    "\nKahve ( Kupa ) : " + formDto.getCoffee()+
                    "\nMaden Suyu ( Şişe ) : " + formDto.getMineralWater()+
                    "\nAsitli İçecek ( Bardak ) : " + formDto.getFizzyDrink()+
                    "\nSigara ( Adet ) : " + formDto.getCigaratte()+
                    "\nAlkol ( Litre ) : " + formDto.getAlcohol()+
                    "\nAyran ( Bardak ) : " + formDto.getAyran()+
                    "\nSüt ( Bardak ) : " + formDto.getMilk()+

                    "\n\nKilo Alma-Verme Öykünüz------"+
                    "\nNe Zaman Kilo Almaya/Vermeye Başladınız ? : " + formDto.getWhenGainLoss()+
                    "\nGörülen En Yüksek Kilo : " + formDto.getHighestWeight()+
                    "\nGörülen En Düşük Kilo : " + formDto.getLowestWeight()+
                    "\nDaha Önce Uyguladığınız Diyet Var Mı ? : " + formDto.getWereCurrentDietBefore()+
                    "\nHedef Kilo : " + formDto.getGoalWeight()+

                    "\n\nAntrenman Bilgisi------"+
                    "\nAğırlık Antrenmanı : " + formDto.getFitness()+
                    "\nKardio : " + formDto.getCardio()+
                    "\nFonksiyonel Antrenman : " + formDto.getFunctional()+
                    "\nÇalışılan Hoca : " + formDto.getTrainerName()+
                    "\nSpor Geçmişiniz : " + formDto.getSportHistory()+
                    "\nGünlük Adım Sayısı : " + formDto.getDailyStep()+
                    "\nÖzel not : " + formDto.getSpecialNote();

                    helper.setText(body);

            mailSender.send(message);

            System.out.println("Mail Sent Succesfully");


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void preRegister2(File file) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("diyetisyenlik_kayit@gmail.com");
            helper.setTo("0emre.ozkaya0@gmail.com");
            helper.setSubject("deneme mesajı ");

            helper.setText("12213213");

            FileSystemResource filee = new FileSystemResource(file);
            helper.addAttachment(filee.getFilename(), filee);

            mailSender.send(message);

            System.out.println("Mail Sent Succesfully");


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public FormDto getJson(String formDto, MultipartFile file) {
        FormDto formJson = new FormDto();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            formJson = objectMapper.readValue(formDto, FormDto.class);
        }catch (IOException e){
            System.out.printf("Error",e.toString());
        }


        return formJson;
    }


}
