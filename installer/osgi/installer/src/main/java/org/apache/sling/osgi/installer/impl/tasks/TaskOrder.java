/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.osgi.installer.impl.tasks;

/** Define the basic ordering of tasks */
class TaskOrder {
	static final String CONFIG_UNINSTALL_ORDER = "10-";
	static final String CONFIG_INSTALL_ORDER = "20-";
	static final String BUNDLE_REMOVE_ORDER = "30-";
    static final String BUNDLE_UPDATE_ORDER = "40-";
	static final String BUNDLE_INSTALL_ORDER = "50-";
	static final String REFRESH_PACKAGES_ORDER = "60-";
	static final String BUNDLE_START_ORDER = "70-";
}
