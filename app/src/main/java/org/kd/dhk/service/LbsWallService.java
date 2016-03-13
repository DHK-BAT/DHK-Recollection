package org.kd.dhk.service;

import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientErrorHandling;
import org.kd.dhk.model.DuowanImage;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;

/**
 * 代号:隐无为
 * 时间:2016/1/28
 * 用途：
 */
@Rest(rootUrl = "http://company.com/ajax/services", converters={ByteArrayHttpMessageConverter.class})
public interface LbsWallService extends RestClientErrorHandling {

   @Post("http://tu.duowan.com/m/meinv?offset=150&order=created&math=0.6211543285753578")
   DuowanImage getImageList();

}
