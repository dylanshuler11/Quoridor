package com.example.shuler18.quoridor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceView;

/**
 * Created by shuler18 on 2/5/2018.
 */

public class gameBoard extends SurfaceView {


    public gameBoard(Context context) {
        super(context);
        gameBoardInit();
    }

    public gameBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
        gameBoardInit();
    }

    public gameBoard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        gameBoardInit();
    }

    public void gameBoardInit()
    {
        setWillNotDraw(false);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        int curX, curY, margin, squareSize;
        float x = 0,y=0,radius=0;
        SurfaceView sv = (SurfaceView)findViewById(R.id.board);

        Paint brownPaint = new Paint();
        brownPaint.setColor(0xFFDEB887);
        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        Paint bluePaint = new Paint();
        bluePaint.setColor(Color.BLUE);

        curX = 600;
        curY = 10;
        squareSize = 100;
        margin = 150;

        for(int i = 0; i < 9; i++)
        {

            for(int j = 0; j < 9; j++)
            {
                canvas.drawRect(curX, curY, curX+squareSize, curY+squareSize, brownPaint);
                curX += margin;
                
                if(j == 4 && i == 1)
                {
                    x = curX+(squareSize*.5f);
                    y = curY+(squareSize*.5f);
                    radius = squareSize*.45f;

                    canvas.drawCircle(x,y,radius, redPaint);

                }

            }
            curX = 600;
            curY += margin;
        }
        //canvas.drawCircle(x,y,radius, redPaint);
        //canvas.drawRect(10,10,110,110, brownPaint);

    }


}
