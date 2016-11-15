package airlinesystem.model.enums;

public enum AgeCategory 
{
    ADULT("Adulto"),
    CHILD("Crian�a"), 
    BABY("Beb�");
	
	private final String name;
	
	private AgeCategory(String s)
	{
		this.name = s;
	}
	
    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String getName() {
       return this.name;
    }
}
