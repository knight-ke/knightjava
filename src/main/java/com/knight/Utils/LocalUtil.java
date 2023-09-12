package com.knight.Utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * 描述: 3、国际化工具类
 * 版权: Copyright (c) 2020
 * 公司: XXXX
 * 作者: yanghj
 * 版本: 4.0
 * 创建日期: 2020/9/18 10:31
 */

@Component
public class LocalUtil
{

    private static MessageSource messageSource;

    public LocalUtil(MessageSource messageSource)
    {
        LocalUtil.messageSource = messageSource;
    }

    /**
     * 获取单个国际化翻译值
     */
    public static String get(String msgKey)
    {
        try
        {
            return messageSource.getMessage(msgKey, null, LocaleContextHolder.getLocale());
        }
        catch (Exception e)
        {
            return msgKey;
        }
    }
}
