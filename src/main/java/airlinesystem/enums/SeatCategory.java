package airlinesystem.enums;

public enum SeatCategory 
{
    ECONOMY ("Tarifa Cheia",2),
    EXECUTIVE("Executiva",4),
    FIRST_CLASS ("Primeira Classe",8);
    
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
