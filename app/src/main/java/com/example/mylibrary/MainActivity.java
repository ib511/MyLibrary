package com.example.mylibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        EditText etPages = findViewById(R.id.etPages);
        EditText etAuthur = findViewById(R.id.etAuthur);
        EditText etBook = findViewById(R.id.etBook);
        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String BookText = etBook.getText().toString();
                if (BookText.isEmpty()) {
                    etBook.setError("חובה למלא את שם הסופר");
                    etBook.requestFocus();
                    return;
                }

                String AuthorText = etAuthur.getText().toString();
                if (AuthorText.isEmpty()) {
                    etAuthur.setError("חובה למלא את שם הסופר");
                    etAuthur.requestFocus();
                    return;
                }
                String pagesText = etPages.getText().toString();
                if (pagesText.isEmpty()) {
                    etPages.setError("חובה למלא מספר עמודים");
                    etPages.requestFocus();
                    return;
                }


            }
        });
    }
}