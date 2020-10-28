package io.darkshot.app.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.darkshot.app.R;
import io.darkshot.app.model.FeedModel;

public class FeedAdapter extends RecyclerView.Adapter < FeedAdapter.FeedAdapterHolder > {
	
	Context context;
	List < FeedModel > feedModels;
	
	
	public FeedAdapter ( Context context , List < FeedModel > feedModels ) {
		this.context = context;
		this.feedModels = feedModels;
	}
	
	@NonNull
	@Override
	public FeedAdapterHolder onCreateViewHolder ( @NonNull ViewGroup parent , int viewType ) {
		return new FeedAdapterHolder ( LayoutInflater.from ( context ).inflate ( R.layout.custom_feed_item , parent , false ) );
	}
	
	@Override
	public void onBindViewHolder ( @NonNull FeedAdapterHolder holder , int position ) {
		
		Picasso.get ( ).load ( feedModels.get ( position ).getLandscape ( ) ).placeholder ( R.drawable.bg ).error ( R.drawable.bg ).into ( holder.previewImg );
		holder.photographer.setText ( feedModels.get ( position ).getPhotographer ( ) );
	}
	
	@Override
	public int getItemCount ( ) {
		return feedModels.size ( );
	}
	
	class FeedAdapterHolder extends RecyclerView.ViewHolder {
		
		ImageView previewImg;
		TextView photographer;
		
		public FeedAdapterHolder ( @NonNull View itemView ) {
			super ( itemView );
			
			previewImg = itemView.findViewById ( R.id.preview_img );
			photographer = itemView.findViewById ( R.id.photographer );
		}
		
	}
}
