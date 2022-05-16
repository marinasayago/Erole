
package com.erole.moviErole.APIQuery.model.contentQuery;

public class Actor {

    private String id;
    private String image;
    private String name;
    private String asCharacter;
    
    public Actor() {}
    
    public Actor(String id, String image, String name, String asCharacter) {
    	this.id = id;
    	this.image = image;
    	this.name = name;
    	this.asCharacter = asCharacter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsCharacter() {
        return asCharacter;
    }

    public void setAsCharacter(String asCharacter) {
        this.asCharacter = asCharacter;
    }
}
