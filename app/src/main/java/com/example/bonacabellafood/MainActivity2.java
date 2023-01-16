package com.example.bonacabellafood;

import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;

import java.util.LinkedList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initPost();
    }
    private void initPost() {

        API.getJSON("https://brzahrana.rs/wp-json/wp/v2/posts",new ReadDataHandler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                String odgovor = getJson();

                try {
                    JSONArray array = new JSONArray(odgovor);
                    LinkedList<PostModel> posts = PostModel.parseJSONArray(array);

                    TextView labelJson = findViewById(R.id.labelJson);
                    labelJson.setText("");
                    TextView labelJSon = findViewById(R.id.labelJSon);
                    labelJSon.setText("");

                    for (PostModel p: posts){
                        labelJson.append(
                                "[" + p.getDate() + "]" + " "+ "\n" + p.getTitle() + "\n"+
                                        android.text.Html.fromHtml(p.getContent()).toString().trim().replaceAll("\n\n", "\n") + "\n\n"+
                                        android.text.Html.fromHtml(p.getExcerpt()).toString().trim().replaceAll("\n\n", "\n") + "\n\n"
                        );
                    }

                }catch (Exception e){ }
            }
        });
        ((TextView)findViewById(R.id.labelJson)).setText("Molimo vas sačekajte trenutak...");
        ((TextView)findViewById(R.id.labelJSon)).setText("Učitava se...");
    }
}