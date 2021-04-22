package com.example.letsup;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.BaseAdapter;
        import android.widget.EditText;
        import android.widget.Filter;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.appcompat.app.AppCompatActivity;

        import java.util.ArrayList;
        import java.util.Locale;

public class LiveStreamActivity extends AppCompatActivity {
    private static String locationName;
    private ListView lvCategory;
    private EditText edtSearch;
    private boolean flagaFilter=true;
    public static String sharedValue = null;

    public static String getLocationName(){
        return locationName;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_stream_search);

        edtSearch = (EditText) findViewById(R.id.edtSearch);
        lvCategory = (ListView) findViewById(R.id.lvCategory);

        final ArrayList<Item> cameraList = new ArrayList<Item>();
        // Header ex. Gdansk
        cameraList.add(new SectionItem("Trójmiasto"));
        // Camera Name
        cameraList.add(new EntryItem("Molo Brzeźno"));
        cameraList.add(new EntryItem("Molo Sopot"));
        cameraList.add(new EntryItem("Gdynia"));
        cameraList.add(new EntryItem("Port Morski Gdynia"));
        cameraList.add(new EntryItem("Gdańsk Motława"));

        cameraList.add(new SectionItem("Półwysep Helski"));
        cameraList.add(new EntryItem("Hel"));

        cameraList.add(new SectionItem("Inne lokalizacje"));
        cameraList.add(new EntryItem("Leba"));
        cameraList.add(new EntryItem("Stegna"));
        cameraList.add(new EntryItem("Rowy"));
        cameraList.add(new EntryItem("Jastarnia"));

        // set adapter
        final CategoryAdapter adapter = new CategoryAdapter(this, cameraList);
        lvCategory.setAdapter(adapter);
        lvCategory.setTextFilterEnabled(true);

        // filter on text change
        edtSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(adapter != null)
                {
                    adapter.getFilter().filter(s.toString());
                    flagaFilter = false;
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(flagaFilter==true) {

                    if (cameraList.get(position).isSection() == false) {

                        Intent intent = new Intent(LiveStreamActivity.this, StreamActivity.class);
                        Log.i("Pozycja", "Pozyjcja " + position + " nazwa " + cameraList.get(position).getTitle());
                        locationName = cameraList.get(position).getTitle();

                        switch(cameraList.get(position).getTitle()) {
                            case "Molo Brzeźno":
                                sharedValue ="<iframe src=\"https://static.webcamera.pl/player/gdansk_cam_77aeaf-webcamera.html?preroll-wait=true&amp;&amp;block-autoplay=true\" \n" +
                                        "mozallowfullscreen=\"\" webkitallowfullscreen=\"\" allowfullscreen=\"\" scrollbars=\"no\" scrolling=\"no\"></iframe>";
                                break;
                            case "Molo Sopot":
                                sharedValue ="<iframe src=\"https://imageserver.webcamera.pl/umiesc/sopot-molo\" " +
                                            "width=\"800\" height=\"450\" border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe>";
                                break;
                            case "Gdynia":
                                sharedValue ="<iframe src=\"https://imageserver.webcamera.pl/umiesc/gdynia\" " +
                                        "width=\"800\" height=\"450\" border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe>";
                                break;
                            case "Port Morski Gdynia":
                                sharedValue ="<iframe src=\"https://imageserver.webcamera.pl/umiesc/port-gdynia\" " +
                                        "width=\"800\" height=\"450\" border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe>";
                                break;
                            case "Gdańsk Motława":
                                sharedValue ="<iframe src=\"https://imageserver.webcamera.pl/umiesc/gdansk-motlawa\"" +
                                        " width=\"800\" height=\"450\" border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe>";
                                break;
                            case "Jastarnia":
                                sharedValue ="<iframe src=\"https://imageserver.webcamera.pl/umiesc/jastarnia\"" +
                                        " width=\"800\" height=\"450\" border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe>";
                                break;
                            case "Hel":
                                sharedValue ="<iframe src=\"https://imageserver.webcamera.pl/umiesc/hel\" " +
                                        "width=\"800\" height=\"450\" border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe>";
                                break;
                            case "Leba":
                                sharedValue ="<iframe src=\"https://imageserver.webcamera.pl/umiesc/leba\" " +
                                        "width=\"800\" height=\"450\" border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe>";
                                break;
                            case "Stegna":
                                sharedValue ="<iframe src=\"https://imageserver.webcamera.pl/umiesc/stegna-plaza\"" +
                                        " width=\"800\" height=\"450\" border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe>";
                                break;
                            case "Rowy":
                                sharedValue ="<iframe src=\"https://imageserver.webcamera.pl/umiesc/rowy-plaza\"" +
                                        " width=\"800\" height=\"450\" border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe>";
                                break;
                        }


                        startActivity(intent);

                    } else if (cameraList.get(position).isSection() == true) {
                        Context context = getApplicationContext();
                        CharSequence text = "Please, click location not section!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }else if(flagaFilter==false){

                    Context context = getApplicationContext();
                    CharSequence text = "From this search window you cannot choose category! This option will be availiable soon";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }

        });

    }

    /**
     * row item
     */
    public interface Item {
        public boolean isSection();
        public String getTitle();
    }

    /**
     * Section Item
     */
    public class SectionItem implements Item {
        private final String title;

        public SectionItem(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public boolean isSection() {
            return true;
        }
    }

    /**
     * Entry Item
     */
    public class EntryItem implements Item {
        public final String title;

        public EntryItem(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public boolean isSection() {
            return false;
        }
    }

    /**
     * Adapter
     */
    public class CategoryAdapter extends BaseAdapter implements ListAdapter, com.example.letsup.CategoryAdapter {
        private Context context;
        private ArrayList<Item> item;
        private ArrayList<Item> originalItem;

        public CategoryAdapter() {
            super();
        }

        public CategoryAdapter(Context context, ArrayList<Item> item) {
            this.context = context;
            this.item = item;
            //this.originalItem = item;
        }



        @Override
        public int getCount() {
            return item.size();
        }

        @Override
        public Object getItem(int position) {
            return item.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(View convertView, int position, ViewGroup parent) {
            return null;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (item.get(position).isSection()) {
                // if section header
                convertView = inflater.inflate(R.layout.activity_live_stream_section, parent, false);
                TextView tvSectionTitle = (TextView) convertView.findViewById(R.id.tvSectionTitle);
                tvSectionTitle.setText(((SectionItem) item.get(position)).getTitle());
            }
            else
            {
                // if item
                convertView = inflater.inflate(R.layout.activity_live_stream_item, parent, false);
                TextView tvItemTitle = (TextView) convertView.findViewById(R.id.tvItemTitle);
                tvItemTitle.setText(((EntryItem) item.get(position)).getTitle());
            }

            return convertView;
        }


        /**
         * Filter
         */
        public Filter getFilter()
        {
            Filter filter = new Filter() {

                @SuppressWarnings("unchecked")
                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {

                    item = (ArrayList<Item>) results.values;
                    notifyDataSetChanged();
                }

                @SuppressWarnings("null")
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {

                    FilterResults results = new FilterResults();
                    ArrayList<Item> filteredArrayList = new ArrayList<Item>();



                    if(originalItem == null || originalItem.size() == 0)
                    {
                        originalItem = new ArrayList<Item>(item);
                    }

                    /*
                     * if constraint is null then return original value
                     * else return filtered value
                     */
                    if(constraint == null && constraint.length() == 0)
                    {
                        results.count = originalItem.size();
                        results.values = originalItem;
                    }
                    else
                    {
                        constraint = constraint.toString().toLowerCase(Locale.ENGLISH);
                        for (int i = 0; i < originalItem.size(); i++)
                        {
                            String title = originalItem.get(i).getTitle().toLowerCase(Locale.ENGLISH);
                            if(title.contains(constraint.toString()))
                            {
                                filteredArrayList.add(originalItem.get(i));
                            }
                        }
                        results.count = filteredArrayList.size();
                        results.values = filteredArrayList;
                    }


                    return results;
                }
            };


            return filter;
        }
    }



}