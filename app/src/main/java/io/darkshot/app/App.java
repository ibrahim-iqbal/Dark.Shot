package io.darkshot.app;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

public class App extends Application {
	
	private static Application instance;
	
	@Override
	public void onCreate ( ) {
		super.onCreate ( );
		if ( instance == null ) {
			instance = this;
			
			Picasso.Builder builder = new Picasso.Builder ( instance );
			Log.d ( getClass ().getSimpleName (),"builder : "+builder );
			Toast.makeText ( instance , "builder"+builder , Toast.LENGTH_SHORT ).show ( );
			builder.memoryCache ( new LruCache ( instance ) );
			builder.defaultBitmapConfig ( Bitmap.Config.ARGB_8888 );
			builder.indicatorsEnabled ( true );
			
			Picasso picasso = builder.build ( );
			try {
				Picasso.setSingletonInstance ( picasso );
			}
			catch ( IllegalStateException ignored ) {
			
			}
		}
	}
}
