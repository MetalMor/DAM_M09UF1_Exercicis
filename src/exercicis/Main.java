package exercicis;

import exercicis.ex01.Ex01;
import exercicis.template.IExercici;

/**
 *
 * @author m0r
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IExercici ex = new Ex01();
        ex.execute();
    }
    
}
