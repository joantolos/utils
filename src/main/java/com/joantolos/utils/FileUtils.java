package com.joantolos.utils;

import com.joantolos.utils.exception.FileManipulationException;

import java.io.*;

/**
 *
 * Created by jtolos on 13/01/2015.
 */
public interface FileUtils {

    InputStream byteArrayToInputStream(byte[] byteArray);

    void closeInputStream(InputStream is) throws FileManipulationException;

    void closeBufferedReader(BufferedReader br) throws FileManipulationException;

    String streamToString(InputStream inputStream) throws FileManipulationException;

    byte[] streamToByteArray(InputStream inputStream) throws FileManipulationException;

    void writeFile(byte[] byteArray, String outputPath) throws FileManipulationException;

    void writeFile(InputStream inputStream, String outputPath) throws FileManipulationException;

    void deleteFile(String path);

    boolean fileExist(String path);

    InputStream stringToInputStream(String inputStream) throws FileManipulationException;

    File byteArrayToFile(byte[] byteArray, String outputPath) throws FileManipulationException;
}
