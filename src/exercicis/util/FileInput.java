/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicis.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author m0r
 */
public class FileInput {
    private File _file;
    private FileInputStream _inputStream;
    
    public FileInput(String pathname) {
        setFile(pathname);
    }
    
    public byte[] getByteArray() {
        try {
            if(_inputStream != null) {
                byte[] byteArray = new byte[(int) _file.length()];
                _inputStream.read(byteArray);
                return byteArray;
            }
        } catch (IOException ex) {
            Logger.getLogger(FileInput.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new byte[] {};
    }
    
    public final void setFile(File file) {
        try {
            _file = file;
            _file.mkdirs();
            if(_file.isFile()) 
                _inputStream = file != null && file.exists() ? new FileInputStream(_file) : null;
        } catch (FileNotFoundException | SecurityException ex) {
            Logger.getLogger(FileInput.class.getName()).log(Level.SEVERE, null, ex);
            _inputStream = null;
            _file = null;
        }
    }
    
    public final void setFile(String pathname) {
        setFile(new File(pathname));
    }
    
}
