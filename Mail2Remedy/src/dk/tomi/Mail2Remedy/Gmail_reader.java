package dk.tomi.Mail2Remedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import com.sun.mail.imap.protocol.Item;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Gmail_reader extends RemedyActivity {
	private TextView textView;
	
	  private static final int PROGRESS = 0x1;

	     private ProgressBar mProgress;
	     private int mProgressStatus = 0;

	     private Handler mHandler = new Handler();

	     
	     
	     
	String response = "";
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cases);
		textView = (TextView) findViewById(R.id.TextView01);

		DownloadWebPageTask task = new DownloadWebPageTask();
		task.execute();
	}

	

	private class DownloadWebPageTask extends AsyncTask<String, Void, String> {
		@Override
	
		protected String doInBackground(String... urls) {
			String content = "";
			
		 	
			
			
			
			try {	
				
				SharedPreferences get_settings = PreferenceManager
		        .getDefaultSharedPreferences(getBaseContext());     
				String gmail_password = get_settings.getString("gmail_password", "");
				
				Properties props = System.getProperties();
				      Session session = Session.getDefaultInstance(props, null);
				      Store store = session.getStore("imaps");
						store.connect("imap.gmail.com", "mail2remedy",
								gmail_password);     Folder inbox = store.getFolder("Inbox");
				      inbox.open(Folder.READ_ONLY);
				     // Message messages[] = inbox.getMessages(1, 5);
				     // for (Message message : messages)
				     //     Log.d("Email", message + "");
				      Message message[] = inbox.getMessages();
								      
				      int i = message.length-10;        
				      int int2 = message.length;
				      for (; i < message.length; i++){
				    	  int2--; 
				                	  content += "modtaget: ";
				                	  content += message[int2].getSentDate().toString();
				                	  content += "\n\n";
				                	  content += message[int2].getContent().toString();
				                	  content += "\n";
				                	  content += "________________________________________";
				                	  content += "\n";

				                  }				      
								      
					} catch (MessagingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			return content;
		}

		@Override
		protected void onPostExecute(String content) {	
			textView.setText(content);
		}
	}



}
	
	
	
	
	
	
	
	
	
	
	
	






	
	
	