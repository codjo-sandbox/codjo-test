/*
 * Team : AGF AM / OSI / SI / BO
 *
 * Copyright (c) 2001 AGF Asset Management.
 */
package net.codjo.test.common.fixture;
/**
 * Interface d�crivant les fixtures de test.
 */
public interface Fixture {
    public void doSetUp() throws Exception;


    public void doTearDown() throws Exception;
}
