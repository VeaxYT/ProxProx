/*
 * Copyright (c) 2016, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.proxprox.api.scheduler;

import java.util.concurrent.TimeUnit;

/**
 * @author BlackyPaw
 * @author geNAZt
 * @version 1.1
 */
public interface Scheduler {

    /**
     * Run the runnable in another Thread
     *
     * @param runnable which should be executed
     * @return the created and scheduled Task
     */
    Task executeAsync( Runnable runnable );

    /**
     * Executes a runnable with a delay. It blocks the Thread for the time until the delay arrives
     *
     * @param runnable which should be executed
     * @param delay amount of timeUnit which should be used for waiting
     * @param timeUnit which should be used to multiply the delay
     * @return the created and scheduled Task
     */
    Task scheduleAsync( Runnable runnable, long delay, TimeUnit timeUnit );

    /**
     * Executes a runnable with a delay. It blocks the Thread for the time until the delay arrives. After the
     * execution of the Runnable it gets rescheduled again in an infinite Loop. You can cancel the returned Task
     * to stop that. It uses the same Thread over and over for rescheduling the Task.
     *
     * @param runnable which should be executed
     * @param delay amount of timeUnit which should be used for waiting
     * @param period amount of timeUnit which should be used for rescheduling the runnable
     * @param timeUnit which should be used to multiply the delay / period
     * @return the created and scheduled Task
     */
    Task scheduleAsync( Runnable runnable, long delay, long period, TimeUnit timeUnit );

    /**
     * Run the runnable on the next tick
     *
     * @param runnable which should be executed
     * @return the created and scheduled Task
     */
    Task executeSync( Runnable runnable );

    /**
     * Executes a runnable with a delay. It gets scheduled and execute against a internal ticker.
     *
     * @param runnable which should be executed
     * @param delay amount of timeUnit which should be used for waiting
     * @param timeUnit which should be used to multiply the delay
     * @return the created and scheduled Task
     */
    Task scheduleSync( Runnable runnable, long delay, TimeUnit timeUnit );

    /**
     * Executes a runnable with a delay. It gets scheduled and execute against a internal ticker. After the
     * execution of the Runnable it gets rescheduled again in an infinite Loop. You can cancel the returned Task
     * to stop that. It uses the same Thread over and over for rescheduling the Task.
     *
     * @param runnable which should be executed
     * @param delay amount of timeUnit which should be used for waiting
     * @param period amount of timeUnit which should be used for rescheduling the runnable
     * @param timeUnit which should be used to multiply the delay / period
     * @return the created and scheduled Task
     */
    Task scheduleSync( Runnable runnable, long delay, long period, TimeUnit timeUnit );
    
}
