package program.lyingman;

/**
 * Created by wdfwolf3 on 2017/6/22.
 */
public class Player {
    private int number;
    private int[] results;
    private int[] roles;
    private int score;


    public Player(int number) {
        this.number = number;
        results = new int[]{1, 1, 1};
        roles = new int[3];
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getResult(int n) {
        return results[n];
    }

    public void setResult(int n, int result) {
        results[n] = result;
    }

    public int getRole(int n) {
        return roles[n];
    }

    public void setRole(int n, int role) {
        roles[n] = role;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
