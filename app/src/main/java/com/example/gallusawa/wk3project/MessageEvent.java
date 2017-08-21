package com.example.gallusawa.wk3project;

import java.util.ArrayList;

/**
 * Created by gallusawa on 8/21/17.
 */

public class MessageEvent {
    String action;
    ArrayList<Books> Book, BookSub;
    boolean pages_validation;
    private  Books;

    public MessageEvent(String action, ArrayList<? extends Books> amazonBook, ArrayList<? extends Books> amazonBookSub, boolean pages_validation) {
        this.action = action;
        this.Book = Book;
        this.BookSub = BookSub;
        this.pages_validation = pages_validation;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ArrayList<Books> getBooks() {
        return Books;
    }

    public void setBooks(ArrayList<Books> Book) {
        this.Books = Books;
    }

    public ArrayList<Books> getBookSub() {
        return BookSub;
    }

    public void setAmazonBookSub(ArrayList<Books> BookSub) {
        this.BookSub = BookSub;
    }

    public boolean isPages_validation() {
        return pages_validation;
    }

    public void setPages_validation(boolean pages_validation) {
        this.pages_validation = pages_validation;
    }
}