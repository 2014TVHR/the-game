package com.projectx.game.RenderRoutines;

import com.projectx.game.MainRoutines.Globals;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

/**
 * 
 * The <b>GraphicsEngine</b> is called to render the game contents on the current Activity.
 * <br>{@link #render(Canvas)}
 *
 */
public class GraphicsEngine {

	private static Paint defaultPaint = new Paint();
	private static Paint backgroundPaint = new Paint();
	
	/**
	 * Initialize the GraphicsEngine.
	 */
	public static void init() {
		defaultPaint.setARGB(255, 255, 255, 255);
		defaultPaint.setTextSize(40f);
		defaultPaint.setStyle(Paint.Style.STROKE);
		defaultPaint.setShadowLayer(10f, 5f, 5f, Color.BLACK);
		backgroundPaint.setARGB(255, 0, 0, 0);
		
	}
	
	/**
	 * This method is called when the current frame needs to be rendered.
	 * @param canvas
	 */
	public static void render(Canvas canvas) {
		
		int color = (int) (Math.sin((float) (Globals.getTimeMillisec()%1000) / 1000f * 2f * Math.PI) * 55f + 200f);
		backgroundPaint.setARGB(255, color, color, color);
		canvas.drawRect(0f, 0f, Globals.getScreenSizeX(), Globals.getScreenSizeY(), backgroundPaint);
		
		float textPos = (Globals.getTimeMillisec() % 2000) / 2000f * defaultPaint.measureText("Game App") * 2f;
		float currPos = -textPos;//defaultPaint.measureText("Game App") * 2f;
		
		while(currPos < Globals.getScreenSizeX())
		{
			canvas.drawText("Game App", currPos, Globals.getScreenSizeY() / 2f, defaultPaint);
			currPos += defaultPaint.measureText("Game App") * 2f;
		}
	}
}
