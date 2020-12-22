package com.example.front.encryption.controller;

import com.example.front.dashboard.model.DashboardSearchDto;
import com.example.front.encryption.model.EncrypRequest;
import lombok.AllArgsConstructor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ui")
@AllArgsConstructor
public class EncrypController {

    private final Logger logger = LoggerFactory.getLogger(EncrypController.class);

    @Qualifier("encryptorBean")
    private PooledPBEStringEncryptor encryptor;

    @GetMapping("/make/encryp")
    public ModelAndView makeEncryp(@Valid @ModelAttribute EncrypRequest params){
        org.springframework.web.servlet.ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("encryptionMake");

        if("Y".equals(params.getIsSearch())){
            logger.info(String.format("PlainText : %s",params.getPlainText()));
            String encryptedText = encryptor.encrypt(params.getPlainText());
            logger.info(String.format("encryptedText : %s",encryptedText));
            String decryptedText = encryptor.decrypt(encryptedText);
            logger.info(String.format("decryptedText : %s",decryptedText));
            modelAndView.addObject("data", encryptedText);
        }
        return modelAndView;
    }
}
