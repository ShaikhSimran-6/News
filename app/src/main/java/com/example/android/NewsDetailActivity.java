package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {


    String title, content, description, imageUrl, url;
    private TextView titleTV, subDescTV, contentTV;

    private ImageView newsIV;
    private Button readNewsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        description = getIntent().getStringExtra("description");
        imageUrl = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");

        titleTV = findViewById(R.id.idTVTitle);
        subDescTV = findViewById(R.id.idTVSubDescription);
        contentTV = findViewById(R.id.idTVContent);
        newsIV = findViewById(R.id.idIVNewsD);
        readNewsBtn = findViewById(R.id.btnReadNews);

        titleTV.setText(title);
        subDescTV.setText(description);
        contentTV.setText(content);
        Picasso.get().load(url).into(newsIV);

        readNewsBtn.setOnClickListener((View view) -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(imageUrl));
            startActivity(i);
        });


    }
}