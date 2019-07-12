package com.example.rr.speechrecog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity  {
    public String str="fail";
    private TextView txvResult;
    ViewPager viewPager;

    MyCustomPagerAdapter myCustomPagerAdapter=new MyCustomPagerAdapter();
    MyCustomPagerAdapter mcp=new MyCustomPagerAdapter();
    int[] images = {R.drawable.apple,R.drawable.parrot,R.drawable.mango,R.drawable.peacock, R.drawable.monkey,R.drawable.pen, R.drawable.tortoise,R.drawable.bag,R.drawable.elephant, R.drawable.squirrel, R.drawable.snake, R.drawable.tiger, R.drawable.dog, R.drawable.deer,R.drawable.thanku};

    /**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvResult = (TextView) findViewById(R.id.txvResult);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        myCustomPagerAdapter = new MyCustomPagerAdapter(MainActivity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);


    }
    public void getSpeechInput(View view) {
        //Informs the recognizer which speech model to prefer when performing ACTION_RECOGNIZE_SPEECH.
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //Use a language model based on free-form speech recognition.
        //Starts an activity that will prompt the user for speech and send it through a speech recognizer.
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //Optional IETF language tag (as defined by BCP 47), for example "en-US".
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", LENGTH_SHORT).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Toast.makeText(this, ""+requestCode, Toast.LENGTH_SHORT).show();
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    str = result.get(0);
                    //txvResult.setText(str);
                    switch (str) {
                        case "apple":
                            String ap = getResources().getResourceEntryName(R.drawable.apple).toString();
                            if (str.equals(ap)){
                                Toast.makeText(this, "Success.."+ap, Toast.LENGTH_SHORT).show();
                            }break;
                        case "mango":
                            String ma = getResources().getResourceEntryName(R.drawable.mango).toString();
                            if (str.equals(ma)){
                                Toast.makeText(this, "Success.."+ma, Toast.LENGTH_SHORT).show();
                            }break;
                        case "parrot":
                            String pa = getResources().getResourceEntryName(R.drawable.parrot).toString();
                            if (str.equals(pa)){
                                Toast.makeText(this, "Success.."+pa, Toast.LENGTH_SHORT).show();
                            }break;
                        case "peacock":
                            String pe = getResources().getResourceEntryName(R.drawable.peacock).toString();
                            if (str.equals(pe)){
                                Toast.makeText(this, "Success.."+pe, Toast.LENGTH_SHORT).show();
                            }break;
                        case "cat":
                            String ca = getResources().getResourceEntryName(R.drawable.cat).toString();
                            if (str.equals(ca)){
                                Toast.makeText(this, "Success.."+ca, Toast.LENGTH_SHORT).show();
                            }break;
                        case "deer":
                            String de = getResources().getResourceEntryName(R.drawable.deer).toString();
                            if (str.equals(de)){
                                Toast.makeText(this, "Success.."+de, Toast.LENGTH_SHORT).show();
                            }break;
                        case "elephant":
                            String el = getResources().getResourceEntryName(R.drawable.elephant).toString();
                            if (str.equals(el)){
                                Toast.makeText(this, "Success.."+el, Toast.LENGTH_SHORT).show();
                            }break;
                        case "tiger":
                            String ti = getResources().getResourceEntryName(R.drawable.tiger).toString();
                            if (str.equals(ti)){
                                Toast.makeText(this, "Success.."+ti, Toast.LENGTH_SHORT).show();
                            }break;
                        case "tortoise":
                            String to = getResources().getResourceEntryName(R.drawable.tortoise).toString();
                            if (str.equals(to)){
                                Toast.makeText(this, "Success.."+to, Toast.LENGTH_SHORT).show();
                            }break;
                        case "monkey":
                            String mo = getResources().getResourceEntryName(R.drawable.monkey).toString();
                            if (str.equals(mo)){
                                Toast.makeText(this, "Success.."+mo, Toast.LENGTH_SHORT).show();
                            }break;
                        case "squirrel":
                            String sq = getResources().getResourceEntryName(R.drawable.squirrel).toString();
                            if (str.equals(sq)){
                                Toast.makeText(this, "Success.."+sq, Toast.LENGTH_SHORT).show();
                            }break;
                        case "snake":
                            String sn = getResources().getResourceEntryName(R.drawable.snake).toString();
                            if (str.equals(sn)){
                                Toast.makeText(this, "Success.."+sn, Toast.LENGTH_SHORT).show();
                            }break;
                        case "dog":
                            String doo = getResources().getResourceEntryName(R.drawable.dog).toString();
                            if (str.equals(doo)){
                                Toast.makeText(this, "Success.."+doo, Toast.LENGTH_SHORT).show();
                            }break;
                        case "pen":
                            String pen = getResources().getResourceEntryName(R.drawable.pen).toString();
                            if (str.equals(pen)){
                                Toast.makeText(this, "Success.."+pen, Toast.LENGTH_SHORT).show();
                            }break;
                        case "bag":
                            String ba = getResources().getResourceEntryName(R.drawable.bag).toString();
                            if (str.equals(ba)){
                                Toast.makeText(this, "Success.."+ba, Toast.LENGTH_SHORT).show();
                            }break;
                        default:
                                Toast.makeText(this, "Unsuccess..U have Spoken:"+str, Toast.LENGTH_SHORT).show();
                            break;
                    }

                }
                break;
        }
    }
}


class MyCustomPagerAdapter extends PagerAdapter {
    private static Uri imageUri;
    Context context;
    int images[];
    LayoutInflater layoutInflater;

    public MyCustomPagerAdapter() {
    }
    public MyCustomPagerAdapter(Context context, int images[]) {
        this.context = context;
        this.images = images;
        //this.names = names;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imgview);
        imageView.setImageResource(images[position]);
       // Toast.makeText(context, "image "+position , Toast.LENGTH_LONG).show();
        container.addView(itemView);
        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(position+1);
            }
            public void send(int n){
                Toast.makeText(context, "Image:::"+n, Toast.LENGTH_LONG).show();
            }
        });

        return itemView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

}

