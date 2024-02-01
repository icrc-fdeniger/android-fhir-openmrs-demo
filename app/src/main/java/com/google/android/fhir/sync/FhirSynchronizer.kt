/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.fhir.sync

import com.google.android.fhir.sync.download.Downloader
import com.google.android.fhir.sync.upload.Uploader
import org.hl7.fhir.r4.model.ResourceType
import java.time.OffsetDateTime

enum class SyncOperation {
  DOWNLOAD,
  UPLOAD,
}

private sealed class SyncResult {
  val timestamp: OffsetDateTime = OffsetDateTime.now()

  class Success : SyncResult()

  data class Error(val exceptions: List<ResourceSyncException>) : SyncResult()
}

data class ResourceSyncException(val resourceType: ResourceType, val exception: Exception)

internal data class UploadConfiguration(
  val uploader: Uploader,
)

internal class DownloadConfiguration(
  val downloader: Downloader,
  val conflictResolver: ConflictResolver,
)

