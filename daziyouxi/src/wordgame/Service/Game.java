package wordgame.Service;

import wordgame.DAO.LevelDAO;
import wordgame.DAO.PlayerDAO;
import wordgame.entity.Level;
import wordgame.entity.Player;

import java.util.Scanner;
import java.util.Timer;

public class Game {
    public void start(){

        Scanner input = new Scanner(System.in);
        LevelDAO levelDAO = new LevelDAO();
        PlayerDAO playerDAO = new PlayerDAO();
        Level level = null;
        Player player = null;
        String word ="";
        long time1;
        long time2;
        int levelCount = 0;
        int count = 0;

        //设置定时器
        Timer timer = new Timer();

        //初始化
        level = levelDAO.levelInit(1,2,10,100);
        player = playerDAO.playInit(level.getLevelNo());

        //游戏开始
        System.out.println("健康游戏，适当休息！");
        System.out.println("请输入与下面字符串相同的字母！");

        while (levelCount < 3) {
            //游戏计时器
            timer.schedule(new MyTimer(),level.getTimeLimit()*1000,level.getTimeLimit()*1000);

            while (count < 3) {
                String str = levelDAO.randomWord(); //获取随机字符串
                System.out.println(str);
                time1 = System.currentTimeMillis();
                word = input.next();

                if (!word.equalsIgnoreCase(str)) {
                    System.out.println("输入错误！游戏结束！");
                    System.exit(0);
                } else {
                    player.setCurrScore(player.getCurrScore() + level.getPerScore());//计算当前得分
                    time2 = System.currentTimeMillis();
                    player.setElapsedTime(player.getElapsedTime() + (time2 - time1) / 1000);
                    System.out.println("恭喜进入下一关！");
                    System.out.println("当前游戏等级为：" + level.getLevelNo() + "  当前积分为：" + player.getCurrScore() + "  当前等级已花费：" + player.getElapsedTime() + "秒");

                }
                count++;
            }
            count=0;
            levelCount++;
            //取消定时器并重新初始化
            timer.cancel();
            timer = new Timer();
            //游戏难度提升
            level.setLevelNo(levelCount+1);
            level.setTimeLimit(level.getTimeLimit()+5);
            level.setPerScore(level.getPerScore()*2);
            level.setStrLength(level.getStrLength()*2);
            player.setElapsedTime(0);
            levelDAO.levelInit(level.getLevelNo(),level.getStrLength(),level.getTimeLimit(),level.getPerScore());

        }
        System.out.println("通关成功！");
    }
}
