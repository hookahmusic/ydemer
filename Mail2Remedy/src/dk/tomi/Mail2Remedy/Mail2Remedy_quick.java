package dk.tomi.Mail2Remedy;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class Mail2Remedy_quick extends RemedyActivity {
	public String min_gruppe;
	public int number;
	public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.close2);
        savedInstanceState = null;
        int[] knap_by_view ={R.id.quickcase0, R.id.quickcase1, R.id.quickcase2, R.id.quickcase3, R.id.quickcase4, R.id.quickcase5, R.id.quickcase6}; 
        min_gruppe = null;
       // knapnavn = null;

  		SharedPreferences get_settings = PreferenceManager.getDefaultSharedPreferences(getBaseContext());     
		min_gruppe = get_settings.getString("min_gruppe", "Ingen");
       
        for (number = 0; number <= 6; number++) {   
        
        String knapnavn = "Quick_case_array_"  + number; 
        
        if (min_gruppe.equals("NYSS"))  {
        	knapnavn = "Quick_case_array_" + number;
        }
 		  
        if (min_gruppe.equals("Studie")) {
        	knapnavn = "StudieQuick_case_array_" + number;
        }

        
        
        
           int getRes = getResources().getIdentifier(knapnavn, "array", getPackageName());
		   Resources getres = getResources();
		   String[] navnpaaknap = getres.getStringArray(getRes);
		   
		   String knap_navnfra_array = navnpaaknap[10];
		  // gem_data(QC_items[0], "remedy_summary");
        	
        	
        	
        button = (Button) findViewById(knap_by_view[number]);
        //button.setText(res.getString(knap_navn[number]));
        button.setText(knap_navnfra_array);
        
        
        button.setOnClickListener(new View.OnClickListener() {
    	   int temp = number;
           public void onClick(View v) {            	   
        	   hent_QC_data_fra_XML(temp);      	   
           }
         });         
        }  	
}
       	
	    public void hent_QC_data_fra_XML (int case_array_select){	   
		   String[] QC_items = null;
		   
		   
		   if (haveInternet()){
    		   gui_besked("OK net forbindelse");   		       		   
    		   
    		   /*
    		   Henter Array id
    		   */
    		   String test12 = "Quick_case_array_" + case_array_select;
    		   int getRes = getResources().getIdentifier(test12, "array", getPackageName());
    		   Resources res = getResources();
    		   QC_items = res.getStringArray(getRes);
    		   
    		   
    		   gem_data(QC_items[0], "remedy_summary");
    		   gem_data(QC_items[1], "remedy_description");
    		   gem_data(QC_items[2], "remedy_category");
    		   gem_data(QC_items[3], "remedy_type");
    		   gem_data(QC_items[4], "remedy_item");
    		   gem_data(QC_items[5], "remedy_group");
        	   gem_data(QC_items[6], "remedy_worklog");      	   
        	   gem_data(QC_items[7], "remedy_tidbrugt");
        	   gem_data(QC_items[8], "remedy_priotet");
        	   gem_data(QC_items[9], "remedy_status");   	
        	   gem_data("", "remedy_worklog_forvalg");
        	   gem_data("Default", "remedy_requesterID");
        	   hent_dato();
        	   	   
		   }
    	   
    	   else{
    		   gui_besked("Fejl! ingen forbindelse - gå ud af elavator");
    		   myProgressStatus = 95;
    		   myProgressLoop = true;
    	   }

		   new send_mail().execute();
	   
	   }

}