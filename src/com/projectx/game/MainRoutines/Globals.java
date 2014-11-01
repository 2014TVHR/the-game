package com.projectx.game.MainRoutines;

public class Globals {
	//GAMEMODE for all different screens
	public static final int GAMEMODE_START		 = 0;
	public static final int GAMEMODE_MAIN_MENU	 = 1;
	public static final int GAMEMODE_PAUSE_MENU	 = 2;
	public static final int GAMEMODE_INGAME		 = 3;
	public static final int GAMEMODE_SETTINGS	 = 4;
	
	//screen size
	private static float screenSizeX = 0f;
	private static float screenSizeY = 0f;
	
	//touch coordinates
	private static float touchX = 0f;
	private static float touchY = 0f;
	//drag and drop
	private static float touchStartX = 0f;
	private static float touchStartY = 0f;
	
	//current mode of the app
	private static int gameMode = GAMEMODE_START;
	private static boolean isRunning = false;
	
	//time calculations
	private static long lastTimeMillisec = 0;
	private static long timeDifferenceMillisec = 0;
	private static float timeDifference = 0f;
	
	public static void init()
	{
		lastTimeMillisec = System.currentTimeMillis();
		timeDifferenceMillisec = 0;
		timeDifference = 0f;
	}
	
	public static void calcTime()
	{
		long currentTime = System.currentTimeMillis();
		timeDifferenceMillisec = currentTime - lastTimeMillisec;
		timeDifference = (float) timeDifferenceMillisec / 1000f;
		lastTimeMillisec = currentTime;
	}
	
	public static float getFPS()
	{
		if(timeDifference > 0f)
		{
			return 1f / timeDifference;
		}
		else
		{
			return 0f;
		}
	}
	
	public static float getTick()
	{
		return timeDifference;
	}
	
	public static long getTimeMillisec()
	{
		return lastTimeMillisec;
	}
	
	public static double getTimeSec()
	{
		return (double) lastTimeMillisec / 1000.0d;
	}
	
	public static float getScreenSizeX() {
		return screenSizeX;
	}
	public static void setScreenSizeX(float screenSizeX) {
		Globals.screenSizeX = screenSizeX;
	}
	public static float getScreenSizeY() {
		return screenSizeY;
	}
	public static void setScreenSizeY(float screenSizeY) {
		Globals.screenSizeY = screenSizeY;
	}
	public static float getTouchX() {
		return touchX;
	}
	public static void setTouchX(float touchX) {
		Globals.touchX = touchX;
	}
	public static float getTouchY() {
		return touchY;
	}
	public static void setTouchY(float touchY) {
		Globals.touchY = touchY;
	}
	public static int getGameMode() {
		return gameMode;
	}
	public static void setGameMode(int gameMode) {
		Globals.gameMode = gameMode;
	}

	public static boolean isRunning() {
		return isRunning;
	}

	public static void setRunning(boolean isRunning) {
		Globals.isRunning = isRunning;
	}

	public static float getTouchStartX() {
		return touchStartX;
	}

	public static void setTouchStartX(float touchStartX) {
		Globals.touchStartX = touchStartX;
	}

	public static float getTouchStartY() {
		return touchStartY;
	}

	public static void setTouchStartY(float touchStartY) {
		Globals.touchStartY = touchStartY;
	}
	
	
}
