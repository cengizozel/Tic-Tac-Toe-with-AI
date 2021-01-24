# Tic-Tac-Toe with AI

A GUI Tic Tac Toe game that uses the Minimax algorithm which allows the AI to find the best move using the alpha-beta-pruning method and returns a heuristic value.

## Demo

![demo](https://user-images.githubusercontent.com/60388555/103140236-47f08480-46b2-11eb-863c-4c8dbaa6e175.gif)

![ezgif com-video-to-gif (3)](https://user-images.githubusercontent.com/60388555/105646663-16183c80-5e6f-11eb-9e4d-8c3cf4bafc0c.gif)

## Installation

Download and run either the 
[exe](https://github.com/cengizozel/Tic-Tac-Toe-with-AI/raw/main/exe/Tic-Tac-Toe.exe)
or
[jar](https://github.com/cengizozel/Tic-Tac-Toe-with-AI/raw/main/exe/Tic-Tac-Toe.jar)
file.

## Usage

This game allows the user to pick between playing against another person (2 Players) or an AI (1 Player). When '1 Player' is selected, the user can choose between a range of difficulties.

The difficulties are:  
**Random:** Moves are completely random.  
**Easy:** 25% chance of making a perfect move.  
**Medium:** 50% chance of making a perfect move.  
**Hard:** 75% chance of making a perfect move.  
**Impossible:** 100% chance of making a perfect move.  

## Minimax Algorithm
Tic Tac Toe is a zero-sum game which means the gain or loss of each player is balanced with the loss or gain (respectively) of the other. This project uses a recursive algorithm in order to choose the next move of the next player after giving a numeric value to the ending of each potential game.

```java
public int minimax(Board board, int depth, int alpha, int beta, boolean maxPlayer) {
        if(depth == 0 || board.isTerminal()) {
            return board.scoreBoard();
        }
        if(maxPlayer) { // Max Player
           int val = Integer.MIN_VALUE;
           ArrayList<Integer> pactions = board.possibleActions();
           for(int i = 0; i < pactions.size(); i ++) {
               Board cb = Board.copyBoard(board);
               cb = Board.playHere(cb, pactions.get(i));

               val = Math.max(val, minimax(cb, depth -1, alpha, beta, false));
               alpha = Math.max(alpha, val);
               if(alpha >= beta) {
                   break;
               }
           }
           return val;
        }
        else { // Min Player
            int val = Integer.MAX_VALUE;
            ArrayList<Integer> pactions = board.possibleActions();
            for(int i = 0; i < pactions.size(); i ++) {
                Board cb = Board.copyBoard(board);
                cb = Board.playHere(cb, pactions.get(i));

                val = Math.min(val, minimax(cb, depth -1, alpha, beta, true));
                beta = Math.min(beta, val);
                if(alpha >= beta) {
                    break;
                }
            }
            return val;
        }
    }
```

Depending of what player the AI is, its goal is to either minimize or maximize the score. This is accomplished with the help of the Alpha-beta pruning algorithm which significantly reduces the number of score comparisons needed to decide the next move.
