package com.example.sergiomoral.rss_feed.presentation.ui.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sergiomoral.rss_feed.R;
import com.example.sergiomoral.rss_feed.domain.entities.Item;
import com.example.sergiomoral.rss_feed.utils.Utils;

import java.util.ArrayList;


public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private static final String TAG = "ItemsAdapter";
    public ArrayList<Item> itemArrayList;
    private Context context;
    private OnItemListener itemListener;

    public ItemsAdapter(ArrayList<Item> itemArrayList, Context context, OnItemListener itemListener) {
        this.itemArrayList = itemArrayList;
        this.context = context;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_feed, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (itemArrayList.get(i) != null) {
            viewHolder.bind(itemArrayList.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public interface OnItemListener {

        void showDetails(Item item);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle;
        TextView mDescription;
        ImageView mThubnail;
        CardView mParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTitle = itemView.findViewById(R.id.tv_title);
            this.mDescription = itemView.findViewById(R.id.tv_description);
            this.mThubnail = itemView.findViewById(R.id.iv_thubnail);
            this.mParent = itemView.findViewById(R.id.parent_layout);
        }

        public void bind(final Item item) {

            Glide.with(context)
                    .asBitmap()
                    .load(item.getThubnail())
                    .into(mThubnail);

            mTitle.setText(item.getTitle());
            mDescription.setText(Utils.getDescriptionFormatted(item.getDescription()));
            mParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemListener.showDetails(item);
                }
            });
        }
    }
}
