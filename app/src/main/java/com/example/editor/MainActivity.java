package com.example.editor;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.irshulx.Editor;
import com.github.irshulx.models.EditorTextStyle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
Editor editor;
    private static  int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editor = (Editor) findViewById(R.id.editor);


        //findViewById(R.id.action_h3).setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
             //   editor.updateTextStyle(EditorTextStyle.H3);
            //}
        //});
        findViewById(R.id.action_bold).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.updateTextStyle(EditorTextStyle.BOLD);
            }
        });
        findViewById(R.id.action_Italic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 editor.updateTextStyle(EditorTextStyle.ITALIC);
            }
        });

        //findViewById(R.id.action_indent).setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  editor.updateTextStyle(EditorTextStyle.INDENT);
            //}
        //});
        //findViewById(R.id.action_outdent).setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  editor.updateTextStyle(EditorTextStyle.OUTDENT);
            //}
        //});
        findViewById(R.id.action_bulleted).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.insertList(false);
            }
        });
        findViewById(R.id.action_color).setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                editor.updateTextColor("#FF3333");
            }
        });
        findViewById(R.id.action_unordered_numbered).setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               editor.insertList(true);
            }
        });
        findViewById(R.id.action_insert_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), images.class);
                startActivity(intent);

               // editor.openImagePicker();
            }
        });

        findViewById(R.id.action_hr).setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               editor.insertDivider();
           }
        });
        findViewById(R.id.action_insert_link).setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               editor.insertLink();
            }
        });
        findViewById(R.id.action_erase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clearAllContents();
            }
        });

        //findViewById(R.id.action_blockquote).setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  editor.updateTextStyle(EditorTextStyle.BLOCKQUOTE);
           // }
        //});
        editor.render();
    }



}
