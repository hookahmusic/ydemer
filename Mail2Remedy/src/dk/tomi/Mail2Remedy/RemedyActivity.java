package dk.tomi.Mail2Remedy;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class RemedyActivity extends Activity{
	public static final String case_collector = "case_collector";
	public static final String lastLaunch = "never";
	public static final String text_field = "input";
	public String line_break = "";
	public ProgressBar progressBar;
	public int myProgressStatus;
	public boolean myProgressLoop;
	public Button button;
	public SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	public String currentTime;
	public String remedy_group;
	public int default_cat;
	public int default_type;
	public int default_item;
	public int case_ID;
	public String stik_ord;
	public String my_remedy_group;
	SQLiteDatabase mydb;
	//public String case_ID;
	private static String DBNAME = "PERSONS2.db";    // THIS IS THE SQLITE DATABASE FILE NAME.
	private static String TABLE = "MY_TABLE2";       // THIS IS THE TABLE NAME
	
	
	   public void gui_besked (String besked){
			Toast.makeText(RemedyActivity.this, besked, 
		            Toast.LENGTH_LONG).show();	}

	   
	   
	   public void clear_case(){    	
    		   gui_besked("Clear case");   		       		   
    		   /*
    		   Henter Array id
    		   */
    		  // String test12 = "Quick_case_array_" + case_array_select;
    		  // int getRes = getResources().getIdentifier(test12, "array", getPackageName());
    		 //  Resources res = getResources();
    		 //  QC_items = res.getStringArray(getRes);
    		   gem_data("", "remedy_summary");
    		   gem_data("", "remedy_description");
    		//   gem_data("", "remedy_category");
    		//   gem_data("", "remedy_type");
    		//   gem_data("", "remedy_item");
    		//   gem_data("", "remedy_group");
        	   gem_data("", "remedy_worklog");      	   
        	   gem_data("15", "remedy_tidbrugt");
        	   gem_data("Low", "remedy_priotet");
        	   gem_data("Assigned", "remedy_status");   	
        	   gem_data("", "remedy_worklog_forvalg");
        	   gem_data("Default", "remedy_BrugerId");
		   }
		   
	   
	   public void hent_dato(){    	
		    SharedPreferences settings =
		        getSharedPreferences(lastLaunch, MODE_PRIVATE);
		        if (settings.contains("dato") == true) {
		        //	String dato_get = settings.getString("dato", "Default");
		        //Log.i("tommilog","Sidst oppe - " + dato_get);
		        }
		        currentTime = formatter.format(new Date());
		   SharedPreferences.Editor prefEditor = settings.edit();
		   prefEditor.putString("dato", currentTime);
		   prefEditor.commit();
		   //Log.i("tommilog","dato pt. - " + currentTime);
		}
	   
	   
	   /* 
	   *@return boolean return true if the application can access the internet 
	   */  
	   public boolean haveInternet(){  		   
		   ConnectivityManager conMan = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

		 //mobile
		 State mobile = conMan.getNetworkInfo(0).getState();

		 //wifi
		 State wifi = conMan.getNetworkInfo(1).getState();
		   
		 if (mobile == NetworkInfo.State.CONNECTED) {
			 return true; 
			} else if (wifi == NetworkInfo.State.CONNECTED) {
				return true; 
			}  
		 return false;    
	   }  
	
	
	public void gem_data(String gemdata, String gemdatatype){
	    SharedPreferences settings =
        getSharedPreferences(case_collector, MODE_PRIVATE);
 
//læs opgave string til log	    
	    if (settings.contains("gemdatatype") == true) {
        	String gemdata1 = settings.getString("gemdatatype", "Default");
        Log.i("tommilog","opgave read - " + gemdata1);
        }
        
 //gemdata
   SharedPreferences.Editor prefEditor = settings.edit();
   prefEditor.putString(gemdatatype, gemdata);
   prefEditor.commit();
   //Log.i("tommilog","data som gemmes. - " + gemdata);
   //Log.i("tommilog","opgave type - " + gemdatatype);
	}

	

	 public class send_mail_database extends AsyncTask<String, Integer, Boolean> {
			@Override
	   	    protected Boolean doInBackground(String... params) {
	   	    	myProgressLoop = true;

	   	    	//gui_besked("Åhhhhhh");
	   	    	
	   	    	Log.e("tommilog", "start af database mail" + case_ID + "stikord" + stik_ord); 
    	
	   	    	

	   	    	        mydb = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE,null);
	   	    	        Cursor allrows  = mydb.rawQuery("SELECT * FROM "+  TABLE + " WHERE ID=" + case_ID, null);
	   	    	     //   System.out.println("COUNT : " + allrows.getCount());


	   	    	                
	   	    	                final int ID = allrows.getInt(0);
	   	    	                final String CASE_NAVN= allrows.getString(1);
	   	    	                String GRUPPE= allrows.getString(2);
	   	    	                String TYPE= allrows.getString(3);
	   	    	                String CASE_NR = allrows.getString(4);
	   	    	                String VERSION= allrows.getString(5);
	   	    	                String REMEDY_SUMMERAY= allrows.getString(6);
	   	    	                String REMEDY_DESCRIPTION = allrows.getString(7);
	   	    	                String REMEDY_CATEGORY= allrows.getString(8);
	   	    	                String REMEDY_TYPE= allrows.getString(9);
	   	    	                String REMEDY_ITEM = allrows.getString(10);
	   	    	                String REMEDY_GROUP= allrows.getString(11);
	   	    	                String REMEDY_WORKLOG= allrows.getString(12);
	   	    	                String REMEDY_TID= allrows.getString(13);
	   	    	                String REMEDY_STATUS= allrows.getString(14);


	   	    	        mydb.close();
	   	    	  
	   	    	
	   	    	
		
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	    	
	   	          //henter data
	   	          SharedPreferences settings =
	   	          getSharedPreferences(case_collector, MODE_PRIVATE);
	          
	   	          //nye
	   	          String remedy_summary = settings.getString("remedy_summary", "Default");
	   	          String remedy_description = settings.getString("remedy_summary", "Default");  	          
	   	          String remedy_category = settings.getString("remedy_category", "Default");  
	   	          //String remedy_group = settings.getString("remedy_group", "Default");
	   	          
	   	          //nye slut
	 	          
	   	          String remedy_type = settings.getString("remedy_type", "Default");
	   	          String remedy_item = settings.getString("remedy_item", "Default");
	   	          String remedy_worklog = settings.getString("remedy_worklog", "Default");
	   	          String remedy_worklog_forvalg = settings.getString("remedy_worklog_forvalg", "Default");
	   	          String remedy_tidbrugt = settings.getString("remedy_tidbrugt", "15");
	   	          String remedy_priotet = settings.getString("remedy_priotet", "Default");
	   	          String remedy_requesterID = settings.getString("remedy_BrugerId", "Default");
	   	          String remedy_status = settings.getString("remedy_status", "Assigned");
	       	    
	       	          
	   	          //MAIL settings//////////////////////////////////////////////////////////////////////////////////////////   	  	  
	   	  		  SharedPreferences mail_conto = PreferenceManager
	   	          .getDefaultSharedPreferences(getBaseContext());    	       
	     	  	  String gmail_subject = getResources().getString(R.string.gmail_subject);  //sættes i strings.xml
	    			
	     	  	  String gmail_user = mail_conto.getString("gmail_user", "Mangler Gmail konto");
	     		  String gmail_password = mail_conto.getString("gmail_password", "Mangler Gmail konto");
	     		  String send_to_mail = mail_conto.getString("send_to_mail", "Mangler Gmail konto");
	     		  String my_bruger_id = mail_conto.getString("my_bruger_id", "Du mangler at intaste dit bruger id under settings");
	     		  remedy_group = mail_conto.getString("remedy_group", "Du mangler at vælge din Group under settings");
	     		  Mail m = new Mail(gmail_user, gmail_password); 
	              String[] toArr = {send_to_mail};     
	   	  	    

	              
	              
	              
	              
	              
	              
	              
	              
	              
	              
	              
	              

	   	          String individual_id = null;
				  if(remedy_requesterID.equals("Default")){
	   	        	remedy_requesterID = my_bruger_id;	
	   	        	individual_id  = my_bruger_id;
	   	          }
	   	          
	   	          if(remedy_status.equals("Assigned")){
	   	        	individual_id = "";	
	     	      }
	   	          
	   	          if(remedy_worklog_forvalg.equals("Predefineret")){
	   	        	remedy_worklog_forvalg = null;		          
	   	          }

	   	          if(remedy_worklog != null & remedy_worklog_forvalg != null){
	   	        	  line_break = "\n";
	   	          }
	   	          else
	   	          {
	   	        	line_break = ""; 	        	  
	   	        	remedy_worklog_forvalg = "";
	   	          }
	   	          
		          
	   	          m.setTo(toArr); 
	   	          m.setFrom(gmail_user);      
				  m.setSubject("<" + gmail_subject + ">");  //sætter subject via gmail_subject string i strings xml           
	   	          m.setBody("<Summary>" + remedy_summary + "</Summary>\n"+
	   	        		    "<Description>" + remedy_description + "</Description>\n"+
	   	        		    "<Category>" + remedy_category + "</Category>\n"+
	   	        		    "<Type>" + remedy_type + "</Type>\n"+
	   	        		    "<Item>" + remedy_item + "</Item>\n"+
	   	        		    "<Group>Service Broadcast</Group>\n"+
	   	        		    "<Worklog>" + remedy_worklog_forvalg + line_break + remedy_worklog + "</Worklog>\n"+
	   	        		    "<Oprettet>" + currentTime + "</Oprettet>\n"+
	   	        		    "<RequesterID>" + remedy_requesterID + "</RequesterID>\n"+
	   	        		    "<Oprettetaf>" + my_bruger_id + "</Oprettetaf>\n"+
	   	        		    "<Tidbrugt>" + remedy_tidbrugt + "</Tidbrugt>\n"+
	   	        		    "<Prioritet>" + remedy_priotet + "</Prioritet>\n"+
	   	        		    "<Status>" + remedy_status + "</Status>\n" +
	   	        		    "<Individual>" + individual_id + "</Individual>\n"
	   	          			); 

	   	          try { 
	   	        	  //brug denne hvis attachment
	   	        	  //if(m.send("/sdcard/FxCamera/FxCam_1287341981827.jpg")) { 
	   	        	  //
	   	        	  if(m.send(null)) { 
	   	          	  Log.e("tommilog", "mailsendt"); 
	   	            } else { 
	   	              Toast.makeText(RemedyActivity.this, "Email er IKKE sendt", 
	   	              Toast.LENGTH_LONG).show(); 
	     	          Log.e("tommilog", "mail FEJLLL"); 
	   	          	  myProgressLoop = false;
	   	              myProgressStatus = 99;
	   	            } 
	   	          } catch(Exception e) { 
	   	          	Log.e("tommilog", "mail FEJLLL2"); 
	   	            return false;
	   	          }  
	   	    	 
	   	       return true;
	   	    }  
	
	   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
   public class send_mail extends AsyncTask<String, Integer, Boolean> {
 //  	     @SuppressWarnings("null")
		@Override
   	    protected Boolean doInBackground(String... params) {
   	    	myProgressLoop = true;

   	          //henter data
   	          SharedPreferences settings =
   	          getSharedPreferences(case_collector, MODE_PRIVATE);
          
   	          //nye
   	          String remedy_summary = settings.getString("remedy_summary", "Default");
   	          String remedy_description = settings.getString("remedy_summary", "Default");  	          
   	          String remedy_category = settings.getString("remedy_category", "Default");  
   	          //String remedy_group = settings.getString("remedy_group", "Default");
   	          
   	          //nye slut
 	          
   	          String remedy_type = settings.getString("remedy_type", "Default");
   	          String remedy_item = settings.getString("remedy_item", "Default");
   	          String remedy_worklog = settings.getString("remedy_worklog", "Default");
   	          String remedy_worklog_forvalg = settings.getString("remedy_worklog_forvalg", "Default");
   	          String remedy_tidbrugt = settings.getString("remedy_tidbrugt", "15");
   	          String remedy_priotet = settings.getString("remedy_priotet", "Default");
   	          String remedy_requesterID = settings.getString("remedy_BrugerId", "Default");
   	          String remedy_status = settings.getString("remedy_status", "Assigned");
       	          
   	          //MAIL settings//////////////////////////////////////////////////////////////////////////////////////////   	  	  
   	  		  SharedPreferences mail_conto = PreferenceManager
   	          .getDefaultSharedPreferences(getBaseContext());    	       
     	  	  String gmail_subject = getResources().getString(R.string.gmail_subject);  //sættes i strings.xml
    			
     	  	  String gmail_user = mail_conto.getString("gmail_user", "Mangler Gmail konto");
     		  String gmail_password = mail_conto.getString("gmail_password", "Mangler Gmail konto");
     		  String send_to_mail = mail_conto.getString("send_to_mail", "Mangler Gmail konto");
     		  String my_bruger_id = mail_conto.getString("my_bruger_id", "Du mangler at intaste dit bruger id under settings");
     		  remedy_group = mail_conto.getString("remedy_group", "Du mangler at vælge din Group under settings");
     		  Mail m = new Mail(gmail_user, gmail_password); 
              String[] toArr = {send_to_mail};     
   	  	    


   	          String individual_id = null;
			  if(remedy_requesterID.equals("Default")){
   	        	remedy_requesterID = my_bruger_id;	
   	        	individual_id  = my_bruger_id;
   	          }
   	          
   	          if(remedy_status.equals("Assigned")){
   	        	individual_id = "";	
     	      }
   	          
   	          if(remedy_worklog_forvalg.equals("Predefineret")){
   	        	remedy_worklog_forvalg = null;		          
   	          }

   	          if(remedy_worklog != null & remedy_worklog_forvalg != null){
   	        	  line_break = "\n";
   	          }
   	          else
   	          {
   	        	line_break = ""; 	        	  
   	        	remedy_worklog_forvalg = "";
   	          }
   	          
	          
   	          m.setTo(toArr); 
   	          m.setFrom(gmail_user);      
			  m.setSubject("<" + gmail_subject + ">");  //sætter subject via gmail_subject string i strings xml           
   	          m.setBody("<Summary>" + remedy_summary + "</Summary>\n"+
   	        		    "<Description>" + remedy_description + "</Description>\n"+
   	        		    "<Category>" + remedy_category + "</Category>\n"+
   	        		    "<Type>" + remedy_type + "</Type>\n"+
   	        		    "<Item>" + remedy_item + "</Item>\n"+
   	        		    "<Group>Service Broadcast</Group>\n"+
   	        		    "<Worklog>" + remedy_worklog_forvalg + line_break + remedy_worklog + "</Worklog>\n"+
   	        		    "<Oprettet>" + currentTime + "</Oprettet>\n"+
   	        		    "<RequesterID>" + remedy_requesterID + "</RequesterID>\n"+
   	        		    "<Oprettetaf>" + my_bruger_id + "</Oprettetaf>\n"+
   	        		    "<Tidbrugt>" + remedy_tidbrugt + "</Tidbrugt>\n"+
   	        		    "<Prioritet>" + remedy_priotet + "</Prioritet>\n"+
   	        		    "<Status>" + remedy_status + "</Status>\n" +
   	        		    "<Individual>" + individual_id + "</Individual>\n"
   	          			); 

   	          try { 
   	        	  //brug denne hvis attachment
   	        	  //if(m.send("/sdcard/FxCamera/FxCam_1287341981827.jpg")) { 
   	        	  //
   	        	  if(m.send(null)) { 
   	          	  Log.e("tommilog", "mailsendt"); 
   	            } else { 
   	              Toast.makeText(RemedyActivity.this, "Email er IKKE sendt", 
   	              Toast.LENGTH_LONG).show(); 
     	          Log.e("tommilog", "mail FEJLLL"); 
   	          	  myProgressLoop = false;
   	              myProgressStatus = 99;
   	            } 
   	          } catch(Exception e) { 
   	          	Log.e("tommilog", "mail FEJLLL2"); 
   	            return false;
   	          }  
   	    	 
   	       return true;
   	    }  

		protected void onPostExecute(Boolean result) {

   		       if (result) {
   		    	//Log.e("tommilog", "mail sendt - onPostExecute"); 
   		    	gui_besked ("Mail er sendt");
   		    	//myProgressStatus = 99;
   		    	myProgressLoop = false;
   		    	clear_case();
   		       
   		       } else {
   		    	//Log.e("tommilog", "mail ikke sendt - onPostExecute"); 
   		    	   gui_besked ("Fejl.. Mail ikke sendt - prøv igen");
   	          	myProgressLoop = false;
   		       }
   		     }
   }


   public class send_mail_progressbar extends AsyncTask<String, Integer, Boolean> {
   	     private ProgressBar myProgressBar;
   	     
   	 
   	     public send_mail_progressbar(ProgressBar p) {
   	       myProgressBar = p;
   	       myProgressStatus = 0;
   	     }
   	 
   	     protected Boolean doInBackground(String... params) {
   	       try {
   	         while (myProgressStatus < 100) {
   	           Thread.sleep(600);
   	           myProgressStatus = myProgressStatus+5;
   	           publishProgress(myProgressStatus);
   	           if (myProgressLoop == true & myProgressStatus == 95 ){
   	        	   myProgressStatus = 0;
   	           }
   	           else if (myProgressLoop == false){
   	        	   myProgressStatus = 95;
   	           }
   	         }
   	 
   	       } catch (InterruptedException e) {
   	         e.printStackTrace();
   	       }
   	       return true;
   	     }
   	 
   	     protected void onProgressUpdate(Integer... progress) {
   	       myProgressBar.setProgress(progress[0]);
   	     }
   	   }


protected void onPreExecute() {
	// TODO Auto-generated method stub
	
}
















	}