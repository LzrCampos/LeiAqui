package com.example.leiaqui.Book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.leiaqui.DAO.BookDAO;
import com.example.leiaqui.Models.BookModel;
import com.example.leiaqui.R;

import java.util.List;

public class BookActivity extends AppCompatActivity {

    private ListView list;
    private static List<BookModel> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Button btnNewBook = (Button) findViewById(R.id.btnNewBook);

        btnNewBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookActivity.this, BookResgisterActivity.class);
                startActivity(intent);
            }
        });

        final BookDAO db = new BookDAO(getBaseContext());

        list = (ListView) findViewById(R.id.listViewBook);
        bookList = db.findAllBook();
        ArrayAdapter<BookModel> adapter = new ArrayAdapter<BookModel>(this, android.R.layout.simple_list_item_1, bookList);
        list.setAdapter(adapter);

        list.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final BookModel bookModel;
                bookModel = bookList.get(position);
                Intent intent = new Intent(BookActivity.this, BookUpdatedActivity.class);
                String bookId = String.valueOf(bookModel.getId());
                intent.putExtra("bookModel", bookId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        BookDAO db = new BookDAO(getBaseContext());
        bookList.clear();
        list.invalidateViews();

        list = (ListView) findViewById(R.id.listViewBook);
        bookList = db.findAllBook();
        ArrayAdapter<BookModel> adapter = new ArrayAdapter<BookModel>(this, android.R.layout.simple_list_item_1, bookList);
        list.setAdapter(adapter);
    }
}
