package edu.purdue.vieck.topgamesrssfeed;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by vieck on 6/7/15.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    Context mContext;
    private ArrayList<RssDataParser.Item> mDataset;

    public RecycleAdapter(Context context, ArrayList<RssDataParser.Item> dataset) {
        this.mContext = context;
        this.mDataset = dataset;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView rssTitle, rssDescription;
        public ViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view);
            rssTitle = (TextView) v.findViewById(R.id.item_title);
            rssDescription = (TextView) v.findViewById(R.id.item_description);
        }
    }

    public void add(int position, RssDataParser.Item item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(RssDataParser.Item item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        mDataset.clear();
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rss_feed_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final RssDataParser.Item item = mDataset.get(position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.cardView.getContext(), position+"", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(item.link));
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(i);
            }
        });
        holder.rssTitle.setText(item.title);
        holder.rssDescription.setText(item.description);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
