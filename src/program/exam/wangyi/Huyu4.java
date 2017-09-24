package program.exam.wangyi;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/9/16.
 */
public class Huyu4 {
    public static int hp;
    public static int ack;
    public static int cd;
    public static int[] ji;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        int[] print = new int[t];
        for (int i = 0; i < t; i++) {
            hp = in.nextInt();
            ack = in.nextInt();
            cd = in.nextInt();
            ji = new int[cd];
            int tmp1 = Math.max(in.nextInt(),ack),tmp2 = Math.max(in.nextInt(),ack),tmp3 = Math.max(in.nextInt(),ack);
            int j1 = Math.max(tmp1, tmp2), j2 = Math.min(tmp1, tmp2),j3;
            if (tmp3>= j1){
                j3 = j2;
                j2 = j1;
                j1 = tmp3;
            }else if (tmp3 <= j2){
                j3 = tmp3;
            }else {
                j3 = j2;
                j2 = tmp3;
            }
            for (int j = 0; j < cd; j++) {
                if (j == 0)
                    ji[j] = j1;
                else if (j==1)
                    ji[j] =j2;
                else if (j==2)
                    ji[j] = j3;
                else
                    ji[j] = ack;
            }
            int hp1 = in.nextInt(), ack1 = in.nextInt(), hp2 = in.nextInt(),ack2 = in.nextInt(), hp3 = in.nextInt(), ack3 = in.nextInt();
            int t1 = time(hp1),t2 = time(hp2),t3 = time(hp3);
            int ans = t1*(ack2+ack3)+Math.min(t2*ack3, t3*ack2);
            ans = Math.min(ans, t2*(ack1+ack3) + Math.min(t1*ack3, t3*ack1));
            ans = Math.min(ans, t3*(ack1 + ack2) +Math.min(t1*ack2, t2*ack1));
            ans += (t1*ack1 + t2*ack2 +t3*ack3);
            print[i] = ans>=hp?-1:hp-ans;
        }
        for (int i = 0; i < t; i++) {
            System.out.println(print[i]);
        }
    }

    public static int time(int hp){
        int time = 0, i = 0;
        while (hp > 0){
            hp -= ji[i];
            i = (i+1)%cd;
            time++;
        }
        return time;
    }
}
