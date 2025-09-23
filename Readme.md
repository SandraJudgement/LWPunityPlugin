# Unity Live Wallpaperプラグイン
```
UnityVersion: Unity6(6000.0.26f1)
```
あまりjavaを扱いなれてない人が気合だけで改変したので、正しくない部分もあるかもしれませんが動作したのでアップロードしました。

## 使い方
```
Assetsフォルダ直下に置いてください。

プロジェクト設定→プレイヤー→公開設定→カスタムメインマニフェストにチェックを入れます。

ビルドプロファイル→シーンリストの、最初のシーン以外にlwp_configSceneを追加してください。

（ホーム画面から起動すると、lwp_configSceneが開きます。

lwp_configScene、LWPunityPluginConfigは自由に改変してください。

LWPunityPluginConfigのsetConfigがゲーム開始時呼ばれます。）
```

恐らくビルドが通ると思います。

## フォーク元
このプラグインはこのプロジェクトのフォークです。
```
https://github.com/MartinRGB/Unity3dAndroidLiveWallpaper/
```
