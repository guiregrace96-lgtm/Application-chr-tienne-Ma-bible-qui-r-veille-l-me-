package com.labiblequireveille.app

import android.app.Activity
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : Activity() {
    private val rose = Color.rgb(183, 110, 121)
    private val fond = Color.rgb(255, 248, 250)
    private val or = Color.rgb(184, 146, 75)
    private val encre = Color.rgb(66, 48, 55)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = fond
        window.navigationBarColor = fond
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        val page = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(20), dp(24), dp(20), dp(28))
            setBackgroundColor(fond)
        }
        page.addView(TextView(this).apply {
            text = "La Bible qui réveille l’âme"
            textSize = 25f
            setTextColor(rose)
            typeface = Typeface.create("sans-serif", Typeface.BOLD)
        })
        page.addView(TextView(this).apply {
            text = "Ta parole est une lampe à mes pieds. — Psaume 119:105"
            textSize = 14f
            setTextColor(encre)
            setPadding(0, dp(8), 0, dp(20))
        })

        section(page, "Ma Bible", "Lire la Bible hors ligne • Les traductions seront ajoutées selon leurs licences.")
        section(page, "Bible audio", "Écouter les textes bibliques hors ligne lorsque les fichiers audio autorisés seront intégrés.")
        section(page, "Thèmes bibliques", "Deux modes de consultation : thème par verset et thème par message.")
        section(page, "Prières et enseignements", "Retrouver des prières, exhortations et enseignements chrétiens.")
        section(page, "Cantiques spirituels", "Espace prévu pour les chants dont l’utilisation hors ligne est autorisée.")
        section(page, "Mes réglages", "Langues, rappels, silence nocturne et horaires de prière.")

        val note = TextView(this).apply {
            text = "Version de démarrage : les rubriques sont une structure d’interface. Les contenus, rappels en arrière-plan et blocages d’applications ne sont pas encore activés."
            textSize = 12f
            setTextColor(Color.DKGRAY)
            setPadding(dp(4), dp(18), dp(4), 0)
        }
        page.addView(note)
        val scroll = ScrollView(this).apply { addView(page) }
        setContentView(scroll)
    }

    private fun section(parent: LinearLayout, title: String, description: String) {
        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(16), dp(14), dp(16), dp(14))
            background = GradientDrawable().apply {
                setColor(Color.WHITE)
                cornerRadius = dp(16).toFloat()
                setStroke(dp(1), Color.rgb(242, 222, 228))
            }
        }
        card.addView(TextView(this).apply {
            text = title
            textSize = 18f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(rose)
        })
        card.addView(TextView(this).apply {
            text = description
            textSize = 13f
            setTextColor(encre)
            setPadding(0, dp(6), 0, 0)
        })
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.bottomMargin = dp(12)
        parent.addView(card, params)
    }

    private fun dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()
}
