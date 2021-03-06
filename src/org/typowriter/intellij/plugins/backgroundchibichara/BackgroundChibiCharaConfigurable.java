package org.typowriter.intellij.plugins.backgroundchibichara;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class BackgroundChibiCharaConfigurable implements Configurable {
    private BackgroundChibiCharaApplicationSettings myBackgroundChibiApplicationSeetings;
    @Nullable
    private BackgroundChibiCharaSettingsForm form = null;

    BackgroundChibiCharaConfigurable(BackgroundChibiCharaApplicationSettings settings) {
        myBackgroundChibiApplicationSeetings = settings;
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "BackgroundChibiChara";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return getForm().getComponent();
    }

    @Override
    public boolean isModified() {
        return !myBackgroundChibiApplicationSeetings.getSettings().equals(getForm().getSettings());
    }

    @Override
    public void apply() throws ConfigurationException {
        myBackgroundChibiApplicationSeetings.updateSettings(getForm().getSettings());
    }

    @Override
    public void reset() {
        getForm().setSettings(myBackgroundChibiApplicationSeetings.getSettings());
    }

    @Override
    public void disposeUIResources() {
        form = null;
    }

    @NotNull
    public BackgroundChibiCharaSettingsForm getForm() {
        if (form == null) {
            form = new BackgroundChibiCharaSettingsForm();
        }
        return form;
    }
}
