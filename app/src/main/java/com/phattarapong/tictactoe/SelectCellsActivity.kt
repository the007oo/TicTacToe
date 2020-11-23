package com.phattarapong.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import com.phattarapong.tictactoe.MainActivity.Companion.ARG_CHOOSE_CELS
import kotlinx.android.synthetic.main.activity_select_cells.*

class SelectCellsActivity : AppCompatActivity() {

    private var chooseCellsAdapter: ChooseCellsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_cells)
        startBtn.setOnClickListener {
            val item = chooseCellsAdapter!!.getItem(spinner.selectedItemPosition)

            Intent(this, MainActivity::class.java).apply {
                putExtra(ARG_CHOOSE_CELS, item!!.second)
            }.run {
                startActivity(this)
            }
        }
        setUpSpiner()
    }

    private fun setUpSpiner() {
        val dataList: ArrayList<Pair<String, Int>> = arrayListOf()
        dataList.add(Pair("3x3", 3))
        dataList.add(Pair("4x4", 4))
        dataList.add(Pair("5x5", 5))
        dataList.add(Pair("6x6", 6))

        chooseCellsAdapter = ChooseCellsAdapter(this, dataList).also { adapter ->
            spinner.adapter = adapter
        }
    }
}