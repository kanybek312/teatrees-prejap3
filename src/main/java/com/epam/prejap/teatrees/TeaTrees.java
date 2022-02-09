package com.epam.prejap.teatrees;

import com.epam.prejap.teatrees.pause.Pause;
import com.epam.prejap.teatrees.pause.PauseMonitor;
import com.epam.prejap.teatrees.block.BlockFeed;
import com.epam.prejap.teatrees.game.Move;
import com.epam.prejap.teatrees.game.Playfield;
import com.epam.prejap.teatrees.game.Printer;
import com.epam.prejap.teatrees.game.Waiter;
import com.epam.prejap.teatrees.player.Player;
import com.epam.prejap.teatrees.player.RandomPlayer;
import java.io.InputStreamReader;
import java.util.Random;

class TeaTrees {

    private final Playfield playfield;
    private final Waiter waiter;
    private final Player player;
    private final Printer printer;
    private final PauseMonitor pauseMonitor;

    public TeaTrees(Playfield playfield, Waiter waiter, Player player, Printer printer,PauseMonitor pauseMonitor) {
        this.playfield = playfield;
        this.waiter = waiter;
        this.player = player;
        this.pauseMonitor = pauseMonitor;
        this.printer = printer;
    }
    /**
     * Main game loop.
     *
     * @return final score
     */
    public void play() {
        boolean moved;
        do {
            moved = false;
            playfield.nextBlock();
            boolean nextMove;
            do {
                pauseMonitor.monitor();
                waiter.waitForIt();
                Move move = player.nextMove().orElse(Move.NONE);
                moved |= (nextMove = playfield.move(move));
            } while (nextMove);

        } while (moved);
    }

    public static void main(String[] args) {
        int rows = 10;
        int cols = 20;
        int delay = 500;

        var feed = new BlockFeed();
        var printer = new Printer(System.out);
        var playfield = new Playfield(rows, cols, feed, printer);

        var waiter = new Waiter(0);
        var game = new TeaTrees(playfield, new Waiter(delay), new RandomPlayer(new Random()), printer,
                new PauseMonitor(new InputStreamReader(System.in), new Pause(waiter)));
        game.play();
    }
}
