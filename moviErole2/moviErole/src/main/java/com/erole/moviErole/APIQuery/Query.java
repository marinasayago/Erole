package com.erole.moviErole.APIQuery;

public class Query {
	private String type;
	private String keyWord;
	
	public Query() {}
	
	public Query(String t, String k) {
		type = t;
		keyWord = k;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String typeString) {
		this.type = typeString;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
}
