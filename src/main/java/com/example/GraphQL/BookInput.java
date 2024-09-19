package com.example.GraphQL;

public class BookInput {
    private String name;
    private int pageCount;
    private AuthorInput author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public AuthorInput getAuthor() {
        return author;
    }

    public void setAuthor(AuthorInput author) {
        this.author = author;
    }
}
