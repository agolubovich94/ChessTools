package com.example.chesstools;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    Button imageButton;
    private static final int[] IMAGESblack = { R.drawable.b_rook, R.drawable.b_knight, R.drawable.b_bishop,
                                               R.drawable.b_queen, R.drawable.b_king};
    private static final int[] IMAGESwhite = { R.drawable.w_rook, R.drawable.w_knight, R.drawable.w_bishop,
                                               R.drawable.w_queen, R.drawable.w_king};
    private ImageSwitcher[] mbImageSwitcher = new ImageSwitcher[8];
    private ImageSwitcher[] mwImageSwitcher = new ImageSwitcher[8];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_OPTIONS_PANEL);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.randomizer);

        mbImageSwitcher[0] = (ImageSwitcher) findViewById(R.id.imageSwitcherb0);
        mbImageSwitcher[1] = (ImageSwitcher) findViewById(R.id.imageSwitcherb1);
        mbImageSwitcher[2] = (ImageSwitcher) findViewById(R.id.imageSwitcherb2);
        mbImageSwitcher[3] = (ImageSwitcher) findViewById(R.id.imageSwitcherb3);
        mbImageSwitcher[4] = (ImageSwitcher) findViewById(R.id.imageSwitcherb4);
        mbImageSwitcher[5] = (ImageSwitcher) findViewById(R.id.imageSwitcherb5);
        mbImageSwitcher[6] = (ImageSwitcher) findViewById(R.id.imageSwitcherb6);
        mbImageSwitcher[7] = (ImageSwitcher) findViewById(R.id.imageSwitcherb7);

        mwImageSwitcher[0] = (ImageSwitcher) findViewById(R.id.imageSwitcherw0);
        mwImageSwitcher[1] = (ImageSwitcher) findViewById(R.id.imageSwitcherw1);
        mwImageSwitcher[2] = (ImageSwitcher) findViewById(R.id.imageSwitcherw2);
        mwImageSwitcher[3] = (ImageSwitcher) findViewById(R.id.imageSwitcherw3);
        mwImageSwitcher[4] = (ImageSwitcher) findViewById(R.id.imageSwitcherw4);
        mwImageSwitcher[5] = (ImageSwitcher) findViewById(R.id.imageSwitcherw5);
        mwImageSwitcher[6] = (ImageSwitcher) findViewById(R.id.imageSwitcherw6);
        mwImageSwitcher[7] = (ImageSwitcher) findViewById(R.id.imageSwitcherw7);

        addListenerOnButton();

        for(int counter = 0; counter < 8; counter++ ) {
            mbImageSwitcher[counter].setFactory(new ViewSwitcher.ViewFactory() {
                @Override
                public View makeView() {
                    ImageView imageView = new ImageView(MainActivity.this);
                    return imageView;
                }
            });
            mbImageSwitcher[counter].setInAnimation(this, android.R.anim.slide_in_left);
            mbImageSwitcher[counter].setOutAnimation(this, android.R.anim.slide_out_right);
            mwImageSwitcher[counter].setFactory(new ViewSwitcher.ViewFactory() {
                @Override
                public View makeView() {
                    ImageView imageView = new ImageView(MainActivity.this);
                    return imageView;
                }
            });
            mwImageSwitcher[counter].setInAnimation(this, android.R.anim.slide_in_left);
            mwImageSwitcher[counter].setOutAnimation(this, android.R.anim.slide_out_right);
        };

        mbImageSwitcher[0].setImageResource(IMAGESblack[Figures.ROOK.get() - 1]);
        mbImageSwitcher[1].setImageResource(IMAGESblack[Figures.KNIGHT.get() - 1]);
        mbImageSwitcher[2].setImageResource(IMAGESblack[Figures.BISHOP.get() - 1]);
        mbImageSwitcher[3].setImageResource(IMAGESblack[Figures.QUEEN.get() - 1]);
        mbImageSwitcher[4].setImageResource(IMAGESblack[Figures.KING.get() - 1]);
        mbImageSwitcher[5].setImageResource(IMAGESblack[Figures.BISHOP.get() - 1]);
        mbImageSwitcher[6].setImageResource(IMAGESblack[Figures.KNIGHT.get() - 1]);
        mbImageSwitcher[7].setImageResource(IMAGESblack[Figures.ROOK.get() - 1]);

        mwImageSwitcher[0].setImageResource(IMAGESwhite[Figures.ROOK.get() - 1]);
        mwImageSwitcher[1].setImageResource(IMAGESwhite[Figures.KNIGHT.get() - 1]);
        mwImageSwitcher[2].setImageResource(IMAGESwhite[Figures.BISHOP.get() - 1]);
        mwImageSwitcher[3].setImageResource(IMAGESwhite[Figures.QUEEN.get() - 1]);
        mwImageSwitcher[4].setImageResource(IMAGESwhite[Figures.KING.get() - 1]);
        mwImageSwitcher[5].setImageResource(IMAGESwhite[Figures.BISHOP.get() - 1]);
        mwImageSwitcher[6].setImageResource(IMAGESwhite[Figures.KNIGHT.get() - 1]);
        mwImageSwitcher[7].setImageResource(IMAGESwhite[Figures.ROOK.get() - 1]);
    }



    private void addListenerOnButton() {
        imageButton = (Button) findViewById(R.id.button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                FischerRand fisherRand = new FischerRand();
                int[] finalResult = fisherRand.rand();
                for(int counter = 0; counter < 8; counter++ ) {
                    mwImageSwitcher[counter].setImageResource(IMAGESwhite[finalResult[counter] - 1]);
                    mbImageSwitcher[counter].setImageResource(IMAGESblack[finalResult[counter] - 1]);
                };

            }

        });

    }
}

