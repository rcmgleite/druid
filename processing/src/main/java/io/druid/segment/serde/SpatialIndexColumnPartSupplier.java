/*
 * Licensed to Metamarkets Group Inc. (Metamarkets) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Metamarkets licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.druid.segment.serde;

import com.google.common.base.Supplier;
import com.metamx.collections.spatial.ImmutableRTree;
import io.druid.segment.column.SpatialIndex;

/**
 */
public class SpatialIndexColumnPartSupplier implements Supplier<SpatialIndex>
{
  private final ImmutableRTree indexedTree;

  public SpatialIndexColumnPartSupplier(
      ImmutableRTree indexedTree
  )
  {
    this.indexedTree = indexedTree;
  }

  @Override
  public SpatialIndex get()
  {
    return new SpatialIndex()
    {
      @Override
      public ImmutableRTree getRTree()
      {
        return indexedTree;
      }
    };
  }
}
