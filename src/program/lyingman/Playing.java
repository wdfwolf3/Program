package program.lyingman;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by wdfwolf3 on 2017/6/22.
 */
public class Playing {
    private Random random;
    private Player[] players;
    private int number;
    private double rateOfHumanWin;

    public Playing(int number) {
        random = new Random();
        this.number = number;
        players = new Player[number];
        for (int i = 0; i < number; i++) {
            players[i] = new Player(i);
        }
        rateOfHumanWin = 0.5;
    }

    public void start() {
        for (int k = 0; k < 3; k++) {
            boolean isHumanWin = getResult();
            System.out.println("第" + (k + 1) + "局" + (isHumanWin ? "好人获胜" : "狼人获胜"));
            int[] sequence = getSequence();
            int[] roles = getRolesNumber();
            int[] scores = getScores();
            if (isHumanWin) {
                for (int i = 0; i < roles[0]; i++) {
                    int index = sequence[i];
                    players[index].setResult(k, 1);
                    players[index].setRole(k, 0);
                }
                for (int i = 0; i < roles[1]; i++) {
                    int index = sequence[i + roles[0]];
                    players[index].setResult(k, 0);
                    players[index].setRole(k, 1);
                    players[index].setScore(players[index].getScore() + scores[1]);
                }
                for (int i = 0; i < roles[2]; i++) {
                    int index = sequence[i + roles[0] + roles[1]];
                    players[index].setResult(k, 0);
                    players[index].setRole(k, 2);
                    players[index].setScore(players[index].getScore() + scores[2]);
                }
                int index1 = sequence[random.nextInt(roles[1] + roles[2]) + roles[0]];
                System.out.println("好人mvp：" + index1 + "号+1分");
                players[index1].setScore(players[index1].getScore() + 1);
                int index2 = sequence[random.nextInt(roles[0])];
                System.out.println("狼人mvp：" + index2 + "号+1分");
                players[index2].setScore(players[index2].getScore() + 1);
            } else {
                for (int i = 0; i < roles[0]; i++) {
                    int index = sequence[i];
                    players[index].setResult(k, 0);
                    players[index].setRole(k, 0);
                    players[index].setScore(players[index].getScore() + scores[0]);
                }
                for (int i = 0; i < roles[1]; i++) {
                    int index = sequence[i + roles[0]];
                    players[index].setResult(k, 1);
                    players[index].setRole(k, 1);
                }
                for (int i = 0; i < roles[2]; i++) {
                    int index = sequence[i + roles[0] + roles[1]];
                    players[index].setResult(k, 1);
                    players[index].setRole(k, 2);
                }
                int index1 = sequence[random.nextInt(roles[1] + roles[2]) + roles[0]];
                System.out.println("好人mvp：" + index1 + "号+1分");
                players[index1].setScore(players[index1].getScore() + 1);
                int index2 = sequence[random.nextInt(roles[0])];
                System.out.println("狼人mvp：" + index2 + "号+1分");
                players[index2].setScore(players[index2].getScore() + 1);
            }
        }
        printResult();
    }

    public boolean getResult() {
        int rate = (int) (rateOfHumanWin * 1000);
        return random.nextInt(1000) < rate;
    }

    public int[] getSequence() {
        int[] sequence = new int[number];
        for (int i = 0; i < number; i++) {
            sequence[i] = i;
        }
        for (int i = 0; i < number; i++) {
            int p = random.nextInt(number);
            int tmp = sequence[i];
            sequence[i] = sequence[p];
            sequence[p] = tmp;
        }
        return sequence;
    }

    public int[] getRolesNumber() {
        if (number == 12) return new int[]{4, 4, 4};
        return new int[]{4, 4, 4};
    }

    public int[] getScores() {
        if (number == 12) return new int[]{3, 2, 1};
        return new int[]{4, 4, 4};
    }

    public void printResult() {
        Arrays.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getScore() <= o2.getScore() ? 1 : -1;
            }
        });

        for (Player player : players) {
            System.out.printf("%2d", player.getNumber());
            System.out.println("号：" + player.getScore() + "分 " + Roles.values()[player.getRole(0)] + Result.values()[player.getResult(0)] + "" + Roles.values()[player.getRole(1)] + Result.values()[player.getResult(1)] + "" + Roles.values()[player.getRole(2)] + Result.values()[player.getResult(2)]);
        }
    }
}
