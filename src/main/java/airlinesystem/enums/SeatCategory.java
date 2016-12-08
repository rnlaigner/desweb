package airlinesystem.enums;

public enum SeatCategory 
{
	DEAL("Promocional",1),
    ECONOMY("Classe Econômica",2),
    EXECUTIVE("Classe Executiva",4),
    FIRST_CLASS ("Primeira Classe",8);
    
    private final String value;   
    private final int factor;

    private SeatCategory(String s, int factor) {
        this.value = s;
        this.factor = factor;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : value.equals(otherName);
    }

    public String getValue() {
       return this.value;
    }
    
    public String getName() {
        return this.value;
     }
    
    public int getFactor() {
        return this.factor;
     }
}
