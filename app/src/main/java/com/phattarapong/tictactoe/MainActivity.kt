package com.phattarapong.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var cells: Int = 3
    private var boardCells = Array(cells) { arrayOfNulls<ImageView>(cells) }
    private var board = Board(cells)

    companion object {
        const val ARG_CHOOSE_CELS = "arg_choose_cells"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intent?.extras?.let {
            cells = it.getInt(ARG_CHOOSE_CELS)
        }

        setUpBoard()

        backBtn.setOnClickListener {
            onBackPressed()
        }

        restartBtn.setOnClickListener {
            //creating a new board instance
            //it will empty every cell
            board = Board(cells)

            //setting the result to empty
            resultTextView.text = ""

            //this function will map the internal board
            //to the visual board
            mapBoardToUi()
        }
    }

    private fun mapBoardToUi() {
        for (i in board.board.indices) {
            for (j in board.board.indices) {
                when (board.board[i][j]) {
                    Board.PLAYER -> {
                        boardCells[i][j]?.setImageResource(R.drawable.ic_o_symbol)
                        boardCells[i][j]?.isEnabled = false
                    }
                    Board.COMPUTER -> {
                        boardCells[i][j]?.setImageResource(R.drawable.ic_x_symbol)
                        boardCells[i][j]?.isEnabled = false
                    }
                    else -> {
                        boardCells[i][j]?.setImageResource(0)
                        boardCells[i][j]?.isEnabled = true
                    }
                }
            }
        }
    }

    private fun setUpBoard() {
        when (cells) {
            3 -> {
                boardLayout.rowCount = 3
                boardLayout.columnCount = 3
            }
            4 -> {
                boardLayout.rowCount = 4
                boardLayout.columnCount = 4
            }
            5 -> {

                boardLayout.rowCount = 5
                boardLayout.columnCount = 5
            }
            6 -> {
                boardLayout.rowCount = 6
                boardLayout.columnCount = 6
            }
            else -> {
                boardLayout.rowCount = 3
                boardLayout.columnCount = 3
            }
        }

        boardCells = Array(cells) { arrayOfNulls<ImageView>(cells) }
        board = Board(cells)

        for (i in boardCells.indices) {
            for (j in boardCells.indices) {
                boardCells[i][j] = ImageView(this)
                boardCells[i][j]?.layoutParams = GridLayout.LayoutParams().apply {
                    rowSpec = GridLayout.spec(i)
                    columnSpec = GridLayout.spec(j)
                    bottomMargin = 5
                    topMargin = 5
                    leftMargin = 5
                    rightMargin = 5

                    when (cells) {
                        3 -> {
                            width = 250
                            height = 250
                        }
                        4 -> {
                            width = 200
                            height = 200
                        }
                        5 -> {
                            width = 150
                            height = 150
                        }
                        6 -> {
                            width = 130
                            height = 130
                        }
                    }
                }
                boardCells[i][j]?.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.colorPrimary
                    )
                )

                //attached a click listener to the board
                boardCells[i][j]?.setOnClickListener(CellClickListener(i, j))

                boardLayout.addView(boardCells[i][j])
            }
        }
    }

    inner class CellClickListener(
        private val i: Int,
        private val j: Int
    ) : View.OnClickListener {

        override fun onClick(p0: View?) {

            //checking if the game is not over
            if (!board.isGameOver) {

                //creating a new cell with the clicked index
                val cell = Cell(i, j)

                //placing the move for player
                board.placeMove(cell, Board.PLAYER)

                //calling minimax to calculate the computers move
//                board.minimax(0, Board.COMPUTER)
                board.computerCalMove()

                //performing the move for computer
                board.computersMove?.let {
                    board.placeMove(it, Board.COMPUTER)
                }

                //mapping the internal board to visual board
                mapBoardToUi()
            }

            //Displaying the results
            //according to the game status
            when {
                board.hasComputerWon() -> resultTextView.text =
                    getString(R.string.text_computer_won)
                board.hasPlayerWon() -> resultTextView.text = getString(R.string.text_player_won)
                board.isGameOver -> resultTextView.text = getString(R.string.text_game_tied)
            }
        }
    }
}