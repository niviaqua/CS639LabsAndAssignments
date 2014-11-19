package com.example.nivedita.happyhours.dummy;

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

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Aceluck", "530 9th Ave New York NY 10018" ));
        addItem(new DummyItem("2", "Atomic Wings", "531 9th Ave New York NY 10018"));
        addItem(new DummyItem("3", "Curry Hut", "550 9th Ave New York NY 10018"));
        addItem(new DummyItem("4", "Baluchis", "570 9th Ave New York NY 10018"));
        addItem(new DummyItem("5", "Subway", "532 9th Ave New York NY 10018"));
        addItem(new DummyItem("6", "EOS", "566 9th Ave New York NY 10018"));
        addItem(new DummyItem("7", "Market Cafe","531 9th Ave New York NY 10018"));
        addItem(new DummyItem("8", "Thai Select","366 9th Ave New York NY 10018"));
        addItem(new DummyItem("9", "Hells Kitchen","436 9th Ave New York NY 10018"));
        addItem(new DummyItem("10", "HK Lounge","482 9th Ave New York NY 10018"));
        addItem(new DummyItem("11", "Dave's Tavern","977 9th Ave New York NY 10018"));
        addItem(new DummyItem("12", "Pie Face","348 9th Ave New York NY 10018"));
        addItem(new DummyItem("13", "Shorty's","462 9th Ave New York NY 10018"));
        addItem(new DummyItem("14", "Blue Fin","240 9th Ave New York NY 10018"));
        addItem(new DummyItem("15", "Frames","534 9th Ave New York NY 10018"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);


    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;
        public String address;

        public DummyItem(String id, String content, String address) {
            this.id = id;
            this.content = content;
            this.address= address;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
