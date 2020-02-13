package dev.idion.monsterrace;

import dev.idion.monsterrace.monster.Monster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreBoard {
    private final Map<Integer, List<String>> rankMap;
    private int winnerMoveCount;

    public ScoreBoard() {
        this.rankMap = new HashMap<>();
    }

    public Map<Integer, List<String>> rankMonsters(List<Monster> monsters) {
        for (Monster monster : monsters) {
            int moveCount = monster.getMoveCount();
            winnerMoveCount = Math.max(winnerMoveCount, moveCount);
            List<String> sameDistanceMonsters = rankMap.getOrDefault(moveCount, new ArrayList<>());
            sameDistanceMonsters.add(monster.getMonsterName());
            rankMap.put(moveCount, sameDistanceMonsters);
        }
        return rankMap;
    }

    public String getWinnerName() {
        List<String> winners = rankMap.get(winnerMoveCount);
        return String.join(", ", winners);
    }
}
