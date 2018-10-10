package wordgame.DAO;

import wordgame.entity.Level;

import java.util.Random;

/**
 * 游戏等级操作类
 */
public class LevelDAO {

    private String[] arry={"A","B","C","D","E","F","G","H","I","J"};
    private Level level = new Level();
    private String word = null;
    //初始化等级
    public Level levelInit(int levelNo,int strLength,long timeLimit, int perScore){

        level.setLevelNo(levelNo);
        level.setStrLength(strLength);
        level.setTimeLimit(timeLimit);
        level.setPerScore(perScore);
        return level;
    }
    //随机生成字符串
    public String randomWord(){
                int mark ;
                word = "";
                Random random = new Random();
                for (int i =0;i<level.getStrLength();i++){
                    mark = random.nextInt(arry.length);
                    word+=arry[mark];
        }

        return word;
    }

}
