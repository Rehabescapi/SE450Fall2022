/*
 *
 *  * Copyright (c) 2022.
 *  * Vahid Alizadeh
 *  * Object-oriented Software Development
 *  * DePaul University
 *
 */

package DesignPatterns.FactoryMethod.mower;

abstract class MowerFactory {
    public abstract Mower getMowerType(String mowerType);
}