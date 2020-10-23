/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.serveur;

/**
 *
 * @author çpc
 */
public class ExprRegu {
    
    public static void main(String[] args) {
        String texto = "O java é uma linguagem orientada a Objetos";
        String[] novoTexto = texto.split(" ");
        for(String s: novoTexto) {
        System.out.println(s);
        }
    }
    
}
