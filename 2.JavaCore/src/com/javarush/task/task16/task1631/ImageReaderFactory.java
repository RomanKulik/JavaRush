package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type){
        if (!(type instanceof ImageTypes))
            throw new IllegalArgumentException();

        if (type.equals(ImageTypes.BMP))
            return new BmpReader();
        if (type.equals(ImageTypes.JPG))
            return new JpgReader();
        return new PngReader();
    }
}

