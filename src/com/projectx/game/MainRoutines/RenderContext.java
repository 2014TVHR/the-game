package com.projectx.game.MainRoutines;

import com.projectx.game.CalculationRoutines.GameEngine;
import com.projectx.game.RenderRoutines.GraphicsEngine;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * 
 * The <b>RenderContext</b> is used by the {@link GameActivity}.
 *
 */
public class RenderContext extends View {
	
	public RenderContext(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//float deltaX = event.getX() - Globals.getTouchX();
		//float deltaY = event.getY() - Globals.getTouchY();
		
		if(event.getAction() == android.view.MotionEvent.ACTION_DOWN)
		{
			Globals.setTouchStartX(event.getX());
			Globals.setTouchStartY(event.getY());
			//deltaX = 0.0f;
			//deltaY = 0.0f;
			
		}

		
		Globals.setTouchX(event.getX());
		Globals.setTouchY(event.getY());
		
		
		return true;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		//TODO: Rico: Warum werden die beiden folgenden Variablen hier gesetzt und nicht im Constructor?
		//TODO: Henrik Die sind f�r globale angaben gedacht. Also f�r die Berechnung etc...
		//TODO: 3. �nderung!
		//TODO: 4. �nderung von Henrik!
		//TODO: 5. �nderung Akira
		//TODO: 6. �nderung (Webinterface)
		//TODO: 7. Test
		//TODO: 8. Test (Henrik)
		//TODO: 9. testilein
		//TODO: 10. Test blabla
		Globals.setScreenSizeX(canvas.getWidth());
		Globals.setScreenSizeY(canvas.getHeight());
		
		Globals.calcTime();
		
		GameEngine.calculate();
		
		GraphicsEngine.render(canvas);
		
		//Forces the RenderContext to refresh its contents.
		invalidate();
	}

}
