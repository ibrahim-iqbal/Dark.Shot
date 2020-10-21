package io.darkshot.app.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.darkshot.app.R;

public class FeedAdapter extends RecyclerView.Adapter < FeedAdapter.FeedAdapterHolder > {

	Context context;
	int count;

	public FeedAdapter ( Context context , int count ) {
		this.context = context;
		this.count = count;
	}

	@NonNull
	@Override
	public FeedAdapterHolder onCreateViewHolder ( @NonNull ViewGroup parent , int viewType ) {
		return new FeedAdapterHolder ( LayoutInflater.from ( context ).inflate ( R.layout.custom_feed_item , parent , false ) );
	}

	@Override
	public void onBindViewHolder ( @NonNull FeedAdapterHolder holder , int position ) {

	}

	@Override
	public int getItemCount ( ) {
		return count;
	}

	class FeedAdapterHolder extends RecyclerView.ViewHolder {
		public FeedAdapterHolder ( @NonNull View itemView ) {
			super ( itemView );
		}
	}

}
