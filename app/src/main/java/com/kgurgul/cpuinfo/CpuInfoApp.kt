/*
 * Copyright 2017 KG Soft
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kgurgul.cpuinfo

import androidx.multidex.MultiDexApplication
import com.kgurgul.cpuinfo.appinitializers.AppInitializers
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import android.app.Application
import io.cobrowse.CobrowseIO

/**
  *Cobrowse.io
  */
  public class MainApplication extends Application {

    @Override
  public void onCreate() {
     super.onCreate()

     CobrowseIO.instance().license("3ozxPbe1ZeJF4g")
     CobrowseIO.instance().start(this)

/**
 * Base Application class for required initializations
 *
 * @author kgurgul
 */
@HiltAndroidApp
class CpuInfoApp : MultiDexApplication() {

    @Inject
    lateinit var initializers: AppInitializers

    override fun onCreate() {
        super.onCreate()
        initializers.init(this)
    }
}
