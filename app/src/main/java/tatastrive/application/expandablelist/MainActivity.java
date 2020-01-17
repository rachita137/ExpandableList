package tatastrive.application.expandablelist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyExpandableListAdapter listAdapter;

    ExpandableListView exp;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exp = findViewById(R.id.lvExp);

        prepareListData();

        listAdapter = new MyExpandableListAdapter(this, listDataHeader, listDataChild);
        exp.setAdapter(listAdapter);

        exp.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                display_msg("Group Selected", listDataHeader.get(groupPosition));
                return false;
            }
        });
        exp.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                display_msg("Child Selected", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                return false;
            }
        });
        exp.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),listDataHeader.get(groupPosition)+"Expanded",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void display_msg(String title, String messgae) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(messgae);
        builder.show();
    }


    private void prepareListData() {

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // adding header data

        listDataHeader.add("Commedy now");
        listDataHeader.add("TV9");
        listDataHeader.add("Marval");

        // Adding child data
        List<String> top250 = new ArrayList<>();
        top250.add("Big bang theory");
        top250.add("Young sheldon");
        top250.add("Suits");
        top250.add("2 and half men");
        top250.add("man with plan");

        List<String> nowShowing = new ArrayList<>();
        nowShowing.add("suits");
        nowShowing.add("breaking bad");
        nowShowing.add("happy man");
        nowShowing.add("vikram or vetal");
        nowShowing.add("chacha chaudhari");

        List<String> comingSoon = new ArrayList<>();
        comingSoon.add("hulk");
        comingSoon.add("thor");
        comingSoon.add("Iorn man");
        comingSoon.add("Black panther");
        comingSoon.add("Venome");

        // header ,child data

        listDataChild.put(listDataHeader.get(0), top250);
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);

    }
}
