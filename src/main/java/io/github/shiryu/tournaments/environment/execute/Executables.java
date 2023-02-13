package io.github.shiryu.tournaments.environment.execute;

import com.google.common.collect.Lists;
import io.github.shiryu.tournaments.environment.TournamentEnvironment;
import io.github.shiryu.tournaments.environment.type.SenderType;
import io.github.shiryu.tournaments.environment.execute.annotation.Executation;
import lombok.experimental.UtilityClass;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
public class Executables {

    private final Map<String, Executable> EXECUTABLES = new HashMap<>();

    @Nullable
    public Executable find(@NotNull final String id){
        return EXECUTABLES.get(id);
    }

    public void register(@NotNull final Executable executable){
        final Executation executation = executable.getClass().getAnnotation(Executation.class);

        if (executation == null)
            throw new IllegalStateException("Every executable needs an Executation annotation!");

        EXECUTABLES.put(
                executation.id(),
                executable
        );
    }

    public void execute(@NotNull final Player player, @NotNull final String[] args){
        final TournamentEnvironment environment = setup(player, args, 1);
        final Executable executable = find(args[0]);

        if (executable == null)
            return;

        executable.execute(environment);
    }

    public void execute(@NotNull final CommandSender sender, @NotNull final String[] args){
        final TournamentEnvironment environment = setup(sender, args, 1);
        final Executable executable = find(args[0]);

        if (executable == null)
            return;

        executable.execute(environment);
    }

    public void execute(@NotNull final Player player, @NotNull final SenderType type, @NotNull final String[] args){
        final TournamentEnvironment environment = setup(player, args, 2);

        final Executable executable = find(args[0]);

        environment.setType(type);

        if (executable == null)
            return;

        executable.execute(environment);
    }

    @NotNull
    private TournamentEnvironment setup(@NotNull final CommandSender sender, @NotNull final String[] args, final int argIndex){
        final TournamentEnvironment environment = new TournamentEnvironment();

        if (sender instanceof Player)
            environment.setPlayer((Player)sender);

        environment.setSender(sender);
        environment.setArgs(getArgs(args, argIndex));

        return environment;
    }

    @NotNull
    private List<String> getArgs(@NotNull final String[] args, final int index){
        final List<String> list = Lists.newArrayList();

        for (int i = index; i < args.length; i++){
            final String arg = args[i];

            if (arg == null || arg.isEmpty())
                continue;

            list.add(arg);
        }

        return list;
    }

}
