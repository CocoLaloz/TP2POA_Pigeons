
public enum EtatsPigeon {
	endormi("0"),
	actif("1"),
	effray�("2");

	private String name = "";

	EtatsPigeon(String name){
		this.name = name;
	}

	public String toString() {
		return name; 
	}
}
