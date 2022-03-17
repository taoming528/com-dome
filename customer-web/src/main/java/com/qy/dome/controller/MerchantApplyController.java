package com.qy.dome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qy.dome.common.enums.ResultCode;
import com.qy.dome.domain.BaseQuery;
import com.qy.dome.domain.BaseResult;
import com.qy.dome.domain.PageResult;
import com.qy.dome.model.MerchantApply;
import com.qy.dome.service.MerchantApplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 服务商申请表 前端控制器
 *
 * @author ltm
 */
@RestController
@RequestMapping("/merchantApply")
@Api(value = "服务商申请表接口", description = "用作服务商申请表演示")
public class MerchantApplyController extends BaseController<MerchantApply> {


    @Autowired
    private MerchantApplyService merchantApplyService;

    @Autowired
    private MessageSource messageSource;

    /**
     * 查询列表数据
     */
    @GetMapping("/list")
    @ApiOperation(value = "服务商申请表", notes = "获取服务商申请表列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query")
    })
    public PageResult list(@ApiIgnore BaseQuery baseQuery) {
        Page page = new Page(baseQuery.getCurrentPage(), baseQuery.getPageSize());
        Page pageList = merchantApplyService.page(page, new QueryWrapper<>());
        return PageResult.successResult(pageList.getTotal(),baseQuery.getCurrentPage(),baseQuery.getPageSize(),pageList.getRecords());
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "服务商申请表", notes = "获取服务商申请表详情信息")
    public BaseResult info(@PathVariable("id") Long id) {
        MerchantApply merchantApply = merchantApplyService.getById(id);
        return BaseResult.successResult(merchantApply);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "服务商申请表", notes = "保存服务商申请表信息")
    public BaseResult save(@RequestBody MerchantApply merchantApply) {
        boolean retFlag = merchantApplyService.save(merchantApply);
        if (!retFlag) {
            return BaseResult.failure(ResultCode.RESOURCE_ERROR);
        }
        return BaseResult.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "服务商申请表", notes = "更新服务商申请表信息")
    public BaseResult update(@RequestBody MerchantApply merchantApply) {
        boolean retFlag = merchantApplyService.updateById(merchantApply);
        if (!retFlag) {
            return BaseResult.failure(ResultCode.RESOURCE_ERROR);
        }
        return BaseResult.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "服务商申请表", notes = "删除服务商申请表信息")
    public BaseResult delete(@PathVariable("id") Long id) {
        boolean retFlag = merchantApplyService.removeById(id);
        if (!retFlag) {
            return BaseResult.failure(ResultCode.RESOURCE_ERROR);
        }
        return BaseResult.ok();
    }
}
