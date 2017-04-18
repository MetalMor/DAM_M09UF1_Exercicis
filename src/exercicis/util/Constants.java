package exercicis.util;

/**
 * Constantes usadas en los ejercicios.
 * @author m0r
 */
public class Constants {
    public static final String STR_EX01_TITLE = "Exercici 01: Retornar el checksum SHA-1 i MD-5 per a la cadena entrada per l'usuari.";
    public static final String STR_EX02_TITLE = "Exercici 02: Retornar el checksum SHA-1 i MD5 per al fitxer que es troba a la ruta entrada per parametre al terminal.";
    public static final String STR_EX05_TITLE = "Exercici 05: Programa que encripta text introduit per l'usuari de manera ininterrompuda.";
    public static final String STR_EX06_TITLE = "Exercici 06: Encriptar i desencriptar amb RSA desant la clau publica a un fitxer";
    
    public static final String STR_INPUT_STRING_REQUEST = "Enter string: ";
    public static final String STR_INPUT_STRING_CONTINUOUSLY_REQUEST = "Enter strings, will encrypt when find an empty line: ";
    
    public static final String STR_PROVIDER_JCE = "SunJCE";
    public static final String STR_PROVIDER_KEY_FACTORY = "PBKDF2WithHmacSHA256";
    public static final String STR_USER_DIR_PROPERTY_KEY = "user.dir";
    public static final String STR_KEYS_PATH = System.getProperty(STR_USER_DIR_PROPERTY_KEY) + "keys/";
    
    public static final String STR_MODE_SHA1 = "SHA-1";
    public static final String STR_MODE_MD5 = "MD5";
    public static final String STR_MODE_RSA = "RSA";
    public static final String STR_MODE_AES_CIPHER = "AES/ECB/PKCS5Padding";
    public static final String STR_MODE_RSA_CIPHER = "RSA/ECB/PKCS1Padding";
    public static final String STR_MODE_AES_KEY = "AES";
    
    public static final int INT_AES_KEY_SIZE = 256;
    public static final int INT_AES_SALT_SIZE = 8;
    public static final int INT_AES_ITERATION_COUNT = 65536;
    
    public static final String STR_MODE_ENCODING = "UTF-8";
    
    public static final String STR_HEX_FORMAT = "%02x";
    
    public static final String STR_NOT_PROCESSED_ERROR = "Not processed.";
    public static final String STR_ONLY_NUMBERS_ERROR = "Wrong input: only numbers.";
}
