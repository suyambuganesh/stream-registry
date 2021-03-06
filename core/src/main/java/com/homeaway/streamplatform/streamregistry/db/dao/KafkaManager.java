/* Copyright (c) 2018 Expedia Group.
 * All rights reserved.  http://www.homeaway.com

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.homeaway.streamplatform.streamregistry.db.dao;

import java.util.Collection;
import java.util.Properties;

import com.homeaway.streamplatform.streamregistry.exceptions.StreamCreationException;

// TODO need javadoc for KafkaManager (#107)
// TODO Need to consider merging this with StreamInfrastructureManager to keep it stream-platform agnostic. (#109)
public interface KafkaManager {
    /**
     * Creates topics in underlying implementation of KafkaManager provider.
     * @param topics topics to creates
     * @param partitions number of partitions for each of those topics
     * @param replicationFactor replicationFactor for each of those topics
     * @param topicConfig topic config to use for each of these topics
     * @param isNewStream whether or not this invocation results from existing or new stream in stream registry.
     * @throws StreamCreationException  when Stream could not be created in the underlying infrastructure for following reasons
     *      a) Input Configs and the existing configs does not match for a new Stream on-boarded to StreamRegistry,
     *      but already available in the infrastructure.
     */
    void upsertTopics(Collection<String> topics, int partitions, int replicationFactor, Properties topicConfig, boolean isNewStream)
            throws StreamCreationException;
}
