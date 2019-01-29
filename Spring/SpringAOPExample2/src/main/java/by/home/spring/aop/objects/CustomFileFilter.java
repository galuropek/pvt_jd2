package by.home.spring.aop.objects;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;

@Component
@Lazy
public class CustomFileFilter implements FilenameFilter {

    private String extension;

//    public CustomFileFilter() {
//    }

    public CustomFileFilter(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.toUpperCase().endsWith("." + extension.toUpperCase());
    }
}
