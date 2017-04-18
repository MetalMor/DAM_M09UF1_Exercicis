/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicis.ex05;

import exercicis.template.Exercici;
import exercicis.util.Constants;
import exercicis.util.Functions;
import exercicis.util.Input;
import java.io.PrintStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author m0r
 */
public class Ex05 extends Exercici {
    
    private Input _input;
    private SecretKeySpec _key;
    private Cipher _cipher;
    
    private static final String STR_TITLE = Constants.STR_EX05_TITLE;
    
    private static final String STR_MODE_AES_KEY = Constants.STR_MODE_AES_KEY;
    private static final String STR_MODE_AES_CIPHER = Constants.STR_MODE_AES_CIPHER;
    private static final String STR_PROVIDER_JCE = Constants.STR_PROVIDER_JCE;
    private static final String STR_PROVIDER_KEY_FACTORY = Constants.STR_PROVIDER_KEY_FACTORY;
    
    private static final String STR_INPUT_STRING_CONTINUOUSLY_REQUEST = Constants.STR_INPUT_STRING_CONTINUOUSLY_REQUEST;
    private static final String STR_NOT_PROCESSED_ERROR = Constants.STR_NOT_PROCESSED_ERROR;
    
    private static final int INT_AES_KEY_SIZE = Constants.INT_AES_KEY_SIZE;
    private static final int INT_AES_SALT_SIZE = Constants.INT_AES_SALT_SIZE;
    private static final int INT_AES_ITERATION_COUNT = Constants.INT_AES_ITERATION_COUNT;
    
    public Ex05() {
        super(STR_TITLE);
        init();
    }
    
    @Override
    public void execute() {
        super.execute();
        PrintStream out = System.out;
        out.println(STR_INPUT_STRING_CONTINUOUSLY_REQUEST);
        String message;
        boolean ok;
        do {
            message = getInput().readString();
            if(ok = !message.isEmpty()) update(message);
        } while(ok);
        out.println("AES output: " + encrypt());
    }
    
    private void init() {
        setInput(new Input());
        try
        {
            setKey(STR_MODE_AES_KEY);
            setCipher(Cipher.getInstance(STR_MODE_AES_CIPHER, STR_PROVIDER_JCE));
            getCipher().init(Cipher.ENCRYPT_MODE, getKey());
        }
        catch(InvalidKeyException | NoSuchAlgorithmException | 
                NoSuchProviderException | NoSuchPaddingException e)
        {
            e.printStackTrace();
            Logger.getLogger(Ex05.class.getName()).log(Level.SEVERE, null, e);
            _key = null;
            setCipher(null);
        }
    }
    
    private byte[] update(String message) {
        return getCipher().update(message.getBytes());
    }
    
    private String encrypt()
    {
        String encryptedMessage = STR_NOT_PROCESSED_ERROR;
        try
        {
            encryptedMessage = Functions.byteToHex(getCipher().doFinal());
        }
        catch(IllegalBlockSizeException | BadPaddingException e)
        {
            e.printStackTrace();
        }
        return encryptedMessage;
    }

    public Cipher getCipher() {
        return _cipher;
    }
    
    public void setCipher(Cipher cipher) {
        _cipher = cipher;
    }
    
    public SecretKey getKey() {
        return _key;
    }
    
    public void setKey(String key) {
        try {
            String salt = Arrays.toString(new SecureRandom().generateSeed(INT_AES_SALT_SIZE));
            SecretKeyFactory factory = SecretKeyFactory.getInstance(STR_PROVIDER_KEY_FACTORY);
            KeySpec spec = new PBEKeySpec(key.toCharArray(), salt.getBytes(), INT_AES_ITERATION_COUNT, INT_AES_KEY_SIZE);
            setKey(new SecretKeySpec(factory.generateSecret(spec).getEncoded(), STR_MODE_AES_KEY));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            ex.printStackTrace();
            Logger.getLogger(Ex05.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setKey(SecretKeySpec key) {
        _key = key;
    }
    
    private Input getInput() {
        return _input;
    }
    private void setInput(Input input) {
        _input = input;
    }
}
