package io.darkshot.app.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import io.darkshot.app.R;

public class Splash extends AppCompatActivity {

	ImageView sp_logo;
	String mode;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );

		SharedPreferences sp = getSharedPreferences ( "dark_mode" , MODE_PRIVATE );
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

		Window window = this.getWindow ( );
		window.clearFlags ( WindowManager.LayoutParams.FLAG_FULLSCREEN );
		//window.addFlags ( WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS );
		getWindow ( ).setFlags ( WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN );
		//window.setStatusBarColor ( ContextCompat.getColor ( this , R.color.colorPrimary ) );
		//View decor = getWindow ( ).getDecorView ( );
		//decor.setSystemUiVisibility ( View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR );
		setContentView ( R.layout.activity_main );

		//ID DECLARATION
		sp_logo = findViewById ( R.id.splogo );
		sp_logo.setOnClickListener ( v -> new Intent ( Splash.this , DashboardActivity.class ) );
		//sp_logo.animate ( ).scaleX ( 1.2f ).scaleY ( 1.2f ).setInterpolator ( new AnticipateInterpolator ( ) ).setDuration ( 1300 );
		new Handler ( ).postDelayed ( ( ) -> startActivity ( new Intent ( Splash.this , DashboardActivity.class ) ) , 5000 );
	}
}