/*
 * Copyright 2007 The Apache Software Foundation.
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
package org.apache.sling.launcher.servlet;

import java.util.Map;

import org.apache.sling.launcher.Logger;
import org.apache.sling.launcher.ResourceProvider;
import org.apache.sling.launcher.Sling;
import org.eclipse.equinox.http.servlet.internal.Activator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleException;

/**
 * The <code>SlingBridge</code> extends the base <code>Sling</code> class
 * calling the Eclipse Equinox Http Service activator for the proxy servlet to
 * be able to handle requests.
 */
public class SlingBridge extends Sling {

    // The Equinox Http Service activator
    private BundleActivator httpServiceActivator;

    public SlingBridge(Logger logger, ResourceProvider resourceProvider,
            Map<String, String> propOverwrite) throws BundleException {
        super(logger, resourceProvider, propOverwrite);
    }

    @Override
    protected void doStartBundle() throws Exception {
        // activate the HttpService
        httpServiceActivator = new Activator();
        httpServiceActivator.start(getBundleContext());
    }

    @Override
    protected void doStopBundle() {
        if (httpServiceActivator != null) {
            try {
                httpServiceActivator.stop(getBundleContext());
            } catch (Exception e) {
                // TODO :log but don't care
            }
            httpServiceActivator = null;
        }
    }
}
