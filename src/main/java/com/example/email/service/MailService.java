package com.example.email.service;
 
import java.io.StringWriter;
import java.util.Map;
 
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
 
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
 
import com.example.email.dto.MailDto;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
 
@RequiredArgsConstructor
@Service
public class MailService {
 
    private final JavaMailSender javaMailSender;
    
    @Async
    public void sendMail(MailDto mailDto, Map<String, String> userInfo) throws MessagingException {
        try {
            // 메일에 들어갈 값 설정
            MailDto sendMailDto = new MailDto();
            sendMailDto.setCompany("DevDream");                                      // 상호명
            sendMailDto.setLink("https://devdream.net");                             // 버튼 링크
            sendMailDto.setTitle(mailDto.getTitle());                                // 제목
            sendMailDto.setContents(mailDto.getContents().replaceAll("\n", "<br>")); // 내용, 개행문자 치환
            sendMailDto.setName(userInfo.get("name").toString());                    // 받는 사람 이름
            sendMailDto.setEmail(userInfo.get("email").toString());                  // 받는 사람 이메일
            
            MustacheFactory mf  = new DefaultMustacheFactory();
            Mustache m          = mf.compile("templates/mail_form.mustache");   // mail form (template)
 
            StringWriter sw = new StringWriter();
            m.execute(sw, sendMailDto);
            sw.flush();
            String mailContents = sw.toString();
            
            MimeMessagePreparator preparator = new MimeMessagePreparator() {
                @Override
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                    // 받는 사람 이메일 
                    helper.setTo(sendMailDto.getEmail());
                    // 제목
                    helper.setSubject(sendMailDto.getTitle());
                    // 내용
                    helper.setText(mailContents, true);
                }
            };
 
            // 메일 발송
            this.javaMailSender.send(preparator);
        } catch (MailException e) {
            System.out.println(e.getMessage());
        }
    }
 
}