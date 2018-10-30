package com.seyha.swoosh.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.seyha.swoosh.R
import com.seyha.swoosh.Utilities.EXTRA_LEAGUE
import com.seyha.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)

        println(league)
    }

    fun onSkillBeginnerClicked(view:View) {
        slillBallerBtn.isChecked = false
        skill = "beginner"
    }

    fun onSkillBallerClicked(view:View) {
        skillBeginnerBtn.isChecked = false
        skill = "baller"
    }

    fun onSkillFinishClicked(view:View) {
        if(skill != "") {
            val searchLeagueActivity = Intent(this, FinishActivity::class.java)
            searchLeagueActivity.putExtra(EXTRA_LEAGUE, league)
            searchLeagueActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(searchLeagueActivity)
        } else {
            Toast.makeText(this, "please select a skill level.", Toast.LENGTH_SHORT).show()
        }
    }
}
