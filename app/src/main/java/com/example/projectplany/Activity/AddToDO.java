package com.example.projectplany.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import org.apache.commons.io.FileUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.projectplany.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AddToDO extends AppCompatActivity {
    private ArrayList<String>items;
    private ArrayAdapter<String>itemsAdapter;
    private ListView lvItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_d_o);
        lvItems=(ListView)findViewById(R.id.lvItems);
        items=new ArrayList<String>();
        readItems();
        itemsAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        lvItems.setAdapter(itemsAdapter);
        items.add("First Item");
        items.add("Second Item");
        setupListViewListener();
    }

    private void readItems(){
        File fileDir= getFilesDir();
        File todoFile = new File(fileDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        }
        catch (IOException e){
            items =new ArrayList<String>();
        }
    }
    private void writeItems(){
        File fileDir= getFilesDir();
        File todoFile = new File(fileDir,"todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    private void setupListViewListener(){
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                        items.remove(pos);
                        itemsAdapter.notifyDataSetChanged();
                        writeItems();
                        return true;
                    }
                }
        );
    }

    public void onAddItem(View v){
        EditText etNewItem =(EditText)findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
        writeItems();
    }
}