package by.home.spring.aop.objects;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FileManager {

    public Set<String> getExtensionList(String folder) {

        File dir = new File(folder);

        Set<String> extList = new TreeSet<>();

        for (String fileName : dir.list()) {
            File file = new File(dir.getAbsolutePath() + "\\" + fileName);
            int i = fileName.lastIndexOf(".");
            if (file.isFile() && i != -1) {
                extList.add(fileName.substring(i + 1, fileName.length()).toLowerCase());
            }
        }
        return extList;
    }
}
