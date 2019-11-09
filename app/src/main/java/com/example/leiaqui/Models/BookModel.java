package com.example.leiaqui.Models;

public class BookModel {
    private int Id;
    private String ISBN;
    private String Title;
    private String Category;
    private String Author;
    private String Keyphrase;
    private String Pdate;
    private String Edition;
    private String Publisher;
    private int Npages;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getKeyphrase() {
        return Keyphrase;
    }

    public void setKeyphrase(String keyphrase) {
        Keyphrase = keyphrase;
    }

    public String getPdate() {
        return Pdate;
    }

    public void setPdate(String pdate) {
        Pdate = pdate;
    }

    public String getEdition() {
        return Edition;
    }

    public void setEdition(String edition) {
        Edition = edition;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public int getNpages() {
        return Npages;
    }

    public void setNpages(int npages) {
        Npages = npages;
    }

    @Override
    public String toString(){
        return this.Title + "            " + this.Author;
    }
}
