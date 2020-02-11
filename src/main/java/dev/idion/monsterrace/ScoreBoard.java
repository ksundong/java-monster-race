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
            List<String> winners = rankMap.getOrDefault(moveCount, new ArrayList<>());
            winners.add(monster.getMonsterName());
            rankMap.put(moveCount, winners);
        });
    }

    public String getWinnerName() {
        List<String> winners = rankMap.get(winnerMoveCount);
        return String.join(", ", winners);
    }
}
