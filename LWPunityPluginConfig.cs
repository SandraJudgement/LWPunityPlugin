using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

[System.Serializable]
public class Save
{
public string tesstr;
public int tesint = 44;
public float tesfloat;

public int targetFps = 60;
}
public class LWPunityPluginConfig : MonoBehaviour
{
public InputField inputfield_str;
public InputField inputfield_int;
public InputField inputfield_float;
public Slider slider_targetFps;
public Save save = new Save();
    void Start()
    {
        saveLoader();
    }
public void test_updateField(InputField inputField)
    {
        if(inputField.contentType == InputField.ContentType.Standard)
            save.tesstr = inputField.text;
        else if(inputField.contentType == InputField.ContentType.IntegerNumber)
            save.tesint = int.Parse(inputField.text);
        else if(inputField.contentType == InputField.ContentType.DecimalNumber)
            save.tesfloat = float.Parse(inputField.text);
    }
public void saveLoader()
    {
        Load();
        if(inputfield_str != null)
inputfield_str.text = save.tesstr;
        if(inputfield_int != null)
inputfield_int.text = save.tesint.ToString();
        if(inputfield_float != null)
inputfield_float.text = save.tesfloat.ToString();

        if(slider_targetFps != null)
            {
                slider_targetFps.value = save.targetFps;
                Application.targetFrameRate = (int)slider_targetFps.value;
            }
    }
public void updateTargetFps()
    {
        save.targetFps = (int)slider_targetFps.value;
        Application.targetFrameRate = (int)slider_targetFps.value;
    }









////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
public void setConfig()
    {
        Load();
        Application.targetFrameRate = save.targetFps;
    }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

    //セーブ
    public void Save()
    {
        //このクラスが持つ変数をjson形式に変換
        string json = JsonUtility.ToJson(save);

        //PlayerPrefsに保存
        PlayerPrefs.SetString("ConfigData", json);
        PlayerPrefs.Save();
    }

    //ロード
    public void Load()
    {
        //PlayerPrefsからjson形式のデータを取得
        string json = PlayerPrefs.GetString("ConfigData");

        //このクラスが持つ変数へ上書き
        JsonUtility.FromJsonOverwrite(json, save);
    }
}
