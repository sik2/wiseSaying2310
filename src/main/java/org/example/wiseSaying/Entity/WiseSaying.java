package org.example;

public class WiseSaying {
    private long id;
    private String author;
    private String content;

    WiseSaying(Long id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public long getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getContent() {
        return this.content;
    }

}
