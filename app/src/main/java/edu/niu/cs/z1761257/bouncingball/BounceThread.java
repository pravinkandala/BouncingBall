package edu.niu.cs.z1761257.bouncingball;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by Pravin on 4/19/16.
 */
public class BounceThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private AnimationArena animationArena;
    private boolean isRunning;

    public BounceThread(SurfaceHolder sh){
        isRunning = true;
        surfaceHolder = sh;
        animationArena = new AnimationArena();
    }//end of Constructor

    public void run(){

        try {
            while (isRunning) {
                Canvas canvas = surfaceHolder.lockCanvas();
                animationArena.update(canvas.getWidth(), canvas.getHeight());
                animationArena.draw(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);

            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }//end of run

    public void endBounce(){
        isRunning = false;

    }//end of endBounce
}//end of BounceThread
