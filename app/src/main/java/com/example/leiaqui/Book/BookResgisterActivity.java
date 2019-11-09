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

public class BookResgisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_resgister);

        Button btnNewBook = (Button)findViewById(R.id.btnRegisterBook);

        btnNewBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDAO bookDAO = new BookDAO(getBaseContext());
                BookModel book = new BookModel();

                EditText etIsbn = (EditText)findViewById(R.id.etISBN);
                EditText etTitle = (EditText)findViewById(R.id.etTitle);
                EditText etCategory = (EditText)findViewById(R.id.etCategory);
                EditText etAuthor = (EditText)findViewById(R.id.etAuthor);
                EditText etKeyphrase = (EditText)findViewById(R.id.etKeyphrase);
                EditText etPdate = (EditText)findViewById(R.id.etPdate);
                EditText etEdition = (EditText)findViewById(R.id.etEdition);
                EditText etPublisher = (EditText)findViewById(R.id.etPublisher);
                EditText etNpages = (EditText)findViewById(R.id.etNpages);

                try {
                    book.setISBN(etIsbn.getText().toString());
                    book.setTitle(etTitle.getText().toString());
                    book.setCategory(etCategory.getText().toString());
                    book.setAuthor(etAuthor.getText().toString());
                    book.setKeyphrase(etKeyphrase.getText().toString());
                    book.setPdate(etPdate.getText().toString());
                    book.setEdition(etEdition.getText().toString());
                    book.setPublisher(etPublisher.getText().toString());
                    book.setNpages(Integer.parseInt(etNpages.getText().toString()));
                } catch (Exception ex){
                    book.setISBN("--");
                    book.setTitle("--");
                    book.setCategory("--");
                    book.setAuthor("--");
                    book.setKeyphrase("--");
                    book.setPdate("--");
                    book.setEdition("--");
                    book.setPublisher("--");
                    book.setNpages(1);
                } finally {
                    String result = bookDAO.insertBook(book);
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                    finish();
                }



            }
        });
    }
}
