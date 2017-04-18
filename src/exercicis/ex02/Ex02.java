/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicis.ex02;

import exercicis.util.FileInput;
import exercicis.util.Constants;
import exercicis.template.Exercici;
import exercicis.util.Functions;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author m0r
 */
public class Ex02 extends Exercici {
    
    private FileInput _input;
    
    private static final String STR_TITLE = Constants.STR_EX02_TITLE;
    
    private static final String STR_MODE_SHA1 = Constants.STR_MODE_SHA1;
    private static final String STR_MODE_MD5 = Constants.STR_MODE_MD5;
    
    private static final String STR_NOT_PROCESSED_ERROR = Constants.STR_NOT_PROCESSED_ERROR;
    
    
    private Ex02() {
        super(STR_TITLE);
    }
    
    public Ex02(String[] args) {
        this();
        if(args != null && args.length > 0) setInput(new FileInput(args[0]));
    }
    
    @Override
    public void execute() {
        super.execute();
        PrintStream out = System.out;
        byte[] byteArray = getInput().getByteArray();
        String sha1 = encrypt(byteArray, STR_MODE_SHA1),
                md5 = encrypt(byteArray, STR_MODE_MD5);
        out.println("SHA-1 output: " + sha1);
        out.println("MD5 output: " + md5);
    }
    
    private String encrypt(byte[] byteArray, final String mode)
    {
        String encryptedMessage = STR_NOT_PROCESSED_ERROR;
        if(_input != null)
            try
            {
                MessageDigest crypt = MessageDigest.getInstance(mode);
                crypt.reset();
                crypt.update(byteArray);
                encryptedMessage = Functions.byteToHex(crypt.digest());
            }
            catch(NoSuchAlgorithmException e)
            {
                Logger.getLogger(Ex02.class.getName()).log(Level.SEVERE, null, e);
            }
        return encryptedMessage;
    }
    
    private FileInput getInput() {
        return _input;
    }
    private void setInput(FileInput input) {
        _input = input;
    }
    
}
