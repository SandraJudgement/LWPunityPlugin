package ulw.ulw.ulw;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.Window;
import ulw.ulw.ulw.App;
import ulw.ulw.ulw.UnityPlayerActivity;
import com.unity3d.player.UnityPlayerForActivityOrService;
import android.util.Log;

import android.app.WallpaperManager;
import android.content.ComponentName;
public class UnityWallpaperService extends WallpaperService
{
    public void onCreate() {
        super.onCreate();

        if (App.mUnityPlayer == null)
        {
            
        }
//Log.d("test!!", "Start of UnityWallpaperService !!!!!!");
exportText.saveFile("lwp_unityBootMode","0");

    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        App.mUnityPlayer.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        super.onDestroy();
        App.mUnityPlayer.onDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        App.mUnityPlayer.onLowMemory();
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (i == 15) {
            App.mUnityPlayer.onLowMemory();
        }
    }
    public Engine onCreateEngine() {
        return new UnityWallpaperEngine();
    }

    private class UnityWallpaperEngine extends Engine
    {
        public void onTouchEvent(MotionEvent motionEvent) {
            App.mUnityPlayer.mUnityPlayer.injectEvent(motionEvent);
        }

        public void onVisibilityChanged(boolean z) {
            super.onVisibilityChanged(z);


            if(isPreview() && WallpaperUtility.isULWActive(getApplicationContext())) App.PS = z;

            if (z) {
                    App.mUnityPlayer.mUnityPlayer.pause();
                    App.mUnityPlayer.mUnityPlayer.displayChanged(0, getSurfaceHolder().getSurface());
                    App.mUnityPlayer.mUnityPlayer.resume();
            }
            else
            {
                if(!App.ACT == true)
                {
                    if(!App.PS)
                    {
                        App.mUnityPlayer.onPause();
                    }
                    App.PS = false;
                }
            }
            App.mUnityPlayer.onWindowFocusChanged(z);
        }
    }
}