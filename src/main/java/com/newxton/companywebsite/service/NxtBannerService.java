package com.newxton.companywebsite.service;

import com.newxton.companywebsite.entity.NxtBanner;
import java.util.List;

/**
 * (NxtBanner)表服务接口
 *
 * @author makejava
 * @since 2020-08-26 09:15:28
 */
public interface NxtBannerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    NxtBanner queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<NxtBanner> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param nxtBanner 实例对象
     * @return 实例对象
     */
    NxtBanner insert(NxtBanner nxtBanner);

    /**
     * 修改数据
     *
     * @param nxtBanner 实例对象
     * @return 实例对象
     */
    NxtBanner update(NxtBanner nxtBanner);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}