package program.win;

/**
 * Created by wdfwolf3 on 2017/6/25.
 */

import com.sun.jna.platform.win32.*;
import com.sun.jna.platform.win32.WinDef.HMODULE;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser.HHOOK;
import com.sun.jna.platform.win32.WinUser.KBDLLHOOKSTRUCT;
import com.sun.jna.platform.win32.WinUser.LowLevelKeyboardProc;


public class KeyBoardHook implements Runnable {
    static HHOOK keyboardHHK;    // 键盘钩子的句柄
    static LowLevelKeyboardProc keyboardHook;            // 键盘钩子函数

    // 安装钩子
    void setHook() {
        HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
        keyboardHHK = User32.INSTANCE.SetWindowsHookEx(WinUser.WH_KEYBOARD_LL, keyboardHook, hMod, 0);
    }

    // 卸载钩子
    void unhook() {
        User32.INSTANCE.UnhookWindowsHookEx(keyboardHHK);
        System.exit(0);
    }

    public void run() {
        keyboardHook = new LowLevelKeyboardProc() {

            @Override
            // 该函数参数的意思参考：http://msdn.microsoft.com/en-us/library/windows/desktop/ms644985(v=vs.85).aspx
            public LRESULT callback(int nCode, WPARAM wParam, KBDLLHOOKSTRUCT lParam) {
                int w = wParam.intValue();
                // 按下alt键时w=WinUser.WM_SYSKEYDOWN; 按下其他大部分键时w=WinUser.WM_KEYDOWN
                if (w == WinUser.WM_KEYDOWN || w == WinUser.WM_SYSKEYDOWN) {
                    System.out.println("key down: vkCode = " + displayCode(lParam.vkCode));
//                    print();
                } else if (w == WinUser.WM_KEYUP || w == WinUser.WM_SYSKEYUP)
                    System.out.println("key up: vkCode = " + displayCode(lParam.vkCode));

                // 如果按下'q'退出程序，'q'的vkCode是81
                if (lParam.vkCode == 81) {
                    System.err.println("program terminated.");
                    unhook();
                }
                return User32.INSTANCE.CallNextHookEx(keyboardHHK, nCode, wParam, lParam.getPointer());
            }

            private char displayCode(int vkCode) {
/*				if ( vkCode > 'a' && vkCode < 'z') {
                    return "" + ( char ) vkCode;
				}
				if ( vkCode > 'A' && vkCode < 'Z') {
					return "" + ( char ) vkCode;
				}*/
                return (char) vkCode;
            }
        };
        System.out.println("press 'q' to quit.");
        setHook();

        int result;
        WinUser.MSG msg = new WinUser.MSG();
        // 消息循环
        // 实际上while循环一次都不执行，这些代码的作用我理解是让程序在GetMessage函数这里阻塞，不然程序就结束了。
        while ((result = User32.INSTANCE.GetMessage(msg, null, 0, 0)) != 0) {
            if (result == -1) {
                System.err.println("error in GetMessage");
                unhook();
                break;
            } else {
                User32.INSTANCE.TranslateMessage(msg);
                User32.INSTANCE.DispatchMessage(msg);
            }
        }
        unhook();
    }

    public static void print() {
        WinDef.HWND h1 = User32.INSTANCE.GetForegroundWindow();
//        User32.INSTANCE.MoveWindow(h1,10,10,10,10,true);
        WinUser.INPUT input = new WinUser.INPUT();
        Character ch = 'a';
        input.type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
        input.input.setType("ki"); // Because setting INPUT_INPUT_KEYBOARD is not enough: https://groups.google.com/d/msg/jna-users/NDBGwC1VZbU/cjYCQ1CjBwAJ
        input.input.ki.wScan = new WinDef.WORD(0);
        input.input.ki.time = new WinDef.DWORD(0);
        input.input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
        // Press
        input.input.ki.wVk = new WinDef.WORD(Character.toUpperCase(ch)); // 0x41
        input.input.ki.dwFlags = new WinDef.DWORD(0);  // keydown

        User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());

        // Release
        input.input.ki.wVk = new WinDef.WORD(Character.toUpperCase(ch)); // 0x41
        input.input.ki.dwFlags = new WinDef.DWORD(2);  // keyup

        User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());
    }
}
