package com.example.demo.ejercicio20;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.Spring;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceLoaderUtils {
    
    private static IInputStreamReader isrr = (InputStream ri) -> {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(ri));
        return buffer.lines().collect(Collectors.joining("\n"));
    };

    private static IInputStreamReader isrrAnonym = new IInputStreamReader() {
        
        @Override
        public String read(InputStream ri) throws Exception{
            BufferedReader buffer = new BufferedReader(new InputStreamReader(ri));
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    };

    public static void loadTextResourceTest(Resource resource) throws Exception{
        String expectedText = "Lorem ipsum dolor sit amet, \n" 
        +"consectetur adipiscing elit, \n" 
        +"sed eiusmod tempor incidunt ut labore et dolore magna aliqua. \n\n"
        +"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        String readText = isrr.read(resource.getInputStream());

        assertEquals(expectedText, readText);

        log.info(readText);
    }

    public static void loadPropertiesTest(Resource resource) throws Exception{
        String expectedText = "certificatic.curso=Spring Framework 5\n"
        +"certificatic.instructor=oga\n"
        +"certificatic.description=My awesome spring course";

        String readTex = isrr.read(resource.getInputStream());

        assertEquals(expectedText, readTex);

        log.info(readTex);

        Properties properties = new Properties();
        properties.load(resource.getInputStream());

        assertEquals("oga", properties.getProperty("certificatic.instructor"));
    }

    public static void loadUrlTest(Resource resource) throws Exception{
        String expectedText = "Spring | Home";
        String readText = isrr.read(resource.getInputStream());

        Document document = Jsoup.parse(readText);
        assertEquals(expectedText, document.title());
    }

    public static void imageResourceCopyTest(Resource resource, String path) throws Exception{
        String expectedText = "logo.png";
        FileCopyUtils.copy(resource.getInputStream(), new FileOutputStream(new File(path, resource.getFilename())));

        Path copiedPath = Paths.get(path + resource.getFilename());
        assertTrue(Files.exists(copiedPath,LinkOption.NOFOLLOW_LINKS));
        assertEquals(expectedText, copiedPath.getFileName().toString());
    }

}
