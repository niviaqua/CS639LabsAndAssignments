package com.example.nivedita.happyhours;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.widget.TextView;


import com.example.nivedita.happyhours.dummy.DummyContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;

    private String[] listDataHeader;
    private String[][] listDataChild;

    public static final String ARG_ITEM_ID = "item_id";

    private DummyContent.DummyItem mItem;
    private ImageView imgphone;
    private ImageView imgMap;
    private ImageView imgRestImg;
    private ImageView childImage;

    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {

            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
        listDataHeader = new String[] { "Food", "Drinks", "Delivery Options" };
        listDataChild = new String [][] {
                { "50% off on appetizers" },
                { "$5 Beers", "$6 Wine", "$8 Champagne" },
                { "Seamless", "Grubhub", "Delivery.com", "Eat24" },

        };


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imgphone = (ImageView) getView().findViewById(R.id.phone);
        imgphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+16467558893"));
                startActivity(intent);
            }
        });

        final String uri= "geo:40.75667,-73.993668?z=18";
        imgMap=  (ImageView)getView().findViewById(R.id.location);
        imgMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.content);
            ((TextView) rootView.findViewById(R.id.item_detail_2)).setText(mItem.address);
            ((TextView) rootView.findViewById(R.id.item_detail_3)).setText(mItem.resttime);
            ((ImageView) rootView.findViewById (R.id.imageView)).setImageResource(mItem.restImage);


        }
      /*  if (listDataHeader[0].equals("Food")){
            ((ImageView) rootView.findViewById (R.id.childImage)).setImageDrawable(getResources().getDrawable(R.drawable.food));
        }
        else if (listDataHeader[1].equals("Drinks")){
            ((ImageView) rootView.findViewById (R.id.childImage)).setImageDrawable(getResources().getDrawable(R.drawable.happyhouricon));
        }
*/

        return rootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);
        expListView.setAdapter(new ExpandableListAdapter(listDataHeader, listDataChild));
        expListView.setGroupIndicator(null);

    }

    public class ExpandableListAdapter extends BaseExpandableListAdapter {


        private LayoutInflater inf;
        private String[] _listDataHeader;
        private String[][] _listDataChild;

        public ExpandableListAdapter(String[] _listDataHeader, String[][] _listDataChild) {
            inf=LayoutInflater.from(getActivity());
            this._listDataHeader = listDataHeader;
            this._listDataChild = listDataChild;
        }

        @Override
        public Object getChild(int groupPosition, int childPosititon) {
            return listDataChild[groupPosition][childPosititon];
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                convertView = inf.inflate(R.layout.list_item, parent, false);
                holder = new ViewHolder();

                holder.text = (TextView) convertView.findViewById(R.id.lblListItem);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(getChild(groupPosition, childPosition).toString());

            return convertView;
        }


        @Override
        public int getChildrenCount(int groupPosition) {
            return listDataChild[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return listDataHeader[groupPosition];
        }

        @Override
        public int getGroupCount() {
            return this._listDataHeader.length;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = inf.inflate(R.layout.list_group, parent, false);

                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.lblListHeader);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(getGroup(groupPosition).toString());

            return convertView;
        }


        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
        private class ViewHolder{
            TextView text;
        }
    }
}
