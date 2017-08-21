package com.example.gallusawa.wk3project;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by gallusawa on 8/20/17.
 */

public class AmazonBookAdaptor extends RecyclerView.Adapter<AmazonBookAdaptor.ViewHolder> {

    private static final String TAG = "DataAdapter";

    ArrayList<Books> booksList = new ArrayList<>();
    Context context;

    public AmazonBookAdaptor(ArrayList<Books> booksList) {
        this.booksList = booksList;
    }





    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2, textView3;
        ImageView myPictures;

        public ViewHolder(View itemV) {
            super(itemV);

            textView1 = (TextView) itemV.findViewById(R.id.textView1);
            textView2 = (TextView) itemV.findViewById(R.id.textView2);
            textView3= (TextView) itemV.findViewById(R.id.textView3);
            myPictures = (ImageView) itemV.findViewById(R.id.myPictures);
        }
    }

    @Override
    public AmazonBookAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_items, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(AmazonBookAdaptor.ViewHolder holder, int p) {
        final Books item = booksList.get(p);
    //    Log.d(TAG, "onBindViewHolder: " + item.getMedia().getM());
        holder.textView1.setText(item.getTitle());
        holder.textView2.setText(item.getAuthor());
        holder.textView3.setText(item.getImageURL());
 //       Glide.with(holder.itemView.getContext()).load(item.getMedia().getM()).into(holder.myPictures);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                new AlertDialog.Builder(v.getContext())
                        .setIcon(R.drawable.background)
                        .setTitle("Options")
                        .setMessage("Display image:")
                        .setNegativeButton("Small Image", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                final Dialog dialogCustom = new Dialog(v.getContext());
                                dialogCustom.setContentView(R.layout.thumb);
                                ImageView ivThumb = (ImageView) dialogCustom.findViewById(R.id.myThumb);
                                Glide.with(v.getContext()).load(item.getMedia().getM()).into(ivThumb);
                                dialogCustom.show();
                            }
                        })
                        .setPositiveButton("Full Image", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(v.getContext(),BookActivity.class);
                                intent.putExtra("picture",item.getMedia().getM());
                                v.getContext().startActivity(intent);
                            }
                        })
                        .show();

                return true;
            }
        });


        Log.d(TAG, "onBindViewHolder: " + p);
    }

    @Override
    public int getItemCount() {

        return booksList.size();
    }

}