package com.example.unittestsstudy

import org.junit.Assert
import org.junit.Test

/**
 * Testes Unitários (nao necessitam de device físico ou virtual)
 * Respeitar mesmo nível hierárquico da classe... por padão, use "NomeDaClasseTest"
 *
 *
 *
 * */

class CalculadoraTest {

    //instanciar classe original
    private val calculadora = Calculadora()

    //titulo da fun de teste deve explicar o que ele faz. Usar GIVEN, WHEN, THEN
    @Test
    fun `teste para validar soma de dois numeros`(){

        //GIVEN
        val a= 1
        val b= 2

        //WHEN
        val result = calculadora.sum(a,b)

        //THEN
        Assert.assertEquals(a+b,result)
    }

    @Test
    fun `teste para validar retorno true quando entrada for numero par`(){

        //GIVEN
        val num = 2

        //WHEN
        val resultado = calculadora.isEven(num)

        //THEN
        Assert.assertTrue(resultado)
    }

    @Test
    fun `teste para validar retorno false quando entrada nao for numero par`(){

        //GIVEN
        val num = 3

        //WHEN
        val resultado = calculadora.isEven(num)

        //THEN
        Assert.assertFalse(resultado)
    }

}