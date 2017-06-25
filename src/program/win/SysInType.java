package program.win;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.win32.StdCallLibrary;

/**
 * Created by wdfwolf3 on 2017/6/25.
 */
public class SysInType {


    public static void main(String[] args) {


        HWND h1 = User32.INSTANCE.GetForegroundWindow();
//        User32.INSTANCE.MoveWindow(h1,10,10,10,10,true);
        WinUser.INPUT input = new WinUser.INPUT(  );
        Character ch = 'a';
        input.type = new WinDef.DWORD( WinUser.INPUT.INPUT_KEYBOARD );
        input.input.setType("ki"); // Because setting INPUT_INPUT_KEYBOARD is not enough: https://groups.google.com/d/msg/jna-users/NDBGwC1VZbU/cjYCQ1CjBwAJ
        input.input.ki.wScan = new WinDef.WORD( 0 );
        input.input.ki.time = new WinDef.DWORD( 0 );
        input.input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR( 0 );
        // Press
        input.input.ki.wVk = new WinDef.WORD( Character.toUpperCase(ch) ); // 0x41
        input.input.ki.dwFlags = new WinDef.DWORD( 0 );  // keydown

        User32.INSTANCE.SendInput( new WinDef.DWORD( 1 ), ( WinUser.INPUT[] ) input.toArray( 1 ), input.size() );

        // Release
        input.input.ki.wVk = new WinDef.WORD( Character.toUpperCase(ch) ); // 0x41
        input.input.ki.dwFlags = new WinDef.DWORD( 2 );  // keyup

        User32.INSTANCE.SendInput( new WinDef.DWORD( 1 ), ( WinUser.INPUT[] ) input.toArray( 1 ), input.size() );
//        Myuser32 myuser32 = Myuser32.INSTANCE;
//        HWND h = user32.FindWindow(windowClass, title);
    }

}
