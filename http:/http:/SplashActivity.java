package net.penguincoders.doit;

import...
  
  public class SplashActivity extends AppCompatActivity {

  @Override
  protected void onCreat(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    getSupportActionBar().hide();
    
    final  Intent i=new Intent(packageContext:Splashactivity.this.MainActivity.class);andler9
    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        startActivity(i);
        finish();
      }
    },delayMillis:1000);
                              }
}
                              
