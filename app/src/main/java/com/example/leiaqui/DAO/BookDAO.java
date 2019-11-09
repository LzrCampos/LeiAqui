package com.example.leiaqui.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.leiaqui.Models.BookModel;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private SQLiteDatabase db;
    private CreateDatabase createDB;

    public BookDAO(Context context) {
        createDB = new CreateDatabase(context);
    }

    public String insertBook(BookModel book) {
        db = createDB.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ISBN", book.getISBN());
        values.put("TITLE", book.getTitle());
        values.put("CATEGORY", book.getCategory());
        values.put("AUTHOR", book.getAuthor());
        values.put("KEYPHRASE", book.getKeyphrase());
        values.put("PDATE", book.getPdate());
        values.put("EDITION", book.getEdition());
        values.put("PUBLISHER", book.getPublisher());
        values.put("NPAGES", book.getNpages());

        long result = db.insert("BOOK", null, values);
        db.close();
        if (result == -1)
            return "Erro ao inserir novo leitor";
        else
            return "Leitor Inserido com sucesso";
    }

    public String updatedBook(BookModel book, String id) {
        db = createDB.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ISBN", book.getISBN());
        values.put("TITLE", book.getTitle());
        values.put("CATEGORY", book.getCategory());
        values.put("AUTHOR", book.getAuthor());
        values.put("KEYPHRASE", book.getKeyphrase());
        values.put("PDATE", book.getPdate());
        values.put("EDITION", book.getEdition());
        values.put("PUBLISHER", book.getPublisher());
        values.put("NPAGES", book.getNpages());

        long result = db.update("BOOK", values, "ID = ?", new String[]{id});
        db.close();

        if (result == -1)
            return "Erro ao atualizar livro";
        else
            return "Livro atualizado com sucesso";
    }

    public String deleteBookById(String id){
        long result;
        db = createDB.getWritableDatabase();

        result = db.delete("BOOK", "ID = ?", new String[]{id});
        db.close();

        if (result == -1)
            return "Erro ao apagar livro";
        else
            return "Livro apagado com sucesso";
    }

    public List<BookModel> findAllBook() {
        Cursor cursor;
        List<BookModel> listBook = new ArrayList<>();
        db = createDB.getReadableDatabase();
        cursor = db.query("BOOK", new String[]{
                "ID", "ISBN", "TITLE", "CATEGORY", "AUTHOR", "KEYPHRASE", "PDATE", "EDITION", "PUBLISHER", "NPAGES"},
                null, null, null, null, null);

        while (cursor.moveToNext()){
            BookModel bookModel = new BookModel();
            bookModel.setId(cursor.getInt(0));
            bookModel.setISBN(cursor.getString(1));
            bookModel.setTitle(cursor.getString(2));
            bookModel.setCategory(cursor.getString(3));
            bookModel.setAuthor(cursor.getString(4));
            bookModel.setKeyphrase(cursor.getString(5));
            bookModel.setPdate(cursor.getString(6));
            bookModel.setEdition(cursor.getString(7));
            bookModel.setPublisher(cursor.getString(8));
            bookModel.setNpages(cursor.getInt(9));
            listBook.add(bookModel);
        }
        db.close();
        return listBook;
    }

    public BookModel findBookById(int id) {
        db = createDB.getReadableDatabase();
        Cursor cursor = db.query("BOOK", new String[]{"ID", "ISBN", "TITLE", "CATEGORY", "AUTHOR", "KEYPHRASE", "PDATE", "EDITION", "PUBLISHER", "NPAGES"},
                "ID="+id, null, null, null, null);

        BookModel book = new BookModel();
        if (cursor != null) {
            cursor.moveToFirst();
            book.setId(cursor.getInt(0));
            book.setISBN(cursor.getString(1));
            book.setTitle(cursor.getString(2));
            book.setCategory(cursor.getString(3));
            book.setAuthor(cursor.getString(4));
            book.setKeyphrase(cursor.getString(5));
            book.setPdate(cursor.getString(6));
            book.setEdition(cursor.getString(7));
            book.setPublisher(cursor.getString(8));
            book.setNpages(cursor.getInt(9));
        }
        db.close();
        return book;
    }
}

