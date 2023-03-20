package io.github.shiryu.tournaments.util;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@RequiredArgsConstructor
public class Replacer {

    private final Map<String, String> replace = new HashMap<>();

    public Replacer add(@NonNull final String key, @NonNull final String value){
        this.replace.put(key, value);

        return this;
    }

    public String replace(@NonNull final String string){
        final AtomicReference<String> returning = new AtomicReference<>(string);

        this.replace.forEach((key, value) ->
                returning.set(
                        returning.get()
                                .replace(key, value)
                )
        );

        return returning.get();
    }

}