package dk.tomi.Mail2Remedy;
import javax.crypto.Mac;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


	public class open_2click extends RemedyActivity {
		public int number;
		public String value;
		public String[] QC_items = null;
		public void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	        setContentView(R.layout.quick);
	               

	        int[] knap_by_view ={R.id.quickcase0, R.id.quickcase1, R.id.quickcase2, R.id.quickcase3, R.id.quickcase4, R.id.quickcase5, R.id.quickcase6, R.id.quickcase7}; 
	        
        
	        
	        
	        for (number = 0; number <= 7; number++) {      
	        	
	        	int number_array = number+10;
	        	
	 		   String knapnavn = "Quick_case_array_" + number_array;
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
	        	   
        	   

	        	   hent_QC_data_fra_XML(temp+10);      	   
	           }
	         });         
	        }  	
	}
	       	
		    public void hent_QC_data_fra_XML (final int case_array_select){	   
			    
			   
			   
	   	        AlertDialog.Builder alert = new AlertDialog.Builder(this);

		        alert.setTitle("Angiv Stikord");
		        alert.setMessage("F.eks: Viz2 er gået i hegnet");

		        // Set an EditText view to get user input 
		        final EditText input = new EditText(this);
		        alert.setView(input);

		        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int whichButton) {
		        	value = input.getText().toString();
		          // Do something with value!
	        
		        
					   if (haveInternet()){
			    		   gui_besked("OK net forbindelse");   		       		   

			    		   /*
			    		   Henter Array id
			    		   */
			    		   String test12 = "Quick_case_array_" + case_array_select;
			    		   int getRes = getResources().getIdentifier(test12, "array", getPackageName());
			    		   Resources res = getResources();
			    		   QC_items = res.getStringArray(getRes);
			    		   
			    		  // String summary = QC_items[0], "remedy_summary";
			    		   gem_data(QC_items[0] + " " + value, "remedy_summary");
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
		        });

		        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		          public void onClick(DialogInterface dialog, int whichButton) {
		            // Canceled.
		          }
		        });
			   
			   alert.show();
			   		   
		   }

	}


