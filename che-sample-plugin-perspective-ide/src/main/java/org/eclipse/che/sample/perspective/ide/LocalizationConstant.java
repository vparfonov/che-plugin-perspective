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

import com.google.gwt.i18n.client.Messages;

/** */
public interface LocalizationConstant extends Messages {

  @Key("navigation.view.title")
  @DefaultMessage("Navigation Panel")
  String navigationTitle();

  @Key("information.view.title")
  @DefaultMessage("Information Panel")
  String informationTitle();

  @Key("button.sayHello")
  @DefaultMessage("Say Hello")
  String sayHello();

  @Key("message.hello")
  @DefaultMessage("Hello!!!")
  String hello();

  @Key("project.perspective")
  @DefaultMessage("Project Perspective")
  String projectPerspective();

  @Key("custom.perspective")
  @DefaultMessage("Custom Perspective")
  String customPerspective();
}
