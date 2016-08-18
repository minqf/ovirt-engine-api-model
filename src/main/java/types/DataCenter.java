/*
Copyright (c) 2015-2016 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package types;

import org.ovirt.api.metamodel.annotations.Link;
import org.ovirt.api.metamodel.annotations.Type;

@Type
public interface DataCenter extends Identified {
    Boolean local();
    StorageFormat storageFormat();
    Version version();
    Version[] supportedVersions();
    DataCenterStatus status();
    QuotaModeType quotaMode();

    /**
     * Reference to the MAC pool used by this data center.
     */
    @Link MacPool macPool();

    /**
     * Reference to storage domains attached to this data center.
     */
    @Link StorageDomain[] storageDomains();

    /**
     * Reference to clusters inside this data center.
     */
    @Link Cluster[] clusters();

    /**
     * Reference to networks attached to this data center.
     */
    @Link Network[] networks();

    /**
     * Reference to permissions assigned to this data center.
     */
    @Link Permission[] permissions();

    /**
     * Reference to quotas assigned to this datacenter.
     */
    @Link Quota[] quotas();

    /**
     * Reference to quality of service used by this data center.
     */
    @Link Qos[] qoss();

    /**
     * Reference to ISCSI bonds used by this data center.
     */
    @Link IscsiBond[] iscsiBonds();
}