package com.cnx.einsview.videoconference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.UUID;

public class SplashActivity extends AppCompatActivity {

  private SharedPreferences mSharedPreferences;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    mSharedPreferences= getPreferences(Context.MODE_PRIVATE);
    String loginId= mSharedPreferences.getString(getString(R.string.login_key), null);
    if(loginId != null){
      //TODO: Login to Video conferencing and on Sucess of login
      //TODO: Start VideoCalling activity
    }
    else {
      //TODO: Generate 6 digit alpha numeric value
      String login= randomStringGenerator();
      //TODO: Start sign up process


      //TODO: onSuccess of Sign up, save in shared preference; else generate alpha numeric again and retry


      SharedPreferences.Editor editor = mSharedPreferences.edit();
      editor.putString(getString(R.string.login_key), login);
      editor.apply();

      //TODO: the login user into quick blox server and start VideoCalling activity on success

      Intent intent= new Intent(this, VideoCallingActivity.class);
      intent.putExtra(getString(R.string.login_key), login);
      startActivity(intent);
    }
  }

  private String randomStringGenerator(){
    String uuid = UUID.randomUUID().toString().replace("-", "");
    return uuid.substring(uuid.length()-6);
  }
}
