package airlinesystem.enums;

public enum SeatCategory 
{
	DEAL("Promocional",1),
    ECONOMY("Classe Econômica",2),//Tarifa Cheia
    EXECUTIVE("Classe Executiva",4),
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
