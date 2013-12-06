package slidenerd.vivz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        username=(EditText) findViewById(R.id.editText1);
        password=(EditText) findViewById(R.id.editText2);
    }
    
    public void save(View view)
    {
    	String text1=username.getText().toString();//vivz
    	String text2=password.getText().toString();//123
    	File file=null;
    	text1=text1+" ";//vivz 
    	FileOutputStream fileOutputStream=null;
		try {
			file=getFilesDir();
			fileOutputStream = openFileOutput("vivz.txt", Context.MODE_PRIVATE);
			fileOutputStream.write(text1.getBytes());
	    	fileOutputStream.write(text2.getBytes());
	    	
	    	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Log.d("VIVZ", e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.d("VIVZ", e.toString());
		}
    	finally{
    		try {
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Log.d("VIVZ", e.toString());
			}
    	}
    	//vivz 123
    	
    	Toast.makeText(this	, "Saved successfully "+file+"/vivz.txt", Toast.LENGTH_SHORT).show();
    }
    public void next(View view)
    {
    	Toast.makeText(this	, "Next called ", Toast.LENGTH_SHORT).show();
    	Intent intent=new Intent(this, SecondActivity.class);
    	startActivity(intent);
    	
    }
    
}
