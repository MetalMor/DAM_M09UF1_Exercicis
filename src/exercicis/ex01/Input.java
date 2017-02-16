package exercicis.ex01;

import exercicis.Constants;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase para manejar los inputs del usuario. Tiene un <code>Scanner</code>
 * incorporado desde donde se pillan las entradas.
 * @author m0R
 */
public class Input {
    
    private Scanner _scanner;
    
    private static final String STR_ONLY_NUMBERS_ERROR = Constants.STR_ONLY_NUMBERS_ERROR;
    
    public Input() { }
    
    public Input(Scanner scanner) {
        this();
        setScanner(scanner);
    }
    
    /**
     * Pide un <code>String</code> por la entrada del usuario.
     * @return <code>String</code> entrado por el usuario.
     */
    public String readString() {
        return getScanner().nextLine();
    }
    
    /**
     * Pide un <code>Integer</code> por la entrada del usuario.
     * @return <code>Integer</code> entrado por el usuario
     * @throws InputMismatchException 
     */
    public Integer readInt() throws InputMismatchException {
        Integer input;
        do {
            try {
                input = getScanner().nextInt();
            } catch(InputMismatchException imEx) {
                System.out.println(STR_ONLY_NUMBERS_ERROR);
                input = null;
                setScanner(new Scanner(System.in));
            }
        } while(input == null);
        return input;
    }
    
    /**
     * Retorna el <code>Scanner</code> de este objeto.
     * @return <code>Scanner</code> que se esta utilizando.
     */
    public Scanner getScanner() {
        setScanner(new Scanner(System.in));
        return _scanner;
    }
    
    /**
     * Define el <code>Scanner</code> a utilizar.
     * @param scanner <code>Scanner</code> a utilizar.
     */
    public final void setScanner(Scanner scanner) {
        if(scanner != null) _scanner = scanner;
    }
}
