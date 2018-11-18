package com.bupt.se.homework.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: UploadFileAction
 * @Description: TODO
 * @Author: kwong
 * @Create: 2018/11/15 16:26
 **/

public class UploadFileAction extends ActionSupport {
    File upload;//上传的文件
    String uploadContentType;//上传的文件类型
    String uploadFileName; //上传的文件名

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName)
    {
        this.uploadFileName = uploadFileName;
    }

    public String execute()
    {
        System.out.println("FileName:"+this.getUploadFileName());
        System.out.println("ContentType:"+this.getUploadContentType());
        System.out.println("File:"+this.getUpload());

        //获取要保存文件夹的物理路径(绝对路径)
        String realPath= ServletActionContext.getServletContext().getRealPath("/upload");
        File file = new File(realPath);

        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
        if(!file.exists())
            file.mkdirs();

        try {
            //保存文件
            FileUtils.copyFile(upload, new File(file,uploadFileName));
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
}
