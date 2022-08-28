package com.Tech4dev.wmtapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var teamAscore: TextView
    private lateinit var teamBscore: TextView
    private lateinit var enterTeamAScore: EditText
    private lateinit var enterTeamBScore: EditText
    private lateinit var addScoreBtn: Button

    private var aScore = ""
    private var bScore = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addScoreBtn = findViewById(R.id.addScoreBtn)
        enterTeamAScore = findViewById(R.id.enterTeamAScore)
        enterTeamBScore = findViewById(R.id.enterTeamBScore)
        teamAscore = findViewById(R.id.teamAscore)
        teamBscore = findViewById(R.id.teamBscore)

        addScoreBtn.setOnClickListener{
            Toast.makeText(this,"Add score was clicked", Toast.LENGTH_LONG).show()

            aScore = enterTeamAScore.text.toString()
            bScore = enterTeamBScore.text.toString()

            teamAscore.text = "team A $aScore"
            teamBscore.text = "team B $bScore"

            if(aScore.isNullOrEmpty()){
                Toast.makeText(this, "Enter A Valid Number", Toast.LENGTH_LONG).show()
            }else if(bScore.isNullOrEmpty()){
                Toast.makeText(this, "Enter A Valid Number", Toast.LENGTH_LONG).show()
            }else {
                updateScoreboard()
                showWinnerPopup()
            }
        }
    }
    private fun updateScoreboard() {
        teamAscore.text = "Team A: $aScore"
        teamBscore.text = "Team B: $bScore"
    }

    private fun showWinnerPopup() {
        var msg = if (aScore.toInt() > bScore.toInt()) {
            "Team A is the Winner"
        } else {
            "Team B is the Winner"
        }

        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setMessage(msg)
            .setTitle("Who is the winner?")
            .setPositiveButton("Ok", null)
            .show()
    }
}

