package dk.tomi.Mail2Remedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;



public class Mail2Remedy_close1 extends RemedyActivity {
	public int idid;


	
	
public void spinneritem2 (int idid3){
    	
    	
    	Spinner spinner = (Spinner)this.findViewById(R.id.Spinneritem);
    	int[] itemspinner = null;
    	int[] item1 = {R.array.afslut_sag_item1, R.array.afslut_sag_item2, R.array.afslut_sag_item3, R.array.afslut_sag_item4, R.array.afslut_sag_item5,};
    	int[] item10 = {R.array.afslut_sag_item11, R.array.afslut_sag_item12, R.array.afslut_sag_item13, R.array.afslut_sag_item14, R.array.afslut_sag_item15, R.array.afslut_sag_item16};
    	int[] item20 = {R.array.afslut_sag_item21, R.array.afslut_sag_item22, R.array.afslut_sag_item23, R.array.afslut_sag_item24, R.array.afslut_sag_item25, R.array.afslut_sag_item26, R.array.afslut_sag_item27};
    	int[] item30 = {R.array.afslut_sag_item30, R.array.afslut_sag_item31, R.array.afslut_sag_item32, R.array.afslut_sag_item33, R.array.afslut_sag_item34};
    	int[] item40 = {R.array.afslut_sag_item40, R.array.afslut_sag_item41, R.array.afslut_sag_item42, R.array.afslut_sag_item43, R.array.afslut_sag_item44, R.array.afslut_sag_item45};
    	int[] item50 = {R.array.afslut_sag_item50, R.array.afslut_sag_item51, R.array.afslut_sag_item52, R.array.afslut_sag_item53, R.array.afslut_sag_item54, R.array.afslut_sag_item55};
    	int[] item60 = {R.array.afslut_sag_item60};

    	//int idid2 = idid3;
    	itemspinner = item1;
     //	if (idid == 0){
     //		itemspinner = item1;
     		//idid2 = idid2 +10;
    // 	}
     	if (idid == 1){
     		itemspinner = item10;
     		//idid2 = idid2 +20;
     	}
     	else if (idid == 2){
     		itemspinner = item20;
     		//idid2 = idid2 +30;
     	}
     	else if (idid == 3){
     		itemspinner = item30;
     		//idid2 = idid2 +40;
     	}
     	else if (idid == 4){
     		itemspinner = item40;
     		//idid2 = idid2 +50;
     	}
     	else if (idid == 5){
     		itemspinner = item50;
     		//idid2 = idid2 +60;
     	}
     	else if (idid == 6){
     		itemspinner = item60;
     		//idid2 = idid2 +60;
     	}

     	final CharSequence[] itemArray =getResources().getTextArray(itemspinner[idid3]);
    	
		 	final List<CharSequence> itemList =new ArrayList<CharSequence>(Arrays.asList(itemArray));
		 	ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,itemList);
	    	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 	spinner.setAdapter(adapter);
		 	spinner.setSelection(default_item);
		 	spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
	             public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition,
	                     long selectedId) {                
            	
             	gem_data(parent.getItemAtPosition(selectedItemPosition).toString(), "remedy_item");  
           	        
             }
             public void onNothingSelected(AdapterView<?> parent) {
             }
         }
         );   
    }
    
   
	
    public void spinnertype (final int idid2){
    	    	
    	Spinner spinner = (Spinner)this.findViewById(R.id.Spinnertype);
    	int[] knap_navn ={R.array.afslut_sag_type1, R.array.afslut_sag_type2, R.array.afslut_sag_type3, R.array.afslut_sag_type4, R.array.afslut_sag_type5, R.array.afslut_sag_type6, R.array.afslut_sag_type7};
	 	final CharSequence[] itemArray =getResources().getTextArray(knap_navn[idid2]);
    	 	
 	
	 	final List<CharSequence> itemList =new ArrayList<CharSequence>(Arrays.asList(itemArray));
	 	ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,itemList);
    	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	 	spinner.setAdapter(adapter);
	 	spinner.setSelection(default_type);
	 	spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition,
                     long selectedId) {                   
	
             	gem_data(parent.getItemAtPosition(selectedItemPosition).toString(), "remedy_type");  

         		spinneritem2(selectedItemPosition);           
             }
             public void onNothingSelected(AdapterView<?> parent) {
             }
         }
         );   
    }
	
	
	
	public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        
    	//String hsduihuisdh = "Service Broadcast";
    	//if (my_remedy_group == hsduihuisdh){
    		default_cat = 3;
    		default_type = 2;
    		default_item = 1;
    		//}
    	
    	
        /*   
        /   Hent data valgt fra spinner SpinnerPriotet - 
        /	Data gemmes i "remedy_priotet"
        */

            	
    	setContentView(R.layout.close1);
		
        Spinner spinner_category = (Spinner) findViewById(R.id.Spinnercategory);
        ArrayAdapter<?> adapter_category = ArrayAdapter.createFromResource(this, R.array.afslut_sag_category,
                android.R.layout.simple_spinner_item);
        adapter_category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_category.setAdapter(adapter_category);          //  if (mGameSettings.contains(GAME_PREFERENCES_GENDER)) {       
        spinner_category.setSelection(default_cat);
        //spinner_category.setSelection(3);
        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        
        	public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition,
                    long selectedId) {                   
            	
            	String convert_array_category = getResources().getStringArray(R.array.afslut_sag_category)[selectedItemPosition];            	
            	gem_data(convert_array_category, "remedy_category");              	
            	idid = selectedItemPosition;
           
            
            		spinnertype(idid);
      
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        }
        );
  
        
        /*    
        /   Hent text fra user input felt fra remedy_worklog_felt i close1.xml- 
        /	Data gemmes i "remedy_close_notes"
        */
        EditText test3 = (EditText) findViewById(R.id.remedy_summary_felt);
        test3.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
            
                } catch (NumberFormatException e) {
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            	
            	   final EditText feedbackField = (EditText) findViewById(R.id.remedy_summary_felt);  
                 String sag_close_activity_notes = feedbackField.getText().toString();
                 gem_data(sag_close_activity_notes, "remedy_summary");
            }
        });
        
     
        
        /*    
        /   Hent text fra user input felt fra remedy_worklog_felt i close1.xml- 
        /	Data gemmes i "remedy_close_notes"
        */
        EditText test = (EditText) findViewById(R.id.remedy_worklog_felt);
        test.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
            
                } catch (NumberFormatException e) {
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            	
            	   final EditText feedbackField = (EditText) findViewById(R.id.remedy_worklog_felt);  
                 String sag_close_activity_notes = feedbackField.getText().toString();
                 gem_data(sag_close_activity_notes, "remedy_worklog");
            }
        });
        
        
        /*    
        /   Hent text fra user input felt fra BrugerIdText - 
        /	Data gemmes i "remedy_BrugerId"
        */
           EditText test2 = (EditText) findViewById(R.id.BrugerIdText);
           test2.addTextChangedListener(new TextWatcher() {

               public void beforeTextChanged(CharSequence s, int start, int count, int after) {
               }
               public void onTextChanged(CharSequence s, int start, int before, int count) {
                   try {
               
                   } catch (NumberFormatException e) {
                   }
               }
               @Override
               public void afterTextChanged(Editable s) {
               	
               	   final EditText feedbackField = (EditText) findViewById(R.id.BrugerIdText);  
                    String sag_close_activity_notes = feedbackField.getText().toString();
                    gem_data(sag_close_activity_notes, "remedy_BrugerId");
                   // TODO Auto-generated method stub

               }
           });
           
        
           /*  forvalgt = premade text til activity/worklog  
           /   Hent data valgt fra remedy_activity_forvalg - 
           /	Data gemmes i "remedy_activity_forvalg"
           */
            final Spinner spinner = (Spinner) findViewById(R.id.SpinnerActivity);
            ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.afslut_sag_activity_spinner,
                    android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);          //  if (mGameSettings.contains(GAME_PREFERENCES_GENDER)) {
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition,
                        long selectedId) {                   
                	String convert_array_index_til_string = getResources().getStringArray(R.array.afslut_sag_activity_spinner)[selectedItemPosition];            	
                	gem_data(convert_array_index_til_string, "remedy_worklog_forvalg");              	
                }
                public void onNothingSelected(AdapterView<?> parent) {
                }
            }
            );
        
        
            /*    
            /   Hent data valgt fra spinner SpinnerTid - 
            /	Data gemmes i "remedy_tidbrugt"
            
            Spinner spinner_time = (Spinner) findViewById(R.id.SpinnerTid);
            ArrayAdapter<?> adapter_time = ArrayAdapter.createFromResource(this, R.array.afslut_sag_tid,
                    android.R.layout.simple_spinner_item);
            adapter_time.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_time.setAdapter(adapter_time);          //  if (mGameSettings.contains(GAME_PREFERENCES_GENDER)) {
            spinner_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition,
                        long selectedId) {                   
                	String convert_array_tid = getResources().getStringArray(R.array.afslut_sag_tid)[selectedItemPosition];            	
                	gem_data(convert_array_tid, "remedy_tidbrugt");              	
                }
                public void onNothingSelected(AdapterView<?> parent) {
                }
            }
            );
       */
        
            /*   
            /   Hent data valgt fra spinner SpinnerPriotet - 
            /	Data gemmes i "remedy_priotet"
            */
            Spinner spinner_priotet = (Spinner) findViewById(R.id.SpinnerPriotet);
            ArrayAdapter<?> adapter_priotet = ArrayAdapter.createFromResource(this, R.array.afslut_sag_priotet,
                    android.R.layout.simple_spinner_item);
            adapter_priotet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_priotet.setAdapter(adapter_priotet);          //  if (mGameSettings.contains(GAME_PREFERENCES_GENDER)) {
            spinner_priotet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition,
                        long selectedId) {                   
                	String convert_array_priotet = getResources().getStringArray(R.array.afslut_sag_priotet)[selectedItemPosition];            	
                	gem_data(convert_array_priotet, "remedy_priotet");              	
                }
                public void onNothingSelected(AdapterView<?> parent) {
                }
            }
            );

        
            /*  Default er en sag altid lukket 
            /   Hent data valgt checkbox Case_open - 
            /	Data gemmes i "remedy_case_status"
            */      	   
                   final CheckBox checkbox = (CheckBox) findViewById(R.id.Case_open);
                   checkbox.setOnClickListener(new OnClickListener() {
                       public void onClick(View v) {
                           // Perform action on clicks, depending on whether it's now checked
                    	   gem_data("Assigned", "remedy_status"); 
                    	   
                    	   
                    	   if (((CheckBox) v).isChecked()) {
                        	   gem_data("Resolved", "remedy_status"); 
                           } 
                    	   //else {
                        	   
                           //}
                       }
                   }); 		   

           /*  
           /   Sender mail + opdatere progressbar
           /   Selve koden ligger i Remedy Activity
           */   	
    	progressBar = (ProgressBar) findViewById(R.id.progress_bar);
    	button = (Button) findViewById(R.id.send_email); 
    	button.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
        	   //gui_besked ("Sender Mail..");               	   
        	   if (haveInternet()){
        		   gui_besked("OK net forbindelse");
        		   myProgressStatus = 0;
        		   myProgressLoop = true;
        	   }
        	   
        	   else{
        		   gui_besked("Fejl! ingen forbindelse");
        		   myProgressStatus = 95;
        		   myProgressLoop = true;
        	   }
        	   
        	   hent_dato();
        	   new send_mail_progressbar(progressBar).execute();
        	   new send_mail().execute();
        	   
           }
         });
      
    }
}