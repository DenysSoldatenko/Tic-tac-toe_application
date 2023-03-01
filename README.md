# Tic-Tac-Toe Game
This is a simple implementation of the popular game Tic-Tac-Toe using Java and Swing.

### How to Play
1. Run the program.
2. Wait for the computer to randomly select who will play first.
3. Click on an empty cell to place your mark (X or O).
4. Alternate turns with the computer until one player wins or the game ends in a draw.

### Features
- Random selection of the starting player.
- Displays the current turn and winner (if any).
- Detects and displays when the game ends in a draw.
- Disables buttons once the game has ended to prevent further moves.

### Technical Details
The game is implemented in Java using the Swing library for the graphical user interface. The game logic is handled in the TicTacToe class, which implements the ActionListener interface to handle button clicks. The game board is represented as an array of JButton objects, and the winning combinations are checked using a two-dimensional array of indices. Once the game ends, the buttons are disabled to prevent further moves.
