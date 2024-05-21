package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSubject, btnAuthor, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubject = findViewById(R.id.buttonSubject);
        btnAuthor = findViewById(R.id.buttonAuthor);
        btnExit = findViewById(R.id.buttonExit);

        btnAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogAuthor();
            }
        });

        // CLICK SUBJECT
        btnSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Chuyển qua activity subject
                Intent intent = new Intent(MainActivity.this, ActivitySubject.class);
                startActivity(intent);
            }
        });


        // CLICK EXIT
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogExit();
            }
        });
    }

    // Hàm hiển thị cửa số dialog exit
    private void DialogExit() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogexit);

        dialog.setCanceledOnTouchOutside(false);
        Button btnYes = dialog.findViewById(R.id.buttonYes);
        Button btnNo = dialog.findViewById(R.id.buttonNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);

                // Thoát
                Intent intent1 = new Intent(Intent.ACTION_MAIN);
                intent1.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent1);
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();

    }

    // Hiển thị thông tin tác giả
    private void DialogAuthor() {
//        Tạo đối tượng của cửa sổ Dialog
        Dialog dialog = new Dialog(this);
        // Nạp layout vào dialog
        dialog.setContentView(R.layout.dialoginformation);
        dialog.show();
    }
}