/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package vn.phongvu.android.nhanvienphongvu.listing

import vn.phongvu.android.nhanvienphongvu.listing.data.SearchResponse

/**
 * Implementation of a remote data source with static access to the data for easy testing.
 */
class FakeListingRepository : ListingRepository {
    override suspend fun searchAsync(query: String) : SearchResponse? {
        return null
    }

    override fun searchUseCallback(query: String, callback: (SearchResponse) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
