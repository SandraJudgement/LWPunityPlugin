using UnityEngine;
using UnityEngine.SceneManagement;
using System.IO;
public static class LWPunityPluginTools
{
public static int unityBootMode;

[RuntimeInitializeOnLoadMethod()]
public static void uniInit()
    {
//Debug.Log("!!!!!!!" + Application.identifier);
# if UNITY_EDITOR
        var path_unityBootMode = Application.persistentDataPath + "/lwp_unityBootMode";
        if(!File.Exists(path_unityBootMode))
            TextFileWriter(path_unityBootMode,"0");
# else
        var path_unityBootMode = "/data/data/" + Application.identifier + "/files/lwp_unityBootMode";
# endif
        unityBootMode = int.Parse(TextFileLoader(path_unityBootMode)[0]);
        if(unityBootMode == 1)
            SceneManager.LoadScene("lwp_configScene", LoadSceneMode.Additive);

        var configData = new LWPunityPluginConfig();
        configData.setConfig();
    }


public static string[] TextFileLoader(string FilePath)
    {
        string TextDATASplit = File.ReadAllText(FilePath);
        TextDATASplit = TextDATASplit.Replace("\r","");

        return TextDATASplit.Split(new char[] {'\n'});
    }
public static void TextFileWriter(string FilePath,string StringData)
    {
        CreateDirectory(FilePath);

        StreamWriter sw = new StreamWriter(FilePath,false);
        sw.Write(StringData);
        sw.Flush();
        sw.Close();
    }
public static DirectoryInfo CreateDirectory(string FilePath)
    {
        string[] GetStrings = FilePath.Split(new char[] {'/','\\'});

        FilePath = "";
        for(int count = 0;count < GetStrings.Length - 1;++count)
            FilePath = Path.Combine(FilePath,GetStrings[count]);

        if(Directory.Exists(FilePath))
            {
                return null;
            }
        return Directory.CreateDirectory(FilePath);
    }
}
