package airlinesystem.enums;

public enum AgeCategory 
{
    ADULT("Adulto"),
    CHILD("Criança"), 
    BABY("Bebê");
	
	private final String value;
	
	private AgeCategory(String s)
	{
		this.value = s;
	}
	
	public String getValue(){
		return this.value;
	}
	
    public boolean equalsValue(String otherName) {
        return (otherName == null) ? false : value.equals(otherName);
    }
    
    @Override
    public String toString() {
    	return this.name();
    }
}
