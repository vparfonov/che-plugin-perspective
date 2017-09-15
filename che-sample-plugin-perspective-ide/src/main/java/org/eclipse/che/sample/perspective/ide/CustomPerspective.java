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

import static org.eclipse.che.ide.api.parts.PartStackType.EDITING;
import static org.eclipse.che.ide.api.parts.PartStackType.INFORMATION;
import static org.eclipse.che.ide.api.parts.PartStackType.NAVIGATION;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import javax.validation.constraints.NotNull;
import org.eclipse.che.ide.api.parts.PartStack;
import org.eclipse.che.ide.part.editor.multipart.EditorMultiPartStackPresenter;
import org.eclipse.che.ide.workspace.PartStackPresenterFactory;
import org.eclipse.che.ide.workspace.PartStackViewFactory;
import org.eclipse.che.ide.workspace.WorkBenchControllerFactory;
import org.eclipse.che.ide.workspace.perspectives.general.AbstractPerspective;
import org.eclipse.che.ide.workspace.perspectives.general.PerspectiveViewImpl;
import org.eclipse.che.providers.DynaProvider;

/** */
@Singleton
public class CustomPerspective extends AbstractPerspective {

  public static final String OPERATIONS_PERSPECTIVE_ID = "Operations Perspective";

  @Inject
  public CustomPerspective(
      PerspectiveViewImpl view,
      EditorMultiPartStackPresenter editorMultiPartStackPresenter,
      PartStackViewFactory partViewFactory,
      SamplePresenter samplePresenter,
      NavigationPresenter navigationPresenter,
      InformationPresenter informationPresenter,
      WorkBenchControllerFactory controllerFactory,
      PartStackPresenterFactory stackPresenterFactory,
      EventBus eventBus,
      DynaProvider dynaProvider) {
    super(
        OPERATIONS_PERSPECTIVE_ID,
        view,
        stackPresenterFactory,
        partViewFactory,
        controllerFactory,
        eventBus,
        dynaProvider);
    //central panel
    partStacks.put(EDITING, editorMultiPartStackPresenter);

    addPart(navigationPresenter, NAVIGATION);
    addPart(informationPresenter, INFORMATION);
  }

  @Override
  public String getPerspectiveId() {
    return OPERATIONS_PERSPECTIVE_ID;
  }

  @Override
  public String getPerspectiveName() {
    return OPERATIONS_PERSPECTIVE_ID;
  }

  /** {@inheritDoc} */
  @Override
  public void go(@NotNull AcceptsOneWidget container) {
    PartStack navigation = getPartStack(NAVIGATION);
    PartStack editing = getPartStack(EDITING);
    PartStack information = getPartStack(INFORMATION);

    if (navigation == null || editing == null) {
      return;
    }

    navigation.go(view.getNavigationPanel());
    editing.go(view.getEditorPanel());
    information.go(view.getInformationPanel());
    container.setWidget(view);
    openActivePart(EDITING);
    openActivePart(NAVIGATION);
  }
}
