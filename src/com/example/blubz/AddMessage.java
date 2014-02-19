package com.example.blubz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

/**
 * Created by macalester on 2/19/14.
 */
public class AddMessage extends Activity {

    // I used the following tutorial to learn how to create Java Objects that
    // can be used to control SQL Queries.
    // http://www.vogella.com/tutorials/AndroidSQLite/article.html

    private CommentsDataSource datasource;
    public final static String INTENT_MESSAGE = "com.example.DatabaseTest.MESSAGE";
    private EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_message);

        datasource = new CommentsDataSource(this);
        datasource.open();

        List<Comment> values = datasource.getAllComments();
        editText = (EditText) findViewById(R.id.message);
    }

    public void addMessage(View view){
        String message = editText.getText().toString();
        Comment comment = datasource.createComment(message);
        editText.setText(null);
        editText.setHint("Message added!");
    }

    public void viewMessages(View view){
        Intent intent = new Intent(this, ViewMessage.class);
        List<Comment> allMessages = datasource.getAllComments();
        String fullMessage = "";
        for(Comment singleComment : allMessages){
            fullMessage = fullMessage + " " + singleComment.getComment();
        }
        intent.putExtra(INTENT_MESSAGE, fullMessage);
        startActivity(intent);
    }

    public void clearMessages(View view){
        List<Comment> allMessages = datasource.getAllComments();
        for(Comment singleComment : allMessages){
            datasource.deleteComment(singleComment);
        }
        editText.setText(null);
        editText.setHint("All messages deleted.");
    }
}