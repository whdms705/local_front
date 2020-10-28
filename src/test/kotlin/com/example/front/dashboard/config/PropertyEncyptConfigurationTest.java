package com.example.front.dashboard.config;

import junit.framework.TestCase;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertyEncyptConfigurationTest extends TestCase {
    @Test
    public void EncyptConfiguration_확인(){
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setProvider(new BouncyCastleProvider());
        encryptor.setPoolSize(2);
        encryptor.setPassword("xoxo");
        encryptor.setAlgorithm("PBEWithSHA256And128BitAES-CBC-BC");

        String plainText = "test";
        String encryptedText = encryptor.encrypt(plainText);
        String decryptedText = encryptor.decrypt(encryptedText);
        assertTrue(plainText.equals(decryptedText));
    }
}
