package wordgame.entity;

public class Level {
    private int levelNo; //各级别号
    private int strLength; //各级别一次输出字符串的长度
    private long timeLimit; //各级别闯关的时间限制
    private int perScore; //各级别正确输入一次的得分

    public int getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(int levelNo) {
        this.levelNo = levelNo;
    }

    public int getStrLength() {
        return strLength;
    }

    public void setStrLength(int strLength) {
        this.strLength = strLength;
    }


    public long getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getPerScore() {
        return perScore;
    }

    public void setPerScore(int perScore) {
        this.perScore = perScore;
    }
}
