/*
 * Copyright (c) 2011 CONTRIBUTORS
 *
 * This file is licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tini.parser;

/**
 * <p>Request line.</p>
 *
 * @author Subbu Allamaraju
 */
public class RequestLine {
    private final String method;
    private final String uri;
    private final String version;

    public RequestLine(final String method, final String uri, final String version) {
        this.method = method;
        this.uri = uri;
        this.version = version;
    }

    /**
     * Returns name of the method.
     *
     * @return method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Returns request URI.
     *
     * @return request URI
     */
    public String getUri() {
        return uri;
    }

    /**
     * Returns protocol version.
     *
     * @return version
     */
    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return method + " " + uri + " " + version;
    }
}
