package com.example.leiaqui.Book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leiaqui.DAO.BookDAO;
import com.example.leiaqui.DAO.CustomerDAO;
import com.example.leiaqui.Models.BookModel;
import com.example.leiaqui.Models.CustomerModel;
import com.example.leiaqui.R;

public class BookUpdatedActivity extends AppCompatActivity {

    public BookModel book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_updated);

        final BookDAO db = new BookDAO(getBaseContext());

        final String id = this.getIntent().getStringExtra("bookModel");

        book = db.findBookById(Integer.parseInt(id));

        final EditText etUpdatedIsbn = (EditText)findViewById(R.id.etUpdateISBN);
        etUpdatedIsbn.setText(book.getISBN());

        final EditText etUpdatedTitle = (EditText)findViewById(R.id.etUpdateTitle);
        etUpdatedTitle.setText(book.getTitle());

        final EditText etUpdatedCategory = (EditText)findViewById(R.id.etUpdateCategory);
        etUpdatedCategory.setText(book.getCategory());

        final EditText etUpdatedAuthor = (EditText)findViewById(R.id.etUpdateAuthor);
        etUpdatedAuthor.setText(book.getAuthor());

        final EditText etUpdatedKeyphrase = (EditText)findViewById(R.id.etUpdateKeyphrase);
        etUpdatedKeyphrase.setText(book.getKeyphrase());

        final EditText etUpdatedPdate = (EditText)findViewById(R.id.etUpdatePdate);
        etUpdatedPdate.setText(book.getPdate());

        final EditText etUpdatedEdition = (EditText)findViewById(R.id.etUpdateEdition);
        etUpdatedEdition.setText(book.getEdition());

        final EditText etUpdatedPublisher = (EditText)findViewById(R.id.etUpdatePublisher);
        etUpdatedPublisher.setText(book.getPublisher());

        final EditText etUpdatedNpages = (EditText)findViewById(R.id.etUpdateNpages);
        etUpdatedNpages.setText(String.valueOf(book.getNpages()));


        Button btnUpdatedBook = (Button)findViewById(R.id.btnUpdateBook);
        Button btnDeleteBook = (Button)findViewById(R.id.btnDeleteBook);

        btnUpdatedBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDAO bookDAO = new BookDAO(getBaseContext());
                BookModel book = new BookModel();

                book.setISBN(etUpdatedIsbn.getText().toString());
                book.setTitle(etUpdatedTitle.getText().toString());
                book.setCategory(etUpdatedCategory.getText().toString());
                book.setAuthor(etUpdatedAuthor.getText().toString());
                book.setKeyphrase(etUpdatedKeyphrase.getText().toString());
                book.setPdate(etUpdatedPdate.getText().toString());
                book.setEdition(etUpdatedEdition.getText().toString());
                book.setPublisher(etUpdatedPublisher.getText().toString());
                book.setNpages(Integer.parseInt(etUpdatedNpages.getText().toString()));

                String result;
                result = bookDAO.updatedBook(book, id);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                finish();
            }
        });

        btnDeleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDAO bookDAO = new BookDAO(getBaseContext());

                String result = bookDAO.deleteBookById(id);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
