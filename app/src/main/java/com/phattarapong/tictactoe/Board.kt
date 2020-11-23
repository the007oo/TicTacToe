package com.phattarapong.tictactoe

import android.util.Log
import kotlin.math.roundToInt
import kotlin.random.Random

class Board(var cellsNumber: Int = 3) {

    //Strings for PLAYER and COMPUTER
    companion object {
        const val PLAYER = "O"
        const val COMPUTER = "X"
    }

    //This is our internal board
    //and for this we used a 3 by 3 array of Strings
    val board = Array(cellsNumber) { arrayOfNulls<String>(cellsNumber) }

    //This property is giving us
    //a list of all the empty cells
    val availableCells: List<Cell>
        get() {
            val cells = mutableListOf<Cell>()
            for (i in board.indices) {
                for (j in board.indices) {
                    if (board[i][j].isNullOrEmpty()) {
                        cells.add(Cell(i, j))
                    }
                }
            }
            return cells
        }

    //this property will tell
    //if the game is over or not
    val isGameOver: Boolean
        get() = hasComputerWon() || hasPlayerWon() || availableCells.isEmpty()

    //These functions are checking
    //Weather the computer or player has won or not
    fun hasComputerWon(): Boolean {
        if (cellsNumber == 3) {
            // Check Cross
            if (board[0][0] == board[1][1] &&
                board[0][0] == board[2][2] &&
                board[0][0] == COMPUTER ||
                board[0][2] == board[1][1] &&
                board[0][2] == board[2][0] &&
                board[0][2] == COMPUTER
            ) {
                return true
            }

            // Check Line
            for (i in board.indices) {
                if (
                    board[i][0] == board[i][1] &&
                    board[i][0] == board[i][2] &&
                    board[i][0] == COMPUTER ||
                    board[0][i] == board[1][i] &&
                    board[0][i] == board[2][i] &&
                    board[0][i] == COMPUTER
                ) {
                    return true
                }
            }
        } else if (cellsNumber == 4) {
            // Check Cross
            if (board[0][0] == board[1][1] &&
                board[0][0] == board[2][2] &&
                board[0][0] == board[3][3] &&
                board[0][0] == COMPUTER ||
                board[0][3] == board[1][2] &&
                board[0][3] == board[2][1] &&
                board[0][3] == board[3][0] &&
                board[0][3] == COMPUTER
            ) {
                return true
            }

            // Check Line
            for (i in board.indices) {
                if (
                    board[i][0] == board[i][1] &&
                    board[i][0] == board[i][2] &&
                    board[i][0] == board[i][3] &&
                    board[i][0] == COMPUTER ||
                    board[0][i] == board[1][i] &&
                    board[0][i] == board[2][i] &&
                    board[0][i] == board[3][i] &&
                    board[0][i] == COMPUTER
                ) {
                    return true
                }
            }
        } else if (cellsNumber == 5) {
            // Check Cross
            if (board[0][0] == board[1][1] &&
                board[0][0] == board[2][2] &&
                board[0][0] == board[3][3] &&
                board[0][0] == board[4][4] &&
                board[0][0] == COMPUTER ||
                board[0][4] == board[1][3] &&
                board[0][4] == board[2][2] &&
                board[0][4] == board[3][1] &&
                board[0][4] == board[4][0] &&
                board[0][4] == COMPUTER
            ) {
                return true
            }

            // Check Line
            for (i in board.indices) {
                if (
                    board[i][0] == board[i][1] &&
                    board[i][0] == board[i][2] &&
                    board[i][0] == board[i][3] &&
                    board[i][0] == board[i][4] &&
                    board[i][0] == COMPUTER ||
                    board[0][i] == board[1][i] &&
                    board[0][i] == board[2][i] &&
                    board[0][i] == board[3][i] &&
                    board[0][i] == board[4][i] &&
                    board[0][i] == COMPUTER
                ) {
                    return true
                }
            }
        } else if (cellsNumber == 6) {
            // Check Cross
            if (board[0][0] == board[1][1] &&
                board[0][0] == board[2][2] &&
                board[0][0] == board[3][3] &&
                board[0][0] == board[4][4] &&
                board[0][0] == board[5][5] &&
                board[0][0] == COMPUTER ||
                board[0][5] == board[1][4] &&
                board[0][5] == board[2][3] &&
                board[0][5] == board[3][2] &&
                board[0][5] == board[4][1] &&
                board[0][5] == board[5][0] &&
                board[0][5] == COMPUTER
            ) {
                return true
            }

            // Check Line
            for (i in board.indices) {
                if (
                    board[i][0] == board[i][1] &&
                    board[i][0] == board[i][2] &&
                    board[i][0] == board[i][3] &&
                    board[i][0] == board[i][4] &&
                    board[i][0] == board[i][5] &&
                    board[i][0] == COMPUTER ||
                    board[0][i] == board[1][i] &&
                    board[0][i] == board[2][i] &&
                    board[0][i] == board[3][i] &&
                    board[0][i] == board[4][i] &&
                    board[0][i] == board[5][i] &&
                    board[0][i] == COMPUTER
                ) {
                    return true
                }
            }
        }

        return false
    }

    fun hasPlayerWon(): Boolean {
        if (cellsNumber == 3) {
            // Check Cross
            if (board[0][0] == board[1][1] &&
                board[0][0] == board[2][2] &&
                board[0][0] == PLAYER ||
                board[0][2] == board[1][1] &&
                board[0][2] == board[2][0] &&
                board[0][2] == PLAYER
            ) {
                return true
            }

            // Check Line
            for (i in board.indices) {
                if (
                    board[i][0] == board[i][1] &&
                    board[i][0] == board[i][2] &&
                    board[i][0] == PLAYER ||
                    board[0][i] == board[1][i] &&
                    board[0][i] == board[2][i] &&
                    board[0][i] == PLAYER
                ) {
                    return true
                }
            }
        } else if (cellsNumber == 4) {
            // Check Cross
            if (board[0][0] == board[1][1] &&
                board[0][0] == board[2][2] &&
                board[0][0] == board[3][3] &&
                board[0][0] == PLAYER ||
                board[0][3] == board[1][2] &&
                board[0][3] == board[2][1] &&
                board[0][3] == board[3][0] &&
                board[0][3] == PLAYER
            ) {
                return true
            }

            // Check Line
            for (i in board.indices) {
                if (
                    board[i][0] == board[i][1] &&
                    board[i][0] == board[i][2] &&
                    board[i][0] == board[i][3] &&
                    board[i][0] == PLAYER ||
                    board[0][i] == board[1][i] &&
                    board[0][i] == board[2][i] &&
                    board[0][i] == board[3][i] &&
                    board[0][i] == PLAYER
                ) {
                    return true
                }
            }
        } else if (cellsNumber == 5) {
            // Check Cross
            if (board[0][0] == board[1][1] &&
                board[0][0] == board[2][2] &&
                board[0][0] == board[3][3] &&
                board[0][0] == board[4][4] &&
                board[0][0] == PLAYER ||
                board[0][4] == board[1][3] &&
                board[0][4] == board[2][2] &&
                board[0][4] == board[3][1] &&
                board[0][4] == board[4][0] &&
                board[0][4] == PLAYER
            ) {
                return true
            }

            // Check Line
            for (i in board.indices) {
                if (
                    board[i][0] == board[i][1] &&
                    board[i][0] == board[i][2] &&
                    board[i][0] == board[i][3] &&
                    board[i][0] == board[i][4] &&
                    board[i][0] == PLAYER ||
                    board[0][i] == board[1][i] &&
                    board[0][i] == board[2][i] &&
                    board[0][i] == board[3][i] &&
                    board[0][i] == board[4][i] &&
                    board[0][i] == PLAYER
                ) {
                    return true
                }
            }
        } else if (cellsNumber == 6) {
            // Check Cross
            if (board[0][0] == board[1][1] &&
                board[0][0] == board[2][2] &&
                board[0][0] == board[3][3] &&
                board[0][0] == board[4][4] &&
                board[0][0] == board[5][5] &&
                board[0][0] == PLAYER ||
                board[0][5] == board[1][4] &&
                board[0][5] == board[2][3] &&
                board[0][5] == board[3][2] &&
                board[0][5] == board[4][1] &&
                board[0][5] == board[5][0] &&
                board[0][5] == PLAYER
            ) {
                return true
            }

            // Check Line
            for (i in board.indices) {
                if (
                    board[i][0] == board[i][1] &&
                    board[i][0] == board[i][2] &&
                    board[i][0] == board[i][3] &&
                    board[i][0] == board[i][4] &&
                    board[i][0] == board[i][5] &&
                    board[i][0] == PLAYER ||
                    board[0][i] == board[1][i] &&
                    board[0][i] == board[2][i] &&
                    board[0][i] == board[3][i] &&
                    board[0][i] == board[4][i] &&
                    board[0][i] == board[5][i] &&
                    board[0][i] == PLAYER
                ) {
                    return true
                }
            }
        }

        return false
    }


    //in this var we will store the computersMove
    var computersMove: Cell? = null

    fun computerCalMove() {
        if (availableCells.isNotEmpty()) {
            computersMove = availableCells.random()
        }
    }

    //this is our minimax function to calculate
    //the best move for the computer
    fun minimax(depth: Int, player: String): Int {
        if (hasComputerWon()) return +1
        if (hasPlayerWon()) return -1

        if (availableCells.isEmpty()) return 0

        var min = Integer.MAX_VALUE
        var max = Integer.MIN_VALUE

        for (i in availableCells.indices) {
            val cell = availableCells[i]
            if (player == COMPUTER) {
                placeMove(cell, COMPUTER)
                val currentScore = minimax(depth + 1, PLAYER)
                max = Math.max(currentScore, max)

                if (currentScore >= 0) {
                    if (depth == 0) {
                        computersMove = cell
                        break
                    }
                }

                if (currentScore == 1) {
                    board[cell.i][cell.j] = ""
                    break
                }

                if (i == availableCells.size - 1 && max < 0) {
                    if (depth == 0) {
                        computersMove = cell
                    }
                }

            } else if (player == PLAYER) {
                placeMove(cell, PLAYER)
                val currentScore = minimax(depth + 1, COMPUTER)
                min = Math.min(currentScore, min)

                if (min == -1) {
                    board[cell.i][cell.j] = ""
                    break
                }
            }
            board[cell.i][cell.j] = ""
        }

        return if (player == COMPUTER) max else min
    }

    //this function is placing a move in the given cell
    fun placeMove(cell: Cell, player: String) {
        board[cell.i][cell.j] = player
    }

}