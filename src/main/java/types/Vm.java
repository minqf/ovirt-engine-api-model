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

import java.util.Date;

@Type
public interface Vm extends VmBase {
    VmStatus status();
    String statusDetail();
    String stopReason();
    Date startTime();
    Date stopTime();
    Boolean runOnce();
    Payload[] payloads();

    VmPlacementPolicy placementPolicy();
    String fqdn();
    Boolean useLatestTemplateVersion();
    Boolean nextRunConfigurationExists();
    NumaTuneMode numaTuneMode();
    TimeZone guestTimeZone();
    GuestOperatingSystem guestOperatingSystem();

    @Link Host host();
    @Link Template template();

    /**
     * References to the original template the virtual machine was created from.
     *
     * If the virtual machine is cloned from a template or another virtual machine,
     * the `template` links to the Blank template and the `original_template`
     * is used to track history.
     *
     * Otherwise the `template` and `original_template` are the same.
     *
     * @author Marek Libra <mlibra@redhat.com>
     * @date 8 Jul 2016
     * @status added
     */
    @Link Template originalTemplate();

    @Link InstanceType instanceType();
    @Link Nic[] nics();
    @Link Snapshot[] snapshots();
    @Link Quota quota();
    @Link VmPool vmPool();
    @Link Cdrom[] cdroms();
    @Link Floppy[] floppies();
    @Link ReportedDevice[] reportedDevices();
    @Link Watchdog[] watchdogs();
    @Link Permission[] permissions();
    @Link ExternalHostProvider externalHostProvider();
    @Link AffinityLabel[] affinityLabels();
    @Link Application[] applications();
    @Link GraphicsConsole[] graphicsConsoles();
    @Link HostDevice[] hostDevices();
    @Link KatelloErratum[] katelloErrata();
    @Link NumaNode[] numaNodes();
    @Link Session[] sessions();
    @Link Statistic[] statistics();
    @Link Tag[] tags();

    /**
     * References to the disks attached to the virtual machine.
     */
    @Link DiskAttachment[] diskAttachments();
}