package io.github.shiryu.tournaments.environment.control;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.github.shiryu.tournaments.environment.TournamentEnvironment;
import io.github.shiryu.tournaments.environment.control.annotation.Controllable;
import io.github.shiryu.tournaments.environment.execute.Executable;
import io.github.shiryu.tournaments.environment.type.SenderType;
import lombok.experimental.UtilityClass;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

@UtilityClass
public class Controllers {

    private final Map<String, Controller> CONTROLLERS = Maps.newHashMap();

    @Nullable
    public Controller find(@NotNull final String id){
        return CONTROLLERS.get(id);
    }

    public void register(@NotNull final Controller controller){
        final Controllable controllable = controller.getClass().getAnnotation(Controllable.class);

        if (controllable == null)
            throw new IllegalStateException("Every controller needs an Controllable annotation!");

        if (CONTROLLERS.containsKey(controllable.id()))
            throw new IllegalStateException("This controller already registered!");

        CONTROLLERS.put(
                controllable.id(),
                controller
        );
    }

    public boolean control(@NotNull final Player player, @NotNull final String[] args){
        final TournamentEnvironment environment = setup(player, args, 1);
        final Controller controller = find(args[0]);

        if (controller == null)
            return false;

        return controller.control(environment);
    }

    public boolean control(@NotNull final CommandSender sender, @NotNull final String[] args){
        final TournamentEnvironment environment = setup(sender, args, 1);
        final Controller controller = find(args[0]);

        if (controller == null)
            return false;

        return controller.control(environment);
    }

    public boolean control(@NotNull final Player player, @NotNull final SenderType type, @NotNull final String[] args){
        final TournamentEnvironment environment = setup(player, args, 2);

        final Controller controller = find(args[0]);

        environment.setType(type);

        if (controller == null)
            return false;

        return controller.control(environment);
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
