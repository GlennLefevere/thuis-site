package be.vdab.entities;


public class TextChar {
	private String charachter;
	private String hex;
	
	public TextChar(String charachter, String hex){
		setCharachter(charachter);
		setHex(hex);
	}
	
	public String getCharachter() {
		return charachter;
	}
	public void setCharachter(String charachter) {
		this.charachter = charachter;
	}
	public String getHex() {
		return hex;
	}
	public void setHex(String hex) {
		this.hex = hex;
	}
}
