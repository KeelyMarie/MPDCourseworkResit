package com.kmccon200.keelymccone.mpdcourseworkresit;

//Keely McCone S1429607 //

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button Manchester;
    Button Glasgow;
    Button Blackpool;
    Button Sunderland;
    Button Dublin;
    Button Cardiff;
    Button Dunfermline;
    Button London;
    Button St_Helier;
    Button Inverness;

    String url1 = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2643123";
    String url2 = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2648579";
    String url3 = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2643743";
    String url4 = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/3042091";
    String url5 = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2646088";
    String url6 = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2650732";
    String url7 = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2655459";
    String url8 = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2653822";
    String url9 = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2636531";
    String url10 = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2964574";

    String result;
    String titles;
    String descriptions;
    String links;
    String pubDate;

    TextView urlInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlInput = (TextView) findViewById(R.id.urlInput);

        Manchester = (Button) findViewById(R.id.Manchester);
        Manchester.setOnClickListener(this);

        Glasgow = (Button) findViewById(R.id.Glasgow);
        Glasgow.setOnClickListener(this);

        London = (Button) findViewById(R.id.London);
        London.setOnClickListener(this);

        St_Helier = (Button) findViewById(R.id.St_Helier);
        St_Helier.setOnClickListener(this);

        Inverness = (Button) findViewById(R.id.Inverness);
        Inverness.setOnClickListener(this);

        Dunfermline = (Button) findViewById(R.id.Dunfermline);
        Dunfermline.setOnClickListener(this);

        Blackpool = (Button) findViewById(R.id.Blackpool);
        Blackpool.setOnClickListener(this);

        Cardiff = (Button) findViewById(R.id.Cardiff);
        Cardiff.setOnClickListener(this);

        Sunderland = (Button) findViewById(R.id.Sunderland);
        Sunderland.setOnClickListener(this);

        Dublin = (Button) findViewById(R.id.Dublin);
        Dublin.setOnClickListener(this);

    } // End of onCreate

    @Override
    public void onClick(View aview) {
        if (aview == Manchester.findViewById(R.id.Manchester)) {
            startProgress1();
        } else if (aview == Glasgow.findViewById(R.id.Glasgow)) {
            startProgress2();
        } else if (aview == London.findViewById(R.id.London)) {
            startProgress3();
        } else if (aview == St_Helier.findViewById(R.id.St_Helier)) {
        startProgress4();
        } else if (aview == Inverness.findViewById(R.id.Inverness)) {
            startProgress5();
        } else if (aview == Dunfermline.findViewById(R.id.Dunfermline)) {
            startProgress6();
        } else if (aview == Blackpool.findViewById(R.id.Blackpool)) {
            startProgress7();
        } else if (aview == Cardiff.findViewById(R.id.Cardiff)) {
            startProgress8();
        } else if (aview == Sunderland.findViewById(R.id.Sunderland)) {
            startProgress9();
        } else if (aview == Dublin.findViewById(R.id.Dublin)) {
            startProgress10();
        }
    }

    public void startProgress1() {
        Toast.makeText(getApplicationContext(), "Manchester", Toast.LENGTH_LONG).show();
        urlInput.setText("Getting Manchester Weather Forecast...");
        new Thread(new Task(url1)).start();
    } //

    public void startProgress2() {
        Toast.makeText(getApplicationContext(), "Glasgow", Toast.LENGTH_LONG).show();
        urlInput.setText("Getting Glasgow Weather Forecast...");
        new Thread(new Task(url2)).start();
    } //

    public void startProgress3() {
        Toast.makeText(getApplicationContext(), "London", Toast.LENGTH_LONG).show();
        urlInput.setText("Getting London Weather Forecast...");
        new Thread(new Task(url3)).start();
    } //

    public void startProgress4() {
        Toast.makeText(getApplicationContext(), "St.Helier", Toast.LENGTH_LONG).show();
        urlInput.setText("Getting St.Helier Weather Forecast...");
        new Thread(new Task(url4)).start();
    } //

    public void startProgress5() {
        Toast.makeText(getApplicationContext(), "Inverness", Toast.LENGTH_LONG).show();
        urlInput.setText("Getting Inverness Weather Forecast...");
        new Thread(new Task(url5)).start();
    } //

    public void startProgress6() {
        Toast.makeText(getApplicationContext(), "Dunfermline", Toast.LENGTH_LONG).show();
        urlInput.setText("Getting Dunfermline Weather Forecast...");
        new Thread(new Task(url6)).start();
    } //

    public void startProgress7() {
        Toast.makeText(getApplicationContext(), "Blackpool", Toast.LENGTH_LONG).show();
        urlInput.setText("Getting Blackpool Weather Forecast...");
        new Thread(new Task(url7)).start();
    } //

    public void startProgress8() {
        Toast.makeText(getApplicationContext(), "Cardiff", Toast.LENGTH_LONG).show();
        urlInput.setText("Getting Cardiff Weather Forecast...");
        new Thread(new Task(url8)).start();
    } //

    public void startProgress9() {
        Toast.makeText(getApplicationContext(), "Sunderland", Toast.LENGTH_LONG).show();
        urlInput.setText("Getting PSunderland Weather Forecast...");
        new Thread(new Task(url9)).start();
    } //

    public void startProgress10() {
        Toast.makeText(getApplicationContext(), "Dublin", Toast.LENGTH_LONG).show();
        urlInput.setText("Getting Dublin Weather Forecast...");
        new Thread(new Task(url10)).start();
    } //

    public InputStream getInputStream(URL url) {
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }
    }

    // Need separate thread to access the internet resource over network
    // Other neater solutions should be adopted in later iterations.
    class Task implements Runnable {
        String url;

        public Task(String aurl) {
            url = aurl;
        }

        @Override
        public void run() {

            result = "";

            try {
                XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
                xmlPullParserFactory.setNamespaceAware(false);
                XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
                xmlPullParser.setInput(getInputStream(new URL(url)), null);
                xmlPullParser.next();

                boolean insideItem = false;

                int eventType = xmlPullParser.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG) {
                        if (xmlPullParser.getName().equalsIgnoreCase("item")) {
                            insideItem = true;
                        } else if (xmlPullParser.getName().equalsIgnoreCase("title")) {
                            if (insideItem) {
                                titles = xmlPullParser.nextText();
                            }
                        } else if (xmlPullParser.getName().equalsIgnoreCase("description")) {
                            if (insideItem) {
                                descriptions = xmlPullParser.nextText();
                            }
                        } else if (xmlPullParser.getName().equalsIgnoreCase("link")) {
                            if (insideItem) {
                                links = xmlPullParser.nextText();
                            }
                        } else if (xmlPullParser.getName().equalsIgnoreCase("pubDate")) {
                            if (insideItem) {
                                pubDate = xmlPullParser.nextText();
                            }
                        }
                    } else if (eventType == XmlPullParser.END_TAG && xmlPullParser.getName().equalsIgnoreCase("item")) {

                        insideItem = false;
                    }

                    eventType = xmlPullParser.next();
                    result = titles + "\n \n" + descriptions + "\n \n" + links + "\n \n" + "Date Published: " + "\n" + pubDate + "\n \n";
                }

            } catch (IOException ae) {
                Log.e("MyTag", "ioexception");
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }

            MainActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    urlInput.setText(result);
                }
            });
        }
    }
}
