
package io.darkshot.app.view;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.darkshot.app.R;
import io.darkshot.app.controller.FeedAdapter;
import io.darkshot.app.model.FeedModel;

public class DashboardActivity extends AppCompatActivity {
	
	FeedAdapter feedAdapter;
	RecyclerView feed;
	FloatingActionButton fabDash;
	int imgCount = 32;
	List < FeedModel > feedModels = new ArrayList <> ( );
	RequestQueue requestQueue;
	String url_img, photographer, original, landscape;
	
	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		
		Window window = this.getWindow ( );
		window.clearFlags ( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
		window.addFlags ( WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS );
		window.setStatusBarColor ( ContextCompat.getColor ( this , R.color.colorSecondary ) );
		
		setContentView ( R.layout.activity_dashboard );
		
		//ID DECLARATION
		feed = findViewById ( R.id.feed );
		fabDash = findViewById ( R.id.fabDash );
		feed.setLayoutManager ( new LinearLayoutManager ( this ) );
		
		requestQueue = Volley.newRequestQueue ( this );
		
		url_img = "https://api.pexels.com/v1/search?query=mountains&per_page=" + imgCount;
		
		StringRequest stringRequest = new StringRequest ( Request.Method.GET , url_img , new Response.Listener < String > ( ) {
			@Override
			public void onResponse ( String response ) {
				
				Log.d ( getClass ( ).getSimpleName ( ) , "Image response : " + response );
				Toast.makeText ( DashboardActivity.this , "response" + response , Toast.LENGTH_SHORT ).show ( );
				
				try {
					JSONObject res = new JSONObject ( response );
					
					if ( res.getInt ( "per_page" ) == imgCount && res.getJSONArray ( "photos" ).length ( ) > 0 ) {
						
						JSONArray photos = res.getJSONArray ( "photos" );
						
						for ( int i = 0 ; i < photos.length ( ) ; i++ ) {
							JSONObject obj = photos.getJSONObject ( i );
							photographer = obj.getString ( "photographer" );
							JSONObject src = obj.getJSONObject ( "src" );
							original = src.getString ( "original" );
							landscape = src.getString ( "landscape" );
							feedModels.add ( new FeedModel ( original , landscape , photographer ) );
						}
						
						feedAdapter = new FeedAdapter ( DashboardActivity.this , feedModels );
						feed.setAdapter ( feedAdapter );
					}
				}
				catch ( JSONException e ) {
					e.printStackTrace ( );
				}
			}
		} , new Response.ErrorListener ( ) {
			@Override
			public void onErrorResponse ( VolleyError error ) {
				Log.d ( getClass ( ).getSimpleName ( ) , "VOLLEY ERROR : " + error.getLocalizedMessage ( ) );
				Toast.makeText ( DashboardActivity.this , "VOLLEY ERROR : " + error.getLocalizedMessage ( ) , Toast.LENGTH_SHORT ).show ( );
			}
		} ) {
			@Override
			public Map < String, String > getHeaders ( ) throws AuthFailureError {
				Map < String, String > hm = new HashMap <> ( );
				hm.put ( "Authorization" , "563492ad6f9170000100000146a9d9bbae9d4390b212aa1115f965b8" );
				return hm;
			}
		};
		requestQueue.add ( stringRequest );
		
	}
}