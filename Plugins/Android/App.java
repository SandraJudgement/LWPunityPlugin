package ulw.ulw.ulw;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.unity3d.player.UnityPlayer;
import ulw.ulw.ulw.UnityPlayerActivity;
import com.unity3d.player.UnityPlayerForActivityOrService;

public class App extends Application
{
public static UnityPlayerActivity mUnityPlayer;
    public static boolean PS;
    public static boolean ACT = false;

    private static App instance;

    public App() {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }



    @Override
    public void onCreate()
    {
        super.onCreate();
        if (mUnityPlayer == null)
        {
            mUnityPlayer = new UnityPlayerActivity();
            mUnityPlayer.mUnityPlayer = new UnityPlayerForActivityOrService(getContext());
            mUnityPlayer.mUnityPlayer.getFrameLayout().requestFocus();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        UnityPlayerActivity.mUnityPlayer.configurationChanged(newConfig);
    }
}
