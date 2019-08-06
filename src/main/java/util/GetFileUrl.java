package util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class GetFileUrl {
    public static String get(MultipartFile file, String movName, HttpServletRequest request) throws IOException {
        StringBuffer url = request.getRequestURL();
        String rootpathDatabase =url.delete(url.length() - request.getRequestURI().length(), url.length())
                .append(request.getServletContext().getContextPath())
                .append("/moviesImg/"+movName+"/")
                .toString();

        String rootpath =request.getServletContext().getRealPath("/static/")+"moviesImg/"+movName+"/";
        File folder = new File(rootpath);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
            System.out.println("创建文件夹");
        }
        String result = rootpathDatabase+file.getOriginalFilename();
        file.transferTo(new File(rootpath+file.getOriginalFilename()));
        return result;
    }
}
