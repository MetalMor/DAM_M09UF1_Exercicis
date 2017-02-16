/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicis.ex01;

import exercicis.Constants;
import exercicis.template.Exercici;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * 
 * @author m0r
 */
public class Ex01 extends Exercici {
    
    private Input _input;
    
    private static final String STR_TITLE = Constants.STR_EX01_TITLE;
    
    private static final String STR_MODE_SHA1 = Constants.STR_MODE_SHA1;
    private static final String STR_MODE_MD5 = Constants.STR_MODE_MD5;
    
    private static final String STR_MODE_ENCODING = Constants.STR_MODE_ENCODING;
    
    private static final String STR_HEX_FORMAT = Constants.STR_HEX_FORMAT;
    
    private static final String STR_INPUT_STRING_REQUEST = Constants.STR_INPUT_STRING_REQUEST;
    private static final String STR_NOT_PROCESSED_ERROR = Constants.STR_NOT_PROCESSED_ERROR;
    
    
    public Ex01() {
        super(STR_TITLE);
        setInput(new Input());
    }
    
    @Override
    public void execute() {
        super.execute();
        PrintStream out = System.out;
        out.println(STR_INPUT_STRING_REQUEST);
        String message = getInput().readString(),
                sha1 = encrypt(message, STR_MODE_SHA1),
                md5 = encrypt(message, STR_MODE_MD5);
        out.println("SHA-1 output: " + sha1);
        out.println("MD5 output: " + md5);
    }
    
    private String encrypt(String message, final String mode)
    {
        String encryptedMessage;
        try
        {
            MessageDigest crypt = MessageDigest.getInstance(mode);
            crypt.reset();
            crypt.update(message.getBytes(STR_MODE_ENCODING));
            encryptedMessage = byteToHex(crypt.digest());
        }
        catch(NoSuchAlgorithmException | UnsupportedEncodingException e)
        {
            encryptedMessage = STR_NOT_PROCESSED_ERROR;
        }
        return encryptedMessage;
    }

    private String byteToHex(final byte[] hash)
    {
        String result;
        try (Formatter formatter = new Formatter()) {
            for (byte b : hash)
                formatter.format(STR_HEX_FORMAT, b);
            result = formatter.toString();
        }
        return result;
    }
    
    private Input getInput() {
        return _input;
    }
    private void setInput(Input input) {
        _input = input;
    }
    
}
