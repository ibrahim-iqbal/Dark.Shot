package io.darkshot.app.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.darkshot.app.R;

public class ProfileActivity extends AppCompatActivity {

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.activity_profile );
	}
}