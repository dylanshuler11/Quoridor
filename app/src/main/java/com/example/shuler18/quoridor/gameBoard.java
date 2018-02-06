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
        float x0=0,y0=0,r0=0,x1=0,y1=0,r1=0;
        SurfaceView sv = (SurfaceView)findViewById(R.id.board);

        Paint brownPaint = new Paint();
        brownPaint.setColor(0xFFDEB887);
        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        Paint bluePaint = new Paint();
        bluePaint.setColor(Color.BLUE);

        margin = canvas.getHeight() / 9 - 10;
        squareSize = margin * 2 / 3;


        int startingX = canvas.getWidth() - margin * 10;
        int startingY = canvas.getHeight() - margin * 10 + squareSize;

        curX = startingX;
        curY = startingY;


        //draws board
        for(int i = 0; i < 9; i++)
        {

            for(int j = 0; j < 9; j++)
            {
                canvas.drawRect(curX, curY, curX+squareSize, curY+squareSize, brownPaint);
                curX += margin;
                
                if(j == 4 && i == 1)
                {
                    x0 = curX+(squareSize*.5f);
                    y0 = curY+(squareSize*.5f);
                    r0 = squareSize*.45f;
                }

                if(j == 6 && i == 6)
                {
                    x1 = curX+(squareSize*.5f);
                    y1 = curY+(squareSize*.5f);
                    r1 = squareSize*.45f;
                }

            }
            curX = startingX;
            curY += margin;
        }
        //canvas.drawCircle(x,y,radius, redPaint);
        //canvas.drawRect(10,10,110,110, brownPaint);

        canvas.drawCircle(x0,y0,r0, redPaint);
        canvas.drawCircle(x1,y1,r1, bluePaint);

    }


}
