package io.darkshot.app.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import io.darkshot.app.R;

public class Splash extends AppCompatActivity {
	
	ImageView sp_logo;
	
	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.activity_main );
		
		//ID DECLARATION
		sp_logo = findViewById ( R.id.splogo );
		sp_logo.animate ( ).scaleX ( 1.2f ).scaleY ( 1.2f ).setInterpolator ( new AnticipateInterpolator ( ) ).setDuration ( 1300 );
		new Handler ( ).postDelayed ( ( ) -> startActivity ( new Intent ( Splash.this , DashboardActivity.class ) ) , 5000 );
	}
}