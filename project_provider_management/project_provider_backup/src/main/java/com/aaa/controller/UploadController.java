package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author CZT
 * @date 2020/7/22 19:12
 * ftp
 */
@RestController
public class UploadController extends CommonController{

    @Autowired
    private UploadService uploadService;


    /**
     * ftp
     * @param file
     * @return
     */
    @PostMapping("/Test")
    public ResultData Test (@RequestBody MultipartFile file){
        Boolean upload = uploadService.upload(file);
        if (upload) {
            return uploadSuccess();
        }else {
            return uploadFalse();
        }
    }


    @Override
    public BaseService getBaseService() {
        return null;
    }
}
