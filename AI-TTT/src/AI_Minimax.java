import java.util.ArrayList;

public class AI_Minimax implements AI {
    
    // The Minimax algorithm allows the AI to find the best move using alpha-beta-pruning method and returns a heuristic value.
    
    static int depthLimit = 1;
    static int depth = 0;
    @Override
    public int decideTurn(Board board) {
        
        ArrayList<Integer> pActions = board.possibleActions();
                
        int maxCol = 0;
        int maxValue = Integer.MIN_VALUE;
        int alpha = Integer.MIN_VALUE;
        int beta = Integer.MAX_VALUE;

        for(int i = 0; i < pActions.size(); i++) {
            Board cb = Board.copyBoard(board);
            cb = Board.playHere(cb, pActions.get(i));
            if(maxValue <= minimax(cb, 5, alpha, beta, false)) {
                maxValue = minimax(cb, 5, alpha, beta, false);
                maxCol = pActions.get(i);
                if(alpha >= beta) {
                    break;
                }
            }
        }
        return maxCol;
    }

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
}
