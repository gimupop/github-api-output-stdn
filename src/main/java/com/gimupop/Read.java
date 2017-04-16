package com.gimupop;

import com.gimupop.entity.Issue;

import java.util.List;

/**
 *  入力用インターフェース
 */
public interface Read {

    /**
     * Issuesの取得をする。
     *
     * @return Issues
     */
    List<Issue> getIssues(int getCount);

}
