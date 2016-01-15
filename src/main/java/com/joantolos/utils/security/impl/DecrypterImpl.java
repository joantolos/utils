package com.joantolos.utils.security.impl;

import com.joantolos.utils.security.Decrypter;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DecrypterImpl implements Decrypter {

    //@Value("${security.key}")
    private String securityKey = "security.key=allworkandnoplaymakesJackadullboy";

    public String decrypt(String encryptedText){
        BasicTextEncryptor textDecryptor = new BasicTextEncryptor();
        textDecryptor.setPassword(this.securityKey+new StringBuffer(this.securityKey).reverse().toString());
        return textDecryptor.decrypt(encryptedText);
    }
}
