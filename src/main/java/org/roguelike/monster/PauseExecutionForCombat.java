package org.roguelike.monster;

import java.util.concurrent.TimeUnit;

public interface PauseExecutionForCombat {

    default void pauseExecution(){
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException ie){
            Thread.currentThread().interrupt();
        }
    }
}