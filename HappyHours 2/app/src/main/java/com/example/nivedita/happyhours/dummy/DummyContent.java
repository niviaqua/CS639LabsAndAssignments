package com.example.nivedita.happyhours.dummy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.ImageReader;
import android.widget.ImageView;

import com.example.nivedita.happyhours.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();


    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Aceluck", "530 9th Ave New York NY 10018", "4pm - 7:30pm",  Integer.valueOf(R.drawable.aceluck)));
        addItem(new DummyItem("2", "Atomic Wings", "531 9th Ave New York NY 10018", "4pm - 7:30pm", Integer.valueOf(R.drawable.aceluck)));
        addItem(new DummyItem("3", "Curry Hut", "550 9th Ave New York NY 10018", "4pm - 7:30pm", Integer.valueOf(R.drawable.curryhut)));
        addItem(new DummyItem("4", "Baluchis", "570 9th Ave New York NY 10018", "4pm - 7:30pm" , Integer.valueOf(R.drawable.baluchis)));
        addItem(new DummyItem("5", "Blue Ruin", "532 9th Ave New York NY 10018", "4pm - 7:30pm" , Integer.valueOf(R.drawable.blueruin)));
        addItem(new DummyItem("6", "EOS", "566 9th Ave New York NY 10018", "4pm - 7:30pm" , Integer.valueOf(R.drawable.snackeos)));
        addItem(new DummyItem("7", "Market Cafe","531 9th Ave New York NY 10018", "4pm - 7:30pm" , Integer.valueOf(R.drawable.marketplace)));
        addItem(new DummyItem("8", "Thai Select","366 9th Ave New York NY 10018", "4pm - 7:30pm" , Integer.valueOf(R.drawable.thaiselect)));
        addItem(new DummyItem("9", "Hells Kitchen","523 9th Ave New York NY 10018", "4pm - 7:30pm" , Integer.valueOf(R.drawable.hk)));
        addItem(new DummyItem("12", "Pie Face","348 9th Ave New York NY 10018", "4pm - 7:30pm", Integer.valueOf(R.drawable.pieface) ));
        addItem(new DummyItem("13", "Shorty's","462 9th Ave New York NY 10018", "4pm - 7:30pm" , Integer.valueOf(R.drawable.shortys)));
        addItem(new DummyItem("14", "Subway","240 9th Ave New York NY 10018", "4pm - 7:30pm" , Integer.valueOf(R.drawable.subway)));
        addItem(new DummyItem("15", "Frames","534 9th Ave New York NY 10018", "4pm - 7:30pm" , Integer.valueOf(R.drawable.frames)));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class DummyItem {
        public String id;
        public String content;
        public String address;
        public String resttime;
        public Integer restImage;

        public DummyItem(String id, String content, String address, String resttime, Integer restImage) {
            this.id = id;
            this.content = content;
            this.address= address;
            this.resttime= resttime;
            this.restImage= restImage;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
