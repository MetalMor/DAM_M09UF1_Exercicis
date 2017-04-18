/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicis.ex06;

import exercicis.template.Exercici;
import exercicis.util.Constants;
import exercicis.util.FileInput;
import exercicis.util.Functions;
import exercicis.util.Input;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author m0r
 */
public class Ex06 extends Exercici {
    
    private Input _input;
    private KeyPair _keyPair;
    private FileInput _fileInput;
    
    private static final String STR_PROVIDER_JCE = Constants.STR_PROVIDER_JCE;
    private static final String STR_KEYS_PATH = Constants.STR_KEYS_PATH;
    private static final String STR_TITLE = Constants.STR_EX06_TITLE;
    private static final String STR_INPUT_STRING_REQUEST = Constants.STR_INPUT_STRING_REQUEST;
    private static final String STR_MODE_RSA_CIPHER = Constants.STR_MODE_RSA_CIPHER;
    private static final String STR_MODE_ENCODING = Constants.STR_MODE_ENCODING;
    private static final String STR_MODE_RSA = Constants.STR_MODE_RSA;

    public Ex06() {
        super(STR_TITLE);
        init();
    }
    
    private void init() {
        _input = new Input();
        _fileInput = new FileInput(STR_KEYS_PATH);
    }
    
    @Override
    public void execute() {
        super.execute();
        PrintStream out = System.out;
        out.println(STR_INPUT_STRING_REQUEST);
        String message = "";
        while(message.isEmpty()) message = getInput().readString();
        String encryptedMessage = encrypt(message);
        String decryptedMessage = decrypt(encryptedMessage);
        out.println("RSA output: " + encryptedMessage);
        out.println("Decrypted output: " + decryptedMessage);
    }
    
    public KeyPair randomGenerate(int len) {
        KeyPair keys = null;
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(STR_MODE_RSA);
            keyGen.initialize(len);
            keys = keyGen.genKeyPair();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return keys;
    }
    
    public String encrypt(String message) {
        String encryptedMessage = null;
        try {
            byte[] messageByteArray = message.getBytes(STR_MODE_ENCODING);
            _keyPair = randomGenerate(8*(messageByteArray.length + 11));
            Cipher cipher = Cipher.getInstance(STR_MODE_RSA_CIPHER, STR_PROVIDER_JCE);
            cipher.init(Cipher.ENCRYPT_MODE, _keyPair.getPublic());
            encryptedMessage = Functions.byteToHex(cipher.doFinal(messageByteArray));
        } catch (InvalidKeyException | NoSuchAlgorithmException | 
                NoSuchPaddingException | NoSuchProviderException |
                UnsupportedEncodingException | IllegalBlockSizeException | 
                BadPaddingException ex) {
            ex.printStackTrace();
        }
        return encryptedMessage;
    }
    
    public String decrypt(String encryptedMessage) {
        String decryptedMessage = null;
        try {
            Cipher cipher = Cipher.getInstance(STR_MODE_RSA_CIPHER, STR_PROVIDER_JCE);
            cipher.init(Cipher.DECRYPT_MODE, _keyPair.getPrivate());
            decryptedMessage = new String(cipher.doFinal(encryptedMessage.getBytes(STR_MODE_ENCODING)), STR_MODE_ENCODING);
        } catch (InvalidKeyException | NoSuchAlgorithmException | 
                NoSuchPaddingException | NoSuchProviderException |
                UnsupportedEncodingException | IllegalBlockSizeException | 
                BadPaddingException ex) {
            ex.printStackTrace();
        }
        return decryptedMessage;
    }
    
    public Input getInput() {
        return _input;
    }
    public void setInput(Input input) {
        _input = input;
    }
}
