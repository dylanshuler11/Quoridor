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

    private Paint brownPaint, redPaint, bluePaint, wallPaint;
    private SurfaceView sv;

    private int svHeight, svWidth, criticalSize, margin, squareSize, boardSize, startingX,
            startingY, wallWid, wallLen;


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

        brownPaint = new Paint();
        brownPaint.setColor(0xFFDEB887);
        redPaint = new Paint();
        redPaint.setColor(Color.RED);
        bluePaint = new Paint();
        bluePaint.setColor(Color.BLUE);
        wallPaint = new Paint();
        wallPaint.setColor(0xFF8B4513);

        sv = (SurfaceView)findViewById(R.id.board);

        updateGlobalMeas();
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        int curX, curY;

        float x0=0,y0=0,r0=0,x1=0,y1=0,r1=0;

        updateGlobalMeas();

        curX = startingX;
        curY = startingY;

        //draws board
        for(int i = 0; i < 9; i++)
        {

            for(int j = 0; j < 9; j++)
            {
                canvas.drawRect(curX, curY, curX+squareSize, curY+squareSize, brownPaint);
                curX += margin;

                //draw player1
                if(j == 4 && i == 1)
                {
                    x0 = curX+(squareSize*.5f);
                    y0 = curY+(squareSize*.5f);
                    r0 = squareSize*.45f;
                }

                //draw player2
                if(j == 6 && i == 6)
                {
                    x1 = curX+(squareSize*.5f);
                    y1 = curY+(squareSize*.5f);
                    r1 = squareSize*.45f;
                }

                //draw horz wall
                if(i == 2 && j == 3)
                {
                    canvas.drawRect(
                            curX,
                            curY-(wallWid+(margin-squareSize))/2,
                            curX+squareSize+margin,
                            curY-((margin-squareSize)-(wallWid+(margin-squareSize))/2),
                            wallPaint);
                }

                //draw vert wall
                if(i == 1 && j == 5)
                {
                    canvas.drawRect(
                            curX -(wallWid+(margin-squareSize))/2,
                            curY,
                            curX-((margin-squareSize)-(wallWid+(margin-squareSize))/2),
                            curY+squareSize+margin,
                            wallPaint);
                }


            }
            curX = startingX;
            curY += margin;
        }
        //canvas.drawCircle(x,y,radius, redPaint);
        //canvas.drawRect(10,10,110,110, brownPaint);

        canvas.drawCircle(x0,y0,r0, redPaint);
        canvas.drawCircle(x1,y1,r1, bluePaint);

        drawP1RemainingWalls(canvas);
        drawP2RemainingWalls(canvas);

    }

    void updateGlobalMeas()
    {
        svHeight = sv.getHeight();
        svWidth = sv.getWidth();
        criticalSize = (svHeight > svWidth) ? svWidth : svHeight;
        margin = criticalSize / 9 - 10;
        squareSize = margin * 2 / 3;

        boardSize = margin * 9 - (margin - squareSize);
        startingX = (svWidth - boardSize)/2;
        startingY = (svHeight - boardSize)/2;
        wallLen = margin + squareSize;
        wallWid = ( margin - squareSize ) / 2;
    }

    void drawP1RemainingWalls(Canvas canvas)
    {
        int curX, curY;
        curX = startingX - (margin - squareSize);
        curY = startingY;

        for (int i=0; i<10; i++)
        {
            canvas.drawRect(curX-wallLen,
                    curY+2*i*wallWid,
                    curX,
                    curY+wallWid+2*i*wallWid,
                    wallPaint);
        }
    }

    void drawP2RemainingWalls(Canvas canvas)
    {
        int curX, curY;
        curX = startingX + (margin*9) ;
        curY = startingY + (margin*8 + squareSize);

        for (int i=0; i<8; i++)
        {
            canvas.drawRect(curX,
                    curY,
                    curX + wallLen,
                    curY-wallWid,
                    wallPaint);
            curY -= 2 * wallWid;
        }
    }


}
