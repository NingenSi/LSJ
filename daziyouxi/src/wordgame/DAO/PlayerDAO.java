package wordgame.DAO;

import wordgame.entity.Player;

/**
 * 玩家操作类
 */
public class PlayerDAO {
    private Player player = new Player();
    public Player playInit(int levelNo){
        player.setLevelNo(levelNo);
        player.setCurrScore(0);
        player.setStartTime("0");
        player.setElapsedTime(0);
        return player;
    }
//
//    //计算得分
//    public int allScore(int currScore,int perScore){
//        return currScore + perScore;
//    }
}
