package org.apache.poi.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Properties;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link PoiProperties}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 */
class PoiPropertiesTest {

    @Test
    void defaultValues() {
        PoiProperties props = new PoiProperties();
        assertThat(props.getSettings()).isNotNull();
        assertThat(props.getSettings()).isEmpty();
        assertThat(props.getTemplateLoaderPath()).containsExactly(PoiProperties.DEFAULT_TEMPLATE_LOADER_PATH);
        assertThat(props.isPreferFileSystemAccess()).isTrue();
        assertThat(props.isAutoCheck()).isFalse();
    }

    @Test
    void constants() {
        assertThat(PoiProperties.DEFAULT_TEMPLATE_LOADER_PATH).isEqualTo("classpath:/templates/");
        assertThat(PoiProperties.DEFAULT_PREFIX).isEmpty();
        assertThat(PoiProperties.DEFAULT_SUFFIX).isEqualTo(".httl");
    }

    @Test
    void setterGetter() {
        PoiProperties props = new PoiProperties();

        Properties settings = new Properties();
        settings.setProperty("key", "value");
        props.setSettings(settings);
        assertThat(props.getSettings()).containsEntry("key", "value");

        props.setTemplateLoaderPath("/templates/", "/other/");
        assertThat(props.getTemplateLoaderPath()).containsExactly("/templates/", "/other/");

        props.setPreferFileSystemAccess(false);
        assertThat(props.isPreferFileSystemAccess()).isFalse();

        props.setAutoCheck(true);
        assertThat(props.isAutoCheck()).isTrue();
    }
}
