package com.richard.music.music.model;

public class Music {
    private Long id;
    private String title;
    private String artist;

    public Music() {
    }

    public Music(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public Music(Long id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

}