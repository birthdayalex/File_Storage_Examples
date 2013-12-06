package slidenerd.vivz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity {

	EditText userName, password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

        userName=(EditText) findViewById(R.id.editText3);
        password=(EditText) findViewById(R.id.editText4);
	}
	public void load(View view)
    {
	
		/*
		 * what you see when you open the file?
		 * vivz 123
		 * what is actually contained in the file?
		 * 118 105 118 122 32 49 50 51 
		 * -1
		 */
		try {
			FileInputStream fileInputStream=openFileInput("vivz.txt");
			int read=-1;
			StringBuffer buffer=new StringBuffer();
			while((read=fileInputStream.read())!=-1)
			{
				buffer.append((char)read);
			}
			
			Log.d("VIVZ", buffer.toString());
			//teststst 123 
			String text1=buffer.substring(0, buffer.indexOf(" "));
			String text2=buffer.substring(buffer.indexOf(" ")+1);
			
			userName.setText(text1);
			password.setText(text2);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Toast.makeText(this	, "Load successful ", Toast.LENGTH_SHORT).show();
    }
	public void previous(View view)
    {
		Toast.makeText(this	, "Previous called ", Toast.LENGTH_SHORT).show();
		Intent intent=new Intent(this, MainActivity.class);
    	startActivity(intent);
		
    }


}
