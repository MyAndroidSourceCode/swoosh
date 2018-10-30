package com.seyha.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.seyha.swoosh.Model.Player
import com.seyha.swoosh.R
import com.seyha.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun leagueNextClicked(view:View) {

        if(player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "please select a league button", Toast.LENGTH_SHORT).show()
        }

    }

    fun mensLeaugeClicked(view: View) {
        womensLeagueBtn.isChecked = false
        coedLeaugeBtn.isChecked = false
        player.league = "mens"
    }

    fun womensLeagueClicked(view:View) {
        coedLeaugeBtn.isChecked = false
        mensLeagueBtn.isChecked = false
        player.league  = "womens"
    }

    fun coedLeagueClicked(view: View) {
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false
        player.league = "co-ed"
    }
}
