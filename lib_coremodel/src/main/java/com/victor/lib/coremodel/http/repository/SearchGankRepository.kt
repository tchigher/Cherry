package com.victor.lib.coremodel.http.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.victor.lib.coremodel.http.ApiService
import com.victor.lib.coremodel.http.datasource.GankDetailPagingSource
import com.victor.lib.coremodel.http.datasource.SearchGankPagingSource

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2018-2028, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: SearchGankRepository
 * Author: Victor
 * Date: 2020/7/8 下午 05:12
 * Description: 
 * -----------------------------------------------------------------
 */
class SearchGankRepository (
    val pageConfig: PagingConfig,
    private val requestApi: ApiService) : IRepository {
    override fun postsOfSubreddit(type: String,pageSize: Int) = Pager(
        config = pageConfig
    ) {
        SearchGankPagingSource(
            type = type,
            requestApi = requestApi
        )
    }.flow
}