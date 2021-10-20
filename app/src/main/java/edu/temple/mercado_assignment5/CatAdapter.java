package edu.temple.mercado_assignment5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CatAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Cat> cats;
    LayoutInflater inflater;

    public CatAdapter (Context context, ArrayList cats)
    {
        this.context = context;
        this.cats = cats;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return cats.size();
    }

    @Override
    public Object getItem(int position)
    {
        return cats.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = inflater.inflate(R.layout.gridview_layout, null);

        ImageView catImg = convertView.findViewById(R.id.catimg);
        catImg.setImageResource(cats.get(position).getImgID());

        TextView catText = convertView.findViewById(R.id.cattext);
        catText.setText(cats.get(position).getName());

        return convertView;
    }

}
