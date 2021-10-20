package edu.temple.mercado_assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //Classwide Declarations
    GridView gridview;
    ImageView imageView;
    TextView textView;
    public static Resources res;
    int[] catImgArray;
    ArrayList<Cat> catArray;
    public static final String NAME = "@string/intent_cat_name";
    public static final String DESC = "@string/intent_cat_desc";
    public static final String IMG = "@string/intent_cat_img";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = getResources();
        this.setTitle(res.getString(R.string.app_name));

        gridview = findViewById(R.id.gridView);
        textView = findViewById(R.id.prompt);

        String[] catNames = res.getStringArray(R.array.cat_names);
        String[] catDescs = res.getStringArray(R.array.cat_descriptions);
        catArray = new ArrayList<Cat>();
        for(int i = 0; i < catNames.length; i++)
            catArray.add(new Cat(catNames[i], catDescs[i]));

        catImgArray = new int[]{
                R.drawable.kitten,
                R.drawable.oldcat,
                R.drawable.supercat,
                R.drawable.fancycat,
                R.drawable.buffcat,
                R.drawable.covidcat};

        for(int i = 0; i < catArray.size(); i++)
        {
            catArray.get(i).setImgID(catImgArray[i]);
        }

        CatAdapter catAdapter = new CatAdapter(this, catArray);
        gridview.setAdapter(catAdapter);

        /*
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    newActivity(position);
                }


            });

         */
    }

    /*
    private void newActivity(int position)
    {
        Cat currCat = catArray.get(position);
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(NAME, currCat.getName());
        intent.putExtra(DESC, currCat.getDesc());
        intent.putExtra(IMG, currCat.getImgID());
        startActivity(intent);

    }

     */

}
