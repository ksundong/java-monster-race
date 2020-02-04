# java-monster-race

코드스쿼드 백엔드 자바 학습 프로젝트 1

## 구현하기

- lucas의 요구사항 문서를 참고해서 구현한다.
- 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.

## PR 보내는 법

- 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
- 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

- [텍스트와 이미지로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)
- [동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://youtu.be/a5c9ku-_fok)

---

# STEP1

1. 몬스터의 확장성을 위해 Monster라는 클래스를 생성
2. 몬스터 레이스를 수행할 Race라는 클래스를 생성
3. Race 수행시 입력을 받아야 하므로 Scanner를 추가하였고, 이를 닫아주는 부분을 terminateGame이라는 메소드에 추가하였습니다.
4. Game을 준비하는 과정 구현(1): 몬스터의 수를 입력받는 메소드를 만들었습니다. 잘못된 입력이 들어오면, 예외처리가 필요하여 종료 코드를 주어 종료되도록 terminateGame 메소드를 수정하였습니다.
5. Game을 준비하는 과정 구현(2): 시도할 횟수를 입력받는 메소드를 만들었습니다. inputMonsterCount와 마찬가지로 예외처리를 해주었습니다.
6. Monster 클래스에 이동 거리를 저장할 int형 변수 moveCount를 private 접근제어자로 생성하였습니다.
7. Monster들을 저장할 배열인 monsters를 Race 클래스에 선언하였습니다. 그리고, 이를 입력받은 수 만큼 배열을 생성하고, 이를 채우도록 하였습니다.
8. Race를 시작할 startGame 메소드를 생성하였습니다.
9. 게임을 시작하면, 입력한 시도횟수 만큼 random값을 만들어서 Monster의 이동 거리를 추가할 것인지 결정하는 randomAttempt 메소드를 생성하고, moveCount가 private 선언이 되어있기 때문에 이를 컨트롤 할 수 있게 하는  plusMoveCount 메소드를 생성하였습니다.
10. 게임을 종료하면 결과를 출력하는 endGame 메소드를 추가하고, monsters 배열에 있는 Monster들의 각각의 이동거리를 출력하는 printMonstersMovingDistance 메소드를 추가하였습니다. Monster별로 이동거리를 출력해주기 위해 showMovingDistance라는 메소드를 Monster 클래스에 추가해주었습니다.
11. Arrays.fill은 한 객체로만 채워주어서 제가 원하는 결과가 나오지 않아 fillMonsterIntoMonsters라는 메소드를 직접 만들어주었습니다.

# STEP2

## 요구사항 분석

- [x] depth를 최대 1단계로 줄이기
- [x] else 문 사용하지 않기
- [x] 메소드의 크기가 10라인을 넘지 않도록 하기
- [x] 메소드가 한 번에 한 가지 일만 하도록 만들기
- [x] 자바 코딩 컨벤션을 지키면서 만들기