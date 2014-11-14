package be.vdab.entities;

import java.io.Serializable;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String pwd;
	private String name;
	
	public Player(String pwd, String name, int id){
		setPwd(pwd);
		setName(name);
		setId(id);
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}