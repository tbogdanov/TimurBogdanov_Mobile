package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static enums.Paths.DEFAULT_TEST_PROPERTY;
import static enums.Paths.MAIN_RESOURCES_PATH;


public class TestProperties {
    protected Properties currentProps = new Properties();
    protected String lastLoadedPropsFile = DEFAULT_TEST_PROPERTY.toString();

    protected Properties loadPropsFromFile(String propertyFileName) throws IOException {
        FileInputStream in = new FileInputStream(
                String.format("%s%s/%s", System.getProperty("user.dir"), MAIN_RESOURCES_PATH, propertyFileName));
        currentProps.load(in);
        in.close();
        lastLoadedPropsFile = propertyFileName;
        return currentProps;
    }

    protected String getProp(String propKey) throws IOException {
        if(!currentProps.containsKey(propKey)) currentProps = loadPropsFromFile(lastLoadedPropsFile);
        // DEFAULT_TEST_PROPERTY if props file not stated before
        return currentProps.getProperty(propKey, null);

    }

}