package com.tomas.moviechecklist.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomas on 1/18/2018.
 */
@Entity
@Table(name = "movies")
@EntityListeners(AuditingEntityListener.class)
public class Movie implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    private String title;

    private boolean completed;

    private String imdbURL;

    private String trailerURL;

    private String imdbID;

    @ElementCollection
    private List<String> genres;

    private String year;

    @ElementCollection
    private List<String> languages;

    private String runTime;

    private Date createdAt;

    private Date updatedAt;

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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getImdbURL() {
        return imdbURL;
    }

    public void setImdbURL(String imdbURL) {
        this.imdbURL = imdbURL;
    }

    public String getTrailerURL() {
        return trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String NEW_LINE = System.lineSeparator();
        sb.append(this.getClass().getName()).append(" Object {").append(NEW_LINE);
        sb.append(" Title: ").append(title).append(NEW_LINE);
        sb.append(" ID: ").append(id).append(NEW_LINE);
        sb.append("}");
        return sb.toString();
    }
}
