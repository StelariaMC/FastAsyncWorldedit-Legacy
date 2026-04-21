package com.boydti.fawe.config;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FaweConfig {

    private static Yaml createYaml() {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setPrettyFlow(true);
        Representer representer = new Representer();
        representer.addClassTag(Settings.class, Tag.MAP);
        return new Yaml(new Constructor(Settings.class), representer, options);
    }

    @SuppressWarnings("unchecked")
    public static <T> T loadOrUpdate(Path file, Class<T> clazz, boolean update) {
        T config = null;
        if (Files.exists(file)) {
            try {
                String content = new String(Files.readAllBytes(file));
                content = content.replaceAll("!!com\\.boydti\\.fawe\\.config\\.Settings\\s*\n?", "");
                try (FileReader reader = new FileReader(file.toFile())) {
                    config = (T) createYaml().load(content);
                }
            } catch (Exception e) {
                config = null;
            }
        }

        if (config == null) {
            try {
                config = clazz.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                return null;
            }
        }

        if (update) {
            save(file, clazz, config);
        }
        return config;
    }

    public static <T> T update(Path file, Class<T> clazz) {
        return loadOrUpdate(file, clazz, true);
    }

    public static <T> void save(Path file, Class<T> clazz, T config) {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setPrettyFlow(true);
        Representer representer = new Representer();
        representer.addClassTag(Settings.class, Tag.MAP);
        Yaml yaml = new Yaml(new Constructor(Settings.class), representer, options);
        try (FileWriter writer = new FileWriter(file.toFile())) {
            yaml.dump(config, writer);
        } catch (IOException ignored) {}
    }
}