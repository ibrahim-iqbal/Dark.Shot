package io.darkshot.app.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.darkshot.app.R;
import io.darkshot.app.controller.FeedAdapter;

public class DashboardActivity extends AppCompatActivity {

	FeedAdapter feedAdapter;
	RecyclerView feed;
	FloatingActionButton fabDash;
	String mode = "";
	SharedPreferences sp;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );

		sp = getSharedPreferences ( "dark_mode" , MODE_PRIVATE );
		mode = sp.getString ( "mode" , "" );

		if ( mode.equals ( "" ) ) {
			setTheme ( R.style.Theme_DarkShot_Dark );
			Window window = this.getWindow ( );
			window.clearFlags ( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
			window.addFlags ( WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS );
			window.setStatusBarColor ( ContextCompat.getColor ( this , R.color.colorSecondary ) );
		}
		else {
			setTheme ( R.style.Theme_DarkShot_Light );
			Window window = this.getWindow ( );
			window.clearFlags ( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
			window.addFlags ( WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS );
			window.setStatusBarColor ( ContextCompat.getColor ( this , R.color.colorPrimary ) );
			View decor = getWindow ( ).getDecorView ( );
			decor.setSystemUiVisibility ( View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR );
		}

		setContentView ( R.layout.activity_dashboard );

		//ID DECLARATION
		feed = findViewById ( R.id.feed );
		fabDash = findViewById ( R.id.fabDash );
		feedAdapter = new FeedAdapter ( this , 10 );
		//feed.setDemoLayoutManager ( ShimmerRecyclerView.LayoutMangerType.LINEAR_VERTICAL );
		feed.setAdapter ( feedAdapter );

		fabDash.setOnClickListener ( v -> {
			sp = getSharedPreferences ( "dark_mode" , MODE_PRIVATE );
			mode = sp.getString ( "mode" , "" );
			if ( mode.equals ( "" ) ) {
				sp.edit ( ).putString ( "mode" , "light" ).apply ( );
				setTheme ( R.style.Theme_DarkShot_Light );
			}
			else {
				sp.edit ( ).remove ( "mode" ).apply ( );
				setTheme ( R.style.Theme_DarkShot_Dark );
			}
		} );

	}
}