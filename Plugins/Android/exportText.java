package ulw.ulw.ulw;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import android.content.Context;

import android.app.Activity;
import android.os.Bundle;

import ulw.ulw.ulw.App;

public class exportText
{
    // ファイルを保存
    public static void saveFile(String filename,String str) {
        String path = "/data/data/" + App.appPackageName + "/files/" + filename;

        // try-with-resources
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(str);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // ファイルを読み出し
    public static String readFile(String filename) {
        String text = null;
        String path = "/data/data/" + App.appPackageName + "/files/" + filename;
 
        // try-with-resources
        try (
                BufferedReader br = new BufferedReader(new FileReader(path))
        ) {
            text = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
 
        return text;
    }
}