package com.gimupop;

import com.gimupop.entity.Issue;

import java.util.List;

/**
 * 出力用インターフェース
 */
public interface Write {

    /**
     * Issuesの中からtitleとbodyを出力する。
     *
     * @param target
     * @param titleLength
     * @param bodyLength
     */
    void printTitleAndBodyFromIssues(List<Issue> target,int titleLength,int bodyLength);
}
