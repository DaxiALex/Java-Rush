package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Alex on 03.01.2017.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes  o)
    {


            if (o == ImageTypes.BMP)
            {
               return new BmpReader();
            }

            else if (o == ImageTypes.PNG)
            {
                return new PngReader();
            }

            else if (o == ImageTypes.JPG)
            {
                return new JpgReader();
            }

            else
            {
                throw new IllegalArgumentException("Неизвестный тип картинки");
            }



    }
}
