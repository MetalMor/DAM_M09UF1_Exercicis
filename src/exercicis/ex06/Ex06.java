/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicis.ex06;

import exercicis.template.Exercici;
import exercicis.util.Constants;
import exercicis.util.Input;
import java.io.PrintStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author m0r
 */
public class Ex06 extends Exercici {
    
    private Input _input;
    
    private static final String STR_TITLE = Constants.STR_EX06_TITLE;
    private static final String STR_INPUT_STRING_REQUEST = Constants.STR_INPUT_STRING_REQUEST;

    public Ex06() {
        super(STR_TITLE);
    }
    
    @Override
    public void execute() {
        super.execute();
        PrintStream out = System.out;
        out.println(STR_INPUT_STRING_REQUEST);
        String message = "";
        while(message.isEmpty()) message = getInput().readString();
        String encryptedMessage = encrypt();
        String decryptedMessage = decrypt();
        out.println("RSA output: " + encryptedMessage);
        out.println("Decrypted output: " + decryptedMessage);
    }
    
    public KeyPair randomGenerate(int len) {
        KeyPair keys = null;
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(len);
            keys = keyGen.genKeyPair();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return keys;
    }
    
    public String encrypt() {
        return "";
    }
    
    public String decrypt() {
        return "";
    }
    
    public Input getInput() {
        return _input;
    }
    public void setInput(Input input) {
        _input = input;
    }
}
