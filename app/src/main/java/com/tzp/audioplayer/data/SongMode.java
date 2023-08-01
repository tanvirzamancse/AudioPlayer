package com.tzp.audioplayer.data;

public class SongMode {
    private String title;
    private String url;

    public SongMode(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public SongMode() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
