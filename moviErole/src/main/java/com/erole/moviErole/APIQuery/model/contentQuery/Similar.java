
package com.erole.moviErole.APIQuery.model.contentQuery;

public class Similar {

    private String id;
    private String title;
    private String image;
    private String imDbRating;
    
	public Similar(String id, String title, String image, String imDbRating) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.imDbRating = imDbRating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImDbRating() {
		return imDbRating;
	}

	public void setImDbRating(String imDbRating) {
		this.imDbRating = imDbRating;
	}
}
