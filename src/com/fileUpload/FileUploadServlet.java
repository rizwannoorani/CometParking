package com.fileUpload;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;


import javax.servlet.http.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileUploadServlet extends HttpServlet{

   private static final long serialVersionUID = 1L;
  private StorageService storage = new StorageService();
  private static final int BUFFER_SIZE = 1024 * 1024;
  private static final Logger log = Logger.getLogger(FileUploadServlet.class.getName()); 
  @Override
   public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      log.info(this.getServletInfo()+" Servlets called....");
      resp.setContentType("text/plain");
      resp.getWriter().println("Now see here your file content, that you have uploaded on storage..");
      
      ServletFileUpload upload = new ServletFileUpload();
      FileItemIterator iter;
   try {
    iter = upload.getItemIterator(req);
     while (iter.hasNext()) {
            FileItemStream item = iter.next();
            String fileName = item.getName();
            String mime = item.getContentType();
            
            storage.init(fileName, mime);
            InputStream is = item.openStream();

             byte[] b = new byte[BUFFER_SIZE];
            int readBytes = is.read(b, 0, BUFFER_SIZE);
            while (readBytes != -1) {
                storage.storeFile(b, readBytes);
                readBytes = is.read(b, 0, readBytes);
            }

             is.close();
            storage.destroy();
            
       resp.getWriter().println("File uploading done");

             resp.getWriter().println("READ:" + storage.readTextFileOnly(fileName));
            
                         log.info(this.getServletName()+" ended....");            

      }
   } catch (FileUploadException e) {
    System.out.println("FileUploadException::"+e.getMessage());
    log.severe(this.getServletName()+":FileUploadException::"+e.getMessage());
    e.printStackTrace();
   } catch (Exception e) {
    log.severe(this.getServletName()+":Exception::"+e.getMessage());
    System.out.println("Exception::"+e.getMessage());
    e.printStackTrace();
   }
 }

}