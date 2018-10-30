package com.seyha.swoosh.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.seyha.swoosh.Model.Player
import com.seyha.swoosh.R
import com.seyha.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {

    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        if(savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onSkillBeginnerClicked(view:View) {
        slillBallerBtn.isChecked = false
        player.skill = "beginner"
    }

    fun onSkillBallerClicked(view:View) {
        skillBeginnerBtn.isChecked = false
        player.skill = "baller"
    }

    fun onSkillFinishClicked(view:View) {
        if(player.skill != "") {
            val searchLeagueActivity = Intent(this, FinishActivity::class.java)
            searchLeagueActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(searchLeagueActivity)
        } else {
            Toast.makeText(this, "please select a skill level.", Toast.LENGTH_SHORT).show()
        }
    }
}
