package com.troutee.api.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.troutee.exceptions.ServiceException;
import org.apache.commons.codec.binary.Base64;

/**
 * Created by vicente on 06/03/16.
 */
public class CryptoUtils {
    private static final String myEncryptionKey= "Tr0uT33KeYs3CR3T";


    public static String encrypt(String strToEncrypt)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            final SecretKeySpec secretKey = new SecretKeySpec(myEncryptionKey.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            final String encryptedString = Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes()));
            return encryptedString;
        }
        catch (Exception e)
        {
           throw new ServiceException("troutee.general.error");
        }

    }

    public static String decrypt(String strToDecrypt)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            final SecretKeySpec secretKey = new SecretKeySpec(myEncryptionKey.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            final String decryptedString = new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));
            return decryptedString;
        }
        catch (Exception e)
        {
            throw new ServiceException("troutee.general.error");

        }
    }





}
