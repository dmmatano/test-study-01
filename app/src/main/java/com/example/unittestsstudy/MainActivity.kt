package com.example.unittestsstudy

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.example.unittestsstudy.databinding.ActivityMainBinding
import kotlin.properties.Delegates

/*
Testes UI e Unitários
Teste UI:
- pasta androidTest
- testar interação do usuario (formularios, cliques, estados visiveis), flow, navigations.
Unit test:
- pasta test
- testar viewModel, presenters, data layers, repositories, domain, utility classes, etc.
- não testar library, framework, activities, fragments, services, classes sem "lógica de negócio"
@Before executa código antes de todos @Test e 0 @After executa depois.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val calculadora = Calculadora()
    private var number:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        updateNumberTextView(number)
        binding.increaseButton.setOnClickListener { increase() }
        binding.decreaseButton.setOnClickListener { decrease() }

    }

    private fun updateNumberTextView(value:Int?) {
        number = validateAndFixNumber(value)
        binding.numberTextView.text = (number?:0).toString()
        updateEvenTextView(number)
    }

    private fun updateEvenTextView(n:Int?) {
        if(calculadora.isEven(n?:0)){
            binding.evenTextView.text = "Even"
        }else{
            binding.evenTextView.text = "Odd"
        }
    }

    private fun increase(){
        val n = number?:0
        updateNumberTextView(n+1)
    }

    private fun decrease(){
        val n = number?:0
        updateNumberTextView(n-1)
    }

    private fun validateAndFixNumber(num:Int?): Int?{
        return if (num != null) {
            if((num > 1000000) || (num < 0)) 0 else num
        }else{
            num
        }
    }
}