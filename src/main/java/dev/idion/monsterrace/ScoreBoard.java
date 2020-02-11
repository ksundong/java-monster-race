package dev.idion.monsterrace;

import dev.idion.monsterrace.monster.Monster;

import java.util.*;

public class ScoreBoard {
    private final Map<Integer, List<String>> rankMap;
    private int winnerMoveCount;

    public ScoreBoard() {
        this.rankMap = new HashMap<>();
    }

    public void rankMonsters(Monster[] monsters) {
        Arrays.stream(monsters).forEach(monster -> {
            int moveCount = monster.getMoveCount();
            winnerMoveCount = Math.max(winnerMoveCount, moveCount);
            List<String> sameDistanceMonsters = rankMap.getOrDefault(moveCount, new ArrayList<>());
            sameDistanceMonsters.add(monster.getMonsterName());
            rankMap.put(moveCount, sameDistanceMonsters);
        });
    }

    public String getWinnerName() {
        List<String> winners = rankMap.get(winnerMoveCount);
        return String.join(", ", winners);
    }
}
