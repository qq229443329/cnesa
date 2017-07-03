package com.cnesa.asset;

import com.cnesa.asset.dao.AssetDao;
import com.cnesa.asset.entity.Asset;
import com.cnesa.asset.model.AssetModel;
import com.cnesa.asset.service.AssetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shangpeibao on 16/12/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring-config.xml"})
public class AssetTest {

    @Resource
    private AssetDao assetDao;

    @Autowired
    private AssetService assetService;

    @Test
    public void testSelectAssetAndAssetDetails(){
        List<AssetModel> list = assetDao.selectAssetAndAssetDetails("064add10-2443-44e0-8589-6fd46884f113");
        for (AssetModel a : list) {
            System.out.println(a.getAssetname());
        }
    }

    @Test
    public void testFindByProjectIdAndDisplay() {
        List<AssetModel> assets = assetService.selectByProjectIdAndDisplay("14f037f6-c2ae-11e6-b138-fe26c35f90b6");
        for (Asset a : assets) {
            System.out.println(a.getAssetname());
        }
    }
}
