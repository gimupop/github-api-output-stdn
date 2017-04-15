package com.gimupop;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by yanagawa_keita on 2017/04/15.
 */
public abstract class AbstractWrite implements Write {

    protected String escapeTabAndLinefeed(String target){
        String escapeLinefeed = StringUtils.replace(target,"\r\n","\\\\n");
        return StringUtils.replace(escapeLinefeed,"\t","\\\\t");
    }


}
