package io.github.shiryu.tournaments.files.impl;

import io.github.shiryu.spider.configuration.annotation.Config;
import io.github.shiryu.spider.configuration.annotation.Value;
import io.github.shiryu.spider.configuration.base.BaseConfiguration;
import io.github.shiryu.tournaments.database.DatabaseType;

@Config(
        name = "settings.yml"
)
public class SettingsFile implements BaseConfiguration {

    @Value(path = "database.type")
    public DatabaseType DATABASE_TYPE = DatabaseType.SQLITE;

    @Value(path = "database.credentials.username")
    public String CREDENTIAL_USERNAME = "localhost";

    @Value(path = "database.credentials.password")
    public String CREDENTIAL_PASSWORD = "123";

    @Value(path = "database.credentials.host")
    public String CREDENTIAL_HOST = "localhost";

    @Value(path = "database.credentials.port")
    public int CREDENTIAL_PORT = 3336;

    @Value(path = "database.credentials.database")
    public String CREDENTIAL_DATABASE = "tournaments";

}
