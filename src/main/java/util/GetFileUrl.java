package util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class GetFileUrl {
    public static String get(MultipartFile file, String movName, HttpServletRequest request) throws IOException {
        String rootpath = request.getServletContext().getRealPath("")+"moviesImg\\"+movName+"\\";
        File folder = new File(rootpath);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
            System.out.println("创建文件夹");
        }
        String result = rootpath+file.getOriginalFilename();
        file.transferTo(new File(rootpath+file.getOriginalFilename()));
        return result;
    }
}
