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

package org.tini.common;

import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

/**
 * @author Subbu Allamaraju
 */
public class ReadablePipeline {

    protected static final Logger logger = Logger.getLogger("org.tini.common");

    // Channel
    protected final AsynchronousSocketChannel channel;

    // Pending reads
    private final BlockingQueue<ReadableMessage> readablesQueue;

    public ReadablePipeline(final AsynchronousSocketChannel channel) {
        this.channel = channel;
        readablesQueue = new LinkedBlockingQueue<ReadableMessage>();
    }

    public void push(final ReadableMessage message) throws InterruptedException {
        readablesQueue.put(message);
    }

    public ReadableMessage peek() throws InterruptedException {
        return readablesQueue.peek();
    }

    public ReadableMessage take() throws InterruptedException {
        if(readablesQueue.peek() != null) {
            return readablesQueue.take();
        }
        else {
            return null;
        }
    }
}
