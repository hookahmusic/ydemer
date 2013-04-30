package dk.tomi.Mail2Remedy;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;

public class Mail2Remedy_Debug extends RemedyActivity {

    public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.debug);

			try {
				Send_Remedy_sag();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
       // self = this;
    }



	public void Send_Remedy_sag() throws MessagingException, IOException{

    	//default_group_func ();
    
    			 setContentView(R.layout.debug);
	              SharedPreferences settings =
	   	          getSharedPreferences(case_collector, MODE_PRIVATE);
	   	          String remedy_category = settings.getString("remedy_category", "Default");
	   	          String gemdata_item = settings.getString("remedy_item", "Default");
	   	          String gemdata_type = settings.getString("remedy_type", "Default");
	   	          String remedy_worklog = settings.getString("remedy_worklog", "Default");
	   	          String remedy_worklog_forvalg = settings.getString("remedy_worklog_forvalg", "Default");
	   	          String remedy_tidbrugt = settings.getString("remedy_tidbrugt", "Default");
	   	    	  String remedy_priotet = settings.getString("remedy_priotet", "Default");
	   	    	  String remedy_BrugerId = settings.getString("remedy_BrugerId", "Default");
	   	    	  String remedy_status = settings.getString("remedy_status", "Assigned");
	   	    	  String remedy_summary = settings.getString("remedy_summary", "Default");
	   	    	
	   	    
	   	  		SharedPreferences get_settings = PreferenceManager
	   	        .getDefaultSharedPreferences(getBaseContext());     

	   			String gmail_user = get_settings.getString("gmail_user", "Mangler Gmail konto");
	   			String gmail_password = get_settings.getString("gmail_password", "Mangler Gmail konto");
	   			String send_to_mail = get_settings.getString("send_to_mail", "Mangler Gmail konto");
	   			String my_bruger_id = get_settings.getString("my_bruger_id", "Du mangler at intaste dit bruger id under settings");
	   			String my_remedy_group = get_settings.getString("remedy_group", "Ingen");
	   			String min_gruppe = get_settings.getString("min_gruppe", "Ingen");
	   			
	  	   	  Properties props = System.getProperties();
	          Session session = Session.getDefaultInstance(props, null);
	          Store store = session.getStore("imaps");
	          store.connect("imap.gmail.com", "mail2remedy",
	        		  gmail_password);
	          Folder inbox = store.getFolder("Inbox");
	          inbox.open(Folder.READ_ONLY);
	          Message messages[] = inbox.getMessages(1, 4);
	          for (Message message : messages)
	              Log.d("Email", message + "");
	          Message message[] = inbox.getMessages(1, 4);
	         

		   	  

		        //  TextView textviewMail = new TextView(this);
		             //     for (int i = 0; i < 4; i++) {
		               // 	  content[i] = message[i].getContent().toString();
		                	  
		                	//  textview.setText("" + content +);
		                	 // Log.d("From", message[i].getFrom()[0] + "");
		                     // Log.d("Subject", message[i].getSubject() + "");
		                     // 
		                     // Log.d("content", content + "");

		                 // }
	    //      String sag1 = message[1].getContent().toString();
	    //      String sag2 = message[2].getContent().toString();
	          
	   			
       			TextView textview = new TextView(this);
	   	        textview.setText("\n Sender via: " + gmail_user + 
	   	        				"\n Gmail pass: " + gmail_password +
	   	        				"\n Sender til: " + send_to_mail +
	   	        				"\n Dit bruger ID: " + my_bruger_id +
	   	        				"\n Remedy Summary: " + remedy_summary +
	   	        				"\n Remedy category: " + remedy_category +
	   	        				"\n Remedy TYPE: " + gemdata_type +
	   	        				"\n Remedy ITEM: " + gemdata_item +
	   	        				"\n Remedy Group: " + my_remedy_group +
	   	        				"\n Remedy Activity: " + remedy_worklog +
	   	        				"\n Remedy pre txt: " + remedy_worklog_forvalg +
	   	        				"\n Remedy Tid: " + remedy_tidbrugt +
	   	        				"\n Remedy Priotet: " + remedy_priotet +
	   	        				"\n Remedy brugerID: " + remedy_BrugerId +
	   	        				"\n Remedy Status: " + remedy_status +
	   	        				"\n Min Gruppe: " + min_gruppe +
	   	        				"\n\n\n Yde mer V 08022013 Tommi Iversen"
	   	        				
	   	        				//"\n" + sag1 + "\n" + sag2
	   	        				
	   	        				);
	   	     setContentView(textview);
              
               //   setContentView(textviewMail);	
	}
}
