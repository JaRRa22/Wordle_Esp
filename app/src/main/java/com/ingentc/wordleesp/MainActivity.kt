package com.ingentc.wordleesp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ingentc.wordleesp.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.util.Locale
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private var palabraSelecionada = ""

    private val palabras = arrayListOf<String>()

    private var comprobarArray = 1

    private var puntos = 0

    private var puntosText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        readWordle()
        palabraSelecionada = palabras[Random.nextInt(0, palabras.size)]

        val espacio = " "
        puntosText = "${binding.puntos.text}$espacio"

        binding.back.setOnClickListener(this)
        binding.submit.setOnClickListener(this)
        binding.borrar.setOnClickListener(this)
        binding.A.setOnClickListener(this)
        binding.B.setOnClickListener(this)
        binding.C.setOnClickListener(this)
        binding.D.setOnClickListener(this)
        binding.E.setOnClickListener(this)
        binding.F.setOnClickListener(this)
        binding.G.setOnClickListener(this)
        binding.H.setOnClickListener(this)
        binding.I.setOnClickListener(this)
        binding.J.setOnClickListener(this)
        binding.K.setOnClickListener(this)
        binding.L.setOnClickListener(this)
        binding.M.setOnClickListener(this)
        binding.N.setOnClickListener(this)
        binding.NE.setOnClickListener(this)
        binding.O.setOnClickListener(this)
        binding.P.setOnClickListener(this)
        binding.Q.setOnClickListener(this)
        binding.r.setOnClickListener(this)
        binding.S.setOnClickListener(this)
        binding.T.setOnClickListener(this)
        binding.U.setOnClickListener(this)
        binding.V.setOnClickListener(this)
        binding.W.setOnClickListener(this)
        binding.X.setOnClickListener(this)
        binding.Y.setOnClickListener(this)
        binding.Z.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v){
            binding.back -> volverAInicio()
            binding.submit -> comprobarPalabra()
            binding.borrar -> borrar()
            binding.A -> pulsarLetra('A')
            binding.B -> pulsarLetra('B')
            binding.C -> pulsarLetra('C')
            binding.D -> pulsarLetra('D')
            binding.E -> pulsarLetra('E')
            binding.F -> pulsarLetra('F')
            binding.G -> pulsarLetra('G')
            binding.H -> pulsarLetra('H')
            binding.I -> pulsarLetra('I')
            binding.J -> pulsarLetra('J')
            binding.K -> pulsarLetra('K')
            binding.L -> pulsarLetra('L')
            binding.M -> pulsarLetra('M')
            binding.N -> pulsarLetra('N')
            binding.NE -> pulsarLetra('Ñ')
            binding.O -> pulsarLetra('O')
            binding.P -> pulsarLetra('P')
            binding.Q -> pulsarLetra('Q')
            binding.r -> pulsarLetra('R')
            binding.S -> pulsarLetra('S')
            binding.T -> pulsarLetra('T')
            binding.U -> pulsarLetra('U')
            binding.V -> pulsarLetra('V')
            binding.W -> pulsarLetra('W')
            binding.X -> pulsarLetra('X')
            binding.Y -> pulsarLetra('Y')
            binding.Z -> pulsarLetra('Z')
        }
    }

    private fun volverAInicio(){
        startActivity(Intent(this, PantallaInicioActivity :: class.java))
    }

    private fun comprobarPalabra(){
        when (comprobarArray){
            1 -> {
                val cadena: String = buildString {
                    append(binding.c1.text)
                    append(binding.c2.text)
                    append(binding.c3.text)
                    append(binding.c4.text)
                    append(binding.c5.text)
                }

                if (palabras.contains(cadena)){

                    if(cadena == palabraSelecionada){
                        subirPuntos()
                        borrarCasillas()
                        casillas()
                    }

                    else{

                        if(cadena[0] == palabraSelecionada[0]){
                            binding.c1.setTextColor(Color.GREEN)
                            letraVerde(cadena[0])
                        }
                        else if (palabraSelecionada.contains(cadena[0])){
                            binding.c1.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[0])
                        }
                        else {
                            comprobarLetra(cadena[0])
                        }

                        if(cadena[1] == palabraSelecionada[1]){
                            binding.c2.setTextColor(Color.GREEN)
                            letraVerde(cadena[1])
                        }
                        else if (palabraSelecionada.contains(cadena[1])){
                            binding.c2.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[1])
                        }
                        else {
                            comprobarLetra(cadena[1])
                        }

                        if(cadena[2] == palabraSelecionada[2]){
                            binding.c3.setTextColor(Color.GREEN)
                            letraVerde(cadena[2])
                        }
                        else if (palabraSelecionada.contains(cadena[2])){
                            binding.c3.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[2])
                        }
                        else {
                            comprobarLetra(cadena[2])
                        }

                        if(cadena[3] == palabraSelecionada[3]){
                            binding.c4.setTextColor(Color.GREEN)
                            letraVerde(cadena[3])
                        }
                        else if (palabraSelecionada.contains(cadena[3]) ){
                            binding.c4.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[3])
                        }
                        else {
                            comprobarLetra(cadena[3])
                        }

                        if(cadena[4] == palabraSelecionada[4]){
                            binding.c5.setTextColor(Color.GREEN)
                            letraVerde(cadena[4])
                        }
                        else if (palabraSelecionada.contains(cadena[4])){
                            binding.c5.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[4])
                        }
                        else {
                            comprobarLetra(cadena[4])
                        }

                        comprobarArray++
                    }
                }
            }
            2 -> {
                val cadena = buildString {
                    append(binding.c6.text)
                    append(binding.c7.text)
                    append(binding.c8.text)
                    append(binding.c9.text)
                    append(binding.c10.text)
                }

                if (palabras.contains(cadena)){

                    if(cadena == palabraSelecionada){
                        subirPuntos()
                        borrarCasillas()
                        casillas()
                    }

                    else{
                        if(cadena[0] == palabraSelecionada[0]){
                            binding.c6.setTextColor(Color.GREEN)
                            letraVerde(cadena[0])
                        }
                        else if (palabraSelecionada.contains(cadena[0])){
                            binding.c6.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[0])
                        }
                        else {
                            comprobarLetra(cadena[0])
                        }

                        if(cadena[1] == palabraSelecionada[1]){
                            binding.c7.setTextColor(Color.GREEN)
                            letraVerde(cadena[1])
                        }
                        else if (palabraSelecionada.contains(cadena[1])){
                            binding.c7.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[1])
                        }
                        else {
                            comprobarLetra(cadena[1])
                        }

                        if(cadena[2] == palabraSelecionada[2]){
                            binding.c8.setTextColor(Color.GREEN)
                            letraVerde(cadena[2])
                        }
                        else if (palabraSelecionada.contains(cadena[2])){
                            binding.c8.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[2])
                        }
                        else {
                            comprobarLetra(cadena[2])
                        }

                        if(cadena[3] == palabraSelecionada[3]){
                            binding.c9.setTextColor(Color.GREEN)
                            letraVerde(cadena[3])
                        }
                        else if (palabraSelecionada.contains(cadena[3])){
                            binding.c9.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[3])
                        }
                        else {
                            comprobarLetra(cadena[3])
                        }

                        if(cadena[4] == palabraSelecionada[4]){
                            binding.c10.setTextColor(Color.GREEN)
                            letraVerde(cadena[4])
                        }
                        else if (palabraSelecionada.contains(cadena[4])){
                            binding.c10.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[4])
                        }
                        else {
                            comprobarLetra(cadena[4])
                        }

                        comprobarArray++
                    }
                }
            }
            3 -> {
                val cadena = buildString {
                    append(binding.c11.text)
                    append(binding.c12.text)
                    append(binding.c13.text)
                    append(binding.c14.text)
                    append(binding.c15.text)
                }

                if (palabras.contains(cadena)){

                    if(cadena == palabraSelecionada){
                        subirPuntos()
                        borrarCasillas()
                        casillas()
                    }

                    else{
                        if(cadena[0] == palabraSelecionada[0]){
                            binding.c11.setTextColor(Color.GREEN)
                            letraVerde(cadena[0])
                        }
                        else if (palabraSelecionada.contains(cadena[0])){
                            binding.c11.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[0])
                        }
                        else {
                            comprobarLetra(cadena[0])
                        }

                        if(cadena[1] == palabraSelecionada[1]){
                            binding.c12.setTextColor(Color.GREEN)
                            letraVerde(cadena[1])
                        }
                        else if (palabraSelecionada.contains(cadena[1])){
                            binding.c12.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[1])
                        }
                        else {
                            comprobarLetra(cadena[1])
                        }

                        if(cadena[2] == palabraSelecionada[2]){
                            binding.c13.setTextColor(Color.GREEN)
                            letraVerde(cadena[2])
                        }
                        else if (palabraSelecionada.contains(cadena[2])){
                            binding.c13.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[2])
                        }
                        else {
                            comprobarLetra(cadena[2])
                        }

                        if(cadena[3] == palabraSelecionada[3]){
                            binding.c14.setTextColor(Color.GREEN)
                            letraVerde(cadena[3])
                        }
                        else if (palabraSelecionada.contains(cadena[3])){
                            binding.c14.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[3])
                        }
                        else {
                            comprobarLetra(cadena[3])
                        }

                        if(cadena[4] == palabraSelecionada[4]){
                            binding.c15.setTextColor(Color.GREEN)
                            letraVerde(cadena[4])
                        }
                        else if (palabraSelecionada.contains(cadena[4])){
                            binding.c15.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[4])
                        }
                        else {
                            comprobarLetra(cadena[4])
                        }

                        comprobarArray++
                    }
                }
            }
            4 -> {
                val cadena = buildString {
                    append(binding.c16.text)
                    append(binding.c17.text)
                    append(binding.c18.text)
                    append(binding.c19.text)
                    append(binding.c20.text)
                }

                if (palabras.contains(cadena)){

                    if(cadena == palabraSelecionada){
                        subirPuntos()
                        borrarCasillas()
                        casillas()
                    }

                    else{
                        if(cadena[0] == palabraSelecionada[0]){
                            binding.c16.setTextColor(Color.GREEN)
                            letraVerde(cadena[0])
                        }
                        else if (palabraSelecionada.contains(cadena[0])){
                            binding.c16.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[0])
                        }
                        else {
                            comprobarLetra(cadena[0])
                        }

                        if(cadena[1] == palabraSelecionada[1]){
                            binding.c17.setTextColor(Color.GREEN)
                            letraVerde(cadena[1])
                        }
                        else if (palabraSelecionada.contains(cadena[1])){
                            binding.c17.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[1])
                        }
                        else {
                            comprobarLetra(cadena[1])
                        }

                        if(cadena[2] == palabraSelecionada[2]){
                            binding.c18.setTextColor(Color.GREEN)
                            letraVerde(cadena[2])
                        }
                        else if (palabraSelecionada.contains(cadena[2])){
                            binding.c18.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[2])
                        }
                        else {
                            comprobarLetra(cadena[2])
                        }

                        if(cadena[3] == palabraSelecionada[3]){
                            binding.c19.setTextColor(Color.GREEN)
                            letraVerde(cadena[3])
                        }
                        else if (palabraSelecionada.contains(cadena[3])){
                            binding.c19.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[3])
                        }
                        else {
                            comprobarLetra(cadena[3])
                        }

                        if(cadena[4] == palabraSelecionada[4]){
                            binding.c20.setTextColor(Color.GREEN)
                            letraVerde(cadena[4])
                        }
                        else if (palabraSelecionada.contains(cadena[4])){
                            binding.c20.setTextColor(Color.YELLOW)
                            letraAmarilla(cadena[4])
                        }
                        else {
                            comprobarLetra(cadena[4])
                        }

                        comprobarArray++
                    }
                }
            }
            5 -> {
                val cadena = buildString {
                    append(binding.c21.text)
                    append(binding.c22.text)
                    append(binding.c23.text)
                    append(binding.c24.text)
                    append(binding.c25.text)
                }

                if (palabras.contains(cadena)){

                    if(cadena == palabraSelecionada){
                        subirPuntos()
                        borrarCasillas()
                        casillas()
                    }
                    else{
                        comprobarArray++
                        restarPuntos()
                        borrarCasillas()
                        casillas()
                    }
                }
            }
        }
    }

    private fun borrar(){
        when(comprobarArray){
            1 -> {
                if (binding.c5.text != ""){
                    binding.c5.text = ""
                }
                else if (binding.c4.text != ""){
                    binding.c4.text = ""
                }
                else if (binding.c3.text != ""){
                    binding.c3.text = ""
                }
                else if (binding.c2.text != ""){
                    binding.c2.text = ""
                }
                else if (binding.c1.text != ""){
                    binding.c1.text = ""
                }
            }
            2 -> {
                if (binding.c10.text != ""){
                    binding.c10.text = ""
                }
                else if (binding.c9.text != ""){
                    binding.c9.text = ""
                }
                else if (binding.c8.text != ""){
                    binding.c8.text = ""
                }
                else if (binding.c7.text != ""){
                    binding.c7.text = ""
                }
                else if (binding.c6.text != ""){
                    binding.c6.text = ""
                }
            }
            3 -> {
                if (binding.c15.text != ""){
                    binding.c15.text = ""
                }
                else if (binding.c14.text != ""){
                    binding.c14.text = ""
                }
                else if (binding.c13.text != ""){
                    binding.c13.text = ""
                }
                else if (binding.c12.text != ""){
                    binding.c12.text = ""
                }
                else if (binding.c11.text != ""){
                    binding.c11.text = ""
                }
            }
            4 -> {
                if (binding.c20.text != ""){
                    binding.c20.text = ""
                }
                else if (binding.c19.text != ""){
                    binding.c19.text = ""
                }
                else if (binding.c18.text != ""){
                    binding.c18.text = ""
                }
                else if (binding.c17.text != ""){
                    binding.c17.text = ""
                }
                else if (binding.c16.text != ""){
                    binding.c16.text = ""
                }
            }
            5 -> {
                if (binding.c25.text != ""){
                    binding.c25.text = ""
                }
                else if (binding.c24.text != ""){
                    binding.c24.text = ""
                }
                else if (binding.c23.text != ""){
                    binding.c23.text = ""
                }
                else if (binding.c22.text != ""){
                    binding.c22.text = ""
                }
                else if (binding.c21.text != ""){
                    binding.c21.text = ""
                }
            }
        }

    }

    private fun pulsarLetra(letra: Char){
        when(comprobarArray){
            1 -> {
                if (binding.c1.text == ""){
                    binding.c1.text = letra.toString()
                }
                else if (binding.c2.text == ""){
                    binding.c2.text = letra.toString()
                }
                else if (binding.c3.text == ""){
                    binding.c3.text = letra.toString()
                }
                else if (binding.c4.text == ""){
                    binding.c4.text = letra.toString()
                }
                else if (binding.c5.text == ""){
                    binding.c5.text = letra.toString()
                }
            }
            2 -> {
                if (binding.c6.text == ""){
                    binding.c6.text = letra.toString()
                }
                else if (binding.c7.text == ""){
                    binding.c7.text = letra.toString()
                }
                else if (binding.c8.text == ""){
                    binding.c8.text = letra.toString()
                }
                else if (binding.c9.text == ""){
                    binding.c9.text = letra.toString()
                }
                else if (binding.c10.text == ""){
                    binding.c10.text = letra.toString()
                }
            }
            3 -> {
                if (binding.c11.text == ""){
                    binding.c11.text = letra.toString()
                }
                else if (binding.c12.text == ""){
                    binding.c12.text = letra.toString()
                }
                else if (binding.c13.text == ""){
                    binding.c13.text = letra.toString()
                }
                else if (binding.c14.text == ""){
                    binding.c14.text = letra.toString()
                }
                else if (binding.c15.text == ""){
                    binding.c15.text = letra.toString()
                }
            }
            4 -> {
                if (binding.c16.text == ""){
                    binding.c16.text = letra.toString()
                }
                else if (binding.c17.text == ""){
                    binding.c17.text = letra.toString()
                }
                else if (binding.c18.text == ""){
                    binding.c18.text = letra.toString()
                }
                else if (binding.c19.text == ""){
                    binding.c19.text = letra.toString()
                }
                else if (binding.c20.text == ""){
                    binding.c20.text = letra.toString()
                }
            }
            5 -> {
                if (binding.c21.text == ""){
                    binding.c21.text = letra.toString()
                }
                else if (binding.c22.text == ""){
                    binding.c22.text = letra.toString()
                }
                else if (binding.c23.text == ""){
                    binding.c23.text = letra.toString()
                }
                else if (binding.c24.text == ""){
                    binding.c24.text = letra.toString()
                }
                else if (binding.c25.text == ""){
                    binding.c25.text = letra.toString()
                }
            }
        }
    }

    private fun readWordle(){
        val buffer = BufferedReader(assets.open("Wordle.txt").reader())

        var cadena = buffer.readLine()

        while (cadena != null){
            val datos: Array<String> = cadena.uppercase(Locale.getDefault()).split(",").toTypedArray()
            palabras.addAll(datos)
            cadena = buffer.readLine()
        }
        buffer.close()
    }

    private fun borrarCasillas(){
        binding.c1.text = ""
        binding.c1.setTextColor(Color.BLACK)
        binding.c2.text = ""
        binding.c2.setTextColor(Color.BLACK)
        binding.c3.text = ""
        binding.c3.setTextColor(Color.BLACK)
        binding.c4.text = ""
        binding.c4.setTextColor(Color.BLACK)
        binding.c5.text = ""
        binding.c5.setTextColor(Color.BLACK)
        binding.c6.text = ""
        binding.c6.setTextColor(Color.BLACK)
        binding.c7.text = ""
        binding.c7.setTextColor(Color.BLACK)
        binding.c8.text = ""
        binding.c8.setTextColor(Color.BLACK)
        binding.c9.text = ""
        binding.c9.setTextColor(Color.BLACK)
        binding.c10.text = ""
        binding.c10.setTextColor(Color.BLACK)
        binding.c11.text = ""
        binding.c11.setTextColor(Color.BLACK)
        binding.c12.text = ""
        binding.c12.setTextColor(Color.BLACK)
        binding.c13.text = ""
        binding.c13.setTextColor(Color.BLACK)
        binding.c14.text = ""
        binding.c14.setTextColor(Color.BLACK)
        binding.c15.text = ""
        binding.c15.setTextColor(Color.BLACK)
        binding.c16.text = ""
        binding.c16.setTextColor(Color.BLACK)
        binding.c17.text = ""
        binding.c17.setTextColor(Color.BLACK)
        binding.c18.text = ""
        binding.c18.setTextColor(Color.BLACK)
        binding.c19.text = ""
        binding.c19.setTextColor(Color.BLACK)
        binding.c20.text = ""
        binding.c20.setTextColor(Color.BLACK)
        binding.c21.text = ""
        binding.c21.setTextColor(Color.BLACK)
        binding.c22.text = ""
        binding.c22.setTextColor(Color.BLACK)
        binding.c23.text = ""
        binding.c23.setTextColor(Color.BLACK)
        binding.c24.text = ""
        binding.c24.setTextColor(Color.BLACK)
        binding.c25.text = ""
        binding.c25.setTextColor(Color.BLACK)
        comprobarArray = 1
        borrar()

        binding.ultimaPalabra.text = buildString {
        append(getString(R.string.ultima_palabra))
        append("\n")
        append(palabraSelecionada)
    }
        palabraSelecionada = palabras[Random.nextInt(0, palabras.size)]
    }

    private fun subirPuntos(){
        puntos++
        val resultado = "$puntosText$puntos"
        binding.puntos.text = resultado
    }

    private fun restarPuntos(){
        if(puntos > 0){
            puntos--
            val resultado = "$puntosText$puntos"
            binding.puntos.text = resultado
        }
    }

    private fun comprobarLetra(word: Char){
        val drawable: Drawable? = ContextCompat.getDrawable(binding.root.context, R.drawable.btn_gray)
        when(word){
            'A' -> binding.A.background = drawable
            'B' -> binding.B.background = drawable
            'C' -> binding.C.background = drawable
            'D' -> binding.D.background = drawable
            'E' -> binding.E.background = drawable
            'F' -> binding.F.background = drawable
            'G' -> binding.G.background = drawable
            'H' -> binding.H.background = drawable
            'I' -> binding.I.background = drawable
            'J' -> binding.J.background = drawable
            'K' -> binding.K.background = drawable
            'L' -> binding.L.background = drawable
            'M' -> binding.M.background = drawable
            'N' -> binding.N.background = drawable
            'Ñ' -> binding.NE.background = drawable
            'O' -> binding.O.background = drawable
            'P' -> binding.P.background = drawable
            'Q' -> binding.Q.background = drawable
            'R' -> binding.r.background = drawable
            'S' -> binding.S.background = drawable
            'T' -> binding.T.background = drawable
            'U' -> binding.U.background = drawable
            'V' -> binding.V.background = drawable
            'W' -> binding.W.background = drawable
            'X' -> binding.X.background = drawable
            'Y' -> binding.Y.background = drawable
            'Z' -> binding.Z.background = drawable
        }
    }
    private fun letraVerde(word: Char){
        val drawable: Drawable? = ContextCompat.getDrawable(binding.root.context, R.drawable.btn_green)
        when(word){
            'A' -> binding.A.background = drawable
            'B' -> binding.B.background = drawable
            'C' -> binding.C.background = drawable
            'D' -> binding.D.background = drawable
            'E' -> binding.E.background = drawable
            'F' -> binding.F.background = drawable
            'G' -> binding.G.background = drawable
            'H' -> binding.H.background = drawable
            'I' -> binding.I.background = drawable
            'J' -> binding.J.background = drawable
            'K' -> binding.K.background = drawable
            'L' -> binding.L.background = drawable
            'M' -> binding.M.background = drawable
            'N' -> binding.N.background = drawable
            'Ñ' -> binding.NE.background = drawable
            'O' -> binding.O.background = drawable
            'P' -> binding.P.background = drawable
            'Q' -> binding.Q.background = drawable
            'R' -> binding.r.background = drawable
            'S' -> binding.S.background = drawable
            'T' -> binding.T.background = drawable
            'U' -> binding.U.background = drawable
            'V' -> binding.V.background = drawable
            'W' -> binding.W.background = drawable
            'X' -> binding.X.background = drawable
            'Y' -> binding.Y.background = drawable
            'Z' -> binding.Z.background = drawable
        }
    }

    private fun letraAmarilla(word: Char){
        val drawable: Drawable? = ContextCompat.getDrawable(binding.root.context, R.drawable.btn_yellow)
        when(word){
            'A' -> binding.A.background = drawable
            'B' -> binding.B.background = drawable
            'C' -> binding.C.background = drawable
            'D' -> binding.D.background = drawable
            'E' -> binding.E.background = drawable
            'F' -> binding.F.background = drawable
            'G' -> binding.G.background = drawable
            'H' -> binding.H.background = drawable
            'I' -> binding.I.background = drawable
            'J' -> binding.J.background = drawable
            'K' -> binding.K.background = drawable
            'L' -> binding.L.background = drawable
            'M' -> binding.M.background = drawable
            'N' -> binding.N.background = drawable
            'Ñ' -> binding.NE.background = drawable
            'O' -> binding.O.background = drawable
            'P' -> binding.P.background = drawable
            'Q' -> binding.Q.background = drawable
            'R' -> binding.r.background = drawable
            'S' -> binding.S.background = drawable
            'T' -> binding.T.background = drawable
            'U' -> binding.U.background = drawable
            'V' -> binding.V.background = drawable
            'W' -> binding.W.background = drawable
            'X' -> binding.X.background = drawable
            'Y' -> binding.Y.background = drawable
            'Z' -> binding.Z.background = drawable
        }
    }

    private fun casillas(){
        val drawable: Drawable? = ContextCompat.getDrawable(binding.root.context, R.drawable.border_boton)
        binding.A.background = drawable
        binding.B.background = drawable
        binding.C.background = drawable
        binding.D.background = drawable
        binding.E.background = drawable
        binding.F.background = drawable
        binding.G.background = drawable
        binding.H.background = drawable
        binding.I.background = drawable
        binding.J.background = drawable
        binding.K.background = drawable
        binding.L.background = drawable
        binding.M.background = drawable
        binding.N.background = drawable
        binding.NE.background = drawable
        binding.O.background = drawable
        binding.P.background = drawable
        binding.Q.background = drawable
        binding.r.background = drawable
        binding.S.background = drawable
        binding.T.background = drawable
        binding.U.background = drawable
        binding.V.background = drawable
        binding.W.background = drawable
        binding.X.background = drawable
        binding.Y.background = drawable
        binding.Z.background = drawable
    }
}