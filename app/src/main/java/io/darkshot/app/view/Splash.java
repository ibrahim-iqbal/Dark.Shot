package io.darkshot.app.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

import io.darkshot.app.R;

public class Splash extends AppCompatActivity {

	MaterialButton loginbtn;
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
		getWindow ( ).setFlags ( WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN );

		setContentView ( R.layout.activity_main );

		//ID DECLARATION
		loginbtn = findViewById ( R.id.loginbtn );
		loginbtn.setOnClickListener ( v -> {
			startActivity ( new Intent ( Splash.this , DashboardActivity.class ) );
			finish ( );
		} );
	}
}