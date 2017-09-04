package cn.cerc.android.heartlog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FrmList extends AppCompatActivity {
    ListView lstView;
    List<TransRecord> items;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_list);
        this.setTitle(R.string.list_trans_text);
        lstView = (ListView) findViewById(R.id.lstView);

        Database db = new Database(this);
        items = db.getTrans();

        adapter = new TransAdapter(this, R.layout.list_item, items);
        lstView.setAdapter(adapter);
    }

    public static void startForm(AppCompatActivity content) {
        Intent intent = new Intent();
        intent.setClass(content, FrmList.class);
        content.startActivity(intent);

    }
}
