package com.fileUpload;


import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;



import com.google.appengine.api.files.*;
import com.google.appengine.api.files.GSFileOptions.GSFileOptionsBuilder;
import java.io.*;
import java.nio.channels.Channels;
import java.util.logging.Logger;

public class StorageService {

public static final String BUCKET_NAME = "mybucket";  

private FileWriteChannel writeChannel = null;
FileService fileService = FileServiceFactory.getFileService();
private OutputStream os = null;
private static final Logger log = Logger.getLogger(StorageService.class.getName());

public void init(String fileName, String mime) throws Exception {
 System.out.println("Storage service:init() method:  file name:"+fileName+" and mime:"+mime);
 log.info("Storage service:init() method:  file name:"+fileName+" and mime:"+mime);
    
    GSFileOptionsBuilder builder = new GSFileOptionsBuilder()
            .setAcl("public_read")
            .setBucket(BUCKET_NAME)
            .setKey(fileName)
            .setMimeType(mime);
    AppEngineFile writableFile = fileService.createNewGSFile(builder.build());
    boolean lock = true;
    writeChannel = fileService.openWriteChannel(writableFile, lock);
    os = Channels.newOutputStream(writeChannel);
}

public void storeFile(byte[] b, int readSize) throws Exception { 
    os.write(b, 0, readSize);
    os.flush();
}



// Only to read uploaded text files

public String readTextFileOnly(String fileName) throws Exception{  
 log.info("Reading the txt file from google cloud storage...........");
 String filename = "/gs/" + BUCKET_NAME + "/" + fileName;
    AppEngineFile readableFile = new AppEngineFile(filename);
    FileReadChannel readChannel = fileService.openReadChannel(readableFile, false);
    BufferedReader reader = new BufferedReader(Channels.newReader(readChannel, "UTF8"));
    String line = reader.readLine();
    readChannel.close();
    return line;

}
public void destroy() throws Exception {
 log.info("Storage service: destroy() method");
    os.close();
    writeChannel.closeFinally();
}
}