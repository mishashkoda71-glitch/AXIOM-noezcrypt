
package com.axiom.noezcrypt

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : Activity() {

    private val backgroundColor = Color.rgb(10, 10, 13)
    private val redColor = Color.rgb(235, 45, 60)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = backgroundColor
        window.navigationBarColor = backgroundColor

        showWarning()
    }

    private fun createLayout(): LinearLayout {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(28, 32, 28, 32)
            setBackgroundColor(backgroundColor)
        }
    }

    private fun createText(
        value: String,
        size: Float,
        color: Int
    ): TextView {
        return TextView(this).apply {
            text = value
            textSize = size
            setTextColor(color)
            gravity = Gravity.CENTER
            setPadding(12, 18, 12, 18)
        }
    }

    private fun showWarning() {
        val layout = createLayout()

        layout.addView(
            createText("AXIOM // SECURITY", 14f, redColor)
        )

        layout.addView(
            createText("ВАС ЗАМЕТИЛИ", 32f, Color.WHITE)
        )

        layout.addView(
            createText(
                "Обнаружена подозрительная активность.\n\n" +
                "Это безопасная демонстрация системы.",
                16f,
                Color.LTGRAY
            )
        )

        val button = Button(this).apply {
            text = "НАЧАТЬ СИМУЛЯЦИЮ"
            setOnClickListener { showSimulation() }
        }

        layout.addView(button)
        setContentView(layout)
    }

    private fun showSimulation() {
        val layout = createLayout()

        layout.addView(
            createText("AXIOM ENCRYPT", 27f, redColor)
        )

        layout.addView(
            createText(
                "ИМИТАЦИЯ ШИФРОВАНИЯ",
                19f,
                Color.WHITE
            )
        )

        layout.addView(
            createText(
                "Проверка завершена.\n" +
                "Реальные файлы не изменялись.",
                16f,
                Color.LTGRAY
            )
        )

        val button = Button(this).apply {
            text = "ПРОДОЛЖИТЬ"
            setOnClickListener { showAccessScreen() }
        }

        layout.addView(button)
        setContentView(layout)
    }

    private fun showAccessScreen() {
        val layout = createLayout()

        layout.addView(
            createText("ACCESS CONTROL", 25f, redColor)
        )

        layout.addView(
            createText(
                "ДЕМОНСТРАЦИОННЫЙ ЭКРАН",
                16f,
                Color.WHITE
            )
        )

        val password = EditText(this).apply {
            hint = "Введите тестовый код"
            setHintTextColor(Color.GRAY)
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            inputType = 129
        }

        layout.addView(password)

        val button = Button(this).apply {
            text = "РАЗБЛОКИРОВАТЬ"
            setOnClickListener {
                if (password.text.toString() == "AXIOM-7429") {
                    Toast.makeText(
                        this@MainActivity,
                        "Доступ разрешён",
                        Toast.LENGTH_SHORT
                    ).show()
                    showWarning()
                } else {
                    password.error = "Неверный код"
                }
            }
        }

        layout.addView(button)

        val exit = Button(this).apply {
            text = "АВАРИЙНЫЙ ВЫХОД"
            setOnClickListener { finish() }
        }

        layout.addView(exit)
        setContentView(layout)
    }
}
