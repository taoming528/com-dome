package com.qy.dome.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qy.dome.model.MerchantApply;
import com.qy.dome.mapper.MerchantApplyMapper;
import com.qy.dome.service.MerchantApplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文件名称: 服务商申请表 服务接口实现类
 * @author ltm
 */
@Service
@Transactional
public class MerchantApplyServiceImpl extends ServiceImpl<MerchantApplyMapper, MerchantApply> implements MerchantApplyService {

}
