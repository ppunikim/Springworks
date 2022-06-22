package com.callor.ems.service.impl;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.callor.ems.model.EmsVO;
import com.callor.ems.model.UserVO;
import com.callor.ems.service.QualifyConfig;
import com.callor.ems.service.SendMailService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service(QualifyConfig.SERVICE.MAIL_V1)
public class SendMailServiceImplV1 implements SendMailService{

	protected final JavaMailSender sender;
	public SendMailServiceImplV1(JavaMailSender sender) {
		this.sender = sender;
	}
	
	@Override
	public void sendMail(EmsVO emsVO) {
		
		//메일 전송 전, 필수 정보에 대해 확인
		log.debug("받는사람 email : {}",emsVO.getE_to_email() );
		log.debug("받는사람 이름: {}",emsVO.getE_to_name() );
		log.debug("받는사람 제목: {}",emsVO.getE_subject() );
		
		/* 메일을 전송하기 위한 Helper Class가져오기
		 * 메일을 보내는 형식을 MIME TYPE으로 메세지를 만들기
		 */
		MimeMessage message = sender.createMimeMessage();
		//mimeMessage에게 속성을 설정하여 주입하기 위한 도구
		MimeMessageHelper mHelper = null;

		try {
			/* 두 번째 전달 값
			 * false: 순수 text만 전송 가능, text/plan type 으로 전송
			 * true: html 코드 포함, 첨부파일도 포함 가능, text/html, multipart/form-data
			 */
			mHelper = new MimeMessageHelper(message,true, "UTF-8");
			mHelper.setFrom("yd62322@naver.com",emsVO.getE_from_name());
			String[] sendTo = {emsVO.getE_to_email()}; 
			mHelper.setTo(sendTo);
			mHelper.setSubject(emsVO.getE_subject());
			mHelper.setText(emsVO.getE_content(), true);
			//메일을 보내는 코드.
			sender.send(message);
			log.debug("메일 전송 OK!");
		} catch (MessagingException e) {
			log.debug("메세지 생성 오류");
		} catch (UnsupportedEncodingException e) {
			log.debug("메세지 변환 오류");
			e.printStackTrace();
		}
		
		
	}//end sendMail()

	@Override
	public void sendMail(EmsVO emsVO, UserVO userVO) {
		// TODO Auto-generated method stub
		
	}
}//end class
