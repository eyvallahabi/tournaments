package io.github.shiryu.tournaments.util;

import io.github.shiryu.tournaments.TournamentPlugin;
import lombok.experimental.UtilityClass;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@UtilityClass
public class FileLoader {

    @NotNull
    public FileConfiguration loadMenu(@NotNull final String name){
        final Plugin plugin = TournamentPlugin.getInstance();

        File file = new File(plugin.getDataFolder().getAbsolutePath() + "/menus/" +  name + "/");

        if (!file.getParentFile().exists())
            file.getParentFile().mkdir();

        if (file.exists()){
            return YamlConfiguration.loadConfiguration(file);
        }

        copy(
                plugin.getResource("menus/" + name),
                file
        );

        return YamlConfiguration.loadConfiguration(file);
    }


    private void copy(@NotNull final InputStream inputStream, @NotNull final File file) {
        try (OutputStream out = new FileOutputStream(file)) {
            byte[] buf = new byte[1024];

            int len;
            while ((len = inputStream.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            inputStream.close();
        } catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
    }
}
