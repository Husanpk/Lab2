package com.cst2335.lab2;

import static com.cst2335.lab2.R.id.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatRoomActivity extends AppCompatActivity {
Button send;
Button recieve;
EditText editText;
TextView editSend;
TextView editRecieve ;
ListView listView;
    private SQLiteDatabase db;

    ArrayList<Message> arraylist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);
        send = findViewById(R.id.send);
        recieve = findViewById(R.id.recieve);
        editText = findViewById(recievetext);
        editSend = findViewById(textView);
        editRecieve = findViewById(textView3);
        listView = findViewById(R.id.listView);
        MessageDatabase dbOpener = new MessageDatabase(this);
        db = dbOpener.getWritableDatabase();


        String [] columns = {MessageDatabase.COL_ID, MessageDatabase.COL_CHAT,
                MessageDatabase.COL_CHAT_TYPE};
        Cursor results = db.query(false, MessageDatabase.TABLE_NAME, columns,
                null, null, null, null, null, null);


        printCursor(results);


        int idColIndex = results.getColumnIndex(MessageDatabase.COL_ID);
        int chatColIndex = results.getColumnIndex(MessageDatabase.COL_CHAT);
        int chatTypeColIndex = results.getColumnIndex(MessageDatabase.COL_CHAT_TYPE);


        results.moveToPosition(-1);
        while(results.moveToNext())
        {
            String message = results.getString(chatColIndex);
            Boolean messageType = results.getInt(chatTypeColIndex) == 1;
            long id = results.getLong(idColIndex);


        }



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = editText.getText().toString();
                Message.message = 1;
                arraylist.add(new Message(R.drawable.row_send, text));
                ChatAdapter chatAdapter = new ChatAdapter(getApplicationContext(), R.layout.sendlayout, arraylist);
                listView.setAdapter(chatAdapter);
                // Add to the database and get new id
                ContentValues cv = new ContentValues();
                // Put string input in the COL_CHAT columnn
                cv.put(MessageDatabase.COL_CHAT, text);
                // Put 1 to stand for true in the COL_CHAT_TYPE column
                cv.put(MessageDatabase.COL_CHAT_TYPE, 1);
                // Insert in the database
                long newId = db.insert(MessageDatabase.TABLE_NAME, null, cv);

            }
        });

        recieve.setOnClickListener(view -> {
            String text = editText.getText().toString();

            Message realmessage = new Message(R.drawable.row_recieve, text);

            Message.message = 2;
            arraylist.add(realmessage);
            ChatAdapter chatAdapter = new ChatAdapter(getApplicationContext(), R.layout.recievelayout, arraylist);
            listView.setAdapter(chatAdapter);
            // Add to the database and get new id
            ContentValues cv = new ContentValues();
            // Put string input in the COL_CHAT columnn
            cv.put(MessageDatabase.COL_CHAT, text);
            // Put 1 to stand for true in the COL_CHAT_TYPE column
            cv.put(MessageDatabase.COL_CHAT_TYPE, 1);


            });




        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ChatRoomActivity.this);
            ChatAdapter chatAdapter = new ChatAdapter(this,R.drawable.row_recieve,arraylist);
            builder.setTitle("Do you want to delete the message")
                    .setMessage("The row is: "+position)
                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialog, which) -> {
                        arraylist.remove(position); //remove the message
                        chatAdapter.notifyDataSetChanged();
                    })
                    .setNegativeButton("No", (dialog, which) -> {

                    });
            AlertDialog dialog  = builder.create();
            dialog.show();
            return true;
        });


    }

    public void printCursor(Cursor cus) {
        // Database Version
        Log.i("The Version of Db :", String.valueOf(MessageDatabase.VERSION_NUM));

        // The number of columns in the cursor.
        Log.i("Number  of Columns:", String.valueOf(cus.getColumnCount()));

        // The name of the columns in the cursor.
        for (int i = 0; i < cus.getColumnCount(); i++) {
            Log.i("The Column is  " + i, cus.getColumnName(i));
        }


        // The number of results in the cursor
        Log.i("The Result count:", String.valueOf(cus.getCount()));

        // Each row of results in the cursor.
        int idColumnIndex = cus.getColumnIndex("_id");
        int chatColumnIndex = cus.getColumnIndex("CHAT");
        int chatTypeColumnIndex = cus.getColumnIndex("CHAT_TYPE");
        cus.moveToFirst();
        while (!cus.isAfterLast()) {
            Long id = cus.getLong(idColumnIndex);
            String chat = cus.getString(chatColumnIndex);
            String chatType = cus.getString(chatTypeColumnIndex);

            Log.i("ID: ", String.valueOf(id));
            Log.i("Message: ", chat);
            Log.i("isSent: ", chatType);

            cus.moveToNext();
        }
    }




    }


