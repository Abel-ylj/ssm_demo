package cn.ylj.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author : yanglujian
 * create at:  2021/1/10  2:11 下午
 */
@Controller
@ResponseBody
public class FileController {

    @RequestMapping("/fileUpload2")
    public void fileUpload2(HttpServletRequest req, HttpServletResponse resp,@RequestParam("file") MultipartFile file){
        String filename = file.getOriginalFilename();
        //获取项目地址
        String contextPath = req.getContextPath();
        contextPath = req.getServletContext().getRealPath(contextPath);
        File dir = new File(contextPath, "up_data");
        if (!dir.exists()){
            dir.mkdirs();
        }
        //写文件
        if (file != null){
            try {
                file.transferTo(new File(dir,  filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/fileUpload")
    public void fileUpload(HttpServletRequest req, HttpServletResponse resp,@RequestParam("file") MultipartFile file){
        String name = file.getOriginalFilename();
        String type = name.split("\\.")[1];
        //存储到本地
        String contextPath = req.getContextPath();
        contextPath = req.getServletContext().getRealPath(contextPath);
        File uf = new File(contextPath, "up_data");
        if (!uf.exists()){
            uf.mkdirs();
            File f = new File(uf, "ceshi.png");
            OutputStream fos = null;
            InputStream is = null;
            try{
                fos =   new BufferedOutputStream(new FileOutputStream(f));
                is = new BufferedInputStream(file.getInputStream());
                byte[] bys = new byte[1024];
                int len = 0;
                while ((len = is.read(bys)) > 0){
                    fos.write(bys, 0, len);
                }
                fos.flush();
            }catch (Exception e){

            }finally {
                if (fos != null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (is != null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}