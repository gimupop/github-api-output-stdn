package com.gimupop;

import org.apache.commons.lang3.StringUtils;

/**
 *
 */
abstract class AbstractWrite implements Write {

    String escapeTabAndLinefeed(String target){
        String escapeLinefeed = StringUtils.replace(target,"\r\n","\\\\n");
        return StringUtils.replace(escapeLinefeed,"\t","\\\\t");
    }


}
