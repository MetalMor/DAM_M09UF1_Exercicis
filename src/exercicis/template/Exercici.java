package exercicis.template;

/**
 *
 * @author m0r
 */
public abstract class Exercici implements IExercici {
    private String _name;
    
    public Exercici(final String name) {
        setName(name);
    }
    
    @Override
    public void execute() {
        System.out.println("Running " + _name);
    }
    
    public String getName() {
        return _name;
    }
    public final void setName(String name) {
        _name = name;
    }
}
