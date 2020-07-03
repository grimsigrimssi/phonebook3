package com.javaex.vo;

public class PersonVo {
	
	private int no;
	private String name;
	private String hp;
	private String company;
	
	public PersonVo() {
	}
	
	public PersonVo(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	public PersonVo(int no, String name, String hp, String company) {
		this.no = no;
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "PersonVo [no=" + no + ", name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}

	

	
	
}
