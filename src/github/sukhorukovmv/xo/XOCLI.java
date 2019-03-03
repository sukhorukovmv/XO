package github.sukhorukovmv.xo;

import github.sukhorukovmv.xo.consoleView.View;
import github.sukhorukovmv.xo.controllers.CurrentMoveController;
import github.sukhorukovmv.xo.controllers.MoveController;
import github.sukhorukovmv.xo.controllers.WinnerController;
import github.sukhorukovmv.xo.model.Field;
import github.sukhorukovmv.xo.model.Figure;
import github.sukhorukovmv.xo.model.Game;
import github.sukhorukovmv.xo.model.Player;
import github.sukhorukovmv.xo.model.exceptions.AlreadyOccupiedException;
import github.sukhorukovmv.xo.model.exceptions.InvalidPointException;

import java.util.Optional;

public class XOCLI {
    public static void main(String[] args) {
        View view = new View();
        Player player1 = new Player("Maksim", Figure.X);
        Player player2 = new Player("Alex", Figure.O);
        Player[] players = {player1, player2};
        Game game = new Game(players, new Field(view.enterFieldSize()), "XO");
        MoveController moveController = new MoveController();
        WinnerController winnerController = new WinnerController();
        CurrentMoveController currentMoveController = new CurrentMoveController();
        int quantityOfFigure = game.getField().getSize() * game.getField().getSize();
        for (int i = 0; i < quantityOfFigure; i++) {
            try {
                Optional<Figure> winner = winnerController.getWinner(game.getField());
                if (winner.isPresent()) {
                    System.out.println(winner.get());
                    break;
                }
                Optional<Figure> currentFigure = currentMoveController.currentFigure(game.getField());
                if (currentFigure.isPresent()) {
                    moveController.applyFigure(game.getField(), view.enterPoint(), currentFigure.get());
                } else System.out.println("DRAW");

            } catch (InvalidPointException e) {
                System.out.println("Invalid point, please enter valid point");
                --i;
            } catch (AlreadyOccupiedException e) {
                System.out.println("This cell already occupied, please change the cell");
                --i;
            }
            view.showField(game.getField());
        }
        view.showField(game.getField());
    }
}
