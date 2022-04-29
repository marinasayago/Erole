
package com.erole.moviErole.APIQuery.model.contentQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "title",
    "originalTitle",
    "fullTitle",
    "type",
    "year",
    "image",
    "releaseDate",
    "runtimeMins",
    "runtimeStr",
    "plot",
    "plotLocal",
    "plotLocalIsRtl",
    "awards",
    "directors",
    "directorList",
    "writers",
    "writerList",
    "stars",
    "starList",
    "actorList",
    "fullCast",
    "genres",
    "genreList",
    "companies",
    "companyList",
    "countries",
    "countryList",
    "languages",
    "languageList",
    "contentRating",
    "imDbRating",
    "imDbRatingVotes",
    "metacriticRating",
    "ratings",
    "wikipedia",
    "posters",
    "images",
    "trailer",
    "boxOffice",
    "tagline",
    "keywords",
    "keywordList",
    "similars",
    "tvSeriesInfo",
    "tvEpisodeInfo",
    "errorMessage"
})
@Generated("jsonschema2pojo")
public class ContentQuery {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("originalTitle")
    private String originalTitle;
    @JsonProperty("fullTitle")
    private String fullTitle;
    @JsonProperty("type")
    private String type;
    @JsonProperty("year")
    private String year;
    @JsonProperty("image")
    private String image;
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("runtimeMins")
    private String runtimeMins;
    @JsonProperty("runtimeStr")
    private String runtimeStr;
    @JsonProperty("plot")
    private String plot;
    @JsonProperty("plotLocal")
    private String plotLocal;
    @JsonProperty("plotLocalIsRtl")
    private Boolean plotLocalIsRtl;
    @JsonProperty("awards")
    private String awards;
    @JsonProperty("directors")
    private String directors;
    @JsonProperty("directorList")
    private List<Director> directorList = null;
    @JsonProperty("writers")
    private String writers;
    @JsonProperty("writerList")
    private List<Writer> writerList = null;
    @JsonProperty("stars")
    private String stars;
    @JsonProperty("starList")
    private List<Star> starList = null;
    @JsonProperty("actorList")
    private List<Actor> actorList = null;
    @JsonProperty("fullCast")
    private Object fullCast;
    @JsonProperty("genres")
    private String genres;
    @JsonProperty("genreList")
    private List<Genre> genreList = null;
    @JsonProperty("companies")
    private String companies;
    @JsonProperty("companyList")
    private List<Company> companyList = null;
    @JsonProperty("countries")
    private String countries;
    @JsonProperty("countryList")
    private List<Country> countryList = null;
    @JsonProperty("languages")
    private String languages;
    @JsonProperty("languageList")
    private List<Language> languageList = null;
    @JsonProperty("contentRating")
    private String contentRating;
    @JsonProperty("imDbRating")
    private String imDbRating;
    @JsonProperty("imDbRatingVotes")
    private String imDbRatingVotes;
    @JsonProperty("metacriticRating")
    private String metacriticRating;
    @JsonProperty("ratings")
    private Object ratings;
    @JsonProperty("wikipedia")
    private Object wikipedia;
    @JsonProperty("posters")
    private Object posters;
    @JsonProperty("images")
    private Object images;
    @JsonProperty("trailer")
    private Object trailer;
    @JsonProperty("boxOffice")
    private BoxOffice boxOffice;
    @JsonProperty("tagline")
    private String tagline;
    @JsonProperty("keywords")
    private String keywords;
    @JsonProperty("keywordList")
    private List<String> keywordList = null;
    @JsonProperty("similars")
    private List<Similar> similars = null;
    @JsonProperty("tvSeriesInfo")
    private Object tvSeriesInfo;
    @JsonProperty("tvEpisodeInfo")
    private Object tvEpisodeInfo;
    @JsonProperty("errorMessage")
    private Object errorMessage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("originalTitle")
    public String getOriginalTitle() {
        return originalTitle;
    }

    @JsonProperty("originalTitle")
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    @JsonProperty("fullTitle")
    public String getFullTitle() {
        return fullTitle;
    }

    @JsonProperty("fullTitle")
    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("releaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("releaseDate")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("runtimeMins")
    public String getRuntimeMins() {
        return runtimeMins;
    }

    @JsonProperty("runtimeMins")
    public void setRuntimeMins(String runtimeMins) {
        this.runtimeMins = runtimeMins;
    }

    @JsonProperty("runtimeStr")
    public String getRuntimeStr() {
        return runtimeStr;
    }

    @JsonProperty("runtimeStr")
    public void setRuntimeStr(String runtimeStr) {
        this.runtimeStr = runtimeStr;
    }

    @JsonProperty("plot")
    public String getPlot() {
        return plot;
    }

    @JsonProperty("plot")
    public void setPlot(String plot) {
        this.plot = plot;
    }

    @JsonProperty("plotLocal")
    public String getPlotLocal() {
        return plotLocal;
    }

    @JsonProperty("plotLocal")
    public void setPlotLocal(String plotLocal) {
        this.plotLocal = plotLocal;
    }

    @JsonProperty("plotLocalIsRtl")
    public Boolean getPlotLocalIsRtl() {
        return plotLocalIsRtl;
    }

    @JsonProperty("plotLocalIsRtl")
    public void setPlotLocalIsRtl(Boolean plotLocalIsRtl) {
        this.plotLocalIsRtl = plotLocalIsRtl;
    }

    @JsonProperty("awards")
    public String getAwards() {
        return awards;
    }

    @JsonProperty("awards")
    public void setAwards(String awards) {
        this.awards = awards;
    }

    @JsonProperty("directors")
    public String getDirectors() {
        return directors;
    }

    @JsonProperty("directors")
    public void setDirectors(String directors) {
        this.directors = directors;
    }

    @JsonProperty("directorList")
    public List<Director> getDirectorList() {
        return directorList;
    }

    @JsonProperty("directorList")
    public void setDirectorList(List<Director> directorList) {
        this.directorList = directorList;
    }

    @JsonProperty("writers")
    public String getWriters() {
        return writers;
    }

    @JsonProperty("writers")
    public void setWriters(String writers) {
        this.writers = writers;
    }

    @JsonProperty("writerList")
    public List<Writer> getWriterList() {
        return writerList;
    }

    @JsonProperty("writerList")
    public void setWriterList(List<Writer> writerList) {
        this.writerList = writerList;
    }

    @JsonProperty("stars")
    public String getStars() {
        return stars;
    }

    @JsonProperty("stars")
    public void setStars(String stars) {
        this.stars = stars;
    }

    @JsonProperty("starList")
    public List<Star> getStarList() {
        return starList;
    }

    @JsonProperty("starList")
    public void setStarList(List<Star> starList) {
        this.starList = starList;
    }

    @JsonProperty("actorList")
    public List<Actor> getActorList() {
        return actorList;
    }

    @JsonProperty("actorList")
    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    @JsonProperty("fullCast")
    public Object getFullCast() {
        return fullCast;
    }

    @JsonProperty("fullCast")
    public void setFullCast(Object fullCast) {
        this.fullCast = fullCast;
    }

    @JsonProperty("genres")
    public String getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(String genres) {
        this.genres = genres;
    }

    @JsonProperty("genreList")
    public List<Genre> getGenreList() {
        return genreList;
    }

    @JsonProperty("genreList")
    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    @JsonProperty("companies")
    public String getCompanies() {
        return companies;
    }

    @JsonProperty("companies")
    public void setCompanies(String companies) {
        this.companies = companies;
    }

    @JsonProperty("companyList")
    public List<Company> getCompanyList() {
        return companyList;
    }

    @JsonProperty("companyList")
    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    @JsonProperty("countries")
    public String getCountries() {
        return countries;
    }

    @JsonProperty("countries")
    public void setCountries(String countries) {
        this.countries = countries;
    }

    @JsonProperty("countryList")
    public List<Country> getCountryList() {
        return countryList;
    }

    @JsonProperty("countryList")
    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    @JsonProperty("languages")
    public String getLanguages() {
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    @JsonProperty("languageList")
    public List<Language> getLanguageList() {
        return languageList;
    }

    @JsonProperty("languageList")
    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }

    @JsonProperty("contentRating")
    public String getContentRating() {
        return contentRating;
    }

    @JsonProperty("contentRating")
    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    @JsonProperty("imDbRating")
    public String getImDbRating() {
        return imDbRating;
    }

    @JsonProperty("imDbRating")
    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }

    @JsonProperty("imDbRatingVotes")
    public String getImDbRatingVotes() {
        return imDbRatingVotes;
    }

    @JsonProperty("imDbRatingVotes")
    public void setImDbRatingVotes(String imDbRatingVotes) {
        this.imDbRatingVotes = imDbRatingVotes;
    }

    @JsonProperty("metacriticRating")
    public String getMetacriticRating() {
        return metacriticRating;
    }

    @JsonProperty("metacriticRating")
    public void setMetacriticRating(String metacriticRating) {
        this.metacriticRating = metacriticRating;
    }

    @JsonProperty("ratings")
    public Object getRatings() {
        return ratings;
    }

    @JsonProperty("ratings")
    public void setRatings(Object ratings) {
        this.ratings = ratings;
    }

    @JsonProperty("wikipedia")
    public Object getWikipedia() {
        return wikipedia;
    }

    @JsonProperty("wikipedia")
    public void setWikipedia(Object wikipedia) {
        this.wikipedia = wikipedia;
    }

    @JsonProperty("posters")
    public Object getPosters() {
        return posters;
    }

    @JsonProperty("posters")
    public void setPosters(Object posters) {
        this.posters = posters;
    }

    @JsonProperty("images")
    public Object getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(Object images) {
        this.images = images;
    }

    @JsonProperty("trailer")
    public Object getTrailer() {
        return trailer;
    }

    @JsonProperty("trailer")
    public void setTrailer(Object trailer) {
        this.trailer = trailer;
    }

    @JsonProperty("boxOffice")
    public BoxOffice getBoxOffice() {
        return boxOffice;
    }

    @JsonProperty("boxOffice")
    public void setBoxOffice(BoxOffice boxOffice) {
        this.boxOffice = boxOffice;
    }

    @JsonProperty("tagline")
    public String getTagline() {
        return tagline;
    }

    @JsonProperty("tagline")
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    @JsonProperty("keywords")
    public String getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("keywordList")
    public List<String> getKeywordList() {
        return keywordList;
    }

    @JsonProperty("keywordList")
    public void setKeywordList(List<String> keywordList) {
        this.keywordList = keywordList;
    }

    @JsonProperty("similars")
    public List<Similar> getSimilars() {
        return similars;
    }

    @JsonProperty("similars")
    public void setSimilars(List<Similar> similars) {
        this.similars = similars;
    }

    @JsonProperty("tvSeriesInfo")
    public Object getTvSeriesInfo() {
        return tvSeriesInfo;
    }

    @JsonProperty("tvSeriesInfo")
    public void setTvSeriesInfo(Object tvSeriesInfo) {
        this.tvSeriesInfo = tvSeriesInfo;
    }

    @JsonProperty("tvEpisodeInfo")
    public Object getTvEpisodeInfo() {
        return tvEpisodeInfo;
    }

    @JsonProperty("tvEpisodeInfo")
    public void setTvEpisodeInfo(Object tvEpisodeInfo) {
        this.tvEpisodeInfo = tvEpisodeInfo;
    }

    @JsonProperty("errorMessage")
    public Object getErrorMessage() {
        return errorMessage;
    }

    @JsonProperty("errorMessage")
    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ContentQuery.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("originalTitle");
        sb.append('=');
        sb.append(((this.originalTitle == null)?"<null>":this.originalTitle));
        sb.append(',');
        sb.append("fullTitle");
        sb.append('=');
        sb.append(((this.fullTitle == null)?"<null>":this.fullTitle));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("year");
        sb.append('=');
        sb.append(((this.year == null)?"<null>":this.year));
        sb.append(',');
        sb.append("image");
        sb.append('=');
        sb.append(((this.image == null)?"<null>":this.image));
        sb.append(',');
        sb.append("releaseDate");
        sb.append('=');
        sb.append(((this.releaseDate == null)?"<null>":this.releaseDate));
        sb.append(',');
        sb.append("runtimeMins");
        sb.append('=');
        sb.append(((this.runtimeMins == null)?"<null>":this.runtimeMins));
        sb.append(',');
        sb.append("runtimeStr");
        sb.append('=');
        sb.append(((this.runtimeStr == null)?"<null>":this.runtimeStr));
        sb.append(',');
        sb.append("plot");
        sb.append('=');
        sb.append(((this.plot == null)?"<null>":this.plot));
        sb.append(',');
        sb.append("plotLocal");
        sb.append('=');
        sb.append(((this.plotLocal == null)?"<null>":this.plotLocal));
        sb.append(',');
        sb.append("plotLocalIsRtl");
        sb.append('=');
        sb.append(((this.plotLocalIsRtl == null)?"<null>":this.plotLocalIsRtl));
        sb.append(',');
        sb.append("awards");
        sb.append('=');
        sb.append(((this.awards == null)?"<null>":this.awards));
        sb.append(',');
        sb.append("directors");
        sb.append('=');
        sb.append(((this.directors == null)?"<null>":this.directors));
        sb.append(',');
        sb.append("directorList");
        sb.append('=');
        sb.append(((this.directorList == null)?"<null>":this.directorList));
        sb.append(',');
        sb.append("writers");
        sb.append('=');
        sb.append(((this.writers == null)?"<null>":this.writers));
        sb.append(',');
        sb.append("writerList");
        sb.append('=');
        sb.append(((this.writerList == null)?"<null>":this.writerList));
        sb.append(',');
        sb.append("stars");
        sb.append('=');
        sb.append(((this.stars == null)?"<null>":this.stars));
        sb.append(',');
        sb.append("starList");
        sb.append('=');
        sb.append(((this.starList == null)?"<null>":this.starList));
        sb.append(',');
        sb.append("actorList");
        sb.append('=');
        sb.append(((this.actorList == null)?"<null>":this.actorList));
        sb.append(',');
        sb.append("fullCast");
        sb.append('=');
        sb.append(((this.fullCast == null)?"<null>":this.fullCast));
        sb.append(',');
        sb.append("genres");
        sb.append('=');
        sb.append(((this.genres == null)?"<null>":this.genres));
        sb.append(',');
        sb.append("genreList");
        sb.append('=');
        sb.append(((this.genreList == null)?"<null>":this.genreList));
        sb.append(',');
        sb.append("companies");
        sb.append('=');
        sb.append(((this.companies == null)?"<null>":this.companies));
        sb.append(',');
        sb.append("companyList");
        sb.append('=');
        sb.append(((this.companyList == null)?"<null>":this.companyList));
        sb.append(',');
        sb.append("countries");
        sb.append('=');
        sb.append(((this.countries == null)?"<null>":this.countries));
        sb.append(',');
        sb.append("countryList");
        sb.append('=');
        sb.append(((this.countryList == null)?"<null>":this.countryList));
        sb.append(',');
        sb.append("languages");
        sb.append('=');
        sb.append(((this.languages == null)?"<null>":this.languages));
        sb.append(',');
        sb.append("languageList");
        sb.append('=');
        sb.append(((this.languageList == null)?"<null>":this.languageList));
        sb.append(',');
        sb.append("contentRating");
        sb.append('=');
        sb.append(((this.contentRating == null)?"<null>":this.contentRating));
        sb.append(',');
        sb.append("imDbRating");
        sb.append('=');
        sb.append(((this.imDbRating == null)?"<null>":this.imDbRating));
        sb.append(',');
        sb.append("imDbRatingVotes");
        sb.append('=');
        sb.append(((this.imDbRatingVotes == null)?"<null>":this.imDbRatingVotes));
        sb.append(',');
        sb.append("metacriticRating");
        sb.append('=');
        sb.append(((this.metacriticRating == null)?"<null>":this.metacriticRating));
        sb.append(',');
        sb.append("ratings");
        sb.append('=');
        sb.append(((this.ratings == null)?"<null>":this.ratings));
        sb.append(',');
        sb.append("wikipedia");
        sb.append('=');
        sb.append(((this.wikipedia == null)?"<null>":this.wikipedia));
        sb.append(',');
        sb.append("posters");
        sb.append('=');
        sb.append(((this.posters == null)?"<null>":this.posters));
        sb.append(',');
        sb.append("images");
        sb.append('=');
        sb.append(((this.images == null)?"<null>":this.images));
        sb.append(',');
        sb.append("trailer");
        sb.append('=');
        sb.append(((this.trailer == null)?"<null>":this.trailer));
        sb.append(',');
        sb.append("boxOffice");
        sb.append('=');
        sb.append(((this.boxOffice == null)?"<null>":this.boxOffice));
        sb.append(',');
        sb.append("tagline");
        sb.append('=');
        sb.append(((this.tagline == null)?"<null>":this.tagline));
        sb.append(',');
        sb.append("keywords");
        sb.append('=');
        sb.append(((this.keywords == null)?"<null>":this.keywords));
        sb.append(',');
        sb.append("keywordList");
        sb.append('=');
        sb.append(((this.keywordList == null)?"<null>":this.keywordList));
        sb.append(',');
        sb.append("similars");
        sb.append('=');
        sb.append(((this.similars == null)?"<null>":this.similars));
        sb.append(',');
        sb.append("tvSeriesInfo");
        sb.append('=');
        sb.append(((this.tvSeriesInfo == null)?"<null>":this.tvSeriesInfo));
        sb.append(',');
        sb.append("tvEpisodeInfo");
        sb.append('=');
        sb.append(((this.tvEpisodeInfo == null)?"<null>":this.tvEpisodeInfo));
        sb.append(',');
        sb.append("errorMessage");
        sb.append('=');
        sb.append(((this.errorMessage == null)?"<null>":this.errorMessage));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.keywords == null)? 0 :this.keywords.hashCode()));
        result = ((result* 31)+((this.year == null)? 0 :this.year.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.tvEpisodeInfo == null)? 0 :this.tvEpisodeInfo.hashCode()));
        result = ((result* 31)+((this.plotLocal == null)? 0 :this.plotLocal.hashCode()));
        result = ((result* 31)+((this.companies == null)? 0 :this.companies.hashCode()));
        result = ((result* 31)+((this.companyList == null)? 0 :this.companyList.hashCode()));
        result = ((result* 31)+((this.actorList == null)? 0 :this.actorList.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.fullCast == null)? 0 :this.fullCast.hashCode()));
        result = ((result* 31)+((this.image == null)? 0 :this.image.hashCode()));
        result = ((result* 31)+((this.images == null)? 0 :this.images.hashCode()));
        result = ((result* 31)+((this.runtimeMins == null)? 0 :this.runtimeMins.hashCode()));
        result = ((result* 31)+((this.countries == null)? 0 :this.countries.hashCode()));
        result = ((result* 31)+((this.countryList == null)? 0 :this.countryList.hashCode()));
        result = ((result* 31)+((this.plotLocalIsRtl == null)? 0 :this.plotLocalIsRtl.hashCode()));
        result = ((result* 31)+((this.keywordList == null)? 0 :this.keywordList.hashCode()));
        result = ((result* 31)+((this.tagline == null)? 0 :this.tagline.hashCode()));
        result = ((result* 31)+((this.contentRating == null)? 0 :this.contentRating.hashCode()));
        result = ((result* 31)+((this.boxOffice == null)? 0 :this.boxOffice.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.writerList == null)? 0 :this.writerList.hashCode()));
        result = ((result* 31)+((this.directors == null)? 0 :this.directors.hashCode()));
        result = ((result* 31)+((this.genreList == null)? 0 :this.genreList.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.imDbRating == null)? 0 :this.imDbRating.hashCode()));
        result = ((result* 31)+((this.trailer == null)? 0 :this.trailer.hashCode()));
        result = ((result* 31)+((this.runtimeStr == null)? 0 :this.runtimeStr.hashCode()));
        result = ((result* 31)+((this.plot == null)? 0 :this.plot.hashCode()));
        result = ((result* 31)+((this.genres == null)? 0 :this.genres.hashCode()));
        result = ((result* 31)+((this.ratings == null)? 0 :this.ratings.hashCode()));
        result = ((result* 31)+((this.imDbRatingVotes == null)? 0 :this.imDbRatingVotes.hashCode()));
        result = ((result* 31)+((this.tvSeriesInfo == null)? 0 :this.tvSeriesInfo.hashCode()));
        result = ((result* 31)+((this.languageList == null)? 0 :this.languageList.hashCode()));
        result = ((result* 31)+((this.wikipedia == null)? 0 :this.wikipedia.hashCode()));
        result = ((result* 31)+((this.fullTitle == null)? 0 :this.fullTitle.hashCode()));
        result = ((result* 31)+((this.languages == null)? 0 :this.languages.hashCode()));
        result = ((result* 31)+((this.releaseDate == null)? 0 :this.releaseDate.hashCode()));
        result = ((result* 31)+((this.similars == null)? 0 :this.similars.hashCode()));
        result = ((result* 31)+((this.posters == null)? 0 :this.posters.hashCode()));
        result = ((result* 31)+((this.errorMessage == null)? 0 :this.errorMessage.hashCode()));
        result = ((result* 31)+((this.metacriticRating == null)? 0 :this.metacriticRating.hashCode()));
        result = ((result* 31)+((this.directorList == null)? 0 :this.directorList.hashCode()));
        result = ((result* 31)+((this.writers == null)? 0 :this.writers.hashCode()));
        result = ((result* 31)+((this.stars == null)? 0 :this.stars.hashCode()));
        result = ((result* 31)+((this.originalTitle == null)? 0 :this.originalTitle.hashCode()));
        result = ((result* 31)+((this.awards == null)? 0 :this.awards.hashCode()));
        result = ((result* 31)+((this.starList == null)? 0 :this.starList.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ContentQuery) == false) {
            return false;
        }
        ContentQuery rhs = ((ContentQuery) other);
        return (((((((((((((((((((((((((((((((((((((((((((((((((this.keywords == rhs.keywords)||((this.keywords!= null)&&this.keywords.equals(rhs.keywords)))&&((this.year == rhs.year)||((this.year!= null)&&this.year.equals(rhs.year))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.tvEpisodeInfo == rhs.tvEpisodeInfo)||((this.tvEpisodeInfo!= null)&&this.tvEpisodeInfo.equals(rhs.tvEpisodeInfo))))&&((this.plotLocal == rhs.plotLocal)||((this.plotLocal!= null)&&this.plotLocal.equals(rhs.plotLocal))))&&((this.companies == rhs.companies)||((this.companies!= null)&&this.companies.equals(rhs.companies))))&&((this.companyList == rhs.companyList)||((this.companyList!= null)&&this.companyList.equals(rhs.companyList))))&&((this.actorList == rhs.actorList)||((this.actorList!= null)&&this.actorList.equals(rhs.actorList))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.fullCast == rhs.fullCast)||((this.fullCast!= null)&&this.fullCast.equals(rhs.fullCast))))&&((this.image == rhs.image)||((this.image!= null)&&this.image.equals(rhs.image))))&&((this.images == rhs.images)||((this.images!= null)&&this.images.equals(rhs.images))))&&((this.runtimeMins == rhs.runtimeMins)||((this.runtimeMins!= null)&&this.runtimeMins.equals(rhs.runtimeMins))))&&((this.countries == rhs.countries)||((this.countries!= null)&&this.countries.equals(rhs.countries))))&&((this.countryList == rhs.countryList)||((this.countryList!= null)&&this.countryList.equals(rhs.countryList))))&&((this.plotLocalIsRtl == rhs.plotLocalIsRtl)||((this.plotLocalIsRtl!= null)&&this.plotLocalIsRtl.equals(rhs.plotLocalIsRtl))))&&((this.keywordList == rhs.keywordList)||((this.keywordList!= null)&&this.keywordList.equals(rhs.keywordList))))&&((this.tagline == rhs.tagline)||((this.tagline!= null)&&this.tagline.equals(rhs.tagline))))&&((this.contentRating == rhs.contentRating)||((this.contentRating!= null)&&this.contentRating.equals(rhs.contentRating))))&&((this.boxOffice == rhs.boxOffice)||((this.boxOffice!= null)&&this.boxOffice.equals(rhs.boxOffice))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.writerList == rhs.writerList)||((this.writerList!= null)&&this.writerList.equals(rhs.writerList))))&&((this.directors == rhs.directors)||((this.directors!= null)&&this.directors.equals(rhs.directors))))&&((this.genreList == rhs.genreList)||((this.genreList!= null)&&this.genreList.equals(rhs.genreList))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.imDbRating == rhs.imDbRating)||((this.imDbRating!= null)&&this.imDbRating.equals(rhs.imDbRating))))&&((this.trailer == rhs.trailer)||((this.trailer!= null)&&this.trailer.equals(rhs.trailer))))&&((this.runtimeStr == rhs.runtimeStr)||((this.runtimeStr!= null)&&this.runtimeStr.equals(rhs.runtimeStr))))&&((this.plot == rhs.plot)||((this.plot!= null)&&this.plot.equals(rhs.plot))))&&((this.genres == rhs.genres)||((this.genres!= null)&&this.genres.equals(rhs.genres))))&&((this.ratings == rhs.ratings)||((this.ratings!= null)&&this.ratings.equals(rhs.ratings))))&&((this.imDbRatingVotes == rhs.imDbRatingVotes)||((this.imDbRatingVotes!= null)&&this.imDbRatingVotes.equals(rhs.imDbRatingVotes))))&&((this.tvSeriesInfo == rhs.tvSeriesInfo)||((this.tvSeriesInfo!= null)&&this.tvSeriesInfo.equals(rhs.tvSeriesInfo))))&&((this.languageList == rhs.languageList)||((this.languageList!= null)&&this.languageList.equals(rhs.languageList))))&&((this.wikipedia == rhs.wikipedia)||((this.wikipedia!= null)&&this.wikipedia.equals(rhs.wikipedia))))&&((this.fullTitle == rhs.fullTitle)||((this.fullTitle!= null)&&this.fullTitle.equals(rhs.fullTitle))))&&((this.languages == rhs.languages)||((this.languages!= null)&&this.languages.equals(rhs.languages))))&&((this.releaseDate == rhs.releaseDate)||((this.releaseDate!= null)&&this.releaseDate.equals(rhs.releaseDate))))&&((this.similars == rhs.similars)||((this.similars!= null)&&this.similars.equals(rhs.similars))))&&((this.posters == rhs.posters)||((this.posters!= null)&&this.posters.equals(rhs.posters))))&&((this.errorMessage == rhs.errorMessage)||((this.errorMessage!= null)&&this.errorMessage.equals(rhs.errorMessage))))&&((this.metacriticRating == rhs.metacriticRating)||((this.metacriticRating!= null)&&this.metacriticRating.equals(rhs.metacriticRating))))&&((this.directorList == rhs.directorList)||((this.directorList!= null)&&this.directorList.equals(rhs.directorList))))&&((this.writers == rhs.writers)||((this.writers!= null)&&this.writers.equals(rhs.writers))))&&((this.stars == rhs.stars)||((this.stars!= null)&&this.stars.equals(rhs.stars))))&&((this.originalTitle == rhs.originalTitle)||((this.originalTitle!= null)&&this.originalTitle.equals(rhs.originalTitle))))&&((this.awards == rhs.awards)||((this.awards!= null)&&this.awards.equals(rhs.awards))))&&((this.starList == rhs.starList)||((this.starList!= null)&&this.starList.equals(rhs.starList))));
    }

}
