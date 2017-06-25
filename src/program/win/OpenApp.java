package program.win;

import java.io.IOException;

/**
 * Created by wdfwolf3 on 2017/6/25.
 */
public class OpenApp {
    public static void main(String[] args) {
        String path = "C:\\Program Files (x86)\\Tencent\\QQ\\Bin\\QQScLauncher.exe"; //(C:\Program Files\Tencent\QQ\Bin\qq.exe)
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
