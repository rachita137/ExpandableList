package tatastrive.application.expandablelist;

import java.util.HashMap;
import java.util.List;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/*class MyExpandableListAdapter {
    public MyExpandableListAdapter(MainActivity mainActivity, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {

    }
}*/

class MyExpandableListAdapter extends BaseExpandableListAdapter {

    MainActivity mainActivity;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChld;

    public MyExpandableListAdapter(MainActivity mainActivity, List<String> listDataHeader, HashMap<String, List<String>> listDataChld) {
        this.mainActivity = mainActivity;
        this.listDataHeader = listDataHeader;
        this.listDataChld = listDataChld;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChld.get(this.listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDataChld.get(this.listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle=(String)getGroup(groupPosition);
        if (convertView==null){
            LayoutInflater inflater=(LayoutInflater) this.mainActivity.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.activity_group,null);
        }
        TextView textView=(TextView) convertView.findViewById(R.id.tvHearder);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String cheaderTitle=(String)getChild(groupPosition,childPosition);
        if (convertView==null){
            LayoutInflater inflater=(LayoutInflater) this.mainActivity.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.activity_group_c,null);
        }
        TextView textView=(TextView) convertView.findViewById(R.id.tvHearder_c);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(cheaderTitle);

        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
