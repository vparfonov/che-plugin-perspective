/*
 * Copyright (c) 2012-2017 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.sample.perspective.ide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import org.vectomatic.dom.svg.ui.SVGResource;

/** */
public interface CustomPerspectiveResources extends ClientBundle {

  /** Singleton instance. */
  CustomPerspectiveResources INSTANCE = GWT.create(CustomPerspectiveResources.class);

  /**
   * Declares an icon.
   *
   * @return the icon
   */
  @Source("icons/my.svg")
  SVGResource icon();
}
