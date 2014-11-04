package com.projectx.game.MainRoutines;

import com.projectx.game.R;
import com.projectx.game.RenderRoutines.GraphicsEngine;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

/**
 * The <b>GameActivity</b> is the main Activity of this app.
 */
public class GameActivity extends Activity {

	//TODO: Git richtig benutzen:
	//aktuelle Version runterladen und auschecken:
	// "Remotes/origin" -> fetch
	// "Branches/RemoteTracking/origin" -> check out as new local branch (z.B. ###)
	// alle Änderungen gehen in den lokalen "Branches/Local/###"
	//
	//eigene Version hochladen:
	// Project -> commit
	// "Branches/Local/###" -> push branch
	
	private static GameActivity instance = null;
	
	public static GameActivity getInstance()
	{
		return instance;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(instance == null)
		{
			instance = this;
		}
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		setContentView(R.layout.activity_game);
		
		if(!Globals.isRunning())
		{
			Log.d("Main", "Init...");
			
			Globals.init();
			GraphicsEngine.init();
			Log.d("Main", "Init done!");
			Globals.setRunning(true);
		}
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}
	
	@Override
	protected void onStop(){
		super.onStop();
		//pause Activity
	}
	
	@Override
	protected void onRestart()
	{
		super.onRestart();
		//reopen Activity
	}
	
	/**
	 * Can be called if the app should be closed.
	 */
	public void quitApp()
	{
		//closes the app-process
		finish();
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			
	    }
	    return super.onKeyDown(keyCode, event);
	}

}
