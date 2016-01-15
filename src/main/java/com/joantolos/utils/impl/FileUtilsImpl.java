package com.joantolos.utils.impl;

import com.google.common.io.Files;
import com.joantolos.utils.FileUtils;
import com.joantolos.utils.enums.FileErrorCode;
import com.joantolos.utils.exception.FileManipulationException;
import org.apache.poi.util.IOUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Component
public class FileUtilsImpl implements FileUtils {

    public InputStream byteArrayToInputStream(byte[] byteArray){
        return new ByteArrayInputStream(byteArray);
    }
   
    public void closeInputStream(InputStream is) throws FileManipulationException {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                throw new FileManipulationException(FileErrorCode.CLOSING_INPUT_STREAM_ERROR);
            }
        }
    }

    public void closeBufferedReader(BufferedReader br) throws FileManipulationException {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                throw new FileManipulationException(FileErrorCode.CLOSING_BUFFERED_READER_ERROR);
            }
        }
    }

    public String streamToString(InputStream inputStream) throws FileManipulationException {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw new FileManipulationException(FileErrorCode.STRING_FROM_STREAM_ERROR);
        } finally {
            closeBufferedReader(br);
        }

        return sb.toString();
    }

    public byte[] streamToByteArray(InputStream inputStream) throws FileManipulationException {
        try {
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            throw new FileManipulationException(FileErrorCode.STRING_FROM_STREAM_ERROR);
        }
    }

    public void writeFile(byte[] byteArray, String outputPath) throws FileManipulationException{
        this.writeFile(this.byteArrayToInputStream(byteArray), outputPath);
    }

    public File byteArrayToFile(byte[] byteArray, String fileNameWithExtension) throws FileManipulationException{
        File resultFile;
        try {
            resultFile = File.createTempFile(fileNameWithExtension.split("\\.")[0], "."+fileNameWithExtension.split("\\.")[1]);
        
            Files.write(byteArray, resultFile);
        } catch (IOException e) {
            throw new FileManipulationException(FileErrorCode.WRITING_FILE_ERROR, e.getMessage());
        }

        return resultFile;
    }

    public void writeFile(InputStream inputStream, String outputPath) throws FileManipulationException {
        try{
            OutputStream outputStream = new FileOutputStream(new File(outputPath));

            int read;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            outputStream.close();
        }catch( IOException e){
            throw new FileManipulationException(FileErrorCode.WRITING_FILE_ERROR);
        }
    }

    public void deleteFile(String path) {
        if(this.fileExist(path)) {
            File file = new File(path);
            //noinspection ResultOfMethodCallIgnored
            file.delete();
        }
    }

    public boolean fileExist(String path) {
        File file = new File(path);
        return file.exists();
    }

    public InputStream stringToInputStream(String inputStream) throws FileManipulationException {
        return new ByteArrayInputStream(inputStream.getBytes(StandardCharsets.UTF_8));
    }
}
