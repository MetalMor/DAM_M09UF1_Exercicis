package exercicis;

import exercicis.builder.ExerciciBuilder;
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
        ExerciciBuilder.setArgs(args);
        IExercici ex = ExerciciBuilder.make(6);
        ex.execute();
    }
    
}
