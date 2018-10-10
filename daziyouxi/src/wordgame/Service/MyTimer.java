package wordgame.Service;

import java.util.TimerTask;

public class MyTimer extends TimerTask {
    @Override
    public void run() {
        System.out.println("输入超时！游戏结束！");
        System.exit(0);
    }
}
