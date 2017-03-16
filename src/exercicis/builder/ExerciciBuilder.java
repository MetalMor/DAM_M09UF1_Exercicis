/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicis.builder;

import exercicis.ex01.Ex01;
import exercicis.ex02.Ex02;
import exercicis.ex05.Ex05;
import exercicis.ex06.Ex06;
import exercicis.template.IExercici;

/**
 *
 * @author m0r
 */
public class ExerciciBuilder {
    private static String[] _args;
    
    public static IExercici make(int index) {
        switch(index) {
            case 1:
                return new Ex01();
            case 2:
                return new Ex02(getArgs());
            case 5:
                return new Ex05();
            case 6:
                return new Ex06();
            default:
                return null;
        }
    }
    
    public static String[] getArgs() {
        return _args;
    }
    
    public static void setArgs(String[] args) {
        _args = args;
    }
}
