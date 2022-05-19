
package com.erole.moviErole.APIQuery.model.contentQuery;

import java.util.List;

public class ContentQuery {

    private String id;
    private String title;
    private String originalTitle;
    private String type;
    private String year;
    private String image;
    private String releaseDate;
    private String runtimeMins;
    private String plot;
    private String awards;
    private String directors;
    private String writers;
    private String stars;
    private List<Actor> actorList = null;
    private String genres;
    private String companies;
    private String countries;
    private String languages;
    private String contentRating;
    private String imDbRating;
    private String imDbRatingVotes;
    private String metacriticRating;
    private String trailer;
    private String tagline;
    private String keywords;
    private List<Similar> similars = null;
    private String errorMessage;
    
	public ContentQuery(String id, String title, String originalTitle, String type, String year, String image,
			String releaseDate, String runtimeMins, String plot, String awards, String directors, String writers,
			String stars, List<Actor> actorList, String genres, String companies, String countries, String languages,
			String contentRating, String imDbRating, String imDbRatingVotes, String metacriticRating, String trailer,
			String tagline, String keywords, List<Similar> similars, String errorMessage) {
		super();
		this.id = id;
		this.title = title;
		this.originalTitle = originalTitle;
		this.type = type;
		this.year = year;
		this.image = image;
		this.releaseDate = releaseDate;
		this.runtimeMins = runtimeMins;
		this.plot = plot;
		this.awards = awards;
		this.directors = directors;
		this.writers = writers;
		this.stars = stars;
		this.actorList = actorList;
		this.genres = genres;
		this.companies = companies;
		this.countries = countries;
		this.languages = languages;
		this.contentRating = contentRating;
		this.imDbRating = imDbRating;
		this.imDbRatingVotes = imDbRatingVotes;
		this.metacriticRating = metacriticRating;
		this.trailer = trailer;
		this.tagline = tagline;
		this.keywords = keywords;
		this.similars = similars;
		this.errorMessage = errorMessage;
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

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRuntimeMins() {
		return runtimeMins;
	}

	public void setRuntimeMins(String runtimeMins) {
		this.runtimeMins = runtimeMins;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getWriters() {
		return writers;
	}

	public void setWriters(String writers) {
		this.writers = writers;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getCompanies() {
		return companies;
	}

	public void setCompanies(String companies) {
		this.companies = companies;
	}

	public String getCountries() {
		return countries;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getContentRating() {
		return contentRating;
	}

	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}

	public String getImDbRating() {
		return imDbRating;
	}

	public void setImDbRating(String imDbRating) {
		this.imDbRating = imDbRating;
	}

	public String getImDbRatingVotes() {
		return imDbRatingVotes;
	}

	public void setImDbRatingVotes(String imDbRatingVotes) {
		this.imDbRatingVotes = imDbRatingVotes;
	}

	public String getMetacriticRating() {
		return metacriticRating;
	}

	public void setMetacriticRating(String metacriticRating) {
		this.metacriticRating = metacriticRating;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<Similar> getSimilars() {
		return similars;
	}

	public void setSimilars(List<Similar> similars) {
		this.similars = similars;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "[" + id + ", " + title + ", " + year + "]";
	}
}