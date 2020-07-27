package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.ResourceMapper;
import com.aaa.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CZT
 * @date 2020/7/21 15:10
 */
@Service
public class ResourceService extends BaseService<Resource> {

    @Autowired
    private ResourceMapper resourceMapper;

}
