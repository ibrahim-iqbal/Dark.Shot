package io.darkshot.app.view;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import io.darkshot.app.R;
import io.darkshot.app.controller.FeedAdapter;

public class DashboardActivity extends AppCompatActivity {

	FeedAdapter feedAdapter;
	RecyclerView feed;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.activity_dashboard );

		Window window = this.getWindow ( );
		window.clearFlags ( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
		window.addFlags ( WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS );
		window.setStatusBarColor ( ContextCompat.getColor ( this , R.color.colorSecondary ) );
		View decor = getWindow ( ).getDecorView ( );
		decor.setSystemUiVisibility ( View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR );

		//ID DECLARATION
		feed = findViewById ( R.id.feed );
		feedAdapter = new FeedAdapter ( this , 10 );
		//feed.setDemoLayoutManager ( ShimmerRecyclerView.LayoutMangerType.LINEAR_VERTICAL );

		feed.setAdapter ( feedAdapter );
	}
}