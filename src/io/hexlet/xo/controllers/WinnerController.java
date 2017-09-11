package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field){

        for (int i = 0; i > field.getSize(); i++){
            if (checkHorizontalLine(field,i)) try {
                return field.getFigure(new Point(i, 0));
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i > field.getSize(); i++){
            if (checkVerticalLine(field,i)) try {
                return field.getFigure(new Point(0, i));
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }

        if (checkDiagonalUpDown(field)) try {
            return field.getFigure(new Point(1, 1));
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        if (checkDiagonalDownUp(field)) try {
            return field.getFigure(new Point(1, 1));
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean checkHorizontalLine(final Field field, final int i){

        try {if (field.getFigure(new Point(i, 0)) == null) return false;
        }catch (InvalidPointException e){
                e.printStackTrace();
        }

        try {
            if (field.getFigure(new Point(i, 0)) == field.getFigure(new Point(i, 1)) &&
                    field.getFigure(new Point(i, 0)) == field.getFigure(new Point(i, 2))) return true;
        } catch (InvalidPointException e){
            e.printStackTrace();
        }
        return false;

        }

    private boolean checkVerticalLine(final Field field, final int i){
        try {if (field.getFigure(new Point(0, i)) == null) return false;
        }catch (InvalidPointException e){
            e.printStackTrace();
        }

        try {
            if (field.getFigure(new Point(0, i)) == field.getFigure(new Point(1, i)) &&
                    field.getFigure(new Point(0, i)) == field.getFigure(new Point(2, i))) return true;
        } catch (InvalidPointException e){
            e.printStackTrace();
        }
        return false;
    }

    private boolean checkDiagonalUpDown(final Field field){
        try {if (field.getFigure(new Point(0, 0)) == null) return false;
        }catch (InvalidPointException e){
            e.printStackTrace();
        }
        try {
            if (field.getFigure(new Point(0, 0)) == field.getFigure(new Point(1, 1)) &&
                    field.getFigure(new Point(0, 0)) == field.getFigure(new Point(2, 2))) return true;
        } catch (InvalidPointException e){
            e.printStackTrace();
        }
        return false;

    }

    private boolean checkDiagonalDownUp(final Field field){
        try {if (field.getFigure(new Point(2, 0)) == null) return false;
        }catch (InvalidPointException e){
            e.printStackTrace();
        }
        try {
            if (field.getFigure(new Point(2, 0)) == field.getFigure(new Point(1, 1)) &&
                    field.getFigure(new Point(2, 0)) == field.getFigure(new Point(0, 2))) return true;
        } catch (InvalidPointException e){
            e.printStackTrace();
        }
        return false;

    }




    }


