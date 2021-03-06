package edu.niu.cs.z1761257.bouncingball;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Pravin on 4/19/16.
 */
public class BounceSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private BounceThread bounceThread;



    public BounceSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);

        bounceThread = new BounceThread(holder);
    }//end of constructor

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        bounceThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        bounceThread.endBounce();
        Thread dummyThread = bounceThread;
        bounceThread = null;
        dummyThread.interrupt();
    }
}//end of BounceSurfaceView
