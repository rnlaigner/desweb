package airlinesystem.enums;

public enum SeatCategory 
{
    ECONOMY ("Classe econômica",2),
    EXECUTIVE("Classe executiva",4),
    FIRST_CLASS ("Primeira classe",8);
    
    private final String name;   
    private final int factor;

    private SeatCategory(String s, int factor) {
        this.name = s;
        this.factor = factor;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String getName() {
       return this.name;
    }
    
    public int getFactor() {
        return this.factor;
     }
}
