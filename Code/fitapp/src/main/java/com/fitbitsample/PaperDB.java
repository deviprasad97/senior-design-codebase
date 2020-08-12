package com.fitbitsample;

import io.paperdb.Book;
import io.paperdb.Paper;


public class PaperDB {
    private static PaperDB paperDB;

    private PaperDB() {
    }

    public static PaperDB getInstance() {
        if (paperDB == null) {
            paperDB = new PaperDB();
        }
        return paperDB;
    }

    public Book get() {
        return Paper.book();
    }


    public void write(String key, Object value) {
        Paper.book().write(key, value);
    }

}