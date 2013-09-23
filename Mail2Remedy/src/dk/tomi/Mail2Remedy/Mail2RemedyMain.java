package dk.tomi.Mail2Remedy;

import android.R.layout;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;
//import android.widget.TabHost.OnTabChangeListener;

@SuppressWarnings("deprecation")
public class Mail2RemedyMain extends TabActivity   {
    /** Called when the activity is first created. */
	@Override

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
        
        setContentView(R.layout.tabs_layout);        
      
        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        //intent = new Intent().setClass(this, Mail2Remedy_opret.class);
        
        intent = new Intent().setClass(this, Mail2Remedy_quick.class);
        spec = tabHost.newTabSpec("quick_case").setIndicator("One-Click",
                          res.getDrawable(R.drawable.ic_tab_close))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, TwoClick.class);
        spec = tabHost.newTabSpec("open_quick").setIndicator("Two-Click",
                          res.getDrawable(R.drawable.ic_tab_close))
                      .setContent(intent);
        tabHost.addTab(spec);
         
        intent = new Intent().setClass(this, Mail2Remedy_close1.class);
        spec = tabHost.newTabSpec("luk").setIndicator("Three-Click",
                          res.getDrawable(R.drawable.ic_tab_close))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, Gmail_reader.class);
        spec = tabHost.newTabSpec("luk").setIndicator("Cases",
                          res.getDrawable(R.drawable.ic_tab_close))
                      .setContent(intent);
        tabHost.addTab(spec);


        
        
        tabHost.setCurrentTab(0);

    ;}

	//	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.bund_menu, menu);
		return true;
	}

	// This method is called once the menu is selected
	//@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		// We have only one menu option
		case R.id.settings_bund_knap:
			// Launch Preference activity
			Intent i = new Intent(Mail2RemedyMain.this, RemedySettings.class);
			startActivity(i);
			break;
			
		case R.id.debug_bund_knap:
			// Launch Preference activity
			Intent i2 = new Intent(Mail2RemedyMain.this, Mail2Remedy_Debug.class);
			startActivity(i2);
			break;

		}
		return true;
	}
}