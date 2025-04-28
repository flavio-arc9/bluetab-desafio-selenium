package core.utils;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber") 
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/java/resources/features/")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "core.utils, core.steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:build/reports/cucumber-reports.html")
public class Test {}