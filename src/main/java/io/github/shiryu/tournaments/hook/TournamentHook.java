package io.github.shiryu.tournaments.hook;

public interface TournamentHook<T> {

    boolean check();

    void enable();

    T get();
}
